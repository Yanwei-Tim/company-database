package cy.its.service.domain;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cy.its.platform.common.utils.ZipUtil;
import cy.its.service.util.DBUtil;

/**
 * @Title: OffLineTask.java
 * @Package cy.its.service.domain
 * @Description: ��������������
 * @author lil@cychina.cn
 * @date 2015��11��17�� ����8:24:39
 * @version V1.0
 */
public abstract class OffLineTask implements Runnable {

	// ϵͳ������
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");

	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public static Logger log = Logger.getLogger(OffLineTask.class);
	/**
	 * �����
	 */
	String taskId;
	/**
	 * sql
	 */
	String sql;

	/**
	 * fileName
	 */
	String fileName;

	/**
	 * loginName
	 */
	String loginName;

	// ZIP�ļ�����
	private File zipFileName;
	// �ļ�����ʱ��·��
	public String filePath;

	public OffLineTask(String taskId, String sql, String fileName, String loginName) {
		this.fileName = fileName;
		this.taskId = taskId;
		this.sql = sql;
		this.loginName = loginName;

		// ȷ������·���������ļ���ȡ
		String fileRoot = OffLineCache.getFilePath();
		filePath = fileRoot + FILE_SEPARATOR + df.format(new Date());
		// ��������
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
		// �����û���Ϣ
		filePath = filePath + FILE_SEPARATOR + loginName;
		File userFile = new File(filePath);
		if (!userFile.exists()) {
			userFile.mkdirs();
		}
		// ѹ���ļ�����
		zipFileName = new File(filePath + FILE_SEPARATOR + fileName + System.currentTimeMillis() + ".zip");
	}

	/**
	 * ����ʵ����
	 */
	@Override
	public void run() {
		Statement stmt = null;
		Connection conn = null;
		ResultSet rs = null;
		// ��ȡ����Դ��Ϣ
		try {
			conn = DBUtil.openConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			// �����ļ�
			createFile(rs, filePath);
			// ����״̬
			String fileUrl = zipFileName.getPath().replace("\\", "/");
			fileUrl = fileUrl.replace(OffLineCache.getFilePath(), "");
			fileUrl = "http://" + OffLineCache.getHttpIp() + fileUrl;
			updateTask(taskId, "4", fileUrl);
			// �ر�����
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			log.error(e.getStackTrace());

		} finally {
			try {
				if (stmt != null) {
					stmt.close();// �����쳣�ر�����
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				log.error(e.getStackTrace());
			}
		}

	}

	/**
	 * @Title: createFile @Description: ���ݻ�ȡ�����ݣ������ļ���Ȼ����ļ���ӵ�Ҫ���ļ��� @param @param
	 * rs @param @param filePath �趨�ļ� @return void �������� @throws
	 */
	public abstract void createFile(ResultSet rs, String filePath);

	/**
	 * @Title: zipUtil @Description: �ɴ������ļ�����ѹ�� @param @param
	 * file @param @return �趨�ļ� @return boolean �������� @throws
	 */
	public boolean zipFiles(List<File> list) {
		try {
			ZipUtil.zipFiles(list, zipFileName, true);
			for (File file : list) {
				file.delete();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * @Title: updateTask @Description: ���������״̬ @param @param
	 * taskId @param @param string �趨�ļ� @return void �������� @throws
	 */
	private void updateTask(String taskId, String status, String fileUrl) {
		String updateSql = "update T_SYS_EXPORT set  status = '" + status + "',file_url='" + fileUrl
				+ "' where task_id= '" + taskId + "'";
		DBUtil.updateData(updateSql);
	}
}
