package cy.its.syscfg.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.com.util.StringUtil;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.model.permission.Menu;
import cy.its.syscfg.domain.model.permission.MenuFunction;
import cy.its.syscfg.domain.model.permission.Role;
import cy.its.syscfg.domain.model.permission.RoleFunction;
import cy.its.syscfg.domain.repository.duty.IUserRepository;
import cy.its.syscfg.domain.repository.home.IDailyMenuRepository;
import cy.its.syscfg.domain.repository.permission.IMenuRepository;
import cy.its.syscfg.domain.repository.permission.IRoleRepository;
import cy.its.syscfg.domain.service.IPermissionService;

/**
 * Ȩ�޷���
 *
 */
@Service
public class PermissionService implements IPermissionService {
	@Autowired
	IMenuRepository menuRepository;
	@Autowired
	IRoleRepository roleRepository;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	IDailyMenuRepository dailyMenuRepository;

	/**
	 * ��ѯ���й��ܵ�
	 * 
	 * @return ���в˵�����һ���˵��Ͷ����˵���
	 */
	public List<Menu> findMenuFunctions() {
		return menuRepository.findMenuFunctions();
	}

	@Override
	public List<Menu> findAllMenus() {
		return menuRepository.findAllMenus();
	}
	/**
	 * ��Ӳ˵�
	 * 
	 * @param menu
	 *            �˵���Ϣ
	 */
	public void addMenu(Menu menu) {
		menuRepository.save(menu);
	}

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
			String functionName, String functionFlag) throws Exception {
		menuRepository.addFunction(new MenuFunction(functionCode, functionName,
				functionFlag, menuCode));
	}

	/**
	 * ɾ��ָ���Ĳ˵�
	 * 
	 * @param menuCode
	 *            �˵�����
	 */
	public void deleteMenu(String menuCode) {
		menuRepository.delete(menuCode);
		menuRepository.deleteFunctionsOfMenu(menuCode);
		dailyMenuRepository.deleteByUserPermmission();
	}

	/**
	 * ɾ��ָ���Ĳ˵�����
	 * 
	 * @param functionCode
	 */
	public void deleteMenuFuntion(String functionCode) {
		menuRepository.deleteFunctionOfCode(functionCode);
		dailyMenuRepository.deleteByUserPermmission();
	}

	/**
	 * ��ѯ���н�ɫ
	 * 
	 * @return ��ɫ�б�
	 */
	public List<Role> findAllRoles(String orgCode) {
		return roleRepository.findAllRoles(orgCode);
	}
	

	
	/**
	 * �����½�ɫ
	 * 
	 * @param role
	 *            �½�ɫ��Ϣ
	 */
	public void createRole(Role role) {
		roleRepository.save(role);
		//roleRepository.saveAllFunctions(role.allFunctions());
	}

	/**
	 * ���½�ɫ
	 * 
	 * @param role
	 *            ��ɫ��Ϣ
	 */
	public void updateRole(Role role) {
		roleRepository.update(role);
		roleRepository.removeAllFunctions(role.getIdentityId());
		roleRepository.saveAllFunctions(role.allFunctions());
		dailyMenuRepository.deleteByUserPermmission();
	}

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
			throws Exception {
		Role role = roleRepository.aggregateOfId(roleId);
		if (role == null) {
			throw new Exception("��ɫ������");
		}
		role.addFunctions(roleFunctions);
		roleRepository.removeAllFunctions(roleId);
		roleRepository.saveAllFunctions(role.allFunctions());
		dailyMenuRepository.deleteByUserPermmission();
	}

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
			throws Exception {
		Role role = roleRepository.aggregateOfId(roleId);
		if (role == null) {
			throw new Exception("��ɫ������");
		}
		role.removeFunctions(functionCodes);
		roleRepository.removeAllFunctions(roleId);
		roleRepository.saveAllFunctions(role.allFunctions());
		dailyMenuRepository.deleteByUserPermmission();
	}

	/**
	 * ɾ��ָ���Ľ�ɫ
	 * 
	 * @param roleId
	 *            ��ɫΨһ��ʶID
	 */
	public void removeRole(String roleId) {
		userRepository.removeUserRolesByRoleId(roleId);
		roleRepository.removeAllFunctions(roleId);
		roleRepository.delete(roleId);
		dailyMenuRepository.deleteByUserPermmission();
	}

	@Override
	public List<Menu> menusOfUser(String userId) {
		return menuRepository.menusOfUser(userId);
	}

	@Override
	public List<String> findPermissinFunctionsByUser(User user) {
		if(user.roleIds == null || user.roleIds.isEmpty()){
			return new ArrayList<String>();
		}
		return menuRepository.findFunctionCodesByRoleIds(user.roleIds);
	}

	@Override
	public Map<String, MenuFunction> allMenuFunctions() {
		List<MenuFunction> lstF = menuRepository.allFuctions();
		if (lstF != null) {
			return lstF.stream().collect(Collectors.toMap(MenuFunction::getFunctionCode, (f) -> f));
		}
		return null;
	}

	@Override
	public List<String> findsubsribeKeys(User user) {
		return roleRepository.findSubsribeKeyByRoleIds(user.roleIds);
	}

	@Override
	public List<String> findsubsribeKeysByRoleId(String roleId) {
		List<String> roleIds = new ArrayList<String>();
		roleIds.add(roleId);
		return roleRepository.findSubsribeKeyByRoleIds(roleIds);
	}

	@Override
	public void saveAlarmSubsribePermission(String roleId, String keyStr) {
		if(!StringUtil.isNullOrEmpty(keyStr)){
			String[] keys = keyStr.split(",");
			for(String key : keys){
				roleRepository.saveAlarmSubsribePermission(roleId,key);
			}
		}
		
	}

	@Override
	public void deleteAlarmSubsribePermission(String roleId) {
		roleRepository.deleteAlarmSubsribePermission(roleId);
	}
}
