package cy.its.sysLog.service;

import cy.its.sysLog.domain.OperateMenu;

/**
* @Title: OperateMenuLogI.java 
* @Package cy.its.sysLog.service 
* @Description: ��¼�˵�����
* @author lil@cychina.cn
* @date 2016��3��11�� ����4:14:58 
* @version V1.0   
 */
public interface OperateMenuLogI { 
	/** 
	* @Title: insert 
	* @Description: �����˵���־
	* @param @param record
	* @param @return    �趨�ļ� 
	* @return int    �������� 
	* @throws 
	*/
	int insert(OperateMenu record);
}
