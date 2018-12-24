/**
 * @Title: IViolationCodeAction.java
 * @Package cy.its.violation.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��13�� ����4:40:24
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.action;

import java.text.ParseException;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;

import cy.its.violation.rest.dto.ViolationCodeDto;

/**
 * @ClassName: IViolationCodeAction
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��13�� ����4:40:24
 *
 */

public interface IViolationCodeAction {
	// ��ѯ
	Map findViolationCode(ViolationCodeDto vioationCodeDto) throws Exception;

	// ���
	String createVioationCode(ViolationCodeDto vioActionDto) throws ParseException, Exception;

	// ����
	public String updateVioationCode(ViolationCodeDto vioationCodeDto) throws ParseException, Exception;

	// ����ɾ��
	public String deleteVioationCode(String vioActionCodeStr , String vioActionMatchIdStr);

	// ����ɾ��
	public String removeVioationCode(String vioationCode , String vioActionMatchId);
}
