package cy.its.service.device.statusChecker.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataAccess.DbExecuter;
import cy.its.service.common.dataAccess.DiscardedDbError;
import cy.its.service.common.log.LogManager;
import cy.its.service.device.statusChecker.util.FileUtil;
import cy.its.service.device.statusChecker.util.Timer;

abstract class Updater<T> {

	List<T> statusList = new ArrayList<T>();

	private Object sync = new Object();

	Timer toDbTimer;

	boolean isStop = ConstValue.BOOL_FALSE;

	String sql;

	String optName;

	Class<T> clazz;

	String filePrefix;

	String directory;

	public Updater(String optName, String optEnName, Class<T> clazz) {
		this.optName = optName;
		this.filePrefix = optEnName;
		this.clazz = clazz;
		this.sql = getSql();
		this.directory = System.getProperty("user.dir") + java.io.File.separator + optEnName;
		FileUtil.createDirectory(directory);

		toDbTimer = new Timer(() -> {
			try {
				this.toDataBase1();
			} catch (Throwable e) {
				LogManager.error(this.optName + " ʧ��:" + StringUtil.getErrorDetail(e));
			}
		} , 5000, 5000);
		toDbTimer.start();
	}

	/**
	 * ����д����
	 * @param t
	 */
	public void write(T t) {
		synchronized (sync) {
			statusList.add(t);
		}
	}

	/**
	 * ֹͣ����
	 */
	public void close() {
		toDbTimer.stop();
		toDataBase1();
	}

	/**
	 * ���ݳ־û�����
	 */
	private void toDataBase1() {
		// ɨ���ļ�д�����ݿ�
		boolean isOk = fileToDB();
		if (isOk) {
			// �ļ��������
			// ����������д�����ݿ�, ʧ��д�������ļ�
			List<T> lstLeft = cacheToDB();

			if (lstLeft != null) {
				// ����д��ʧ�ܵĻ�������
				// �����ʧ�ܵ��Լ��ŵ�����δ��������д���ļ�
				cacheToFile(lstLeft);
			}
		} else {
			// ����δ������ɵ��ļ�
			// ���������ݰ�˳��洢���ļ���
			cacheToFile(null);
		}
	}

	/**
	 * ���浽�ļ�
	 * @param lstLeft
	 */
	private void cacheToFile(List<T> lstLeft) {
		try {
			String fileName = getFileName();
			File file = new File(fileName);
			if (lstLeft != null) {
				FileUtil.writeFile(lstLeft, file);
			}

			while (ConstValue.BOOL_TRUE) {
				lstLeft = readCache();
				if (lstLeft != null) {
					FileUtil.writeFile(lstLeft, file);
				} else {
					break;
				}
			}
		} catch (Throwable e) {
			LogManager.error(e);
		}
	}

	/**
	 * ���浽���ݿ�
	 * @return
	 */
	private List<T> cacheToDB() {
		// ���������ݴ洢����
		List<T> lstLeft = null; 
		while (ConstValue.BOOL_TRUE) {
			// ��ȡ����
			List<T> lst = readCache();
			if (lst != null) {
				// ��鲻�������ݴ洢�����Ƿ񴴽�
				if(lstLeft != null){
					// �Ѵ���: ����֮ǰ�Ѵ���δ���ɹ�������
					// ��������������������ݴ洢���ϣ���������⴦��
					lstLeft.addAll(lst);
					continue;
				}
				// д��
				writeDb(lst);
				// �ж��Ƿ�������δ�ɹ��ҵȴ��´���������
				if(lst.size() > ConstValue.INT_0) {
					// ���ڣ����������������ݴ洢����
					if(lstLeft == null){
						lstLeft = new ArrayList<T>();
					}
					lstLeft.addAll(lst);
				}
			} else {
				// �����������ݣ�ֹͣ����
				break;
			}
		}
		// ���ػ����ж�ȡ���ġ�δд�����ҵȴ��´δ�������ݼ���
		return lstLeft;
	}

