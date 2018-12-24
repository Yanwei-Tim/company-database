package cy.its.road.rest.dto;

import java.util.Date;

import cy.its.com.dto.BaseDto;
/**
 * 
  * @ClassName: RoadDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��10��27�� ����3:15:46
  *
 */
public class RoadDto extends BaseDto{
	private String roadId;
	//��·����
    private String roadCode;
    //�ɵĴ���
    private String oldRoadCode;
    //��·����
    private String roadName;
    //��·���� 
    private String roadType;
    //��·����
    private String roadAliasName;
	
    public String districtCode;
    //����������
    private String districtCodeList;
    //����������ϸ���
    private String districtMileage;
    //��������
    private String orgId;
    //��·�����ȼ�
    private String roadAdminGrade;
    //������Ϊ�϶���ʽ
    private String vioConfirmModel;
    //��·����
    private String isOneDirection;
    //���з���
    private String upDirection;
    //���з���
    private String downDirection;
    //·��ṹ
    private String roadStructure;
    //��·����
    private String roadLandscape;
    //��·����
    private String roadLinear;
    //��·���������ʩ
    private String roadIsolation;
    //���������ʩ
    private String centralIsolation;
    //������ʩ����
    private String protectFacilities;
    //��ʼ���
    private String roadBeginMileage;
    //�������
    private String roadEndMileage;
    //�ܳ�
    private String roadLength;
    //�������
    private String roadBeginName;
    //�յ�����
    private String roadEndName;
    //�ǳ��з�������
    private String noDirectionTypeCity;
    //���з�������
    private String directionTypeCity;
    //����Ȩ�޴���
    private String orgPrivilegeCode;
    
	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}
	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}
	public String getRoadLength() {
		return roadLength;
	}
	public void setRoadLength(String roadLength) {
		this.roadLength = roadLength;
	}
	
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	public String getRoadCode() {
		return roadCode;
	}
	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}
	
	public String getOldRoadCode() {
		return oldRoadCode;
	}
	public void setOldRoadCode(String oldRoadCode) {
		this.oldRoadCode = oldRoadCode;
	}
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
	
	public String getRoadAliasName() {
		return roadAliasName;
	}
	public void setRoadAliasName(String roadAliasName) {
		this.roadAliasName = roadAliasName;
	}
	public String getRoadType() {
		return roadType;
	}
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	public String getVioConfirmModel() {
		return vioConfirmModel;
	}
	public void setVioConfirmModel(String vioConfirmModel) {
		this.vioConfirmModel = vioConfirmModel;
	}
	public String getDistrictCodeList() {
		return districtCodeList;
	}
	public void setDistrictCodeList(String districtCodeList) {
		this.districtCodeList = districtCodeList;
	}
	public String getDistrictMileage() {
		return districtMileage;
	}
	public void setDistrictMileage(String districtMileage) {
		this.districtMileage = districtMileage;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getRoadAdminGrade() {
		return roadAdminGrade;
	}
	public void setRoadAdminGrade(String roadAdminGrade) {
		this.roadAdminGrade = roadAdminGrade;
	}
	public String getIsOneDirection() {
		return isOneDirection;
	}
	public void setIsOneDirection(String isOneDirection) {
		this.isOneDirection = isOneDirection;
	}
	public String getUpDirection() {
		return upDirection;
	}
	public void setUpDirection(String upDirection) {
		this.upDirection = upDirection;
	}
	public String getDownDirection() {
		return downDirection;
	}
	public void setDownDirection(String downDirection) {
		this.downDirection = downDirection;
	}
	public String getRoadStructure() {
		return roadStructure;
	}
	public void setRoadStructure(String roadStructure) {
		this.roadStructure = roadStructure;
	}
	public String getRoadLandscape() {
		return roadLandscape;
	}
	public void setRoadLandscape(String roadLandscape) {
		this.roadLandscape = roadLandscape;
	}
	public String getRoadLinear() {
		return roadLinear;
	}
	public void setRoadLinear(String roadLinear) {
		this.roadLinear = roadLinear;
	}
	public String getRoadIsolation() {
		return roadIsolation;
	}
	public void setRoadIsolation(String roadIsolation) {
		this.roadIsolation = roadIsolation;
	}
	public String getCentralIsolation() {
		return centralIsolation;
	}
	public void setCentralIsolation(String centralIsolation) {
		this.centralIsolation = centralIsolation;
	}
	public String getProtectFacilities() {
		return protectFacilities;
	}
	public void setProtectFacilities(String protectFacilities) {
		this.protectFacilities = protectFacilities;
	}
	public String getRoadBeginMileage() {
		return roadBeginMileage;
	}
	public void setRoadBeginMileage(String roadBeginMileage) {
		this.roadBeginMileage = roadBeginMileage;
	}
	public String getRoadEndMileage() {
		return roadEndMileage;
	}
	public void setRoadEndMileage(String roadEndMileage) {
		this.roadEndMileage = roadEndMileage;
	}
	public String getRoadBeginName() {
		return roadBeginName;
	}
	public void setRoadBeginName(String roadBeginName) {
		this.roadBeginName = roadBeginName;
	}
	public String getRoadEndName() {
		return roadEndName;
	}
	public void setRoadEndName(String roadEndName) {
		this.roadEndName = roadEndName;
	}
	
	public String getNoDirectionTypeCity() {
		return noDirectionTypeCity;
	}
	public void setNoDirectionTypeCity(String noDirectionTypeCity) {
		this.noDirectionTypeCity = noDirectionTypeCity;
	}
	public String getDirectionTypeCity() {
		return directionTypeCity;
	}
	public void setDirectionTypeCity(String directionTypeCity) {
		this.directionTypeCity = directionTypeCity;
	}
	
  
    
}