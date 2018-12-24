package cy.its.vehTrack.rest.dto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.omg.CORBA.portable.CustomValue;

import cy.its.com.constant.ConstValue;
import cy.its.com.dto.BaseDto;
import cy.its.com.util.ObjectMapUtils;
import cy.its.com.util.StringUtil;
import cy.its.vehTrack.domain.criteria.PassCriteria;
import cy.its.vehTrack.domain.model.PassInfo;

public class PassDto extends BaseDto{
	
	/**
	 * ת������ģ�Ͷ���
	 * @return
	 */
	public PassInfo converToModel(){
		PassInfo passInfo = new PassInfo();
		ObjectMapUtils.parseObject(passInfo, this);
		return passInfo;
	}
	
	
	/**
	 * ת��Ϊ�����ѯ����
	 * @return
	 * @throws ParseException 
	 */
	public PassCriteria convertToCriteria() throws ParseException{
		PassCriteria criteria = new PassCriteria();
		ObjectMapUtils.parseObject(criteria, this);
		if(!StringUtil.isNullOrEmpty(this.distritCodes)){
			criteria.setDistritCodes(distritCodes.split(","));
		}
		if(!StringUtil.isNullOrEmpty(this.roadCodes)){
			criteria.setRoadCodes(roadCodes.split(","));
		}
		if(!StringUtil.isNullOrEmpty(this.siteCodes)){
			criteria.setSiteCodes(siteCodes.split(","));
		}
		if(!StringUtil.isNullOrEmpty(this.speedStart)){
			criteria.setSpeedStart(this.speedStart);;
		}
		if(!StringUtil.isNullOrEmpty(this.speedEnd)){
			criteria.setSpeedEnd(this.speedEnd);
		}
		//���õ�ǰ�û�����Ȩ��
		criteria.setOrgPrvCode(this.getCurrentOrgPrivilegeCode());
		criteria.setPageNum(this.getPageNumber());
		criteria.setPageSize(this.getPageSize());
		criteria.setTotal(this.getTotalCount());
		return criteria;
	}
	
	/**
	 * Ĭ���޲ι��캯��
	 */
	public PassDto(){
		
	}
	
	/**
	 * ����ģ��תΪΪDTO
	 * @param passInfo
	 */
	public PassDto(PassInfo passInfo){
		ObjectMapUtils.parseObject(this, passInfo);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		this.passTime = formatter.format(passInfo.getPassTime());
		this.transferDelay = String.valueOf(passInfo.getTransferDelay());
		this.vehicleLength = String.valueOf(passInfo.getVehicleLength());
	}
	
	/**
	
	  * ����һ���µ�ʵ�� PassDto. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param plateNbr ���ƺ�
	  * @param passTimeStart ��ʼʱ��
	  * @param passTimeEnd ����ʱ��
	  * @param searchType ��������
	  */
	
	public PassDto(String plateNbr, String passTimeStart, String passTimeEnd, String searchType,
			int pageSize, int pageNumber,String plateType) {
		this.plateNbr = plateNbr;
		this.plateType = plateType;
		this.setPageSize(pageSize);
		this.setPageNumber(pageNumber);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date now = new Date();
		if(ConstValue.SEARCH_TIME_TYPE_LAST_2_HOUR.equals(searchType)){
			//���2Сʱ
			this.passTimeStart = formatter.format(new Date(now.getTime() - (2L*3600L*1000L)));
			this.passTimeEnd = formatter.format(now);
		}else if(ConstValue.SEARCH_TIME_TYPE_LAST_1_DAY.equals(searchType)){
			//���һ��
			this.passTimeStart = formatter.format(new Date(now.getTime() - (24L*3600L*1000L)));
			this.passTimeEnd = formatter.format(now);
		}else if(ConstValue.SEARCH_TIME_TYPE_LAST_1_WEEK.equals(searchType)){
			//���һ��
			this.passTimeStart = formatter.format(new Date(now.getTime() - (7L*24L*3600L*1000L)));
			this.passTimeEnd = formatter.format(now);
		}else{
			this.passTimeStart = passTimeStart;
			this.passTimeEnd = passTimeEnd;
		}
	}

	/**
	 * ������������
	 */
	private String distritCode;
	
	/**
	 * ������������
	 */
	private String distritCodes;

	/**
	 * ��·���ͱ���
	 */
	private String roadType;

	/**
	 * ��·����
	 */
	private String roadCodes;

