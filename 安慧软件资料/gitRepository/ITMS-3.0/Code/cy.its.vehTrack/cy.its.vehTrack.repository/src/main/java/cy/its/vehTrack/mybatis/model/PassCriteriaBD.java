/**
 * ������˾		���ճ�Զ��Ϣ�������޹�˾
 * ϵͳ��			its
 * ��ϵͳ��      ������ƽ̨
 *
 * @author  Xujin.Jiao
 * @version Version 1.0
 * 
 * ��������
 * 2015��6��5��: ����
 */
package cy.its.vehTrack.mybatis.model;

import java.io.Serializable;

import org.springframework.util.StringUtils;

import cy.its.com.domain.Criteria;
/**
 * ������ѯ��������
 */
public class PassCriteriaBD implements Serializable {

	/**
	  * @Fields serialVersionUID : TODO����һ�仰�������������ʾʲô��
	  */
	private static final long serialVersionUID = 5971737935616728060L;

	/**
	 * ���ƺ���
	 */
	private String plateNbr;

	/**
	 * ������ʼ���ڼ�ʱ��
	 */
	private String startDateTime;
	
	/**
	 * ������ֹ���ڼ�ʱ��
	 */
	private String endDateTime;
	
	/**
	 * ��С����
	 */
	private String speedStart;
	
	/**
	 * �����
	 */
	private String speedEnd;
	
	/**
	 * ��������
	 */
	private String orgCodes;
	
	/**
	 * ��Ͻ��������
	 */
	private String orgAuthorityCode;

	/**
	 * ��������
	 */
	private String directType;
	
	/**
	 * ��·����
	 */
	private String roadCodes;
	
	/**
	 * ��λ����
	 */
	private String siteCodes;

	/**
	 *������
	 */
	private String driveLane;
	
	/**
	 * ������������(007)
	 */
	private String districtCodes;
	
	/**
	 * (�Զ���)�������� <br />
	 * ������ѯҳ��δʹ�ø�����������Ȼ����ʹ��restful�ӿ�ʹ�ø�����
	 */
	private String directionName;
	
	/**
	 * ·��·�δ���
	 */
	private String roadSectionCodes;
	
	/**
	 * �豸ϵͳ���
	 */
	private String deviceSysNbr;
	
	/**
	 * ��������(002)
	 */
	private String plateType;
	
	/**
	 * ������ɫ(003)
	 */
	private String plateColor;

	/**
	 *ͨ�з�ʽ(050)
	 */
	private String driveMode;
	
	/**
	 *���������ط���(084)
	 */
	private String vehicleLocalization;

	/**
	 *������ɫ(006)
	 */
	private String vehicleColor;

	/**
	 * ��·����
	 */
	private String roadType;

	/**
	 *����Ʒ��(005) 3λ����
	 */
	private String vehicleBrand;
	
	/**
	 *������Ʒ��(005) 2λ����
	 */
	private String vehicleSubBrand;
	
	/**
	 *��������(004)
	 */
	private String vehicleShape;

	/**
	 * �ο����һ��������ʹ����ga802��ga24.4��ֻ��ʶ�������������ļ�1λ������루h��k��m�ȣ���ֻ��ʶ�������͹��ļ�2λ��ȫʶ��ļ�3λ��
	 * ֻ��ʶ������������ļ�2λ���֣���һλ��0���루1���󳵣�2�����ͳ���3��С�ͳ���4��΢�ͳ�����Ħ�г�Ϊm1��m2
	 */
	private String vehicleType;
	
	/**
	 * ga802-2008�����ջ��鲼��ϵͳ���룺0��δ������ϵͳ���䣩g:���� h:���� i:���� j:�Ȼ� k:���̾��� l:Ӫת�� m:����ת�� 
	 * n:���� o:�׶�У�� p:Сѧ��У�� q:������У�� s:��Сѧ��У�� r:Σ��Ʒ���� a:��Ӫ�� b:��·���� c:�������� d:������� e:���ο��� f:����
	 */
	private String vehCharcter;

	/**
	 * Ҫ��ѯ���ֶ� 
	 */
	private String selectFields = "snap_nbr,device_nbr,image_url_path,vehicle_pass_id,plate_nbr,plate_type,plate_color,org_code,district_code,road_code,road_section_code,site_code,lane,direction_type,direction_name,speed,pass_time,drive_mode,vehicle_brand,vehicle_sub_brand,vehicle_color";
	
	/**
	 * Ҫ��ѯ�����ݿ����ͣ�elasticsearch mongodb <br />
	 * ������ѯδʹ�øò�ѯ����������Ȼ����ʹ��restful�ӿ�ʹ�ø�����
	 */
	private String dbType;

