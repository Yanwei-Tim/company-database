package cy.its.syscfg.mybatis.model;

public class LoginTime {

	/**
	 * �û���
	 */
	private String userName;
	
	/**
	 * ��¼����
	 */
	private Long loginTime;
	
	/**
	 * ����¼ʱ��
	 */
	private String lastLoginTime; 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Long loginTime) {
		this.loginTime = loginTime;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
