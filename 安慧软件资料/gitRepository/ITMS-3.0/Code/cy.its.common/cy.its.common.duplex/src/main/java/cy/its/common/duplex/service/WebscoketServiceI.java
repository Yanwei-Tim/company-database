package cy.its.common.duplex.service;

import java.util.Map;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import cy.its.common.duplex.domain.WebscoketSessionBean;

/**
 * @author lilei
 * ����ӿ��࣬���弸������
 */
public interface WebscoketServiceI {
	/**
	 * @param wsb
	 * ����
	 */
	public void  addWebscoketSessionBean(WebscoketSessionBean wsb,String key);
	
	/**
	 * @param wsb
	 * �޸�
	 */
	public void  updateWebscoketSessionBean(WebSocketSession ws,Map param,String key);
	
	
	/**
	 * @param wsb
	 * ɾ��
	 */
	public void  deleteWebscoketSessionBean(WebSocketSession ws,String key);
	
	/**
	 * @param ws
	 * @param txMessage
	 * @return
	 * ���ýӿڷ�����Ϣ
	 */
	public void  sendMessage(WebscoketSessionBean wb,TextMessage txMessage);
	
	/** 
	* @Title: deleteWebscoketSessionParam 
	* @Description: ɾ������ 
	* @param @param wss
	* @param @param wsbMap    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public void  deleteWebscoketSessionParam(WebSocketSession wss, Map wsbMap);

	/** 
	* @Title: addWebscoketSessionParam 
	* @Description:���Ӳ���
	* @param @param wss
	* @param @param wsbMap    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public void addWebscoketSessionParam(WebSocketSession wss, Map wsbMap);
	
}
