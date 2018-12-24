package cy.its.service.device.statusChecker.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.JsonUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.device.statusChecker.data.DeviceDAO;
import cy.its.service.device.statusChecker.data.StatusLogWriter;
import cy.its.service.device.statusChecker.data.StatusUpdater;
import cy.its.service.device.statusChecker.model.DeviceCfg;
import cy.its.service.device.statusChecker.model.SurveyData;
import cy.its.service.device.statusChecker.util.ISysManager;

@Export
public class SysManager implements ISysManager {

	static Map<String, Class<?>> deviceType;

	static {
		deviceType = new HashMap<String, Class<?>>();

		// ֻ��������ϵͳ����
		Class<SysJustHeat> sysJustHeat = SysJustHeat.class;

		// �����豸������״̬������ʽ�Ķ�Ӧ��ϵ
		deviceType.put("01", sysJustHeat); // ����
		deviceType.put("02", sysJustHeat); // �羯
		deviceType.put("03", sysJustHeat);// ��Ƶ
		deviceType.put("04", sysJustHeat); // �����豸
		deviceType.put("05", sysJustHeat);// �����豸
		deviceType.put("06", sysJustHeat); // �ɱ�������
		deviceType.put("07", sysJustHeat);// �յ���
		deviceType.put("08", sysJustHeat);// �¼����
		deviceType.put("09", sysJustHeat); // �������
		deviceType.put("10", sysJustHeat);// ���Ż�վ
		deviceType.put("11", sysJustHeat);// Υͣ
		deviceType.put("12", sysJustHeat);// ��ռ��
		deviceType.put("13", sysJustHeat);// ����
		deviceType.put("14", sysJustHeat);// �źŻ�
		deviceType.put("15", sysJustHeat);// �ѵ����źŻ�
		deviceType.put("16", sysJustHeat); // ����

	}

	Map<String, Sys> sysMap;

	/**
	 * ��������
	 */
	@Override
	public void start(List<DeviceCfg> lstDevCfg) {
		Map<String, List<DeviceCfg>> map = lstDevCfg.stream().collect(Collectors.groupingBy(DeviceCfg::getDeviceSysId));

		try {
			sysMap = new HashMap<String, Sys>(map.size());
			for (Entry<String, List<DeviceCfg>> kv : map.entrySet()) {
				createSys(kv.getKey(), kv.getValue());
			}
		} catch (Throwable e) {
			LogManager.error(e);
		}

	}

	/**
	 * ֹͣ����
	 */
	@Override
	public void stop() {
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
	 * ��������״̬����
	 * 
	 * @throws Exception
	 */
	@Override
	public void handleStatus(SurveyUpgrade_DeviceStatus heart) throws Exception {
		Sys sys = getSys(heart.getDeviceSysId());
		if (sys != null) {
			sys.receive(heart);
		}
	}
	

	@Override
	public void receiveSurveyData(SurveyData surveyData) {
		Sys sys = getSys(surveyData.getDeviceId());
		if (sys != null) {
			Long dataTime = null;
			if (surveyData.getPassTime() != null) {
				dataTime = surveyData.getPassTime().getTime();
			} else if (surveyData.getViolationTime() != null) {
				dataTime = surveyData.getViolationTime().getTime();
			} else if (surveyData.getCountTime() != null) {
				dataTime = surveyData.getCountTime().getTime();
			} else if (surveyData.getRecordTime() != null) {
				dataTime = surveyData.getRecordTime().getTime();
			}

			sys.setLastUploadTime(surveyData.getSysComponentId(), dataTime);
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
					.collect(Collectors.groupingBy(DeviceCfg::getDeviceSysId));
			synchronized (sysMap) {
				List<String> lstOldId = sysMap.keySet().stream().collect(Collectors.toList());
				for (String oldId : lstOldId) {
					if (map.containsKey(oldId)) {
						configExistDevice(map, oldId);
						// sysMap.get(oldId).change(map.remove(oldId));
					} else {
						sysMap.remove(oldId).stop();
					}
				}
				lstOldId.clear();
				for (Entry<String, List<DeviceCfg>> kv : map.entrySet()) {
					this.createSys(kv.getKey(), kv.getValue());
				}
			}

		} catch (Throwable e) {
			LogManager.error(e);
		}
	}

	/**
	 * ��ȡָ����ϵͳ
	 * 
	 * @param sysNbr
	 * @return
	 */
	private Sys getSys(String sysId) {
		synchronized (sysMap) {
			return sysMap.get(sysId);
		}
	}

	/**
	 * ѡ���Դ���ϵͳ
	 * 
	 * @param deviceSysNbr
	 * @param lstCfg
	 */
	private void createSys(String deviceSysId, List<DeviceCfg> lstCfg) {
		if (lstCfg.size() > ConstValue.INT_1) {
			// �������ϵͳ
			sysMap.put(deviceSysId, new SysComponents(lstCfg));
		} else if (lstCfg.size() == ConstValue.INT_1) {
			DeviceCfg cfg = lstCfg.get(ConstValue.INT_0);
			if (!StringUtil.isNullOrEmpty(cfg.getCameraId())) {
				// �������ϵͳ
				sysMap.put(deviceSysId, new SysComponents(lstCfg));
			} else {
				Class<?> clz = deviceType.get(cfg.getDeviceType());
				if (clz != null && clz == SysJustHeat.class) {
					sysMap.put(deviceSysId, new SysJustHeat(lstCfg));
				}
			}
		}
	}
	
	/**
	 * ���ñ��
	 * @param map
	 * @param oldId
	 */
	private void configExistDevice(Map<String, List<DeviceCfg>> map, String oldId) {
		List<DeviceCfg> newCfgs = map.remove(oldId);
		Sys sys = sysMap.get(oldId);
		if (newCfgs.size() > ConstValue.INT_1
				|| !StringUtil.isNullOrEmpty(newCfgs.get(ConstValue.INT_0).getCameraId())) {
			if (sys instanceof SysComponents) {
				sys.change(newCfgs);
			} else {
				sys.stop();
				sysMap.put(oldId, new SysComponents(newCfgs));
			}
		} else {
			if (sys instanceof SysComponents) {
				sys.stop();
				sysMap.put(oldId, new SysJustHeat(newCfgs));
			} else {
				sys.change(newCfgs);
			}
		}
	}
}
