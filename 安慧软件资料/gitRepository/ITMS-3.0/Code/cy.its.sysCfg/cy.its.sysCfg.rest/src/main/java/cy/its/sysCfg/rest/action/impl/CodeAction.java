package cy.its.sysCfg.rest.action.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cy.its.com.util.ObjectMapUtils;
import cy.its.sysCfg.rest.action.ICodeAction;
import cy.its.sysCfg.rest.dto.CodeDto;

import cy.its.sysCfg.rest.dto.CodeTypeTreeDto;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.model.sysCode.CodeType;
import cy.its.syscfg.domain.service.ISysCodeService;

@RestController
@RequestMapping("/conCfg/SysCodeAction")
public class CodeAction implements ICodeAction {

	@Autowired
	ISysCodeService sysCodeService;

	@RequestMapping("/getSysCodeTypeData")
	public List<CodeTypeTreeDto> initSysCodeTypeData() throws Exception {
		// ���������������
		CodeTypeTreeDto ggdmDto = new CodeTypeTreeDto();
		// ����Id,�ı�
		ggdmDto.setId("0");
		ggdmDto.setText("���ô����");
		// �����ӽڵ�
		ggdmDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		CodeTypeTreeDto xtglDto = new CodeTypeTreeDto();
		xtglDto.setId("1");
		xtglDto.setText("ϵͳ�����");
		xtglDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		CodeTypeTreeDto clckDto = new CodeTypeTreeDto();
		clckDto.setId("2");
		clckDto.setText("������ر�");
		clckDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		CodeTypeTreeDto wfmkDto = new CodeTypeTreeDto();
		wfmkDto.setId("3");
		wfmkDto.setText("Υ��ģ���");
		wfmkDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		CodeTypeTreeDto sbywDto = new CodeTypeTreeDto();
		sbywDto.setId("4");
		sbywDto.setText("�豸��ά��");
		sbywDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		CodeTypeTreeDto lkjkDto = new CodeTypeTreeDto();
		lkjkDto.setId("5");
		lkjkDto.setText("·�ڼ�ر�");
		lkjkDto.setChildren(new ArrayList<CodeTypeTreeDto>());
	
		 CodeTypeTreeDto xxfbDto = new CodeTypeTreeDto();
		  xxfbDto.setId("6");
		  xxfbDto.setText("��Ϣ������");
		  xxfbDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		  
		/**
		 * CodeTypeTreeDto zhddDto=new CodeTypeTreeDto(); 
		 * zhddDto.setId("7");
		 * zhddDto.setText("ָ�ӵ��ȱ�");
		 * zhddDto.setChildren(new ArrayList<CodeTypeTreeDto>()); 
		 * CodeTypeTreeDto qwglDto=new CodeTypeTreeDto();
		 * qwglDto.setId("8"); 
		 * qwglDto.setText("��������");
		 * qwglDto.setChildren(new ArrayList<CodeTypeTreeDto>());
		 */
		// ����ҳ��list����
		List<CodeTypeTreeDto> lstView = new ArrayList<CodeTypeTreeDto>();
		// ���������ѯ����,���ش�������lst����
		List<CodeType> lst = sysCodeService.findCodeTypes();
		// �������������е�ÿһ��
		for (CodeType ct : lst) {
			// �жϴ�������Idƥ������ĸΪ0��Ϊһ��
			if (ct.getIdentityId().startsWith("0")) {
				// �����ӽڵ����
				CodeTypeTreeDto ggdmCDto = new CodeTypeTreeDto();
				ggdmCDto.setId(ct.getIdentityId());// ���Id
				ggdmCDto.setText(ct.codeTypeName);// ����ı���
				List<CodeTypeTreeDto> ltP = ggdmDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltP.add(ggdmCDto);
			} else if (ct.getIdentityId().startsWith("1")) {
				CodeTypeTreeDto xtglCDto = new CodeTypeTreeDto();
				xtglCDto.setId(ct.getIdentityId());// ���Id
				xtglCDto.setText(ct.codeTypeName);// ����ı���
				List<CodeTypeTreeDto> ltS = xtglDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltS.add(xtglCDto);
			} else if (ct.getIdentityId().startsWith("2")) {
				CodeTypeTreeDto clckCDto = new CodeTypeTreeDto();
				clckCDto.setId(ct.getIdentityId());// ���Id
				clckCDto.setText(ct.codeTypeName);// ����ı���
				List<CodeTypeTreeDto> ltB = clckDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltB.add(clckCDto);
			} else if (ct.getIdentityId().startsWith("3")) {
				CodeTypeTreeDto wfmkCDto = new CodeTypeTreeDto();
				wfmkCDto.setId(ct.getIdentityId());// ���Id
				wfmkCDto.setText(ct.codeTypeName);// ����ı���
				List<CodeTypeTreeDto> ltL = wfmkDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltL.add(wfmkCDto);
			} else if (ct.getIdentityId().startsWith("4")) {
				CodeTypeTreeDto sbywCDto = new CodeTypeTreeDto();
				sbywCDto.setId(ct.getIdentityId());// ���Id
				sbywCDto.setText(ct.codeTypeName);// ����ı���
				List<CodeTypeTreeDto> ltD = sbywDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltD.add(sbywCDto);
			} else if(ct.getIdentityId().startsWith("5")){
				CodeTypeTreeDto lkjkCDto = new CodeTypeTreeDto();
				lkjkCDto.setId(ct.getIdentityId());// ���Id
				lkjkCDto.setText(ct.codeTypeName);
				List<CodeTypeTreeDto> ltlkjk = lkjkDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltlkjk.add(lkjkCDto);
			} else if(ct.getIdentityId().startsWith("6")){
				CodeTypeTreeDto xxfbCDto = new CodeTypeTreeDto();
				xxfbCDto.setId(ct.getIdentityId());// ���Id
				xxfbCDto.setText(ct.codeTypeName);
				List<CodeTypeTreeDto> ltxxfb = xxfbDto.getChildren();
				// ���ӽڵ���Ϣ��ӵ��ӽڵ��ļ���
				ltxxfb.add(xxfbCDto);
			} 
		}
		lstView.add(ggdmDto);
		lstView.add(xtglDto);
		lstView.add(clckDto);
		lstView.add(wfmkDto);
		lstView.add(sbywDto);
		lstView.add(lkjkDto);
		lstView.add(xxfbDto);
		return lstView;
	}

