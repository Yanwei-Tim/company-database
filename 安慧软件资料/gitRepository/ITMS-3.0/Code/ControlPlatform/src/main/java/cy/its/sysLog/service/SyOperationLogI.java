package cy.its.sysLog.service;

import cy.its.sysLog.domain.SyOperationLog;

/**
* @Title: SyOperationLogI.java 
* @Package cy.its.sysLog.service 
* @Description: TODO �����ռǶ�д
* @author lil@cychina.cn
* @date 2015��8��31�� ����3:42:56 
* @version V1.0   
 */
public interface SyOperationLogI {
	
	/** 
	* @Title: insert 
	* @Description: ������־
	* @param @param record
	* @param @return    �趨�ļ� 
	* @return int    �������� 
	* @throws 
	*/
	int insert(SyOperationLog record);
	
}
