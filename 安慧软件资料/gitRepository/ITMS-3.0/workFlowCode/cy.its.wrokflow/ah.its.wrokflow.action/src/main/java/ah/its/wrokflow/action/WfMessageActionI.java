package ah.its.wrokflow.action;

import java.util.Map;

import ah.its.wrokflow.dto.Message;

/**
* @Title: WfMessageActionI.java 
* @Package ah.its.wrokflow.action 
* @Description: ֪ͨ����controller�ӿ�
* @author chengj@cychina.cn
* @version V1.0   
 */
public interface WfMessageActionI {
	/**
	 * ����id��ѯ
	 */
	public Map queryMessageById(String id);
	/**
	 * ����idɾ��
	 */
	public Map deleteMessageById(String id);
	/**
	 * ����message����
	 */
	public Map queryMessagesByRecord(Message message);
	/**
	 * ���
	 * @param message
	 * @return
	 */
	public Map addMessage(Message message);
	/**
	 * �޸�
	 * @param message
	 * @return
	 */
	public Map updateMessage(Message message);
}