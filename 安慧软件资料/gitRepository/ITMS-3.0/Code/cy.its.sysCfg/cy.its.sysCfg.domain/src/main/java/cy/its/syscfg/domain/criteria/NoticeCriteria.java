package cy.its.syscfg.domain.criteria;

import java.util.Date;

import cy.its.com.domain.Criteria;

public class NoticeCriteria extends Criteria {

	/**
	 * �û���������Ȩ�޴���
	 */
	public String userOrgPrivilegeCode;

	/**
	 * �������
	 */
	public String noticeTitle;
	
	/**
	 * ���淢��ʱ�䷶Χ ��ʼ
	 */
	public Date createTimeFrom;
	
	/**
	 * ���淢��ʱ�䷶Χ ����
	 */
	public Date createTimeTo;
}
