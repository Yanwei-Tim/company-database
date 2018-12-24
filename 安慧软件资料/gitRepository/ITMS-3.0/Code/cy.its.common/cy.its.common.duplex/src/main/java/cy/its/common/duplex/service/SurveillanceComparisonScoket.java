package cy.its.common.duplex.service;

import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.domain.WebscoketSessionBean;
import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;
import cy.its.common.duplex.rabbitMq.MQEntrance;
import cy.its.common.duplex.service.impl.WebscoketServiceImplA;
import cy.its.platform.common.utils.Log4jFactoryProxy;

/**
* @Title: SurveillanceComparisonScoket.java 
* @Package com.cy.task.service 
* @Description:���رȶԵ�˫ͨ����
* @author lil@cychina.cn
* @date 2015��10��27�� ����7:35:02 
* @version V1.0   
 */
public class SurveillanceComparisonScoket extends WebscoketServiceImplA implements IWebscoketReceiver{
	
	/*
	 * ��־
	 */
	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(SurveillanceComparisonScoket.class);
	
	
	private final String routingKey="comparison_services";
	/**
	 * ����KEY������ͬһ��
	 */
	private final String monitorKey="surveillanceComparison";

	private SurveillanceComparisonScoket(){
		IMqReceiver receive = MQEntrance.getIreceivermap().get(routingKey);
		receive.addReciveObject(this);
	}

	@Override
	public Boolean receive(JSONObject  jsonObject) {
		//һ��Ԥ����Ϣ���ܰ������Ԥ����Ϣ������Ҫͳһ����
		JSONArray   array  = jsonObject.getJSONArray("vlist");
		jsonObject.remove("vlist");
		for(int i=0;i<array.size();i++){
			JSONObject  newJsonobj  = array.getJSONObject(i);
			newJsonobj.putAll(jsonObject);
			singleSend(newJsonobj);
		}
		return true;
	}


	private void singleSend(JSONObject newJsonobj) {
		//���ݲ������ֱ��ȡ������������
		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);
		
		listbean.stream().forEach(wsb->{
		    String  trackCharacter = newJsonobj.getString("trackCharacter");
		    if("2".equals(trackCharacter)){//�ؿ�ֻ�����Լ�
		    	String  userName  = newJsonobj.getString("trackName");
		    	if(userName.equals(wsb.getLoginName())){
			    	JSONObject  obj   = new JSONObject();
			    	obj.put("wbskey",monitorKey);
			    	obj.put(monitorKey, newJsonobj.toJSONString());
			    	TextMessage returnMessage = new TextMessage(obj.toJSONString());
			    	this.sendMessage(wsb, returnMessage);
		    	}
		    }else{
		    	//�������������ϵĶ����û�
		    	String  orgPrivilegeCode  = newJsonobj.getString("orgPrivilegeCode");
		    	String  orgCode  = wsb.getOrgCode()==null?"-":wsb.getOrgCode();
		    	if(orgPrivilegeCode.startsWith(orgCode)){
			    	JSONObject  obj   = new JSONObject();
			    	obj.put("wbskey",monitorKey);
			    	obj.put(monitorKey, newJsonobj.toJSONString());
			    	TextMessage returnMessage = new TextMessage(obj.toJSONString());
			    	this.sendMessage(wsb, returnMessage);
		    	}
		    }
        });
	}
}
