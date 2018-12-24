package cy.its.service.analysisAlarm.domain;

import java.util.Date;

/**
* @Title: RoadSensor.java 
* @Package cy.its.service.weather.domain 
* @Description:·�н���������Ϣ
* @author lil@cychina.cn
* @date 2015��11��13�� ����3:09:02 
* @version V1.0   
 */
public class RoadSensor {
	/**
	 *ϵͳ���
	 */
	private String  deviceSysNbr;
	/**
	 *��������
	 */
	private String  orgCode;
	/**
	 *��λ����
	 */
	private String  siteCode;
	/**
	 *·���¶�
	 */
	private double  roadTemperature;
	/**
	 *·���¶�
	 */
	private double  roadbedTemperature;
	/**
	 *ˮĤ���
	 */
	private double  waterFileHeigh;
	/**
	 *������
	 */
	private double  salinity;
	/**
	 *������¶�
	 */
	private double  freezingTemperature;
	
	/**
	 * ��·����
	 */
	private String roadType;
	/**
	 *��·״��
	 */
	private String  roadCondition;
	/**
	 *��¼ʱ��
	 */
	private Date  recordTime;
	/**
	 *����Ȩ�޹��˴���
	 */
	private String  orgPrivilegeCode;
	
	/**
	 *�豸ID
	 */
	private String  deviceId="";
	
	
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
	public double getRoadTemperature() {
		return roadTemperature;
	}
	public void setRoadTemperature(double roadTemperature) {
		this.roadTemperature = roadTemperature;
	}
	public double getRoadbedTemperature() {
		return roadbedTemperature;
	}
	public void setRoadbedTemperature(double roadbedTemperature) {
		this.roadbedTemperature = roadbedTemperature;
	}
	public double getWaterFileHeigh() {
		return waterFileHeigh;
	}
	public void setWaterFileHeigh(double waterFileHeigh) {
		this.waterFileHeigh = waterFileHeigh;
	}
	public double getSalinity() {
		return salinity;
	}
	public void setSalinity(double salinity) {
		this.salinity = salinity;
	}
	public double getFreezingTemperature() {
		return freezingTemperature;
	}
	public void setFreezingTemperature(double freezingTemperature) {
		this.freezingTemperature = freezingTemperature;
	}
	public String getRoadType() {
		return roadType;
	}
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	public String getRoadCondition() {
		return roadCondition;
	}
	public void setRoadCondition(String roadCondition) {
		this.roadCondition = roadCondition;
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
}
