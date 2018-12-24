package cy.its.service.device.statusAnalysis.core;

import java.util.Date;
import java.util.List;

import cy.its.service.common.ConstValue;
import cy.its.service.common.dataModel.ComponentStatusResult;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.util.StatusUtil;

class ComponentOfSys {
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

	private String sysComponentId;

	private String deviceNbr;

	private int offLinePeriod;

	private long statusUpdateTime;

	private int statusType;

	private List<Integer> statusDetails;

	private int vehicleTotal;

	/**
	 * ����ϴ�ʱ��
	 */
	private long surveyDataUploadTime;

	/**
	 * ���캯��
	 * @param cfg
	 */
	public ComponentOfSys(DeviceCfg cfg) {
		this.initConfig(cfg);
		long now = System.currentTimeMillis();
		this.lastBeatCode = ConstValue.INT_0;
		this.lastBeatTime = now;
		this.surveyDataUploadTime = now;
		this.setStatus(now, ConstValue.DEV_STATUS_TYPE_NORMAL, ConstValue.INT_0, this.lastBeatCode, ConstValue.BOOL_TRUE);
	}

	/**
	 * ��ʼ������
	 * @param cfg
	 */
	public void initConfig(DeviceCfg cfg) {
		this.offLinePeriod = 600000;
		this.nodataPeriod = 3600000;
		this.sysComponentId = cfg.getSysComponentId();
		this.deviceNbr = cfg.getDeviceNbr();
	}

	/**
	 * ������������
	 * @param statusCode
	 * @param statusTime
	 * @param vehicleTotal
	 * @return
	 */
	public boolean receive(int statusCode, long statusTime, int vehicleTotal) {
		// ��������ʱ��
		this.lastBeatTime = statusTime;
		// ������������
		this.lastBeatCode = StatusUtil.formatStatus(statusCode);
		// ȷ����ǰ�Ƿ��쳣
		int statusType = StatusUtil.offLineOrAbnormal(statusTime, this.lastBeatTime, this.surveyDataUploadTime,
				this.offLinePeriod, this.nodataPeriod);

		if (statusType == Integer.MIN_VALUE) {
			// δ��⵽�쳣
			statusType = StatusUtil.getStatusType(this.lastBeatCode);
		}

		return this.setStatus(statusTime, statusType, vehicleTotal, this.lastBeatCode, ConstValue.BOOL_FALSE);
	}

	/**
	 * ���ռ������
	 * @param data
	 */
	public void receive(SurveyData data) {
		this.surveyDataUploadTime = System.currentTimeMillis();
	}

	/**
	 * �Զ������ڼ��
	 * @param statusTime
	 * @return
	 */
	public boolean customCheck(long statusTime) {
		int statusType = StatusUtil.offLineOrAbnormal(statusTime, this.lastBeatTime, this.surveyDataUploadTime,
				this.offLinePeriod, this.nodataPeriod);

		if (statusType != Integer.MIN_VALUE) {
			return this.setStatus(statusTime, statusType, ConstValue.INT_0, ConstValue.INT_1_MINUS, ConstValue.BOOL_FALSE);
		} else {
			// δ��⵽�쳣������
			if (this.statusType == ConstValue.DEV_STATUS_TYPE_ERROR ||
				this.statusType == ConstValue.DEV_STATUS_TYPE_OFFLINE) {
				// �豸��ǰ�����쳣��������
				// �ָ��豸״̬
				return this.setStatus(statusTime, StatusUtil.getStatusType(this.lastBeatCode), ConstValue.INT_0,
						this.lastBeatCode, ConstValue.BOOL_FALSE);
			}
		}

		return ConstValue.BOOL_FALSE;
	}

	/**
	 * ����״̬����
	 * @param newStatusTime
	 * @param newStatusType
	 * @param vehicleTotal
	 * @param statusCode
	 * @param ignore
	 * @return
	 */
	private boolean setStatus(long newStatusTime, int newStatusType, int vehicleTotal, int statusCode, boolean ignore) {
		// �ж�״̬�����Ƿ����仯
		if (this.statusType != newStatusType) {
			this.statusType = newStatusType;
		} else {
			// ״̬���Ͳ���
			// ������ݷ����Ƿ�Ƶ��
			if (!ignore && newStatusTime - this.statusUpdateTime < ConstValue.INT_60000) {
				// �������͵���ͬ״̬�Ҽ��ʱ��϶�
				return ConstValue.BOOL_FALSE;
			}
		}

		this.statusUpdateTime = newStatusTime;
		this.statusDetails = StatusUtil.splitStatus(statusCode);
		this.vehicleTotal = vehicleTotal;

		return ConstValue.BOOL_TRUE;
	}

	public int getStatusType() {
		return statusType;
	}

	public int getVehicleTotal() {
		return vehicleTotal;
	}

	public ComponentStatusResult result() {
		return new ComponentStatusResult(sysComponentId, deviceNbr,
				new Date(statusUpdateTime), statusType,
				lastBeatCode, statusDetails, vehicleTotal);
	}
}
