package cy.its.syscfg.domain.model.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cy.its.com.domain.AggregateRoot;

public class Role extends AggregateRoot {

	/**
	 * ��ɫID
	 */
	private String roleId;

	/**
	 * ��ɫ��
	 */
	private String roleName;

	/**
	 * 0��δ���ã�1�����á�
	 */
	private String roleEnableFlag;

	/**
	 * ��ע
	 */
	public String roleRemark;
	
	/**
	 * ����Ȩ�ޱ���
	 */
	private String dataAccessType;
	
	private String orgCode;

	/**
	 * �����б�
	 */
	private Map<String, RoleFunction> functionMap;

	public Role(String roleName, String roleEnableFlag) {
		// List<RoleFunction> functionList
		this.setRoleName(roleName);
		this.setRoleEnableFlag(roleEnableFlag);
		// functionMap = new HashMap<String, RoleFunction>();
		// for (RoleFunction roleFunction : functionList) {
		// if(functionMap.containsKey(roleFunction.getIdentityId().getFunctionCode())){
		//
		//
		// }
		// }

	}

	public Role(String roleId, String roleName, String roleEnableFlag,
			List<RoleFunction> functionList) {
		this(roleName, roleEnableFlag);
		this.setRoleId(roleId);

		functionMap = new HashMap<String, RoleFunction>();
		if (functionList != null) {
			for (RoleFunction roleFunction : functionList) {
				String key = roleFunction.getIdentityId().getFunctionCode();
				if (!functionMap.containsKey(key)) {
					functionMap.put(key, roleFunction);
				}
			}
		}
	}

	@Override
	public String getIdentityId() {
		return roleId;
	}

	/**
	 * �������н�ɫ���ù����б�
	 * 
	 * @return
	 */
	public RoleFunction[] allFunctions() {
		if (functionMap == null) {
			return null;
		}

		RoleFunction[] roleFunctions = new RoleFunction[functionMap.size()];
		return functionMap.values().toArray(roleFunctions);
	}

	/**
	 * Ϊ��ɫ��ӹ���
	 * 
	 * @param functions
	 * @throws Exception
	 */
	public void addFunctions(RoleFunction[] roleFunctions) throws Exception {

		if (functionMap == null) {
			throw new Exception("��ɫ��δ����,����Ϊ����ӽ�ɫ����");
		}

		String functionCode;
		for (RoleFunction roleFunction : roleFunctions) {
			if (!this.roleId.equals(roleFunction.getIdentityId().getRoleId())) {
				throw new Exception("��ӵĽ�ɫ���ܲ����ڵ�ǰ��ɫ");
			}

			functionCode = roleFunction.getIdentityId().getFunctionCode();

			if (this.functionMap.containsKey(functionCode)) {
				throw new Exception("��ӵĽ�ɫ�������ظ�");
			}

			this.functionMap.put(functionCode, roleFunction);
		}
	}

	public void removeFunctions(String[] functionCodes) {
		for (String code : functionCodes) {
			functionMap.remove(code);
		}
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleEnableFlag() {
		return roleEnableFlag;
	}

	public void setRoleEnableFlag(String roleEnableFlag) {
		this.roleEnableFlag = roleEnableFlag;
	}

	/**
	 * getter method
	 * @return the dataAccessType
	 */
	
	public String getDataAccessType() {
		return dataAccessType;
	}

	/**
	 * setter method
	 * @param dataAccessType the dataAccessType to set
	 */
	
	public void setDataAccessType(String dataAccessType) {
		this.dataAccessType = dataAccessType;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
