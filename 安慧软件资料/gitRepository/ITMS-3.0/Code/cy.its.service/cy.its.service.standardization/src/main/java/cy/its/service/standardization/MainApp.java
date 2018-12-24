package cy.its.service.standardization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cy.its.service.common.config.ITSConfig;
import cy.its.service.common.ice.grid.AppService;
import cy.its.service.common.ioc.AppContext;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.ioc.Import;
import cy.its.service.common.log.ILog;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.BindRelation;
import cy.its.service.common.rabbitmqClient.ExchangeInfo;
import cy.its.service.common.rabbitmqClient.ExchangeType;
import cy.its.service.common.rabbitmqClient.MQAddress;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.common.ConstValue;
import cy.its.service.standardization.dictionary.CacheManager;

/**
 * @Title: MainApp.java
 * @Package cy.its.service.standardization
 * @Description: TODO
 * @author STJ lijun@cychina.cn
 * @date 2015��11��3�� ����10:59:13
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */
@Export
public class MainApp extends AppService {

	
	@Import
	List<IMaker> baseMakers;

	@Import
	CacheManager cacheManager;

	static final String LogName = "MainApp";

	static ILog log;

	/**
	 * �������
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogManager.createDefaultLogger("standard~", "standardization");
			AppContext.init("cy.its.service.standardization");
			Run(AppContext.getBean(MainApp.class), args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	/**
	 * ������������
	 */
	public void Start(String[] args) throws Exception {
		// ��ʼ������
		cacheManager.initialize();
		// ��ʼ��MQ
		initRabbitMQ();
		LogManager.info("�����淶������");
	}

	@Override
	/**
	 * ����ֹͣ����
	 */
	public void Stop() throws Exception {
		LogManager.info("��ʼֹͣ�淶������");
		MQGateWay.stop();
		cacheManager.close();
		LogManager.info("���ֹͣ�淶������");
	}

	@Override
	public String getAppName() {
		return "standardization";
	}

	/**
	 * ��ʼ����MQ������
	 * 
	 * @throws Exception
	 */
	private void initRabbitMQ() throws Exception {
		// ��ʼ��MQ
		String mqIp = ITSConfig.findValue("rabbitMqIp");
		MQAddress mqAddress = new MQAddress(mqIp, "/", "guest", "guest");
		List<BindRelation> bindRelations = new ArrayList<BindRelation>();
		bindRelations.add(new BindRelation(new ExchangeInfo(ConstValue.EXCHANGE, true, false, ExchangeType.TOPIC),
				baseMakers.stream().map(m -> m.getQueueHandler()).collect(Collectors.toList())));

		MQGateWay.init(mqAddress, bindRelations, s -> {
			LogManager.info(s);
		} , s -> {
			LogManager.error(s);
		});
	}

//	Timer timer = new Timer();

//	private void testPublish() {
//		timer.schedule(new TimerTask() {
//
//			@Override
//			public void run() {
//				PassingVehicle pv = new PassingVehicle();
//				pv.setCaptureTime(DateUtil.formatDate(new Date()));
//				pv.setDeviceNo("530326003");
//				pv.setSnapNbr(DateUtil.formatDate(new Date()));
//				pv.setPlateNbr("��A12345");
//				pv.setPlateColor("2");
//				pv.setLane(1);
//				pv.setDriveDirection("��������");
//				pv.setDriveDirection("�򶫷���");
//
//				boolean r = MQGateWay.publish(ConstValue.ROUTE_KEY_ORIGINAL_PASS, JsonUtil.serialize(pv));
//
//				System.out.println(r ? ("�������Է����ɹ�һ��:" + JsonUtil.serialize(pv)) : "�������Է���ʧ��");
//			}
//		}, 1000, 10000);

//		pubPass();
//
//		pubVio();

//		pubFlow();
//	}

//	private void pubFlow() {
//		timer.schedule(new TimerTask() {
//			@Override
//			public void run() {
//				TrafficStats stats = new TrafficStats();
//				 
//				Date d = new Date();
//				if (d.getSeconds() % 2 == 0) {
//					stats.setDeviceNo("WS2100202184");
//				} else {
//					stats.setDeviceNo("530326003");
//				}
//				
//				stats.setStatsTime(DateUtil.formatDate(d));
//				stats.setDriveLane(1);
//				stats.setVehicleTotal(100);
//				
//				boolean r = MQGateWay.publish(ConstValue.ROUTE_KEY_ORIGINAL_FLOW, JsonUtil.serialize(stats));
//
//				System.out.println(r ? ("�������Է����ɹ�һ��:" + JsonUtil.serialize(stats)) : "�������Է���ʧ��");
//			}
//		}, 1000, 12233);
//	}
//
//	private void pubVio() {
//		timer.schedule(new TimerTask() {
//
//			@Override
//			public void run() {
//				ViolationVehicle pv = new ViolationVehicle();
//				pv.setCaptureTime(DateUtil.formatDate(new Date()));
//				pv.setDeviceNo("530326003");
//				pv.setSnapNbr(DateUtil.formatDate(new Date()));
//				pv.setPlateNbr("��A12345");
//				pv.setPlateColor("2");
//				pv.setLane(1);
//				pv.setDriveDirection("��������");
//				pv.setDriveDirection("�򶫷���");
//				// SpeedLimit[] limits = new SpeedLimit[1];
//				SpeedLimit limit = new SpeedLimit();
//				limit.setLane(1);
//				limit.setVehicleType("01");
//				limit.setRoadOverSpeedLimit(120);
//				pv.setRoadSpeedLimits(new SpeedLimit[] { limit });
//				pv.setViolationBehaviors(new String[] { "56024" });
//
//				boolean r = MQGateWay.publish(ConstValue.ROUTE_KEY_ORIGINAL_VIO, JsonUtil.serialize(pv));
//
//				System.out.println(r ? ("Υ�����Է����ɹ�һ��:" + JsonUtil.serialize(pv)) : "Υ�����Է���ʧ��");
//			}
//		}, 1000, 10000);
//	}
//
//	private void pubPass() {
//		timer.schedule(new TimerTask() {
//
//			@Override
//			public void run() {
//			
//				PassingVehicle pv = new PassingVehicle();
//				pv.setCaptureTime(DateUtil.formatDate(new Date()));
//				pv.setDeviceNo("530326003");
//				pv.setSnapNbr(DateUtil.formatDate(new Date()));
//				pv.setPlateNbr("��A12345");
//				pv.setPlateColor("2");
//				pv.setLane(1);
//				pv.setDriveDirection("��������");
//				pv.setDriveDirection("�򶫷���");
//				
//				boolean r = MQGateWay.publish(ConstValue.ROUTE_KEY_ORIGINAL_PASS, 
//						JsonUtil.serialize(pv));
//				
//				System.out.println(r?("�������Է����ɹ�һ��:"+JsonUtil.serialize(pv)):"�������Է���ʧ��");
//			
//				
//			}
//		}, 1000, 13123);
//	}
}
