/**
 * @Title: IManualStateRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: �˹���Ԥ��·ͨ��״̬������ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��18�� ����9:19:45
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.repository;

import cy.its.com.domain.IRepository;
import cy.its.trafficSituation.domain.model.TrafficManualState;

public interface IManualStateRepository extends IRepository<TrafficManualState> {
	TrafficManualState selectByRoadId(String roadId);
}
