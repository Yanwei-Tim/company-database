package cy.its.vehTrack.mybatis.model;

import java.math.BigDecimal;
import java.util.Date;

import cy.its.com.util.ObjectMapUtils;
import cy.its.vehTrack.domain.model.PassInfo;

public class Pass {
	//����Id
	private String vehiclePassId;

	//ץ�ı��
    private String snapNbr;
    
    //�豸ϵͳ���
    private String deviceSysNbr;

    //�豸���
    private String deviceNbr;

    //������������
    private String districtCode;

    //��λ����
    private String siteCode;

    //��·����
    private String roadCode;

    //��·����
    private String roadType;

    //·�δ���
    private String roadSectionCode;

    //��������
    private String directionName;

    //��������
    private String directionType;

    //������
    private String lane;

    //���ƺ���
    private String plateNbr;

    //������ɫ
    private String plateColor;

    //��������
    private String plateType;

    //β�ƺ���
    private String tailPlateNbr;

    //β����ɫ
    private String tailPlateColor;

    //����Ʒ��
    private String vehicleBrand;

    //������Ʒ��
    private String vehicleSubBrand;

    //��������
    private String vehicleType;

    //����ʹ������
    private String vehCharcter;

    //������״
    private String vehicleShape;

    //����
    private BigDecimal vehicleLength;

    //������ɫ
    private String vehicleColor;

    //����ʱ��
    private Date passTime;

    //�ٶ�
    private Integer speed;

    //ͨ�з�ʽ
    private String driveMode;

    //������
    private String vehLocalization;

    //��������
    private String vehCategory;

    //��������
    private String orgCode;

    //����Ȩ�޴���
    private String orgAuthorityCode;

    //ͼƬ�洢·��
    private String imageUrlPath;

    //��βͼƬ�洢·��
    private String imageUrl1;

    //��������ͼƬ·��
    private String imageUrl2;

    //����ͼ��洢·��
    private String imageUrl3;

    //����ͼƬλ��
    private String vehiclePlatePlace;

    //����ͼ��λ��
    private String facePlace;

    //�����ӳ�
    private Long transferDelay;

    //����ʱ��
    private Date createTime;

    //�������ٹ�·���ڱ�ʶ
    private String highwayAccessFlag;

    //�������������ڱ�ʶ
    private String serviceAreaAccessFlag;

    //�����Ƿ�����
    private String ertranceOrExit;
    
    public PassInfo convertToModel(){
    	PassInfo passInfo = new PassInfo();
    	ObjectMapUtils.parseObject(passInfo, this);
    	return passInfo;
    }
    
    /**
	 * getter method
	 * @return the deviceSysNbr
	 */
	
	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	/**
	 * setter method
	 * @param deviceSysNbr the deviceSysNbr to set
	 */
	
	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getVehiclePassId() {
        return vehiclePassId;
    }

    public void setVehiclePassId(String vehiclePassId) {
        this.vehiclePassId = vehiclePassId;
    }

    public String getSnapNbr() {
        return snapNbr;
    }

    public void setSnapNbr(String snapNbr) {
        this.snapNbr = snapNbr;
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

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
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

    public Long getTransferDelay() {
        return transferDelay;
    }

    public void setTransferDelay(Long transferDelay) {
        this.transferDelay = transferDelay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

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
}