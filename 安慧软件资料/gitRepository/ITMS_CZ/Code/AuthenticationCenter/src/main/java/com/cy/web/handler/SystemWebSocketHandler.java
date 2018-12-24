package com.cy.web.handler;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSONObject;
import com.cy.web.GlobalProerty;
import com.cy.web.service.WebscoketServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import cy.its.common.duplex.domain.WebscoketSessionBean;
import cy.its.common.duplex.service.WebscoketServiceI;
import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.platform.common.utils.RedisPoolUtil;
/**
* @Title: SystemWebSocketHandler.java 
* @Package com.cy.web.handler 
* @Description:WEBSCOKET������
* @author lil@cychina.cn
* @date 2015��10��18�� ����4:33:16 
* @version V1.0   
 */
@Component
public class SystemWebSocketHandler implements WebSocketHandler {

	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(SystemWebSocketHandler.class);
	
	public  static  CopyOnWriteArrayList<WebSocketSession>  wsList;
	
	public  static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator"); 
	
	private ObjectMapper  mapper  = new ObjectMapper();
	
	private static Map  serviceMap;//webscoket����ע���ļ�
	
	static{
		wsList = new CopyOnWriteArrayList<WebSocketSession>();//WS����������
		serviceMap = getServiceMap();
	}
	
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    	log.info("����webscoket����һ��ɣ���ȴ��������ݣ�");//���������������
    	wsList.add(session);
    	log.info("��ǰ��"+wsList.size()+"������������webscoket����");//�ж�����������
    }

    private static Map getServiceMap() {
		// TODO Auto-generated method stub
    	String servicePath = "";
    	//�������ļ�
    	 if(FILE_SEPARATOR.equals("\\")) {  
             // ��ȡ���ݷ����������ļ���·��  
    		servicePath = GlobalProerty.getProjectPath() + "WEB-INF\\classes\\webscoket.properties";
         } else if(FILE_SEPARATOR.equals("/")) {  
        	 servicePath= GlobalProerty.getProjectPath() + "WEB-INF/classes/webscoket.properties";
        }  
		return getProperties(servicePath);
	}
    
    
	/**
	 * ��ȡ�����ļ�
	 * Ϊ��Ŀ�����ʼ����Ϣ
	 * ��Ŀ·����Ϣ
	 */
	private  static Map getProperties(String globalPath) {
		Map  map = new HashMap();
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(globalPath);
			prop.load(fis);
			fis.close();
			Iterator itr = prop.entrySet().iterator();
	        while (itr.hasNext()){
	            Entry e = (Entry)itr.next();
	            map.put(e.getKey(),e.getValue());
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/* (non-Javadoc)
     * @see org.springframework.web.socket.WebSocketHandler#handleMessage(org.springframework.web.socket.WebSocketSession,
     *  org.springframework.web.socket.WebSocketMessage)
     *  ������Ϣ���ı������
     */
    public void handleMessage(WebSocketSession wss, WebSocketMessage<?> wsm) throws Exception {
    	Map     paramMap = mapper.readValue(wsm.getPayload().toString(), Map.class);
    	String  wbskey = paramMap.get("wbskey")==null?"":paramMap.get("wbskey").toString();
    	String  className  = serviceMap.get(wbskey)==null?"":(String)serviceMap.get(wbskey);
    	String  method = paramMap.get("serviceMethod")==null?"":paramMap.get("serviceMethod").toString();
    	Map     wsbMap =  paramMap.get("param")==null?new HashMap():(HashMap)paramMap.get("param");
    	WebscoketServiceI wbsimpl= WebscoketServiceFactory.getSingleWebscoketServiceFactory().getServiceBean(wbskey, className);
    	
    	if("init".equals(method)){
    		String  token = paramMap.get("token")==null?"":paramMap.get("token").toString();
    		//ͨ��token��ȡ�û�����Ȩ�޴���
    		WebscoketSessionBean bean = new WebscoketSessionBean(wsbMap,wss,getUserInfo(token,"orgPrivCode"),getUserInfo(token,"userName"),wbskey);
    		wbsimpl.addWebscoketSessionBean(bean,wbskey);
    	}else if("addParam".equals(method)){
    		wbsimpl.addWebscoketSessionParam(wss,wsbMap);//���Ӳ���
    	}else if("deleteParam".equals(method)){
    		wbsimpl.deleteWebscoketSessionParam(wss,wsbMap);//ɾ������
    	}else{
    		wbsimpl.deleteWebscoketSessionBean(wss, wbskey);//ɾ������
    	}
    }

    /** 
    * @Title: getOrgCode 
    * @Description: ��ȡws�����û��˵�������Ϣ
    * @param @param token
    * @param @return    �趨�ļ� 
    * @return String    �������� 
    * @throws 
    */
    private String getUserInfo(String  token,String  filed) {
    	Map    map   = JSONObject.parseObject(RedisPoolUtil.get("VU:"+token), Map.class);
    	String  orgCode  = (String) map.get(filed);
		return orgCode;
	}

	public void handleTransportError(WebSocketSession wss, Throwable thrwbl) throws Exception {
        if(wss.isOpen()){
            wss.close();
        }
        log.error("WEBSCOKET�����쳣���رո����ӣ�������ˢ�£�");
    }

    /* (non-Javadoc)
     * @see org.springframework.web.socket.WebSocketHandler#afterConnectionClosed(org.springframework.web.socket.WebSocketSession,
     *  org.springframework.web.socket.CloseStatus)
     *  �������з���ɾ���Ự
     */
    public void afterConnectionClosed(WebSocketSession wss, CloseStatus cs) throws Exception {
    	wsList.remove(wss);
    	for (Object key:serviceMap.keySet()) {
    		String className  = serviceMap.get(key).toString();
    		Class<?> classType = Class.forName(className);
    		WebscoketServiceI wbsimpl = (WebscoketServiceI)classType.newInstance();
    		wbsimpl.deleteWebscoketSessionBean(wss,key.toString());
		}
    	log.info("websocket connection closed......");//ɾ����ǰ��
    }
    public boolean supportsPartialMessages() {
        return false;
    }
}
