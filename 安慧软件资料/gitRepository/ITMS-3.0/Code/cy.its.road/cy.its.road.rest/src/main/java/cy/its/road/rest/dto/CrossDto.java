/**
 * @Title: CrossDto.java
 * @Package cy.its.road.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��24�� ����1:54:57
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
  * @ClassName: CrossDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��24�� ����1:54:57
  *
  */

public class CrossDto extends BaseDto{
	//·��Id
	private String crossId;
	//·�ڴ���
	private String crossCode;
	//����Id
	private String orgId;
	//��������
	private String orgName;
	//��������
	private String districtCode;
	//·������
	private String crossName;
	//·������
	private String crossType;
	//·�ھ���
	private String crossLongitude;
	//·��γ��
	private String crossLatitude;
	//·����������·
	private String roadId;
	//·�ڶ�����
	private String sectionNum;
	//Ȩ�޹��˴���
    private String orgPrivilegeCode;
    
	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}
	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}
	public String getCrossId() {
		return crossId;
	}
	public void setCrossId(String crossId) {
		this.crossId = crossId;
	}
	public String getCrossCode() {
		return crossCode;
	}
	public void setCrossCode(String crossCode) {
		this.crossCode = crossCode;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getCrossName() {
		return crossName;
	}
	public void setCrossName(String crossName) {
		this.crossName = crossName;
	}
	public String getCrossType() {
		return crossType;
	}
	public void setCrossType(String crossType) {
		this.crossType = crossType;
	}
	
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	public String getCrossLongitude() {
		return crossLongitude;
	}
	public void setCrossLongitude(String crossLongitude) {
		this.crossLongitude = crossLongitude;
	}
	
	public String getCrossLatitude() {
		return crossLatitude;
	}
	public void setCrossLatitude(String crossLatitude) {
		this.crossLatitude = crossLatitude;
	}
	
	public String getSectionNum() {
		return sectionNum;
	}
	public void setSectionNum(String sectionNum) {
		this.sectionNum = sectionNum;
	}
	
}
