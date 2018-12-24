package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.repository.dao.ApproveChk;

/**
* @Title: ApproveChkActionI.java 
* @Package ah.its.wrokflow.action 
* @Description: ����������
* @author lil@cychina.cn
* @date 2016��4��27�� ����9:14:41 
* @version V1.0   
 */
public interface ApproveChkActionI {
	
	/** 
	* @Description: �������뵥��ѯ������¼ 
	* @param @param approveId
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map queryChkRecord(String approveId);
	
	
	/** 
	* @Description: ����
	* @param @param form
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map processChkRecord(ApproveChk form);
}
