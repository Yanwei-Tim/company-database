package ah.its.workFlow.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.fastjson.JSONObject;

import ah.its.workFlow.util.MD5Util;
import ah.its.wrokflow.action.SysUserActionI;
import ah.its.wrokflow.domain.Impl.SysUserDomainImpl;
import ah.its.wrokflow.repository.SysUserRepositoryI;

/**
* @Title: LoginServlet.java 
* @Package ah.its.workFlow.web.servlet 
* @Description:�����¼�����е�����
* @author lil@cychina.cn
* @date 2016��4��5�� ����10:12:11 
* @version V1.0 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	/**
	 * @Description:����
	 */
	private static final long serialVersionUID = 3841675807862073145L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String loginName = request.getParameter("loginName");
		String password = request.getParameter("pwd");
		try {
			password  = MD5Util.md5(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//��֤��¼����¼�ɹ�����Ϣд��cookie����Ϊȫ�ֵĻ���
		ApplicationContext springBeanFactory = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		SysUserDomainImpl  sysUserDomainImpl = (SysUserDomainImpl) springBeanFactory.getBean("sysUserDomainImpl");
		Map  map = sysUserDomainImpl.queryUserShipById(loginName, password);
		//�����֤ͨ�������û���Ϣд��cookie
		if(map.get("status").equals("1")){
	    	 //д��ͻ��˵�cookie��
			 JSONObject  obj = (JSONObject) JSONObject.parse(JSONObject.toJSONString(map));
			 JSONObject  user = obj.getJSONObject("user");
			 //�����з��룬�û���������ID��������Ƭ��������ַ
	    	 Cookie cookie = new Cookie("loginName",loginName);
	    	 Cookie cookieName = new Cookie("userName",URLEncoder.encode(user.getString("first"),"utf-8"));
	    	 Cookie cookie1 = new Cookie("groupId",user.getString("groupId"));
	    	 Cookie cookie2 = new Cookie("servieImg",GlobalProerty.getGlobalProerty().service_img);
	    	 response.addCookie(cookie);
	    	 response.addCookie(cookie1);
	    	 response.addCookie(cookie2);
	    	 response.addCookie(cookieName);
	     }
	   	 //AJAX��ʽ��������
	   	 response.setContentType("application/x-json;charset=UTF-8");
	   	 PrintWriter out = response.getWriter();
	   	 out.write(JSONObject.toJSONString(map));//ע��������jsp�����������script�еĽػ񷽷�
	   	 out.flush();  
	   	 out.close();
   	 
	}
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	
	
}