	/**
	 * Ҫ��ѯ�Ľ����Ǳ�ʾ
	 */
	private String ertranceOrExits;
	
	/**
	 * ��ѯ�������ʽ����ʱ�䵹����˳��
	 */
	private String orderType;
	
	/**
	 * �������ࡣ1-������������2-��
	 */
	private String vehCategory;
	
	/**
	 * �������ٹ�·���ڱ�ʶ��0-�ǽ������ٹ�·���ڣ�1-����2-��
	 */
	private String highwayAccessFlag;
	
	/**
	 * �������������ڱ�ʶ��0-�ǽ������������ڣ�1-����2-��
	 */
	private String serviceAreaAccessFlag;
	
	/**
	 * ҳ���С
	 */
	private int pageSize;
	
	/**
	 * ��ǰҳ��
	 */
	private int pageNumber;
	
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * getter method
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * setter method
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	/**
	 * @return the ertranceOrExits
	 */
	public String getErtranceOrExits() {
		return ertranceOrExits;
	}

	/**
	 * @param ertranceOrExits the ertranceOrExits to set
	 */
	public void setErtranceOrExits(String ertranceOrExits) {
		this.ertranceOrExits = ertranceOrExits;
	}

	/**
	 * @return the selectFields
	 */
	public String getSelectFields() {
		return selectFields;
	}

	/**
	 * @param selectFields the selectFields to set
	 */
	public void setSelectFields(String selectFields) {
		this.selectFields = selectFields;
	}

	/**
	 * @return the plateNbr
	 */
	public String getPlateNbr() {
		return plateNbr;
	}

