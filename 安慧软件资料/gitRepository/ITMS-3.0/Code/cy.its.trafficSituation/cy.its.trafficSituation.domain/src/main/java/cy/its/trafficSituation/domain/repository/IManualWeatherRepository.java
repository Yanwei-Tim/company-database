/**
 * @Title: IManualWeatherRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: �˹��ǼǶ�������������ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��10�� ����2:45:44
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.repository;

import java.util.List;
import java.util.Map;

import cy.its.com.domain.IRepository;
import cy.its.trafficSituation.domain.model.TrafficManualWeather;

public interface IManualWeatherRepository extends IRepository<TrafficManualWeather> {
	/**
	 * 
	  * @Title: selectAll
	  * @Description: �����������˹���¼���������б�
	  * @param @param map
	  * @param @return    �趨�ļ�
	  * @return List<TrafficManualWeather>    ��������
	  * @throws
	 */
	List<TrafficManualWeather> selectAll(Map<String, Object> map);
}
