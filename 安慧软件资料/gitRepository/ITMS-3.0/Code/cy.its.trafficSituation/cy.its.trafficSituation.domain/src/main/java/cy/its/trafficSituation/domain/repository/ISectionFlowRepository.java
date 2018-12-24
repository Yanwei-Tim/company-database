/**
 * @Title: ISectionFlowRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: ��������������ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����6:35:59
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
import cy.its.trafficSituation.domain.model.TrafficSectionFlow;

public interface ISectionFlowRepository extends IRepository<TrafficSectionFlow> {
	/**
	  * @Title: selectRegionFlows
	  * @Description: �����������Ҷ��������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficRegionFlow>    ��������
	  * @throws
	 */	
	List<TrafficSectionFlow> selectSctionFlows(Map<String,Object> map); 
	TrafficSectionFlow selectSectionFlowBySectionId(String sectionId);
	List<TrafficSectionFlow> select2HourSectionFlow(Map<String, Object> map);
}
