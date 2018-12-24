package cy.its.service.device.statusAnalysis.core;

import java.util.List;

import cy.its.service.common.ConstValue;
import cy.its.service.common.dataModel.ComponentStatusResult;
import cy.its.service.common.dataModel.DeviceStatus;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.util.StatusUtil;

/**
 * �Խ������������豸����״̬����
 * @author lijun
 *
 */
class SysJustHeat extends Sys {
	
	/**
	 * ���캯��
	 * @param cfg
	 */
	public SysJustHeat(List<DeviceCfg> cfgs){
		super(cfgs);
	}
	
	/**
	 * ���ƻ�����
	 */
	@Override
	void customConfig(List<DeviceCfg> cfgs) {
		this.offLinePeriod = 30 * 60 * 1000;
	}	

	/**
	 * �豸ϵͳ�����������ϴ�ʱ��
	 * 
	 * @param data
	 */
	@Override
	synchronized void receive(SurveyData data) {
		return;
	}

	/**
	 * ����ǰ�˴��͵�����
	 * 
	 * @param status
	 */
	@Override
	synchronized void receive(DeviceStatus status) {
		int statusCode = StatusUtil.formatStatus(status.getStatus());
		int statusType = StatusUtil.getStatusType(statusCode);
		this.setStatus(System.currentTimeMillis(), statusType,
				StatusUtil.getVehicleTotal(status), statusCode, ConstValue.BOOL_FALSE);
	}

	/**
	 * ���߼��
	 */
	@Override
	synchronized void customCheck() {
		long now = System.currentTimeMillis();
		if (now - this.statusTypeUpdateTime > this.offLinePeriod) {
			this.setStatus(now, ConstValue.DEV_STATUS_TYPE_OFFLINE,
					ConstValue.INT_0, ConstValue.INT_1_MINUS, ConstValue.BOOL_FALSE);
		}
	}

	/**
	 * ���ز���
	 */
	@Override
	List<ComponentStatusResult> componentStatus() {
		// ��ǰ�豸�޲���
		return null;
	}

}
