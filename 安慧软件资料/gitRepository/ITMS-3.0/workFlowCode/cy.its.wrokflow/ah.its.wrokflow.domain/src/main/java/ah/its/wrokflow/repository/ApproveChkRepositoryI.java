package ah.its.wrokflow.repository;

import java.util.List;

import ah.its.wrokflow.repository.dao.ApproveChk;

/**
* @Title: ApproveChkRepositoryI.java 
* @Package ah.its.wrokflow.repository 
* @Description: ����������
* @author lil@cychina.cn
* @date 2016��4��26�� ����6:26:01 
* @version V1.0   
 */
public interface ApproveChkRepositoryI {
	
	public int saveApproveChkData(ApproveChk record);
	
	public List<ApproveChk> queryApproveChkData(String approveId);
}
