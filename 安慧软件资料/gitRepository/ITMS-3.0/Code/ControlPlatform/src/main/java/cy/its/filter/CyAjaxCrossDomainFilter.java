package cy.its.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import cy.its.web.GlobalProerty;

/**
* @Title: CyAjaxCrossDomainFilter.java 
* @Package cy.its.filter 
* @Description:1��service��ͷ�ķ��ʷ��������û����󣬸��ݷ��ʵ�ģ�飬
* ��ȡ����ģ���ǲ��Ƿֲ�ʽ�����������ֱ�Ӵ�����ʷ��񲢷�������
* @author lil@cychina.cn
* @date 2015��8��14�� ����1:58:49
* @version V1.0   
 */
@WebFilter(filterName="cyAjaxCrossDomainFilter",urlPatterns="/service/*")
public class CyAjaxCrossDomainFilter  implements Filter {
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 * ��֤���û��Ƿ���Է��ʷ���
	 */
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		
		//����ģʽû�д���Ҳ����Ҫ����
		if(GlobalProerty.getGlobalProerty().model.equals("develop")){
			
			chain.doFilter(request, response);
			
		}else{
			//����ȫ��������Ϣ��ģ���Ƿ�ֲ�ʽ����
			String url =((HttpServletRequest)request).getServletPath();
			String temp  = url.replace("/service/", "");
			String  urlNameSpace = url.split("/")[0];
			if(StringUtils.isEmpty(GlobalProerty.getGlobalProerty().routeMap.get(urlNameSpace))){//������
				chain.doFilter(request, response);
			}else{//����
				String ipProject = (String) GlobalProerty.getGlobalProerty().routeMap.get(urlNameSpace);
				//��ʼ����
				doProxy((HttpServletRequest)request,response,ipProject);
				
			}
		}
		   
	}
	
	/**
	 * @param request
	 * @param response
	 * @param url
	 * @throws ServletException
	 * @throws IOException
	 * ת��URL���󣬲��������ݶ���
	 */
	protected void doProxy(HttpServletRequest request, ServletResponse response,String  ipPorject) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out=response.getWriter();
        StringBuffer params=new StringBuffer();
        String serviceUrl=request.getServletPath();
        //���в������ŵ�URL����ȥ
        params.append(request.getQueryString());
        // ʹ��POST��ʽ��Ŀ�ķ�������������
        URL connect = new URL("http://"+ipPorject+"/"+serviceUrl);
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

	public void destroy() {
		
	}
	
	public void init(FilterConfig arg0) throws ServletException {
		
	}
}
