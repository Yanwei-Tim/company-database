package cy.its.vehTrack.domain.service;

import java.util.Map;

public interface IVioSpaceTimeService {
	/**
	 * Υ���ֲ�����
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public  String getVioDistribution(String query) throws Exception;
	
	/**
	 * Υ�����Ʒ���
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public  String getVioTrendStat(String query) throws Exception;

}