	/**
	 * �ļ������ݿ�
	 * @return
	 */
	private boolean fileToDB() {
		// Ĭ�ϣ��ļ��������
		boolean isOk = ConstValue.BOOL_TRUE;
		try {
			// ɨ���ļ�
			List<File> lstFile = FileUtil.findFiles(directory,
					(f) -> f.isFile() && f.getName().startsWith(this.filePrefix));
			if (lstFile.size() > ConstValue.INT_0) {
				// �ļ�����������
				sortFiles(lstFile);				
				for (File file : lstFile) {
					// ��ȡ�ļ�
					List<T> lstT = FileUtil.readFile(file, clazz);
					if (lstT != null) {
						// �������
						writeDb(lstT);
						// �ж������Ƿ�ȫ�����
						if (lstT.size() == ConstValue.INT_0) {
							// ����ȫ�����
							// ɾ�����ݶ�Ӧ���ļ�
							FileUtil.deleteFile(file);
							// ���������¸��ļ�
							continue;
						} else {
							// ����δȫ�����
							// ɾ�����ļ�
							FileUtil.deleteFile(file);
							// ��δ�����������д��ͬ���ļ�ͬ�����ļ���
							FileUtil.writeFile(lstT, file);
						}
					}

					// �ļ�δ�������:�˳�����
					isOk = ConstValue.BOOL_FALSE;
					break;
				}
			}
		} catch (Throwable e) {
			LogManager.error(e);
			isOk = ConstValue.BOOL_FALSE;
		}

		return isOk;
	}

	/**
	 * �ļ�������
	 * @param lstFile
	 */
	private void sortFiles(List<File> lstFile) {
		lstFile.sort(new Comparator<File>() {
			@Override
			public int compare(File o1, File o2) {
				return Integer.valueOf(o1.getName().substring(filePrefix.length()))
						.compareTo(Integer.valueOf(o2.getName().substring(filePrefix.length())));
			}
		});
	}

	static String FMT1 = "%s ��������%d����¼�ɹ�, ��ʱ:%d����";
	static String FMT2 = "%s ��������%d����¼ʧ��, ��ʱ:%d����, ����Ϊ��������,  ԭ��:%s";
	
	/**
	 * ��⴦��
	 * @param lst
	 */
	private void writeDb(List<T> lst) {
		long t0 = System.currentTimeMillis();
		try {
			// ��¼�������
			DbExecuter.batchInsert(sql, lst.stream().map(t->getParamters(t)).collect(Collectors.toList()));
			LogManager.debug(String.format(FMT1, this.optName, lst.size(), System.currentTimeMillis() - t0));
			// �������ɹ�
			lst.clear();
		} catch (Throwable e) {
			// �������ʧ��
			LogManager.error(String.format(FMT2, this.optName, lst.size(),
					System.currentTimeMillis() - t0, StringUtil.getErrorDetail(e)));
			// ��Ϊ��������
			int size = lst.size();
			for (int i = ConstValue.INT_0; i < size; i++) {
				try {
					// ������⴦��
					DbExecuter.singleInsert(sql, getParamters(lst.get(ConstValue.INT_0)));
					// �������ɹ�
					lst.remove(ConstValue.INT_0);
				} catch (Throwable e2) {
					// ����������
					if (DiscardedDbError.isDiscardedDataErrorExcludeUniqueConstraint(e2)) {
						// ������ Ϊ �ɶ����Ĵ��󣺼�����һ������
						lst.remove(ConstValue.INT_0);
					} else {
						// ������ Ϊ ���ɶ����������������¼
						break;
					}
				}
			}
		}
	}

	/**
	 * �����ȡ����
	 * @return
	 */
	private List<T> readCache() {
		synchronized (sync) {
			if (statusList.size() > ConstValue.INT_0) {
				List<T> lst = new ArrayList<T>(statusList.size());
				lst.addAll(statusList);
				statusList.clear();
				return lst;
			}
		}

		return null;
	}

	/**
	 * �����ļ���
	 * @return
	 */
	private String getFileName() {
		return this.directory + java.io.File.separator + FileUtil.maxFileName(this.directory, this.filePrefix);
	}

	abstract String getSql();

	abstract List<Object> getParamters(T t);
}