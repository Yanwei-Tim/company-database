package cy.its.upload;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;

import cy.its.platform.common.utils.SftpUtil;

/**
 * @author ����
 *
 */
@WebServlet("/cosDeleteServlet")
public class CosDeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		JSONObject jsonobj = new JSONObject();

		String filePaths = request.getParameter("filePaths");
		if (Strings.isNullOrEmpty(filePaths)) {
			jsonobj.put("info", "�봫����ȷ���ļ�·����");
		} else {
			String deleteFile = "";
			if (filePaths.contains(",")) {
				String[] paths = filePaths.split(",");
				for (String path : paths) {
					if (SftpUtil.delete(path)) {
						deleteFile += path + ",";
					}
				}
			} else {
				if (SftpUtil.delete(filePaths)) {
					deleteFile += filePaths + ",";
				}
			}
			jsonobj.put("info", "�ļ���" + deleteFile + "���Ѿ���ɾ����");
		}
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(jsonobj.toJSONString());
	}

}
