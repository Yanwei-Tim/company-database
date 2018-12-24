package cy.its.platform.common.utils;

import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author lilei
 * @company ���ճ�Զ
 * �ռǴ����࣬ϵͳȫ������
 * ����ģʽ ʵ��ȫ��ͳһ
 */
public class Log4jFactoryProxy {
   
   private  Logger log;
   
   private volatile static Log4jFactoryProxy log4jFactoryProxy;  
   
	/**
	 * @param classInfo ��ӡ��־��
	 * 
	 */
	private Log4jFactoryProxy(Class classInfo){
		   log  = Logger.getLogger(classInfo);
	}
   
   /**
 * @param classinfo
 * @return ��ǰ��ʵ����ȫ��Ψһ
 * ʵ��ͬ������
 */
public static Log4jFactoryProxy getSingleton(Class classinfo) {  
	    if (log4jFactoryProxy == null) {  
	        synchronized (Log4jFactoryProxy.class) {  
		        if (log4jFactoryProxy == null) {  
		        	log4jFactoryProxy = new Log4jFactoryProxy(classinfo);  
		        }  
	        }  
	    }  
	    return log4jFactoryProxy;  
   } 

	 /**
	 * @param message
	 * ת����info����
	 */
	public  void info(Object  message){
	   log.info(message);
   }
	/**
	* @param message
	* ת����debug����
	*/
   public  void debug(Object  message){
	   log.debug(message);
   }
	/**
	* @param message
	* ת����error����
	*/
   public  void error(Object  message){
	   log.error(message);
   }


	public void error(String message, SQLException e) {
		 log.error(message,e);
	}
}
