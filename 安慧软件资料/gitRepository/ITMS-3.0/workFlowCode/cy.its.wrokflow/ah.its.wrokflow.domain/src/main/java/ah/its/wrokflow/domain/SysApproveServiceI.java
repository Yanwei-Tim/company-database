package ah.its.wrokflow.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.ApproveChk;
import ah.its.wrokflow.repository.dao.SysApprove;

/**
 * ���뵥ҵ������ 
 * @Title: SystemApproveServiceI.java
 * @Package ah.its.wrokflow.domain
 * @Description: TODO(����Ҫ��д��;)
 * @author chengf chengf@cychina.cn
 * @date 2016��6��13�� ����5:54:25
 * @version V1.0
 */
public interface SysApproveServiceI {
	
	/**
	 * ����ϵͳ���뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  int  saveSystemApprove(SysApprove record);
	
	/**
	 * ����ʵ��ID�����µ����뵥��
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  int  updateSystemApprove(SysApprove record);
	
	/**
	 * ��ѯ���뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  List<SysApprove>  selectAllData(Map map);
	
	/**
	 * ɾ�����뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  int  deleteSystemApprove(Map map);
	
	/**
	 * ����id�������뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public SysApprove querySystemApproveById(String approveId);

	/**
	 * ϵͳ������ʷ��ѯ
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public List<SysApprove> querySystemApproveHistory(Map map);

	/**
	 *  ��ѯ�뵱ǰ���뵥��ص����������������λ�;�����
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public List<ApproveChk> querySystemApproveHistoryDetail(String approveId);

}
