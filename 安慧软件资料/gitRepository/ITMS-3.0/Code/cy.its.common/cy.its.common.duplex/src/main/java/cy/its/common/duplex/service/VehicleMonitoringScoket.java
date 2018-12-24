package cy.its.common.duplex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

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
 * @Description: ������ص� webscoket ������
 * @author lil@cychina.cn
 * @date 2015��10��18�� ����7:31:04
 * @version V1.0
 */
public class VehicleMonitoringScoket extends WebscoketServiceImplA implements IWebscoketReceiver {

	private Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(VehicleMonitoringScoket.class);

	private final String routingKey = "its_pass_vehicle";
	/**
	 * ����KEY������ͬһ��
	 */
	private final String monitorKey = "vehicleMonitor";

	private VehicleMonitoringScoket() {
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
			Map<String, List<String>> siteMap = wsb.getParam();
			if (siteMap == null) {
				return;
			}
			siteMap.entrySet().stream().forEach(entry -> {
				String site = entry.getKey();
				List<String> directions = entry.getValue();
				// ����õ�λ�Ǽ�ط�Χ�ڵĵ�λ���ҷ�����ȷ
				if (jsonObject.get("siteCode").equals(site)
						&& inList(directions, (String) jsonObject.get("directionType"))) {
					JSONObject obj = new JSONObject();
					obj.put("wbskey", monitorKey);
					obj.put(monitorKey, jsonObject);
					TextMessage returnMessage = new TextMessage(obj.toJSONString());
					this.sendMessage(wsb, returnMessage);
				}
			});
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

	@Override
	public void deleteWebscoketSessionParam(WebSocketSession wss, Map wsbMap) {

		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);

		listbean.stream().filter(wbs -> wbs.equals(wss)).forEach(bean -> {
			Map<String, List<String>> siteMap = bean.getParam();
			wsbMap.entrySet().stream().forEach(item -> {
				Entry<String,List<String>> entry = (Entry<String,List<String>>)item;
				if(siteMap.get(entry.getKey()) != null){
					//ɾ���Ѽ����ķ��� 
					List<String> directionList = entry.getValue();
					List<String> oldList = siteMap.get(entry.getKey());
					for(String direction : directionList){
						for(int index=0; index<oldList.size(); index++){
							if(direction.equals(oldList.get(index))){
								oldList.remove(index--);
							}
						}
					}
					//���з���ɾ����ȥ���õ�λ�ļ���
					if(oldList.isEmpty()){
						siteMap.remove(entry.getKey());
					}
				}
			});
		});
	}

	@Override
	public void addWebscoketSessionParam(WebSocketSession wss, Map wsbMap) {

		CopyOnWriteArrayList<WebscoketSessionBean> listbean = maplistbean.get(monitorKey);

		listbean.stream().filter(wbs -> wbs.equals(wss)).forEach(bean -> {
			Map<String, List<String>> siteMap = bean.getParam();
			wsbMap.entrySet().stream().forEach(item -> {
				Entry<String,List<String>> entry = (Entry<String,List<String>>)item;
				if(siteMap.get(entry.getKey()) == null){
					List<String> directionList = new ArrayList<String>();
					siteMap.put(entry.getKey(), directionList);
				}
				siteMap.get(entry.getKey()).addAll(entry.getValue());
			});
		});
	}
}
