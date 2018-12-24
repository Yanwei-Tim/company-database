package cy.its.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import cy.its.platform.common.utils.MD5Util;
/**
 * @author lilei
 * �����½��    SERVLET
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private ObjectMapper  mapper  = new ObjectMapper();
	/**
	 *
	 */
	private static final long serialVersionUID = -34186853386310955L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("loginName");
		String password = request.getParameter("password");
		String loginType = request.getParameter("loginType");
		String sessionId="";
		/**
		 * ������ǰ��ʽ���û���¼��
		 */
		if("1".equals(loginType)){
			//��־Ϊ1ʱ����ѯ��ɫ��Ϣ
			processUrlData("authentication/getAllRoleByStaffCode",request,response,"username",name);//�����ȡ��ɫ����
		}else if("2".equals(loginType)){
			//�ǳ�
			//��ȡ��ǰ�û�token
			sessionId= getTokenValue(request);
			if(!"".equals(sessionId)){
				processUrlData("authentication/loginOut",request,response,"sessionId",sessionId);//�����ȡ��ɫ����
			}
		}else if("3".equals(loginType)){
			//ˢ�¹���ʱ��
			sessionId= getTokenValue(request);
			if(!"".equals(sessionId)){
				processUrlData("authentication/reFreshToken",request,response,"sessionId",sessionId);//�����ȡ��ɫ����
			}
		
		}else if("4".equals(loginType)){
			//ͳ�������û���
			processUrlData("authentication/onlineUsers",request,response,"u","1");//�����ȡ��ɫ����
		}else{//��½��Ϣ
			String role = request.getParameter("role");
			Map mapInfo = new HashMap();
			mapInfo.put("role", role);
			mapInfo.put("username", name);
			//�������İ�ȫ��飬��½���������MD5��ʽ���ܡ�
			try {
				password  = MD5Util.md5(password);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
			mapInfo.put("password", password);
			
			processUrlRequest(name,"authentication/validatelogin",request,response,mapper.writeValueAsString(mapInfo));
	
		}
	}
	
	/** 
	* @Title: getTokenValue 
	* @Description:���û������л�ȡtoken��Ϣ
	* @param @param request
	* @param @return    �趨�ļ� 
	* @return String    �������� 
	* @throws 
	*/
	private String getTokenValue(HttpServletRequest request) {
		String  sessionId ="";
		Cookie[]  cookies  = request.getCookies();
		for(Cookie cookie:cookies){
			if(null != cookie.getName()){
				if(("LoginToken").equals(cookie.getName())){
					sessionId = cookie.getValue();
				}
			}
		}
		return sessionId;
	}

	private void processUrlData(String serviceUrl,HttpServletRequest request,
			HttpServletResponse response,String paraInfo,String value) throws IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        StringBuffer params=new StringBuffer();
        params.append("1=1");
        params.append("&").append(paraInfo).append("=").append(value);
        if(serviceUrl != null){
            // ʹ��POST��ʽ��Ŀ�ķ�������������
            URL connect = new URL("http://"+GlobalProerty.getGlobalProerty().validate_ip+"/"+GlobalProerty.getGlobalProerty().authorityPName+"/service/"+serviceUrl);
            URLConnection connection = connect.openConnection();
            connection.setDoOutput(true);
            OutputStreamWriter paramout = new OutputStreamWriter(connection.getOutputStream());
            paramout.write(params.toString());
            paramout.flush();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuffer dataSend=new StringBuffer();
            while((line = reader.readLine()) != null){
                out.append(line);
                dataSend.append(line);
            }
            paramout.close();
            reader.close();
        }
	}

	private void processUrlRequest(String  loginName,String serviceUrl, HttpServletRequest request,
			HttpServletResponse response, String writeValueAsString) throws IOException {
		Map  map = new HashMap<>();
		//Զ�������ַ��
		String url= "http://"+GlobalProerty.getGlobalProerty().validate_ip+"/"+GlobalProerty.getGlobalProerty().authorityPName+"/service/"+serviceUrl+"?paramInfo="+writeValueAsString;
		URL restServiceURL = new URL(url);
		HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();
		httpConnection.setRequestMethod("GET");
		httpConnection.setRequestProperty("Accept", "application/json");
		if (httpConnection.getResponseCode() != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : "
                          + httpConnection.getResponseCode());
	     }
	     BufferedReader responseBuffer = new BufferedReader(new InputStreamReader((httpConnection.getInputStream()),"UTF-8"));
	     String output;
	     while ((output = responseBuffer.readLine()) != null) {
	           map= mapper.readValue(output, Map.class);
	     }
	     httpConnection.disconnect();
	     
	     if(map.get("data") != null ){
	    	 //д��ͻ��˵�cookie��
	    	 Cookie cookie = new Cookie("LoginToken",map.get("info").toString());
	    	 response.addCookie(cookie);
	     }
	     if("2".equals(map.get("status"))){
	 		//�û�״̬��¼
			UserUtil.loginLog(loginName, request);
	     }
    	 //AJAX��ʽ��������
    	 response.setContentType("application/x-json;charset=UTF-8");
    	 PrintWriter out = response.getWriter();
    	 out.write(JSONObject.toJSONString(map));//ע��������jsp�����������script�еĽػ񷽷�
    	 out.flush();  
    	 out.close();
    	 //response.sendRedirect("index.jsp");
	}



	//��дdoPost����
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}
}
