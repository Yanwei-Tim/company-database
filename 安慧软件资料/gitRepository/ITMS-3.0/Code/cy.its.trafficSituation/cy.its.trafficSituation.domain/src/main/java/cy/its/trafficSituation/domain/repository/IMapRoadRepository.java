/**
 * @Title: IRoadSectionRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��13�� ����9:10:18
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

import cy.its.trafficSituation.domain.model.MapRoad;

public interface IMapRoadRepository {
	List<MapRoad> selectAllRoad(Map map);
	MapRoad selectByPrimaryKey(String cyid);
	List<MapRoad> selectByRegionalId(String regionalId);
	int selectRoadCount(Map map);
}
