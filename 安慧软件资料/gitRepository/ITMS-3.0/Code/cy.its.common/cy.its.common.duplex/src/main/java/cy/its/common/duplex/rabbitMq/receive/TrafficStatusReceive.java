package cy.its.common.duplex.rabbitMq.receive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;
import cy.its.platform.common.utils.RedisPoolUtil;

/**
* @Title: TrafficStatus.java 
* @Package com.cy.rabbitMq.receive 
* @Description: ·��
* @author lil@cychina.cn
* @date 2015��11��19�� ����3:19:19
* @version V1.0   
 */
public class TrafficStatusReceive implements IMqReceiver{
	
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
		for(IWebscoketReceiver webscoketReceiver:list){
			status=webscoketReceiver.receive(jsonObject);
		}
		//����״̬���ݷ���redis
		RedisPoolUtil.hset("tf:region",jsonObject.getString("regionalId"), message);
		//����������
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