package ah.its.wrokflow.domain;

import java.util.List;

import ah.its.wrokflow.repository.dao.ApproveChk;

/**
* @Title: ApproveChkServiceI.java 
* @Package ah.its.wrokflow.domain 
* @Description: ����������
* @author lil@cychina.cn
* @date 2016��4��26�� ����6:28:14 
* @version V1.0   
 */
public interface ApproveChkServiceI {
	
	public int saveApproveChkData(ApproveChk record);
	
	public List<ApproveChk> queryApproveChkData(String approveId);
}
