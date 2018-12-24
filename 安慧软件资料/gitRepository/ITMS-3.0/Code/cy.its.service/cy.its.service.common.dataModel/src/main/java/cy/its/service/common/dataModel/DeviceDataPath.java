package cy.its.service.common.dataModel;

import java.math.BigDecimal;
import java.util.Date;

public class DeviceDataPath extends Model {

	/**
	 * ���Ӽ��ϵͳID
	 */
	@Mapper("DEVICE_ID")
	private String deviceId;
	
	/**
	 * ���ID
	 */
	@Mapper("SYS_COMPONENT_ID")
	private String sysComponentId;
	
	/**
	 * ����Ȩ�޴���
	 */
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;

	/**
	 * ϵͳ���
	 */
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;

	/**
	 * �豸���
	 */
	private String deviceNbr;

	/**
	 * ץ�ı��
	 */
	@Mapper("SNAP_NBR")
	private String snapNbr;

	/**
	 * ����ʱ��
	 */
	@Mapper("PASS_TIME")
	private Date passTime;

	/**
	 * ��ط���������ʱ��
	 */
	@Mapper("SERVER_RECEIVING_TIME")
	private Date serverReceivingTime;
	
	/**
	 * ���ü�ط���������ʱ��
	 */
	@Mapper("AFTER_SERVER_RECEIVING_TIME")
	private Date afterserverReceivingTime;
	
	/**
	 * ICE2MQ����ʱ��
	 */
	@Mapper("ICE2MQ_TIME")
	private Date ice2mqTime;

	/**
	 * ǰ�û�����ʱ��
	 */
	@Mapper("PRE_TIME")
	private Date preTime;

	/**
	 * ���û�����ʱ��
	 */
	@Mapper("AFTER_TIME")
	private Date afterTime;

	/**
	 * ���鲼��ϵͳ�ϴ���ʼʱ��
	 */
	@Mapper("UPLOAD_TIME")
	private Date uploadTime;

	/**
	 * ���鲼��ϵͳ�ϴ�����ʱ��
	 */
	@Mapper("UPLOAD_END_TIME")
	private Date uploadEndTime;

	/**
	 * �ܺ�ʱ����λΪ�롣
	 */
	@Mapper("TOTAL_TIME")
	private BigDecimal totalTime;

	/**
	 * Ψһֵ
	 */
	@Mapper("DEVICE_KEY")
	private String deviceKey;

	@Mapper("SITE_CODE")
	private String siteCode;	
	
	@Mapper("ROAD_CODE")
	private String roadCode;

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getSysComponentId() {
		return sysComponentId;
	}

	public void setSysComponentId(String sysComponentId) {
		this.sysComponentId = sysComponentId;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getDeviceNbr() {
		return deviceNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceNbr = deviceNbr;
	}

	public String getSnapNbr() {
		return snapNbr;
	}

	public void setSnapNbr(String snapNbr) {
		this.snapNbr = snapNbr;
	}

	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public Date getServerReceivingTime() {
		return serverReceivingTime;
	}

	public void setServerReceivingTime(Date serverReceivingTime) {
		this.serverReceivingTime = serverReceivingTime;
	}
	
	public Date getAfterserverReceivingTime() {
		return afterserverReceivingTime;
	}

	public void setAfterserverReceivingTime(Date afterserverReceivingTime) {
		this.afterserverReceivingTime = afterserverReceivingTime;
	}

	public Date getIce2mqTime() {
		return ice2mqTime;
	}

	public void setIce2mqTime(Date ice2mqTime) {
		this.ice2mqTime = ice2mqTime;
	}

	public Date getPreTime() {
		return preTime;
	}

	public void setPreTime(Date preTime) {
		this.preTime = preTime;
	}

	public Date getAfterTime() {
		return afterTime;
	}

	public void setAfterTime(Date afterTime) {
		this.afterTime = afterTime;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Date getUploadEndTime() {
		return uploadEndTime;
	}

	public void setUploadEndTime(Date uploadEndTime) {
		this.uploadEndTime = uploadEndTime;
	}

	public BigDecimal getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(BigDecimal totalTime) {
		this.totalTime = totalTime;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}
}
