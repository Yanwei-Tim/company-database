/**
 * @Title: RegionFlowRepository.java
 * @Package cy.its.trafficSituation.repository
 * @Description: ��������repositoryʵ����
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����4:38:13
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.com.util.StringUtil;
import cy.its.trafficSituation.domain.model.TrafficRegionFlow;
import cy.its.trafficSituation.domain.repository.IRegionFlowRepository;
import cy.its.trafficSituation.mybatis.client.TrafficRegionFlowMapper;

@Service
public class RegionFlowRepository implements IRegionFlowRepository {
	@Autowired
	TrafficRegionFlowMapper regionFlowMapper;

	/*
	 * <p>Title: aggregateOfId</p> <p>Description:��ѯ </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @throws Exception
	 * 
	 * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	 */
	@Override
	public TrafficRegionFlow aggregateOfId(String id) throws Exception {
		return regionFlowMapper.selectByPrimaryKey(id);
	}

	/*
	 * <p>Title: selectRegionFlows</p> <p>Description:��ѯ�б� </p>
	 * 
	 * @param map
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.repository.IRegionFlowRepository#
	 * selectRegionFlows(java.util.Map)
	 */
	@Override
	public List<TrafficRegionFlow> selectRegionFlows(Map<String, Object> map) {
		return regionFlowMapper.selectAllRegionFlow(map);
	}

	@Override
	public List<TrafficRegionFlow> select2HourRegionFlow(Map<String, Object> map) {
		return regionFlowMapper.select2HourRegionFlow(map);
	}

	/*
	 * <p>Title: save</p> <p>Description:���� </p>
	 * 
	 * @param obj
	 * 
	 * @return
	 * 
	 * @see cy.its.com.domain.IRepository#save(java.lang.Object)
	 */
	@Override
	public String save(TrafficRegionFlow obj) {
		obj.setRegionalId(StringUtil.generateUUID());
		regionFlowMapper.insertSelective(obj);
		return obj.getRegionalId();
	}

	/*
	 * <p>Title: delete</p> <p>Description:ɾ�� </p>
	 * 
	 * @param id
	 * 
	 * @return
	 * 
	 * @see cy.its.com.domain.IRepository#delete(java.lang.String)
	 */

	@Override
	public int delete(String id) {
		return regionFlowMapper.deleteByPrimaryKey(id);
	}

	/*
	 * <p>Title: update</p> <p>Description:�޸� </p>
	 * 
	 * @param obj
	 * 
	 * @return
	 * 
	 * @see cy.its.com.domain.IRepository#update(java.lang.Object)
	 */
	@Override
	public int update(TrafficRegionFlow obj) {
		return regionFlowMapper.updateByPrimaryKey(obj);
	}

	/*
	 * <p>Title: selectByRegionId</p> <p>Description: </p>
	 * 
	 * @param regionalId
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.repository.IRegionFlowRepository#
	 * selectByRegionId(java.lang.String)
	 */

	@Override
	public List<TrafficRegionFlow> selectByRegionId(String regionalId) {
		return regionFlowMapper.selectByRegionId(regionalId);
	}

	/*
	 * <p>Title: selectLastFlowByRegionId</p> <p>Description: </p>
	 * 
	 * @param regionalId
	 * 
	 * @return
	 * 
	 * @see cy.its.trafficSituation.domain.repository.IRegionFlowRepository#
	 * selectLastFlowByRegionId(java.lang.String)
	 */

	@Override
	public TrafficRegionFlow selectLastFlowByRegionId(String regionalId) {
		return regionFlowMapper.selectLastFlowByRegionId(regionalId);
	}

}
