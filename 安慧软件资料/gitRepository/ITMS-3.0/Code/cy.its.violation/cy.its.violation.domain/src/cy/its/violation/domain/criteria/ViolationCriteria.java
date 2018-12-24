package cy.its.violation.domain.criteria;

import java.util.List;

import cy.its.com.domain.Criteria;

/**
 * ��o_��ͷ�ı����Ǹ����ֶ�
 * 
 * @author jinhb
 */
public class ViolationCriteria extends Criteria {
	// �����ֶ�
	public String UvehicleRegId;

	/**
	 * 
	 */
	public String o_discardedType;
	/**
	 * 
	 */
	public String o_discardedBy;
	/**
	 * 
	 */
	public String o_discardedTime;
	/**
	 * 
	 */
	public String o_specialVehType;
	/**
	 * 
	 */
	public String o_discardedReason;
	/**
	 * 
	 */
	public String o_statusFlag;
	/**
	 * 
	 */
	public String o_entryBy;
	/**
	 * 
	 */
	public String o_entryTime;
	/**
	 * 
	 */
	public String o_uploadFlag;
	/**
	 * 
	 */
	public String o_uploadBy;
	/**
	 * 
	 */
	public String o_uploadTime;
	/**
	 * 
	 */
	public String o_speedingType;
	/**
	 * 
	 */
	public String o_collectionType;
	/**
	 * 
	 */
	public String o_collectionPolice;
	/**
	 * 
	 */
	private String o_exportFlag;
	/**
	 * 
	 */
	public String o_exportTime;
	/**
	 * 
	 */
	public String o_remark;
	/**
	 * 
	 */
	public String o_updateTime;

	// ���ƺ��롢�������ࡢ������ɫ���ɼ���λ��
	// �ɼ��豸��Υ��ʱ�䡢Υ�����͡���¼״̬���¼�¼����¼�롢�ѷ�������
	// �ɼ���ʽ������ԭ�����⳵�����Ƿ�������⳵����
	// Υ��ʱ�䡢�ٶȡ��������
	// �ϴ����
	// �������
	// �Ƿ�δʶ�����

	/**
	 * ��ȷ���ƺ���
	 */
	public String plateNbr;

	/**
	 * ģ�����ƺ���
	 */
	public String fuzzyPlateNbr;

	/**
	 * ��������
	 */
	public String plateType;

	/**
	 * ������ɫ
	 */
	public String plateColor;

	/**
	 * �ɼ���λ
	 */
	public String orgCode;
	/**
	 * �ɼ���λȨ�޴���
	 */
	public String org_authority_code;

	/**
	 * �ɼ��豸
	 */
	public String deviceSysNbr;

	/**
	 * �ɼ���λ
	 */
	public List<String> LstSiteCode;

	/**
	 * Υ����ʼʱ��
	 */
	public String violationBeginTime;

	/**
	 * Υ������ʱ��
	 */
	public String violationEndTime;

	/**
	 * �ϴ���ʼʱ��
	 */
	public String uploadBeginTime;

	/**
	 * �ϴ�����ʱ��
	 */
	public String uploadEndTime;

	/**
	 * Υ������(030)�� 0����ռ�� 1�������� 2�������� 3������ 4������� 5��ѹ���� 6��Υ��ͣ�� 7�����䳬�� 8������ 9������
	 * a��Υ��ռ�� b���ڵ����� c������������ʻ d��ѹ�� e��δϵ��ȫ��
	 */
	public List<String> lstViolationType;

	/**
	 * ��¼״̬��301��,0���¼�¼��1����¼�룻2��������¼
	 */
	public List<String> lstStatusFlag;
	
	/**
	 * ��¼״̬��301��,0���¼�¼��1����¼�룻2��������¼
	 */
	public List<String> lstCollectionType;

	/**
	 * ��¼״̬
	 */
	public String statusFlag;

	/**
	 * ����ԭ��(312) 01 �쳣���� 02 ���⳵�� 21���Ƴ� 22 ���Ƴ� 23 �������� 24 ������ 25 ũ�ó� 26 Ħ�г� 03
	 * �ظ���¼ 04 ��Чͼ�� 05 ���Ʋ�ȫ 06 �޺��� 07 ��ʱ 08 ����
	 */
	public String discardedReason;

	/**
	 * �������
	 */
	public String discardedType;

	/**
	 * ��������ֵ
	 */
	public Integer speedMin;

	/**
	 * ��������ֵ
	 */
	public Integer speedMax;

	/**
	 * �ɼ���ʽ 1��������豸 2����·�����豸 3�������豸 4����·���� 5���ƶ����� 6������ͨ 7��������� 8�����Ƕ�λװ�� 9�����������豸
	 */
	public String collectionType;

	/**
	 * ������� ��1 �ƶ����� 2 ������� 3 �̶������ 4 ������Ȧ���� 5 �����״����
	 */
	public String speedingType;

	/**
	 * �ϴ���� 0 δ�ϴ� 1 ���ϴ� 2 ���ϴ� 3 �ϴ�ʧ��
	 */
	public String uploadFlag;

	/**
	 * ���⳵������
	 */
	public String specialVehType;

	/**
	 * �Ƿ�������⳵�� 0���: ������; 1:����;
	 */
	public String isIncludeSpecial;

	/**
	 * �Ƿ�����쳣����
	 */
	// public String isIncludeSpecial;
	public Boolean isArmyPlate;

	public Boolean isUnknownPlate;
}