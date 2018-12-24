package cy.its.syscfg.domain.model.duty;

import java.util.Date;
import java.util.List;

import cy.its.com.constant.SysCodeConstant;
import cy.its.com.domain.AggregateRoot;

/**
 * @author STJ
 *
 */
public final class User extends AggregateRoot {

	/**
	 * �û�ID
	 */
	private String userId;

	/**
	 * �ⵥλID
	 */
	public String otherOrgId;

	/**
	 * ����ID
	 */
	public String orgId;

	/**
	 * ��Ա
	 */
	private Police police;

	/**
	 * ��¼��
	 */
	private String loginName;

	/**
	 * ��½����
	 */
	private String loginPassword;

	/**
	 * ���IP��IP��Χ
	 */
	public String permissionIpList;

	/**
	 * ��¼״̬
	 */
	private String isOnline;

	/**
	 * ���һ�ε�¼ʱ��
	 */
	private Date latestLoginTime;

	/**
	 * ��¼����
	 */
	private Integer totalLoginCounts = 0;

	/**
	 * ����
	 */
	public String name;

	/**
	 * ��Ч��
	 */
	public Date validDate;

	/**
	 * �û���ɫ�б�
	 */
	public List<String> roleIds;

	// static UserAssignRoleSpecification userAssignRoleSpecification = new
	// UserAssignRoleSpecification();

	public User(Police police, String loginName, String loginPassword,
			String permissionIpList, Date validDate, String orgId)
			throws Exception {

		this.police = police;
		this.setLoginName(loginName);
		this.setLoginPassword(loginPassword);
		this.permissionIpList = permissionIpList;
		this.validDate = validDate;
		this.orgId = orgId;
		this.isOnline = SysCodeConstant.ONLINE_STATUS_OFF;
		this.latestLoginTime = new Date();
	}

	public User(String userId, String orgId, Police police, String loginName,
			String loginPassword, String permissionIpList, String isOnline,
			Date latestLoginTime, Integer totalLoginCounts, String name,
			Date validDate, List<String> roleIds) throws Exception {

		this(police, loginName, loginPassword, permissionIpList, validDate,
				orgId);

		this.userId = userId;
		this.isOnline = isOnline;
		this.latestLoginTime = latestLoginTime;
		this.totalLoginCounts = totalLoginCounts;
		this.name = name;
		this.roleIds = roleIds;
		// roleIds.stream().map(
		// r-> new UserRole(this.userId, r)).
		// collect(Collectors.toList());
	}

	@Override
	public String getIdentityId() {
		return this.userId;
	}

	/**
	 * �����ɫ
	 * 
	 * @param role
	 * @throws Exception
	 */
	public void assignRoles(String... roleIdArr) throws Exception {
		if (roleIds != null) {
			for (String roleId : roleIdArr) {
				if (roleIds.contains(roleId)) {
					throw new Exception("��ǰ�û�����Ľ�ɫ�ظ�");
				}

				roleIds.add(roleId);
			}
		}
	}

	/**
	 * ɾ���û���ɫ
	 * 
	 * @param role
	 */
	public void removeRoles(String... roleIdArr) {
		if (roleIds != null) {
			for (String roleId : roleIdArr) {
				if (roleIds.contains(roleId)) {
					roleIds.remove(roleId);
				}
			}
		}
	}

	/**
	 * ��ȡ��ǰ�û�Ȩ���б�
	 * 
	 * @return
	 */
	public String[] roleIds() {
		return roleIds.toArray(new String[roleIds.size()]);
	}

	/**
	 * ��֤
	 * 
	 * @param loginName
	 * @param passWord
	 * @return
	 * @throws Exception
	 */
	public boolean authorize(String loginName, String passWord)
			throws Exception {

		if (this.loginName.equals(loginName)
				&& this.loginPassword.equals(passWord)) {
			Date systime = new Date();

			if (systime.after(this.validDate)) {
				throw new Exception("�����û�");
			}

			this.totalLoginCounts++;
			this.latestLoginTime = systime;

			return true;
		}

		return false;
	}

	/**
	 * @return the latestLoginTime
	 */
	public java.util.Date getLatestLoginTime() {
		return latestLoginTime;
	}

	/**
	 * @return the totalLoginCounts
	 */
	public Integer getTotalLoginCounts() {
		return totalLoginCounts;
	}

	public void setUserId(String userId) throws Exception {
		NotNull(userId, "�û�ID");
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setPolice(Police police) throws Exception {
		// NotNull(police, "��Ա");
		this.police = police;
	}

	public Police getPolice() {
		return police;
	}

	public void setLoginName(String loginName) throws Exception {
		NotNull(loginName, "��¼��");
		this.loginName = loginName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginPassword(String loginPassword) throws Exception {
		//NotNull(loginPassword, "��½����");
		this.loginPassword = loginPassword;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	// public void setIsOnline( String isOnline) throws Exception {
	// NotNull(isOnline, "��¼״̬");
	// this.isOnline = isOnline;
	// }

	public String getIsOnline() {
		return isOnline;
	}

	// public void setLatestLoginTime( Date latestLoginTime) throws Exception {
	// NotNull(latestLoginTime, "���һ�ε�¼ʱ��");
	// this.latestLoginTime = latestLoginTime;
	// }

	// public Date getLatestLoginTime() {
	// return latestLoginTime;
	// }

	// public void setTotalLoginCounts( Integer totalLoginCounts) throws
	// Exception {
	// NotNull(totalLoginCounts, "��¼����");
	// this.totalLoginCounts = totalLoginCounts;
	// }

}
