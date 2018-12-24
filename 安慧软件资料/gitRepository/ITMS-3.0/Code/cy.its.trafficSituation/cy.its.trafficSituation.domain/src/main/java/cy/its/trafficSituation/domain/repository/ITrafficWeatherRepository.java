/**
 * @Title: ITrafficWeatherRepository.java
 * @Package cy.its.trafficSituation.domain.repository
 * @Description: �����ǻ�����ʩ��ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��28�� ����7:51:10
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
import cy.its.trafficSituation.domain.model.TrafficWeather;

public interface ITrafficWeatherRepository extends IRepository<TrafficWeather> {
	List<TrafficWeather> selectWeathers(Map<String,Object> map);
	TrafficWeather getLastWeatherByNBR(String deviceNbr);
	List<TrafficWeather> select2HourWeathers(Map<String, Object> map);
}
