package cy.its.service.common.dataModel;

import java.util.Date;

public class TrafficEvent extends Model {

	/**
	 * ��������
	 */
	@Mapper("ORG_CODE")
	private String orgCode;

	/**
	 * ϵͳ���
	 */
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;

	/**
	 * ��λ����
	 */
	@Mapper("SITE_CODE")
	private String siteCode;

	/**
	 * ·��Ԥ���¼����1 ����Ԥ�� 2 ����Ԥ�� 3 ��ͨ�¼� 4 �˹���¼
	 */
	@Mapper("ALARM_EVENT_TYPE")
	private String alarmEventType;

	/**
	 * ��ͨ�¼����� 
	 *   300 ������
	 *   301 ӵ�� 
	 *   302 ͣ�� 
	 *   303 Υͣ 
	 *   304 ���� 
	 *   305 ���� 
	 *   306 �������������Ƭ
	 *   307 ����
	 */
	@Mapper("SUB_ALARM_EVENT")
	private String subAlarmEvent;

	/**
	 * Ԥ����ʼʱ��
	 */
	@Mapper("START_ALARM_TIME")
	private Date startAlarmTime;

	/**
	 * Ԥ������
	 */
	@Mapper("ALARM_DESC")
	private String alarmDesc;

	/**
	 * ����Ȩ�޹��˴���
	 */
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getAlarmEventType() {
		return alarmEventType;
	}

	public void setAlarmEventType(String alarmEventType) {
		this.alarmEventType = alarmEventType;
	}

	public String getSubAlarmEvent() {
		return subAlarmEvent;
	}

	public void setSubAlarmEvent(String subAlarmEvent) {
		this.subAlarmEvent = subAlarmEvent;
	}

	public Date getStartAlarmTime() {
		return startAlarmTime;
	}

	public void setStartAlarmTime(Date startAlarmTime) {
		this.startAlarmTime = startAlarmTime;
	}

	public String getAlarmDesc() {
		return alarmDesc;
	}

	public void setAlarmDesc(String alarmDesc) {
		this.alarmDesc = alarmDesc;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}
	
    private String deviceId;
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
