/**
 * @Title: IWhiteListAction.java
 * @Package cy.its.violation.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��4�� ����2:56:33
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

import cy.its.violation.rest.dto.WhiteListDto;

/**
 * @ClassName: IWhiteListAction
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��4�� ����2:56:33
 *
 */

public interface IWhiteListAction {
	// ��ѯ
	Map searchWhiteList(WhiteListDto whiteListDto);

	// ��ѯ
	Map searchWhiteVioList(WhiteListDto whiteListDto);

	// ���
	String createWhiteList(WhiteListDto whiteListDto) throws ParseException;

	// ����
	public String goUpdateWhiteList(WhiteListDto whiteListDto) throws ParseException;

	// ����ɾ��
	public String goDeleteWhiteList(String whiteListStrId);

	// ����ɾ��
	public String goRemoveWhiteList(String whiteListId);
}
