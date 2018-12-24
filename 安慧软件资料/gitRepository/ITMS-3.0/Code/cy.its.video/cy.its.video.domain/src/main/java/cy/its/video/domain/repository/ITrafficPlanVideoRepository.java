package cy.its.video.domain.repository;

import java.util.List;

import cy.its.com.domain.IRepository;
import cy.its.video.domain.model.TrafficPlanVideo;

public interface ITrafficPlanVideoRepository extends IRepository<TrafficPlanVideo> {

	/**
	 * ��ȡѲ��������������Ƶ�б�
	 * 
	 * @param videoPlanID
	 * @return
	 */
	List<TrafficPlanVideo> getTrafficPlanVideo(String videoPlanID);

}
