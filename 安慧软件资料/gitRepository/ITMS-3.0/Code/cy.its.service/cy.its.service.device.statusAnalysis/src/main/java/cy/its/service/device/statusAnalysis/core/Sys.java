package cy.its.service.device.statusAnalysis.core;

import java.util.Date;
import java.util.List;

import cy.its.service.common.ConstValue;
import cy.its.service.common.JsonUtil;
import cy.its.service.common.dataModel.ComponentStatusResult;
import cy.its.service.common.dataModel.DeviceStatus;
import cy.its.service.common.dataModel.SysStatusResult;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.device.statusAnalysis.data.StatusLogWriter;
import cy.its.service.device.statusAnalysis.data.StatusUpdater;
import cy.its.service.device.statusAnalysis.data.SurveyData;
import cy.its.service.device.statusAnalysis.model.DeviceCfg;
import cy.its.service.device.statusAnalysis.model.Period;
import cy.its.service.device.statusAnalysis.model.StatusLog;
import cy.its.service.device.statusAnalysis.util.StatusUtil;

abstract class Sys {
	protected String deviceId;
	protected String deviceSysNbr;
	protected String orgPrivilegeCode;
	protected String siteCode;
	protected String deviceType;
	protected int statusType;
	protected long surveyDataUploadTime;
	protected long statusTypeUpdateTime;
	protected long statusTypeBeginTime;
	protected List<Integer> statusDetails;
	protected int vehicleTotal;
	protected int offLinePeriod;

	protected Sys(List<DeviceCfg> cfgs){
		this.config(cfgs.get(ConstValue.INT_0));
		this.customConfig(cfgs);
		this.initStatus(cfgs.get(ConstValue.INT_0));
	}
	
	/**
	 * �豸ϵͳ�����������ϴ�ʱ��
	 * 
	 * @param data
	 */
	abstract void receive(SurveyData data);

	/**
	 * ����ǰ�˴��͵�����
	 * 
	 * @param status
	 */
	abstract void receive(DeviceStatus status);

	/**
	 * �Զ�����,�����ߡ��쳣�ȼ��
	 */
	abstract void customCheck();

	/**
	 * ��ȡ���״̬
	 * 
	 * @return
	 */
	abstract List<ComponentStatusResult> componentStatus();
	
	/**
	 * ���ƻ�����
	 */
	abstract void customConfig(List<DeviceCfg> cfgs);

	/**
	 * �ı�ϵͳ��Ϣ
	 * 
	 * @param cfgs
	 */
	synchronized void change(List<DeviceCfg> cfgs) {
		this.config(cfgs.get(ConstValue.INT_0));
		this.customConfig(cfgs);
	}
	
	/**
	 * ֹͣϵͳ��״̬����
	 */
	public synchronized void stop() {
		this.setStatus(System.currentTimeMillis(), this.statusType, this.vehicleTotal,
				StatusUtil.sumListStatus(this.statusDetails), ConstValue.BOOL_TRUE);
	}

	/**
	 * ���û�����Ϣ
	 * 
	 * @param cfg
	 */
	protected void config(DeviceCfg cfg) {
		this.deviceId = cfg.getDeviceId();
		this.deviceSysNbr = cfg.getDeviceSysNbr();
		this.orgPrivilegeCode = cfg.getOrgPrivilegeCode();
		this.siteCode = cfg.getSiteCode();
		this.deviceType = cfg.getDeviceType();
	}

