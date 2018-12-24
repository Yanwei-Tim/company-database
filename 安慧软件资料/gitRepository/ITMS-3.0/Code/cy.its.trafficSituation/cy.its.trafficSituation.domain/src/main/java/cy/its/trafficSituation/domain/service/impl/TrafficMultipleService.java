/**
 * @Title: TrafficMultipleService.java
 * @Package cy.its.trafficSituation.domain.service.impl
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��29�� ����2:21:48
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.trafficSituation.domain.model.TrafficEventImage;
import cy.its.trafficSituation.domain.model.TrafficRegionFlow;
import cy.its.trafficSituation.domain.model.TrafficRoadsensor;
import cy.its.trafficSituation.domain.model.TrafficSectionFlow;
import cy.its.trafficSituation.domain.model.TrafficState;
import cy.its.trafficSituation.domain.model.TrafficVisibility;
import cy.its.trafficSituation.domain.model.TrafficWeather;
import cy.its.trafficSituation.domain.repository.IEventImageRepository;
import cy.its.trafficSituation.domain.repository.IRegionFlowRepository;
import cy.its.trafficSituation.domain.repository.IRoadsensorRepository;
import cy.its.trafficSituation.domain.repository.ISectionFlowRepository;
import cy.its.trafficSituation.domain.repository.ITrafficStateRepository;
import cy.its.trafficSituation.domain.repository.ITrafficVisibilityRepository;
import cy.its.trafficSituation.domain.repository.ITrafficWeatherRepository;
import cy.its.trafficSituation.domain.service.ITrafficMultipleService;

@Service
public class TrafficMultipleService implements ITrafficMultipleService {
	@Autowired
	ITrafficStateRepository trafficStateRepository;
	@Autowired
	IRegionFlowRepository regionFlowRepository;
	@Autowired
	ISectionFlowRepository sectionFlowRepository;
	@Autowired
	ITrafficWeatherRepository weatherRepository;
	@Autowired
	ITrafficVisibilityRepository visibilityRepository;
	@Autowired
	IRoadsensorRepository roadsensorRepository;
	@Autowired
	IEventImageRepository eventImageRepository;
	/*
	 * <p>Title: selectStateById</p> <p>Description:����ID��ѯ��ͨ״̬ </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectStateById(java.lang.String)
	 */

	@Override
	public TrafficState selectStateById(String id) throws Exception {
		return trafficStateRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectStates</p> <p>Description:����������ѯ��ͨ״̬ </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectStates(java.util.Map)
	 */

	@Override
	public List<TrafficState> selectStates(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * <p>Title: selectSectionFlowById</p> <p>Description:����ID��ѯ�������� </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectSectionFlowById(java.lang.String)
	 */

	@Override
	public TrafficSectionFlow selectSectionFlowById(String id) throws Exception {
		return sectionFlowRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectSectionFlows</p> <p>Description:���������Ҷ��������б� </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectSectionFlows(java.util.Map)
	 */

	@Override
	public List<TrafficSectionFlow> selectSectionFlows(Map<String, Object> map) {
		return sectionFlowRepository.selectSctionFlows(map);
	}

	@Override
	public List<TrafficSectionFlow> select2HourSectionFlow(Map<String, Object> map) {
		return sectionFlowRepository.select2HourSectionFlow(map);
	}

	/*
	 * <p>Title: selectRegionFlowById</p> <p>Description:����ID��ѯ�������� </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectRegionFlowById(java.lang.String)
	 */

	@Override
	public TrafficRegionFlow selectRegionFlowById(String id) throws Exception {
		return regionFlowRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectRegionFlows</p> <p>Description:����������ѯ���������б� </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectRegionFlows(java.util.Map)
	 */

	@Override
	public List<TrafficRegionFlow> selectRegionFlows(Map<String, Object> map) {
		return regionFlowRepository.selectRegionFlows(map);
	}

	@Override
	public List<TrafficRegionFlow> select2HourRegionFlow(Map<String, Object> map) {
		return regionFlowRepository.select2HourRegionFlow(map);
	}

	/*
	 * <p>Title: selectWeatherById</p> <p>Description:����ID��ѯ���������� </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectWeatherById(java.lang.String)
	 */

	@Override
	public TrafficWeather selectWeatherById(String id) throws Exception {
		return weatherRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectWeathers</p> <p>Description:����������ѯ���������� </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectWeathers(java.util.Map)
	 */

	@Override
	public List<TrafficWeather> selectWeathers(Map<String, Object> map) {
		return weatherRepository.selectWeathers(map);
	}

	@Override
	public List<TrafficWeather> select2HourWeathers(Map<String, Object> map) {
		return weatherRepository.select2HourWeathers(map);
	}
	/*
	 * <p>Title: selectRoadsensorById</p> <p>Description: ����ID��ѯ·������ </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectRoadsensorById(java.lang.String)
	 */

	@Override
	public TrafficRoadsensor selectRoadsensorById(String id) throws Exception {
		return roadsensorRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectRoadsensors</p> <p>Description: </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectRoadsensors(java.util.Map)
	 */

	@Override
	public List<TrafficRoadsensor> selectRoadsensors(Map<String, Object> map) {
		return roadsensorRepository.selectRoadsensors(map);
	}

	@Override
	public List<TrafficRoadsensor> select2HourRoadsensors(Map<String, Object> map) {
		return roadsensorRepository.select2HourRoadsensors(map);
	}
	/*
	 * <p>Title: selectVisibilityById</p> <p>Description: ����ID��ѯ�ܼ�������</p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectVisibilityById(java.lang.String)
	 */

	@Override
	public TrafficVisibility selectVisibilityById(String id) throws Exception {
		return visibilityRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectVisibilitys</p> <p>Description: </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectVisibilitys(java.util.Map)
	 */

	@Override
	public List<TrafficVisibility> selectVisibilitys(Map<String, Object> map) {
		return visibilityRepository.selectVisibilitys(map);
	}

	@Override
	public List<TrafficVisibility> select2HourVisibilitys(Map<String, Object> map) {
		return visibilityRepository.select2HourVisibilitys(map);
	}

	/*
	 * <p>Title: selectEventImageById</p> <p>Description: ����ID�¼�Ӱ�� </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectEventImageById(java.lang.String)
	 */

	@Override
	public TrafficEventImage selectEventImageById(String id) throws Exception {
		return eventImageRepository.aggregateOfId(id);
	}

	/*
	 * <p>Title: selectByRegionId</p> <p>Description: </p>
	 * 
	 * @param regionalId
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectByRegionId(java.lang.String)
	 */

	@Override
	public List<TrafficRegionFlow> selectByRegionId(String regionalId) {
		return regionFlowRepository.selectByRegionId(regionalId);
	}

	/*
	 * <p>Title: selectSectionsBySectionId</p> <p>Description: </p>
	 * 
	 * @param sectionId
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectSectionsBySectionId(java.lang.String)
	 */

	@Override
	public TrafficSectionFlow selectSectionFlowBySectionId(String sectionId) {
		return sectionFlowRepository.selectSectionFlowBySectionId(sectionId);
	}

	/*
	 * <p>Title: selectLastByNBR</p> <p>Description: </p>
	 * 
	 * @param deviceNbr
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectLastByNBR(java.lang.String)
	 */

	@Override
	public TrafficWeather getLastWeatherByNBR(String deviceNbr) {
		return weatherRepository.getLastWeatherByNBR(deviceNbr);
	}

	/*
	 * <p>Title: selectLastFlowByRegionId</p> <p>Description: </p>
	 * 
	 * @param regionalId
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.service.ITrafficMultipleService#
	 * selectLastFlowByRegionId(java.lang.String)
	 */

	@Override
	public TrafficRegionFlow selectLastFlowByRegionId(String regionalId) {
		return regionFlowRepository.selectLastFlowByRegionId(regionalId);
	}

}
