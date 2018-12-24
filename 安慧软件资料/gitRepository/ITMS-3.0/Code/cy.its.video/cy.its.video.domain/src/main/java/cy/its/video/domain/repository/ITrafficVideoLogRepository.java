package cy.its.video.domain.repository;

import java.util.List;

import cy.its.com.domain.IRepository;
import cy.its.video.domain.model.TrafficVideoLog;

public interface ITrafficVideoLogRepository extends IRepository<TrafficVideoLog> {

	/**
	 * ����Ѳ����־id��ȡ��ص��¼���¼
	 * 
	 * @param videoPlanLogId
	 * @return
	 */
	List<TrafficVideoLog> getVideoCruiseEvent(String videoPlanLogId);

}
