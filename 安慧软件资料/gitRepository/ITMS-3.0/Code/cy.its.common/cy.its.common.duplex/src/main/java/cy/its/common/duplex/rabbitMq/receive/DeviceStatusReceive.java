package cy.its.common.duplex.rabbitMq.receive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.mapData.DeviceStatusMapData;
import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;

/**
* @Title: DeviceStatus.java 
* @Package com.cy.rabbitMq.receive 
* @Description: �豸״̬
* @author lil@cychina.cn
* @date 2015��11��19�� ����3:28:12 
* @version V1.0   
 */
public class DeviceStatusReceive implements IMqReceiver{
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
    	JSONObject  jsonObject  = JSONObject.parseObject(message);
    	//���»���
    	DeviceStatusMapData.updateDevStatus(jsonObject);
		for(IWebscoketReceiver webscoketReceiver:list){	
		    try{
		    	status=webscoketReceiver.receive(jsonObject);
		    }catch(Exception e){
		    	continue;
		    }
			
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
