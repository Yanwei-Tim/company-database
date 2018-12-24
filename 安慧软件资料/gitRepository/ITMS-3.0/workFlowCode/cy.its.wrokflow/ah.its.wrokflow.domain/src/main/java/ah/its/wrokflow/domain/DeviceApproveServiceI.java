package ah.its.wrokflow.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.ApproveChk;
import ah.its.wrokflow.repository.dao.DeviceApprove;
import ah.its.wrokflow.repository.dao.DeviceApproveResult;

/**
* @Title: DeviceApproveServiceI.java 
* @Package ah.its.wrokflow.domain 
* @Description: ���뵥ҵ������ 
* @author lil@cychina.cn
* @date 2016��4��19�� ����7:59:44 
* @version V1.0   
 */
public interface DeviceApproveServiceI {
	
	/** 
	* @Description: �����豸���뵥 
	* @param @param record
	* @param @return    �趨�ļ� 
	* @return int    �������� 
	* @throws 
	*/
	public  int  saveDeviceApprove(DeviceApprove record);
	
	
	/** 
	* @Description: ����ʵ��ID�����µ����뵥��
	* @param @param record
	* @param @return    �趨�ļ� 
	* @return int    �������� 
	* @throws 
	*/
	public  int  updateDeviceApprove(DeviceApprove record);


	/** 
	* @Description:��ѯ���뵥
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<DeviceApprove>    �������� 
	* @throws 
	*/
	public  List<DeviceApprove> selectAllData(Map map);


	/** 
	* @Description:ɾ�����뵥
	* @param @param map    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public int deleteDeviceApprove(Map map);


	public DeviceApprove queryDeviceApproveById(String approveId);

	/**
	 * ��������ʷ��ѯ
	 * @param map
	 * @return
	 */
	public List<DeviceApprove> queryDeviceApproveHistory(Map map);


	/**
	 * ������ʷ��¼����
	 * @param approveId
	 * @return
	 */
	public List<ApproveChk> queryDeviceApproveHistoryDetail(String approveId);

}
