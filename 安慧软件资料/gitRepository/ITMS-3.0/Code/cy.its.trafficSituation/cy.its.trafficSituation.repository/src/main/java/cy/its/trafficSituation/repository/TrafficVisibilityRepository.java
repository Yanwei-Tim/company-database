/**
 * @Title: TrafficVisibilityRepository.java
 * @Package cy.its.trafficSituation.repository
 * @Description: �ܼ����ǻ�����ʩ��ʵ����
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����7:44:40
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

import cy.its.trafficSituation.domain.model.TrafficVisibility;
import cy.its.trafficSituation.domain.repository.ITrafficVisibilityRepository;
import cy.its.trafficSituation.mybatis.client.TrafficVisibilityMapper;

@Service 
public class TrafficVisibilityRepository implements ITrafficVisibilityRepository {
	@Autowired
	TrafficVisibilityMapper trafficVisibilityMapper;
	/*
	  * <p>Title: aggregateOfId</p>
	  * <p>Description:��ѯ </p>
	  * @param id
	  * @return
	  * @throws Exception
	  * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	  */

	@Override
	public TrafficVisibility aggregateOfId(String id) throws Exception {
		return trafficVisibilityMapper.selectByPrimaryKey(id);
	}
	/*
	  * <p>Title: selectVisibilitys</p>
	  * <p>Description: ��������ѯ�б�</p>
	  * @param map
	  * @return
	  * @see cy.its.trafficSituation.domain.repository.ITrafficVisibilityRepository#selectVisibilitys(java.util.Map)
	  */
	@Override
	public List<TrafficVisibility> selectVisibilitys(Map<String, Object> map) {
		return trafficVisibilityMapper.selectVisibilitys(map);
	}
	@Override
	public List<TrafficVisibility> select2HourVisibilitys(Map<String, Object> map) {
		return trafficVisibilityMapper.select2HourVisibilitys(map);
	}
	
	/*
	  * <p>Title: save</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#save(java.lang.Object)
	  */
	@Override
	public String save(TrafficVisibility obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	  * <p>Title: delete</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see cy.its.com.domain.IRepository#delete(java.lang.String)
	  */

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	  * <p>Title: update</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#update(java.lang.Object)
	  */

	@Override
	public int update(TrafficVisibility obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
