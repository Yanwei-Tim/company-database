package cy.its.trafficSituation.domain.service;

import java.util.List;
import java.util.Map;

public interface ITrafficAllEventService {

	/*
	 * ����
	 */
	public List queryWeatherEvent(Map map);
	
	/*
	 * �ܼ���
	 */
	public List queryVisibilityEvent(Map map);

	/*
	 *·��
	 */
	public List queryRoadSensorEvent(Map map);

	/*
	 * �¼����
	 */
	public List queryTrafficEvent(Map map);
	
}
