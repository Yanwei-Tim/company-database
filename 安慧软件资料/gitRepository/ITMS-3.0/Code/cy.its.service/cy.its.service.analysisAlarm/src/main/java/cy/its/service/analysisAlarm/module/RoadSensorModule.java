package cy.its.service.analysisAlarm.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.service.analysisAlarm.domain.GlobalProperty;
import cy.its.service.analysisAlarm.domain.RoadSensor;
import cy.its.service.analysisAlarm.domain.TrafficAlarmValue;
import cy.its.service.analysisAlarm.domain.VisibilityData;
import cy.its.service.analysisAlarm.domain.WeatherAlarm;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.util.DBUtil;
import cy.its.service.util.RedisPoolUtil;

/**
* @Title: RoadSensorModule.java 
* @Package cy.its.service.weather.module 
* @Description: ·�з�������Ԥ��
* @author lil@cychina.cn
* @date 2015��11��14�� ����10:25:24 
* @version V1.0   
 */
public class RoadSensorModule implements IReceiver{
	/*
	 *��־
	 */
	private static  Logger log=Logger.getLogger(RoadSensorModule.class);
	/* (non-Javadoc)
	 * @see cy.its.service.com.rabbitmqClient.IReceiver#receive(java.lang.String, java.lang.String)
	 * Ԥ����Ϊ���֣�·���¶ȡ���·��ѩԤ����·���ˮ
	 */
	@Override
	public Boolean receive(String arg0, String jsonObject) {
		//·���¶ȣ�·��״��
		RoadSensor vp = JSONObject.parseObject(jsonObject,RoadSensor.class);
		//·���¶ȷ���
		processRoadSensor(vp,"temperature");
		//��·״������
		processRoadSensor(vp,"roadCondtion");
		//ˮĤ��ȷ���
		processRoadSensor(vp,"waterThickness");
		
		return true;
	}

	
	private void processRoadSensor(RoadSensor vp,String  key) {
		String     deviceSysNbr  = vp.getDeviceSysNbr();
		//��������������ڳ������������Ԥ��
		String  jsonStr  = RedisPoolUtil.hget("alarm:"+key,deviceSysNbr);
		if(jsonStr == null){
			//��һ�η�������
			List<WeatherAlarm>  list  = new ArrayList();
			//���㵱ǰ���ݵ�״̬  alarmGrade = "0" ����
			WeatherAlarm  alarm = getRoadSensorStatus(vp,key);
			list.add(alarm);
			RedisPoolUtil.hset("alarm:"+key,vp.getDeviceSysNbr(),JSONArray.toJSONString(list));
		}else{
			//���㵱ǰ���ݵ�״̬  alarmGrade = "0" ��״̬
			WeatherAlarm  alarm = getRoadSensorStatus(vp,key);
			List<WeatherAlarm>  list= JSONArray.parseArray(jsonStr,WeatherAlarm.class);
			list  = list.stream().sorted((a,b)->{
				return (int) (a.getEndAlarmTime().getTime() - b.getEndAlarmTime().getTime());
			}).collect(Collectors.toList());
			//�����������ڣ�����Ԥ�����򱨾������ ����Ԥ���ȼ�����ͬ��
			WeatherAlarm  lastAlarm = list.get(list.size()-1);
			//��������ӳ�����Ԥ����ֱ������
			Date  recordTime  = alarm.getStartAlarmTime();
			Date  lastRecordTime  = lastAlarm.getEndAlarmTime();
			if(recordTime == null || lastRecordTime == null){
				return;
			}else{
				if(alarm.getStartAlarmTime().getTime() < lastAlarm.getEndAlarmTime().getTime()){
					return;
				}else{
					//����10���� ���ݳ������⣬��Ҫ���µ���������Ϣ���Ҳ���Ԥ��
					if((recordTime.getTime() -lastRecordTime.getTime()) > 1000*60*10){
						list =  new ArrayList();
						list.add(alarm);
						RedisPoolUtil.hset("alarm:"+key, vp.getDeviceSysNbr(),JSONArray.toJSONString(list));
						return;
					}
				}
			}
			//���������������ʱ����һ��Ԥ�����ڶ���ҲԤ��ʱ����������
			if(list.size() == 1){
				WeatherAlarm  firstAlarm = list.get(0);
				if(firstAlarm != null && alarm != null){
					if(!"0".equals(firstAlarm.getAlarmGrade())||!"0".equals(alarm.getAlarmGrade())){
						//����Ԥ��
						warnData(alarm,key);
					}
				}
			}
			//�����������ڣ�����Ԥ��
			if(list.size() > 1){
				//��һ������
				WeatherAlarm  firstAlarm = list.get(0);
				//��Ϊ�տ�ʼ����Ԥ��
				if(firstAlarm != null && lastAlarm != null){
					//firstAlarm ״̬��������lastAlarm�� alarmͬʱ������ֵ��Ԥ��
					if("0".equals(firstAlarm.getAlarmGrade())){
						if(!"0".equals(lastAlarm.getAlarmGrade())&&!"0".equals(alarm.getAlarmGrade())){
							//����Ԥ��
							warnData(alarm,key);
						}
					}else{
						//�ڶ��������������� ����
						if("0".equals(lastAlarm.getAlarmGrade())&&"0".equals(alarm.getAlarmGrade())){
							//������Ϣ�������
							MQGateWay.publish("its_"+key+"_alarm",JSONObject.toJSONString(alarm));
						}
						//�ڶ��� ��������ͬԤ�������µڶ���Ԥ���Ľ���ʱ��
						if(lastAlarm.getAlarmGrade().equals(alarm.getAlarmGrade())&&!"0".equals(alarm.getAlarmGrade())){
							//���³���ʱ��
							warnUpdateData(lastAlarm,alarm);
						}else{
							//����Ԥ��
							if(!"0".equals(lastAlarm.getAlarmGrade())&&!"0".equals(alarm.getAlarmGrade())){
								warnData(alarm,key);
							}
						}
					}
				}
			}
			if(list.size()>=2){
				list.remove(0);
			}
			list.add(alarm);
			//��Żػ�����
			RedisPoolUtil.hset("alarm:"+key, vp.getDeviceSysNbr(),JSONArray.toJSONString(list));
		   }
	}
	private void warnData(WeatherAlarm alarm,String key){
		try {
			//ֻҪ״̬�仯����Ҫ����������
			String  sql= AlarmUtil.getSql(alarm);
			//��Ϊ0����������ݣ�Ϊ��ֻ����
			DBUtil.execute(sql);
			//����Ԥ����Ϣ������MQ��
			MQGateWay.publish("its_"+key+"_alarm",JSONObject.toJSONString(alarm));
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			log.error("���Ԥ����⼰����ʧ�ܣ�");
			log.error(e);
			//���ʧ��Ҫ������������Ȼ��ѭ������
		}
	}
	/** 
	* @Title: warnUpdateData 
	* @Description: ����Ԥ������ʱ��
	* @param @param alarm  �趨�ļ� 
	* @return void �������� 
	*/
	private void warnUpdateData(WeatherAlarm lastAlarm,WeatherAlarm alarm){
		log.info("����״̬����ʱ�䣡");
		DBUtil.execute(AlarmUtil.getUpdateSql(lastAlarm,alarm.getStartAlarmTime()));
	}

