/**
 * @Title: IManualEventRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: �˹��Ǽ��¼�������ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��10�� ����2:47:03
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.repository;

import java.util.List;
import java.util.Map;

import cy.its.com.domain.IRepository;
import cy.its.trafficSituation.domain.model.TrafficManualEvent;

public interface IManualEventRepository extends IRepository<TrafficManualEvent> {
	/**
	 * 
	  * @Title: selectAll
	  * @Description: �����������˹��Ǽ��¼��б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficManualEvent>    ��������
	  * @throws
	 */
	List<TrafficManualEvent> selectAll(Map<String, Object> map);
}
