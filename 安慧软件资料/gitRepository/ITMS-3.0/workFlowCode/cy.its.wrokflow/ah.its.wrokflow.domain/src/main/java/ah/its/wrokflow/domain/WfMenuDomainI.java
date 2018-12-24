package ah.its.wrokflow.domain;

import java.util.List;

import ah.its.wrokflow.repository.dao.WfGroupMenu;
import ah.its.wrokflow.repository.dao.WfMenu;

/**
* @Title: WfMenuDomainI.java 
* @Package ah.its.wrokflow.domain 
* @Description: �˵����������� 
* @author chengj@cychina.cn
* @version V1.0   
 */
public interface WfMenuDomainI {
	/**
	 * ��groupId��ѯ�˵�
	 * @param groupId
	 * @return
	 */
	public List<WfMenu> queryMenuByGroupId(String groupId);
	/**
	 * �������Group Menu��Ӧ��ϵ
	 * @param records
	 * @return
	 */
	public int addGroupMenuMapRecord(List<WfGroupMenu> records);
	public int delGroupMenuMapRecord(String groupId);
}
