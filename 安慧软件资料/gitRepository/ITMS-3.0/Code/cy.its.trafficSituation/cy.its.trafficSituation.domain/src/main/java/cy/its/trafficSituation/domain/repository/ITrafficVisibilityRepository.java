/**
 * @Title: ITrafficVisibilityRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: �ܼ����ǻ�����ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����7:40:52
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
import cy.its.trafficSituation.domain.model.TrafficVisibility;

public interface ITrafficVisibilityRepository extends IRepository<TrafficVisibility> {
	List<TrafficVisibility> selectVisibilitys(Map<String, Object> map);

	List<TrafficVisibility> select2HourVisibilitys(Map<String, Object> map);
}
