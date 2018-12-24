package cy.its.sysLog.task;

import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.sysLog.domain.UserLogin;
import cy.its.sysLog.service.UserLoginLogI;

/**
* @Title: UserLoginTask.java 
* @Package cy.its.sysLog.task 
* @Description: �û���¼
* @author lil@cychina.cn
* @date 2016��3��11�� ����4:50:03 
* @version V1.0   
 */
public class UserLoginTask  extends Thread{
	
	private  Log4jFactoryProxy log4jFactoryProxy = Log4jFactoryProxy.getSingleton(UserLoginTask.class);
	
	private UserLogin userLogin;
	
	private UserLoginLogI userLoginLogImpl;
	

	public  UserLoginTask(UserLoginLogI imp, UserLogin log) {
		this.userLogin=log;
		this.userLoginLogImpl=imp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * ���ýӿڷ������棬��Ϣ
	 */
	@Override
    public void run() {
		
		int is = 0;
		try{
			is = userLoginLogImpl.insert(userLogin);
		}catch(Exception e){
			//�����κδ���Ӱ��������ҵ������ռǼ�¼���ɹ���
		}
		log4jFactoryProxy.info(is);
    }
}