	/**
	 * ��ѯ����
	 */
	@RequestMapping("/selectAllCode")
	@Override
	public Map<String, Object> selectAllCodeType(CodeDto codeDto) throws Exception {
		// ��ѯCode��Ϣ�б�
		List<Code> list = sysCodeService.codeListOfType(codeDto.getCodeType());
		// �Ѳ�ѯ���ת���ɲ�ѯ�б���
		ArrayList<CodeDto> lstView = new ArrayList<CodeDto>();
		// ����list
		if(list !=null){
			for (Code lst : list) {
				CodeDto codeDt = new CodeDto();
				// ת����ѯ����е�������
				ObjectMapUtils.parseObject(codeDt, lst);
				lstView.add(codeDt);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "");
		Map<String, Serializable> maprow = new HashMap<String, Serializable>();
		maprow.put("rows", lstView);
		maprow.put("total", lstView.size());
		map.put("result", maprow);
		return map;

	}

	/**
	 * ɾ��ϵͳ�������
	 */
	@RequestMapping("/deleteCode")
	@Override
	public int deleteCode(@RequestParam("codeIdStr") String codeIdStr) {
				
				String[] idarr = codeIdStr.split(",");
				
				//ͨ��Arrays.asList���ַ�������ת��ΪList<String>���϶���

				List<String> idList = Arrays.asList(idarr);

				Map<String,Object> map = new HashMap<String,Object>();

				//�����϶�����õ�HashMap��

				map.put("idList", idList);

				//����mysqlbatisɾ������

				sysCodeService.deleteCode(map);
				// ���֪ͨ
				sysCodeService.sysCodeChanged();;
								
				return 1;
	}

	/**
	 * ����ϵͳ�������
	 */
	@Override
	@RequestMapping("/saveCode")
	public String createCode(CodeDto codeDto) {
		// ʵ����Code����
		Code code = new Code(codeDto.getCodeNo(), codeDto.getCodeType(), codeDto.getCodeName(), codeDto.getRemark(),
				codeDto.getEnableFlag());
		code.editable = codeDto.getEditable();

		saveCode(code);// ����saveCode����;����ϵͳ����

		sysCodeService.sysCodeChanged();// ���֪ͨ

		return "success";
	}

	private void saveCode(Code code) {

		sysCodeService.createCode(code);

	}
	/**
	 * ����ɾ������
	 */
	@RequestMapping("/removeCode")
	@Override
	public String removeCode(@RequestParam("codeId") String codeId) {
		
		sysCodeService.removeCode(codeId);// ɾ��ϵͳ����
		
		sysCodeService.sysCodeChanged();// ���֪ͨ
		
		return "success";
	}

	/**
	 * ���²���
	 */
	@RequestMapping("/updateCode")
	@Override
	public String goUpdateCode(@ModelAttribute(value = "codeId") CodeDto codeDto) {

		Code code = new Code(codeDto.getCodeId(), codeDto.getCodeNo(), codeDto.getCodeType(), codeDto.getCodeName(),
				codeDto.getRemark(), codeDto.getEnableFlag());
		code.editable = codeDto.getEditable();
	
		updateCode(code);// ����updateCode����;����ϵͳ����

		sysCodeService.sysCodeChanged();// ���֪ͨ

		return "success";
	}

	private void updateCode(Code code) {
		sysCodeService.updateCode(code);
	}

	@RequestMapping("/testValidate")
	public Boolean testValidate(String paramName){
		return new Boolean(paramName);
	}

}
