package cy.its.violation.rest.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cy.its.violation.domain.model.violation.Violation;
import cy.its.violation.rest.action.impl.FileToZip;

public class ViolationExport {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private static String fileseparator = File.separator == "/" ? "/" : "\\";

	/**
	 * �Բ�ѯ����Υ����������xml�ĵ����洢�ڷ�������
	 * 
	 * @param request
	 * @param vioLst
	 * @return
	 */
	public static String CreateFileFromData(HttpServletRequest request, List<Violation> vioLst) {
		String httpFileHref;

		//
		String serverDirectory = request.getSession().getServletContext().getRealPath("/") + fileseparator + "file";
		String exportDirectory = serverDirectory + fileseparator + dateFormat.format(new Date());
		File exportFile = new File(exportDirectory);
		// ����ļ��в��������½�
		if (!exportFile.exists()) {
			exportFile.mkdirs();
		}
		//
		vioLst.stream().parallel().forEach(vl -> {
			// ����XML�ļ�

			XmlExportGen.createXmlByViolation(vl, exportDirectory);
		});
		// ����ļ��У����ش���ļ�������
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy��MM��dd��HHʱmm��");
		String zipFileName = "Υ������" + format2.format(new Date());
		FileToZip.fileToZip(exportDirectory, serverDirectory, zipFileName);

		httpFileHref = ServerUtil.getFileUrl(request) + "/" + "file" + "/" + zipFileName + ".zip";
		// ɾ���ļ���
		deleteFile(exportFile);
		return httpFileHref;
	}

	// ɾ���ļ��м��ڲ��ļ�
	public static void deleteFile(File oldPath) {
		if (oldPath.exists()) {
			if (oldPath.isDirectory()) {
				File[] files = oldPath.listFiles();
				for (File file : files) {
					deleteFile(file);
				}
				oldPath.delete();
			} else {
				oldPath.delete();
			}
		}
	}

}
