/**
 * @Title: IMapRoadService.java
 * @Package cy.its.trafficSituation.domain.service
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��13�� ����9:19:38
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

import cy.its.trafficSituation.domain.model.MapRoad;

public interface IMapRoadService {
	List<MapRoad> selectAll(Map map);
	MapRoad selectById(String cyid);
	List<MapRoad> selectByRegionalId(String regionalId);
	int selectRoadCount(Map map);
}
