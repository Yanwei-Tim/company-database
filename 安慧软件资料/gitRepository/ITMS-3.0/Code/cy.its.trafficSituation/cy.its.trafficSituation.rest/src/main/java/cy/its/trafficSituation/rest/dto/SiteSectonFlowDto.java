/**
 * @Title: SiteSectonFlowDto.java
 * @Package cy.its.trafficSituation.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��26�� ����2:30:57
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.dto;

import java.util.List;

import cy.its.com.dto.BaseDto;
import cy.its.device.domain.model.site.Site;

public class SiteSectonFlowDto extends BaseDto {

	public SiteSectonFlowDto(Site site) {
		this.siteId = site.getSiteId();
		this.crossId = site.getCrossId();
		this.districtCode = site.getDistrictCode();
		this.mileage = site.getMileage();
		this.orgId = site.getOrgId();
		this.remark = site.getRemark();
		this.roadId = site.getRoadId();
		this.roadSectionId = site.getRoadSectionId();
		this.siteCode = site.getSiteCode();
		this.siteLandscape = site.getSiteLandscape();
		if (site.getSiteLatitude() != null) {
			this.siteLatitude = site.getSiteLatitude().toString();
		}
		if (site.getSiteLongitude() != null) {
			this.siteLongitude = site.getSiteLongitude().toString();
		}
		this.siteName = site.getSiteName();
		this.siteSimpleName = site.getSiteSimpleName();
		this.siteType = site.getSiteType();
	}

	// Ĭ�Ϲ��췽��
	public SiteSectonFlowDto() {

	}

	// ��λId
	private String siteId;

	// ������·Id
	private String roadId;

	// ����·��ID
	private String crossId;

	// ����·��ID
	private String roadSectionId;

	// ��λ����
	private String siteCode;

	// ��λ����
	private String siteName;

	// ��λ���Ƽ��
	private String siteSimpleName;

	// ��λ����
	private String siteType;

	// ����
	private String mileage;

	// ����������������
	private String districtCode;

	// ��������Id
	private String orgId;

	// ��������Id�б����ŷָ�
	private String orgIds;

	// ��λ����
	private String siteLongitude;

	// ��λγ��
	private String siteLatitude;

	// ��λ����
	private String siteLandscape;

	// ��ע
	private String remark;

	// ��λ�����ж���
	private List<SectionFlowDto> sections;

	/**
	 * getter method
	 * 
	 * @return the siteId
	 */

	public String getSiteId() {
		return siteId;
	}

	/**
	 * setter method
	 * 
	 * @param siteId
	 *            the siteId to set
	 */

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	/**
	 * getter method
	 * 
	 * @return the roadId
	 */

	public String getRoadId() {
		return roadId;
	}

	/**
	 * setter method
	 * 
	 * @param roadId
	 *            the roadId to set
	 */

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	/**
	 * getter method
	 * 
	 * @return the crossId
	 */

	public String getCrossId() {
		return crossId;
	}

	/**
	 * setter method
	 * 
	 * @param crossId
	 *            the crossId to set
	 */

	public void setCrossId(String crossId) {
		this.crossId = crossId;
	}

	/**
	 * getter method
	 * 
	 * @return the roadSectionId
	 */

	public String getRoadSectionId() {
		return roadSectionId;
	}

	/**
	 * setter method
	 * 
	 * @param roadSectionId
	 *            the roadSectionId to set
	 */

	public void setRoadSectionId(String roadSectionId) {
		this.roadSectionId = roadSectionId;
	}

	/**
	 * getter method
	 * 
	 * @return the siteCode
	 */

	public String getSiteCode() {
		return siteCode;
	}

	/**
	 * setter method
	 * 
	 * @param siteCode
	 *            the siteCode to set
	 */

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	/**
	 * getter method
	 * 
	 * @return the siteName
	 */

	public String getSiteName() {
		return siteName;
	}

	/**
	 * setter method
	 * 
	 * @param siteName
	 *            the siteName to set
	 */

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * getter method
	 * 
	 * @return the siteSimpleName
	 */

	public String getSiteSimpleName() {
		return siteSimpleName;
	}

	/**
	 * setter method
	 * 
	 * @param siteSimpleName
	 *            the siteSimpleName to set
	 */

	public void setSiteSimpleName(String siteSimpleName) {
		this.siteSimpleName = siteSimpleName;
	}

	/**
	 * getter method
	 * 
	 * @return the siteType
	 */

	public String getSiteType() {
		return siteType;
	}

	/**
	 * setter method
	 * 
	 * @param siteType
	 *            the siteType to set
	 */

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	/**
	 * getter method
	 * 
	 * @return the mileage
	 */

	public String getMileage() {
		return mileage;
	}

	/**
	 * setter method
	 * 
	 * @param mileage
	 *            the mileage to set
	 */

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	/**
	 * getter method
	 * 
	 * @return the districtCode
	 */

	public String getDistrictCode() {
		return districtCode;
	}

	/**
	 * setter method
	 * 
	 * @param districtCode
	 *            the districtCode to set
	 */

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	/**
	 * getter method
	 * 
	 * @return the orgId
	 */

	public String getOrgId() {
		return orgId;
	}

	/**
	 * setter method
	 * 
	 * @param orgId
	 *            the orgId to set
	 */

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	/**
	 * getter method
	 * 
	 * @return the orgIds
	 */

	public String getOrgIds() {
		return orgIds;
	}

	/**
	 * setter method
	 * 
	 * @param orgIds
	 *            the orgIds to set
	 */

	public void setOrgIds(String orgIds) {
		this.orgIds = orgIds;
	}

	/**
	 * getter method
	 * 
	 * @return the siteLongitude
	 */

	public String getSiteLongitude() {
		return siteLongitude;
	}

	/**
	 * setter method
	 * 
	 * @param siteLongitude
	 *            the siteLongitude to set
	 */

	public void setSiteLongitude(String siteLongitude) {
		this.siteLongitude = siteLongitude;
	}

	/**
	 * getter method
	 * 
	 * @return the siteLatitude
	 */

	public String getSiteLatitude() {
		return siteLatitude;
	}

	/**
	 * setter method
	 * 
	 * @param siteLatitude
	 *            the siteLatitude to set
	 */

	public void setSiteLatitude(String siteLatitude) {
		this.siteLatitude = siteLatitude;
	}

	/**
	 * getter method
	 * 
	 * @return the siteLandscape
	 */

	public String getSiteLandscape() {
		return siteLandscape;
	}

	/**
	 * setter method
	 * 
	 * @param siteLandscape
	 *            the siteLandscape to set
	 */

	public void setSiteLandscape(String siteLandscape) {
		this.siteLandscape = siteLandscape;
	}

	/**
	 * getter method
	 * 
	 * @return the remark
	 */

	public String getRemark() {
		return remark;
	}

	/**
	 * setter method
	 * 
	 * @param remark
	 *            the remark to set
	 */

	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * getter method
	 * 
	 * @return the sections
	 */

	public List<SectionFlowDto> getSections() {
		return sections;
	}

	/**
	 * setter method
	 * 
	 * @param sections
	 *            the sections to set
	 */

	public void setSections(List<SectionFlowDto> sections) {
		this.sections = sections;
	}
}
