/**
 * @Title: IManualStateAction.java
 * @Package cy.its.trafficSituation.rest.action
 * @Description: �˹���Ԥ��·ͨ��״̬rest �ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��18�� ����5:10:29
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.action;

import java.text.ParseException;

import cy.its.trafficSituation.rest.dto.ManualStateDto;

public interface IManualStateAction {
	/**
	 * @throws ParseException 
	 * 
	  * @Title: update
	  * @Description: �����˹���Ԥ
	  * @param @param dto
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int update(ManualStateDto dto) throws ParseException;
	/**
	 * 
	  * @Title: selectByRoadId
	  * @Description: ����roadId�����˹���Ԥ
	  * @param @param roadId ��·ID
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	ManualStateDto selectByRoadId(String roadId);
	
}
