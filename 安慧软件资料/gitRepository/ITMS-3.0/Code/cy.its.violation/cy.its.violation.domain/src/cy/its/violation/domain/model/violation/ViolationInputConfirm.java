package cy.its.violation.domain.model.violation;

import java.util.Date;

import cy.its.violation.domain.criteria.ConstantCode;

/**
 * Υ��¼������_У���¼�� ������:���١�����ơ���ռ����Υͣ��δϵ��ȫ�����ͳ�ҹ����С�ռ��Ӧ������������������Υ���� ��֤��¼��
 * 
 * @author STJ
 *
 */
public class ViolationInputConfirm extends ViolationInput {

	/**
	 * Υ��Ψһ��ʶ
	 */
	private String violationId;

	/**
	 * ���ƺ���
	 */
	private String plateNbr;

	/**
	 * ��������(002)
	 */
	private String plateType;

	/**
	 * ������ɫ(003)
	 */
	private String plateColor;

	/**
	 * Υ������
	 */
	private String violationCode;

	/**
	 * Υ������
	 */
	private String violationDesc;

	/**
	 * ¼����
	 */
	private String entryBy;

	/**
	 * ¼��ʱ��
	 */
	private Date entryTime;

	/**
	 * @param violationId
	 * @param plateNbr
	 * @param plateType
	 * @param plateColor
	 * @param violationCode
	 * @param violationDesc
	 * @param entryBy
	 * @param entryTime
	 */
	public ViolationInputConfirm(String violationId, String plateNbr, String plateType, String plateColor,
			String violationCode, String violationDesc, String entryBy, Date entryTime) {
		this.violationId = violationId;
		this.plateNbr = plateNbr;
		this.plateType = plateType;
		this.plateColor = plateColor;
		this.violationCode = violationCode;
		this.violationDesc = violationDesc;
		this.entryBy = entryBy;
		this.entryTime = entryTime;
	}

	@Override
	void ExcuteInput(Violation violation) throws Exception {
		violation.setViolationId(this.violationId);
		violation.setPlateNbr(this.plateNbr);
		violation.setPlateType(this.plateType);
		violation.setPlateColor(this.plateColor);
		violation.setViolationCode(this.violationCode);
		violation.setViolationDesc(this.violationDesc);
		violation.entryBy = this.entryBy;
		violation.entryTime = this.entryTime;
		violation.setStatusFlag(ConstantCode.StatusFlag.CONFIRMED);
	}

	public String getViolationId() {
		return violationId;
	}

	public void setViolationId(String violationId) {
		this.violationId = violationId;
	}

	public String getPlateNbr() {
		return plateNbr;
	}

	public String getPlateType() {
		return plateType;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public String getViolationCode() {
		return violationCode;
	}

	public String getViolationDesc() {
		return violationDesc;
	}

	public String getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	@Override
	protected boolean IsEmpty() {
		return false;
	}
}
