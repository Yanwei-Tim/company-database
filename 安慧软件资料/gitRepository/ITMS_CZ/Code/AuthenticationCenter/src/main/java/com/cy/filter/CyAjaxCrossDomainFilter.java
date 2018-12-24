package com.cy.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lilei
 *���淽��������
 *�ӽ���������󣬲�ѯ���ݿ��д��ڵķ���Ȼ��������
 *����JSON����
 */
@WebFilter(filterName="cyAjaxCrossDomainFilter",urlPatterns="/service/*")
public class CyAjaxCrossDomainFilter  implements Filter {
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 * Filter 1�����û���֤���鿴�û��Ƿ��½
	 * 2���鿴�û���ɫ�Ƿ���й��ܷ���Ȩ��
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	        String key = request.getParameter("serviceKey");
	        getRequestPayload((HttpServletRequest)request);
	        //��һ��������������1�ǲ�ѯ�û��Ƿ��½
	        //2 �鿴�û��Ƿ���з��ʷ���Ȩ�ޣ�������򷵻�URL ���û���򷵻� ��Ȩ�޷��ʽ���
	        //��cookie��ȡtoken
	        if(key != null){
	        	String  loginToken="";
		        Cookie[] cookies = ((HttpServletRequest) request).getCookies(); 
		        for(Cookie c:cookies){
		        	if(c.getName().equals("LoginToken")){
		        		loginToken = c.getValue().toString();
		        	}
		        }
		        if(loginToken.equals("")){
		        	 request.getRequestDispatcher ("validateError.html").forward(request, response);//��½��Ϣ�����ڣ������µ�½
		        }
		        Map map = new HashMap<>();
		        map.put("serviceKey", key);
		        map.put("sessionId", loginToken);
		        map = validateService(map,request,response);
		        String status = (String) map.get("status");
		        if(status.equals("0")){
		        	writeError("��½��Ϣ�����ڻ���ڣ������µ�½",(HttpServletResponse) response);
		        }else if(status.equals("1")){
		        	writeError("��ûȨ�޷��ʸ÷���",(HttpServletResponse) response);
		        }else{
		        	doProxy(request , response , map.get("serviceUrl").toString());//���ʷ��񷵻�����
		        }
	        }else{
	        	chain.doFilter(request, response);
	        }
	}

	private void writeError(String string,HttpServletResponse response) throws IOException {
		response.setStatus(403);
		response.setHeader("Content-Type", "text/html;charset=UTF-8");
    	PrintWriter out=response.getWriter();
    	out.append(string);
	}

	/**
	 * @param map
	 * @param request
	 * @param response
	 * @return
	 */
	private Map validateService(Map map,ServletRequest request, ServletResponse response) {
		ObjectMapper  mapper  = new ObjectMapper();
		try {
			String  servieUrl = "http://192.168.10.33:9001/ac/service/validateService?paramInfo="+mapper.writeValueAsString(map);
			URL restServiceURL = new URL(servieUrl);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	/**
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 * ת��URL���󣬲��������ݶ���
	 */
	protected void doProxy(ServletRequest request, ServletResponse response,String serviceUrl) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        String mac;
        StringBuffer params=new StringBuffer();
        params.append("1=1");
        //���в������ŵ�URL����ȥ
		request.getParameterMap().forEach((id, val) ->  
			{
				try {
					params.append("&").append(id).append("=").append(val[0].toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		);
        if(serviceUrl != null){
            // ʹ��POST��ʽ��Ŀ�ķ�������������
            URL connect = new URL("http://192.168.10.33:9001/ac/"+serviceUrl);
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
	/**
	 * @param  key
	 * @return resful �ӿڵ�ַ�����油��
	 */
	private String getUrlBy(String key) {
		return null;
	}
	public void destroy() {
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	private String getRequestPayload(HttpServletRequest req) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();  
        try(BufferedReader reader = req.getReader();) {  
                 char[]buff = new char[1024];  
                 int len;  
                 while((len = reader.read(buff)) != -1) {  
                          sb.append(buff,0, len);  
                 }  
        }catch (IOException e) {  
                 e.printStackTrace();  
        }  
        return  URLDecoder.decode(sb.toString(),"UTF-8");  
   } 
}
