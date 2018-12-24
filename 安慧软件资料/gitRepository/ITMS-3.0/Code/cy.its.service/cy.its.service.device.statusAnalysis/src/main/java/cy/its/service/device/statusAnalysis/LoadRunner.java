package cy.its.service.device.statusAnalysis;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.config.ITSConfig;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.ioc.Import;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.BindRelation;
import cy.its.service.common.rabbitmqClient.ExchangeInfo;
import cy.its.service.common.rabbitmqClient.ExchangeType;
import cy.its.service.common.rabbitmqClient.MQAddress;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.device.statusAnalysis.data.DeviceDAO;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.model.StatusLog;
import cy.its.service.device.statusAnalysis.receiver.StatusReceiver;
import cy.its.service.device.statusAnalysis.util.ISysManager;

/**
 * @Title: LoadRunner.java
 * @Package cy.its.service.device.statusAnalysis
 * @Description: ״̬�����������й�����
 * @author STJ lijun@cychina.cn
 * @date 2015��11��4�� ����3:21:01
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 *      Company: ���ճ�Զ��Ϣ�������޹�˾ Copyright: Copyright (c) 2015
 */
@Export
public class LoadRunner {
	@Import
	ISysManager sysManager;

	@Import
	List<StatusReceiver> receivers;

	boolean isStop = false;

	ExecutorService excutor;

	void initialize() {
		try {
			String[] devTypes = sysManager.focusDeviceTypes();
			boolean loaded = false;
			while (!isStop) {
				try {
					loadDevice(devTypes);
					loaded = true;
					break;
				} catch (Throwable e) {
					LogManager.error("ϵͳ״̬��������ʼ������ʧ��, �Ժ����¼���, ����:" + StringUtil.getErrorDetail(e));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e1) {
						LogManager.error(e1);
					}
				}
			}

			if (loaded && !isStop) {
				this.initMQ();
				sysManager.publishAllStatus();
			}
		} catch (Throwable e) {
			LogManager.error(e);
		}

	}

	void start() {
		excutor = Executors.newFixedThreadPool(1);
		excutor.submit(() -> initialize());
		LogManager.info("����״̬��������");
	}

	void stop() {
		LogManager.info("ֹͣ״̬�������� ��ʼ");

		try {
			isStop = true;
			excutor.shutdown();
			excutor.awaitTermination(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
		}

		try {
			MQGateWay.stop();
		} catch (Exception e1) {
		}

		sysManager.stop();

		LogManager.info("ֹͣ״̬�������� ����");
	}

	void initMQ() {
		// ��ʼ��MQ
		String mqIp = ITSConfig.findValue("rabbitMqIp");
		MQAddress mqAddress = new MQAddress(mqIp, "/", "guest", "guest");

		List<BindRelation> bindRelations = Arrays
				.asList(new BindRelation(new ExchangeInfo(ConstValue.EXCHANGE, true, false, ExchangeType.TOPIC),
						receivers.stream().map(c -> c.queueHandler()).collect(Collectors.toList())));

		try {
			MQGateWay.synInit(mqAddress, bindRelations, s -> {
				LogManager.info(s);
			} , s -> {
				LogManager.error(s);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void loadDevice(String[] devTypes) throws Exception {
		List<DeviceCfg> lstDevCfg = DeviceDAO.getDeviceCfg(devTypes);
		Map<String, StatusLog> m = DeviceDAO.getDeviceStatusLog().stream()
				.filter(l -> l != null && !StringUtil.isNullOrEmpty(l.deviceId))
				.collect(Collectors.toMap(StatusLog::getDeviceId, s -> s));
		lstDevCfg.forEach(c -> {
			StatusLog l = m.get(c.getDeviceId());
			if (l != null) {
				c.setStatusType(l.statusType);
				c.setStartTime(l.startTime);
				c.setEndTime(l.endTime);
			}
		});

		sysManager.start(lstDevCfg);
	}
}