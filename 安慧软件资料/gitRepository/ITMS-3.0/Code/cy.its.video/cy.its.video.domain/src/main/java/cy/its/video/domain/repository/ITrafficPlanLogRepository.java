package cy.its.video.domain.repository;

import java.util.List;
import java.util.Map;

import cy.its.com.domain.IRepository;
import cy.its.video.domain.model.TrafficPlanLog;

public interface ITrafficPlanLogRepository extends IRepository<TrafficPlanLog> {

	/**
	 * ����Ѳ��������ȡѲ����־
	 * 
	 * @param videoPlanID
	 * @return
	 */
	List<TrafficPlanLog> getTrafficPlanLog(Map<String, Object> map);

	/**
	 * ����������ȡ����
	 * 
	 * @param map
	 * @return
	 */
	int countTrafficPlanLogTotal(Map<String, Object> map);

}
