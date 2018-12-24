	package cy.its.service.region;

import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import cy.its.service.common.ice.grid.AppService;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.QueueHandler;
import cy.its.service.region.module.CacheManager;
import cy.its.service.region.module.RegionReceiveModule;
import cy.its.service.region.module.RegionScheduleService;
import cy.its.service.util.MQUtil;
import cy.its.service.util.QuartzManager;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.ServiceFileResource;

/**
* @Title: RegionFlowApp.java 
* @Package cy.its.service.Region 
* @Description:����ƽ������
* @author lil@cychina.cn
* @date 2015��11��3�� ����10:25:21 
* @version V1.0   
 */
public class RegionFlowApp extends AppService {
	
	private static  Logger log=Logger.getLogger(RegionFlowApp.class);
	/**
	 * ��ʼ�����е���Դ�ļ�
	 */
	/** 
	* @Title: ConfigAllProperies 
	* @Description: ���������ļ����������ļ� 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private  void ConfigAllProperties() {
		//��Դ�ļ���ʼ��
		ServiceFileResource   sfr  = new ServiceFileResource("global.xml","regionFlowLog.log");
		//������ݽ��շ������
		Class<?> clinstance  =RegionReceiveModule.class;
		IReceiver ic;
		try {
			ic = (IReceiver) clinstance.newInstance();
			MQUtil.getQueueHandler().add(new QueueHandler("region_flow_queue", false, true,"its_pass_vehicle",ic));
			MQUtil.init();
		} catch (Exception e) {
			log.error("���շ���ʵ����ʧ�ܣ��������ã�������������");
			e.printStackTrace();
		}
		//redisʵ����
		RedisPoolUtil.index  = 2;
	}
	
	public  static  void main(String[] args){
		
		RegionFlowApp  rapp = new RegionFlowApp();
		rapp.ConfigAllProperties();
		//����ʵ��
		Run(rapp, args);
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

	@Override
	public void Start(String[] args) throws Exception {
		//������ʱ��
		Date date = getNewDate();
		try {
			
			QuartzManager.addJob("regionFlowTriger", "regionFlow",date, RegionScheduleService.class,60*5);
			
		} catch (SchedulerException | ParseException e) {
			log.error("������ʱ������");
			e.printStackTrace();
		}
	}

	@Override
	public void Stop() throws Exception {
		//�ر�MQ����ͨ��
		MQUtil.stop();
		//�رն�ʱ��
		QuartzManager.shutdown();
	}

	@Override
	public String getAppName() {
		
		return "RegionFlow";
	}
}
