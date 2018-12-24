/**
 * @Title: IEventImageRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: ��ͨ�¼�Ӱ������ͼ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����8:54:46
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.repository;

import cy.its.com.domain.IRepository;
import cy.its.trafficSituation.domain.model.TrafficEventImage;

public interface IEventImageRepository extends IRepository<TrafficEventImage>{
	/**
	  * @Title: selectEventImageByAlarmId
	  * @Description: �����¼�Ԥ��ID��ѯӰ��
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficEventImage    ��������
	  * @throws
	 */
	TrafficEventImage selectEventImageByAlarmId(String id);	
}