	/**
	 * ��λ����
	 */
	private String siteCodes;

	/**
	 * ����
	 */
	private String direction;

	/**
	 * ����
	 */
	private String lane;

	/**
	 * ����ʱ�俪ʼ
	 */
	private String passTimeStart;

	/**
	 * ����ʱ�����
	 */
	private String passTimeEnd;

	/**
	 * ���ƺ���
	 */
	private String plateNbr;

	/**
	 * ������ɫ
	 */
	private String plateColor;

	/**
	 * ��������
	 */
	private String vehicleType;

	/**
	 * ������ɫ
	 */
	private String vehicleColor;

	/**
	 * ����Ʒ��
	 */
	private String vehicleBrand;

	/**
	 * ����������
	 */
	private String vehLocalization;

	/**
	 * ��С�ٶ�
	 */
	private String speedStart;
	/**
	 * ����ٶ�
	 */
	private String speedEnd;
	// ������ϢID��Ψһ����
	private String vehiclePassId;

	// ץ�ı��
	private String snapNbr;

	// �豸���
	private String deviceNbr;

	// ������������
	private String districtCode;

	// ��λ����
	private String siteCode;

	// ��·����
	private String roadCode;

	// ·��\·�δ���
	private String junctionCode;

	// ��������
	private String directionName;

	// ��������
	private String directionType;

	// ��������
	private String plateType;

	// β�ƺ���
	private String tailPlateNbr;

	// β����ɫ
	private String tailPlateColor;

	// ������Ʒ��
	private String vehicleSubBrand;

	// ��������
	private String vehCharcter;

	// ������״
	private String vehicleShape;

	// ��������
	private String vehicleLength;

	// ����ʱ��
	private String passTime;

	// �ٶ�
	private Integer speed;

	// ���ͷ�ʽ
	private String driveMode;

	// ������� 1������2��
	private String vehCategory;

	// ������������
	private String orgCode;

	// ����Ȩ�ޱ���
	private String orgAuthorityCode;

	// ����ͼƬ·��
	private String imageUrlPath;

	// ��βͼƬ·��
	private String imageUrl1;

	// ��������ͼƬ·��
	private String imageUrl2;

	// ��������ͼƬ·��
	private String imageUrl3;

	// ����ͼƬλ��
	private String vehiclePlatePlace;

	// ����ͼƬλ��
	private String facePlace;

	// ���ݴ����ӳ�
	private String transferDelay;

	// ����ʱ��
	private String createTime;

	// �������ٹ�·���ڱ�ʶ
	private String highwayAccessFlag;

	// �������������ڱ�ʶ
	private String serviceAreaAccessFlag;

	// ���ǻ����
	private String ertranceOrExit;
	
	// ��λ����
	private String siteName;
	
	// ��λ����
	private BigDecimal siteLon;
	
	// ��λγ��
	private BigDecimal siteLat;
	
	//�Ƿ�����������Ƴ������ƺ��볤��С��7�� ֵ��true �� false��Ĭ��Ϊfalse
	private String justSearchNullPlate;
	
	//��س���ѯ��ʶ ֵ��true �� false��Ĭ��Ϊfalse����Ϊtrueʱ�����ƺ��Ʋ���ӦΪ���س�����ǰ׺���磺��A* ����ѯ���Ʋ�����A��ͷ�����Ĺ�����¼��
	private String justNonlocalVeh;
	//�״γ��ֳ�����ѯ��ʶ ֵ��true �� false��Ĭ��Ϊfalse����Ϊtrueʱ������ѯ��Щ��ָ�������������״γ��ֳ����Ĺ�����¼��[һ����]��ǰ����û��ָ�������������ֹ�������Impala֧�֡�
	private String justFirstApear;
	
	//�״γ��ֳ�����ѯ���½�ʱ��綨ֵ�����״γ���ʱ�䲻С�ڸ�ʱ��ʱ����Ϊ�½����֡� ��ʽ��yyyy-MM-dd HH:mm:ss
	private String firstTime;
	//�״γ��ֳ�����ѯ�ġ������������������룬���磺Ҫ��ѯ�Ĳ���Ϊ�ںϷ����״γ��ֵĳ��������Ǳ��ι�����ѯ�ķ�Χȴ�޶�����ɽ������ֵ��Ϸ��е������������룺340100
	private String firstAppearDistrictCodes;
	//�����ֶμ�����ʽ��ϣ��磺plate_type desc, vehicle_brand, vehicle_color desc, pass_time asc ����ֵ��Ϊ�գ�[orderType]������ʧЧ��
	private String orderFields;
	//��ѯ�������ʽ��������ʱ�䵹����˳��ֵ"asc"��"desc"��
	private String orderType;
	
