package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.dto.DeviceApproveDto;
import ah.its.wrokflow.repository.dao.DeviceApprove;

/**
* @Title: ApproveFormActionI.java 
* @Package cy.its.wrokflow.approve.action 
* @Description: ��Ҫ�����豸���뵥 
* @author lil@cychina.cn
* @date 2016��3��28�� ����8:36:52 
* @version V1.0   
 */
public interface DeviceApproveFormActionI {
	
	/** 
	* @Description: TODO(������һ�仰�����������������) 
	* @param @param form
	* @param @return  ���� ʧ��0  �ɹ�1 
	* @return Map    �������� 
	* @throws 
	*/
	public Map   saveDeviceApprove(DeviceApprove form);
	
	
	/** 
	* @Description: �������뵥
	* @param @param form
	* @param @return   ���ر�־ ʧ��1 �ɹ�0 
	* @return Map    �������� 
	* @throws 
	*/
	public Map   updateDeviceApprove(DeviceApprove form);
	
	/** 
	* @Description: ����ɾ�����뵥
	* @param @param String
	* @param @return   ����ֵ  �ɹ�1  ʧ��0 
	* @return Map    �������� 
	* @throws 
	*/
	public Map   deleteDeviceApprove(String ids);
	
	/** 
	* @Description: �豸DTO���ղ���
	* @param @param dto
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map   queryDeviceApprove(DeviceApproveDto dto);
	
	/** 
	* @Description: �ύ���뵥 
	* @param @param processId
	* @param @param deviceApproveId
	* @param @return �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map  submitDeviceApprove(String processId,String deviceApproveId);


	/** 
	* @Description: �������뵥���ύ
	* @param @param form
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map saveDeviceApproveSubmit(DeviceApprove form);


	/** 
	* @Description: ͨ��ID��ȡ���뵥���ݣ�ͬʱ��ѯ���Ѿ��������ļ�¼��
	* @param @param approveId
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map queryDeviceApproveDataById(String approveId);


	/** 
	* @Description: �޸�����ʱ��ȡ�����е�����
	* @param @param approveId
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map queryDeviceApproveById(String approveId);



	/**
	 * ������ʷ��¼��ѯ
	 * @param dto
	 * @return
	 */
	public Map queryDeviceApproveHistory(DeviceApproveDto dto);

	/**
	 * ������ʷ��¼����
	 * @param dto
	 * @return
	 */
	//public Map queryDeviceApproveHistoryDetail(String approveId);
}
