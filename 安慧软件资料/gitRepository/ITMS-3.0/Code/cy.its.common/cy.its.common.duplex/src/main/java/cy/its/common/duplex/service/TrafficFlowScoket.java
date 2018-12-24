package cy.its.common.duplex.service;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.domain.WebscoketSessionBean;
import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;
import cy.its.common.duplex.rabbitMq.MQEntrance;
import cy.its.common.duplex.service.impl.WebscoketServiceImplA;
import cy.its.platform.common.utils.Log4jFactoryProxy;

/**
* @Title: TrafficFlowScoket.java 
* @Package com.cy.task.service 
* @Description:��ͨ����Ԥ��
* @author lil@cychina.cn
* @date 2015��10��30�� ����10:41:31 
* @version V1.0   
 */
public class TrafficFlowScoket  extends WebscoketServiceImplA implements IWebscoketReceiver{
	/*
	 * ��־
	 */
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(TrafficFlowScoket.class);
	
	
	private final String routingKey="its_section_flow";
	/**
	 * ����KEY������ͬһ��
	 */
	private final String monitorKey="trafficFlow";
	
	private TrafficFlowScoket(){
		IMqReceiver receive = MQEntrance.getIreceivermap().get(routingKey);
		receive.addReciveObject(this);
	}
	
	@Override
	public Boolean receive(JSONObject  jsonObject) {
		
		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);
		
		listbean.stream().forEach(wsb->{
			String orgCode = wsb.getOrgCode();
		    String  orgAuthorityCode = jsonObject.getString("orgAuthorityCode");
		   // if(orgAuthorityCode.startsWith(orgCode)){
		    	JSONObject  obj   = new JSONObject();
		    	obj.put("wbskey",monitorKey);
		    	obj.put(monitorKey, jsonObject.toJSONString());
		    	TextMessage returnMessage = new TextMessage(obj.toJSONString());
		    	this.sendMessage(wsb, returnMessage);
		    //}
        });
		return true;
	}
}
