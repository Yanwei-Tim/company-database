package cy.its.platform.common.exception;

import cy.its.platform.common.utils.Log4jFactoryProxy;

/**
* @Title: ItmsAppException.java 
* @Package cy.its.platfrom.common.exception 
* @Description: ����ϵͳ�쳣���࣬�̳���
*rumTimeException 
* @author lil@cychina.cn
* @date 2015��9��28�� ����1:48:32 
* @version V1.0   
 */
public class ItmsAppException extends RuntimeException { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309113777707711417L;
	
	Log4jFactoryProxy log4jFactoryProxy=Log4jFactoryProxy.getSingleton(ItmsAppException.class);
	
    /**
     * �޲εĹ��캯��
     * ����Ҫ����κ���Ϣ����������
     */
    public ItmsAppException() {
        super();  
    }  
 
    /**
     * @param msg
     * ���ݴ�����Ϣ�����ݸ������Ա��ͬʱ����̨��ӡ�����Ϣ
     */
    public ItmsAppException(String msg) {
        super(msg);  
        printAppStackTrace(msg);
    }  
	
    /** 
    * @Title: printAppStackTrace 
    * @Description: ��ӡ�Զ�����Ϣ�����Ҵ�ӡ����Դ��Ϣ
    * @param @param msg    �趨�ļ� 
    * @return void �������� 
    * @throws 
    */
    private void printAppStackTrace(String msg) {
    	log4jFactoryProxy.error(msg);
    	StackTraceElement[] stacks =this.getStackTrace();
    	for(StackTraceElement st: stacks){
    		log4jFactoryProxy.error("��������쳣��Ϣ:"+st.getMethodName()+" : "+st);
    	}
	}
}
