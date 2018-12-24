package cy.its.sysCfg.rest.dto;

public class OrgDto {
	//��������
	private String orgCode;
	//�ɻ�������
	private String oldOrgCode;
	// ����Ψһ��ʶ
	private String orgId;
	//�û�Id
	private String userId;
	//����Ȩ�޴���
	private String orgPrivilegeCode;
	//��������
	private String orgName;
	//��������
	private String orgLevel;
	//������
	private String parentOrgId;
	//����������
	private String parentOrgCode;
	
	//ҵ��ָ������
	private String parentInstructOrgId;
	//��������
	private String orgType;
	//����������
	private String orgHeaderName;
	//�����˵绰
	private String orgHeaderPhone;
	//������ϵ�˵绰
	private String orgPhoneNbr;
	//Ͻ����Χ
	private String sponsorDistributes;
	//����״̬
	private String enableFlag;
	//�Ƿ��Ƕ�������
	private String 	isDepartment;
	//�Ƿ��Ǹ��ٹ�����
	private String isHighwayOrg;
	//��ע
	private String remark;
	//פ�����ڳ���
	private String city;
	//פ����������
	private String districtCode;
	//פ�ص�ַ
	private String addressDesc;
	//����
	private String orgLongitude;
	//γ��
	private String orgLatitude;
	// ������Ϣҳ��
	private int pageNumber;
	// ������Ϣÿҳ��
	private int pageSize;
	
	
	public String getParentOrgCode() {
		return parentOrgCode;
	}
	public void setParentOrgCode(String parentOrgCode) {
		this.parentOrgCode = parentOrgCode;
	}
	
	
	public String getOldOrgCode() {
		return oldOrgCode;
	}
	public void setOldOrgCode(String oldOrgCode) {
		this.oldOrgCode = oldOrgCode;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	public String getOrgLevel() {
		return orgLevel;
	}
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel;
	}
	public String getParentOrgId() {
		return parentOrgId;
	}
	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}
	
	public String getParentInstructOrgId() {
		return parentInstructOrgId;
	}
	public void setParentInstructOrgId(String parentInstructOrgId) {
		this.parentInstructOrgId = parentInstructOrgId;
	}
	public String getOrgType() {
		return orgType;
	}
	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
	public String getOrgHeaderName() {
		return orgHeaderName;
	}
	public void setOrgHeaderName(String orgHeaderName) {
		this.orgHeaderName = orgHeaderName;
	}
	public String getOrgHeaderPhone() {
		return orgHeaderPhone;
	}
	public void setOrgHeaderPhone(String orgHeaderPhone) {
		this.orgHeaderPhone = orgHeaderPhone;
	}
	public String getOrgPhoneNbr() {
		return orgPhoneNbr;
	}
	public void setOrgPhoneNbr(String orgPhoneNbr) {
		this.orgPhoneNbr = orgPhoneNbr;
	}
	public String getSponsorDistributes() {
		return sponsorDistributes;
	}
	public void setSponsorDistributes(String sponsorDistributes) {
		this.sponsorDistributes = sponsorDistributes;
	}
	public String getEnableFlag() {
		return enableFlag;
	}
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
	
	public String getIsDepartment() {
		return isDepartment;
	}
	public void setIsDepartment(String isDepartment) {
		this.isDepartment = isDepartment;
	}
	
	public String getIsHighwayOrg() {
		return isHighwayOrg;
	}
	public void setIsHighwayOrg(String isHighwayOrg) {
		this.isHighwayOrg = isHighwayOrg;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getAddressDesc() {
		return addressDesc;
	}
	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}
	public String getOrgLongitude() {
		return orgLongitude;
	}
	public void setOrgLongitude(String orgLongitude) {
		this.orgLongitude = orgLongitude;
	}
	public String getOrgLatitude() {
		return orgLatitude;
	}
	public void setOrgLatitude(String orgLatitude) {
		this.orgLatitude = orgLatitude;
	}

	
	
	
}