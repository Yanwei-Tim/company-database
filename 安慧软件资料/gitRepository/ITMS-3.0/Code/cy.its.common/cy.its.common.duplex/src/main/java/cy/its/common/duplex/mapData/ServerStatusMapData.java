/**
 * @Title: ServerStatusMapData.java
 * @Package cy.its.common.duplex.mapData
 * @Description: TODO(����Ҫ��д��;)
 * @author Administrator Administrator@cychina.cn
 * @date 2015��12��28�� ����5:10:47
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.common.duplex.mapData;

import java.util.Collection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.platform.common.model.DeviceGeneralStatusModel;
import cy.its.platform.common.utils.RedisPoolUtil;
import cy.its.service.common.rabbitmqClient.MQGateWay;

/**
 * @ClassName: ServerStatusMapData
 * @Description: ���������������
 * @author chenzhiying
 * @date 2015��12��28�� ����5:10:47
 *
 */

public class ServerStatusMapData {
	/*
	 * ����MQ��Ϣ
	 */
	public static void sendMqMessage() {
		MQGateWay.publish("its_query_request.server_status_result", "0");
	}

	public static void load(String objList) {
		JSONArray array = JSONArray.parseArray(objList);
		synchronized (ServerStatusMapData.class) {
			RedisPoolUtil.del("serverStatus");
			for (Object obj : array) {
				try {
					JSONObject temp = (JSONObject) obj;
					RedisPoolUtil.hset("serverStatus", temp.getString("serverId"), JSONObject.toJSONString(temp));
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void updateServerStatus(JSONObject obj) {
		synchronized (ServerStatusMapData.class) {
			// �ж��Ƿ��Ѿ������˸÷����������������£�û������
			if (RedisPoolUtil.hexists("serverStatus", obj.getString("serverId"))) {
				RedisPoolUtil.hset("serverStatus", obj.getString("serverId"), JSONObject.toJSONString(obj));
			}
		}
	}

}