	/**
	 * ��ʼ��ϵͳ״̬
	 * 
	 * @param cfg
	 */
	protected void initStatus(DeviceCfg cfg) {
		// Ĭ������״̬Ϊ����
		this.statusType = ConstValue.DEV_STATUS_TYPE_NORMAL;
		this.vehicleTotal = ConstValue.INT_0;
		this.statusDetails = null;

		// �������ֹͣ�ڼ��״̬
		if (cfg.getStartTime() != null && cfg.getEndTime() != null) {
			this.statusTypeBeginTime = this.statusType == Integer.valueOf(cfg.getStatusType())
					? cfg.getStartTime().getTime() : cfg.getEndTime().getTime();
			this.setStatus(System.currentTimeMillis(), ConstValue.DEV_STATUS_TYPE_NORMAL, vehicleTotal,
					ConstValue.INT_0, ConstValue.BOOL_TRUE);
		} else {
			// ����ϵͳ��
			this.statusTypeUpdateTime = System.currentTimeMillis();
			this.statusTypeBeginTime = this.statusTypeUpdateTime;
			StatusUpdater.update(this.deviceId, this.statusType, new Date(this.statusTypeUpdateTime), null, null);
		}
	}

	/**
	 * ����״̬
	 * 
	 * @param newStatusTime
	 * @param status1
	 * @param vehicleTotal
	 */
	protected void setStatus(long newStatusTime, int newStatusType, int vehicleTotal, int statusCode, boolean ignore) {
		// �ж�״̬�����Ƿ����仯
		if (this.statusType != newStatusType) {
			// ״̬���ͷ����仯
			// д״̬��־��
			this.statusTypeBeginTime = this.writeStatusLog(this.deviceId, this.statusType, this.statusTypeBeginTime,
					newStatusTime);
			// ����ϵͳ��
			StatusUpdater.update(this.deviceId, newStatusType, new Date(newStatusTime), null, null);
			this.statusTypeBeginTime = newStatusTime;
		} else {
			// ״̬���Ͳ���
				// ������ݷ����Ƿ�Ƶ��
			if (!ignore && newStatusTime - this.statusTypeUpdateTime < ConstValue.INT_60000) {
				// �������͵���ͬ״̬�Ҽ��ʱ��϶�
				return;
			}

			// д״̬��־��
			this.statusTypeBeginTime = this.writeStatusLog(this.deviceId, this.statusType, this.statusTypeBeginTime,
					newStatusTime);

			// ����ϵͳ��
			StatusUpdater.update(this.deviceId, newStatusType, new Date(newStatusTime),
					new Date(this.statusTypeBeginTime), new Date(newStatusTime));
		}

		this.statusType = newStatusType;
		this.statusTypeUpdateTime = newStatusTime;
		this.statusDetails = StatusUtil.splitStatus(statusCode);
		this.vehicleTotal = vehicleTotal;

		// ����״̬�������
		this.publishResult();
	}

	/**
	 * ����״̬�������
	 */
	void publishResult() {
		String json = JsonUtil.serialize(getResult());
		LogManager.debug(String.format(fmt, JsonUtil.serialize(json)));
		MQGateWay.publish(ConstValue.ROUTE_KEY_STATUS_RESULT, json);
	}

	synchronized SysStatusResult generateResult() {
		return getResult();
	}
	
	private SysStatusResult getResult(){
		return new SysStatusResult(this.deviceId, this.deviceSysNbr, this.orgPrivilegeCode,
				this.siteCode, this.surveyDataUploadTime, this.statusTypeUpdateTime, this.statusType, this.statusDetails,
				this.vehicleTotal, this.componentStatus(), this.deviceType);
	}
	
	static String fmt = "����״̬�������:%s";

	/**
	 * д״̬��־
	 * 
	 * @param devId
	 * @param statusType
	 * @param begin
	 * @param end
	 * @return
	 */
	protected long writeStatusLog(String devId, int statusType, long begin, long end) {
		Date newBegin = null;
		List<Period> periods = StatusUtil.splitDateByDay(new Date(begin), new Date(end));
		for (Period period : periods) {
			StatusLogWriter.insert(
					new StatusLog(devId, String.valueOf(statusType), period.getBeginTime(), period.getEndTime()));
			newBegin = period.getBeginTime();
		}

		return newBegin.getTime();
	}

}
