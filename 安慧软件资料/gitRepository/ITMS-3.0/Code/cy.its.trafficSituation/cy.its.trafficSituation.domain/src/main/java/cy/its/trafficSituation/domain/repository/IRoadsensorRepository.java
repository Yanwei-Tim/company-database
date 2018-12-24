/**
 * @Title: IRoadsensorRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: ·��repository�ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����5:14:28
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
import cy.its.trafficSituation.domain.model.TrafficRoadsensor;

public interface IRoadsensorRepository extends IRepository<TrafficRoadsensor> {
	List<TrafficRoadsensor> selectRoadsensors(Map<String,Object> map);

	List<TrafficRoadsensor> select2HourRoadsensors(Map<String, Object> map);
}
