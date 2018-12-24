/**
 * @Title: EventImageRepository.java
 * @Package cy.its.trafficSituation.repository
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����8:58:22
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.trafficSituation.domain.model.TrafficEventImage;
import cy.its.trafficSituation.domain.repository.IEventImageRepository;
import cy.its.trafficSituation.mybatis.client.TrafficEventImageMapper;

@Service
public class EventImageRepository implements IEventImageRepository {
	@Autowired
	TrafficEventImageMapper trafficEventImageMapper;
	/*
	  * <p>Title: aggregateOfId</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @throws Exception
	  * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	  */

	@Override
	public TrafficEventImage aggregateOfId(String id) throws Exception {
		return trafficEventImageMapper.selectByPrimaryKey(id);
	}
	

	/*
	  * <p>Title: aggregateOfId</p>
	  * <p>Description:�����¼�Ԥ��ID��ѯӰ�� </p>
	  * @param id
	  * @return
	  * @throws Exception
	  * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	  */

	@Override
	public TrafficEventImage selectEventImageByAlarmId(String id){
		return trafficEventImageMapper.selectByAlarmId(id);
	}

	/*
	  * <p>Title: save</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#save(java.lang.Object)
	  */

	@Override
	public String save(TrafficEventImage obj) {
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
	public int update(TrafficEventImage obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
