package cy.its.vehTrack.domain.service;

import java.util.Map;
public interface ICloneCarService {

	
	/**
	 * ���Ƴ�������ѯ
	 * @param query
	 * @return Map
	 */
	public  Map<String, Object> findCloneCarInfo(String query,String queryDB) throws Exception;
	
	/**
	 * ���Ƴ�״̬����
	 * @param clone_vehicle_id
	 * @param clone_flag
	 */
	public void updateConfirmFlag(String clone_vehicle_id,String clone_flag,String confirm_desc) throws Exception;

}
