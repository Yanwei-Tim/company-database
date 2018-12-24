package cy.its.service.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import cy.its.service.common.rabbitmqClient.BindRelation;
import cy.its.service.common.rabbitmqClient.ExchangeInfo;
import cy.its.service.common.rabbitmqClient.ExchangeType;
import cy.its.service.common.rabbitmqClient.MQAddress;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.common.rabbitmqClient.QueueHandler;

/**
* @Title: MQUtil.java 
* @Package cy.its.service.surveillance.util 
* @Description: MQ���ӹ�����
* @author lil@cychina.cn
* @date 2015��10��24�� ����9:10:10 
* @version V1.0   
 */
public class MQUtil {
	  
	   private  static   List<QueueHandler>   queueHandlers;
	
	   private  static    Logger log=Logger.getLogger(MQUtil.class);
	   //����ֵ
	   private  static   String  propertity="";
	   
	   //�����ļ�·��
	   private  static   String  resource="";
	   //ip��ַ
	   private  static   String  ip;
	   //�û�
	   private  static   String  user;
	   //����
	   private  static   String  pwd;
	   //���Ľ���������
	   private  static   String  dataCenter;
	   
	   private MQUtil(){
		   
	   }
	   
	   private  MQUtil(String  propertity1,String  resource1){
		   propertity=propertity1;
		   resource=resource1;
		   //���propertity��Ϊ������Ҫ�����������ļ�����־��·��
		   try {
			  initAllProperties();
			} catch (Exception e) {
				log.error("mq���ӳ�ʼ���쳣�����������ļ���");
				e.printStackTrace();
			}
	    }
	   
		/** 
		* @Title: initAllProperties 
		* @Description: ��ʼ����������
		* @param @throws Exception    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		private static  void initAllProperties() throws Exception {
			OrderedProperties prop = new OrderedProperties();//���Լ��϶��� 
			InputStream fis =  new FileInputStream(resource);
			prop.load(fis);// �������ļ���װ�ص�Properties������ 
			fis.close();// �ر��� 
			ip = prop.getProperty("rabbitMqIp");
			user ="guest";
			pwd ="guest";
			dataCenter ="SURVEY_CENTER";
			initMqChanel();
		}
		
		static MQAddress mqAddress;
		static List<BindRelation> bindRelations;
		/** 
		* @Title: initMqChanel 
		* @Description: ��ͨMQͨ��
		* @param @throws Exception    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		private  static void  initMqChanel(){
			mqAddress = new MQAddress(ip,"/",user,pwd);
			bindRelations = new ArrayList<BindRelation>();
			queueHandlers = new ArrayList<QueueHandler>();
			bindRelations.add(new BindRelation(new ExchangeInfo(dataCenter, true, false,ExchangeType.TOPIC),
					queueHandlers));
			
		}
		
		public static  List<QueueHandler>  getQueueHandler(){
			return queueHandlers;
		}

		/** 
		* @Title: init 
		* @Description: ��ʼ��ͨ����Ϣ
		* @param @throws Exception    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		public static void init() throws Exception {
			
			MQGateWay.init(mqAddress,bindRelations, (s)->{System.out.println(s);},
					(s)->{System.out.println(s);});
		}
		
		/** 
		* @Title: stop 
		* @Description: �ر�MQ����
		* @param @throws Exception    �趨�ļ� 
		* @return void    �������� 
		* @throws 
		*/
		public static void stop() throws Exception {
			MQGateWay.stop();
		}
		
		
}