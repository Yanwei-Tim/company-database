/**
 * @Title: TrafficManualReportRepository.java
 * @Package cy.its.trafficSituation.repository
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����3:31:43
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

import cy.its.com.util.StringUtil;
import cy.its.trafficSituation.domain.model.TrafficManualReport;
import cy.its.trafficSituation.domain.repository.ITrafficManualReportRepository;
import cy.its.trafficSituation.mybatis.client.TrafficManualReportMapper;

/**
  * @ClassName: TrafficManualReportRepository
  * @Description: �˹��ϱ���ͨ�¼�������ʩ��ʵ����
  * @author gyf guanyf@cychina.cn
  * @date 2015��10��28�� ����3:31:43
  *
  */
@Service
public class TrafficManualReportRepository implements ITrafficManualReportRepository {
	
	@Autowired
	TrafficManualReportMapper trafficManualReportMapper;
	/*
	  * <p>Title: aggregateOfId</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @throws Exception
	  * @see cy.its.com.domain.IRepository#aggregateOfId(java.lang.String)
	  */

	@Override
	public TrafficManualReport aggregateOfId(String id) throws Exception {
		return trafficManualReportMapper.selectByPrimaryKey(id);
	}

	/*
	  * <p>Title: save</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#save(java.lang.Object)
	  */

	@Override
	public String save(TrafficManualReport obj) {
		obj.setManualReportTraId(StringUtil.generateUUID());
		trafficManualReportMapper.insertSelective(obj);
		return obj.getManualReportTraId();
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
		return trafficManualReportMapper.deleteByPrimaryKey(id);
	}

	/*
	  * <p>Title: update</p>
	  * <p>Description: </p>
	  * @param obj
	  * @return
	  * @see cy.its.com.domain.IRepository#update(java.lang.Object)
	  */

	@Override
	public int update(TrafficManualReport obj) {
		return trafficManualReportMapper.updateByPrimaryKey(obj);
	}

}
