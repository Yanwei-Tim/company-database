package cy.its.service.convertFlow;


import java.text.ParseException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.SchedulerException;

import cy.its.service.common.ice.grid.AppService;
import cy.its.service.common.rabbitmqClient.IReceiver;
import cy.its.service.common.rabbitmqClient.QueueHandler;
import cy.its.service.convertFlow.service.CacheManager;
import cy.its.service.convertFlow.service.ConverFlowService;
import cy.its.service.convertFlow.service.FlowScheduleService;
import cy.its.service.util.MQUtil;
import cy.its.service.util.QuartzManager;
import cy.its.service.util.RedisPoolUtil;
import cy.its.service.util.ServiceFileResource;

/**
* @Title: ConvertFlowAppService.java 
* @Package cy.its.road.convertFlow 
* @Description:5������������ת������
* @author lil@cychina.cn
* @date 2015��10��28�� ����11:29:02
* @version V1.0   
 */
public class ConvertFlowAppService  extends AppService {
	
	private static  Logger log=Logger.getLogger(ConvertFlowAppService.class);
	/**
	 * ��ʼ�����е���Դ�ļ�
	 */
	/**
	* @Title: main 
	* @Description:������ʱ��
	* @param @param agrs    �趨�ļ� 
	* @return void    �������� 
	* @throws
	 */
    public  static  void  main(String[]  agrs){
    	ConvertFlowAppService capp = new ConvertFlowAppService();
    	capp.ConfigAllProperties();
    	Run(capp,agrs);
    }
    
	/** 
	* @Title: ConfigAllProperies 
	* @Description: ���������ļ����������ļ� 
	* @param     �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	private  void ConfigAllProperties() {
		//��Դ�ļ���ʼ��
		ServiceFileResource   sfr  = new ServiceFileResource("global.xml","sectionFlowLog.log");
		//��ʼ��������Ϣ
		//CacheManager.initSectionist();
		//������ݽ��շ������
		Class<?> clinstance  =ConverFlowService.class;
		IReceiver ic;
		try {
			ic = (IReceiver) clinstance.newInstance();
			//��������
			MQUtil.getQueueHandler().add(new QueueHandler("conver_flow_queue", false, true,"its_traffic_stats",ic));
			
			MQUtil.init();
		} catch (Exception e) {
			log.error("���շ���ʵ����ʧ�ܣ��������ã�������������");
			e.printStackTrace();
		}
		//redisʵ����
		RedisPoolUtil.index  = 5;
	}
	
	private static Date getNewDate(int i) {
		Date date  = new  Date();
		if(i==0){
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
		}else if(i==1){
			date.setTime(date.getTime()+1000*60*60);
			date.setSeconds(0);
			date.setMinutes(5);
		}else {
			date.setTime(date.getTime()+1000*60*60*24);
			date.setHours(0);
			date.setMinutes(8);
			date.setSeconds(0);
		}
		return date;
	}

	@Override
	public void Start(String[] args) throws Exception {
		//������ʱ����
    	Date  date   = getNewDate(0);
    	try {
    		//5��������һ��
			QuartzManager.addJob("five_flow", "flow_service",date,FlowScheduleService.class,5*60);
			
		} catch (SchedulerException | ParseException e) {
			log.info("��ʱ��������ʧ�ܣ�");
			e.printStackTrace();
		}
		
	}

	@Override
	public void Stop() throws Exception {
		//ֹͣ����MQ
		MQUtil.stop();
		//ֹͣ��ʱ��
		QuartzManager.shutdown();
		
	}

	@Override
	public String getAppName() {
		// TODO Auto-generated method stub
		return "ConvertFlow";
	}
}
