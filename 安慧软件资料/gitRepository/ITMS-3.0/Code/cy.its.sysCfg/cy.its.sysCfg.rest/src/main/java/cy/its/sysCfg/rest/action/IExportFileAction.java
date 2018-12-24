/**
 * @Title: IExportFileAction.java
 * @Package cy.its.sysCfg.rest.aciton
 * @Description: �������� 
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��27�� ����9:28:08
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.action;


import java.text.ParseException;

import cy.its.sysCfg.rest.dto.ExportDto;

public interface IExportFileAction {
	Object selectAll(ExportDto exportDto) throws ParseException;
	int delete(String id);
}