	private String dbType;
	
	private long totalCount;
	
	
	//�����flag
	private boolean activeFlag;

	public BigDecimal getSiteLon() {
		return siteLon;
	}


	public void setSiteLon(BigDecimal siteLon) {
		this.siteLon = siteLon;
	}


	public BigDecimal getSiteLat() {
		return siteLat;
	}


	public void setSiteLat(BigDecimal siteLat) {
		this.siteLat = siteLat;
	}


	/**
	 * getter method
	 * @return the siteName
	 */
	
	public String getSiteName() {
		return siteName;
	}


	/**
	 * setter method
	 * @param siteName the siteName to set
	 */
	
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public String getDistritCodes() {
		return distritCodes;
	}




	public void setDistritCodes(String distritCodes) {
		this.distritCodes = distritCodes;
	}


	public String getDistritCode() {
		return distritCode;
	}

	public void setDistritCode(String distritCode) {
		this.distritCode = distritCode;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getRoadCodes() {
		return roadCodes;
	}

	public void setRoadCodes(String roadCodes) {
		this.roadCodes = roadCodes;
	}

	public String getSiteCodes() {
		return siteCodes;
	}

	public void setSiteCodes(String siteCodes) {
		this.siteCodes = siteCodes;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getPassTimeStart() {
		return passTimeStart;
	}

	public void setPassTimeStart(String passTimeStart) {
		this.passTimeStart = passTimeStart;
	}

	public String getPassTimeEnd() {
		return passTimeEnd;
	}

	public void setPassTimeEnd(String passTimeEnd) {
		this.passTimeEnd = passTimeEnd;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehLocalization() {
		return vehLocalization;
	}

	public void setVehLocalization(String vehLocalization) {
		this.vehLocalization = vehLocalization;
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

	public String getJunctionCode() {
		return junctionCode;
	}

	public void setJunctionCode(String junctionCode) {
		this.junctionCode = junctionCode;
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

	public String getVehicleSubBrand() {
		return vehicleSubBrand;
	}

	public void setVehicleSubBrand(String vehicleSubBrand) {
		this.vehicleSubBrand = vehicleSubBrand;
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

	public String getVehicleLength() {
		return vehicleLength;
	}

	public void setVehicleLength(String vehicleLength) {
		this.vehicleLength = vehicleLength;
	}

	public String getPassTime() {
		return passTime;
	}

	public void setPassTime(String passTime) {
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

	public String getTransferDelay() {
		return transferDelay;
	}

	public void setTransferDelay(String transferDelay) {
		this.transferDelay = transferDelay;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
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


	public boolean isActiveFlag() {
		return activeFlag;
	}


	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}


	public String getJustSearchNullPlate() {
		return justSearchNullPlate;
	}


	public void setJustSearchNullPlate(String justSearchNullPlate) {
		this.justSearchNullPlate = justSearchNullPlate;
	}


	public String getJustNonlocalVeh() {
		return justNonlocalVeh;
	}


	public void setJustNonlocalVeh(String justNonlocalVeh) {
		this.justNonlocalVeh = justNonlocalVeh;
	}


	public String getJustFirstApear() {
		return justFirstApear;
	}


	public void setJustFirstApear(String justFirstApear) {
		this.justFirstApear = justFirstApear;
	}


	public String getFirstTime() {
		return firstTime;
	}


	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}


	public String getFirstAppearDistrictCodes() {
		return firstAppearDistrictCodes;
	}


	public void setFirstAppearDistrictCodes(String firstAppearDistrictCodes) {
		this.firstAppearDistrictCodes = firstAppearDistrictCodes;
	}


	public String getOrderFields() {
		return orderFields;
	}


	public void setOrderFields(String orderFields) {
		this.orderFields = orderFields;
	}


	public String getDbType() {
		return dbType;
	}


	public void setDbType(String dbType) {
		this.dbType = dbType;
	}


	public String getSpeedStart() {
		return speedStart;
	}


	public void setSpeedStart(String speedStart) {
		this.speedStart = speedStart;
	}


	public String getSpeedEnd() {
		return speedEnd;
	}


	public void setSpeedEnd(String speedEnd) {
		this.speedEnd = speedEnd;
	}


	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
