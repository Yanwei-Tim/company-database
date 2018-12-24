package cy.its.sysLog.task;

import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.sysLog.domain.UserStatus;
import cy.its.sysLog.service.UserStatusLogI;

/**
* @Title: UserStatusTask.java 
* @Package cy.its.sysLog.task 
* @Description: �����û�״̬������
* @author lil@cychina.cn
* @date 2016��3��11�� ����4:49:39 
* @version V1.0   
 */
public class UserStatusTask extends Thread{
   
	private  Log4jFactoryProxy log4jFactoryProxy = Log4jFactoryProxy.getSingleton(UserStatusTask.class);
	
	private UserStatus userStatus;
	
	private UserStatusLogI userStatusLogImpl;
	

	public  UserStatusTask(UserStatusLogI imp, UserStatus log) {
		this.userStatus=log;
		this.userStatusLogImpl=imp;
	}
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 * ���ýӿڷ������棬��Ϣ
	 */
	@Override
    public void run() {
		
		int is = 0;
		try{
			is = userStatusLogImpl.updateUserStatus(userStatus);
		}catch(Exception e){
			//�����κδ���Ӱ��������ҵ������ռǼ�¼���ɹ���
		}
		log4jFactoryProxy.info(is);
    }
}