	/** 
	* @Title: getRoadSensorStatus 
	* @Description: ��װԤ���� 
	* @param @param vp
	* @param @param key
	* @param @return  �趨�ļ� 
	* @return WeatherAlarm  �������� 
	* @throws 
	*/
	private WeatherAlarm getRoadSensorStatus(RoadSensor vp, String key) {
		WeatherAlarm  alarm= new WeatherAlarm();
		alarm.setAlarmEventId(AlarmUtil.generatorId());
		alarm.setDeviceSysNbr(vp.getDeviceSysNbr());
		alarm.setOrgPrivilegeCode(vp.getOrgPrivilegeCode());
		alarm.setOrgCode(vp.getOrgCode());
		alarm.setSiteCode(vp.getSiteCode());
		alarm.setStartAlarmTime(vp.getRecordTime());
		alarm.setEndAlarmTime(vp.getRecordTime());
		alarm.setDeviceId(vp.getDeviceId());
		
		alarm.setAlarmGrade("0");//��״̬����
		if(key.equals("temperature")){
			alarm.setAlarmEventType(AlarmUtil.alarmEventTypeW);
			alarm.setSubAlarmEvent(AlarmUtil.TYPE_5022);
			alarm.setWeatherData(vp.getRoadbedTemperature()+"");
			List<TrafficAlarmValue> list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTyper);
			if(list == null){
				CacheManager.initWarnList(CacheManager.alermTyper,"");
				 CacheManager.getTrafficAlarmDataList(CacheManager.alermTyper);
			}
			for(TrafficAlarmValue tdv:list){
				if(vp.getRoadbedTemperature()>tdv.getMin() && vp.getRoadbedTemperature() <=tdv.getMax()){
					alarm.setAlarmGrade(tdv.getAlermGrade());
					alarm.setAlarmValueId(tdv.getMin()+","+tdv.getMax());
				}
			}
			alarm.setAlarmDesc("�¶�Ԥ���ȼ�Ϊ��"+alarm.getAlarmGrade());
		}
		if(key.equals("roadCondtion")){
			alarm.setAlarmEventType(AlarmUtil.alarmEventTypeW);
			alarm.setSubAlarmEvent(AlarmUtil.TYPE_5025);
			alarm.setWeatherData(vp.getRoadCondition()+"");
			List<TrafficAlarmValue> list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypeice);
			if(list == null){
				CacheManager.initWarnList(CacheManager.alermTypeice,"");
				list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypeice);
			}
			for(TrafficAlarmValue tdv:list){
				double config  = Double.valueOf(vp.getRoadCondition());
				if(config==tdv.getMax()){
					alarm.setAlarmGrade(vp.getRoadCondition());
					alarm.setAlarmValueId(tdv.getMax()+","+tdv.getMax());
				}
			}
			alarm.setAlarmDesc("��·״��Ԥ���ȼ�Ϊ��"+alarm.getAlarmGrade());
		}
		if(key.equals("waterThickness")){
			alarm.setAlarmEventType(AlarmUtil.alarmEventTypeW);
			alarm.setSubAlarmEvent(AlarmUtil.TYPE_5023);
			alarm.setWeatherData(vp.getWaterFileHeigh()+"");
			List<TrafficAlarmValue> list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypewt);
			if(list == null){
				CacheManager.initWarnList(CacheManager.alermTypeice,"");
				list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypewt);
			}
			for(TrafficAlarmValue tdv:list){
				if(vp.getWaterFileHeigh()>tdv.getMin() && vp.getWaterFileHeigh() <=tdv.getMax()){
					alarm.setAlarmGrade(tdv.getAlermGrade());
					alarm.setAlarmValueId(tdv.getMin()+","+tdv.getMax());
				}
			}
			alarm.setAlarmDesc("ˮĤ���Ԥ���ȼ�Ϊ��"+alarm.getAlarmGrade());
		}
		return alarm;
	}
}
