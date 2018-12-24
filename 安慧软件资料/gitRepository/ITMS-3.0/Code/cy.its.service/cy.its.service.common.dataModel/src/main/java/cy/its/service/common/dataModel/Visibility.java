package cy.its.service.common.dataModel;

import java.util.Date;

/**
 * �ܼ���
 * @author STJ
 *
 */
public class Visibility extends Model {
	/**
	 * ϵͳ���
	 */
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;

	/**
	 * ��������
	 */
	@Mapper("ORG_CODE")
	private String orgCode;

	/**
	 * ��λ����
	 */
	@Mapper("SITE_CODE")
	private String siteCode;

	/**
	 * һ�����ܼ���ֵ
	 */
	@Mapper("ONE_MINUTE_VISIBILITY")
	private long oneMinuteVisibility;

	/**
	 * ʮ�����ܼ���ֵ
	 */
	@Mapper("TEN_MINUTE_VISIBILITY")
	private long tenMinuteVisibility;

	/**
	 * ���ȼ�
	 */
	@Mapper("CLEAN_DEGRE")
	private long cleanDegre;

	/**
	 * �����¶�
	 */
	@Mapper("CASE_TEMPERATURE")
	private long caseTemperature;

	/**
	 * ��Դ��ѹ
	 */
	@Mapper("POWER_VOLATAGE")
	private String powerVolatage;

	/**
	 * ��¼ʱ��
	 */
	@Mapper("RECORD_TIME")
	private Date recordTime;

	/**
	 * ����Ȩ�޹��˴���
	 */
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public long getOneMinuteVisibility() {
		return oneMinuteVisibility;
	}

	public void setOneMinuteVisibility(long oneMinuteVisibility) {
		this.oneMinuteVisibility = oneMinuteVisibility;
	}

	public long getTenMinuteVisibility() {
		return tenMinuteVisibility;
	}

	public void setTenMinuteVisibility(long tenMinuteVisibility) {
		this.tenMinuteVisibility = tenMinuteVisibility;
	}

	public long getCleanDegre() {
		return cleanDegre;
	}

	public void setCleanDegre(long cleanDegre) {
		this.cleanDegre = cleanDegre;
	}

	public long getCaseTemperature() {
		return caseTemperature;
	}

	public void setCaseTemperature(long caseTemperature) {
		this.caseTemperature = caseTemperature;
	}

	public String getPowerVolatage() {
		return powerVolatage;
	}

	public void setPowerVolatage(String powerVolatage) {
		this.powerVolatage = powerVolatage;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
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
