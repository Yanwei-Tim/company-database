/**
 * @Title: DeviceStatusMapData.java
 * @Package cy.its.common.duplex.mapData
 * @Description: TODO(����Ҫ��д��;)
 * @author Administrator Administrator@cychina.cn
 * @date 2015��12��23�� ����2:12:36
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.common.duplex.mapData;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.platform.common.model.DeviceGeneralStatusModel;
import cy.its.platform.common.utils.RedisPoolUtil;
import cy.its.service.common.rabbitmqClient.MQGateWay;

/**
 * @ClassName: DeviceStatusMapData
 * @Description: TODO(����Ҫ��д��;)
 * @author Administrator Administrator@cychina.cn
 * @date 2015��12��23�� ����2:12:37
 *
 */

public class DeviceStatusMapData {
	/*
	 * ����MQ��Ϣ
	 */
	public static void sendMqMessage() {

		MQGateWay.publish("its_query_request.status_result", "0");

	}

	public static Collection<DeviceGeneralStatusModel> getDeviceGeneralStatus() {
//		return statusMap.values();
		return null;
	}

	public static void load(String objList) {
		JSONArray array = JSONArray.parseArray(objList);
		synchronized (DeviceStatusMapData.class) {
			RedisPoolUtil.del("deviceStatus");
			for (Object obj : array) {
				try {
					JSONObject temp = (JSONObject) obj;
					RedisPoolUtil.hset("deviceStatus", temp.getString("deviceId"), JSONObject.toJSONString(temp));
				} catch (Throwable e) {
					e.printStackTrace();
				}

				// JSONArray.parseArray("", DeviceGeneralStatusModel.class);

				// RedisPoolUtil.hget(key, filed);

				// RedisPoolUtil.hgetAll("").values();

				// RedisPoolUtil.hset("deviceStatus",temp.getString("deviceId"),JSONObject.toJSONString(deviceStatus));
			}
		}
	}
 
	

	private static void convertStatusObj(DeviceGeneralStatusModel deviceStatus, JSONObject temp) {
		
//		deviceStatus.setStatusType(temp.getInteger("statusType"));
//		// ������ǰ�豸�Ĺ�������todo ���˵״̬���Ҫ����������
//		int bugType = 9;// Ĭ���豸����
//		JSONArray arrayStatusDetails = temp.getJSONArray("statusDetails");
//		// ����ǹ��ػ��豸���ù�����ֵ
//		if (arrayStatusDetails != null && arrayStatusDetails.size() > 0) {
//			if (arrayStatusDetails.contains(2))// ��������б����е�Դ���ϣ���Ϊ��Դ����
//			{
//				bugType = 2;
//			} else if (arrayStatusDetails.contains(6))// ��������б�����������ϣ���Ϊ�������
//			{
//				bugType = 6;
//			}
//		} else// ���������������ù�����ֵ������Ĺ����Ǵ����������������е�
//		{
//			arrayStatusDetails = temp.getJSONArray("componentStatus");
//			if (arrayStatusDetails != null) {
//				for (Object status : arrayStatusDetails) {
//					JSONObject tempStatus = (JSONObject) status;
//					if (tempStatus == null) {
//						continue;
//					}
//					JSONArray arrayDetails = tempStatus.getJSONArray("statusDetails");
//					if (arrayDetails.contains(2))// ��������б����е�Դ���ϣ���Ϊ��Դ����
//					{
//						bugType = 2;
//						break;
//					} else if (arrayStatusDetails.contains(6))// ��������б�����������ϣ���Ϊ�������
//					{
//						bugType = 6;
//						break;
//					}
//				}
//			}
//		}
//		deviceStatus.setStatusBugType(bugType);
	}

	/**
	 * updateDevStatus(���µ����豸״̬����) @Title: updateDevStatus @Description:
	 * ���µ����豸״̬���� @param @param obj �趨�ļ� @return void �������� @throws
	 */
	public static void updateDevStatus(JSONObject obj) {
		synchronized (DeviceStatusMapData.class) {
			//RedisPoolUtil.hget("deviceStatus", obj.getString("deviceId"))
			//�ж��Ƿ��Ѿ������˸��豸�����������£�û������
			if(RedisPoolUtil.hexists("deviceStatus", obj.getString("deviceId")))
			{
				RedisPoolUtil.hset("deviceStatus", obj.getString("deviceId"), JSONObject.toJSONString(obj));
			}
//			DeviceGeneralStatusModel deviceStatus = statusMap.get(obj.getString("deviceId"));
//			convertStatusObj(deviceStatus, obj);
//			statusMap.put(obj.getString("deviceId"), deviceStatus);
		}
	}
}
