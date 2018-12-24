package cy.its.service.device.statusChecker.core;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.JsonUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceAlarm;
import cy.its.service.common.dataModel.SurveyUpgrade_ComponentStatusResult;
import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.common.dataModel.SurveyUpgrade_SysStatusResult;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.MQGateWay;
import cy.its.service.device.statusChecker.data.StatusUpdater;
import cy.its.service.device.statusChecker.model.DeviceCfg;
import cy.its.service.device.statusChecker.util.StatusUtil;

abstract class Sys {

//	protected String deviceKey;
	protected String deviceId;
	protected String deviceType;
	protected String deviceSysNbr;
	protected String orgPrivilegeCode;
	protected String siteCode;
	protected int statusType;
	protected long statusTypeUpdateTime;
	protected long statusTypeBeginTime;
	protected List<String> faultDetails;

	protected Long lastUploadTime;
	
	protected Long latestDataTimeInDevice;

	private Long deviceCurTime;

	private Integer timeDiff;

	protected Sys(List<DeviceCfg> cfgs) {
		this.config(cfgs.get(ConstValue.INT_0));
		this.customConfig(cfgs);
		this.initStatus(cfgs.get(ConstValue.INT_0));
	}

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
		this.setStatus(System.currentTimeMillis(), this.statusType, this.faultDetails, this.deviceCurTime,
				this.timeDiff);
	}

	/**
	 * ���û�����Ϣ
	 * 
	 * @param cfg
	 */
	protected void config(DeviceCfg cfg) {
		this.deviceId = cfg.getDeviceSysId();
		this.deviceSysNbr = cfg.getDeviceSysNbr();
		this.orgPrivilegeCode = cfg.getOrgPrivilegeCode();
		this.siteCode = cfg.getSiteCode();
//		this.deviceKey = cfg.getDeviceSysKey();
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
		this.faultDetails = null;

		// �������ֹͣ�ڼ��״̬
		if (cfg.getStartTime() != null && cfg.getEndTime() != null) {
			this.statusTypeBeginTime = this.statusType == Integer.valueOf(cfg.getStatusType())
					? cfg.getStartTime().getTime() : cfg.getEndTime().getTime();
			this.setStatus(System.currentTimeMillis(), ConstValue.DEV_STATUS_TYPE_NORMAL, null, null, null);
		} else {
			// ����ϵͳ��
			this.statusTypeUpdateTime = System.currentTimeMillis();
			this.statusTypeBeginTime = this.statusTypeUpdateTime;
			StatusUpdater.update(this.deviceId, this.statusType, this.statusTypeUpdateTime);
		}
	}

	/**
	 * ����״̬
	 * 
	 * @param newStatusTime
	 * @param status1
	 * @param vehicleTotal
	 */
	protected void setStatus(long newStatusTime, int newStatusType, List<String> faultCodes, Long deviceCurTime,
			Integer timeDiff) {
		if (newStatusTime > this.statusTypeBeginTime) {
			// д״̬��־��
			this.statusTypeBeginTime = StatusUtil.writeStatusLog(this.deviceId, this.statusType,
					this.statusTypeBeginTime, newStatusTime);
			
			// �ж�״̬�����Ƿ����仯
			if (this.statusType != newStatusType) {
				// ״̬���ͷ����仯
				this.statusTypeBeginTime = newStatusTime;
			}

			faultAlarm(newStatusTime, newStatusType, faultCodes);
			
			// ����ϵͳ��
			StatusUpdater.update(this.deviceId, newStatusType, newStatusTime);
			this.statusTypeUpdateTime = newStatusTime;			
		} else {
			// ����ϵͳ��
			StatusUpdater.update(this.deviceId, newStatusType, this.statusTypeBeginTime);
			this.statusTypeUpdateTime = this.statusTypeBeginTime;
		}

		this.statusType = newStatusType;
		this.faultDetails = faultCodes;
		this.deviceCurTime = deviceCurTime;
		this.timeDiff = timeDiff;

		// ����״̬�������
		this.publishResult();
	}

	static String fmt = "����״̬�������:%s";

	/**
	 * ����״̬�������
	 */
	synchronized void publishResult() {
		String json = JsonUtil.serialize(getResult());
		LogManager.debug(String.format(fmt, JsonUtil.serialize(json)));
		MQGateWay.publish(ConstValue.ROUTE_KEY_STATUS_RESULT_FOR_UPGRADE, json);
	}

	synchronized SurveyUpgrade_SysStatusResult generateResult() {
		return getResult();
	}

	SurveyUpgrade_SysStatusResult getResult() {
		return new SurveyUpgrade_SysStatusResult(this.deviceId, this.deviceSysNbr, this.deviceType,
				this.orgPrivilegeCode, this.siteCode, new Date(this.statusTypeUpdateTime), this.statusType,
				this.faultDetails, this.componentStatus(),
				this.deviceCurTime != null ? new Date(this.deviceCurTime) : null, this.timeDiff,
				this.lastUploadTime != null ? new Date(this.lastUploadTime) : null,
				this.latestDataTimeInDevice != null ? new Date(this.latestDataTimeInDevice): null);
	}

	protected void setLatestDataTime(Long dataTime) {
		if (dataTime != null) {
			if (this.latestDataTimeInDevice == null) {
				this.latestDataTimeInDevice = dataTime;
			} else {
				if (this.latestDataTimeInDevice < dataTime) {
					this.latestDataTimeInDevice = dataTime;
				}
			}
		}
	}
	
	void faultAlarm(long newStatusTime, int newStatusType, List<String> newfaultCodes) {
		if(ConstValue.DEV_STATUS_TYPE_FAULT == newStatusType ||
		   ConstValue.DEV_STATUS_TYPE_ERROR == newStatusType) {
			boolean isPub = false;
			if (newStatusType != this.statusType) {
				// ״̬�仯ʱ
				isPub = true;
			} else {
				// ״̬δ�仯ʱ����������ϸ���ޱ仯
				if (newfaultCodes != null && this.faultDetails != null) {
					if(newfaultCodes.size() != this.faultDetails.size()){
						isPub = true;
					}else{
						Set<String> set1 = newfaultCodes.stream().collect(Collectors.toSet());
						Set<String> set2 = this.faultDetails.stream().collect(Collectors.toSet());						
						Set<String> join = new HashSet<String>(set1);
						join.retainAll(set2);						
						if(join.size() < set2.size() || join.size() < set1.size()){
							isPub = true;
						}
					}					
				} else {
					int newCount = newfaultCodes == null?0:newfaultCodes.size();
					int oldCount = this.faultDetails == null?0:this.faultDetails.size();					
					if(newCount != oldCount){
						isPub = true;
					}					
				}
			}
			
			if(isPub){
				publishAlarm(newStatusTime, newStatusType, newfaultCodes);
			}
		}
	}
	
	void publishAlarm(long newStatusTime, int statusType, List<String> faultDetails) {
		DeviceAlarm alarm = new DeviceAlarm();
		alarm.setAlarmId(StringUtil.generateUUID());
		alarm.setAlarmType("1");
		alarm.setAlarmSubType(String.valueOf(statusType));
		alarm.setAlarmDeviceId(this.deviceId);
		alarm.setStartTime(new Date(newStatusTime));
//		alarm.setEndTime();
		alarm.setCollectWay("2");
		alarm.setAlarmDisc(faultDetails != null && faultDetails.size() > 0 ? 
				String.join(ConstValue.SEMICOLON, faultDetails) : null);
		alarm.setOrgPrivilegeCode(this.orgPrivilegeCode);
		String msg = JsonUtil.serialize(alarm);
		LogManager.debug("�����豸�����쳣����: " + msg);
		MQGateWay.publish(ConstValue.ROUTE_KEY_ALARM_DEVICE_BEFORE_TODB, msg);
	}
	
	/**
	 * ����ǰ�˴��͵�����
	 * 
	 * @param status
	 * @throws Exception
	 */
	abstract void receive(SurveyUpgrade_DeviceStatus status) throws Exception;

	abstract void setLastUploadTime(String componentId, Long dataTime);

	/**
	 * ��ȡ���״̬
	 * 
	 * @return
	 */
	abstract List<SurveyUpgrade_ComponentStatusResult> componentStatus();

	/**
	 * ���ƻ�����
	 */
	abstract void customConfig(List<DeviceCfg> cfgs);
}
