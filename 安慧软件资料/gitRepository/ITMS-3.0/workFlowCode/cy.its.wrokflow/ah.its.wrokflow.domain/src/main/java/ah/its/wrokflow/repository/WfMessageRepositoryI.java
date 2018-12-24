package ah.its.wrokflow.repository;

import java.util.List;

import ah.its.wrokflow.repository.dao.WfMessage;

/**
* @Title: WfMessageRepositoryI.java 
* @Package ah.its.wrokflow.repository 
* @Description:
* @author chengj@cychina.cn
* @version V1.0   
 */
public interface WfMessageRepositoryI {
	/**
	 * ����id��ѯ
	 */
	public WfMessage queryMessageById(String id);
	/**
	 * ����message����
	 */
	public List<WfMessage> queryMessagesByRecord(WfMessage message);
	/**
	 * ���
	 * @param message
	 * @return
	 */
	public int addMessage(WfMessage message);
	/**
	 * �޸�
	 * @param message
	 * @return
	 */
	public int updateMessage(WfMessage message);
	public int deleteMessageById(String messageId);
}
