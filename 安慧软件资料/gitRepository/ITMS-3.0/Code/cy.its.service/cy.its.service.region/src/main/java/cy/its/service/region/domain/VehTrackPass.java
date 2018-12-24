package cy.its.service.region.domain;

import java.util.Date;

/**
* @Title: VehTrackPass.java 
* @Package cy.its.service.section.domain 
* @Description: ��ʱ����Ҫ�⼸���ֶ�
* @author lil@cychina.cn
* @date 2015��11��4�� ����1:59:37 
* @version V1.0   
 */
public class VehTrackPass {
	/**
	* ��λ����
	*/
	private String siteCode;
	/**
	* ���ƺ���
	*/
	private String plateNbr;
	
	/**
	* ������ɫ(003)
	*/
	private String plateColor;
	/**
	* ����ʱ��
	*/
	private Date passTime;
	
	
	/**
	* ��������
	*/
	private String orgCode;
	
	/**
	* ����Ȩ�޴���
	*/
	private String orgPrivilegeCode;
	
	
	/**
	* �������ͣ�070��
	*/
	private String directionType;
	
	
	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
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

	public Date getPassTime() {
		return passTime;
	}

	public void setPassTime(Date passTime) {
		this.passTime = passTime;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	
}