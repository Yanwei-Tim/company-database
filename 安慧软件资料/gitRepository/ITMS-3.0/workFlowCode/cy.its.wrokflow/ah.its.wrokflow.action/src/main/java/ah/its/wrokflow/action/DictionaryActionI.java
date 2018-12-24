package ah.its.wrokflow.action;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
* @Title: DictionaryActionI.java 
* @Package ah.its.wrokflow.action 
* @Description: �����ֵ�rest ������
* @author lil@cychina.cn
* @date 2016��4��8�� ����5:42:27 
* @version V1.0   
 */
public interface DictionaryActionI {
	/** 
	* @Description: ���ݴ����KEYS��ȡ�����ֵ�����	
	* @param @param keys ֮����,����
	* @param @return �趨�ļ� 
	* @return Map �������� 
	* @throws 
	*/
	public JSONObject getAllDictionaryByKeys(String keys);
	
	
	
	/** 
	* @Description: ���ݵ�ǰ�û��Ĳ�����Ϣ��ȡ���������еĻ�����Ϣ
	* @param @param curOrgId
	* @param @return �趨�ļ� 
	* @return JSONObject �������� 
	* @throws 
	*/
	public JSONArray getOrgs(String curOrgId);
	
	
	
	/** 
	* @Description: ��������
	* @param @param key ����KEY 
	* @param @param parentCode ������� ��Դ�����������
	* @param @return    �趨�ļ� 
	* @return JSONObject    �������� 
	* @throws 
	*/
	public JSONObject getCascadeData(String key,String parentCode);



	/** 
	* @Description: ���ݲ��Ż�ȡ��������
	* @param @param curOrgId
	* @param @return    �趨�ļ� 
	* @return JSONArray    �������� 
	* @throws 
	*/
	public JSONArray getOrgChildren(String curOrgId);



	/** 
	* @Description: ��ȡ�˵������menuIdΪ�����ȡ���е�
	* @param @param curOrgId
	* @param @return    �趨�ļ� 
	* @return JSONArray    �������� 
	* @throws 
	*/
	public JSONArray getMenus(String menuId);



	/** 
	* @Description: ��ȡ��������Ϣ
	* @param @param groupId
	* @param @return    �趨�ļ� 
	* @return JSONArray    �������� 
	* @throws 
	*/
	public JSONArray getGroupTrees(String groupId);
	
}
