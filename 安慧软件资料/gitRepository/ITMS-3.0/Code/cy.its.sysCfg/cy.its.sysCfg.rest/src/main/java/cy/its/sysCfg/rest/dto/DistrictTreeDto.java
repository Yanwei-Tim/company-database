package cy.its.sysCfg.rest.dto;

import java.util.List;
import java.util.Map;

public class DistrictTreeDto {
	 
	/**
	 * ����ID
	 */
	private String id;
	
	/**
	 * ��������
	 */
	private String text;
	
	/**
	 * �ӽڵ�
	 */
	private List<DistrictTreeDto> children;

	/**
	 *  ��������
	 */
	private Map<String,String> attribute;
	
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

	public List<DistrictTreeDto> getChildren() {
		return children;
	}

	public void setChildren(List<DistrictTreeDto> children) {
		this.children = children;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}
	
	
}
