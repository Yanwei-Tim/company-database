package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.dto.SystemApproveDto;
import ah.its.wrokflow.repository.dao.SysApprove;
import ah.its.wrokflow.repository.dao.SysApproveFile;

/**
* @Title: SysApproveCompleteFormActionI.java 
* @Package cy.its.wrokflow.approve.action 
* @Description: ϵͳ���뽨���������(����)
* @author lil@cychina.cn
* @date 2016��3��28�� ����8:40:59 
* @version V1.0   
 */
public interface SysApproveCompleteFormActionI {
	
	/**
	 * @Description:����ϵͳ��������
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map saveSysApproveComplete(SysApproveFile form);

	/**
	 * �ύϵͳ��������
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map submitSysApproveComplete(String processId,String SystemApproveId);
	
	/**
	 * ���沢�ύϵͳ��������
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map saveSysApproveCompleteSubmit(SysApproveFile form);
	
	/**
	 * ����ϵͳ��������
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map updateSysApproveComplete(SysApproveFile form);
	
	/**
	 * ɾ��ϵͳ��������
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map deleteSysApproveComplete(String ids);
	
	/**
	 * ������ѯϵͳ��������
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map querySysApproveComplete(SystemApproveDto dto);
	
	/**
	 * ����id����ϵͳ��������
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map querySysApproveCompleteById(String approveId);
	
	/**
	 * ����id����ϵͳ�������룬����ѯ������¼
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	public Map querySysApproveCompleteDataById(String approveId);
	
	/**
	 * ϵͳ����������ʷ��ѯ
	 * @Description:����
	 * @param @param 
	 * @return Map    �������� 
	 * @throws
	 */
	Map querySysApproveCompleteHistory(SystemApproveDto dto);

}
