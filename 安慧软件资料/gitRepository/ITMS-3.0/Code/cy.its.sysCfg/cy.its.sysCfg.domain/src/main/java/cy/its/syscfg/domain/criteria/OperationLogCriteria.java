package cy.its.syscfg.domain.criteria;

import cy.its.com.domain.Criteria;

public class OperationLogCriteria extends Criteria {

	/**
	 * �����û�
	 */
	public String userId;

	/**
	 * �����û�����
	 */
	public String opeUserName;
	
	/**
	 * ��������
	 */
	public String sysFunctionCode;

	/**
	 * ������ʼʱ��
	 */
	public String operateBeginTime;

	/**
	 * ��������ʱ��
	 */
	public String operateEndTime;
	
	/**
	 * �������
	 */
	public String operateResult;
	
	/**
	 * ����Ȩ�޴���
	 */
	public String orgPrivilegeCode;
}
