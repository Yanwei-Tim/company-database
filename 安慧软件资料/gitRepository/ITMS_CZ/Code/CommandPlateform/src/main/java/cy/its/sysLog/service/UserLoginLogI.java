package cy.its.sysLog.service;

import cy.its.sysLog.domain.UserLogin;

public interface UserLoginLogI {
	/** 
	* @Title: insert 
	* @Description: �����˵���־
	* @param @param record
	* @param @return �趨�ļ� 
	* @return int    �������� 
	* @throws 
	*/
	int insert(UserLogin record);
	
	/** 
	* @Description: ���ݵ�¼������ȡ�û�ID
	* @param @param name
	* @param @return    USER_ID 
	* @return String    �������� 
	* @throws 
	*/
	String getUserId(String name);
}
