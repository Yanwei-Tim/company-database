package cy.its.service.common.dataModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: TrafficFlow.java
 * @Package cy.its.service.common.dataModel
 * @Description: �淶���Ľ�ͨ����
 * @author STJ lijun@cychina.cn
 * @date 2015��11��8�� ����9:33:15
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */
public class TrafficFlow extends Model {
	
//	/**
//	 * ����ID
//	 */
//	@Mapper("FLOW_ID")
//	private String flowId;

	/**
	 * ��λ����
	 */
	@Mapper("SITE_CODE")
	private String siteCode;

	/**
	 * ϵͳ���
	 */
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;

	/**
	 * ��������
	 */
	@Mapper("DIRECTION_TYPE")
	private String directionType;

	/**
	 * ����
	 */
	@Mapper("LANE")
	private String lane;

	/**
	 * ͳ��ʱ��
	 */
	@Mapper("COUNT_TIME")
	private Date countTime;

	/**
	 * ͳ������
	 */
	@Mapper("PERIOD")
	private int period;

	/**
	 * �ܳ���
	 */
	@Mapper("TOTAL_NUM")
	private int totalNum;

	/**
	 * ƽ������
	 */
	@Mapper("AVR_SPEED")
	private BigDecimal avrSpeed;

	/**
	 * ƽ������
	 */
	@Mapper("AVR_LENGTH")
	private BigDecimal avrLength;

	/**
	 * ʱ��ռ����
	 */
	@Mapper("TIME_PERCENT")
	private BigDecimal timePercent;

	/**
	 * �ռ�ռ����
	 */
	@Mapper("SPACE_PERCENT")
	private BigDecimal spacePercent;

	/**
	 * ��ͷ���
	 */
	@Mapper("VEH_SPACE_HEADWAY")
	private BigDecimal vehSpaceHeadway;

	/**
	 * ��ͷʱ��
	 */
	@Mapper("VEH_TIME_HEADWAY")
	private BigDecimal vehTimeHeadway;

	/**
	 * �����ܶ�
	 */
	@Mapper("VEH_DENSITY")
	private BigDecimal vehDensity;

	/**
	 * ���ٳ�����
	 */
	@Mapper("LOW_SPEED_VEH_NUM")
	private BigDecimal lowSpeedVehNum;

	/**
	 * ���ٳ�����
	 */
	@Mapper("HIGH_SPEED_VEH_NUM")
	private BigDecimal highSpeedVehNum;

	/**
	 * ����
	 */
	@Mapper("LARGE_NUM")
	private int largeNum;

	/**
	 * ���ͳ���
	 */
	@Mapper("MIDDLE_NUM")
	private int middleNum;

	/**
	 * С����
	 */
	@Mapper("SMALL_NUM")
	private int smallNum;

	/**
	 * Ħ�г���
	 */
	@Mapper("MOTOR_NUM")
	private int motorNum;

	/**
	 * ����������
	 */
	@Mapper("SUPPER_LEN_VEH_NUM")
	private BigDecimal supperLenVehNum;

	/**
	 * ��������
	 */
	@Mapper("OTHER_NUM")
	private int otherNum;

	/**
	 * ʵ��ֵΪ����Ȩ�޴���
	 */
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;

	/**
	 * �豸���
	 */
	@Mapper("DEVICE_NBR")
	private String deviceNbr;

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public Date getCountTime() {
		return countTime;
	}

	public void setCountTime(Date countTime) {
		this.countTime = countTime;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public BigDecimal getAvrSpeed() {
		return avrSpeed;
	}

	public void setAvrSpeed(BigDecimal avrSpeed) {
		this.avrSpeed = avrSpeed;
	}

	public BigDecimal getAvrLength() {
		return avrLength;
	}

	public void setAvrLength(BigDecimal avrLength) {
		this.avrLength = avrLength;
	}

	public BigDecimal getTimePercent() {
		return timePercent;
	}

	public void setTimePercent(BigDecimal timePercent) {
		this.timePercent = timePercent;
	}

	public BigDecimal getSpacePercent() {
		return spacePercent;
	}

	public void setSpacePercent(BigDecimal spacePercent) {
		this.spacePercent = spacePercent;
	}

	public BigDecimal getVehSpaceHeadway() {
		return vehSpaceHeadway;
	}

	public void setVehSpaceHeadway(BigDecimal vehSpaceHeadway) {
		this.vehSpaceHeadway = vehSpaceHeadway;
	}

	public BigDecimal getVehTimeHeadway() {
		return vehTimeHeadway;
	}

	public void setVehTimeHeadway(BigDecimal vehTimeHeadway) {
		this.vehTimeHeadway = vehTimeHeadway;
	}

	public BigDecimal getVehDensity() {
		return vehDensity;
	}

	public void setVehDensity(BigDecimal vehDensity) {
		this.vehDensity = vehDensity;
	}

	public BigDecimal getLowSpeedVehNum() {
		return lowSpeedVehNum;
	}

	public void setLowSpeedVehNum(BigDecimal lowSpeedVehNum) {
		this.lowSpeedVehNum = lowSpeedVehNum;
	}

	public BigDecimal getHighSpeedVehNum() {
		return highSpeedVehNum;
	}

	public void setHighSpeedVehNum(BigDecimal highSpeedVehNum) {
		this.highSpeedVehNum = highSpeedVehNum;
	}

	public int getLargeNum() {
		return largeNum;
	}

	public void setLargeNum(int largeNum) {
		this.largeNum = largeNum;
	}

	public int getMiddleNum() {
		return middleNum;
	}

	public void setMiddleNum(int middleNum) {
		this.middleNum = middleNum;
	}

	public int getSmallNum() {
		return smallNum;
	}

	public void setSmallNum(int smallNum) {
		this.smallNum = smallNum;
	}

	public int getMotorNum() {
		return motorNum;
	}

	public void setMotorNum(int motorNum) {
		this.motorNum = motorNum;
	}

	public BigDecimal getSupperLenVehNum() {
		return supperLenVehNum;
	}

	public void setSupperLenVehNum(BigDecimal supperLenVehNum) {
		this.supperLenVehNum = supperLenVehNum;
	}

	public int getOtherNum() {
		return otherNum;
	}

	public void setOtherNum(int otherNum) {
		this.otherNum = otherNum;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getDeviceNbr() {
		return deviceNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceNbr = deviceNbr;
	}
	
    private String deviceId;
	
	private String sysComponentId;
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getSysComponentId() {
		return sysComponentId;
	}

	public void setSysComponentId(String sysComponentId) {
		this.sysComponentId = sysComponentId;
	}
}
