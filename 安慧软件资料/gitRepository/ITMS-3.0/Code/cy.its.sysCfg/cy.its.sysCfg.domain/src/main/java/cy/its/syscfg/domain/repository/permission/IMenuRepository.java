package cy.its.syscfg.domain.repository.permission;

import java.util.List;

import cy.its.com.domain.IRepository;
import cy.its.syscfg.domain.model.permission.Menu;
import cy.its.syscfg.domain.model.permission.MenuFunction;

public interface IMenuRepository extends IRepository<Menu> {
	List<Menu> findMenuFunctions();

	void addFunction(MenuFunction menuFunction);
	void deleteFunctionOfCode(String functionCode);
	void deleteFunctionsOfMenu(String menuCode);
	void modifyFunction(MenuFunction menuFunction);
	/**
	 * 
	  * findAllMenus �������еĲ˵�
	  * @Title: findAllMenus
	  * @Description: TODO
	  * @param     �趨�ļ�
	  * @return void    ��������
	  * @throws
	 */
	List<Menu> findAllMenus();

	List<Menu> menusOfUser(String userId);
	
	/**
	 * ����ȫ��ID���ҹ��ܵ㼯��
	 * @param roleIds
	 * @return
	 */
	List<String> findFunctionCodesByRoleIds(List<String> roleIds);

	
	List<MenuFunction> allFuctions();
}
