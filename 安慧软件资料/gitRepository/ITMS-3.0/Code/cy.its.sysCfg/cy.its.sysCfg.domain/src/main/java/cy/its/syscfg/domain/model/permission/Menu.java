package cy.its.syscfg.domain.model.permission;

import java.util.List;

import cy.its.com.domain.AggregateRoot;

public class Menu extends AggregateRoot {

	/**
	 * �˵�����
	 */
	private String menuCode;

	/**
	 * �˵�����
	 */
	private String menuName;

	/**
	 * �˵���ַ
	 */
	private String targetUrl;

	/**
	 * ���˵�����
	 */
	public String parentCode;

	/**
	 * ��������
	 */
	private String sortIndex;

	/**
	 * �˵����ñ��
	 */
	private String menuEnableFlag;
	
	/**
	 * ͼ������
	 */
	private String menuImageUrl;

	/**
	 * ��ע
	 */
	public String remark;

	/**
	 * ϵͳ�����б�
	 */
	private List<MenuFunction> functions;
	
	public Menu(){
		
	}
	public Menu(String menuCode, String menuName, String targetUrl,
			String sortIndex, String menuEnableFlag,
			List<MenuFunction> functions
			) throws Exception {
		this.setMenuCode(menuCode);
		this.setMenuName(menuName);
		this.setTargetUrl(targetUrl);
		this.setSortIndex(sortIndex);
		this.setMenuEnableFlag(menuEnableFlag);
		this.functions = functions;
	}

	@Override
	public String getIdentityId() {
		return menuCode;
	}

	/**
	 * �鿴���в˵�����
	 * @return
	 */
	public List<MenuFunction> allFunctions() {
		return functions;
	}

	public void setMenuCode(String menuCode) throws Exception {
		NotNull(menuCode, "�˵�����");
		this.menuCode = menuCode;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuName(String menuName) throws Exception {
		NotNull(menuName, "�˵�����");
		this.menuName = menuName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setTargetUrl(String targetUrl) throws Exception {
		//NotNull(targetUrl, "�˵���ַ");
		this.targetUrl = targetUrl;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setSortIndex(String sortIndex) throws Exception {
		NotNull(sortIndex, "��������");
		this.sortIndex = sortIndex;
	}

	public String getSortIndex() {
		return sortIndex;
	}

	public void setMenuEnableFlag(String menuEnableFlag) throws Exception {
		NotNull(menuEnableFlag, "�˵����ñ��");
		this.menuEnableFlag = menuEnableFlag;
	}

	public String getMenuEnableFlag() {
		return menuEnableFlag;
	}
	public String getMenuImageUrl() {
		return menuImageUrl;
	}
	public void setMenuImageUrl(String menuImageUrl) {
		this.menuImageUrl = menuImageUrl;
	}
	
}
