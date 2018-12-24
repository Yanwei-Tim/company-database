package cy.its.sysCfg.rest.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import cy.its.com.constant.SysCodeConstant;
import cy.its.com.dto.BaseDto;
import cy.its.com.util.DateUtil;
import cy.its.com.util.ObjectMapUtils;
import cy.its.syscfg.domain.model.duty.Police;
import cy.its.syscfg.domain.model.duty.User;

/**
 * �û���Ϣ
 */
public class UserDto extends BaseDto{
	
	private String userId;
	//����Id
	private String orgId;
	//����ҳ��
	private int pageNumber;
	//ÿҳ��¼����
	private int pageSize;
	//����
	private String policeName;
	//��ԱID
	private String policeId;
	//����
	private String policeCode;
	//��Ա���
	private String policeNbr;
	//�Ƿ�����״̬
	private String isOnline;
	//��Ա����
	private String policeType;
	//ҵ���λ
	private String businessPost;
	//���֤����
	private String personId;
	//��������
	private String authorizedType;
	//������ȼ�
	private String eventLevel;
	//�쵼����
	private String leaderLevel;
	//��������
	private String birthDate;
	//�Ա�
	private String sex;
	//����
	private String policeRank;
	//ְ��
	private String jobLevel;
	//ְλ
	private String position;
	//��ϵ�绰
	private String pPhoneNbr;
	//�칫�绰
	private String officePhone;
	//��ͥסַ
	private String familyAddress;
	//��������
	private String email;
	//�û���
	private String loginName;
	//����
	private String loginPassword;
	//��Чʱ��
	private String validDate;
	//���Ip
	private String permissionIpList;
	
	private String loginTime;
	
	private String lastLoginTime;
	
	//��ɫId
	private String roleIds;
	
	public UserDto(){
		
	}
	/**
	
	  * ����һ���µ�ʵ�� UserDto. �����������ת��
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param user
	  */
	public UserDto(User user) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		this.userId = user.getUserId();
		this.orgId = user.getPolice().getOrgId();
		this.policeId = user.getPolice().getIdentityId();
		this.policeName = user.getPolice().getPoliceName();
		this.policeCode = user.getPolice().getPoliceCode();
		this.policeNbr = user.getPolice().getPoliceNbr();
		this.isOnline = user.getIsOnline();
		this.policeType = user.getPolice().getPoliceType();
		this.businessPost = user.getPolice().getBusinessPost();
		this.personId = user.getPolice().getPersonId();
		this.authorizedType = user.getPolice().getAuthorizedType();
		this.eventLevel = user.getPolice().getEventLevel();
		this.leaderLevel = user.getPolice().getLeaderLevel();
		if(user.getPolice().getBirthDate() != null){
			this.birthDate = sf.format(user.getPolice().getBirthDate());
		}
		this.sex = user.getPolice().getSex();
		this.policeRank = user.getPolice().getPoliceRank();
		this.jobLevel = user.getPolice().getJobLevel();
		this.position = user.getPolice().getPosition();
		this.pPhoneNbr = user.getPolice().getpPhoneNbr();
		this.officePhone = user.getPolice().getOfficePhone();
		this.familyAddress = user.getPolice().getFamilyAddress();
		this.email = user.getPolice().getEmail();
		this.loginName = user.getLoginName();
		if(user.getLatestLoginTime() != null){
			this.lastLoginTime = DateUtil.formatDate(user.getLatestLoginTime());
		}
		if(user.getTotalLoginCounts() != null){
			this.loginTime = user.getTotalLoginCounts() + "";
		}
		this.loginPassword = user.getLoginPassword();
		if(user.validDate != null){
			this.validDate = sf.format(user.validDate);
		}
		this.permissionIpList = user.permissionIpList;
		
		if(user.roleIds != null && user.roleIds.size() > 0){
			StringBuilder sb = new StringBuilder();
			for(String roleId : user.roleIds()){
				sb.append(roleId).append(",");
			}
			this.roleIds = sb.substring(0, sb.length()-1);
		}
	}
	
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getIsOnline() {
		return isOnline;
	}
	public void setIsOnline(String isOnline) {
		this.isOnline = isOnline;
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
	
	
	public String getPoliceName() {
		return policeName;
	}
	public void setPoliceName(String policeName) {
		this.policeName = policeName;
	}
	public String getPoliceId() {
		return policeId;
	}
	public void setPoliceId(String policeId) {
		this.policeId = policeId;
	}
	
	public String getPoliceCode() {
		return policeCode;
	}
	public void setPoliceCode(String policeCode) {
		this.policeCode = policeCode;
	}
	public String getPoliceNbr() {
		return policeNbr;
	}
	public void setPoliceNbr(String policeNbr) {
		this.policeNbr = policeNbr;
	}
	public String getPoliceType() {
		return policeType;
	}
	public void setPoliceType(String policeType) {
		this.policeType = policeType;
	}
	public String getBusinessPost() {
		return businessPost;
	}
	public void setBusinessPost(String businessPost) {
		this.businessPost = businessPost;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getAuthorizedType() {
		return authorizedType;
	}
	public void setAuthorizedType(String authorizedType) {
		this.authorizedType = authorizedType;
	}
	public String getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPoliceRank() {
		return policeRank;
	}
	public void setPoliceRank(String policeRank) {
		this.policeRank = policeRank;
	}
	public String getJobLevel() {
		return jobLevel;
	}
	public void setJobLevel(String jobLevel) {
		this.jobLevel = jobLevel;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getpPhoneNbr() {
		return pPhoneNbr;
	}
	public void setpPhoneNbr(String pPhoneNbr) {
		this.pPhoneNbr = pPhoneNbr;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public String getFamilyAddress() {
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	public String getPermissionIpList() {
		return permissionIpList;
	}
	public void setPermissionIpList(String permissionIpList) {
		this.permissionIpList = permissionIpList;
	}
	public String getLeaderLevel() {
		return leaderLevel;
	}
	public void setLeaderLevel(String leaderLevel) {
		this.leaderLevel = leaderLevel;
	}
	
	/**
	 * getter method
	 * @return the roleIds
	 */
	
	public String getRoleIds() {
		return roleIds;
	}
	/**
	 * setter method
	 * @param roleIds the roleIds to set
	 */
	
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	/**
	 * getter method
	 * @return the userId
	 */
	
	public String getUserId() {
		return userId;
	}
	/**
	 * setter method
	 * @param userId the userId to set
	 */
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * @throws Exception 
	 * @throws ParseException 
	  * convertToUser      ת�����������
	  * @Title: convertToUser
	  * @Description: TODO
	  * @param @return    �趨�ļ�
	  * @return User    ��������
	  * @throws
	  */
	public User convertToUser() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Police police = new Police();
		police.setBirthDate(df.parse(this.getBirthDate()));
		if(this.policeId == null || "".equals(this.policeId)){
			//����ʱ��ʼ���ֶ�
			police.setpRecordStatus(SysCodeConstant.P_RECORD_STATUS_NORMAL);
			police.setpEnableFlag(SysCodeConstant.ENABLE_FLAG_ENANLE);
		}
		ObjectMapUtils.parseObject(police, this);
		Date validateTime = null;
		if(this.validDate != null && !"".equals(this.getValidDate())){
			validateTime = df.parse(this.getValidDate());
		}
		User user = new User(police, this.getLoginName().toUpperCase(), this.getLoginPassword(),
				this.getPermissionIpList(), validateTime, this.getOrgId());
		user.name = this.getPoliceName();
		if(this.userId != null && !"".equals(this.userId)){
			user.setUserId(userId);
		}
		return user;
	}
}





