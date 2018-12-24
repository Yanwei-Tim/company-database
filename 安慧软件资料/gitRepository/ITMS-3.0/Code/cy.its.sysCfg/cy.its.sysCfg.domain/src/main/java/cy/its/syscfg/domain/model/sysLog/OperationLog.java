package cy.its.syscfg.domain.model.sysLog;

import java.util.Date;

import cy.its.com.domain.AggregateRoot;

public class OperationLog extends AggregateRoot {

	/**
	 * ��־id
	 */
	private String opeLogId;

	/**
	 * ϵͳ���ܱ���
	 */
	private String sysFunctionCode;

	/**
	 * �����û�
	 */
	private String opeUserName;

	/**
	 * ����ʱ��
	 */
	private Date operateTime;

	/**
	*
	*/
	private String operateRecordCounts;

	/**
	 * ���������1-�ɹ���2-ʧ��
	 */
	private String operateResult;

	/**
	 * ������ʱ
	 */
	private Double consumeSeconds;

	/**
	 * ����ʧ��ԭ��
	 */
	private String errorDesc;


	/**
	 * ����IP
	 */
	private String computerIp;

	/**
	 * 0����֧�֣� 1��֧�֣�֧�ֵ�ʱ�������ݿ�������ݱ��м�¼�������ݡ�
	 */
	private String rebackable;

	public OperationLog(){}
	
	public OperationLog(String sysFunctionCode, String opeUserName,
			Date operateTime, String operateRecordCounts, String operateResult,
			Double consumeSeconds, String errorDesc, String computerIp,
			String rebackable) throws Exception {

		this.setOpeUserName(opeUserName);
		this.setOperateTime(operateTime);
		this.setOperateRecordCounts(operateRecordCounts);
		this.setOperateResult(operateResult);
		this.setConsumeSeconds(consumeSeconds);
		this.setRebackable(rebackable);

		this.errorDesc = errorDesc;
		this.computerIp = computerIp;
		this.sysFunctionCode = sysFunctionCode;
	}

	public OperationLog(String opeLogId, String sysFunctionCode,
			String opeUserName, Date operateTime, String operateRecordCounts,
			String operateResult,Double consumeSeconds, String errorDesc,
			String computerIp, String rebackable) throws Exception {
		this(sysFunctionCode, opeUserName, operateTime, 
				operateRecordCounts, operateResult, consumeSeconds, errorDesc, computerIp, rebackable);
		this.setOpeLogId(opeLogId);
	}

	public void setOpeLogId(String opeLogId) throws Exception {
		NotNull(opeLogId, "��־id");
		this.opeLogId = opeLogId;
	}

	private void setOpeUserName(String opeUserName) throws Exception {
//		NotNull(opeUserName, "�����û�");
		this.opeUserName = opeUserName;
	}

	public String getOpeUserName() {
		return opeUserName;
	}

	private void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}

	public Date getOperateTime() {
		return operateTime;
	}

	private void setOperateRecordCounts(String operateRecordCounts)
			throws Exception {
//		NotNull(operateRecordCounts, "");
		this.operateRecordCounts = operateRecordCounts;
	}

	public String getOperateRecordCounts() {
		return operateRecordCounts;
	}

	private void setOperateResult(String operateResult) throws Exception {
		NotNull(operateResult, "�������");
		this.operateResult = operateResult;
	}

	public String getOperateResult() {
		return operateResult;
	}

	private void setConsumeSeconds(Double consumeSeconds) throws Exception {
//		NotLessThanZero(consumeSeconds, "������ʱ");
		this.consumeSeconds = consumeSeconds;
	}

	public Double getConsumeSeconds() {
		return consumeSeconds;
	}

	private void setRebackable(String rebackable) throws Exception {
//		NotNull(rebackable, "");
		this.rebackable = rebackable;
	}

	public String getRebackable() {
		return rebackable;
	}

	@Override
	public String getIdentityId() {
		return opeLogId;
	}


	public String getSysFunctionCode() {
		return sysFunctionCode;
	}

	public String getErrorDesc() {
		return errorDesc;
	}

	public String getComputerIp() {
		return computerIp;
	}
}
