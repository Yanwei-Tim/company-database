package cy.its.service.common.dataModel;

import java.util.Date;

/**
 * @Title: Violation.java
 * @Package cy.its.service.common.dataModel
 * @Description: �淶�����Υ��
 * @author STJ lijun@cychina.cn
 * @date 2015��11��8�� ����9:34:04
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */
public class Violation extends Model {
	/**
	 * ������ϢID
	 */
	@Mapper("VEHICLE_REG_ID")
	private String vehicleRegId;

	/**
	 * ϵͳ���
	 */
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;
	
	/**
	 * �豸���
	 */
	@Mapper("DEVICE_NBR")
	private String deviceNbr;

	/**
	 * ץ�ı��
	 */
	@Mapper("SNAP_NBR")
	private String snapNbr;

	/**
	 * �ɼ����ر��
	 */
	@Mapper("ORG_CODE")
	private String orgCode;
	
	@Mapper("ORG_AUTHORITY_CODE")
	private String orgAuthorityCode;

	/**
	 * �ɼ���ʽ��013����1��������豸 2����·�����豸 3�������豸 4����·���� 5���ƶ����� 6������ͨ 7��������� 8�����Ƕ�λװ��
	 * 9�����������豸
	 */
	@Mapper("COLLECTION_TYPE")
	private String collectionType;

	/**
	 * ��������
	 */
	@Mapper("DISTRICT_CODE")
	private String districtCode;

	/**
	 * Υ���ص����
	 */
	@Mapper("VIO_SITE_CODE")
	private String vioSiteCode;

	/**
	 * Υ���ص�����
	 */
	@Mapper("ADDRESS_DESC")
	private String addressDesc;

	/**
	 * ��·����
	 */
	@Mapper("ROAD_CODE")
	private String roadCode;
	
	/**
	 * ·�δ���
	 */
	@Mapper("ROAD_SECTION_CODE")
	private String roadSectionCode;
	
	/**
	 * ·�ڴ���
	 */
	@Mapper("CROSS_CODE")
	private String crossCode;


	/**
	 * ����·������
	 */
	@Mapper("MILEAGE")
	private int mileage;

	/**
	 * �������ͣ�070��
	 */
	@Mapper("DIRECTION_TYPE")
	private String directionType;

	/**
	 * ��������
	 */
	@Mapper("DIRECTION_NAME")
	private String directionName;

	/**
	 * �������
	 */
	@Mapper("LANE_NBR")
	private String laneNbr;

	/**
	 * ���ƺ���
	 */
	@Mapper("PLATE_NBR")
	private String plateNbr;

	/**
	 * ��������(002)
	 */
	@Mapper("PLATE_TYPE")
	private String plateType;

	/**
	 * ������ɫ(003)
	 */
	@Mapper("PLATE_COLOR")
	private String plateColor;

	/**
	 * Υ��ʱ��
	 */
	@Mapper("VIOLATION_TIME")
	private Date violationTime;

	/**
	 * Υ������(011)
	 */
	@Mapper("VIOLATION_TYPE")
	private String violationType;

	/**
	 * Υ����Ϊ����
	 */
	@Mapper("VIOLATION_CODE")
	private String violationCode;

	/**
	 * Υ����Ϊ����
	 */
	@Mapper("VIOLATION_DESC")
	private String violationDesc;

	/**
	 * ����
	 */
	@Mapper("SPEED")
	private int speed;

	/**
	 * ���޸���
	 */
	@Mapper("LIMIT_LARGE")
	private int limitLarge;

	/**
	 * С���޸���
	 */
	@Mapper("LIMIT_SMALL")
	private int limitSmall;

	/**
	 * �޵���
	 */
	@Mapper("LIMIT_LOWER")
	private int limitLower;

	/**
	 * ���ٱ�
	 */
	@Mapper("OVER_SPEED_PERCENT")
	private int overSpeedPercent;

	/**
	 * ������ڵص����
	 */
	@Mapper("ENTRY_SITE_CODE")
	private String entrySiteCode;

	/**
	 * �������ʱ��
	 */
	@Mapper("REGION_ENTRY_TIME")
	private Date regionEntryTime;

	/**
	 * �������
	 */
	@Mapper("REGION_DISTANCE")
	private Long regionDistance;

	/**
	 * ��ƿ�ʼʱ��
	 */
	@Mapper("RED_LIGHT_BEGIN_TIME")
	private Date redLightBeginTime;

	/**
	 * ��ƽ���ʱ��
	 */
	@Mapper("RED_LIGHT_END_TIME")
	private Date redLightEndTime;

	/**
	 * �������309����1���ƶ����٣�2��������٣�3���̶�����٣�4��������Ȧ���� 5�������״����
	 */
	@Mapper("SPEEDING_TYPE")
	private String speedingType;

