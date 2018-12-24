package cy.its.video.domain.repository;

import java.util.List;
import java.util.Map;

import cy.its.com.domain.IRepository;
import cy.its.video.domain.model.TrafficPlan;

public interface ITrafficPlanRepository extends IRepository<TrafficPlan> {

	/**
	 * ��ȡ����Ѳ�������б�
	 * 
	 * @return
	 */
	List<TrafficPlan> getTrafficPlanByCondition(Map<String, String> map);

}
