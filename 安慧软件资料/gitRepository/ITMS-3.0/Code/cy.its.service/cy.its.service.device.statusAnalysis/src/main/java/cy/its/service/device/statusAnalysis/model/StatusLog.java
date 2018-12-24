package cy.its.service.device.statusAnalysis.model;

import java.util.Date;

import cy.its.service.common.dataAccess.MapColumn;

public class StatusLog {

	/**
	 * ���Ӽ��ϵͳID
	 */
	@MapColumn
	public String deviceId;

	/**
	 * �豸״̬��1��������2���ѻ���3������
	 */
	@MapColumn
	public String statusType;

	/**
	 * ��ʼʱ��
	 */
	@MapColumn
	public Date startTime;

	/**
	 * ����ʱ��
	 */
	@MapColumn
	public Date endTime;

	public StatusLog(){}
	
	// /**
	// * ����ʱ��
	// */
	// public Long durationSecs;
	// , Long durationSecs
	public StatusLog(String deviceId, String statusType, Date startTime, Date endTime) {
		this.deviceId = deviceId;
		this.statusType = statusType;
		this.startTime = startTime;
		this.endTime = endTime;
		// this.durationSecs = durationSecs;
	}
	
	public String getDeviceId() {
		return this.deviceId;
	}
}
