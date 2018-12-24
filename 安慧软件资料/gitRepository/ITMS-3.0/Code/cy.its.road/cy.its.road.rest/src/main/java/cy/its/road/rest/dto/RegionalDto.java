/**
 * @Title: ReglonalDto.java
 * @Package cy.its.road.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��21�� ����10:29:51
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
  * @ClassName: ReglonalDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��21�� ����10:29:51
  *
  */

public class RegionalDto extends BaseDto{
	//����Id
	private String regionalId;
	//������
	private String regionalCode;
	//��������
	private String regionalName;
	//��������
	private String districtCode;
	//����Id
	private String orgId;
	//��������
	private String orgName;
	//��·Id
	private String roadId;
	//��·����
	private String roadName;
	//���Id
	private String entrySiteId;
	//��λ������� 
	private String entrySiteName;
	//�յ�Id
	private String exitSiteId;
	//��λ �յ����� 
	private String exitSiteName;
	//��������
	private String directionType;
	//��������
	private String directionName;
	//������
	private String laneNum;
	//�Ƿ�֧���������
	//private String hasSupportSpeed;
	//�Ƿ�֧�������������
	//private String hasSupportVehicleFlow;
	//������ʷ�߷峵����
	private String hisToryMaxVehicleNum;
	//�߷�ʱ��
	private String hisToryMaxFlowTime;
	//�Ƿ�֧�ֲ�������
	private String hasSupportSpeed;
	//�����������
	private String  regionalDesignCapacity;
	//���޸���
	private String limitLarge;
	//С���޸���
	private String limitSmall;
	//�������޸���
	//private String limitOthers;
	//�޵���
	private String limitLower;
	//����������ֵ 
	//С����������ֵ
	//���ñ�ʶ
	private String enableFlag;
	//�������
    private  String distance;
    //Ȩ�޹��˴���
    private String orgPrivilegeCode;
	
	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}
	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getRegionalId() {
		return regionalId;
	}
	public void setRegionalId(String regionalId) {
		this.regionalId = regionalId;
	}
	public String getRegionalCode() {
		return regionalCode;
	}
	public void setRegionalCode(String regionalCode) {
		this.regionalCode = regionalCode;
	}
	public String getRegionalName() {
		return regionalName;
	}
	public void setRegionalName(String regionalName) {
		this.regionalName = regionalName;
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
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getRoadId() {
		return roadId;
	}
	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}
	
	public String getRoadName() {
		return roadName;
	}
	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}
		
	public String getEntrySiteId() {
		return entrySiteId;
	}
	public void setEntrySiteId(String entrySiteId) {
		this.entrySiteId = entrySiteId;
	}
	public String getExitSiteId() {
		return exitSiteId;
	}
	public void setExitSiteId(String exitSiteId) {
		this.exitSiteId = exitSiteId;
	}
	public String getEntrySiteName() {
		return entrySiteName;
	}
	public void setEntrySiteName(String entrySiteName) {
		this.entrySiteName = entrySiteName;
	}
	public String getExitSiteName() {
		return exitSiteName;
	}
	public void setExitSiteName(String exitSiteName) {
		this.exitSiteName = exitSiteName;
	}
	public String getDirectionType() {
		return directionType;
	}
	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}
	public String getDirectionName() {
		return directionName;
	}
	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}
	public String getLaneNum() {
		return laneNum;
	}
	public void setLaneNum(String laneNum) {
		this.laneNum = laneNum;
	}
//	public String getHasSupportSpeed() {
//		return hasSupportSpeed;
//	}
//	public void setHasSupportSpeed(String hasSupportSpeed) {
//		this.hasSupportSpeed = hasSupportSpeed;
//	}
//	public String getHasSupportVehicleFlow() {
//		return hasSupportVehicleFlow;
//	}
//	public void setHasSupportVehicleFlow(String hasSupportVehicleFlow) {
//		this.hasSupportVehicleFlow = hasSupportVehicleFlow;
//	}
	public String getHisToryMaxVehicleNum() {
		return hisToryMaxVehicleNum;
	}
	public void setHisToryMaxVehicleNum(String hisToryMaxVehicleNum) {
		this.hisToryMaxVehicleNum = hisToryMaxVehicleNum;
	}
	public String getHisToryMaxFlowTime() {
		return hisToryMaxFlowTime;
	}
	public void setHisToryMaxFlowTime(String hisToryMaxFlowTime) {
		this.hisToryMaxFlowTime = hisToryMaxFlowTime;
	}
	public String getRegionalDesignCapacity() {
		return regionalDesignCapacity;
	}
	public void setRegionalDesignCapacity(String regionalDesignCapacity) {
		this.regionalDesignCapacity = regionalDesignCapacity;
	}
	public String getLimitLarge() {
		return limitLarge;
	}
	public void setLimitLarge(String limitLarge) {
		this.limitLarge = limitLarge;
	}
	public String getLimitSmall() {
		return limitSmall;
	}
	public void setLimitSmall(String limitSmall) {
		this.limitSmall = limitSmall;
	}
//	public String getLimitOthers() {
//		return limitOthers;
//	}
//	public void setLimitOthers(String limitOthers) {
//		this.limitOthers = limitOthers;
//	}
	public String getLimitLower() {
		return limitLower;
	}
	public void setLimitLower(String limitLower) {
		this.limitLower = limitLower;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	public String getHasSupportSpeed() {
		return hasSupportSpeed;
	}
	public void setHasSupportSpeed(String hasSupportSpeed) {
		this.hasSupportSpeed = hasSupportSpeed;
	}
		
}
