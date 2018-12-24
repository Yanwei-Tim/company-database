/**
 * @Title: MenuTreeDto.java
 * @Package cy.its.sysCfg.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author zuop zuop@cychina.cn
 * @date 2015��10��29�� ����11:23:17
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cy.its.syscfg.domain.model.permission.Menu;

/**
  * @ClassName: MenuTreeDto
  * @Description: �˵�������
  * @author zuop zuop@cychina.cn
  * @date 2015��10��29�� ����11:23:17
  *
  */

public class MenuTreeDto {
	
	/**
	 * �˵�id
	 */
	private String id;
	/**
	 * �˵�����
	 */
	private String text;
	
	/**
	 * �ӽڵ�
	 */
	private List<MenuTreeDto> children;
	
	/**
	 * ��������
	 */
	private Map<String,String> attribute = new HashMap<String,String>();

	/**
	
	  * ����һ���µ�ʵ�� MenuTreeDto. ���ò˵��͹��ܵ㼯��
	  * <p>Title: </p>
	  * <p>Description: </p>
	  * @param menuList �˵�������󼯺�
	 * @param functionList ���ܵ㼯��
	  */
	public MenuTreeDto(List<Menu> menuList, List<Menu> functionList) {
		//��ʼ�����ڵ�
		this.id = "root";
		this.text = "�ܿ�ƽ̨3.0";
		//��װ�ӽڵ�
		List<MenuTreeDto> children = new ArrayList<MenuTreeDto>();
		//��ʼ���˵��ڵ�
		setMenuInfoChildren(this.id,children,menuList);
		this.setChildren(children);
		//��ʼ�����ܵ�ڵ�
		setFunctionInfoChildren(this,functionList);
	}
	/**
	  * setFunctionInfoChildren ��������ӵ����ڵ���
	  *
	  * @Title: setFunctionInfoChildren
	  * @Description: TODO
	  * @param @param menuTreeDto
	  * @param @param functionList    �趨�ļ�
	  * @return void    ��������
	  * @throws
	  */
	private void setFunctionInfoChildren(MenuTreeDto menuTreeDto, List<Menu> functionList) {
		List<MenuTreeDto> fnChildren = menuTreeDto.getChildren();
		if(fnChildren != null && !fnChildren.isEmpty()){
			fnChildren.forEach(item -> {
				setFunctionInfoChildren(item,functionList);
			});
		}else{
			functionList.forEach(item -> {
				if(item.getMenuCode().equals(menuTreeDto.getId())){
					item.allFunctions().stream().forEach(fn -> {
						MenuTreeDto fnNode = new MenuTreeDto();
						fnNode.setId(fn.getIdentityId());
						fnNode.setText(fn.getFunctionName());
						fnChildren.add(fnNode);
					});
				}
			});
		}
	}
	/**
	  * �޲ι��캯��
	  * <p>Title: </p>
	  * <p>Description: </p>
	 */
	public MenuTreeDto(){
		
	}
	/**
	 * 
	  * setMenuInfoChildren ���˵���ӵ��ӽڵ���
	  * @Title: setMenuInfoChildren
	  * @Description: TODO
	  * @param @param children
	  * @param @param menuList    �趨�ļ�
	  * @return void    ��������
	  * @throws
	 */
	private void setMenuInfoChildren(String parentId,List<MenuTreeDto> children,List<Menu> menuList){
		menuList.forEach(item ->{
			if(parentId.equals(item.parentCode)){
				MenuTreeDto treeItem = new MenuTreeDto();
				treeItem.setId(item.getIdentityId());
				treeItem.setText(item.getMenuName());
				treeItem.getAttribute().put("url", item.getTargetUrl());
				treeItem.getAttribute().put("image", item.getMenuImageUrl());
				List<MenuTreeDto> itemChildren = new ArrayList<MenuTreeDto>();
				setMenuInfoChildren(item.getIdentityId(),itemChildren,menuList);
				treeItem.setChildren(itemChildren);
				children.add(treeItem);
			}
		});
	}
	/**
	 * getter method
	 * @return the id
	 */
	
	public String getId() {
		return id;
	}

	/**
	 * setter method
	 * @param id the id to set
	 */
	
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * getter method
	 * @return the text
	 */
	
	public String getText() {
		return text;
	}

	/**
	 * setter method
	 * @param text the text to set
	 */
	
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * getter method
	 * @return the children
	 */
	
	public List<MenuTreeDto> getChildren() {
		return children;
	}

	/**
	 * setter method
	 * @param children the children to set
	 */
	
	public void setChildren(List<MenuTreeDto> children) {
		this.children = children;
	}
	public Map<String, String> getAttribute() {
		return attribute;
	}
	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}
	
}
