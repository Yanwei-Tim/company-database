package cy.its.sysCfg.rest.dto;

import java.util.List;
import java.util.Map;

public class CodeTypeTreeDto {
		//�������ͱ��
		String id;
		//������������
		String text;
		//�ӽڵ�
		List<CodeTypeTreeDto> children;
		//��������
		Map<String,String> attribute;
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
		public List<CodeTypeTreeDto> getChildren() {
			return children;
		}
		public void setChildren(List<CodeTypeTreeDto> children) {
			this.children = children;
		}
		public Map<String, String> getAttribute() {
			return attribute;
		}
		public void setAttribute(Map<String, String> attribute) {
			this.attribute = attribute;
		}
		
}
