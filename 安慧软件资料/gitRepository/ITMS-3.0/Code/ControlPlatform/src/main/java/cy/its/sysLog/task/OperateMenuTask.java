package cy.its.sysLog.task;

import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.sysLog.domain.OperateMenu;
import cy.its.sysLog.service.OperateMenuLogI;

/**
* @Title: OperateMenuTask.java 
* @Package cy.its.sysLog.task 
* @Description:�˵�����
* @author lil@cychina.cn
* @date 2016��3��11�� ����4:50:19 
* @version V1.0   
 */
public class OperateMenuTask extends Thread{
	
	private  Log4jFactoryProxy log4jFactoryProxy = Log4jFactoryProxy.getSingleton(OperateMenuTask.class);
	
	private OperateMenu operateMenu;
	
	private OperateMenuLogI operateMenuLogImpl;
	

	public  OperateMenuTask(OperateMenuLogI imp, OperateMenu log) {
		this.operateMenu=log;
		this.operateMenuLogImpl=imp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * ���ýӿڷ������棬��Ϣ
	 */
	@Override
    public void run() {
		
		int is = 0;
		try{
			is = operateMenuLogImpl.insert(operateMenu);
		}catch(Exception e){
			//�����κδ���Ӱ��������ҵ������ռǼ�¼���ɹ���
		}
		log4jFactoryProxy.info(is);
    }
}
