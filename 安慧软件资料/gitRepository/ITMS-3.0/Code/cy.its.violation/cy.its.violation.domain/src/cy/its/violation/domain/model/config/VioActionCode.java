package cy.its.violation.domain.model.config;

import java.util.Date;

import cy.its.com.domain.AggregateRoot;

public class VioActionCode extends AggregateRoot {

	/**
	 * Υ��������
	 */
	private String vioActionCode;

	/**
	 * Υ������
	 */
	private String vioType;

	/**
	 * Υ������(078)
	 */
	public String vioPriorType;

	/**
	 * Υ�����ݸ���
	 */
	private String vioSummary;

	/**
	 * Υ������
	 */
	public String vioConetent;

	/**
	 * ���÷�������
	 */
	public String legalReference;

	/**
	 * ������������
	 */
	public String punishLegalReference;

	/**
	 * Υ���Ƿ�
	 */
	public Integer fineScore;

	/**
	 * ��߷�����
	 */
	public Integer fineMax;

	/**
	 * ��ͷ�����
	 */
	public Integer fineMin;

	/**
	 * Ĭ�Ϸ�����
	 */
	public Integer fineDefault;

	/**
	 * ����ݿ�����
	 */
	public Integer suspendMonthMax;

	/**
	 * ����ݿ�����
	 */
	public Integer suspendMonthMin;

	/**
	 * ����������
	 */
	public Integer detainDaysMax;

	/**
	 * ��С��������
	 */
	public Integer detainDaysMin;

	/**
	 * ǿ�ƴ�ʩ����(079)
	 */
	public String forceType;

	/**
	 * ������
	 */
	public String flagWarn;

	/**
	 * ������
	 */
	public String flagFine;

	/**
	 * �ݿ۱��
	 */
	public String flagSuspend;

	/**
	 * �������
	 */
	public String flagCancel;

	/**
	 * �������
	 */
	public String flagDetain;

	/**
	 * ������ʻ֤���
	 */
	public String flagRevokeVehicle;

	/**
	 * ������ʻ֤���
	 */
	public String flagRevokeDriver;

	/**
	 * �Ƿ����
	 */
	private String isGb;

	/**
	 * ��Ч��ʼ
	 */
	private Date issueDay;

	/**
	 * ��Ч����
	 */
	private Date issueEndDay;

	/**
	 * �Ƿ���
	 */
	public String isCommonUsed;

	public VioActionCode() {

	}

	/**
	 * @param vioActionCode
	 * @param vioType
	 * @param vioSummary
	 * @param isGb
	 * @param issueDay
	 * @param issueEndDay
	 * @throws Exception
	 */
	public VioActionCode(String vioActionCode, String vioType, String vioSummary, String isGb, Date issueDay,
			Date issueEndDay) throws Exception {
		this.setVioActionCode(vioActionCode);
		this.setVioType(vioType);
		this.setVioSummary(vioSummary);
		this.setIsGb(isGb);
		this.setIssueDay(issueDay);
		this.setIssueEndDay(issueEndDay);
	}

	public void setVioActionCode(String vioActionCode) throws Exception {
		NotNull(vioActionCode, "Υ��������");
		this.vioActionCode = vioActionCode;
	}

	public String getVioActionCode() {
		return vioActionCode;
	}

	public void setVioType(String vioType) throws Exception {
		NotNull(vioType, "Υ������");
		this.vioType = vioType;
	}

	public String getVioType() {
		return vioType;
	}

	public void setVioSummary(String vioSummary) throws Exception {
		NotNull(vioSummary, "Υ�����ݸ���");
		this.vioSummary = vioSummary;
	}

	public String getVioSummary() {
		return vioSummary;
	}

	public void setIsGb(String isGb) throws Exception {
		NotNull(isGb, "�Ƿ����");
		this.isGb = isGb;
	}

	public String getIsGb() {
		return isGb;
	}

	public void setIssueDay(Date issueDay) throws Exception {
		// NotNull(issueDay, "��Ч��ʼ");
		this.issueDay = issueDay;
	}

	public Date getIssueDay() {
		return issueDay;
	}

	public void setIssueEndDay(Date issueEndDay) throws Exception {
		// NotNull(issueEndDay, "��Ч����");
		this.issueEndDay = issueEndDay;
	}

	public Date getIssueEndDay() {
		return issueEndDay;
	}

	@Override
	public String getIdentityId() {
		return this.vioActionCode;
	}

}
