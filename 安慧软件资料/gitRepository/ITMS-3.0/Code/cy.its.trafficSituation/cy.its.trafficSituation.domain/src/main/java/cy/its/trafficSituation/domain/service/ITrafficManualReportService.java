/**
 * @Title: ITrafficManualReportService.java
 * @Package cy.its.trafficSituation.domain.service
 * @Description: TODO(����Ҫ��д��;)
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����3:43:01
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.service;

import cy.its.trafficSituation.domain.model.TrafficManualReport;

/**
  * @ClassName: ITrafficManualReportService
  * @Description: �˹��ϱ���ͨ�¼������ӿ�
  * @author gyf guanyf@cychina.cn
  * @date 2015��10��28�� ����3:43:01
  *
  */

public interface ITrafficManualReportService {
	/**
	 * @throws Exception 
	 * 
	  * @Title: selectById
	  * @Description: ����ID�����˹��ϱ���ͨ�¼�
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficManualReport    ��������
	  * @throws
	 */
	TrafficManualReport selectById(String id) throws Exception;
	
	/**
	  * @Title: save
	  * @Description: �����˹��ϱ���ͨ�¼�
	  * @param @param trafficManualReport
	  * @param @return    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	String save(TrafficManualReport trafficManualReport);
	/**
	  * @Title: delete
	  * @Description: ����IDɾ��
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int delete(String id);
	/**
	  * @Title: update
	  * @Description: ����
	  * @param @param trafficManualReport
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int update(TrafficManualReport trafficManualReport);
}
