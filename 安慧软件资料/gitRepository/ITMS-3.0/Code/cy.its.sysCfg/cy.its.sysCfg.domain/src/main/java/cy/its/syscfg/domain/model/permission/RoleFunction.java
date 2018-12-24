package cy.its.syscfg.domain.model.permission;

import cy.its.com.domain.Entity;

public class RoleFunction extends Entity<RoleFunctionKey> {

	/**
	 * ��ɫ����key
	 */
	private RoleFunctionKey roleFunctionKey;


	/**
	 * ����Ȩ�ޱ��ʽ
	 */
	public java.lang.String dataAccessFormula;

	/**
	 * ��ע
	 */
	public java.lang.String remark;

	@SuppressWarnings("unused")
	private RoleFunction() {
	}

	public RoleFunction(RoleFunctionKey roleFunctionKey)
			throws Exception {
		this.setRoleFunctionKey(roleFunctionKey);
	}
	
	public void setRoleFunctionKey(RoleFunctionKey roleFunctionKey)
			throws Exception {
		NotNull(roleFunctionKey, "��ɫȨ�޹ؼ���");
		this.roleFunctionKey = roleFunctionKey;
	}

	public RoleFunctionKey getRoleFunctionKey() {
		return roleFunctionKey;
	}

	@Override
	public RoleFunctionKey getIdentityId() {
		return roleFunctionKey;
	}
}
