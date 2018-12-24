package cy.its.service.analysisAlarm.module;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cy.its.service.analysisAlarm.domain.TrafficAlarmValue;
import cy.its.service.analysisAlarm.domain.VisibilityData;
import cy.its.service.analysisAlarm.domain.WeatherAlarm;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.util.DBUtil;
import cy.its.service.util.RedisPoolUtil;


/**
* @Title: VisibilityModule.java 
* @Package cy.its.service.analysisAlarm.module 
* @Description: �ܼ���Ԥ��,������������
* @author lil@cychina.cn
* @date 2015��12��16�� ����4:15:21 
* @version V1.0   
 */
public class VisibilityModule implements IReceiver{
	/*
	 *��־
	 */
	private static  Logger log=Logger.getLogger(VisibilityModule.class);
	
	/* (non-Javadoc)
	 * @see cy.its.service.com.rabbitmqClient.IReceiver#receive(java.lang.String, java.lang.String)
	 * �����ܼ�������
	 */
	@Override
	public Boolean receive(String arg0, String jsonObject) {
		//�ܼ���
		VisibilityData vp = JSONObject.parseObject(jsonObject,VisibilityData.class);
	    //�����л�ȡ���ݣ����ݽṹΪMAP key  field list
		//ÿ���ܼ����Ǳ���6������
		//���ڵ�����������Ԥ���ж�
		//��������������ڳ������������Ԥ��
		String  deviceSysNbr  = vp.getDeviceSysNbr();
		String  jsonStr  = RedisPoolUtil.hget("alarm:visibility",deviceSysNbr);
		if(jsonStr == null){
			//��һ�η�������
			List<WeatherAlarm>  list  = new ArrayList();
			//���㵱ǰ���ݵ�״̬  alarmGrade = "0" ����
			WeatherAlarm  alarm = getVisibilityStatus(vp);
			list.add(alarm);
			RedisPoolUtil.hset("alarm:visibility",vp.getDeviceSysNbr(),JSONArray.toJSONString(list));
		}else{
			//���㵱ǰ���ݵ�״̬  alarmGrade = "0" ��״̬
			WeatherAlarm  alarm = getVisibilityStatus(vp);
			List<WeatherAlarm>  list= JSONArray.parseArray(jsonStr,WeatherAlarm.class);
			list  = list.stream().sorted((a,b)->{
				return (int) (a.getEndAlarmTime().getTime() - b.getEndAlarmTime().getTime());
			}).collect(Collectors.toList());
			//���ǰһ��������Ԥ�� ������������ҲԤ�� �����Ԥ����Ϣ
			WeatherAlarm  lastAlarm = list.get(list.size()-1);
			//��������ӳ�����Ԥ����ֱ������
			Date  recordTime  = alarm.getStartAlarmTime();
			Date  lastRecordTime  = lastAlarm.getEndAlarmTime();
			if(recordTime == null || lastRecordTime == null){
				return true;
			}else{
				if(alarm.getStartAlarmTime().getTime() < lastAlarm.getEndAlarmTime().getTime()){
					return true;
				}else{
					//����10���� ���ݳ������⣬��Ҫ���µ���������Ϣ���Ҳ���Ԥ��
					if((recordTime.getTime() -lastRecordTime.getTime()) > 1000*60*10){
						list =  new ArrayList();
						list.add(alarm);
						RedisPoolUtil.hset("alarm:visibility", vp.getDeviceSysNbr(),JSONArray.toJSONString(list));
						return true;
					}
				}
			}
			//���������������ʱ����һ��Ԥ�����ڶ���ҲԤ��ʱ����������
			if(list.size() == 1){
				WeatherAlarm  firstAlarm = list.get(0);
				if(firstAlarm != null && alarm != null){
					if(!"0".equals(firstAlarm.getAlarmGrade())||!"0".equals(alarm.getAlarmGrade())){
						//����Ԥ��
						warnData(alarm);
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
							warnData(alarm);
						}
					}else{
						//�ڶ��������������� ����
						if("0".equals(lastAlarm.getAlarmGrade())&&"0".equals(alarm.getAlarmGrade())){
							//������Ϣ�������
							MQGateWay.publish("its_visibility_alarm",JSONObject.toJSONString(alarm));
						}
						//�ڶ��� ��������ͬԤ�������µڶ���Ԥ���Ľ���ʱ��
						if(lastAlarm.getAlarmGrade().equals(alarm.getAlarmGrade())&&!"0".equals(alarm.getAlarmGrade())){
							//���³���ʱ��
							warnUpdateData(lastAlarm,alarm);
						}else{
							//����Ԥ��
							if(!"0".equals(lastAlarm.getAlarmGrade())&&!"0".equals(alarm.getAlarmGrade())){
								warnData(alarm);
							}
						}
					}
				}
			}
			if(list.size() >= 2){
				list.remove(0);
			}
			list.add(alarm);
			//��Żػ�����
			RedisPoolUtil.hset("alarm:visibility",vp.getDeviceSysNbr(),JSONArray.toJSONString(list));
		}
		return true;
	}
	
	private void warnData(WeatherAlarm alarm){
		try {
			//ֻҪ״̬�仯����Ҫ����������
			String  sql= AlarmUtil.getSql(alarm);
			//��Ϊ0����������ݣ�Ϊ��ֻ����
			DBUtil.execute(sql);
			//����Ԥ����Ϣ������MQ��
			MQGateWay.publish("its_visibility_alarm",JSONObject.toJSONString(alarm));
			
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
	* @Title: getVisibilityStatus 
	* @Description:��ȡ���ܼ��ȵ���ֵ��Ϣ
	* @param @param vp �趨�ļ� 
	* @return WeatherAlarm �������� 
	* @throws 
	*/
	private WeatherAlarm getVisibilityStatus(VisibilityData vp) {
		WeatherAlarm  alarm= new WeatherAlarm();
		alarm.setAlarmEventId(AlarmUtil.generatorId());
		alarm.setDeviceSysNbr(vp.getDeviceSysNbr());
		alarm.setDeviceId(vp.getDeviceId());
		alarm.setOrgPrivilegeCode(vp.getOrgPrivilegeCode());
		alarm.setOrgCode(vp.getOrgCode());
		alarm.setSiteCode(vp.getSiteCode());
		alarm.setStartAlarmTime(vp.getRecordTime());
		alarm.setEndAlarmTime(vp.getRecordTime());
		alarm.setAlarmEventType(AlarmUtil.alarmEventTypeW);
		alarm.setSubAlarmEvent(AlarmUtil.TYPE_5021);
		alarm.setAlarmGrade("0");//��״̬����
		alarm.setWeatherData(vp.getOneMinuteVisibility()+"");
		List<TrafficAlarmValue> list = CacheManager.getTrafficAlarmDataList(CacheManager.alermTypev);
		if(list==null){
			CacheManager.initWarnList(CacheManager.alermTypev,"");
			CacheManager.getTrafficAlarmDataList(CacheManager.alermTypev);
		}
		for(TrafficAlarmValue tdv:list){
			if(vp.getOneMinuteVisibility()>tdv.getMin() && vp.getOneMinuteVisibility() <=tdv.getMax()){
				alarm.setAlarmGrade(tdv.getAlermGrade());
				alarm.setAlarmValueId(tdv.getMin()+","+tdv.getMax());
			}
		}
		alarm.setAlarmDesc("�ܼ���Ԥ���ȼ�Ϊ��"+alarm.getAlarmGrade());
		return alarm;
	}
	
}
