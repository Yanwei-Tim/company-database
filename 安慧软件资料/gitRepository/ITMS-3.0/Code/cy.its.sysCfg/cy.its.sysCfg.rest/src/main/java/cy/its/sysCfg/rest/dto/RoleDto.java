package cy.its.sysCfg.rest.dto;

import java.util.ArrayList;
import java.util.List;

import cy.its.com.dto.BaseDto;
import cy.its.com.util.ObjectMapUtils;
import cy.its.syscfg.domain.model.permission.Role;
import cy.its.syscfg.domain.model.permission.RoleFunction;
import cy.its.syscfg.domain.model.permission.RoleFunctionKey;

public class RoleDto extends BaseDto{
	
	public RoleDto(){
		
	}
	
	/**
	 *  ��������󴴽�dto
	
	  * ����һ���µ�ʵ�� RoleDto. 
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param role
	 */
	public RoleDto(Role role){
		ObjectMapUtils.parseObject(this, role);
		StringBuilder builder = new StringBuilder();
		for(RoleFunction foleFunction : role.allFunctions()){
			builder.append(foleFunction.getRoleFunctionKey().getFunctionCode()).append(",");
		}
		if(builder.length() > 0){
			this.functions = builder.substring(0, builder.length()-1);
		}
	}
	
	//��ɫId
	private String roleId;
	//��ɫ����
	private String roleName;
	//����״̬
	private String roleEnableFlag;
	//��ע
	private String roleRemark;
	
	private String dataAccessType;
	
	//���ܵ�id�ַ���
	private String functions;
	
	/**
	  * @throws Exception 
	  * 
	  * convertToRole ת�����������
	  * @Title: convertToRole
	  * @Description: TODO
	  * @param     �趨�ļ�
	  * @return void    ��������
	  * @throws
	 */
	public Role convertToRole() throws Exception{
		Role role = null;
		if(this.roleId != null && !"".equals(this.roleId)){
			role = new Role(this.roleId, this.roleName, this.roleEnableFlag, convertToRoleFunctions(this.roleId));
		}else{
			role = new Role(this.roleName,this.roleEnableFlag);
		}
		role.roleRemark = this.roleRemark;
		role.setDataAccessType(this.dataAccessType);
		role.setOrgCode(this.getCurrentOrgCode());
		return role;
	}
	/**
	 * 
	  * convertToRoleFunctions ת��Ϊ��ɫȨ�޶���
	  * @Title: convertToRoleFunctions
	  * @Description: TODO
	  * @param @param roleId
	  * @param @return
	  * @param @throws Exception    �趨�ļ�
	  * @return RoleFunction[]    ��������
	  * @throws
	 */
	public List<RoleFunction>  convertToRoleFunctions(String roleId) throws Exception{
		//��functions�ַ���ת��ΪRoleFunction�б�
		List<RoleFunction> roleFunctions = new ArrayList<RoleFunction>();
		String[] functionIds = this.functions.split(",");
		for(String functionId : functionIds){
			RoleFunctionKey roleFunctionKey = new RoleFunctionKey(roleId, functionId);
			RoleFunction roleFunction = new RoleFunction(roleFunctionKey);
			roleFunctions.add(roleFunction);
		}
		//���б�ת��Ϊ����
		return roleFunctions;
	}
	
	/**
	 * getter method
	 * @return the functions
	 */
	
	public String getFunctions() {
		return functions;
	}

	/**
	 * setter method
	 * @param functions the functions to set
	 */
	
	public void setFunctions(String functions) {
		this.functions = functions;
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
	public String getRoleRemark() {
		return roleRemark;
	}
	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}
	
}
