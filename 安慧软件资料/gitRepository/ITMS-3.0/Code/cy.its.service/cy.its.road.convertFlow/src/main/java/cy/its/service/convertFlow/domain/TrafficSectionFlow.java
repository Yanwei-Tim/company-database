package cy.its.service.convertFlow.domain;

import java.util.Date;

import cy.its.service.util.TableColumn;

/**
* @Title:TrafficSectionFlow.java 
* @Package cy.its.road.convertFlow.domain 
* @Description:����������
* @author lil@cychina.cn
* @date 2015��10��28�� ����6:39:00 
* @version V1.0   
 */
public class TrafficSectionFlow {
	
	//ID
	@TableColumn(name="SECTION_STATE_ID")
    private String sectionStateId;

    /*
     * ����ID
     */
	@TableColumn(name="SECTION_ID")
    private String sectionId;

    /*
     * �������ܳ���
     */
	@TableColumn(name="TOTAL_NUM")
    private Integer totalNum;
	/*
	 * ����
	 */
	@TableColumn(name="LARGE_NUM")
    private Integer largeNum;
	/*
	 * С����
	 */
	@TableColumn(name="SMALL_NUM")
    private Integer smallNum;
	/*
	 * ��������
	 */
	@TableColumn(name="OTHER_NUM")
    private Integer otherNum;
	/*
	 * ƽ������
	 */
	@TableColumn(name="AVG_SPEED")
    private double avgSpeed;
	/*
	 * ��ͷʱ��
	 */
	@TableColumn(name="VEH_TAIL_SPACE")
    private double vehTailSpace;
	/*
	 * ���ݸ���ʱ��
	 */
	@TableColumn(name="UPDATE_TIME")
    private Date updateTime;
	
	/*
	 * ����Ȩ�޹���
	 */
	@TableColumn(name="ORG_PRIVILEGE_CODE")
    private String orgPrivilegeCode;
	

    public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getSectionStateId() {
        return sectionStateId;
    }

    public void setSectionStateId(String sectionStateId) {
        this.sectionStateId = sectionStateId;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getLargeNum() {
        return largeNum;
    }

    public void setLargeNum(Integer largeNum) {
        this.largeNum = largeNum;
    }

    public Integer getSmallNum() {
        return smallNum;
    }

    public void setSmallNum(Integer smallNum) {
        this.smallNum = smallNum;
    }

    public Integer getOtherNum() {
        return otherNum;
    }

    public void setOtherNum(Integer otherNum) {
        this.otherNum = otherNum;
    }

    /**
	 * @return the avgSpeed
	 */
	public double getAvgSpeed() {
		return avgSpeed;
	}

	/**
	 * @param avgSpeed the avgSpeed to set
	 */
	public void setAvgSpeed(double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public double getVehTailSpace() {
        return vehTailSpace;
    }

    public void setVehTailSpace(double vehTailSpace) {
        this.vehTailSpace = vehTailSpace;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}