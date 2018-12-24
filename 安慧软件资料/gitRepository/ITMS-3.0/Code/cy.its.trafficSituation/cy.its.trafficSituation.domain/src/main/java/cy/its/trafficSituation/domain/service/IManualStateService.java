/**
 * @Title: IManualStateService.java
 * @Package cy.its.trafficSituation.domain.service
 * @Description: �˹���Ԥ��·ͨ��״̬�����ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��18�� ����9:32:16
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.service;

import cy.its.trafficSituation.domain.model.TrafficManualState;

public interface IManualStateService {
	/**
	 * @throws Exception 
	 * 
	  * @Title: selectById
	  * @Description: ��
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficManualState    ��������
	  * @throws
	 */
	TrafficManualState selectById(String id) throws Exception;
	/**
	 * 
	  * @Title: save
	  * @Description: ��
	  * @param @param manualState
	  * @param @return    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	String save(TrafficManualState manualState);
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
	  * @Title: update
	  * @Description: ��
	  * @param @param manualState
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int update(TrafficManualState manualState);
	/**
	 * 
	  * @Title: selectByRoadId
	  * @Description: ����roadId��ѯ�˹���Ԥ״̬
	  * @param @param roadId
	  * @param @return    �趨�ļ�
	  * @return TrafficManualState    ��������
	  * @throws
	 */
	TrafficManualState selectByRoadId(String roadId);
}
