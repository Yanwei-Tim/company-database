/**
 * @Title: IInfoTreeAction.java
 * @Package cy.its.sysCfg.rest.aciton.impl
 * @Description: ��ͨ������Ϣ��
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��30�� ����3:29:16
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.action;

import java.util.List;

import cy.its.sysCfg.rest.dto.InfoTreeDto;

public interface IInfoTreeAction {
	/**
	 * ��ȡ����������
	 * @return ����������
	 * @throws Exception
	 */
	List<InfoTreeDto> getInfoTree()throws Exception;
	String createTree();
}
