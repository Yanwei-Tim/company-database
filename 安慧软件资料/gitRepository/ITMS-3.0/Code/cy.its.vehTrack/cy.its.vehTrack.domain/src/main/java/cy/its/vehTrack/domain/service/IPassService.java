package cy.its.vehTrack.domain.service;

import java.util.List;

import cy.its.vehTrack.domain.criteria.PassCriteria;
import cy.its.vehTrack.domain.model.PassInfo;

public interface IPassService {
	
	/**
	 * ���ҹ�����Ϣ
	 * @param passCriteria ������ѯ������װ��
	 * @return
	 */
	public List<PassInfo> findPassInfo(PassCriteria passCriteria) throws Exception ;
}
