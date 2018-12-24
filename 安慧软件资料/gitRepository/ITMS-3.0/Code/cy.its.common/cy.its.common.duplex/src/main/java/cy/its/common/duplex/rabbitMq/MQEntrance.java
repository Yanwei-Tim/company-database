package cy.its.common.duplex.rabbitMq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cy.its.platform.common.utils.Log4jFactoryProxy;
import cy.its.service.common.rabbitmqClient.BindRelation;
import cy.its.service.common.rabbitmqClient.ExchangeInfo;
import cy.its.service.common.rabbitmqClient.ExchangeType;
import cy.its.service.common.rabbitmqClient.MQAddress;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.common.rabbitmqClient.QueueHandler;

/**
* @Title: MQUtil.java 
* @Package com.cy.rabbitMq 
* @Description:MQ�����ֻ࣬�ڹ���������ʱ���ʼ��һ��
* @author lil@cychina.cn
* @date 2015��11��19�� ����2:05:53 
* @version V1.0   
 */
public class MQEntrance {
	/**
	 * ͨ����Ϣ
	 */
	private static List<QueueHandler> queueHandlers;
	
	private static Log4jFactoryProxy log = Log4jFactoryProxy.getSingleton(MQEntrance.class);
	
	/**
	 *��Ž���ҵ����
	 */
	private static Map<String,IMqReceiver>  ireceivermap;
	
	
	static{
		
		ireceivermap  = new  HashMap();
	}
	
	private MQEntrance() {
		//��ҪCHNAL
    	MQAddress mqAddress = new MQAddress(RabbitMqProperties.getIp(), "/",RabbitMqProperties.getUser(), RabbitMqProperties.getPwd());
		List<BindRelation> bindRelations = new ArrayList<BindRelation>();
		queueHandlers = new ArrayList<QueueHandler>();
		//���������ļ���ʵ��������
		for (String key : RabbitMqProperties.getMap().keySet()) {
			   Class instance;
			try {
				instance = Class.forName(RabbitMqProperties.getMap().get(key));
				IMqReceiver  imr  = (IMqReceiver) instance.newInstance();
				//�������
				ireceivermap.put(key,imr);
				queueHandlers.add(new QueueHandler(key+"_"+System.currentTimeMillis(),false, true, key,imr));
			} catch (Exception e) {
				log.error(RabbitMqProperties.getMap().get(key)+"�����շ�������ʧ�ܣ�");
				log.error(e.getStackTrace());
			}
		}
		//������������
		bindRelations.add(new BindRelation(new ExchangeInfo(RabbitMqProperties.getDataCenter(), true, false, ExchangeType.TOPIC),
				queueHandlers));
		try {
			//��ʼ����Ϣ
			MQGateWay.synInit(mqAddress,bindRelations, s->{log.info(s);}, s->{log.error(s);});
		} catch (Exception e) {
			log.error("��ʼ��MQ��Ϣ�������⣡");
			log.error(e.getStackTrace());
		}	
	}

	public static Map<String, IMqReceiver> getIreceivermap() {
		return ireceivermap;
	}
	
	
}
