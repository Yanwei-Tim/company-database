/**
 * @Title: IMapRoadAction.java
 * @Package cy.its.trafficSituation.rest.action
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��13�� ����9:46:02
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.action;

import java.util.List;

import cy.its.trafficSituation.rest.dto.MapRoadDto;

public interface IMapRoadAction {
	List<MapRoadDto> selectAll() throws Exception;
	MapRoadDto selectById(String cyid);
}
