package cy.its.service.device.statusAnalysis.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.JsonUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceStatus;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.device.statusAnalysis.data.DeviceDAO;
import cy.its.service.device.statusAnalysis.data.StatusLogWriter;
import cy.its.service.device.statusAnalysis.data.StatusUpdater;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.util.ISysManager;
import cy.its.service.device.statusAnalysis.util.StatusUtil;
import cy.its.service.device.statusAnalysis.util.Timer;

/**
 * @Title: SysManager.java
 * @Package cy.its.service.device.statusAnalysis.core
 * @Description: ���ϵͳ������
 * @author STJ lijun@cychina.cn
 * @date 2015��11��4�� ����3:19:41
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 *      Company: ���ճ�Զ��Ϣ�������޹�˾ Copyright: Copyright (c) 2015
 */
@Export
public class SysManager implements ISysManager {

	static Map<String, Class<?>> deviceType;

	static {
		deviceType = new HashMap<String, Class<?>>();
		// �ȷ������ַ�������ݵ�ϵͳ����
		Class<SysDevice> sysDev = SysDevice.class;
		// ֻ��������ϵͳ����
		Class<SysJustHeat> sysJustHeat = SysJustHeat.class;

		// �����豸������״̬������ʽ�Ķ�Ӧ��ϵ
		deviceType.put("01", sysDev); // ����
		deviceType.put("02", sysDev); // �羯
		deviceType.put("03", sysJustHeat);// ��Ƶ
		deviceType.put("04", sysDev); // �����豸
		deviceType.put("05", sysJustHeat);// �����豸
		deviceType.put("06", sysJustHeat); // �ɱ�������
		deviceType.put("07", sysJustHeat);// �յ���
		deviceType.put("08", sysJustHeat);// �¼����
		deviceType.put("09", sysDev); // �������
		deviceType.put("10", sysJustHeat);// ���Ż�վ
		deviceType.put("11", sysJustHeat);// Υͣ
		deviceType.put("12", sysJustHeat);// ��ռ��
		deviceType.put("13", sysJustHeat);// ����
		deviceType.put("14", sysJustHeat);// �źŻ�
		deviceType.put("15", sysJustHeat);// �ѵ����źŻ�
		deviceType.put("16", sysJustHeat); // ����

	}

	Map<String, Sys> sysMap;
	Timer customChecker;
	Object sync = new Object();

	/**
	 * ��������
	 */
	@Override
	public void start(List<DeviceCfg> lstDevCfg) {
		Map<String, List<DeviceCfg>> map = lstDevCfg.stream()
				.collect(Collectors.groupingBy(DeviceCfg::getDeviceSysNbr));

		try {
			sysMap = new HashMap<String, Sys>(map.size());
			for (Entry<String, List<DeviceCfg>> kv : map.entrySet()) {
				createSys(kv.getKey(), kv.getValue());
			}
		} catch (Throwable e) {
			LogManager.error(e);
		}

		if (customChecker == null) {
			customChecker = new Timer(() -> {
				this.customCheck();
			} , 60000, 5000);

			customChecker.start();
		}
	}

	/**
	 * ֹͣ����
	 */
	@Override
	public void stop() {
		customChecker.stop();
		synchronized (sysMap) {
			for (Sys sys : sysMap.values()) {
				sys.stop();
			}
			sysMap.clear();
		}

		StatusUpdater.stop();
		StatusLogWriter.stop();
	}

	/**
	 * ��ȡ��ע���豸����
	 */
	@Override
	public String[] focusDeviceTypes() {
		return deviceType.keySet().toArray(new String[ConstValue.INT_0]);
	}

	/**
	 * ������������ļ������
	 */
	@Override
	public void handleSurveyData(SurveyData data) {
		Sys sys = getSys(data.getDeviceSysNbr());
		if (sys != null) {
			sys.receive(data);
		}
	}

	/**
	 * ��������״̬����
	 */
	@Override
	public void handleStatus(DeviceStatus heart) {
		Sys sys = getSys(heart.getDeviceSysNbr());
		if (sys != null) {
			sys.receive(heart);
		}
	}

	/**
	 * ��������ϵͳ��״̬
	 */
	@Override
	public void publishAllStatus() {
		List<Sys> lst;
		synchronized (sysMap) {
			lst = sysMap.values().stream().collect(Collectors.toList());
		}

		MQGateWay.publish(ConstValue.ROUTE_KEY_QUERY_RESULT_STATUS_RESULT,
				JsonUtil.serialize(lst.stream().map(c -> c.generateResult()).collect(Collectors.toList())));
	}

	/**
	 * ���ϵͳ����������ñ��
	 */
	@Override
	public void checkChangeOfSysCfg() {
		try {
			List<DeviceCfg> lstDevCfg = DeviceDAO.getDeviceCfg(this.focusDeviceTypes());
			Map<String, List<DeviceCfg>> map = lstDevCfg.stream()
					.collect(Collectors.groupingBy(DeviceCfg::getDeviceSysNbr));
			synchronized (sysMap) {
				Set<String> leftSysNbrs = StatusUtil.intersect(map.keySet(), sysMap.keySet());
				Set<String> newSysNbrs = StatusUtil.sutract(map.keySet(), leftSysNbrs);
				Set<String> deleteSysNbrs = StatusUtil.sutract(sysMap.keySet(), leftSysNbrs);
				for (String s : deleteSysNbrs) {
					sysMap.get(s).stop();
					sysMap.remove(s);
				}

				for (String s : newSysNbrs) {
					this.createSys(s, map.get(s));
				}

				for (String s : leftSysNbrs) {
					sysMap.get(s).change(map.get(s));
				}
			}

		} catch (Throwable e) {
			LogManager.error(e);
		}
	}

	/**
	 * �Զ������ڼ��
	 */
	private void customCheck() {
		try {
			Sys[] lstSys = null;
			synchronized (sysMap) {
				if (sysMap.size() > ConstValue.INT_0) {
					lstSys = sysMap.values().toArray(new Sys[ConstValue.INT_0]);
				}
			}

			if (lstSys != null) {
				for (Sys sys : lstSys) {
					sys.customCheck();
				}
			}
		} catch (Throwable e) {
			LogManager.error(StringUtil.getErrorDetail(e));
		}
	}

	/**
	 * ��ȡָ����ϵͳ
	 * 
	 * @param sysNbr
	 * @return
	 */
	private Sys getSys(String sysNbr) {
		synchronized (sysMap) {
			return sysMap.get(sysNbr);
		}
	}

	/**
	 * ѡ���Դ���ϵͳ
	 * 
	 * @param deviceSysNbr
	 * @param lstCfg
	 */
	private void createSys(String deviceSysNbr, List<DeviceCfg> lstCfg) {
		if (lstCfg.size() > ConstValue.INT_1) {
			// �������ϵͳ
			sysMap.put(deviceSysNbr, new SysComponents(lstCfg));
		} else if (lstCfg.size() == ConstValue.INT_1) {
			DeviceCfg cfg = lstCfg.get(ConstValue.INT_0);
			if (!StringUtil.isNullOrEmpty(cfg.getDeviceNbr())) {
				// �������ϵͳ
				sysMap.put(deviceSysNbr, new SysComponents(lstCfg));
			} else {
				Class<?> clz = deviceType.get(cfg.getDeviceType());
				if (clz != null) {
					if (clz == SysDevice.class) {
						sysMap.put(deviceSysNbr, new SysDevice(lstCfg));
					} else if (clz == SysJustHeat.class) {
						sysMap.put(deviceSysNbr, new SysJustHeat(lstCfg));
					}
				}
			}
		}
	}

}
