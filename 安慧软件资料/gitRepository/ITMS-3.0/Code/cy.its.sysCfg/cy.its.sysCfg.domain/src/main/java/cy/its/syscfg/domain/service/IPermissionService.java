package cy.its.syscfg.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.permission.Menu;
import cy.its.syscfg.domain.model.permission.MenuFunction;
import cy.its.syscfg.domain.model.permission.Role;
import cy.its.syscfg.domain.model.permission.RoleFunction;

public interface IPermissionService {

	/**
	 * ��ѯ���й��ܵ㣬�����˵���Ϣ
	 * 
	 * @return ���в˵�����һ���˵��Ͷ����˵���
	 */
	public List<Menu> findMenuFunctions();
	
	/**
	 *  
	  * findMenus ��ѯ���в˵���Ϣ
	  * @Title: findMenus
	  * @Description: TODO
	  * @param @return    �趨�ļ�
	  * @return List<Menu>    ��������
	  * @throws
	 */
	public List<Menu> findAllMenus();

	/**
	 * ��Ӳ˵�
	 * 
	 * @param menu
	 *            �˵���Ϣ
	 */
	public void addMenu(Menu menu);

	/**
	 * Ϊָ���˵����ָ������
	 * 
	 * @param menuCode
	 *            ָ���˵�����
	 * @param functionCode
	 *            ��ӹ��ܱ���
	 * @param functionName
	 *            ��ӹ�������
	 * @param functionFlag
	 *            �������ñ��
	 * @throws Exception
	 */
	public void addMenuFunction(String menuCode, String functionCode,
			String functionName, String functionFlag) throws Exception;

	/**
	 * ɾ��ָ���Ĳ˵�
	 * 
	 * @param menuCode
	 *            �˵�����
	 */
	public void deleteMenu(String menuCode);

	/**
	 * ɾ��ָ���Ĳ˵�����
	 * 
	 * @param functionCode
	 */
	public void deleteMenuFuntion(String functionCode);

	/**
	 * ��ѯ���н�ɫ
	 * @param orgCode 
	 * 
	 * @return ��ɫ�б�
	 */
	public List<Role> findAllRoles(String orgCode);

	/**
	 * �����½�ɫ
	 * 
	 * @param role
	 *            �½�ɫ��Ϣ
	 */
	public void createRole(Role role);

	/**
	 * ���½�ɫ
	 * 
	 * @param role
	 *            ��ɫ��Ϣ
	 */
	public void updateRole(Role role);

	/**
	 * Ϊָ���Ľ�ɫ��ӹ����б�
	 * 
	 * @param roleId
	 *            ��ɫΨһ��ʶID
	 * @param roleFunctions
	 *            �����б�
	 * @throws Exception
	 *             ��ɫ������
	 */
	public void addRoleFunctions(String roleId, RoleFunction[] roleFunctions)
			throws Exception;

	/**
	 * ɾ��ָ����ɫ�µĶ������
	 * 
	 * @param roleId
	 *            ��ɫΨһ��ʶID
	 * @param functionCodes
	 *            ��ɫ�µĶ�����ܱ���
	 * @throws Exception
	 */
	public void removeRoleFunctions(String roleId, String[] functionCodes)
			throws Exception;

	/**
	 * ɾ��ָ���Ľ�ɫ
	 * 
	 * @param roleId
	 *            ��ɫΨһ��ʶID
	 */
	public void removeRole(String roleId);
	
	/**
	 * ��ѯָ���û������в˵�
	 * @param userId
	 * @return
	 */
	public List<Menu> menusOfUser(String userId);

	/**
	 * �����û��������еĹ��ܵ�
	 * @param user
	 */
	public List<String> findPermissinFunctionsByUser(User user);
	
	/**
	 * ��ȡ���еĹ���
	 * @return ����MAP  key:���ܱ���  value:������Ϣ
	 */
	public Map<String, MenuFunction> allMenuFunctions();
	
	/**
	 * ����Ԥ������Ȩ��
	 * @param user
	 * @return
	 */
	public List<String> findsubsribeKeys(User user);

	/**
	 * ����Ȩ�޲��ұ�������Ȩ��
	 * @param roleId
	 * @return
	 */
	public List<String> findsubsribeKeysByRoleId(String roleId);
	
	/**
	 * ���汨������Ȩ��
	 * @param roleId
	 * @param keys
	 */
	public void saveAlarmSubsribePermission(String roleId, String keys);
	
	/**
	 * ���汨������Ȩ��
	 * @param roleId
	 */
	public void deleteAlarmSubsribePermission(String roleId);

}