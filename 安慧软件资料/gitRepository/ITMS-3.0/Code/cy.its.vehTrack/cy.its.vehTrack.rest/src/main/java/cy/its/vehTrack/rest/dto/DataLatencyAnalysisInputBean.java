package cy.its.vehTrack.rest.dto;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class DataLatencyAnalysisInputBean  extends BaseDto{
	
	@ApiParam(name="������ʼʱ��",value="fromDate",required=true)
	private String fromDate;
	@ApiParam(name="��������ʱ��",value="endDate",required=true)
	private String endDate;
	
	/**
	 * ������������
	 */
	@ApiParam(name="������������",value="distritCode")
	private String distritCode;
	
	@ApiParam(name="��֯��������",value="orgId")
	private String orgId;
	
	
	@ApiParam(name="�����豸���",value="deviceSysNbr")
	private String deviceSysNbr;
	
	@ApiParam(name="������Ļ��߽���ƽ̨Id",value="serverId")
	private String serverId;
	
	@ApiParam(name="���ڵȼ�(����)",value="deviceType")
	private String deviceType;
	
	@ApiParam(name="��ʼʱ���",value="startTime")
	private String startTime;
	
	@ApiParam(name="����ʱ���",value="����ʱ���")
	private String endTime;

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDistritCode() {
		return distritCode;
	}

	public void setDistritCode(String distritCode) {
		this.distritCode = distritCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
