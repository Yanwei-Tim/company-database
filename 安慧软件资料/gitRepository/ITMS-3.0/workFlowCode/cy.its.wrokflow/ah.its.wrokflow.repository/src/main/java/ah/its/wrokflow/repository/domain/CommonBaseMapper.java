package ah.its.wrokflow.repository.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.CommonBaseObj;

public interface CommonBaseMapper {
	
	/** 
	* @Description: ��ȡ�������е�����
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<CommonBaseObj>    �������� 
	* @throws 
	*/
	List<CommonBaseObj> selectTaskByGroup(Map map);
	
	
	/** 
	* @Description: ��ȡ�Լ����е�����
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<CommonBaseObj>    �������� 
	* @throws 
	*/
	List<CommonBaseObj> selectTaskByUser(Map map);
	
	/** 
	* @Description: ���ҵ�ǰ�û���֪ͨ
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<CommonBaseObj>    �������� 
	* @throws 
	*/
	List<CommonBaseObj> selectNoticeByUser(Map map);
	
	/** 
	* @Description: ��ȡ��������������������
	* @param @param map
	* @param @return    �趨�ļ� 
	* @return List<CommonBaseObj>    �������� 
	* @throws 
	*/
	List<CommonBaseObj> selectDevChkByGroup(Map map);
	List<CommonBaseObj> selectSysChkByGroup(Map map);
	List<CommonBaseObj> selectSysCompleteChkByGroup(Map map);
}
