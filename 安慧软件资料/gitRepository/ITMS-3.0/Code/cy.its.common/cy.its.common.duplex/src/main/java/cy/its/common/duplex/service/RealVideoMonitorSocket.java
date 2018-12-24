/**
 * @Title: DeviceMonitorScoket.java
 * @Package com.cy.task.service
 * @Description: �豸״̬��ص� webscoket ������
 * @author chenzhiying chenzy@cychina.cn
 * @date 2015��11��18�� ����8:41:28
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.common.duplex.service;

import java.util.List;
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
  * @ClassName: DeviceMonitorScoket
  * @Description: ��Ƶ�豸״̬��ص� webscoket ������
  * @author jinhaibo jinhb@cychina.cn
  * @date 2015��11��18�� ����8:41:28
  *
  */

public class RealVideoMonitorSocket  extends WebscoketServiceImplA implements IWebscoketReceiver{
	
	/*
	 * ��־
	 */
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(DeviceMonitorScoket.class);
	
	
	private final String routingKey="its_status_result_for_upgrade";
	
	/**
	 * ����KEY������ͬһ��
	 */
	private final String monitorKey="realVideoMonitor";
	
	
	private RealVideoMonitorSocket(){
		IMqReceiver receive = MQEntrance.getIreceivermap().get(routingKey);
		receive.addReciveObject(this);
	}
	/*
	  * <p>Title: receive</p>
	  * <p>Description: </p>
	  * @param arg0
	  * @param arg1
	  * @return
	  * @see cy.its.service.common.rabbitmqClient.IReceiver#receive(java.lang.String, java.lang.String)
	  */	
	
	@Override
	public Boolean receive(JSONObject  jsonObject) {
		//���ݲ������ֱ��ȡ������������
		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);
		
		listbean.stream().forEach(wsb->{
			List<String> temp = (List<String>) wsb.getParam().get("devSysNbrs");
			if (temp.contains(jsonObject.get("deviceSysNbr").toString())) {
		    	JSONObject  obj   = new JSONObject();
		    	obj.put("wbskey", monitorKey);
		    	obj.put(monitorKey, jsonObject.toJSONString());
		    	TextMessage returnMessage = new TextMessage(obj.toJSONString());
		    	this.sendMessage(wsb, returnMessage);
		    }
        });
		return true;
	}

}
