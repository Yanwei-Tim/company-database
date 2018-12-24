package ah.its.wrokflow.repository;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.SysApprove;
import ah.its.wrokflow.repository.dao.SysApproveFile;

public interface SysApproveCompleteRepositoryI {

	
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
