package cy.its.violation.rest.util;

import javax.servlet.http.HttpServletRequest;

public class ServerUtil {

	// ��ȡ������ʵ�ַ
	public static String getFileUrl(HttpServletRequest request) {
		String path = request.getRequestURL().toString();
		String projectName = request.getContextPath();
		return path.split(projectName)[0] + projectName;
	}

}
