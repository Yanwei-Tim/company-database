package cy.its.vehTrack.domain.criteria;

import cy.its.com.domain.Criteria;

public class PassCriteria extends Criteria{
	/**
	 * ������������
	 */
	private String[] distritCodes;
	
	/**
	 * ��·���ͱ���
	 */
	private String roadType;
	
	/**
	 * ��·����
	 */
	private String[] roadCodes;
	
	/**
	 * ��λ����
	 */
	private String[] siteCodes;
	
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
	 * ����Ȩ�޴���
	 */
	private String orgPrvCode;
	
	/**
	 * ��С�ٶ�
	 */
	private String speedStart;
	
	/**
	 * ����ٶ�
	 */
	private String  speedEnd;
	
	/**
	 * �������asc��desc
	 */
	private String sort;
	
	/**
	 * �Ƿ�����������Ƴ������ƺ��볤��С��7�� ֵ��true �� false��Ĭ��Ϊfalse
	 */
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
	
	private String plateType;


	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/**
	 * getter method
	 * @return the orgPrvCode
	 */
	
	public String getOrgPrvCode() {
		return orgPrvCode;
	}

	/**
	 * setter method
	 * @param orgPrvCode the orgPrvCode to set
	 */
	
	public void setOrgPrvCode(String orgPrvCode) {
		this.orgPrvCode = orgPrvCode;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}


	public String[] getDistritCodes() {
		return distritCodes;
	}

	public void setDistritCodes(String[] distritCodes) {
		this.distritCodes = distritCodes;
	}

	public String[] getRoadCodes() {
		return roadCodes;
	}

	public void setRoadCodes(String[] roadCodes) {
		this.roadCodes = roadCodes;
	}

	public String[] getSiteCodes() {
		return siteCodes;
	}

	public void setSiteCodes(String[] siteCodes) {
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

	

	/**
	 * getter method
	 * @return the passTimeStart
	 */
	
	public String getPassTimeStart() {
		return passTimeStart;
	}

	/**
	 * setter method
	 * @param passTimeStart the passTimeStart to set
	 */
	
	public void setPassTimeStart(String passTimeStart) {
		this.passTimeStart = passTimeStart;
	}

	/**
	 * getter method
	 * @return the passTimeEnd
	 */
	
	public String getPassTimeEnd() {
		return passTimeEnd;
	}

	/**
	 * setter method
	 * @param passTimeEnd the passTimeEnd to set
	 */
	
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

	/**
	 * getter method
	 * @return the sort
	 */
	
	public String getSort() {
		return sort;
	}

	/**
	 * setter method
	 * @param sort the sort to set
	 */
	
	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getJustNonlocalVeh() {
		return justNonlocalVeh;
	}

	public void setJustNonlocalVeh(String justNonlocalVeh) {
		this.justNonlocalVeh = justNonlocalVeh;
	}

	public String getJustSearchNullPlate() {
		return justSearchNullPlate;
	}

	public void setJustSearchNullPlate(String justSearchNullPlate) {
		this.justSearchNullPlate = justSearchNullPlate;
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

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
}
