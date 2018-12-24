package cy.its.service.common.dataModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: VehTrackPass.java
 * @Package cy.its.service.common.dataModel
 * @Description: �淶����Ĺ���
 * @author STJ lijun@cychina.cn
 * @date 2015��11��8�� ����9:33:34
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */
public class VehTrackPass extends Model {

	// /**
	// * ����ID
	// */
	// private String vehiclePassId;	
	

	/**
	 * ץ�ı��
	 */
	@Mapper("SNAP_NBR")
	private String snapNbr;

	/**
	 * ϵͳ���
	 */
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;

	/**
	 * ��������(007)
	 */
	@Mapper("DISTRICT_CODE")
	private String districtCode;

	/**
	 * ��λ����
	 */
	@Mapper("SITE_CODE")
	private String siteCode;

	/**
	 * ��·����
	 */
	@Mapper("ROAD_CODE")
	private String roadCode;

	/**
	 * ��·����
	 */
	@Mapper("ROAD_TYPE")
	private String roadType;

	/**
	 * ·�δ���
	 */
	@Mapper("ROAD_SECTION_CODE")
	private String roadSectionCode;

	/**
	 * ǰ���豸�ϴ����Զ��巽������
	 */
	@Mapper("DIRECTION_NAME")
	private String directionName;

	/**
	 * �������ͣ�070��
	 */
	@Mapper("DIRECTION_TYPE")
	private String directionType;

	/**
	 * ������
	 */
	@Mapper("LANE")
	private String lane;

	/**
	 * ���ƺ���
	 */
	@Mapper("PLATE_NBR")
	private String plateNbr;

	/**
	 * ������ɫ(003)
	 */
	@Mapper("PLATE_COLOR")
	private String plateColor;

	/**
	 * ��������(002)
	 */
	@Mapper("PLATE_TYPE")
	private String plateType;

	/**
	 * β�ƺ���
	 */
	@Mapper("TAIL_PLATE_NBR")
	private String tailPlateNbr;

	/**
	 * β����ɫ(003)
	 */
	@Mapper("TAIL_PLATE_COLOR")
	private String tailPlateColor;

	/**
	 * ����Ʒ��
	 */
	@Mapper("VEHICLE_BRAND")
	private String vehicleBrand;

	/**
	 * ������Ʒ��
	 */
	@Mapper("VEHICLE_SUB_BRAND")
	private String vehicleSubBrand;

	/**
	 * �������͡��ο����һ��������ʹ����GA802��GA24.4��ֻ��ʶ�������������ļ�1λ������루H��K��M�ȣ���ֻ��ʶ�������͹��ļ�2λ��
	 * ȫʶ��ļ�3λ��ֻ��ʶ������������ļ�2λ���֣���һλ��0���루1���󳵣�2�����ͳ���3��С�ͳ���4��΢�ͳ�����Ħ�г�ΪM1��M2
	 */
	@Mapper("VEHICLE_TYPE")
	private String vehicleType;

	/**
	 * ����ʹ�����ʡ�GA802-2008�����ջ��鲼��ϵͳ���룺 0��δ������ϵͳ���䣩 G ���� H ���� I ���� J �Ȼ� K ���̾��� L
	 * Ӫת�� M ����ת�� N ���� O �׶�У�� P Сѧ��У�� Q ������У�� S ��Сѧ��У�� R Σ��Ʒ���� A ��Ӫ�� B ��·���� C
	 * �������� D ������� E ���ο��� F ����
	 */
	@Mapper("VEH_CHARCTER")
	private String vehCharcter;

	/**
	 * ��������
	 */
	@Mapper("VEHICLE_SHAPE")
	private String vehicleShape;

	/**
	 * ����
	 */
	@Mapper("VEHICLE_LENGTH")
	private BigDecimal vehicleLength;

	/**
	 * ������ɫ(006)
	 */
	@Mapper("VEHICLE_COLOR")
	private String vehicleColor;

	/**
	 * ����ʱ��
	 */
	@Mapper("PASS_TIME")
	private Date passTime;

	/**
	 * ����
	 */
	@Mapper("SPEED")
	private int speed;

	/**
	 * ͨ�з�ʽ(050)
	 */
	@Mapper("DRIVE_MODE")
	private String driveMode;

	/**
	 * �����ء�1-���У�2-��ʡ��3-��ʡ��4-������5-����
	 */
	@Mapper("VEH_LOCALIZATION")
	private String vehLocalization;

	/**
	 * �������ࡣ1-������������2-��
	 */
	@Mapper("VEH_CATEGORY")
	private String vehCategory;

	/**
	 * ��������
	 */
	@Mapper("ORG_CODE")
	private String orgCode;

	/**
	 * ��Ͻ����Ȩ�޴���
	 */
	@Mapper("ORG_AUTHORITY_CODE")
	private String orgAuthorityCode;

	/**
	 * ͼƬ�洢·��
	 */
	@Mapper("IMAGE_URL_PATH")
	private String imageUrlPath;

	/**
	 * ��βͼƬ�洢·��
	 */
	@Mapper("IMAGE_URL1")
	private String imageUrl1;

	/**
	 * ��������ͼƬ�洢·��
	 */
	@Mapper("IMAGE_URL2")
	private String imageUrl2;

	/**
	 * ����ͼ��洢·��
	 */
	@Mapper("IMAGE_URL3")
	private String imageUrl3;

