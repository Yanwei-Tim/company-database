package cy.its.violation.repository;

import java.util.List;

import cy.its.com.domain.IRepository;
import cy.its.violation.domain.criteria.ViolationCriteria;
import cy.its.violation.domain.model.violation.FilterStatistic;
import cy.its.violation.domain.model.violation.UnFilterStatistic;
import cy.its.violation.domain.model.violation.Violation;

public interface IViolationRepository extends IRepository<Violation> {
	/**
	 * @param violationCriteria
	 * @return
	 */
	List<Violation> findViolations(ViolationCriteria violationCriteria);

	int countViolation(ViolationCriteria violationCriteria);

	/**
	 * ����Υ����¼��(T_VIO_VIOLATION) ����������: Υ����¼ID, ����״̬Ϊδ����; ���½��:
	 * ����״̬���Ϊ������;����ʱ��Ϊָ������ʱ��;������Ϊָ��������;
	 * 
	 * @param violation
	 * @return
	 */
	int updateForLock(Violation violation);

	/**
	 * ����Υ����¼��(T_VIO_VIOLATION) ����������: Υ����¼ID, ����״̬Ϊ������; ���½��:
	 * ����״̬���Ϊδ����;����ʱ��Ϊ��;������Ϊ��;
	 * 
	 * @param violation
	 * @return
	 */
	int updateForUnlock(Violation violation);

	/**
	 * ������������Υ����¼
	 * 
	 * @param violationCriteria
	 * @return
	 */
	int updateVioByCondition(ViolationCriteria violationCriteria);

	/**
	 * ��������ɾ��Υ����¼
	 * 
	 * @param violationCriteria
	 * @return
	 */
	int deleteVioByCondition(ViolationCriteria violationCriteria);

	/**
	 * ͳ�ƴ�ɸѡ������
	 * 
	 * @param violationCriteria
	 * @return
	 */
	List<UnFilterStatistic> findUnFilterStatistic(ViolationCriteria violationCriteria);

	/**
	 * ͳ����ɸѡ������
	 * 
	 * @param violationCriteria
	 * @return
	 */
	public List<FilterStatistic> findFilterStatistic(ViolationCriteria violationCriteria);

}
