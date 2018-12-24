package cy.its.service.analysisAlarm.domain;

import java.util.Date;

/**
* @Title: Visibility.java 
* @Package cy.its.service.visibility.domain 
* @Description: �ܼ���ģ��
* @author lil@cychina.cn
* @date 2015��11��6�� ����10:24:27 
* @version V1.0   
 */
public class VisibilityData {
    
	/**
	 * �豸ϵͳ����
	 */
	private  String  deviceSysNbr;
	
	/**
	* ��������
	*/
	private String orgCode;
	
	/**
	* ��Ͻ����Ȩ�޴���
	*/
	private String orgPrivilegeCode;
	
	/**
	* ��λ����
	*/
	private String siteCode;
	
	/**
	 * �Ƿ����ܼ���ֵ
	 */
	private  double  oneMinuteVisibility;
	
	/**
	 * ���ȼ�
	 */
	private  String  cleanDegre;
	
	/**
	 * RECORD_TIME
	 */
	private  Date  recordTime;
	
	/**
	 * ��·����
	 */
	private  String  roadType="0";
	
	
	/**
	 *�豸ID
	 */
	private String  deviceId="";
	
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public double getOneMinuteVisibility() {
		return oneMinuteVisibility;
	}

	public void setOneMinuteVisibility(double oneMinuteVisibility) {
		this.oneMinuteVisibility = oneMinuteVisibility;
	}

	public String getCleanDegre() {
		return cleanDegre;
	}

	public void setCleanDegre(String cleanDegre) {
		this.cleanDegre = cleanDegre;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}
	
}
