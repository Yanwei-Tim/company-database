package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.repository.dao.CommonBaseObj;

/**
* @Title: CommonBaseActionI.java 
* @Package ah.its.wrokflow.action 
* @Description:ͨ��ȡ����
* @author lil@cychina.cn
* @date 2016��5��28�� ����10:43:22 
* @version V1.0   
 */
public interface CommonBaseActionI {
	/** 
	* @Description: ͨ��ȡ������
	* @param @param commonBaseObj
	* @param @return    �趨�ļ� 
	* @return Map    �������� 
	* @throws 
	*/
	public Map selectAllData(Map<String, Object> map);
}
