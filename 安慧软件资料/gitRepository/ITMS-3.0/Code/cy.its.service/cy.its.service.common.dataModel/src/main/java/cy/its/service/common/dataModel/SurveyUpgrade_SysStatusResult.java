package cy.its.service.common.dataModel;

import java.util.Date;
import java.util.List;

public class SurveyUpgrade_SysStatusResult extends Model {	

	/**
	 * ϵͳID
	 */
	private String deviceId;

	/**
	 * ϵͳ���
	 */
	private String deviceSysNbr;

//	/**
//	 * ϵͳ���
//	 */
//	private String deviceKey;
	
	/**
	 * �豸����
	 */
	private String deviceType;

	/**
	 * ϵͳ��������Ȩ�޴���
	 */
	private String orgPrivilegeCode;
	
	/**
	 * ��λ����
	 */
	private String siteCode;
	
	/**
	 * ״̬����ʱ��
	 */
	private Date statusUpdateTime;

	/**
	 * ״̬����
	 */
	private int statusType;

	/**
	 * ��ϸ�������б� ע:��ϵͳΪ������ �����ϵͳʱ, ���豸Ϊ�޹���ʱ���б���ֵ;
	 */
	private List<String> faultDetails;

	/**
	 * ����״̬�б� ע: ��ϵͳΪ������ �����ϵͳʱ, ���б��;
	 */
	private List<SurveyUpgrade_ComponentStatusResult> componentStatusResults;
	
	/**
	 * �豸��ǰʱ��
	 * ע: ��ϵͳ�������ʱ, ��ֵΪʱ������ֵ�����Ǹ�������豸��ǰʱ��
	 */
	private Date deviceCurTime;
	
	/**
	 * ʱ���   ��λ:��
	 * ������ʾ��ط�����ʱ����豸(���)��ǰʱ���(��)
	 * ��ֵ��ʾ��ط�����ʱ����豸(���)��ǰʱ��С(��)
	 * ע: ��ϵͳ�������ʱ, ��ֵΪʱ������ֵ�����Ǹ�����Ĳ�ֵ
	 */
	private Integer timeDiff;
	
	/**
	 * ��������ϴ�ʱ��
	 */
	private Date lastUploadTime;
	
	/**
	 * ����豸��������������ʱ��
	 */
	private Date latestDataTime;
	
	public SurveyUpgrade_SysStatusResult() {
	}

	public SurveyUpgrade_SysStatusResult(String deviceId, String deviceSysNbr, String deviceType,
			String orgPrivilegeCode, String siteCode, Date statusUpdateTime, int statusType, List<String> faultDetails,
			List<SurveyUpgrade_ComponentStatusResult> componentStatusResults, Date deviceCurTime, Integer timeDiff, Date lastUploadTime, Date latestDataTime) {
		super();
		this.deviceId = deviceId;
		this.deviceSysNbr = deviceSysNbr;
//		this.deviceKey = deviceKey;
		this.deviceType = deviceType;
		this.orgPrivilegeCode = orgPrivilegeCode;
		this.siteCode = siteCode;
		this.statusUpdateTime = statusUpdateTime;
		this.statusType = statusType;
		this.faultDetails = faultDetails;
		this.componentStatusResults = componentStatusResults;
		this.deviceCurTime = deviceCurTime;
		this.timeDiff = timeDiff;
		this.lastUploadTime = lastUploadTime;
		this.latestDataTime = latestDataTime;
	}

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

//	public String getDeviceKey() {
//		return deviceKey;
//	}
//
//	public void setDeviceKey(String deviceKey) {
//		this.deviceKey = deviceKey;
//	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public Date getStatusUpdateTime() {
		return statusUpdateTime;
	}

	public void setStatusUpdateTime(Date statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}

	public int getStatusType() {
		return statusType;
	}

	public void setStatusType(int statusType) {
		this.statusType = statusType;
	}

	public List<String> getFaultDetails() {
		return faultDetails;
	}

	public void setFaultDetails(List<String> faultDetails) {
		this.faultDetails = faultDetails;
	}

	public List<SurveyUpgrade_ComponentStatusResult> getComponentStatusResults() {
		return componentStatusResults;
	}

	public void setComponentStatusResults(List<SurveyUpgrade_ComponentStatusResult> componentStatusResults) {
		this.componentStatusResults = componentStatusResults;
	}
	
	public Date getDeviceCurTime() {
		return deviceCurTime;
	}

	public void setDeviceCurTime(Date deviceCurTime) {
		this.deviceCurTime = deviceCurTime;
	}

	public Integer getTimeDiff() {
		return timeDiff;
	}

	public void setTimeDiff(Integer timeDiff) {
		this.timeDiff = timeDiff;
	}

	public Date getLastUploadTime() {
		return lastUploadTime;
	}

	public void setLastUploadTime(Date lastUploadTime) {
		this.lastUploadTime = lastUploadTime;
	}

	public Date getLatestDataTime() {
		return latestDataTime;
	}

	public void setLatestDataTime(Date latestDataTime) {
		this.latestDataTime = latestDataTime;
	}
}
