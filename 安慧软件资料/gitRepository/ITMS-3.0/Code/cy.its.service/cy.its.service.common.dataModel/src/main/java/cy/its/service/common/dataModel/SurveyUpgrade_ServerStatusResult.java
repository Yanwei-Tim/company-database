package cy.its.service.common.dataModel;

import java.util.Date;
import java.util.List;

public class SurveyUpgrade_ServerStatusResult {
	String surveySystemId;
	String surveySystemName;
	String orgPrivilegeCode;
	String serverId;
	String serverIP;
	
	/**
	 * ������
	 */
	String hostName;
	
	/**
	 * ����汾
	 */
	String softVersion;
	
	/**
	 * ����������ʱ��,yyyy-MM-dd HH:mm:ss
	 * ��δ�յ�ʱΪ��
	 */
	Date hostStartTime;
	
	/**
	 * ��������ǰʱ��, yyyy-MM-dd HH:mm:ss
	 * ��δ�յ�ʱΪ��
	 */
	Date hostCurrTime;
	
	/**
	 * ����������,%
	 */
	Integer networkUsage;
	
	/**
	 * ���ڴ棬kb
	 */
	Long memoryTotal;
	
	/**
	 * �����ڴ�,  %
	 */
	Long memoryUsage;

	/**
	 * cpu������,%
	 */
	Integer cpuUsage;
	
	/**
	 * IOPS-Input
	 */
	Integer inputPerSec;
	
	/**
	 * IOPS-Output
	 */
	Integer outputPerSec;
	
	/**
	 * ������״̬����ʱ��
	 * ������״̬��δ�յ�ʱΪ��
	 */
	Date updateTime;
	
	Integer msgType;
	Integer reportCycle;
	Integer timeResult;
    
    /**
     * ������״̬   0 ����   1 �쳣   2 δ�յ�
     */
    Integer status;
    
    /**
     * ������״̬����
     */
    String statusDescription;
    
    /**
     * �������ϵķ���״̬
     * ����״̬��δ�յ�ʱ�������б�Ϊ��
     */
	List<SurveyUpgrade_ServiceStatusResult> lstServiceStatus;

	public String getSurveySystemId() {
		return surveySystemId;
	}

	public void setSurveySystemId(String surveySystemId) {
		this.surveySystemId = surveySystemId;
	}

	public String getSurveySystemName() {
		return surveySystemName;
	}

	public void setSurveySystemName(String surveySystemName) {
		this.surveySystemName = surveySystemName;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getSoftVersion() {
		return softVersion;
	}

	public void setSoftVersion(String softVersion) {
		this.softVersion = softVersion;
	}

	public Date getHostStartTime() {
		return hostStartTime;
	}

	public void setHostStartTime(Date hostStartTime) {
		this.hostStartTime = hostStartTime;
	}

	public Date getHostCurrTime() {
		return hostCurrTime;
	}

	public void setHostCurrTime(Date hostCurrTime) {
		this.hostCurrTime = hostCurrTime;
	}

	public Integer getNetworkUsage() {
		return networkUsage;
	}

	public void setNetworkUsage(Integer networkUsage) {
		this.networkUsage = networkUsage;
	}

	public Long getMemoryTotal() {
		return memoryTotal;
	}

	public void setMemoryTotal(Long memoryTotal) {
		this.memoryTotal = memoryTotal;
	}

	public Long getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(Long memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public Integer getCpuUsage() {
		return cpuUsage;
	}

	public void setCpuUsage(Integer cpuUsage) {
		this.cpuUsage = cpuUsage;
	}

	public Integer getInputPerSec() {
		return inputPerSec;
	}

	public void setInputPerSec(Integer inputPerSec) {
		this.inputPerSec = inputPerSec;
	}

	public Integer getOutputPerSec() {
		return outputPerSec;
	}

	public void setOutputPerSec(Integer outputPerSec) {
		this.outputPerSec = outputPerSec;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getMsgType() {
		return msgType;
	}

	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	public Integer getReportCycle() {
		return reportCycle;
	}

	public void setReportCycle(Integer reportCycle) {
		this.reportCycle = reportCycle;
	}

	public Integer getTimeResult() {
		return timeResult;
	}

	public void setTimeResult(Integer timeResult) {
		this.timeResult = timeResult;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public List<SurveyUpgrade_ServiceStatusResult> getLstServiceStatus() {
		return lstServiceStatus;
	}

	public void setLstServiceStatus(List<SurveyUpgrade_ServiceStatusResult> lstServiceStatus) {
		this.lstServiceStatus = lstServiceStatus;
	}
}
