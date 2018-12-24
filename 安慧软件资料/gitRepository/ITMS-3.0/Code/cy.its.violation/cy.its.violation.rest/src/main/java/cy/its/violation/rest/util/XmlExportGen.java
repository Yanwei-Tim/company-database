package cy.its.violation.rest.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentFactory;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.springframework.util.StringUtils;

import cy.its.violation.domain.model.violation.Violation;
import cy.its.violation.rest.action.impl.FileToZip;

public class XmlExportGen {

	private static String fileseparator = File.separator == "/" ? "/" : "\\";

	/**
	 * ���ݴ����������XML��ͼƬ
	 * 
	 * @param vl
	 *            Υ����Ϣ
	 * 
	 * @param exportDirectory
	 */
	public static void createXmlByViolation(Violation vl, String exportDirectory) {
		String documentName = exportDirectory + fileseparator + vl.getIdentityId() + ".xml";
		DocumentFactory factory = new DocumentFactory();
		Document document = factory.createDocument();
		Element root = document.addElement("violation");
		// �������ڵ�
		Element images = root.addElement("images");
		String url = "http://localhost:8080/ControlPlatform/html/src/data/violationMgr/img/region_0.jpg,http://localhost:8080/ControlPlatform/html/src/data/violationMgr/img/region_1.jpg";// vl.image;
		String[] urls = url.split(",");
		int i = 1;
		for (String tmp : urls) {
			if (!StringUtils.isEmpty(tmp)) {
				Element image1 = images.addElement("image");
				String imageName = tmp.substring(tmp.lastIndexOf("/") + 1, tmp.length());
				image1.addAttribute("url", vl.getIdentityId() + "-" + i + imageName);// ������name
				// ��ͼƬ�����ļ���
				try {
					URL httpurl = new URL(tmp);
					HttpURLConnection conn = (HttpURLConnection) httpurl.openConnection();
					// ��������ʽΪ"GET"
					conn.setRequestMethod("GET");
					// ��ʱ��Ӧʱ��Ϊ5��
					conn.setConnectTimeout(5 * 1000);
					// ͨ����������ȡͼƬ����
					InputStream inStream = conn.getInputStream();
					// �õ�ͼƬ�Ķ��������ݣ��Զ����Ʒ�װ�õ����ݣ�����ͨ����
					byte[] data = FileToZip.readInputStream(inStream);
					// newһ���ļ�������������ͼƬ��Ĭ�ϱ��浱ǰ���̸�Ŀ¼
					File imageFile = new File(exportDirectory + fileseparator + vl.getIdentityId() + "-" + imageName);
					// ���������
					FileOutputStream outStream = new FileOutputStream(imageFile);
					// д������
					outStream.write(data);
					// �ر������
					outStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		// ����һ��xml�ļ�����Dom4j��д��xml�ļ�
		try {
			FileWriter fw = new FileWriter(documentName);
			XMLWriter writer = new XMLWriter(fw);
			writer.write(document);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
