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
 * @Title: VehicleMonitoringScoket.java
 * @Package com.cy.task.service
 * @Description: �豸���ϱ���
 * @author lil@cychina.cn
 * @date 2015��10��18�� ����7:31:04
 * @version V1.0
 */
public class ServerAbnormalStateSocket extends WebscoketServiceImplA implements IWebscoketReceiver {

	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(ServerAbnormalStateSocket.class);

	private final String routingKey = "its_alarm_device";
	/**
	 * ����KEY������ͬһ��
	 */
	private final String monitorKey = "serverAbnormalState";

	private ServerAbnormalStateSocket() {
		IMqReceiver receive = MQEntrance.getIreceivermap().get(routingKey);
		receive.addReciveObject(this);
	}

	/**
	 * @Title: processMessage @Description: ������Ϣ @param @param jsonObject
	 *         �趨�ļ� @return void �������� @throws
	 */
	public Boolean receive(JSONObject jsonObject) {

		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);

		listbean.stream().forEach(wsb -> {
			String orgPrivCode = (String) wsb.getParam().get("orgPrivCode");
			//�жϱ�������,ֻ���ܷ�����״̬����
			if(orgPrivCode != null && !orgPrivCode.isEmpty()
					&& "2".equals(jsonObject.getString("alarmType")) &&  jsonObject.getString("orgPrivilegeCode").startsWith(orgPrivCode)){
				JSONObject  obj   = new JSONObject();
		    	obj.put("wbskey", monitorKey);
		    	obj.put(monitorKey, jsonObject.toJSONString());
		    	TextMessage returnMessage = new TextMessage(obj.toJSONString());
		    	this.sendMessage(wsb, returnMessage);
			}
		});
		return true;
	}

	/**
	 * �ж�Ԫ���Ƿ���list��
	 * 
	 * @param array
	 *            �б�
	 * @param index
	 *            ����Ԫ��
	 * @return
	 */
	private boolean inList(List<String> array, String index) {
		return array.stream().filter(item -> 
			item.equals(index)
		).count() > 0;
	}
}
