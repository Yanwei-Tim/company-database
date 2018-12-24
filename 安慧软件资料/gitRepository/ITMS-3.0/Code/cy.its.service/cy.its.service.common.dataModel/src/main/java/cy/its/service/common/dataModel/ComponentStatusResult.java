package cy.its.service.common.dataModel;

import java.util.Date;
import java.util.List;

/**
 * @Title: ComponentStatusResult.java
 * @Package cy.its.service.common.dataModel
 * @Description: ����״̬�������
 * @author STJ lijun@cychina.cn
 * @date 2015��11��8�� ����9:48:10
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 *      Company: ���ճ�Զ��Ϣ�������޹�˾ Copyright: Copyright (c) 2015
 */
public class ComponentStatusResult {
	/**
	 * ����id
	 */
	private String sysComponentId;

	/**
	 * ����豸���
	 */
	private String deviceNbr;

	/**
	 * ���״̬����ʱ��
	 */
	private Date statusUpdateTime;

	/**
	 * ���״̬����
	 */
	private int statusType;

	/**
	 * �������״̬
	 */
	private int status;

	/**
	 * ��ϸ״̬���б�
	 */
	private List<Integer> statusDetails;

	/**
	 * ������
	 */
	private int vehicleTotal;
	
	

	public ComponentStatusResult(String sysComponentId, String deviceNbr, Date statusUpdateTime, int statusType,
			int status, List<Integer> statusDetails, int vehicleTotal) {
		this.sysComponentId = sysComponentId;
		this.deviceNbr = deviceNbr;
		this.statusUpdateTime = statusUpdateTime;
		this.statusType = statusType;
		this.status = status;
		this.statusDetails = statusDetails;
		this.vehicleTotal = vehicleTotal;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
}
