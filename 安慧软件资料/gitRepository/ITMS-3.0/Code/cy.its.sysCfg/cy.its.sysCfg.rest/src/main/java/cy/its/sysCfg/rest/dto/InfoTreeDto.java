/**
 * @Title: InfoTreeDto.java
 * @Package cy.its.sysCfg.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��30�� ����3:24:46
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.dto;

import java.util.List;
import java.util.Map;


public class InfoTreeDto {
	/**
	 * ����
	 */
	String id;
	
	/**
	 * �ı�
	 */
	String text;
	
	/**
	 * ����
	 */
	Object attribute;
	
	/**
	 * �ӽڵ�
	 */
	List<InfoTreeDto> children;

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

	public List<InfoTreeDto> getChildren() {
		return children;
	}

	public void setChildren(List<InfoTreeDto> children) {
		this.children = children;
	}

	public Object getAttribute() {
		return attribute;
	}

	public void setAttribute(Object attribute) {
		this.attribute = attribute;
	}
}
