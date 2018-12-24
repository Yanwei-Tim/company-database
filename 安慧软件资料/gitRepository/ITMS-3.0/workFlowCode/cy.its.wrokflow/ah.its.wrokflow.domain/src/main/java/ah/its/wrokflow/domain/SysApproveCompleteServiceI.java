package ah.its.wrokflow.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.SysApprove;
import ah.its.wrokflow.repository.dao.SysApproveFile;

/**
 * ���뵥ҵ������ 
 * @Title: SystemApproveServiceI.java
 * @Package ah.its.wrokflow.domain
 * @Description: TODO(����Ҫ��д��;)
 * @author chengf chengf@cychina.cn
 * @date 2016��6��13�� ����5:54:25
 * @version V1.0
 */
public interface SysApproveCompleteServiceI {
	
	/**
	 * ����ϵͳ���뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  int  saveSystemApproveComplete(SysApproveFile record);
	
	/**
	 * ����ʵ��ID�����µ����뵥��
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  int  updateSystemApproveComplete(SysApproveFile record);
	
	/**
	 * ��ѯ���뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  List<SysApproveFile>  selectAllData(Map map);
	
	/**
	 * ɾ�����뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public  int  deleteSystemApproveComplete(Map map);
	
	/**
	 * ����id�������뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public SysApproveFile querySystemApproveCompleteById(String approveId);

	/**
	 * ϵͳ������ʷ��ѯ
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public List<SysApprove> querySystemApproveCompleteHistory(Map map);


}
