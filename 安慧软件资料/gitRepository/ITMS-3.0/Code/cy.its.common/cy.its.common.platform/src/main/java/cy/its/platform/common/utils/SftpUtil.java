package cy.its.platform.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.Vector;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

/**
 * Created by IntelliJ IDEA. User: Administrator Date: 2011-6-30 Time: 9:10:23
 * To change this template use File | Settings | File Templates.
 */
public class SftpUtil {
	static String pathSeparator = (new Properties(System.getProperties())).getProperty("file.separator");
	private static Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(SftpUtil.class);

	static String sftp_host = "192.168.10.203";
	static int sftp_port = 22;
	static String sftp_userName = "root";
	static String sftp_password = "2016test";
	static String sftp_root = "/itms3/share/";
	static String sftp_server = "192.168.10.203/share/";
	static ChannelSftp sftp_Channel;

	private SftpUtil(String propertyPath) {
		try {
			OrderedProperties prop = new OrderedProperties();// ���Լ��϶���
			InputStream fis = new FileInputStream(propertyPath);
			prop.load(fis);// �������ļ���װ�ص�Properties������
			fis.close();// �ر���
			sftp_host = prop.getProperty("sftp.host").trim();
			sftp_port = Integer.valueOf(prop.getProperty("sftp.port").trim());
			sftp_userName = prop.getProperty("sftp.userName").trim();
			sftp_password = prop.getProperty("sftp.pwd").trim();
			sftp_root = prop.getProperty("sftp.root").trim();
			sftp_server = prop.getProperty("sftp.server").trim();
			sftp_Channel = connect();
		} catch (IOException e) {
			log.error("sftp��ʼ���쳣�����������ļ���");
			e.printStackTrace();
		}
	}

	/**
	 * ����sftp������
	 *
	 * @param host
	 *            ����
	 * @param port
	 *            �˿�
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return
	 */
	public static ChannelSftp connect() {
		if (sftp_Channel == null) {
			try {
				JSch jsch = new JSch();
				// jsch.getSession(username, host, port);
				Session sshSession = jsch.getSession(sftp_userName, sftp_host, sftp_port);
				sshSession.setPassword(sftp_password);
				Properties sshConfig = new Properties();
				sshConfig.put("StrictHostKeyChecking", "no");
				sshSession.setConfig(sshConfig);
				sshSession.connect();
				Channel channel = sshSession.openChannel("sftp");
				channel.connect();
				sftp_Channel = (ChannelSftp) channel;

				Field f = ChannelSftp.class.getDeclaredField("server_version");
				f.setAccessible(true);
				f.set(sftp_Channel, 2);
				String systemEncoding = System.getProperty("file.encoding");
				sftp_Channel.setFilenameEncoding(systemEncoding);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sftp_Channel;
	}

	/**
	 * �ϴ��ļ�
	 *
	 * @param directory
	 *            �ϴ���Ŀ¼
	 * @param uploadFile
	 *            Ҫ�ϴ����ļ�
	 * @param sftp
	 */
	public static String upload(File uploadFile) {
		String serverPath = "";
		try {
			ChannelSftp sftp = SftpUtil.connect();
			if (sftp != null) {
				cdDirectoryOrCreate(sftp_root, uploadFile.getParentFile().getName(), sftp);

				sftp.put(new FileInputStream(uploadFile), uploadFile.getName());
				serverPath = sftp_server + uploadFile.getParentFile().getName() + "/" + uploadFile.getName();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverPath;
	}

	/**
	 * �����ļ�
	 *
	 * @param directory
	 *            ����Ŀ¼
	 * @param downloadFile
	 *            ���ص��ļ�
	 * @param saveFile
	 *            ���ڱ��ص�·��
	 * @param sftp
	 */
	public static void download(String directory, String downloadFile, String saveFile, ChannelSftp sftp) {
		try {
			sftp.cd(directory);
			File file = new File(saveFile);
			sftp.get(downloadFile, new FileOutputStream(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ɾ���ļ�
	 *
	 * @param rootDirectory
	 *            Ҫɾ���ļ����ڸ�Ŀ¼
	 * @param directory
	 *            Ҫɾ���ļ�����Ŀ¼�����Ŀ¼��Ϊ�գ�Ҳɾ���ļ�Ŀ¼����ʽΪ��XXX/XXX/
	 * @param deleteFile
	 *            Ҫɾ�����ļ�
	 * @param sftp
	 * @return
	 * @throws SftpException
	 */
	public static Boolean delete(String deleteRemoteFilePath) {
		try {
			String directory = deleteRemoteFilePath.substring(
					deleteRemoteFilePath.indexOf(sftp_server) + sftp_server.length(),
					deleteRemoteFilePath.lastIndexOf("/") + 1);
			String deleteFile = deleteRemoteFilePath.substring(deleteRemoteFilePath.lastIndexOf("/") + 1);
			ChannelSftp sftp = SftpUtil.connect();
			sftp.cd(sftp_root + directory);
			sftp.rm(deleteFile);
			// Ϊ��ʱɾ��Ŀ¼
			while (listFiles(sftp_root + directory, sftp).size() == 2 && !"".equals(directory)) {
				sftp.cd("..");
				directory = directory.substring(0, directory.length() - 1);
				String removeDir = directory.substring(directory.lastIndexOf("/") + 1);
				sftp.rmdir(removeDir);
				directory = directory.substring(0, directory.lastIndexOf("/") + 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * �г�Ŀ¼�µ��ļ�
	 *
	 * @param directory
	 *            Ҫ�г���Ŀ¼
	 * @param sftp
	 * @return
	 * @throws SftpException
	 */
	public static Vector listFiles(String directory, ChannelSftp sftp) throws SftpException {
		return sftp.ls(directory);
	}

	public static void cdDirectoryOrCreate(String rootDirectory, String directory, ChannelSftp sftp)
			throws SftpException {
		if (null == directory || "".equals(directory)) {
			return;
		}
		sftp.cd(rootDirectory);
		String[] directs = directory.split("/");
		for (String d : directs) {
			try {
				if (null != d && !"".equals(d)) {
					sftp.cd(d);
				}
			} catch (Exception e) {
				sftp.mkdir(d);
				sftp.cd(d);
			}
		}
	}
}