package cy.its.service.data2db.BulkData;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.QueueHandler;
import cy.its.service.common.ConstValue;
import cy.its.service.common.SignalEvent;
import cy.its.service.common.StringUtil;
import cy.its.service.data2db.IMaker;
import cy.its.service.data2db.BulkData.Utils.BulkParam;
import cy.its.service.data2db.BulkData.Utils.FileUtil;
import cy.its.service.data2db.BulkData.Utils.InsertResult;

public abstract class BulkMaker implements IMaker {

	SignalEvent readEvent = new SignalEvent();
	SignalEvent writeEvent = new SignalEvent();
	SignalEvent stopEvent = new SignalEvent();
	boolean isStop = ConstValue.BOOL_FALSE;
	boolean canWrite = ConstValue.BOOL_TRUE;
	List<String> cache = new ArrayList<String>();
	boolean addedToCache;
	Future<String> toDbRunner;
	String directory;
	String filePrefix = "Pw";
	protected BulkParam param;
	int Index = 1;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	ExecutorService exec = Executors.newFixedThreadPool(1);

	public BulkMaker() {
		try {
			this.param = getBulkParam();
			cache = new ArrayList<String>(param.ReadMaxPeriod);
			directory = System.getProperty("user.dir") + java.io.File.separator + param.DataName;
			if(!FileUtil.createDirectory(directory)){
				LogManager.warn("����Ŀ¼ʧ��:" + this.directory);
			}
		} catch (Throwable e) {
			LogManager.error(param.DataName + "����ʼ�������쳣:" + StringUtil.getErrorDetail(e));
		}

		toDbRunner = exec.submit(() -> {
			return this.periodToDB();
		});
	}

	@Override
	public QueueHandler getQueueHandler() {
		return new QueueHandler(this.param.QueueName, true, false, this.param.RouteKey, this);
	}

	@Override
	public Boolean receive(String routingKey, String message) {
		try {
			if (isStop) {
				stopEvent.waitOne();
				return ConstValue.BOOL_FALSE;
			}

			if (!canWrite) {
				writeEvent.waitOne();
				if (isStop) {
					stopEvent.waitOne();
					return ConstValue.BOOL_FALSE;
				}
			}

			synchronized (cache) {
				addedToCache = ConstValue.BOOL_FALSE;
				if (cache.size() < param.CacheMaxSize) {
					cache.add(message);
					addedToCache = ConstValue.BOOL_TRUE;
				}

				if (cache.size() >= param.CacheMaxSize) {
					readEvent.set();
					canWrite = ConstValue.BOOL_FALSE;
				}

				return addedToCache;
			}
		} catch (Exception e) {
		}

		return ConstValue.BOOL_FALSE;
	}

	final static String MSG_FAIL = "%s������_ʧ��";

	private String periodToDB() {
		try {
			readEvent.set();
			List<String> lstCache = new ArrayList<String>(param.MaxBatchSize);
			InsertResult insertResult = new InsertResult(this.param.MaxBatchSize);
			while (!isStop) {
				readEvent.waitOne(param.ReadMaxPeriod);
				try {
					fileToDB(lstCache, insertResult);
					cacheToDB(lstCache, insertResult);
				} catch (Throwable e) {
					LogManager.error(String.format(MSG_FAIL, this.param.DataName));
				}
				lstCache.clear();
				insertResult.reset();
			}

			cacheToDB(lstCache, insertResult);
		} catch (Throwable e) {
			LogManager.error(e);
		}

		return "Stop to Db!";
	}

	final static String MSG_FILE_BEGIN = "%s������_��ʼ��ȡ�ļ����";
	final static String MSG_FILE_END = "%s������_��ɶ�ȡ�ļ����";
	final static String MSG_FILE_FAIL = "%s������_��ȡ�ļ����ʧ��, %s";

