package cy.its.service.common.dataModel;

import java.util.Date;

public class DeviceFault extends Model {

	/**
	 * �豸ID
	 */
	@Mapper("DEVICE_ID")
	private String deviceId;
	
	/**
	 * ���ID
	 */
	@Mapper("SYS_COMPONENT_ID")
	private String sysComponentId;

	/**
	 * ����ʱ��
	 */
	@Mapper("FAULT_EVENT_TIME")
	private Date faultEventTime;

	/**
	 * ���ϻ򱨾���1-���ϣ�2-������
	 */
	@Mapper("FAULT_ALARM")
	private String faultAlarm;

	/**
	 * ����/�������͡�1�������쳣 100�����״��ź� 101���״�����ϵ 102���״ﲻ���� 103���״����ݴ��� 104����Ƶ�ֻ�����
	 * 105���Ŵ��·���� 106��CPU���� 128������ 2���������ϵ 200�����������ж� 201��ups��ص�ѹƫ�� 202��UpsʧЧ
	 * 203��û��Ups�ź� 3�������ͼ�� 300����Ȧ����ϵ 301��û����Ȧ�ź� 302����Ȧ���ݴ��� 4��û��ͼ���ź� 400����ʱ����ץ��ͼ��
	 * 401����ͨ�г��� 402���洢���� 403��û�������
	 * 
	 */
	@Mapper("FAULT_TYPE")
	private String faultType;

	/**
	 * ����������
	 */
	@Mapper("FAULT_SUB_TYPE")
	private String faultSubType;

	/**
	 * �ɼ���ʽ��1-ǰ���豸�ϴ���2-ϵͳ������3-�˹����
	 */
	@Mapper("COLLECT_METHOD")
	private String collectMethod;

	/**
	 * ����
	 */
	@Mapper("REMARK")
	private String remark;
	
	@Mapper("ORG_PRIVILEGE_CODES")
	private String orgPrivilegeCode;
	

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSysComponentId() {
		return sysComponentId;
	}

	public void setSysComponentId(String sysComponentId) {
		this.sysComponentId = sysComponentId;
	}

	public Date getFaultEventTime() {
		return faultEventTime;
	}

	public void setFaultEventTime(Date faultEventTime) {
		this.faultEventTime = faultEventTime;
	}

	public String getFaultAlarm() {
		return faultAlarm;
	}

	public void setFaultAlarm(String faultAlarm) {
		this.faultAlarm = faultAlarm;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public String getFaultSubType() {
		return faultSubType;
	}

	public void setFaultSubType(String faultSubType) {
		this.faultSubType = faultSubType;
	}

	public String getCollectMethod() {
		return collectMethod;
	}

	public void setCollectMethod(String collectMethod) {
		this.collectMethod = collectMethod;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}
}
