/**
 * @Title: TrafficManualReportService.java
 * @Package cy.its.trafficSituation.domain.service.impl
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����4:02:22
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.trafficSituation.domain.model.TrafficManualReport;
import cy.its.trafficSituation.domain.repository.ITrafficManualReportRepository;
import cy.its.trafficSituation.domain.service.ITrafficManualReportService;

/**
  * @ClassName: TrafficManualReportService
  * @Description: �˹��ϱ���ͨ�¼�����ʵ�ֲ�
  * @author gyf guanyf@cychina.cn
  * @date 2015��10��28�� ����4:02:22
  *
  */

@Service
public class TrafficManualReportService implements ITrafficManualReportService {
	@Autowired
	ITrafficManualReportRepository trafficManualReportRepository;

	/*
	  * <p>Title: selectById</p>
	  * <p>Description:��ѯ </p>
	  * @param id
	  * @return
	  * @see cy.its.trafficSituation.domain.service.ITrafficManualReportService#selectById(java.lang.String)
	  */

	@Override
	public TrafficManualReport selectById(String id) throws Exception {
		return trafficManualReportRepository.aggregateOfId(id);
	}

	/*
	  * <p>Title: save</p>
	  * <p>Description:���� </p>
	  * @param trafficManualReport
	  * @return
	  * @see cy.its.trafficSituation.domain.service.ITrafficManualReportService#save(cy.its.trafficSituation.domain.model.TrafficManualReport)
	  */

	@Override
	public String save(TrafficManualReport trafficManualReport) {
		return trafficManualReportRepository.save(trafficManualReport);
	}

	/*
	  * <p>Title: delete</p>
	  * <p>Description:ɾ�� </p>
	  * @param id
	  * @return
	  * @see cy.its.trafficSituation.domain.service.ITrafficManualReportService#delete(java.lang.String)
	  */

	@Override
	public int delete(String id) {
		return trafficManualReportRepository.delete(id);
	}

	/*
	  * <p>Title: update</p>
	  * <p>Description: �޸�</p>
	  * @param trafficManualReport
	  * @return
	  * @see cy.its.trafficSituation.domain.service.ITrafficManualReportService#update(cy.its.trafficSituation.domain.model.TrafficManualReport)
	  */

	@Override
	public int update(TrafficManualReport trafficManualReport) {
		return trafficManualReportRepository.update(trafficManualReport);
	}

}
