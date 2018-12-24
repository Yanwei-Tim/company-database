/**
 * @Title: TrafficWeatherReceive.java
 * @Package cy.its.common.duplex.rabbitMq.receive
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��12��9�� ����3:06:48
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.common.duplex.rabbitMq.receive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;
import cy.its.platform.common.utils.RedisPoolUtil;

public class TrafficWeatherReceive implements IMqReceiver{
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
		RedisPoolUtil.hset("tf:weather",jsonObject.getString("deviceSysNbr"), message);
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
