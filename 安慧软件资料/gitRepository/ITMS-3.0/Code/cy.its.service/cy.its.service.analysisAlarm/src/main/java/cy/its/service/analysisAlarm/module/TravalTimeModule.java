package cy.its.service.analysisAlarm.module;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import cy.its.service.analysisAlarm.domain.GlobalProperty;
import cy.its.service.analysisAlarm.domain.TrafficAlarmValue;
import cy.its.service.analysisAlarm.domain.WeatherAlarm;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.util.DBUtil;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.StringUtils;

/**
* @Title: TravalTimeModule.java 
* @Package cy.its.service.analysisAlarm.module 
* @Description:����ʱ�䳬������
* @author lil@cychina.cn
* @date 2015��12��17�� ����10:37:16 
* @version V1.0   
 */
public class TravalTimeModule implements IReceiver {

	private static  Logger log=Logger.getLogger(TravalTimeModule.class);
	
	private String   redisKey  = "alarm:traval";
	
	private  String  routeKey ="its_traval_alarm";
	/*
	 * (non-Javadoc)
	 * @see cy.its.service.common.rabbitmqClient.IReceiver#receive(java.lang.String, java.lang.String)
	 * �������ݣ�����Ҫ����ʱ��  һ��6 - 23 ���Ե���
	 */
	@Override
	public Boolean receive(String routingKey, String message) {
		//��������ʱ�䣬�������ڼ�ɾ��������Ϣ
		int startTime = GlobalProperty.getStartTime();
		int endTime = GlobalProperty.getStartTime();
	    int hour  = new Date().getHours();
	    //���ݼ�������
	    if(hour >= startTime && startTime <= endTime){
			//һ������һ����¼
			JSONObject  jsonObject = JSONObject.parseObject(message);
			//��ȡԤ�������Ϣ
			WeatherAlarm alarm = getRegionAlarm(jsonObject);
			String regionalId = jsonObject.getString("regionalId");
			String jsonStr = RedisPoolUtil.hget(redisKey,regionalId);//��ȡ�ϴλ��������
			if(!StringUtils.isEmpty(jsonStr)){
				WeatherAlarm  lastAlarm = JSONObject.parseObject(jsonStr,WeatherAlarm.class);
				//���»���
				if(!lastAlarm.getAlarmGrade().equals(alarm.getAlarmGrade())){
					//�Ȳ������ݿ�
					try {
						//ֻҪ״̬�仯����Ҫ����������
						String  sql= AlarmUtil.getSql(alarm);
						DBUtil.execute(sql);
						//����Ԥ����Ϣ������MQ��
						MQGateWay.publish(routeKey,JSONObject.toJSONString(alarm));
						
					} catch (IllegalArgumentException | IllegalAccessException e) {
						log.error("ƽ������ʱ�䳬��Ԥ����⼰����ʧ�ܣ�");
						log.error(e);
					}
				}else{
					//״̬����һ����ͬʱ������¼�¼�����״̬Ϊ0 �򲻴���
					if(!lastAlarm.getAlarmGrade().equals("0")){
						log.info("����״̬����ʱ�䣡");
						DBUtil.execute(AlarmUtil.getUpdateSql(lastAlarm,alarm.getStartAlarmTime()));
					}
				}
			}else{
				if(!alarm.getAlarmGrade().equals("0")){
					MQGateWay.publish(routeKey,JSONObject.toJSONString(alarm));
				}
				RedisPoolUtil.hset(redisKey,regionalId,JSONObject.toJSONString(alarm));//��ȡ�ϴλ��������
			}
	    }
		return true;
	}

	/** 
	* @Title: getRegionAlarm 
	* @Description: ���ݴ����ֵ��ȡԤ����Ϣ
	* @param @param jsonObject
	* @param @return    �趨�ļ� 
	* @return WeatherAlarm    �������� 
	* @throws 
	*/
	private WeatherAlarm getRegionAlarm(JSONObject jsonObject) {
		WeatherAlarm  alarm= new WeatherAlarm();
		//����ÿ�����ʱ
		double speed = jsonObject.getDouble("avgSpeed");
		double avgTime  = speed==0 ?0:3600*1.00/speed;
		alarm.setAlarmEventId(AlarmUtil.generatorId());
		alarm.setOrgCode(jsonObject.getString("orgCode"));
		alarm.setRegionalId(jsonObject.getString("regionalId"));
		alarm.setDeviceSysNbr("");
		alarm.setSiteCode("");
		alarm.setOrgPrivilegeCode(jsonObject.getString("orgPrivilegeCode"));
		alarm.setStartAlarmTime(jsonObject.getDate("updateTime"));
		alarm.setEndAlarmTime(jsonObject.getDate("updateTime"));
		alarm.setAlarmEventType(AlarmUtil.alarmEventTypeF);
		alarm.setSubAlarmEvent(AlarmUtil.TYPE_50604);
		alarm.setAlarmGrade("0");//��״̬����
		alarm.setWeatherData(jsonObject.getString("avgTravelTime"));
		//��ֵ���㣬ÿ����������С��ʱ��
		int min = new Date().getMinutes();
		List<TrafficAlarmValue> list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypetr);
		if(list == null){
			CacheManager.initWarnList(CacheManager.alermTypetr,"");
			list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypetr);
		}
		for(TrafficAlarmValue tdv:list){
			if(avgTime >tdv.getMin() && avgTime <=tdv.getMax()){
				alarm.setAlarmGrade(tdv.getAlermGrade());
				alarm.setAlarmValueId(tdv.getMin()+","+tdv.getMax());
			}
		}
		alarm.setAlarmDesc("��������ʱ�䳬��Ԥ���ȼ�Ϊ��"+alarm.getAlarmGrade());
		return alarm;
	}

}
