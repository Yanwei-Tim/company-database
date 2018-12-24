package cy.its.common.duplex.rabbitMq.receive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;

/**
* @Title: TrafficAuto.java 
* @Package com.cy.rabbitMq.receive 
* @Description: ��ͨ�¼�Ԥ��
* @author lil@cychina.cn
* @date 2015��11��19�� ����3:27:40 
* @version V1.0   
 */
public class TrafficAutoReceive implements IMqReceiver{
	/**
	 * ��ʱ����ע����Ϣ
	 */
    private  List<IWebscoketReceiver> list = new ArrayList<IWebscoketReceiver>();
    /**
     * ������෢����Ϣ
     */
    @Override
	public Boolean receive(String routingKey,String message) {
    	boolean status = true;
		for(IWebscoketReceiver webscoketReceiver:list){
			JSONObject  jsonObject  = JSONObject.parseObject(message);
			status=webscoketReceiver.receive(jsonObject);
		}
		return status;
	}

	
	/**
	 * ע��һ��������
	 */
	@Override
	public boolean addReciveObject(IWebscoketReceiver webscoketReceiver) {
		synchronized(this){
			list.add(webscoketReceiver);
		}
		return true;
	}
}
