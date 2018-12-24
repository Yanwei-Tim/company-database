package cy.its.service.device.statusAnalysis.core;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.ComponentStatusResult;
import cy.its.service.common.dataModel.DeviceStatus;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.util.StatusUtil;

/**
 * �������ϵͳ��������������ͼ������
 * @author STJ
 *
 */
class SysComponents extends Sys {

	Map<String, ComponentOfSys> comMap;

	SysComponents(List<DeviceCfg> cfgs) {
		super(cfgs);
	}

	@Override
	void customConfig(List<DeviceCfg> cfgs) {
		this.configComponents(cfgs);
	}

	/**
	 * ���ռ������
	 */
	@Override
	synchronized void receive(SurveyData data) {
		if (this.comMap != null) {
			ComponentOfSys com = this.comMap.get(data.getDeviceNbr());
			if (com != null) {
				com.receive(data);
			}
		}
	}

	/**
	 * �����豸����
	 */
	@Override
	synchronized void receive(DeviceStatus status) {
		if (this.comMap != null) {
			// ���ô�������ϵͳ״̬
			ComponentOfSys com = this.comMap.get(status.getDeviceNbr());
			if (com != null) {
				long now = System.currentTimeMillis();
				if (com.receive(status.getStatus(), now, StatusUtil.getVehicleTotal(status))) {
					setSysStatusByComp(now);
				}
			}
		}
	}

	/**
	 * �Զ�����
	 */
	@Override
	synchronized void customCheck() {
		if (this.comMap != null) {
			// �������ϵͳ
			boolean seted = ConstValue.BOOL_FALSE;
			long now = System.currentTimeMillis();
			for (Entry<String, ComponentOfSys> kv : this.comMap.entrySet()) {
				if (kv.getValue().customCheck(now)) {
					seted = ConstValue.BOOL_TRUE;
				}
			}

			if (seted) {
				setSysStatusByComp(now);
			}
		}
	}

	/**
	 * ��ȡ���״̬�б�
	 */
	@Override
	List<ComponentStatusResult> componentStatus() {
		if (this.comMap != null) {
			return this.comMap.values().stream().map(c -> c.result()).collect(Collectors.toList());
		}

		return null;
	}

	/**
	 * ����ϵͳ���
	 * 
	 * @param cfgs
	 * @return
	 */
	private Boolean configComponents(List<DeviceCfg> cfgs) {
		boolean hasChange = ConstValue.BOOL_FALSE;
		List<DeviceCfg> comCfgs = cfgs.stream().filter(c -> !StringUtil.isNullOrEmpty(c.getDeviceNbr()))
				.collect(Collectors.toList());
		if (comCfgs.size() > ConstValue.INT_0) {
			if (this.comMap == null) {
				hasChange = ConstValue.BOOL_TRUE;
				this.comMap = comCfgs.stream()
						.collect(Collectors.toMap(DeviceCfg::getDeviceNbr, c -> new ComponentOfSys(c)));
			} else {
				// �µ�����б�ӳ���map
				Map<String, DeviceCfg> mapCfg = comCfgs.stream()
						.collect(Collectors.toMap(DeviceCfg::getDeviceNbr, c -> c));

				// ��ȡ�Ѵ��ڵ�����б�
				String[] keys = this.comMap.keySet().toArray(new String[0]);
				for (String key : keys) {
					if (mapCfg.containsKey(key)) {
						// �Դ��ڵ����,�޸���������Ϣ
						this.comMap.get(key).initConfig(mapCfg.get(key));
						mapCfg.remove(key);
					} else {
						// ��������ڵ����
						hasChange = ConstValue.BOOL_TRUE;
						this.comMap.remove(key);
					}
				}

				// ��������������״̬����
				for (Entry<String, DeviceCfg> kv : mapCfg.entrySet()) {
					hasChange = ConstValue.BOOL_TRUE;
					this.comMap.put(kv.getKey(), new ComponentOfSys(kv.getValue()));
				}
			}
		} else {
			// ��ǰϵͳ����ѱ����
			if (this.comMap != null) {
				hasChange = ConstValue.BOOL_TRUE;
				this.comMap = null;
			}
		}
		return hasChange;
	}

	/**
	 * ���������״̬ȷ��ϵͳ״̬
	 * 
	 * @param statusTime
	 */
	private void setSysStatusByComp(long statusTime) {
		int statusType = ConstValue.DEV_STATUS_TYPE_NORMAL;
		int vTotal = ConstValue.INT_0;
		int normal = ConstValue.INT_0, fault = ConstValue.INT_0, offline = ConstValue.INT_0, error = ConstValue.INT_0;
		for (Entry<String, ComponentOfSys> kv : this.comMap.entrySet()) {
			vTotal += kv.getValue().getVehicleTotal();
			switch (kv.getValue().getStatusType()) {
			case ConstValue.DEV_STATUS_TYPE_NORMAL:
				normal++;
				break;
			case ConstValue.DEV_STATUS_TYPE_OFFLINE:
				offline++;
				break;
			case ConstValue.DEV_STATUS_TYPE_FAULT:
				fault++;
				break;
			case ConstValue.DEV_STATUS_TYPE_ERROR:
				error++;
				break;
			default:
				break;
			}
		}

		int csize = this.comMap.size();
		if (csize == normal) {
			statusType = ConstValue.DEV_STATUS_TYPE_NORMAL;
		} else if (csize == offline) {
			statusType = ConstValue.DEV_STATUS_TYPE_OFFLINE;
		} else if (csize == fault) {
			statusType = ConstValue.DEV_STATUS_TYPE_FAULT;
		} else if (csize == error) {
			statusType = ConstValue.DEV_STATUS_TYPE_ERROR;
		} else if (csize == offline) {
			statusType = ConstValue.DEV_STATUS_TYPE_OFFLINE;
		} else {
			statusType = ConstValue.DEV_STATUS_TYPE_FAULT;
		}

		this.setStatus(statusTime, statusType, vTotal, ConstValue.INT_1_MINUS, ConstValue.BOOL_FALSE);
	}
}
