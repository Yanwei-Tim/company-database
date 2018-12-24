/**
 * @Title: IManualEventService.java
 * @Package cy.its.trafficSituation.domain.service
 * @Description: �˹���¼�¼������ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��10�� ����3:11:38
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.trafficSituation.domain.model.TrafficManualEvent;

public interface IManualEventService {
	/**
	 * @throws Exception 
	 * 
	  * @Title: selectById
	  * @Description: ��ѯ
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficManualEvent    ��������
	  * @throws
	 */
	TrafficManualEvent selectById(String id) throws Exception;
	/**
	 * 
	  * @Title: save
	  * @Description: ����
	  * @param @param manualEvent
	  * @param @return    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	String save(TrafficManualEvent manualEvent);
	/**
	 * 
	  * @Title: delete
	  * @Description: ɾ��
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int delete(String id);
	/**
	 * 
	  * @Title: update
	  * @Description: �޸�
	  * @param @param manualEvent
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int update(TrafficManualEvent manualEvent);
	/**
	 * 
	  * @Title: selectAll
	  * @Description: ��ѯ
	  * @param @return    �趨�ļ�
	  * @return List<TrafficManualEvent>    ��������
	  * @throws
	 */
	List<TrafficManualEvent> selectAll(Map<String, Object> map);
}
