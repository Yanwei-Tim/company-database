package cy.its.service.analysisAlarm;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.text.ParseException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import cy.its.service.analysisAlarm.domain.GlobalProperty;
import cy.its.service.analysisAlarm.module.RoadSensorModule;
import cy.its.service.analysisAlarm.module.SectionFlowModule;
import cy.its.service.analysisAlarm.module.TrafficEventModule;
import cy.its.service.analysisAlarm.module.TravalTimeModule;
import cy.its.service.analysisAlarm.module.VisibilityModule;
import cy.its.service.analysisAlarm.module.WeatherModule;
import cy.its.service.common.ice.grid.AppService;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.QueueHandler;
import cy.its.service.util.MQUtil;
import cy.its.service.util.QuartzManager;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.ServiceFileResource;

/**
* @Title: VisibilityApp.java 
* @Package cy.its.service.visibility 
* @Description:�ܼ��ȷ������
* @author lil@cychina.cn
* @date 2015��11��6�� ����10:20:09 
* @version V1.0   
 */
public class AnalysisAlarmApp  extends AppService {
	
	private static  Logger log=Logger.getLogger(AnalysisAlarmApp.class);
	/** 
	* @Title: ConfigAllProperies 
	* @Description: ���������ļ����������ļ� 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private  void ConfigAllProperties() {
		//��Դ�ļ���ʼ��
		ServiceFileResource   sfr  = new ServiceFileResource("global.xml","analysisAlarm.log");
		//���ر��������ļ�
		InputStream   is;
        Properties props = new Properties();
        try {
        	
        	is = new FileInputStream(sfr.globalPath+sfr.FILE_SEPARATOR+"alarm.properties");
			props.load(is);
			//��ʼ��ȫ�ֱ���
			Class<?> c = GlobalProperty.class;
			Constructor c0=c.getDeclaredConstructor(new Class[]{int.class,int.class,int.class});
			c0.setAccessible(true);
			c0.newInstance(new Object[]{Integer.valueOf(props.getProperty("startTime")),
					Integer.valueOf(props.getProperty("endTime")),
					Integer.valueOf(props.getProperty("delayTime"))}); 
			try {
				
				IReceiver ic3 = (IReceiver) VisibilityModule.class.newInstance();
				
				IReceiver ic4 = (IReceiver) TrafficEventModule.class.newInstance();
				IReceiver ic5 = (IReceiver) WeatherModule.class.newInstance();
				IReceiver ic6 = (IReceiver) RoadSensorModule.class.newInstance();
				IReceiver ic7 = (IReceiver) TravalTimeModule.class.newInstance();
				
				IReceiver ic8 = (IReceiver) SectionFlowModule.class.newInstance();
				
				//�ܼ���
				MQUtil.getQueueHandler().add(new QueueHandler("traffic_event_visibility_queue", false, true,"its_visibility",ic3));
				//��ͨ�¼�
				MQUtil.getQueueHandler().add(new QueueHandler("traffic_event_nalysis_queue", false, true,"its_traffic_event",ic4));
				//���Ԥ��
				MQUtil.getQueueHandler().add(new QueueHandler("traffic_event_weather_queue", false, true,"its_weather",ic5));
				//·��
				MQUtil.getQueueHandler().add(new QueueHandler("traffic_event_roadSensor_queue", false, true,"its_roadsensor",ic6));
				//����ʱ�䳬��
				MQUtil.getQueueHandler().add(new QueueHandler("traffic_event_travalTime_queue", false, true,"its_region_speed",ic7));
				//����Ԥ��
				MQUtil.getQueueHandler().add(new QueueHandler("traffic_event_section_queue",false,true,"its_section_flow",ic8));
				
				//������ʱ��������ر�ʱ �رն�ʱ��
				Date date = getNewDate();
				try {
					QuartzManager.addJob("analysisTriger", "weatherAlarm",date, AlarmScheduleService.class,60*5);
				} catch (SchedulerException | ParseException e) {
					log.error("������ʱ������");
					e.printStackTrace();
				}
				
				MQUtil.init();
			} catch (Exception e) {
				log.error("���շ���ʵ����ʧ�ܣ��������ã�������������");
				e.printStackTrace();
			}
			//redisʵ����
			RedisPoolUtil.index = 2;
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	/** 
	* @Title: getNewDate 
	* @Description:��ȡ��ʱ��ִ��ʱ��
	* @param @return   �趨�ļ� 
	* @return Date    �������� 
	* @throws 
	*/
	private static Date getNewDate() {
		Date date  = new  Date();
		int minute = date.getMinutes();
		minute = minute%10;
		int s = minute/10;
		if(minute <2){
			minute=2;
		}else if(minute < 7){
			minute=7;
		}else{
			minute=2;
		}
		date.setMinutes(s*10+minute);
		date.setSeconds(s*10);
		return date;
	}
	
	public  static  void  main(String[]  agrs){
		AnalysisAlarmApp   aal  = new AnalysisAlarmApp();
		aal.ConfigAllProperties();
		Run(aal,agrs);
	}

	@Override
	public void Start(String[] args) throws Exception {
		System.out.println("·��Ԥ����������������");
	}

	@Override
	public void Stop() throws Exception {
		//ֹͣ��������
		MQUtil.stop();
		//ֹͣ������Ϣ
		QuartzManager.shutdown();
	}

	@Override
	public String getAppName() {
		// TODO Auto-generated method stub
		return "AnalysisAlarm";
	}
}
