/**
 * @Title: IManualWeatherService.java
 * @Package cy.its.trafficSituation.domain.service
 * @Description: �������������ӿ�
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��10�� ����3:19:12
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.trafficSituation.domain.model.TrafficManualWeather;

public interface IManualWeatherService {
	/**
	 * @throws Exception 
	 * 
	  * @Title: selectById
	  * @Description: ��ѯ
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return TrafficManualWeather    ��������
	  * @throws
	 */
	TrafficManualWeather selectById(String id) throws Exception;
	/**
	 * 
	  * @Title: save
	  * @Description: ����
	  * @param @param manualWeather
	  * @param @return    �趨�ļ�
	  * @return String    ��������
	  * @throws
	 */
	String save(TrafficManualWeather manualWeather);
	/**
	 * 
	  * @Title: delete
	  * @Description: ɾ��
	  * @param @param id
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int delete(String id);
	/**
	 * 
	  * @Title: update
	  * @Description: �޸�
	  * @param @param manualWeather
	  * @param @return    �趨�ļ�
	  * @return int    ��������
	  * @throws
	 */
	int update(TrafficManualWeather manualWeather);
	/**
	 * 
	  * @Title: selectAll
	  * @Description: ��ѯ
	  * @param @return    �趨�ļ�
	  * @return List<TrafficManualWeather>    ��������
	  * @throws
	 */
	List<TrafficManualWeather> selectAll(Map<String, Object> map);
}
