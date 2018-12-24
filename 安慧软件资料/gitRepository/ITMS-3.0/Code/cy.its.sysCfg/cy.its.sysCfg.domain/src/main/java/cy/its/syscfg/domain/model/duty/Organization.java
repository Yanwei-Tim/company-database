package cy.its.syscfg.domain.model.duty;

import cy.its.com.domain.AggregateRoot;

public class Organization extends AggregateRoot {
	/**
	 * ����Ψһ��ʶ
	 */
	private java.lang.String orgId;

	/**
	 * ��������
	 */
	public java.lang.String orgCode;

	/**
	 * ��������
	 */
	public java.lang.String orgName;

	/**
	 * ����������
	 */
	public java.lang.String parentOrgCode;
	
	/**
	 * ������ID
	 */
	public java.lang.String parentOrgId;

	/**
	 * ҵ��ָ������
	 */
	public java.lang.String parentInstructOrgId;

	/**
	 * ��������
	 */
	public java.lang.String orgType;

	/**
	 * �Ƿ��ǲ��� 0-�����ĵ�λ�����ܶӡ�֧�ӡ���ӡ��ɳ�����1-��λ�µĲ��ţ���װ�������Ƽ��������ư졢���򴦡�
	 */
	public java.lang.String isDepartment;

	/**
	 * �Ƿ��Ǹ��ٹ����� ����֧������Ȩ�޺�����֧������Ȩ�޷ֿ���0����1���ǡ�
	 */
	public java.lang.String isHighwayOrg;
	/**
	 * ��������(072)�� 1����ʡ�����ܶ� 2�����о֣�֧�� 3�����ؾ֣���� 4�����ɳ������ж�
	 */
	public java.lang.String orgLevel;

	/**
	 * ��ϵ��ʽ
	 */
	public java.lang.String orgPhoneNbr;

	/**
	 * ����������
	 */
	public OrgHeader orgHeader;

	/**
	 * ǩ��
	 */
	public java.lang.String orgSignature;
	
	/**
	 * ֪ͨ��ǩ��
	 */
	public java.lang.String signatureNotifier;

	/**
	 * Ͻ����Ӧ������������Χ
	 */
	public java.lang.String sponsorDistributes;
	
	/**
	 * ����פ����Ϣ
	 */
	public OrgSeat orgSeat;

	/**
	 * ������
	 */
	private java.lang.String createBy;

	/**
	 * ������
	 */
	public java.lang.String updateBy;
	
	/**
	 * ��ע
	 */
	public java.lang.String remark;
	
	/**
	 * ����Ȩ�޴���
	 */
	public java.lang.String orgPrivilegeCode ;

	public Organization(OrgHeader orgHeader, OrgSeat orgSeat, String createBy,
			String updateBy) {
		this.orgHeader = orgHeader;
		this.orgSeat = orgSeat;
		this.createBy = createBy;
		this.updateBy = updateBy;
	}

	public Organization(OrgHeader orgHeader, OrgSeat orgSeat, String orgId,
			String createBy, String updateBy) {
		this(orgHeader, orgSeat, createBy, updateBy);
		this.orgId = orgId;
	}

	@Override
	public String getIdentityId() {
		return orgId;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}
	
	public void setOrgId(java.lang.String orgId) {
		this.orgId = orgId;
	}
}
