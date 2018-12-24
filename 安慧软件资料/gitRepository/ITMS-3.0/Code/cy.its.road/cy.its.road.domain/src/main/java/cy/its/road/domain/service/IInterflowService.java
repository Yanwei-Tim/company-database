package cy.its.road.domain.service;

import java.util.List;

import cy.its.road.domain.criteria.InterflowCriteria;
import cy.its.road.domain.model.interflow.Interflow;

public interface IInterflowService {

	/**
	 * ��ѯ���������Ĺ�·��ͨ�б�
	 * 
	 * @param interflowCriteria
	 *            ��ѯ����
	 * @return ��·��ͨ�б�
	 */
	public List<Interflow> findInterflows(InterflowCriteria interflowCriteria);

	/**
	 * ��ѯָ���Ĺ�·��ͨ
	 * 
	 * @param id
	 *            ��·��ͨΨһ��ʶ
	 * @return ��·��ͨ��ϸ
	 * @throws Exception
	 */
	public Interflow interflowOfId(String id) throws Exception;

	/**
	 * �����µĹ�·��ͨ
	 * 
	 * @param interflow
	 *            ��·��ͨ
	 */
	public void saveInterflow(Interflow interflow);

	/**
	 * ���¹�·��ͨ
	 * 
	 * @param interflow
	 *            ��·��ͨ
	 */
	public void updateInterflow(Interflow interflow);

	/**
	 * ɾ��ָ���Ĺ�·��ͨ
	 * 
	 * @param interflowId
	 *            ��·��ͨΨһ��ʶ
	 */
	public void deleteInterflow(String interflowId);

}