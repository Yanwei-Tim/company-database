package ah.its.wrokflow.domain;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.WfNotice;

/**
* @Title: WfMessageServiceI.java 
* @Package ah.its.wrokflow.domain 
* @Description:��Ϣ������
* @author lil@cychina.cn
* @date 2016��5��28�� ����4:46:18 
* @version V1.0   
 */
public interface WfNoticeServiceI {
	
	/**
	 * ����notice����
	 */
	public List<WfNotice> queryNoticesByRecord(WfNotice notice);
	/**
	 * ���
	 * @param message
	 * @return
	 */
	public int insertBatch(Map map);
}
