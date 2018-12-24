package cy.its.common.duplex.rabbitMq;

import com.alibaba.fastjson.JSONObject;

/**
* @Title: IWebscoketReceiver.java 
* @Package com.cy.rabbitMq 
* @Description:MQ���ýӿ��࣬��������
* @author lil@cychina.cn
* @date 2015��11��19�� ����2:52:50 
* @version V1.0   
 */
public interface IWebscoketReceiver {
	
	/** 
	* @Title: receive 
	* @Description:���崫��ӿ�
	* @param @param jsonStr
	* @param @return    �趨�ļ� 
	* @return Boolean    �������� 
	* @throws 
	*/
	public Boolean receive(JSONObject  jsonObject);
	
}
