package cy.its.vehTrack.domain.repository;


public interface IVioSpaceTimeRepository {
	
	
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
