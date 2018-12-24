package cy.its.sysCfg.rest.dto;

import java.util.List;
import java.util.Map;

public class OrgTreeDto {
	
	//�������
	String id;
	//��������
	String text;
	//�ӽڵ�
	List<OrgTreeDto> children;
	//��������
	Map<String,String> attribute;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<OrgTreeDto> getChildren() {
		return children;
	}
	public void setChildren(List<OrgTreeDto> children) {
		this.children = children;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Map<String, String> getAttribute() {
		return attribute;
	}
	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}
	
}
