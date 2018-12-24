/**
 * @Title: IManualWeatherAction.java
 * @Package cy.its.trafficSituation.rest.action
 * @Description: �˹���¼��������rest�ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��10�� ����3:40:38
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.action;

import java.text.ParseException;
import java.util.List;

import cy.its.trafficSituation.rest.dto.ManualWeatherDto;

public interface IManualWeatherAction {
	/**
	 * @throws Exception 
	 * 
	  * @Title: add
	  * @Description: ��
	  * @param @param dto
	  * @param @return    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	String add(ManualWeatherDto dto) throws Exception;
	/**
	 * 
	  * @Title: delete
	  * @Description: ɾ
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int delete(String id);
	/**
	 * 
	  * @Title: deleteMultiple
	  * @Description: ɾ��
	  * @param @param ids
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int deleteMultiple(String ids);
	/**
	 * @throws Exception 
	 * 
	  * @Title: update
	  * @Description: ��
	  * @param @param dto
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int update(ManualWeatherDto dto) throws Exception;
	/**
	 * @throws Exception 
	 * @throws ParseException 
	 * 
	  * @Title: selectAll
	  * @Description: ��
	  * @param @param manualWeatherDto
	  * @param @return    �趨�ļ�
	  * @return Object    ��������
	  * @throws
	 */
	Object selectAll(ManualWeatherDto manualWeatherDto) throws ParseException, Exception;
}
