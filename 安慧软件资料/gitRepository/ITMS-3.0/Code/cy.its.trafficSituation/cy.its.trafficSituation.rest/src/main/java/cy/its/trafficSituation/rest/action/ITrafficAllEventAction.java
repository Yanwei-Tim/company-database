package cy.its.trafficSituation.rest.action;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * @author 
 *
 */
public interface ITrafficAllEventAction {
   
	/** 
	* @Description: ���ݴ����KEYS��ȡ�����ֵ�����
	* @param @param alarmType 1 ���� 2���ܼ��� 3 ·�� 4 �豸��⣬deviceSysNbr �豸����
	* @param @return �趨�ļ� 
	* @return Map ��������  ����ҳ������
	* @throws 
	*/
	public JSONObject  queryAllTrafficAlarmEvent(String alarmType,String deviceSysNbr,String startDate,String endDate,String curPage,String pageSize);
	
}
