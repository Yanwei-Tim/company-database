package cy.its.sysCfg.rest.dto;

import java.util.List;

public class FastMenuDto {
	private String dailyMenuId;
	
	public String getDailyMenuId() {
		return dailyMenuId;
	}

	public void setDailyMenuId(String dailyMenuId) {
		this.dailyMenuId = dailyMenuId;
	}

	private String menuCode;    
    
    /**
	 * �˵�����
	 */
	private String menuName;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	/**
	 * �˵���ַ
	 */
	private String targetUrl;
	/**
	 * �Ӳ˵�
	 */
	private List<FastMenuDto> sonMenus;

	public List<FastMenuDto> getSonMenus() {
		return sonMenus;
	}

	public void setSonMenus(List<FastMenuDto> sonMenus) {
		this.sonMenus = sonMenus;
	}
	
}