	/**
	 * @param plateNbr the plateNbr to set
	 */
	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
	}

	/**
	 * @return the startDateTime
	 */
	public String getStartDateTime() {
		return startDateTime;
	}

	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(String startDateTime) {
		if (!StringUtils.isEmpty(startDateTime)) {
			switch(startDateTime.length())
			{
				case 10:
					startDateTime += " 00:00:00";
					break;
				case 13:
					startDateTime += " :00:00";
					break;
				case 16:
					startDateTime += " :00";
					break;
			}
		}
		this.startDateTime = startDateTime;
	}

	/**
	 * @return the endDateTime
	 */
	public String getEndDateTime() {
		return endDateTime;
	}

	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(String endDateTime) {
		if (!StringUtils.isEmpty(endDateTime)) {
			switch(endDateTime.length())
			{
				case 10:
					endDateTime += " 23:59:59";
					break;
				case 13:
					endDateTime += " :59:59";
					break;
				case 16:
					endDateTime += " :59";
					break;
			}
		}
		this.endDateTime = endDateTime;
	}

	/**
	 * @return the speedStart
	 */
	public String getSpeedStart() {
		return speedStart;
	}

	/**
	 * @param speedStart the speedStart to set
	 */
	public void setSpeedStart(String speedStart) {
		this.speedStart = speedStart;
	}

	/**
	 * @return the speedEnd
	 */
	public String getSpeedEnd() {
		return speedEnd;
	}

	/**
	 * @param speedEnd the speedEnd to set
	 */
	public void setSpeedEnd(String speedEnd) {
		this.speedEnd = speedEnd;
	}

	/**
	 * @return the directType
	 */
	public String getDirectType() {
		return directType;
	}

	/**
	 * @param directType the directType to set
	 */
	public void setDirectType(String directType) {
		this.directType = directType;
	}

	/**
	 * @return the driveLane
	 */
	public String getDriveLane() {
		return driveLane;
	}

	/**
	 * @param driveLane the driveLane to set
	 */
	public void setDriveLane(String driveLane) {
		this.driveLane = driveLane;
	}

	/**
	 * @return the orgCodes
	 */
	public String getOrgCodes() {
		return orgCodes;
	}

	/**
	 * @param orgCodes the orgCodes to set
	 */
	public void setOrgCodes(String orgCodes) {
		this.orgCodes = orgCodes;
	}

	/**
	 * getter method
	 * @return the orgAuthorityCode
	 */
	public String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}

	/**
	 * setter method
	 * @param orgAuthorityCode the orgAuthorityCode to set
	 */
	public void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
	}

	/**
	 * @return the roadCodes
	 */
	public String getRoadCodes() {
		return roadCodes;
	}

	/**
	 * @param roadCodes the roadCodes to set
	 */
	public void setRoadCodes(String roadCodes) {
		this.roadCodes = roadCodes;
	}

	/**
	 * @return the siteCodes
	 */
	public String getSiteCodes() {
		
		return siteCodes;
	}

	/**
	 * @param siteCodes the siteCodes to set
	 */
	public void setSiteCodes(String siteCodes) {
		this.siteCodes = siteCodes;
	}

	/**
	 * @return the districtCodes
	 */
	public String getDistrictCodes() {
		return districtCodes;
	}

	/**
	 * @param districtCodes the districtCodes to set
	 */
	public void setDistrictCodes(String districtCodes) {
		this.districtCodes = districtCodes;
	}

	/**
	 * @return the directionName
	 */
	public String getDirectionName() {
		return directionName;
	}

	/**
	 * @param directionName the directionName to set
	 */
	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	/**
	 * getter method
	 * @return the roadSectionCodes
	 */
	public String getRoadSectionCodes() {
		return roadSectionCodes;
	}

	/**
	 * setter method
	 * @param roadSectionCodes the roadSectionCodes to set
	 */
	public void setRoadSectionCodes(String roadSectionCodes) {
		this.roadSectionCodes = roadSectionCodes;
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

	/**
	 * @return the plateType
	 */
	public String getPlateType() {
		return plateType;
	}

	/**
	 * @param plateType the plateType to set
	 */
	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	/**
	 * @return the plateColor
	 */
	public String getPlateColor() {
		return plateColor;
	}

	/**
	 * @param plateColor the plateColor to set
	 */
	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	/**
	 * @return the driveMode
	 */
	public String getDriveMode() {
		return driveMode;
	}

	/**
	 * @param driveMode the driveMode to set
	 */
	public void setDriveMode(String driveMode) {
		this.driveMode = driveMode;
	}

	/**
	 * @return the vehicleLocalization
	 */
	public String getVehicleLocalization() {
		return vehicleLocalization;
	}

	/**
	 * @param vehicleLocalization the vehicleLocalization to set
	 */
	public void setVehicleLocalization(String vehicleLocalization) {
		this.vehicleLocalization = vehicleLocalization;
	}

	/**
	 * @return the vehicleColor
	 */
	public String getVehicleColor() {
		return vehicleColor;
	}

	/**
	 * @param vehicleColor the vehicleColor to set
	 */
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	/**
	 * @return the roadType
	 */
	public String getRoadType() {
		return roadType;
	}

	/**
	 * @param roadType the roadType to set
	 */
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	/**
	 * @return the vehicleBrand
	 */
	public String getVehicleBrand() {
		return vehicleBrand;
	}

	/**
	 * @param vehicleBrand the vehicleBrand to set
	 */
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	/**
	 * @return the vehicleSubBrand
	 */
	public String getVehicleSubBrand() {
		return vehicleSubBrand;
	}

	/**
	 * @param vehicleSubBrand the vehicleSubBrand to set
	 */
	public void setVehicleSubBrand(String vehicleSubBrand) {
		this.vehicleSubBrand = vehicleSubBrand;
	}

	/**
	 * @return the vehicleShape
	 */
	public String getVehicleShape() {
		return vehicleShape;
	}

	/**
	 * @param vehicleShape the vehicleShape to set
	 */
	public void setVehicleShape(String vehicleShape) {
		this.vehicleShape = vehicleShape;
	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the vehCharcter
	 */
	public String getVehCharcter() {
		return vehCharcter;
	}

	/**
	 * @param vehCharcter the vehCharcter to set
	 */
	public void setVehCharcter(String vehCharcter) {
		this.vehCharcter = vehCharcter;
	}

	/**
	 * @return the dbType
	 */
	public String getDbType() {
		return dbType;
	}

	/**
	 * @param dbType the dbType to set
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/**
	 * getter method
	 * @return the vehCategory
	 */
	public String getVehCategory() {
		return vehCategory;
	}

	/**
	 * setter method
	 * @param vehCategory the vehCategory to set
	 */
	public void setVehCategory(String vehCategory) {
		this.vehCategory = vehCategory;
	}

	/**
	 * getter method
	 * @return the highwayAccessFlag
	 */
	public String getHighwayAccessFlag() {
		return highwayAccessFlag;
	}

	/**
	 * setter method
	 * @param highwayAccessFlag the highwayAccessFlag to set
	 */
	public void setHighwayAccessFlag(String highwayAccessFlag) {
		this.highwayAccessFlag = highwayAccessFlag;
	}

	/**
	 * getter method
	 * @return the serviceAreaAccessFlag
	 */
	public String getServiceAreaAccessFlag() {
		return serviceAreaAccessFlag;
	}

	/**
	 * setter method
	 * @param serviceAreaAccessFlag the serviceAreaAccessFlag to set
	 */
	public void setServiceAreaAccessFlag(String serviceAreaAccessFlag) {
		this.serviceAreaAccessFlag = serviceAreaAccessFlag;
	}

}
