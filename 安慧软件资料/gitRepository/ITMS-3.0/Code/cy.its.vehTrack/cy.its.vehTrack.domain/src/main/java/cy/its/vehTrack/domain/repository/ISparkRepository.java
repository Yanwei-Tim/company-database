package cy.its.vehTrack.domain.repository;

public interface ISparkRepository {
	
	/**
	 * ����serviceNameȥ���ô�����spark���񲢷���jobid
	 * @param query
	 * @param serviceName
	 * @return
	 * @throws Exception
	 */
	public String  getSparkJobId(String query,String serviceName) throws Exception;

}
