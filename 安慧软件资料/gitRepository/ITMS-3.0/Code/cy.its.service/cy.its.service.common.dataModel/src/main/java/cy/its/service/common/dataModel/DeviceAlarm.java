package cy.its.service.common.dataModel;

import java.util.Date;

public class DeviceAlarm {
	
	/**
	* Ψһ��ʶ
	*/
	@Mapper("ALARM_ID")
	private String alarmId;
	
	/**
	* 1:�豸����
	2:����������
	3:����
	*/
	@Mapper("ALARM_TYPE")
	private String alarmType;
	
	/**
	* �豸�࣬��Ӧcode:478
	������Ϊ��
	*/
	@Mapper("ALARM_SUB_TYPE")
	private String alarmSubType;
	
	/**
	* �����������豸ID���������豸��Ҳ�����Ƿ�������
	*/
	@Mapper("ALARM_DEVICE_ID")
	private String alarmDeviceId;
	
	/**
	* ������ʼʱ��
	*/
	@Mapper("START_TIME")
	private Date startTime;
	
	/**
	* ��������ʱ�䣬����Ϊ��
	*/
	@Mapper("END_TIME")
	private Date endTime;
	
	/**
	* 1ǰ���豸�ϴ�
	2ϵͳ����
	3�˹����
	*/
	@Mapper("COLLECT_WAY")
	private String collectWay;
	
	/**
	* ��������
	*/
	@Mapper("ALARM_DISC")
	private String alarmDisc;
	
	/**
	* ����Ȩ�ޱ��룬����Ȩ�޹���
	*/
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;
	
	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public String getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(String alarmType) {
		this.alarmType = alarmType;
	}

	public String getAlarmSubType() {
		return alarmSubType;
	}

	public void setAlarmSubType(String alarmSubType) {
		this.alarmSubType = alarmSubType;
	}

	public String getAlarmDeviceId() {
		return alarmDeviceId;
	}

	public void setAlarmDeviceId(String alarmDeviceId) {
		this.alarmDeviceId = alarmDeviceId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCollectWay() {
		return collectWay;
	}

	public void setCollectWay(String collectWay) {
		this.collectWay = collectWay;
	}

	public String getAlarmDisc() {
		return alarmDisc;
	}

	public void setAlarmDisc(String alarmDisc) {
		this.alarmDisc = alarmDisc;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

}
