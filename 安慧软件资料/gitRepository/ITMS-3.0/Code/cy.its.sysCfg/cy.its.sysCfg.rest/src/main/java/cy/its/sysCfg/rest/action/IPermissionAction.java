package cy.its.sysCfg.rest.action;

import java.util.Map;

import cy.its.sysCfg.rest.dto.RoleDto;


public interface IPermissionAction {
	/**
	 * 
	  * getRoleList ��ѯ��ɫȨ����Ϣ
	  * @Title: getRoleList
	  * @Description: TODO
	  * @param @return
	  * @param @throws Exception    �趨�ļ�
	  * @return List<RoleDto>    ��������
	  * @throws
	 */
	public Map  findPermission(String currentUserId,String currentOrgCode) throws Exception; 
	
}