	/**
	 * ���⳵�����ͣ�311����1�����Ƴ���2�����Ƴ���3������������4����������5��ũ�ó���6��Ħ�г�
	 * 
	 */
	@Mapper("SPECIAL_VEH_TYPE")
	private String specialVehType;

//	/**
//	 * ����ʱ��
//	 */
//	@Mapper("CREATE_TIME")
//	private Date createTime;
//
//	/**
//	 * ����ʱ��
//	 */
//	@Mapper("UPDATE_TIME")
//	private Date updateTime;

	/**
	 * ͼƬ�洢·��
	 */
	@Mapper("IMAGE")
	private String image;

	/**
	 * ��Ƶ�洢·��
	 */
	@Mapper("VIDEO")
	private String video;

	/**
	 * ��ע
	 */
	@Mapper("REMARK")
	private String remark;

	/**
	 * ������
	 */
	@Mapper("VEH_LOCALIZATION")
	private String vehLocalization;

	public String getVehicleRegId() {
		return vehicleRegId;
	}

	public void setVehicleRegId(String vehicleRegId) {
		this.vehicleRegId = vehicleRegId;
	}
	
	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getDeviceNbr() {
		return deviceNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceNbr = deviceNbr;
	}

	public String getSnapNbr() {
		return snapNbr;
	}

	public void setSnapNbr(String snapNbr) {
		this.snapNbr = snapNbr;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
	public String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}

	public void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getVioSiteCode() {
		return vioSiteCode;
	}

	public void setVioSiteCode(String vioSiteCode) {
		this.vioSiteCode = vioSiteCode;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}

	public String getRoadSectionCode() {
		return roadSectionCode;
	}

	public void setRoadSectionCode(String roadSectionCode) {
		this.roadSectionCode = roadSectionCode;
	}

	public String getCrossCode() {
		return crossCode;
	}

	public void setCrossCode(String crossCode) {
		this.crossCode = crossCode;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getLaneNbr() {
		return laneNbr;
	}

	public void setLaneNbr(String laneNbr) {
		this.laneNbr = laneNbr;
	}

	public String getPlateNbr() {
		return plateNbr;
	}

	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	public Date getViolationTime() {
		return violationTime;
	}

	public void setViolationTime(Date violationTime) {
		this.violationTime = violationTime;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public String getViolationCode() {
		return violationCode;
	}

	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	public String getViolationDesc() {
		return violationDesc;
	}

	public void setViolationDesc(String violationDesc) {
		this.violationDesc = violationDesc;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLimitLarge() {
		return limitLarge;
	}

	public void setLimitLarge(int limitLarge) {
		this.limitLarge = limitLarge;
	}

	public int getLimitSmall() {
		return limitSmall;
	}

	public void setLimitSmall(int limitSmall) {
		this.limitSmall = limitSmall;
	}

	public int getLimitLower() {
		return limitLower;
	}

	public void setLimitLower(int limitLower) {
		this.limitLower = limitLower;
	}

	public int getOverSpeedPercent() {
		return overSpeedPercent;
	}

	public void setOverSpeedPercent(int overSpeedPercent) {
		this.overSpeedPercent = overSpeedPercent;
	}

	public String getEntrySiteCode() {
		return entrySiteCode;
	}

	public void setEntrySiteCode(String entrySiteCode) {
		this.entrySiteCode = entrySiteCode;
	}

	public Date getRegionEntryTime() {
		return regionEntryTime;
	}

	public void setRegionEntryTime(Date regionEntryTime) {
		this.regionEntryTime = regionEntryTime;
	}

	public Long getRegionDistance() {
		return regionDistance;
	}

	public void setRegionDistance(Long regionDistance) {
		this.regionDistance = regionDistance;
	}

	public Date getRedLightBeginTime() {
		return redLightBeginTime;
	}

	public void setRedLightBeginTime(Date redLightBeginTime) {
		this.redLightBeginTime = redLightBeginTime;
	}

	public Date getRedLightEndTime() {
		return redLightEndTime;
	}

	public void setRedLightEndTime(Date redLightEndTime) {
		this.redLightEndTime = redLightEndTime;
	}

	public String getSpeedingType() {
		return speedingType;
	}

	public void setSpeedingType(String speedingType) {
		this.speedingType = speedingType;
	}

	public String getSpecialVehType() {
		return specialVehType;
	}

	public void setSpecialVehType(String specialVehType) {
		this.specialVehType = specialVehType;
	}

//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}
//
//	public Date getUpdateTime() {
//		return updateTime;
//	}
//
//	public void setUpdateTime(Date updateTime) {
//		this.updateTime = updateTime;
//	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getVehLocalization() {
		return vehLocalization;
	}

	public void setVehLocalization(String vehLocalization) {
		this.vehLocalization = vehLocalization;
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
