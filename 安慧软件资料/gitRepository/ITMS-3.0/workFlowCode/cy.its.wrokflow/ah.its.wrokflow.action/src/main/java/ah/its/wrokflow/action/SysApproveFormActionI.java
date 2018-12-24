package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.dto.SystemApproveDto;
import ah.its.wrokflow.repository.dao.SysApprove;

/**
 * ϵͳ�걨Action�ӿ�
 * @Title: SystemApproveFormActionI.java
 * @Package ah.its.wrokflow.action
 * @Description: ϵͳ�걨����
 * @author chengf chengf@cychina.cn
 * @date 2016��6��13�� ����5:04:41
 * @version V1.0
 */
public interface SysApproveFormActionI {
	
	/**
	 * ����ϵͳ���뵥
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map saveSystemApprove(SysApprove form);
	
	/**
	 * �ύϵͳ���뵥
	 * @Description:����
	 * @param @param form
	 * @return Map    �������� 
	 * @throws
	 */
	public Map submitSystemApprove(String processId,String SystemApproveId);
	
	/**
	 * ���沢�ύϵͳ���뵥
	 * @Description:����
	 * @param @param form
	 * @return Map    �������� 
	 * @throws
	 */
	public Map saveSystemApproveSubmit(SysApprove form);
	
	/**
	 * ����ϵͳ���뵥
	 * @Description:����ϵͳ���뵥
	 * @param @param form
	 * @return Map    �������� 
	 * @throws
	 */
	public Map updateSystemApprove(SysApprove form);
	
	/**
	 * ����ɾ��ϵͳ���뵥
	 * @Description:����
	 * @param @param form
	 * @return Map    �������� 
	 * @throws
	 */
	public Map deleteSystemApprove(String ids);
	
	/**
	 * ������ѯϵͳ���뵥
	 * @Description:����
	 * @param @param form
	 * @return Map    �������� 
	 * @throws
	 */
	public Map querySystemApprove(SystemApproveDto dto);
	
	/**
	 * �������뵥id��ѯ���뵥����
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map querySystemApproveById(String approveId);
	
	/**
	 * ͨ��ID��ȡ���뵥���ݣ�ͬʱ��ѯ���Ѿ��������ļ�¼��
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map querySystemApproveDataById(String approveId);

	/**
	 * ϵͳ������ʷ��ѯ
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	Map querySystemApproveHistory(SystemApproveDto dto);

	/**
	 * ��ѯ��ʷ��¼����
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	//Map querySystemApproveHistoryDetail(String approveId);

}
