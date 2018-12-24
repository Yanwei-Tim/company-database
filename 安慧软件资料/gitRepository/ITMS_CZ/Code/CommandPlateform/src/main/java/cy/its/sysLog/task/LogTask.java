package cy.its.sysLog.task;

import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.sysLog.domain.SyOperationLog;
import cy.its.sysLog.service.SyOperationLogI;

/**
* @Title: LogTask.java 
* @Package cy.its.sysLog 
* @Description: �첽��¼��־��Ϣ
* @author lil@cychina.cn
* @date 2015��8��31�� ����6:57:57 
* @version V1.0   
 */
public class LogTask  extends Thread{
	
	private  Log4jFactoryProxy log4jFactoryProxy = Log4jFactoryProxy.getSingleton(LogTask.class);
	
	private SyOperationLog syOperationLog;
	
	private SyOperationLogI SyOperationLogImpl;
	

	public  LogTask(SyOperationLogI imp, SyOperationLog log) {
		this.syOperationLog=log;
		this.SyOperationLogImpl=imp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * ���ýӿڷ������棬��Ϣ
	 */
	@Override
    public void run() {
		
		int is = 0;
		try{
			is = SyOperationLogImpl.insert(syOperationLog);
		}catch(Exception e){
			//�����κδ���Ӱ��������ҵ������ռǼ�¼���ɹ���
		}
		log4jFactoryProxy.info(is);
    }
}
