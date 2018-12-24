package cy.its.service.device.statusChecker.core;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.SurveyUpgrade_ComponentStatusResult;
import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.device.statusChecker.model.DeviceCfg;

/**
 * �������ϵͳ��������������ͼ������
 * 
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
	 * �����豸����
	 * 
	 * @throws Exception
	 */
	@Override
	synchronized void receive(SurveyUpgrade_DeviceStatus status) throws Exception {
		if (this.comMap != null) {
			// ���ô�������ϵͳ״̬
			ComponentOfSys com = this.comMap.get(status.getCameraId());
			if (com != null) {
				long now = System.currentTimeMillis();
				com.receive(status.getStatusCode(), status.getFaultCodes(), status.getDeviceTime(),
						status.getTimeDiff(), now);
				setSysStatusByComp(now);
			}
		}
	}

	/**
	 * ��ȡ���״̬�б�
	 */
	@Override
	List<SurveyUpgrade_ComponentStatusResult> componentStatus() {
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
		List<DeviceCfg> comCfgs = cfgs.stream().filter(c -> !StringUtil.isNullOrEmpty(c.getCameraId()))
				.collect(Collectors.toList());
		if (comCfgs.size() > ConstValue.INT_0) {
			if (this.comMap == null) {
				hasChange = ConstValue.BOOL_TRUE;
				this.comMap = comCfgs.stream()
						.collect(Collectors.toMap(DeviceCfg::getCameraId, c -> new ComponentOfSys(c)));
			} else {
				// �µ�����б�ӳ���map
				Map<String, DeviceCfg> mapCfg = comCfgs.stream()
						.collect(Collectors.toMap(DeviceCfg::getCameraId, c -> c));

				// ��ȡ�Ѵ��ڵ�����б�
				String[] keys = this.comMap.keySet().toArray(new String[0]);
				for (String key : keys) {
					if (mapCfg.containsKey(key)) {
						// �Դ��ڵ����,�޸���������Ϣ
						this.comMap.get(key).config(mapCfg.get(key));
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
		int normal = ConstValue.INT_0, fault = ConstValue.INT_0, offline = ConstValue.INT_0, error = ConstValue.INT_0;
		Integer diff = ConstValue.INT_0;
		Long devCurTime = null;
		boolean hasMaxDiff = ConstValue.BOOL_FALSE;
		ComponentOfSys c;
		
		for (Entry<String, ComponentOfSys> kv : this.comMap.entrySet()) {
			c = kv.getValue();
			if (c.getTimeDiff() != null && Math.abs(c.getTimeDiff()) >= Math.abs(diff) ) {
				hasMaxDiff = ConstValue.BOOL_TRUE;
				diff = c.getTimeDiff();
				devCurTime = c.getDeivceCurTime();
			}

			switch (c.getStatusType()) {
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

		this.setStatus(statusTime, statusType, null, devCurTime, hasMaxDiff? diff : null);
	}

	@Override
	synchronized void setLastUploadTime(String componentId, Long dataTime) {
		this.lastUploadTime = System.currentTimeMillis();		
		this.setLatestDataTime(dataTime);		
		if(this.comMap != null && !StringUtil.isNullOrEmpty(componentId)){
			ComponentOfSys c = this.comMap.get(componentId);
			if(c != null){
				c.setLastUploadTime(this.lastUploadTime, dataTime);
			}
		}
		
	}
}
