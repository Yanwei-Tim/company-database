package cy.its.vehTrack.domain.service;

public interface ISparkService {
	
	/**
	 * ����serviceNameȥ���ô�����spark���񲢷���jobid
	 * @param query
	 * @param serviceName
	 * @return
	 * @throws Exception
	 */
	public String  getSparkJobId(String query,String serviceName) throws Exception;

}
