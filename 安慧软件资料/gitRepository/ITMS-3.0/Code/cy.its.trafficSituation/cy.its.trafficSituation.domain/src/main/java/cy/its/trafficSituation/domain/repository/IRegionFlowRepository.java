/**
 * @Title: IRegionFlow.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: ��������repository�ӿ���
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����4:26:16
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

import org.apache.ibatis.annotations.Param;

import cy.its.com.domain.IRepository;
import cy.its.trafficSituation.domain.model.TrafficRegionFlow;


public interface IRegionFlowRepository extends IRepository<TrafficRegionFlow> {
	/**
	  * @Title: selectRegionFlows
	  * @Description: ���������������������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficRegionFlow>    ��������
	  * @throws
	 */
	List<TrafficRegionFlow> selectRegionFlows(Map<String,Object> map); 
	
	List<TrafficRegionFlow> selectByRegionId(String regionalId);
	
	TrafficRegionFlow selectLastFlowByRegionId(String regionalId);

	List<TrafficRegionFlow> select2HourRegionFlow(Map<String, Object> map);
}
