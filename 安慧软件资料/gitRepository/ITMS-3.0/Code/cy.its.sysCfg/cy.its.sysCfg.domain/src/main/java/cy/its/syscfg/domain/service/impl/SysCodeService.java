package cy.its.syscfg.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.its.syscfg.domain.criteria.DistrictCriteria;
import cy.its.syscfg.domain.model.district.District;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.model.sysCode.CodeType;
import cy.its.syscfg.domain.repository.sysCode.ISysCodeRepository;
import cy.its.syscfg.domain.service.ISysCodeService;

/**
 * ϵͳ�������
 *
 */
@Service
public class SysCodeService implements ISysCodeService {

	@Autowired
	ISysCodeRepository sysCodeRepository;

	/**
	 * ��ѯ���еĴ���������Ϣ�б�
	 * 
	 * @return ����������Ϣ�б�
	 */
	public List<CodeType> findCodeTypes() {
		return sysCodeRepository.findCodeTypes();
	}

	/**
	 * ��ѯ���е�ϵͳ������Ϣ�б�
	 * 
	 * @return ϵͳ������Ϣ�б�
	 */
	public List<Code> findCodes() {
		List<CodeType> codeTypes = findCodeTypes();
		if (codeTypes != null) {
			List<Code> lstCodes = new ArrayList<Code>();
			codeTypes.stream().forEach(c -> {
				lstCodes.addAll(c.codeList());
			});
			return lstCodes;
		}

		return null;
	}

	/**
	 * ��ѯָ�����������µ����д��붨��
	 * 
	 * @param codeType
	 *            �������ͱ���
	 * @return ���붨���б�
	 * @throws Exception
	 */
	public List<Code> codeListOfType(String codeType) throws Exception {
		CodeType type = sysCodeRepository.aggregateOfId(codeType);
		return type == null ? null : type.codeList();
	}

	/**
	 * ��ѯָ����ϵͳ��������
	 * 
	 * @param codeType
	 *            ϵͳ�������ͱ���
	 * @return ϵͳ��������
	 * @throws Exception
	 */
	public CodeType codeTypeOfId(String codeType) throws Exception {
		return sysCodeRepository.aggregateOfId(codeType);
	}

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
	public Code codeOfId(String codeType, String codeNo) throws Exception {
		CodeType type = sysCodeRepository.aggregateOfId(codeType);
		return type != null ? type.code(codeNo) : null;
	}

	/**
	 * ɾ��ָ����ϵͳ��������
	 * 
	 * @param codeType
	 *            �������ͱ���
	 * @throws Exception
	 */
	public void removeCodeType(String codeType) throws Exception {
		CodeType type = sysCodeRepository.aggregateOfId(codeType);
		for (Code code : type.codeList()) {
			sysCodeRepository.removeCode(code.getIdentityId());
		}
		sysCodeRepository.delete(codeType);
	}

	/**
	 * ɾ��ָ����ϵͳ����
	 * 
	 * @param codeId
	 *            ϵͳ����Ψһ��ʶID
	 */
	public void removeCode(String codeId) {
		sysCodeRepository.removeCode(codeId);
	}
	/**
	 * ����ɾ��
	 */
	public void deleteCode(Map<String,Object> codeIds){
		sysCodeRepository.deleteCode(codeIds);
	}
	/**
	 * ����ϵͳ��������
	 * 
	 * @param codeType
	 *            ϵͳ����������Ϣ
	 */
	public void createCodeType(CodeType codeType) {
		sysCodeRepository.save(codeType);
	}

	/**
	 * ����ϵͳ����
	 * 
	 * @param code
	 *            ϵͳ������Ϣ
	 */
	public void createCode(Code code) {
		sysCodeRepository.saveCode(code);
	}

	/**
	 * ����ϵͳ����
	 * 
	 * @param code
	 *            ϵͳ������Ϣ
	 */
	public void updateCode(Code code) {
		sysCodeRepository.upddateCode(code);
	}

	/**
	 * ��ѯ��������������������Ϣ�б� ע:�ɷ�ҳ
	 * 
	 * @param crieria
	 *            ��ѯ����
	 * @return ����������Ϣ�б�
	 */
	public List<District> findDistrict(DistrictCriteria crieria) {
		if (crieria.getNeedTotal()) {
			crieria.setTotal(sysCodeRepository.countDistrict(crieria));
		}
		return sysCodeRepository.findDistrict(crieria);
	}

	/**
	 * ϵͳ�������֪ͨ
	 */
	public void sysCodeChanged() {
		sysCodeRepository.sysCodeChanged();
	}

	@Override
	public Map<String, String> selectAllData() {
		// TODO Auto-generated method stub
		return this.sysCodeRepository.selectAllData();
	}

}
