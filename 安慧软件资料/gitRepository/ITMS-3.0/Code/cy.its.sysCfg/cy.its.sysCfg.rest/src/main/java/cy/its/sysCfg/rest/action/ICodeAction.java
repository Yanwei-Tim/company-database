package cy.its.sysCfg.rest.action;

import java.util.List;
import java.util.Map;

import cy.its.sysCfg.rest.dto.CodeDto;
import cy.its.sysCfg.rest.dto.CodeTypeTreeDto;

public interface ICodeAction {
	//CodeType��
	public List<CodeTypeTreeDto> initSysCodeTypeData()throws Exception;
	//����
	public String goUpdateCode(CodeDto codeDto);
	//����ɾ��
	public int deleteCode(String codeIdStr);
	//��ѯ
	Map<String,Object> selectAllCodeType(CodeDto codeDto) throws Exception;
	//����ϵͳ����
	String createCode(CodeDto codeDto);
	//����ɾ��
	String  removeCode(String codeId);
	
}