	private void fileToDB(List<String> lstCache, InsertResult insertResult) {
		List<File> lstFile = FileUtil.findFiles(directory,
				(f) -> f.isFile() && f.getName().startsWith(this.filePrefix));
		if (lstFile.size() > ConstValue.INT_0) {
			LogManager.info(String.format(MSG_FILE_BEGIN, this.param.DataName));
			for (File f : lstFile) {
				lstCache.clear();
				insertResult.reset();
				if (isStop) {
					break;
				}
				try {
					FileUtil.readFile(lstCache, f);
					if (lstCache.size() > ConstValue.INT_0) {
						batchInsert(lstCache, insertResult);
						if (insertResult.avaliableList.size() == ConstValue.INT_0) {
							// �����������ӡ�����δ������ԭ��δ��ȷ��������
							// ���ܴ��������ݸ�ʽ��ΨһԼ��������޷���������
							// ɾ�������ļ�
							FileUtil.deleteFile(f);
						} else if (insertResult.avaliableList.size() >= lstCache.size()) {
							// δ������ݺ����ǰ����һ��:��ɾ�������ļ�, �ȴ��´ζ�ȡ
							continue;
						} else {
							// ɾ�������ļ�
							FileUtil.deleteFile(f);
							// ��δ������������д�뻺��
							WriteToFile(insertResult.avaliableList);
						}
					}
				} catch (Throwable e) {
					LogManager.error(String.format(MSG_FILE_FAIL, this.param.DataName, StringUtil.getErrorDetail(e)));
				}
			}

			LogManager.info(String.format(MSG_FILE_END, this.param.DataName));
		}

		lstCache.clear();
		insertResult.reset();
	}

	final static String MSG_CACHE_BEGIN = "%s������_��ʼ��ȡ�������";
	final static String MSG_CACHE_END = "%s������_��ɶ�ȡ�������";
	final static String MSG_CACHE_FAIL = "%s������_��ȡ�������ʧ��, %s";

	private void cacheToDB(List<String> lstCache, InsertResult instRslt) {
		boolean logged = ConstValue.BOOL_FALSE;
		while (ConstValue.BOOL_TRUE) {
			try {
				lstCache.clear();
				instRslt.reset();
				synchronized (cache) {
					if (cache.size() == ConstValue.INT_0) {
						break;
					}
					if (!logged) {
						LogManager.info(String.format(MSG_CACHE_BEGIN, this.param.DataName));
						logged = ConstValue.BOOL_TRUE;
					}
					if (cache.size() <= param.MaxBatchSize) {
						lstCache.addAll(cache);
						cache.clear();
					} else {
						for (int i = ConstValue.INT_0; i < this.param.MaxBatchSize; i++) {
							lstCache.add(cache.remove(ConstValue.INT_0));
						}
					}

					canWrite = ConstValue.BOOL_TRUE;
					writeEvent.set();
				}

				batchInsert(lstCache, instRslt);
				if (instRslt.avaliableList.size() > ConstValue.INT_0) {
					WriteToFile(instRslt.avaliableList);
				}
			} catch (Throwable e) {
				LogManager.error(String.format(MSG_CACHE_FAIL, this.param.DataName, StringUtil.getErrorDetail(e)));
			}
		}

		lstCache.clear();
		instRslt.reset();

		if (logged) {
			LogManager.info(String.format(MSG_CACHE_END, this.param.DataName));
		}
	}

	private void WriteToFile(List<String> lstAvailable) {
		String fileName = directory + java.io.File.separator + filePrefix + sdf.format(new Date()) + (Index++);
		FileUtil.writeFile(lstAvailable, new File(fileName));
	}

	@Override
	public void close() {
		isStop = ConstValue.BOOL_TRUE;
		writeEvent.set();
		readEvent.set();
		stopEvent.set();

		try {
			toDbRunner.get();

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		try {
			exec.shutdown();
			exec.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<String> lstCache = new ArrayList<String>(param.MaxBatchSize);
		InsertResult insertResult = new InsertResult(this.param.MaxBatchSize);
		fileToDB(lstCache, insertResult);
		cacheToDB(lstCache, insertResult);
	}

	public abstract BulkParam getBulkParam();

	public abstract void batchInsert(List<String> infoList, InsertResult insertResult);
}
