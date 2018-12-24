package cy.its.violation.domain.service;

import java.util.List;

import cy.its.violation.domain.criteria.ViolationCriteria;
import cy.its.violation.domain.model.violation.FilterStatistic;
import cy.its.violation.domain.model.violation.UnFilterStatistic;
import cy.its.violation.domain.model.violation.Violation;
import cy.its.violation.domain.model.violation.ViolationInputConfirm;
import cy.its.violation.domain.model.violation.ViolationInputDigital;

public interface IViolationService {

	/**
	 * ��ѯ����������Υ����¼�б�
	 * 
	 * @param violationCriteria
	 *            ��ѯ����
	 * @return Υ����¼�б�
	 */
	public List<Violation> findViolations(ViolationCriteria violationCriteria);

	/**
	 * ͳ�Ʒ���������Υ����¼�б�
	 * 
	 * @param violationCriteria
	 *            ��ѯ����
	 * 
	 * @return ����������Υ����¼��
	 */
	public int countViolations(ViolationCriteria violationCriteria);

	/**
	 * ��ѯ����������Υ����¼�б�
	 * 
	 * @param violationCriteria
	 *            ��ѯ����
	 * @return Υ����¼�б�
	 */
	public String findViolationSql(ViolationCriteria violationCriteria);

	/**
	 * ����ʽ�鿴Υ����ϸ
	 * 
	 * @param violationId
	 *            Υ����¼Ψһ��ʶID
	 * @param lockUser
	 *            �����û�
	 * @return Υ����ϸ
	 * @throws Exception
	 */
	public Violation viewViolationOfIdWithLock(String violationId, String lockUser) throws Exception;

	/**
	 * �����ָ��Υ����¼������
	 * 
	 * @param violationId
	 *            Υ����¼Ψһ��ʶID
	 * @return
	 * @throws Exception
	 */
	public int unLockViolation(String violationId) throws Exception;

	/**
	 * ɸѡͨ��ָ����Υ����¼
	 * 
	 * @param violationId
	 *            Υ����¼Ψһ��ʶID
	 * @throws Exception
	 */
	public void filterViolation(String violationId, String opUser) throws Exception;

	/**
	 * ��¼ָ����Υ����¼
	 * 
	 * @param violationId
	 * @return
	 * @throws Exception
	 */
	public int reInputViolation(String[] violationId, String updateBy) throws Exception;

	/**
	 * ��¼ָ����Υ����¼
	 * 
	 * @param violationCriteria
	 * @param updateBy
	 * @return
	 * @throws Exception
	 */
	public int reInputViolation(ViolationCriteria violationCriteria, String updateBy) throws Exception;

	/**
	 * Υ��¼�� ������: ���١�����ơ���ռ����Υͣ�� δϵ��ȫ���� �ͳ� ҹ����С� ռ��Ӧ������������������Υ���� ¼��
	 * 
	 * @param confirm
	 * @return
	 * @throws Exception
	 */
	public int inputViolationForConfirm(ViolationInputConfirm confirm) throws Exception;

	/**
	 * ����ɼ�¼�� ������ ����ȡ֤¼��;��Ƶ���ȡ֤¼��;��Ƶ¼��ȡ֤¼��;
	 * 
	 * @param inputDigital
	 *            ����ɼ���Ϣ
	 * @throws Exception
	 */
	public void inputViolationDigital(ViolationInputDigital inputDigital) throws Exception;

	/**
	 * Υ����������ĵ������
	 * 
	 * @param violation
	 *            Υ����Ϣ
	 * @throws Exception
	 */
	public void inputViolationDigital(Violation violation) throws Exception;

	/**
	 * Υ��¼��:������������
	 * 
	 * @param violationId
	 *            Υ��Ψһ��ʶID
	 * @param specialVehType
	 *            ���⳵������
	 * @param discardedReason
	 *            ����ԭ��
	 * @param discardedBy
	 *            ������
	 * @return
	 * @throws Exception
	 */
	public int abandonViolation(String violationId, String specialVehType, String discardedReason, String discardedBy)
			throws Exception;

	/**
	 *
	 * ��������δ����
	 * 
	 * @param violationIds
	 *            Υ��Ψһ��ʶID�б�
	 * @param specialVehType
	 *            ���⳵������
	 * @param discardedReason
	 *            ����ԭ��
	 * @param discardedBy
	 *            ������
	 * @throws Exception
	 */
	public int abandonViolations(String[] violationIds, String discardedReason, String discardedBy) throws Exception;

	/**
	 * ��������δ����
	 * 
	 * @param violationCriteria
	 * @param specialVehType
	 * @param discardedReason
	 * @param discardedBy
	 * @return
	 * @throws Exception
	 */
	public int abandonViolations(ViolationCriteria violationCriteria, String specialVehType, String discardedReason,
			String discardedBy) throws Exception;

	/**
	 * ������������Υ�������޸�Ϊ���ϴ�
	 * 
	 * @param violationIds
	 * @return
	 * @throws Exception
	 */
	public int uploadViolation(String[] violationIds, String uploadBy) throws Exception;

	/**
	 * ������������Υ�������޸�Ϊ���ϴ�
	 * 
	 * @param violationCriteria
	 * @return
	 * @throws Exception
	 */
	public int uploadViolation(ViolationCriteria violationCriteria, String uploadBy) throws Exception;

	/**
	 * ����ָ�����ϴ�ʧ��Υ����¼
	 * 
	 * @param violationId
	 *            Υ����¼Ψһ��ʶID
	 * @param roadCode
	 *            ������ĵ�·����
	 * @param orgCode
	 *            �����˵Ļ�������
	 * @param uploadBy
	 *            ������
	 * @throws Exception
	 */
	public void verifyUploadFailViolation(String violationId, String roadCode, String orgCode, String uploadBy)
			throws Exception;

	/**
	 * ��ԭָ�����ѷ���Υ����¼
	 * 
	 * @param violationIds
	 * @return
	 * @throws Exception
	 */
	public int restoreAbandons(String[] violationIds) throws Exception;

	/**
	 * ��ԭָ���������ѷ���Υ����¼
	 * 
	 * @param violationCriteria
	 * @return
	 * @throws Exception
	 */
	public int restoreAbandons(ViolationCriteria violationCriteria) throws Exception;

	/**
	 * ɾ��ָ�����ѷ���Υ����¼
	 * 
	 * @param violationIds
	 * @return
	 * @throws Exception
	 */
	public int deleteViolations(String[] violationIds) throws Exception;

	/**
	 * ɾ��ָ���������ѷ���Υ����¼
	 * 
	 * @param violationCriteria
	 * @return
	 * @throws Exception
	 */
	public int deleteViolations(ViolationCriteria violationCriteria) throws Exception;

	/**
	 * ͳ��δɸѡ��Υ����¼
	 * 
	 * @param violationCriteria
	 * @return
	 */
	List<UnFilterStatistic> findUnFilterStatistic(ViolationCriteria violationCriteria);

	/**
	 * ͳ����ɸѡ��Υ����¼
	 * 
	 * @param violationCriteria
	 * @return
	 */
	List<FilterStatistic> findFilterStatistic(ViolationCriteria violationCriteria);

}