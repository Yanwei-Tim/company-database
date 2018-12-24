package cy.its.service.common.dataModel;

import java.math.BigDecimal;
import java.util.Date;

public class RoadSensor extends Model {
	
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
	 * ·���¶�
	 */
	@Mapper("ROAD_TEMPERATURE")
	private BigDecimal roadTemperature;

	/**
	 * ·���¶�
	 */
	@Mapper("ROADBED_TEMPERATURE")
	private BigDecimal roadbedTemperature;

	/**
	 * ˮĤ���
	 */
	@Mapper("WATER_FILE_HEIGH")
	private BigDecimal waterFileHeigh;

	/**
	 * ������
	 */
	@Mapper("SALINITY")
	private BigDecimal salinity;

	/**
	 * ������¶�
	 */
	@Mapper("FREEZING_TEMPERATURE")
	private BigDecimal freezingTemperature;

	/**
	 * ��·״��
	 */
	@Mapper("ROAD_CONDITION")
	private String roadCondition;

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

	public BigDecimal getRoadTemperature() {
		return roadTemperature;
	}

	public void setRoadTemperature(BigDecimal roadTemperature) {
		this.roadTemperature = roadTemperature;
	}

	public BigDecimal getRoadbedTemperature() {
		return roadbedTemperature;
	}

	public void setRoadbedTemperature(BigDecimal roadbedTemperature) {
		this.roadbedTemperature = roadbedTemperature;
	}

	public BigDecimal getWaterFileHeigh() {
		return waterFileHeigh;
	}

	public void setWaterFileHeigh(BigDecimal waterFileHeigh) {
		this.waterFileHeigh = waterFileHeigh;
	}

	public BigDecimal getSalinity() {
		return salinity;
	}

	public void setSalinity(BigDecimal salinity) {
		this.salinity = salinity;
	}

	public BigDecimal getFreezingTemperature() {
		return freezingTemperature;
	}

	public void setFreezingTemperature(BigDecimal freezingTemperature) {
		this.freezingTemperature = freezingTemperature;
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
	
    private String deviceId;	
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
