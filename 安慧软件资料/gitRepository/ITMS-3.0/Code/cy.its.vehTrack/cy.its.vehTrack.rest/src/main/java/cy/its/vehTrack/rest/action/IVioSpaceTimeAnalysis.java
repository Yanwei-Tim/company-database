package cy.its.vehTrack.rest.action;

import java.util.Map;

import cy.its.vehTrack.rest.dto.VioSpaceTimeInputBean;

public interface IVioSpaceTimeAnalysis {
	
	/**
	 * Υ���ֲ�����
	 * @param inputBean
	 * @throws Exception
	 */
	public Map<String, Object> getVioDistribution(VioSpaceTimeInputBean inputBean) throws Exception;

	
	/**
	 * Υ�����Ʒ���
	 * @param inputBean
	 * @throws Exception
	 */
	public  Map<String, Object> getVioTrendStat(VioSpaceTimeInputBean inputBean) throws Exception;

}
