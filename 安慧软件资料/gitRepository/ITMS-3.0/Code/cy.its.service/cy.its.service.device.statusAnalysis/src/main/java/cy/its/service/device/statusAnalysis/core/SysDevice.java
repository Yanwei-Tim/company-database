package cy.its.service.device.statusAnalysis.core;

import java.util.List;

import cy.its.service.common.ConstValue;
import cy.its.service.common.dataModel.ComponentStatusResult;
import cy.its.service.common.dataModel.DeviceStatus;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.util.StatusUtil;

/**
 * �Լ���������������������ݵ�����������豸ϵͳ����״̬����
 * 
 * @author STJ
 *
 */
public class SysDevice extends Sys {

	/**
	 * ���µ������ϴ�ʱ��
	 */
	private long lastBeatTime;

	/**
	 * ���µ���������
	 */
	private int lastBeatCode;

	/**
	 * �޼�����ݼ������
	 */
	private int nodataPeriod;

	public SysDevice(List<DeviceCfg> cfgs) {
		super(cfgs);
	}

	@Override
	void customConfig(List<DeviceCfg> cfgs) {
		this.offLinePeriod = 5 * 60 * 1000;
		this.nodataPeriod = 30 * 60 * 1000;
		this.lastBeatTime = System.currentTimeMillis();
		this.surveyDataUploadTime = this.lastBeatTime;
	}

	/**
	 * �豸ϵͳ�����������ϴ�ʱ��
	 * 
	 * @param data
	 */
	@Override
	synchronized void receive(SurveyData data) {
		this.surveyDataUploadTime = System.currentTimeMillis();
	}

	/**
	 * ����ǰ�˴��͵�����
	 * 
	 * @param status
	 */
	@Override
	synchronized void receive(DeviceStatus status) {
		long now = System.currentTimeMillis();
		// ��������ʱ��
		this.lastBeatTime = now;
		// ������������
		this.lastBeatCode = StatusUtil.formatStatus(status.getStatus());
		// ȷ����ǰ�Ƿ��쳣
		int statusType = StatusUtil.offLineOrAbnormal(now, this.lastBeatTime, this.surveyDataUploadTime,
				this.offLinePeriod, this.nodataPeriod);

		if (statusType == Integer.MIN_VALUE) {
			// δ��⵽�쳣
			statusType = StatusUtil.getStatusType(this.lastBeatCode);
		}

		this.setStatus(now, statusType, StatusUtil.getVehicleTotal(status), this.lastBeatCode, ConstValue.BOOL_FALSE);
	}

	/**
	 * ���߼��
	 */
	@Override
	synchronized void customCheck() {
		long now = System.currentTimeMillis();
		// ȷ����ǰ�Ƿ��쳣
		int statusType = StatusUtil.offLineOrAbnormal(now, 
				this.lastBeatTime, this.surveyDataUploadTime,
				this.offLinePeriod, this.nodataPeriod);

		if (statusType != Integer.MIN_VALUE) {
			// ��⵽�쳣������
			this.setStatus(now, statusType, ConstValue.INT_0, ConstValue.INT_1_MINUS, ConstValue.BOOL_FALSE);
		} else {
			// δ��⵽�쳣������
			if (this.statusType == ConstValue.DEV_STATUS_TYPE_ERROR
					|| this.statusType == ConstValue.DEV_STATUS_TYPE_OFFLINE) {
				// �豸��ǰ�����쳣��������
				// �ָ��豸״̬
				this.setStatus(now, StatusUtil.getStatusType(this.lastBeatCode), 
						ConstValue.INT_0, this.lastBeatCode, ConstValue.BOOL_FALSE);
			}
		}
	}

	@Override
	List<ComponentStatusResult> componentStatus() {
		return null;
	}
}
