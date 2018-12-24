package cy.its.syscfg.domain.model.sysCode;

import cy.its.com.domain.Entity;

public class Code extends Entity<String> {

	/**
	 * ϵͳ����id
	 */
	private java.lang.String codeId;

	/**
	 * ������
	 */
	public java.lang.String codeNo;
	
	/**
	 * ��������
	 */
	public java.lang.String codeType;

	/**
	 * ��������
	 */
	public java.lang.String codeName;

	/**
	 * �༭��ʶ
	 */
	public java.lang.String editable;

	/**
	 * ��������
	 */
	public java.lang.String sortIndex;

	/**
	 * ��ע
	 */
	public java.lang.String remark;

	/**
	 * ���ñ�ʶ
	 */
	public java.lang.String enableFlag;
	
	public Code(String codeNo, String codeType,
			String codeName, String remark, String enableFlag) {
		this.codeNo = codeNo;
		this.codeType = codeType;
		this.codeName = codeName;
		this.remark = remark;
		this.enableFlag = enableFlag;
	}
	
	public Code(String codeId, String codeNo, String codeType,
			String codeName, String remark, String enableFlag) {
		this(codeNo, codeType, codeName, remark, enableFlag);
		this.codeId = codeId;
	}

	@Override
	public String getIdentityId() {
		return codeId;
	}
	
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	
	public String getCodeNo() {
		return this.codeNo;
	}
	
	public String getCodeType() {
		return this.codeType;
	}
}
