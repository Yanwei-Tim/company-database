/**
 * @Title: SectionDto.java
 * @Package cy.its.road.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��10��29�� ����4:15:59
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.road.rest.dto;



import cy.its.com.dto.BaseDto;

/**
 * @ClassName: SectionDto
 * @Description: TODO(sectionDto��Ӧҳ��������Dto��������)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��10��29�� ����4:15:59
 *
 */

public class RoadSectionDto extends BaseDto {
	
	// ·��Id
	private String roadSectionId;
	// ��·Id
	private String roadId;
	// �ɵ�·Id
	private String oldRoadId;
	//������·
	private String roadCode;
	// ·�δ���
	private String roadSectionCode;
	// ��·�δ���
	private String oldRoadSectionCode;
	// ��������
	private String districtCode;
	// ����Id
	private String orgId;
	// ·������
	private String roadSectionName;
	// ·������
	private String roadSectionType;
	// �Ƿ���ͨ��
	private String isOneDirection;
	// ��·�ṹ
	private String roadStructure;
	// ��·����
	private String roadLinear;
	// ��·����
	private String roadLandscape;
	// ���������ʩ
	private String centralIsolation;
	// ������ʩ����
	private String protectFacilities;
	//��·�������
	private String roadBeginName;
	//��·�յ�����
	private String roadEndName;
	// ��ʼ���
	private String beginMeterG;
	//��ʼ����
	private String beginMeterM;
	//�������
	private String endMeterG;
	//��������
	private String endMeterM;
	
	private String orgPrivilegeCode;
	
	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
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

	public String getRoadSectionId() {
		return roadSectionId;
	}

	public void setRoadSectionId(String roadSectionId) {
		this.roadSectionId = roadSectionId;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getOldRoadId() {
		return oldRoadId;
	}

	public void setOldRoadId(String oldRoadId) {
		this.oldRoadId = oldRoadId;
	}

	public String getRoadSectionCode() {
		return roadSectionCode;
	}

	public void setRoadSectionCode(String roadSectionCode) {
		this.roadSectionCode = roadSectionCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}

	public String getOldRoadSectionCode() {
		return oldRoadSectionCode;
	}

	public void setOldRoadSectionCode(String oldRoadSectionCode) {
		this.oldRoadSectionCode = oldRoadSectionCode;
	}

	public String getRoadSectionName() {
		return roadSectionName;
	}

	public void setRoadSectionName(String roadSectionName) {
		this.roadSectionName = roadSectionName;
	}

	public String getRoadSectionType() {
		return roadSectionType;
	}

	public void setRoadSectionType(String roadSectionType) {
		this.roadSectionType = roadSectionType;
	}

	public String getIsOneDirection() {
		return isOneDirection;
	}

	public void setIsOneDirection(String isOneDirection) {
		this.isOneDirection = isOneDirection;
	}

	public String getRoadStructure() {
		return roadStructure;
	}

	public void setRoadStructure(String roadStructure) {
		this.roadStructure = roadStructure;
	}

	public String getRoadLinear() {
		return roadLinear;
	}

	public void setRoadLinear(String roadLinear) {
		this.roadLinear = roadLinear;
	}

	public String getRoadLandscape() {
		return roadLandscape;
	}

	public void setRoadLandscape(String roadLandscape) {
		this.roadLandscape = roadLandscape;
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

	
	public String getBeginMeterM() {
		return beginMeterM;
	}

	public void setBeginMeterM(String beginMeterM) {
		this.beginMeterM = beginMeterM;
	}

	
	public String getBeginMeterG() {
		return beginMeterG;
	}

	public void setBeginMeterG(String beginMeterG) {
		this.beginMeterG = beginMeterG;
	}

	public String getEndMeterG() {
		return endMeterG;
	}

	public void setEndMeterG(String endMeterG) {
		this.endMeterG = endMeterG;
	}

	public String getEndMeterM() {
		return endMeterM;
	}

	public void setEndMeterM(String endMeterM) {
		this.endMeterM = endMeterM;
	}

	

}
