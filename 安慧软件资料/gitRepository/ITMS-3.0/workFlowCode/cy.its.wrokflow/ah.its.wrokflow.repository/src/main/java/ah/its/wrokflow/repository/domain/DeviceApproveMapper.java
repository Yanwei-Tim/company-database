package ah.its.wrokflow.repository.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.ApproveChk;
import ah.its.wrokflow.repository.dao.DeviceApprove;

public interface DeviceApproveMapper {
    int deleteByPrimaryKey(String deviceApproveId);

    int insert(DeviceApprove record);

    int insertSelective(DeviceApprove record);

    DeviceApprove selectByPrimaryKey(String deviceApproveId);

    int updateByPrimaryKeySelective(DeviceApprove record);

    int updateByPrimaryKey(DeviceApprove record);

	/** 
	* @Description: ��ȡ�û����ڲ��������е����뵥 
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<DeviceApprove>    �������� 
	* @throws 
	*/
	List<DeviceApprove> selectAllData(Map map);

	/**
	 * ��������ʷ��ѯ
	 * @param map
	 * @return
	 */
	List<DeviceApprove> queryDeviceApproveHistory(Map map);

	/**
	 * ������ʷ��¼����
	 * @param approveId
	 * @return
	 */
	List<ApproveChk> queryDeviceApproveHistoryDetail(String deviceApproveId);

}