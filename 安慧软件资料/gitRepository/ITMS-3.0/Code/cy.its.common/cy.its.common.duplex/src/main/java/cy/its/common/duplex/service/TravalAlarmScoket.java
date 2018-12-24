/**
 * @Title: TravalAlarmScoket.java
 * @Package cy.its.common.duplex.service
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��12��22�� ����5:57:15
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

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

public class TravalAlarmScoket  extends WebscoketServiceImplA implements IWebscoketReceiver{
	/*
	 * ��־
	 */
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(TravalAlarmScoket.class);
	
	private final String routingKey="its_traval_alarm";
	/**
	 * ����KEY������ͬһ��
	 */
	private final String monitorKey="travalAlarm";
	
	private TravalAlarmScoket(){
		IMqReceiver receive = MQEntrance.getIreceivermap().get(routingKey);
		receive.addReciveObject(this);
	}
	
	@Override
	public Boolean receive(JSONObject  jsonObject) {
		
		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);
		
		listbean.stream().forEach(wsb->{
			String orgCode = wsb.getOrgCode();
		    String  orgAuthorityCode = jsonObject.getString("orgAuthorityCode");
		    //if(orgAuthorityCode.startsWith(orgCode)){
		    	JSONObject  obj   = new JSONObject();
		    	obj.put("wbskey", monitorKey);
		    	obj.put(monitorKey, jsonObject.toJSONString());
		    	TextMessage returnMessage = new TextMessage(obj.toJSONString());
		    	this.sendMessage(wsb, returnMessage);
		    //}
        });
		return true;
	}
}
