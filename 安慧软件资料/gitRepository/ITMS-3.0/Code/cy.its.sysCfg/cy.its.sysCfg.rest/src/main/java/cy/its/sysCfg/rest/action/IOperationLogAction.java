/**
 * @Title: IOperationLog.java
 * @Package cy.its.sysCfg.rest.aciton
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��12��3�� ����9:11:04
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.sysCfg.rest.action;

import java.util.Map;

import cy.its.sysCfg.rest.dto.OperationLogDto;

/**
  * @ClassName: IOperationLog
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��12��3�� ����9:11:04
  *
  */

public interface IOperationLogAction {
	//��ѯ������־
	public Map<String,Object> goFindByOperationLog(OperationLogDto operationLogDto) throws Exception;
}
