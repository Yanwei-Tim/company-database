package cy.its.service.region.domain;


/**
* @Title: Section.java 
* @Package cy.its.service.section.domain 
* @Description: �������
* @author lil@cychina.cn
* @date 2015��11��4�� ����2:01:17 
* @version V1.0   
 */
public class Region {
	/**
	 * ����ID
	 */
	private String regionalId;
	/**
	 * ����λ
	 */
	private String startSiteCode;
	/**
	 * �յ��λ
	 */
	private String endSiteCode;

	/**
	* �������ͣ�070��
	*/
	private String directionType;
	
	/**
	 * �������
	 */
	private String  distance;
	
	/**
	 * ��·����
	 */
	private String roadType;
	
    
	/**
	 *����Ȩ�޴���
	 */
    private String  orgPrivilegeCode;
    
    
	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getRegionalId() {
		return regionalId;
	}

	public void setRegionalId(String regionalId) {
		this.regionalId = regionalId;
	}

	public String getStartSiteCode() {
		return startSiteCode;
	}

	public void setStartSiteCode(String startSiteCode) {
		this.startSiteCode = startSiteCode;
	}

	public String getEndSiteCode() {
		return endSiteCode;
	}

	public void setEndSiteCode(String endSiteCode) {
		this.endSiteCode = endSiteCode;
	}

	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
	
}
