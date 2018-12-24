package cy.its.service.analysisAlarm.module;

import java.util.Date;

import oracle.net.aso.a;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

import cy.its.service.analysisAlarm.domain.GlobalProperty;
import cy.its.service.analysisAlarm.domain.WeatherAlarm;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.util.DBUtil;

/**
* @Title: TrafficEventModule.java 
* @Package cy.its.service.analysisAlarm.module 
* @Description:�豸ץ�ĵ��¼�������¼����ӳٳ�����ֵ��������
* @author lil@cychina.cn
* @date 2015��12��16�� ����2:43:53 
* @version V1.0   
 */
public class TrafficEventModule implements IReceiver {
	/*
	 *��־
	 */
	private static  Logger log=Logger.getLogger(TrafficEventModule.class);
	
	@Override
	public Boolean receive(String routingKey, String message) {
		
		WeatherAlarm alarm = JSONObject.parseObject(message,WeatherAlarm.class);
		alarm.setAlarmEventId(AlarmUtil.generatorId());
		alarm.setAlarmGrade("-");
		alarm.setEndAlarmTime(alarm.getStartAlarmTime());
		try {
			Date startTime  = alarm.getStartAlarmTime();
			if(startTime != null ){
				DBUtil.execute(AlarmUtil.getSql(alarm));
				//С�ڰ�Сʱ�����ݣ���Ҫ���͵�����
				if((new Date().getTime() -startTime.getTime()) < GlobalProperty.getDelayTime()*1000*60){
					//����MQ��Ϣ
					MQGateWay.publish("its_traffic_event_alarm",JSONObject.toJSONString(alarm));
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.error("��ȡSQL���������⣡");
			log.error(e);
		}
		return true;
	}

}
