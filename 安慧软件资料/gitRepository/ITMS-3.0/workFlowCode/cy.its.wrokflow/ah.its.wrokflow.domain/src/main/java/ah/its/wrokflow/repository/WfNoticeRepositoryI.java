package ah.its.wrokflow.repository;

import java.util.List;
import java.util.Map;

import ah.its.wrokflow.repository.dao.WfNotice;

/**
* @Title: WfNoticeRepositoryI.java 
* @Package ah.its.wrokflow.repository 
* @Description: TODO(��һ�仰�������ļ���ʲô) 
* @author lil@cychina.cn
* @date 2016��5��28�� ����4:28:46 
* @version V1.0   
 */
public interface WfNoticeRepositoryI {
	
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
