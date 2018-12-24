package cy.its.service.device.statusChecker.core;

import java.util.List;

import cy.its.service.common.dataModel.SurveyUpgrade_ComponentStatusResult;
import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.device.statusChecker.model.DeviceCfg;
import cy.its.service.device.statusChecker.util.StatusUtil;

/**
 * �Խ������������豸����״̬����
 * 
 * @author lijun
 *
 */
class SysJustHeat extends Sys {

	/**
	 * ���캯��
	 * 
	 * @param cfg
	 */
	public SysJustHeat(List<DeviceCfg> cfgs) {
		super(cfgs);
	}

	/**
	 * ���ƻ�����
	 */
	@Override
	void customConfig(List<DeviceCfg> cfgs) {
	}

	/**
	 * ����ǰ�˴��͵�����
	 * 
	 * @param status
	 * @throws Exception
	 */
	@Override
	synchronized void receive(SurveyUpgrade_DeviceStatus status) throws Exception {
		this.setStatus(System.currentTimeMillis(),
				StatusUtil.getStatusType(status.getStatusCode(), status.getFaultCodes()),
				status.getFaultCodes(), status.getDeviceTime(), status.getTimeDiff());
	}

	@Override
	synchronized void setLastUploadTime(String componentId, Long dataTime) {
		this.lastUploadTime = System.currentTimeMillis();
		this.setLatestDataTime(dataTime);	
	}
	
	@Override
	List<SurveyUpgrade_ComponentStatusResult> componentStatus() {
		return null;
	}

}
