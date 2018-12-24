/**
 * @Title: ITrafficMultipleAction.java
 * @Package cy.its.trafficSituation.rest.action
 * @Description: �ۺ�rest�ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��29�� ����4:00:19
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.action;

import java.text.ParseException;
import java.util.List;

import cy.its.trafficSituation.rest.dto.RegionFlowDto;
import cy.its.trafficSituation.rest.dto.RoadStateDto;
import cy.its.trafficSituation.rest.dto.RoadsensorDto;
import cy.its.trafficSituation.rest.dto.SectionFlowDto;
import cy.its.trafficSituation.rest.dto.SiteSectonFlowDto;
import cy.its.trafficSituation.rest.dto.VisibilityDto;
import cy.its.trafficSituation.rest.dto.WeatherDto;

public interface ITrafficMultipleAction {
	/**
	 * @throws Exception @throws ParseException @Title:
	 * selectRegionFlows @Description: ����������ѯ���������б� @param @param
	 * map @param @return �趨�ļ� @return List<RegionFlowDto> �������� @throws
	 */
	Object selectRegionFlows(RegionFlowDto regionFlowDto) throws ParseException, Exception;

	/**
	 * @throws Exception @throws ParseException @Title:
	 * selectSectionFlows @Description: ����������ѯ���������б� @param @param
	 * map @param @return �趨�ļ� @return List<RegionFlowDto> �������� @throws
	 */
	Object selectSectionFlows(SectionFlowDto sectionFlowDto) throws ParseException, Exception;

	/**
	 * 
	 * @Title: selectWeathers @Description: ��������ѯ���������б� @param @param
	 * weatherDto @param @return @param @throws Exception �趨�ļ� @return Object
	 * �������� @throws
	 */
	Object selectWeathers(WeatherDto weatherDto) throws Exception;

	/**
	 * 
	 * @Title: selectVisibilitys @Description: ��������ѯ�ܼ����б� @param @param
	 * visibilityDto @param @return @param @throws Exception �趨�ļ� @return Object
	 * �������� @throws
	 */
	Object selectVisibilitys(VisibilityDto visibilityDto) throws Exception;

	/**
	 * 
	 * @Title: selectRoadsensors @Description: ��������ѯ·�������б� @param @param
	 * roadsensorDto @param @return @param @throws Exception �趨�ļ� @return Object
	 * �������� @throws
	 */
	Object selectRoadsensors(RoadsensorDto roadsensorDto) throws Exception;

	/**
	 * 
	 * @Title: selectRoadStates @Description: ��ѯ��ʷ·������ @param @param
	 * roadStateDto @param @return @param @throws Exception �趨�ļ� @return Object
	 * �������� @throws
	 */
	Object selectRoadStates(RoadStateDto roadStateDto) throws Exception;

	/**
	 * 
	 * @Title: selectSiteSections @Description:
	 * ��ѯ���һ����ʷ������������ @param @return @param @throws Exception �趨�ļ� @return
	 * List<SiteSectonFlowDto> �������� @throws
	 */
	List<SiteSectonFlowDto> selectSiteSections(String currentOrgPrivilegeCode) throws Exception;

}
