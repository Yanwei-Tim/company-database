package cy.its.syscfg.domain.service;

import java.util.List;
import java.util.Map;

import cy.its.syscfg.domain.criteria.DistrictCriteria;
import cy.its.syscfg.domain.model.district.District;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.model.sysCode.CodeType;

public interface ISysCodeService {

	/**
	 * ��ѯ���еĴ���������Ϣ�б�
	 * 
	 * @return ����������Ϣ�б�
	 */
	public List<CodeType> findCodeTypes();
	
	/**
	 * ��ѯ���е�ϵͳ������Ϣ�б�
	 * 
	 * @return ϵͳ������Ϣ�б�
	 */
	public List<Code> findCodes();

	/**
	 * ��ѯָ�����������µ����д��붨��
	 * 
	 * @param codeType
	 *            �������ͱ���
	 * @return ���붨���б�
	 * @throws Exception 
	 */
	public List<Code> codeListOfType(String codeType) throws Exception;

	/**
	 * ��ѯָ����ϵͳ��������
	 * 
	 * @param codeType
	 *            ϵͳ�������ͱ���
	 * @return ϵͳ��������
	 * @throws Exception 
	 */
	public CodeType codeTypeOfId(String codeType) throws Exception;

	/**
	 * ��ѯָ����ϵͳ���붨��
	 * 
	 * @param codeType
	 *            ϵͳ��������
	 * @param codeNo
	 *            ϵͳ����
	 * @return ϵͳ���붨��
	 * @throws Exception 
	 */
	public Code codeOfId(String codeType, String codeNo) throws Exception;

	/**
	 * ɾ��ָ����ϵͳ��������
	 * 
	 * @param codeType
	 *            �������ͱ���
	 * @throws Exception 
	 */
	public void removeCodeType(String codeType) throws Exception;

	/**
	 * ɾ��ָ����ϵͳ����
	 * 
	 * @param codeId
	 *            ϵͳ����Ψһ��ʶID
	 */
	public void removeCode(String codeId);

	//����ɾ��
	public void deleteCode(Map<String,Object> codeIds);
	/**
	 * ����ϵͳ��������
	 * 
	 * @param codeType
	 *            ϵͳ����������Ϣ
	 */
	public void createCodeType(CodeType codeType);

	/**
	 * ����ϵͳ����
	 * 
	 * @param code
	 *            ϵͳ������Ϣ
	 */
	public void createCode(Code code);

	/**
	 * ����ϵͳ����
	 * 
	 * @param code
	 *            ϵͳ������Ϣ
	 */
	public void updateCode(Code code);

	/**
	 * ��ѯ��������������������Ϣ�б�
	 * 
	 * @param crieria
	 *            ��ѯ����
	 * @return ����������Ϣ�б�
	 */
	public List<District> findDistrict(DistrictCriteria crieria);
	
	/**
	 * ϵͳ������֪ͨ
	 */
	public void sysCodeChanged();

	/**
	 * ����ǰ׺
	 * @return
	 */
	public Map<String,String> selectAllData() ;
}