	/**
	 * ����ͼƬλ��
	 */
	@Mapper("VEHICLE_PLATE_PLACE")
	private String vehiclePlatePlace;

	/**
	 * ����ͼ��λ��
	 */
	@Mapper("FACE_PLACE")
	private String facePlace;

	/**
	 * ������ʱ
	 */
	@Mapper("TRANSFER_DELAY")
	private long transferDelay;

	/**
	 * ����ʱ��
	 */
//	@Mapper("CREATE_TIME")
//	private Date createTime;

	/**
	 * �������ٹ�·���ڱ�ʶ��0-�ǽ������ٹ�·���ڣ�1-����2-��
	 */
	@Mapper("HIGHWAY_ACCESS_FLAG")
	private String highwayAccessFlag;

	/**
	 * �������������ڱ�ʶ��0-�ǽ������������ڣ�1-����2-��
	 */
	@Mapper("SERVICE_AREA_ACCESS_FLAG")
	private String serviceAreaAccessFlag;

	/**
	 * �����Ƿ����ǡ�1-���ǣ�2-����
	 */
	@Mapper("ENTRANCE_OR_EXIT")
	private String ertranceOrExit;

	/**
	 * �豸��š�����Ȳ����ı�ţ�����Ψһ�ԣ������޷����м�ء�
	 */
	@Mapper("DEVICE_NBR")
	private String deviceNbr;

	private String deviceKey;
	// public String getVehiclePassId() {
	// return vehiclePassId;
	// }
	//
	// public void setVehiclePassId(String vehiclePassId) {
	// this.vehiclePassId = vehiclePassId;
	// }

	public String getSnapNbr() {
		return snapNbr;
	}

	public void setSnapNbr(String snapNbr) {
		this.snapNbr = snapNbr;
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

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getRoadSectionCode() {
		return roadSectionCode;
	}

	public void setRoadSectionCode(String roadSectionCode) {
		this.roadSectionCode = roadSectionCode;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
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

	public String getPlateNbr() {
		return plateNbr;
	}

	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	public String getTailPlateNbr() {
		return tailPlateNbr;
	}

	public void setTailPlateNbr(String tailPlateNbr) {
		this.tailPlateNbr = tailPlateNbr;
	}

	public String getTailPlateColor() {
		return tailPlateColor;
	}

	public void setTailPlateColor(String tailPlateColor) {
		this.tailPlateColor = tailPlateColor;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleSubBrand() {
		return vehicleSubBrand;
	}

	public void setVehicleSubBrand(String vehicleSubBrand) {
		this.vehicleSubBrand = vehicleSubBrand;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehCharcter() {
		return vehCharcter;
	}

	public void setVehCharcter(String vehCharcter) {
		this.vehCharcter = vehCharcter;
	}

	public String getVehicleShape() {
		return vehicleShape;
	}

	public void setVehicleShape(String vehicleShape) {
		this.vehicleShape = vehicleShape;
	}

	public BigDecimal getVehicleLength() {
		return vehicleLength;
	}

	public void setVehicleLength(BigDecimal vehicleLength) {
		this.vehicleLength = vehicleLength;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getDriveMode() {
		return driveMode;
	}

	public void setDriveMode(String driveMode) {
		this.driveMode = driveMode;
	}

	public String getVehLocalization() {
		return vehLocalization;
	}

	public void setVehLocalization(String vehLocalization) {
		this.vehLocalization = vehLocalization;
	}

	public String getVehCategory() {
		return vehCategory;
	}

	public void setVehCategory(String vehCategory) {
		this.vehCategory = vehCategory;
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

	public String getImageUrlPath() {
		return imageUrlPath;
	}

	public void setImageUrlPath(String imageUrlPath) {
		this.imageUrlPath = imageUrlPath;
	}

	public String getImageUrl1() {
		return imageUrl1;
	}

	public void setImageUrl1(String imageUrl1) {
		this.imageUrl1 = imageUrl1;
	}

	public String getImageUrl2() {
		return imageUrl2;
	}

	public void setImageUrl2(String imageUrl2) {
		this.imageUrl2 = imageUrl2;
	}

	public String getImageUrl3() {
		return imageUrl3;
	}

	public void setImageUrl3(String imageUrl3) {
		this.imageUrl3 = imageUrl3;
	}

	public String getVehiclePlatePlace() {
		return vehiclePlatePlace;
	}

	public void setVehiclePlatePlace(String vehiclePlatePlace) {
		this.vehiclePlatePlace = vehiclePlatePlace;
	}

	public String getFacePlace() {
		return facePlace;
	}

	public void setFacePlace(String facePlace) {
		this.facePlace = facePlace;
	}

	public long getTransferDelay() {
		return transferDelay;
	}

	public void setTransferDelay(long transferDelay) {
		this.transferDelay = transferDelay;
	}

//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}

	public String getHighwayAccessFlag() {
		return highwayAccessFlag;
	}

	public void setHighwayAccessFlag(String highwayAccessFlag) {
		this.highwayAccessFlag = highwayAccessFlag;
	}

	public String getServiceAreaAccessFlag() {
		return serviceAreaAccessFlag;
	}

	public void setServiceAreaAccessFlag(String serviceAreaAccessFlag) {
		this.serviceAreaAccessFlag = serviceAreaAccessFlag;
	}

	public String getErtranceOrExit() {
		return ertranceOrExit;
	}

	public void setErtranceOrExit(String ertranceOrExit) {
		this.ertranceOrExit = ertranceOrExit;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
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