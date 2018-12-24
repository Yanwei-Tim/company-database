package cy.its.violation.domain.model.violation;

import java.util.Date;

import cy.its.violation.domain.criteria.ConstantCode;

/**
 * Υ��¼������_����¼��
 * 
 * @author STJ
 *
 */
public class ViolationInputAbandon extends ViolationInput {

	/**
	 * ���⳵�����ͣ�311��
	 */
	private String specialVehType;

	/**
	 * ����ԭ��312��
	 */
	private String discardedReason;

	/**
	 * �������306��
	 */
	private String discardedType;

	/**
	 * ������
	 */
	private String discardedBy;

	/**
	 * ����ʱ��
	 */
	private Date discardedTime;

	public ViolationInputAbandon(String specialVehType, String discardedReason, String discardedType,
			String discardedBy, Date discardedTime) {
		this.specialVehType = specialVehType;
		this.discardedReason = discardedReason;
		this.discardedType = discardedType;
		this.discardedBy = discardedBy;
		this.discardedTime = discardedTime;
	}

	@Override
	void ExcuteInput(Violation violation) throws Exception {

		if (stringIsEmpty(this.specialVehType)) {
			if (stringIsEmpty(this.discardedReason)) {
				throw new Exception("���⳵��Ϊ��ʱ,����ԭ�򲻿�Ϊ��!");
			}

			violation.discardedReason = this.discardedReason;

		} else {
			violation.specialVehType = this.specialVehType;
			violation.discardedReason = "02"; // 02 ���⳵��
		}

		violation.discardedType = this.discardedType;
		violation.setDiscardedBy(this.discardedBy);
		violation.setDiscardedTime(this.discardedTime);
		violation.setStatusFlag(ConstantCode.StatusFlag.DISCARDED);
		violation.setUploadFlag(ConstantCode.UploadFlag.NEW);

	}

	@Override
	protected boolean IsEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
}
