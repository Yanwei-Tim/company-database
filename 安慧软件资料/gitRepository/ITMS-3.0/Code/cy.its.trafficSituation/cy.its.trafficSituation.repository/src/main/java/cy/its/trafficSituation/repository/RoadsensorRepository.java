/**
 * @Title: RoadsensorRepository.java
 * @Package cy.its.trafficSituation.repository
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����5:18:19
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
import cy.its.trafficSituation.domain.model.TrafficRoadsensor;
import cy.its.trafficSituation.domain.repository.IRoadsensorRepository;
import cy.its.trafficSituation.mybatis.client.TrafficRoadsensorMapper;

@Service
public class RoadsensorRepository implements IRoadsensorRepository {
	
	@Autowired
	TrafficRoadsensorMapper roadsensorMapper;
	/*
	  * <p>Title: aggregateOfId</p>
	  * <p>Description:��ѯ </p>
	  * @param id
	  * @return
	  * @throws Exception
	  * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	  */

	@Override
	public TrafficRoadsensor aggregateOfId(String id) throws Exception {
		return roadsensorMapper.selectByPrimaryKey(id);
	}

	/*
	  * <p>Title: save</p>
	  * <p>Description:���� </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#save(java.lang.Object)
	  */

	@Override
	public String save(TrafficRoadsensor obj) {
		obj.setRoadsensorDataId(StringUtil.generateUUID());
		roadsensorMapper.insertSelective(obj);		
		return obj.getRoadsensorDataId();
	}

	/*
	  * <p>Title: delete</p>
	  * <p>Description:ɾ�� </p>
	  * @param id
	  * @return
	  * @see cy.its.com.domain.IRepository#delete(java.lang.String)
	  */

	@Override
	public int delete(String id) {
		return roadsensorMapper.deleteByPrimaryKey(id);
	}

	/*
	  * <p>Title: update</p>
	  * <p>Description:�޸� </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#update(java.lang.Object)
	  */

	@Override
	public int update(TrafficRoadsensor obj) {
		return roadsensorMapper.updateByPrimaryKey(obj);
	}

	/*
	  * <p>Title: selectRoadsensors</p>
	  * <p>Description:��ѯ�б� </p>
	  * @param map
	  * @return
	  * @see cy.its.trafficSituation.domain.repository.IRoadsensorRepository#selectRoadsensors(java.util.Map)
	  */
	
	
	@Override
	public List<TrafficRoadsensor> selectRoadsensors(Map<String, Object> map) {
		return roadsensorMapper.selectRoadsensors(map);
	}
	@Override
	public List<TrafficRoadsensor> select2HourRoadsensors(Map<String, Object> map) {
		return roadsensorMapper.select2HourRoadsensors(map);
	}

}
