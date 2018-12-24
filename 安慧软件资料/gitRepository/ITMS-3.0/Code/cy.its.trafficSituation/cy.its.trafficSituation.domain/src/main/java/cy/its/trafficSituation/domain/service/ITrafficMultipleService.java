/**
 * @Title: ITrafficMultipleService.java
 * @Package cy.its.trafficSituation.domain.service
 * @Description: �ۺ�����ӿ�
 * @author gyf  guanyf@cychina.cn
 * @date 2015��10��28�� ����8:05:23
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

import cy.its.trafficSituation.domain.model.TrafficEventImage;
import cy.its.trafficSituation.domain.model.TrafficRegionFlow;
import cy.its.trafficSituation.domain.model.TrafficRoadsensor;
import cy.its.trafficSituation.domain.model.TrafficSectionFlow;
import cy.its.trafficSituation.domain.model.TrafficState;
import cy.its.trafficSituation.domain.model.TrafficVisibility;
import cy.its.trafficSituation.domain.model.TrafficWeather;

public interface ITrafficMultipleService {
	/**
	 * @throws Exception 
	  * @Title: selectStateById
	  * @Description: ����ID��ѯ��ͨ״̬
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficState    ��������
	  * @throws
	 */
	TrafficState selectStateById(String id) throws Exception;
	/**
	  * @Title: selectStates
	  * @Description: ����������ѯ��ͨ״̬�б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficState>    ��������
	  * @throws
	 */
	List<TrafficState> selectStates(Map<String,Object> map);
	/**
	 * @throws Exception 
	  * @Title: selectSectionFlowById
	  * @Description: ����ID��ѯ��������
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficSectionFlow    ��������
	  * @throws
	 */
	TrafficSectionFlow selectSectionFlowById(String id) throws Exception;
	/**
	  * @Title: selectSectionFlows
	  * @Description: ����������ѯ���������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficSectionFlow>    ��������
	  * @throws
	 */
	List<TrafficSectionFlow> selectSectionFlows(Map<String,Object> map);
	/**
	 * 
	  * @Title: selectSectionsBySectionId
	  * @Description: ����sectionId��ѯ�����������һ��ʱ�������
	  * @param @param sectionId
	  * @param @return    �趨�ļ�
	  * @return List<TrafficSectionFlow>    ��������
	  * @throws
	 */
	TrafficSectionFlow selectSectionFlowBySectionId(String sectionId);
	/**
	 * @throws Exception 
	  * @Title: selectRegionFlowById
	  * @Description: ����ID��ѯ��������
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficRegionFlow    ��������
	  * @throws
	 */
	TrafficRegionFlow selectRegionFlowById(String id) throws Exception;
	/**
	  * @Title: selectRegionFlows
	  * @Description: ����������ѯ���������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficRegionFlow>    ��������
	  * @throws
	 */
	List<TrafficRegionFlow> selectRegionFlows(Map<String,Object> map);
	/**
	 * 
	  * @Title: selectByRegionId
	  * @Description: ��������ID��ѯ���������б�
	  * @param @param regionalId
	  * @param @return    �趨�ļ�
	  * @return List<TrafficRegionFlow>    ��������
	  * @throws
	 */
	List<TrafficRegionFlow> selectByRegionId(String regionalId);
	/**
	 * 
	  * @Title: selectLastFlowByRegionId
	  * @Description: ��������ID��ѯ�����������һ��
	  * @param @param regionalId
	  * @param @return    �趨�ļ�
	  * @return List<TrafficRegionFlow>    ��������
	  * @throws
	 */
	TrafficRegionFlow selectLastFlowByRegionId(String regionalId);
	/**
	 * @throws Exception 
	  * @Title: selectWeatherById
	  * @Description: ����ID��ѯ����������
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficWeather    ��������
	  * @throws
	 */
	TrafficWeather selectWeatherById(String id) throws Exception;
	/**
	 * 
	  * @Title: selectLastByNBR
	  * @Description: ��ȡ���µ���������
	  * @param @param deviceNbr
	  * @param @return    �趨�ļ�
	  * @return TrafficWeather    ��������
	  * @throws
	 */
	TrafficWeather getLastWeatherByNBR(String deviceNbr);
	/**
	  * @Title: selectWeathers
	  * @Description: ����������ѯ�����������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficWeather>    ��������
	  * @throws
	 */	
	List<TrafficWeather> selectWeathers(Map<String,Object> map);
	
	/**
	 * @throws Exception 
	  * @Title: selectRoadsensorById
	  * @Description: ����ID��ѯ·������
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficRoadsensor    ��������
	  * @throws
	 */
	TrafficRoadsensor selectRoadsensorById(String id) throws Exception;
	/**
	  * @Title: selectRoadsensors
	  * @Description: ����������ѯ·�������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficRoadsensor>    ��������
	  * @throws
	 */
	List<TrafficRoadsensor> selectRoadsensors(Map<String,Object> map);
	
	/**
	 * @throws Exception 
	  * @Title: selectVisibilityById
	  * @Description: ����ID��ѯ�ܼ���������
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficVisibility    ��������
	  * @throws
	 */
	TrafficVisibility selectVisibilityById(String id) throws Exception;
	/**
	  * @Title: selectVisibilitys
	  * @Description: ����������ѯ�ܼ����������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficVisibility>    ��������
	  * @throws
	 */
	List<TrafficVisibility> selectVisibilitys(Map<String,Object> map);
	/**
	 * @throws Exception 
	  * @Title: selectEventImageById
	  * @Description: ����ID��ѯ�¼�Ӱ��
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficEventImage    ��������
	  * @throws
	 */
	TrafficEventImage selectEventImageById(String id) throws Exception;
	List<TrafficSectionFlow> select2HourSectionFlow(Map<String, Object> map);
	List<TrafficRegionFlow> select2HourRegionFlow(Map<String, Object> map);
	List<TrafficWeather> select2HourWeathers(Map<String, Object> map);
	List<TrafficVisibility> select2HourVisibilitys(Map<String, Object> map);
	List<TrafficRoadsensor> select2HourRoadsensors(Map<String, Object> map);
	
}
