package cy.its.platform.common.utils;

import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
* @Title: SpringBeanFactoryUtil.java 
* @Package cy.its.utils 
* @Description: �ṩȫ�ַ���SPRING bean�ӿ�
* @author lil@cychina.cn
* @date 2015��9��8�� ����6:52:51 
* @version V1.0   
 */
public class SpringBeanFactoryUtil {
    
    private  static WebApplicationContext wac;
	
    /** 
    * @Title: setServletContext 
    * @Description: ͨ���������Ϣ��ʼ��WebApplicationContext����
    * @param @param servletContext    �趨�ļ� 
    * @return void    �������� 
    * @throws 
    */
    public   static void  setServletContext(ServletContext servletContext){
    	wac = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    }
    
    /** 
    * @Title: getBeanFromFactory 
    * @Description: ���ݳ�������ƻ�ȡ����BEAN
    * @param @param serviceName
    * @param @return    �趨�ļ� 
    * @return Object    �������� 
    * @throws 
    */
    public  static Object getBeanFromFactory(String  serviceName){
    	return wac.getBean(serviceName);
    }
}
