package cy.its.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cy.its.platform.common.utils.NetworkUtil;
import cy.its.sysLog.domain.UserLogin;
import cy.its.sysLog.domain.UserStatus;
import cy.its.sysLog.service.UserLoginLogI;
import cy.its.sysLog.service.UserStatusLogI;
import cy.its.sysLog.task.LogTaskThroadManager;
import cy.its.sysLog.task.UserLoginTask;
import cy.its.sysLog.task.UserStatusTask;

public class UserUtil {
	
   public  static  void loginLog(String name,HttpServletRequest request){
	    ApplicationContext springBeanFactory = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
   		UserLoginLogI imp = (UserLoginLogI) springBeanFactory.getBean("userLoginLogImpl");
   		name = imp.getUserId(name.toUpperCase());
		//��ȡ�û�IP��ַ
		String  ip  =  getIp(request);
		UserLogin   userLogin  = new UserLogin();
		userLogin.setUserId(name);
		userLogin.setUserIp(ip);
		userLogin.setLoginTime(new Date());
		userLogin.setRemark("����¼��");
		UserLoginTask task = new  UserLoginTask(imp,userLogin);
		LogTaskThroadManager.addTaskPool(task);
		
		UserStatus  status  = new UserStatus();
		status.setUserId(name);
		UserStatusLogI userStatusLogI = (UserStatusLogI) springBeanFactory.getBean("userStatusLogImpl");
		UserStatusTask userTask = new UserStatusTask(userStatusLogI,status);
		LogTaskThroadManager.addTaskPool(userTask);
   }
   
	/** 
	* @Title: getIp 
	* @Description: ��ȡIP
	* @param @param request
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private static String getIp(HttpServletRequest request) {
		String ip = "";
		try {
			ip=NetworkUtil.getIpAddress(request);
		} catch (IOException e) {
			ip = "";
		}
		return ip;
	}
}
