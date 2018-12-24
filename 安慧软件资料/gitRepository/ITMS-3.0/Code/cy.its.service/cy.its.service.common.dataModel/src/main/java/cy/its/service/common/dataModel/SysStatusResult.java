package cy.its.service.common.dataModel;

import java.util.Date;
import java.util.List;

/**
 * @Title: SysStatusResult.java
 * @Package cy.its.service.common.dataModel
 * @Description: �豸״̬�������
 * @author STJ lijun@cychina.cn
 * @date 2015��11��8�� ����9:34:23
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 *      Company: ���ճ�Զ��Ϣ�������޹�˾ Copyright: Copyright (c) 2015
 */
public class SysStatusResult {

	public SysStatusResult() {
	}

	public SysStatusResult(String deviceId, String deviceSysNbr, String orgPrivilegeCode, String siteCode,
			long lastUploadTime, long statusUpdateTime, int statusType, List<Integer> statusDetails, int vehicleTotal,
			List<ComponentStatusResult> componentStatus) {
		this.deviceId = deviceId;
		this.deviceSysNbr = deviceSysNbr;
		this.orgPrivilegeCode = orgPrivilegeCode;
		this.siteCode = siteCode;
		this.lastUploadTime = lastUploadTime > 0 ? new Date(lastUploadTime) : null;
		this.statusUpdateTime = statusUpdateTime > 0 ? new Date(statusUpdateTime) : null;
		this.statusType = statusType;
		this.statusDetails = statusDetails;
		this.vehicleTotal = vehicleTotal;
		this.componentStatus = componentStatus;
	}

	public SysStatusResult(String deviceId, String deviceSysNbr, String orgPrivilegeCode, String siteCode,
			long lastUploadTime, long statusUpdateTime, int statusType, List<Integer> statusDetails, int vehicleTotal,
			List<ComponentStatusResult> componentStatus, String deviceType) {
		this(deviceId, deviceSysNbr, orgPrivilegeCode, siteCode, lastUploadTime, statusUpdateTime, statusType,
				statusDetails, vehicleTotal, componentStatus);
		this.deviceType = deviceType;
	}

	/**
	 * ϵͳID
	 */
	private String deviceId;

	/**
	 * ϵͳ���
	 */
	private String deviceSysNbr;

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
	 * ���µļ������ʱ��
	 */
	private Date lastUploadTime;

	/**
	 * ״̬����ʱ��
	 */
	private Date statusUpdateTime;

	/**
	 * ״̬����
	 */
	private int statusType;

	/**
	 * ��ϸ״̬���б� ע:��ϵͳΪ������ �����ϵͳʱ, ���б���ֵ;
	 */
	private List<Integer> statusDetails;

	/**
	 * ������
	 */
	private int vehicleTotal;

	/**
	 * ����״̬�б� ע: ��ϵͳΪ������ �����ϵͳʱ, ���б��;
	 */
	private List<ComponentStatusResult> componentStatus;

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

	public Date getLastUploadTime() {
		return lastUploadTime;
	}

	public void setLastUploadTime(Date lastUploadTime) {
		this.lastUploadTime = lastUploadTime;
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

	public List<Integer> getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(List<Integer> statusDetails) {
		this.statusDetails = statusDetails;
	}

	public int getVehicleTotal() {
		return vehicleTotal;
	}

	public void setVehicleTotal(int vehicleTotal) {
		this.vehicleTotal = vehicleTotal;
	}

	public List<ComponentStatusResult> getComponentStatus() {
		return componentStatus;
	}

	public void setComponentStatus(List<ComponentStatusResult> componentStatus) {
		this.componentStatus = componentStatus;
	}
}
