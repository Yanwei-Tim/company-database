package ah.its.wrokflow.repository;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.CommonBaseObj;

/**
* @Title: CommonBaseRepositoryI.java 
* @Package ah.its.wrokflow.repository 
* @Description: ͨ�û�ȡ���ݷ���
* @author lil@cychina.cn
* @date 2016��5��28�� ����10:29:02 
* @version V1.0   
 */
public interface CommonBaseRepositoryI {
	
	/**
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException  
	* @Description:���÷����ȡ mapper�еķ����������������������������
	* @param @param map
	* @param @param method
	* @param @return    �趨�ļ� 
	* @return List<CommonBaseObj>    �������� 
	* @throws 
	*/
	public List<CommonBaseObj> selectAllData(Map map,String method) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
}
