package cy.its.service.common.dataModel;

import java.util.Date;
import java.util.List;

public class SurveyUpgrade_ComponentStatusResult extends Model {
	/**
	 * ����id
	 */
	private String sysComponentId;

	/**
	 * ����豸���
	 */
	private String deviceNbr;
	
	/**
	 * ����豸���
	 */
	private String deviceKey;

	/**
	 * ���״̬����ʱ��
	 */
	private Date statusUpdateTime;

	/**
	 * ���״̬����
	 */
	private int statusType;

	/**
	 * �������б�
	 */
	private List<String> faultDetails;
	
	/**
	 * �����ǰʱ��
	 */
	private Date deviceCurTime;
	
	/**
	 * ʱ���   ��λ:��
	 * ������ʾ��ط�����ʱ����豸(���)��ǰʱ���(��)
	 * ��ֵ��ʾ��ط�����ʱ����豸(���)��ǰʱ��С(��)
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

	public SurveyUpgrade_ComponentStatusResult(String sysComponentId, String deviceNbr, String deviceKey,
			Date statusUpdateTime, int statusType, List<String> faultDetails, Date deviceCurTime, Integer timeDiff, Date lastUploadTime, Date latestDataTime) {
		this.sysComponentId = sysComponentId;
		this.deviceNbr = deviceNbr;
		this.deviceKey = deviceKey;
		this.statusUpdateTime = statusUpdateTime;
		this.statusType = statusType;
		this.faultDetails = faultDetails;
		this.deviceCurTime = deviceCurTime;
		this.timeDiff = timeDiff;
		this.lastUploadTime = lastUploadTime;
		this.latestDataTime = latestDataTime;
	}

	public String getSysComponentId() {
		return sysComponentId;
	}

	public void setSysComponentId(String sysComponentId) {
		this.sysComponentId = sysComponentId;
	}

	public String getDeviceNbr() {
		return deviceNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceNbr = deviceNbr;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
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
