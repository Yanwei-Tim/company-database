package cy.its.service.util;

import java.text.ParseException;
import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
* @Title: QuartzManager.java 
* @Package cy.its.road.convertFlow.util 
* @Description: ��ʱ���������
* @author lil@cychina.cn
* @date 2015��10��28�� ����6:59:06 
* @version V1.0   
 */
public class QuartzManager {
	
	   private static SchedulerFactory sf = new StdSchedulerFactory();
	   private static String JOB_GROUP_NAME = "group1";
	   private static String TRIGGER_GROUP_NAME = "trigger1";
	   
	  
	   
	/** 
	* @Title: addJob 
	* @Description:��ʱ������
	* @param @param triggerName
	* @param @param jobName
	* @param @param time
	* @param @param clssType
	* @param @throws SchedulerException
	* @param @throws ParseException    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public static void addJob(String triggerName,String jobName,Date runTime,Class clssType,int seconds) 
	                               throws SchedulerException, ParseException{
	      Scheduler sched = sf.getScheduler();
	     //��������Jobʵ���༰������һЩ��̬��Ϣ������һ����ҵʵ��
	       JobDetail jobDetail = JobBuilder.newJob(clssType).withIdentity(jobName, JOB_GROUP_NAME).build();
	       //������
	       Trigger trigger = TriggerBuilder.newTrigger()//����һ���µ�TriggerBuilder���淶һ��������
	    		   .withIdentity(triggerName, TRIGGER_GROUP_NAME)//����������һ�����ֺ�����
	    		   .startAt(runTime)//����ִ��
	    		   .withSchedule(
		    		   SimpleScheduleBuilder.simpleSchedule()
		    		   .withIntervalInSeconds(seconds)//ʱ����  ��λ����
		    		   .repeatForever()//һֱִ��
	    		   )
	    		   .build();//����������
	       sched.scheduleJob(jobDetail, trigger);
	       //����
	       if(!sched.isShutdown())
	          sched.start();
    }
	
	
	/** 
	* @Title: shutdown 
	* @Description: �رն�ʱ��
	* @param @param schedName    �趨�ļ� 
	* @return void    �������� 
	* @throws 
	*/
	public  static void shutdown() {
		try {
			Scheduler currentScheduler = sf.getScheduler();
			currentScheduler.shutdown();
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
