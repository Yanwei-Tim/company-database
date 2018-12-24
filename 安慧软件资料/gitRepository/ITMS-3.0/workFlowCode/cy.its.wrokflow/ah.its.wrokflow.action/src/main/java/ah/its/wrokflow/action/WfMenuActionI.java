package ah.its.wrokflow.action;

import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ah.its.wrokflow.repository.dao.WfGroupMenu;

/**
* @Title: WfMenuActionI.java 
* @Package ah.its.wrokflow.action 
* @Description: �˵�controller�ӿ�
* @author chengj@cychina.cn
* @version V1.0   
 */
public interface WfMenuActionI {
	/**
	 * ����groupId���Ҳ˵�(�˵��㼶��ϵ������)
	 * @param groupId
	 * @return
	 */
	public Map queryMenuByGroupId(String groupId);
	/**
	 * ����groupId���Ҳ˵���ֱ�ӷ��ز˵��б�
	 * @param groupId
	 * @return
	 */
	public Map queryMenuListByGroupId(WfGroupMenu wfGroupMenu);
	/**
	 * �����֯���˵���Ӧ��ϵ��¼
	 * @param groupId
	 * @param menuIds menuId1��menuId2��menuId3������
	 * @return
	 */
	public Map addGroupMenuMapRecord(WfGroupMenu wfGroupMenu);
	JSONArray findMenuByGroupId(String menuId);
}