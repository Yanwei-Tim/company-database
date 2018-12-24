package cy.its.common.duplex.rabbitMq;

import cy.its.service.common.rabbitmqClient.IReceiver;

/**
* @Title: IMqReceiver.java 
* @Package com.cy.rabbitMq 
* @Description:���� IReceiver �ӿڣ���Ҫ����ע��ӿ�
* @author lil@cychina.cn
* @date 2015��11��19�� ����2:48:49 
* @version V1.0   
 */
public interface IMqReceiver extends IReceiver{
    
	/** 
	* @Title: addReciveObject 
	* @Description:����ע��ӿڣ����ڽӿ�ʵ�� 
	* @param @return  �趨�ļ� 
	* @return boolean �������� 
	* @throws 
	*/
	public  boolean  addReciveObject(IWebscoketReceiver webscoketReceiver);
	
}
