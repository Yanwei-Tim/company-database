package cy.its.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cy.its.platform.common.utils.NetworkUtil;
import cy.its.sysLog.domain.OperateMenu;
import cy.its.sysLog.service.OperateMenuLogI;
import cy.its.sysLog.task.LogTaskThroadManager;
import cy.its.sysLog.task.OperateMenuTask;

/**
 * @author lilei
 * �����½��    SERVLET
 */
@WebServlet("/menuServlet")
public class MenuServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginName = request.getParameter("currentUserId");
		String menuId = request.getParameter("menuId");
		String menuName = request.getParameter("menuName");
		String orgId = request.getParameter("currentOrgId");
		
		
    	ApplicationContext springBeanFactory = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
    	OperateMenuLogI imp = (OperateMenuLogI) springBeanFactory.getBean("operateMenuLogImpl");
		//��ȡ�û�IP��ַ
		String  ip  =  getIp(request);
		OperateMenu   operateMenu  = new OperateMenu();
		operateMenu.setMenName(menuName);
		operateMenu.setMenuId(menuId);
		operateMenu.setOrgId(orgId);
		operateMenu.setOperIp(ip);
		operateMenu.setOperateTime(new Date());
		operateMenu.setUserId(loginName);
		operateMenu.setRemark("����¼��");
		OperateMenuTask task = new  OperateMenuTask(imp,operateMenu);
		LogTaskThroadManager.addTaskPool(task);
	}
	//��дdoPost����
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
	
	/** 
	* @Title: getIp 
	* @Description: ��ȡIP
	* @param @param request
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private String getIp(HttpServletRequest request) {
		String ip = "";
		try {
			ip=NetworkUtil.getIpAddress(request);
		} catch (IOException e) {
			ip = "";
		}
		return ip;
	}

}
