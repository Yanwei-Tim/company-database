package ah.its.wrokflow.domain;

import java.util.List;

import ah.its.wrokflow.repository.dao.WfMessage;

/**
* @Title: WfMessageDomainI.java 
* @Package ah.its.wrokflow.domain 
* @Description: ֪ͨ��������� 
* @author chengj@cychina.cn
* @version V1.0   
 */
public interface WfMessageDomainI {
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
