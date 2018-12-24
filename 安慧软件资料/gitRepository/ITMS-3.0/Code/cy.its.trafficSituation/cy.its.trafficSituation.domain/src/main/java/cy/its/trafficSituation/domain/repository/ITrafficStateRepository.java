/**
 * @Title: ITrafficStateRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: ��ͨ״̬������ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����7:06:08
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.repository;

import cy.its.com.domain.IRepository;
import cy.its.trafficSituation.domain.model.TrafficState;

public interface ITrafficStateRepository extends IRepository<TrafficState> {
	
	TrafficState selectByRoadSectionId(String id);
}
