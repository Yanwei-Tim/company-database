package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class PlateRecognition extends BaseDto {



	/**
	 * ������ʼ���ڼ�ʱ��
	 */
	@ApiParam(value=" ������ʼʱ�� ��ʽ��yyyy-MM-dd HH:mm:ss",required=true)
	private String startDateTime;
	
	/**
	 * ������ֹ���ڼ�ʱ��
	 */
	@ApiParam(value=" ������ֹʱ�� ��ʽ��yyyy-MM-dd HH:mm:ss",required=true)
	private String endDateTime;

	/**
	 * �������루����ð�Ƕ��Ÿ�����
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
	 * ��·���루����ð�Ƕ��Ÿ�����
	 */
	private String roadCodes;
	
	/**
	 * ��λ���루����ð�Ƕ��Ÿ�����
	 */
	private String siteCodes;

	/**
	 *������
	 */
	private String driveLane;
	
	/**
	 * ������������(007)������ð�Ƕ��Ÿ�����
	 */
	private String districtCodes;
	
	/**
	 * (�Զ���)�������� <br />
	 */
	private String directionName;
	
	/**
	 * ·��·�δ��루����ð�Ƕ��Ÿ�����
	 */
	private String roadSectionCodes;
	
	/**
	 * �豸ϵͳ���
	 */
	private String deviceSysNbr;
	
	/**
	 * �豸���
	 */
	private String deviceNbr;

	/**
	 * ��·����
	 */
	private String roadType;

	/**
	 * Ҫ��ѯ�Ľ����Ǳ�ʾ������ð�Ƕ��Ÿ�����
	 */
	private String entranceOrExits;
	
	/**
	 * �������ٹ�·���ڱ�ʶ��0-�ǽ������ٹ�·���ڣ�1-����2-��
	 */
	private String highwayAccessFlag;
	
	/**
	 * �������������ڱ�ʶ��0-�ǽ������������ڣ�1-����2-��
	 */
	private String serviceAreaAccessFlag;
	
	/**
	 * ��ѯ�������ʽ��������˳��ASC DESC��
	 */
	private String orderType;
	
	/**
	 * ��ѯ��������ֶ�����deviceNbr day hour recogRate totalCount invalidCount <br />
	 * Constants.PlateRecogOrderName
	 */
	private String orderTypeName;
	
	/**
	 * ��ʲôͳ��(deviceNbr:���豸��day:�������죬 hour:������Сʱ)
	 */
	private String statBy;
	
	private String tollgateType;
	
	private String isConnectTrackSys;
	/**
     * �ܼ�¼��
     */
    private String totalCount;
    
 // ��ǰҳ��
 	private int pageNumber;
 	// ��ҳ��С
 	private int pageSize;
    
	public String getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}
	public String getEndDateTime() {
		return endDateTime;
	}
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}
	public String getOrgCodes() {
		return orgCodes;
	}
	public void setOrgCodes(String orgCodes) {
		this.orgCodes = orgCodes;
	}
	public String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}
	public void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
	}
	public String getDirectType() {
		return directType;
	}
	public void setDirectType(String directType) {
		this.directType = directType;
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
	public String getDriveLane() {
		return driveLane;
	}
	public void setDriveLane(String driveLane) {
		this.driveLane = driveLane;
	}
	public String getDistrictCodes() {
		return districtCodes;
	}
	public void setDistrictCodes(String districtCodes) {
		this.districtCodes = districtCodes;
	}
	public String getDirectionName() {
		return directionName;
	}
	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}
	public String getRoadSectionCodes() {
		return roadSectionCodes;
	}
	public void setRoadSectionCodes(String roadSectionCodes) {
		this.roadSectionCodes = roadSectionCodes;
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
	public String getRoadType() {
		return roadType;
	}
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	public String getEntranceOrExits() {
		return entranceOrExits;
	}
	public void setEntranceOrExits(String entranceOrExits) {
		this.entranceOrExits = entranceOrExits;
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
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderTypeName() {
		return orderTypeName;
	}
	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}
	public String getStatBy() {
		return statBy;
	}
	public void setStatBy(String statBy) {
		this.statBy = statBy;
	}
	
	public String getTollgateType() {
		return tollgateType;
	}
	public void setTollgateType(String tollgateType) {
		this.tollgateType = tollgateType;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	
	
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getIsConnectTrackSys() {
		return isConnectTrackSys;
	}
	public void setIsConnectTrackSys(String isConnectTrackSys) {
		this.isConnectTrackSys = isConnectTrackSys;
	}
	@Override
	public String toString(){
		StringBuilder params = new StringBuilder();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			try {
				params.append("&").append(field.getName()).append("=");
				Object value = field.get(this);
				if(value != null){
					params.append(value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return params.substring(1);
	}
}
