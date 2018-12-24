package cy.its.service.imageQuery.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.URL;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import cy.its.service.imageQuery.utils.StreamHelper;


public class FtpAccess {
	public static void main(String[] args) {

		byte[] file;
		try {
			// String ftp =
			// "ftp://CY8011:cy_1234@192.168.10.205/ϵͳ�߻�֧�ֲ�/���������ĵ�/������������/�����и��ٹ�·���ܽ�ͨ��ȫ����ϵͳ��Ŀ��������V4.0.docx";
			// file = FtpUtils.download(ftp);

			String ftp = "ftp://192.168.10.205/ϵͳ�߻�֧�ֲ�/���������ĵ�/������������/�����и��ٹ�·���ܽ�ͨ��ȫ����ϵͳ��Ŀ��������V4.0.docx";
			file = download(ftp, "CY8011", "cy_1234");
			System.out.println(file.length);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * �����ַ�����
	 */
	private static String LOCAL_CHARSET = "GBK";

	/*
	 * FTPЭ�����棬�涨�ļ�������Ϊiso-8859-1
	 */
	private static String SERVER_CHARSET = "ISO-8859-1";

	public static byte[] download(String ftpUrl) throws Exception {
		return download(ftpUrl, "", "");
	}

	public static byte[] download(String ftpUrl, String defaltUser, String defaultPwd) throws Exception {
		URL url = new URL(ftpUrl);
		String host = url.getHost();
		int port = url.getPort();
		String userInfo = url.getUserInfo();
		String user = defaltUser, pwd = defaultPwd;
		if (userInfo != null) {
			String[] u = userInfo.split(":");
			if (u.length > 1) {
				user = u[0];
				pwd = u[1];
			}
		}

		return download(host, port, user, pwd, url.getPath());
	}

	static byte[] download(String host, int port, String user, String passWord, String filePath) throws Exception {
		FTPClient ftp = null;
		InputStream is = null;
		try {
			ftp = connect(host, port);
			String localCharset = localCharset(ftp);
			configFtpClient(ftp, localCharset);

			if (login(user, passWord, ftp)) {
				is = ftp.retrieveFileStream(new String(filePath.getBytes(localCharset), SERVER_CHARSET));
				if (is != null) {
					return StreamHelper.readInputStream(is);
				}
			}

			return null;
		} finally {
			close(ftp, is);
		}
	}

	private static Boolean login(String user, String passWord, FTPClient ftp) throws IOException {
		Boolean canDownload = true;
		if (user != null && user != "") {
			canDownload = ftp.login(user, passWord);
		}
		return canDownload;
	}

	private static void close(FTPClient ftp, InputStream is) {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (ftp != null) {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static FTPClient connect(String host, int port) throws SocketException, IOException, Exception {
		FTPClient ftpClient = new FTPClient();
		if (port < 0) {
			ftpClient.connect(host);
		} else {
			ftpClient.connect(host, port);
		}

		int reply = ftpClient.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftpClient.disconnect();
			throw new Exception("FTP�������ܾ�������.");
		}
		return ftpClient;
	}

	private static void configFtpClient(FTPClient ftpClient, String localCharset) throws IOException {
		ftpClient.setControlEncoding(localCharset);
		ftpClient.enterLocalPassiveMode();// ���ñ���ģʽ
		ftpClient.setBufferSize(1024);
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
	}

	private static String localCharset(FTPClient ftpClient) throws IOException {
		int reply = ftpClient.sendCommand("OPTS UTF8", "ON");
		String localCharset = LOCAL_CHARSET;
		if (FTPReply.isPositiveCompletion(reply)) {
			localCharset = "UTF-8";
		}
		return localCharset;
	}
}
