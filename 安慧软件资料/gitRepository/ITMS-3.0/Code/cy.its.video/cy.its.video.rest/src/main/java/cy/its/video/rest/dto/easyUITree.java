package cy.its.video.rest.dto;

import java.util.List;
import java.util.Map;

/**
 * easyui��tree�ṹ��
 * 
 * @author jinhaibo
 *
 */
public class easyUITree {

	/**
	 * ����
	 */
	private String id;

	/**
	 * �ı�
	 */
	private String text;

	/**
	 * ״̬
	 */
	private String state;

	/**
	 * ͼ��
	 */
	private String iconCls;

	/**
	 * �ӽڵ�
	 */
	private List<easyUITree> children;

	/**
	 * ��������
	 */
	private Map<String, String> attribute;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<easyUITree> getChildren() {
		return children;
	}

	public void setChildren(List<easyUITree> children) {
		this.children = children;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
}
