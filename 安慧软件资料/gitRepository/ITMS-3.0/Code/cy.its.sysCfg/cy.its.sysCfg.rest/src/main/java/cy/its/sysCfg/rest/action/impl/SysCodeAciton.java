package cy.its.sysCfg.rest.action.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cy.its.sysCfg.rest.action.ISysCodeAction;
import cy.its.sysCfg.rest.dto.CodeComboxDto;
import cy.its.sysCfg.rest.dto.DistrictTreeDto;
import cy.its.sysCfg.rest.dto.OrgTreeDto;
import cy.its.syscfg.domain.criteria.DistrictCriteria;
import cy.its.syscfg.domain.model.district.District;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.service.ISysCodeService;

@RestController
@RequestMapping("/sysCfg/sysCode")
public class SysCodeAciton implements ISysCodeAction{
	
	@Autowired
	ISysCodeService sysCodeService;
	
	/**
	 * ��ʼ������
	 * @param codeTypesString ϵͳ�������ͣ�����Զ��Ÿ���
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/getSysCodes")
	public Map initSyscodeData(@RequestParam(value="codeTypesString",required=true) String codeTypesString) throws Exception{
		String[] codeTypes = codeTypesString.split(",");
		Map<String,List<CodeComboxDto>> returnMap = new HashMap<String,List<CodeComboxDto>>();
		//����codeType��������Ժ�������ֵ�
		for(String codeType : codeTypes){
			returnMap.put(codeType, getSysCodesByType(codeType));
		}
		return returnMap;
	}
	
	/**
	 * ��ʼ����������
	 * @param districtCode �����������ڵ������
	 * @return �ýڵ��µ���������������Ϣ
	 * @throws Exception
	 */
	@RequestMapping("/getDistrict")
	public List<DistrictTreeDto> initDistrictData(@RequestParam(value="districtCode",required=true) String districtCode) throws Exception{
		//��ȡȫ������������
		DistrictCriteria crieria = new DistrictCriteria();
		crieria.districtCode = districtCode;
		crieria.setNoPage();
		List<District> districtList = sysCodeService.findDistrict(crieria);
		//�����������������������
		sortDistrict(districtList);
		//ת�������нṹ
		DistrictTreeDto districtTreeDto = convertToDto(districtList.get(0));
		districtTreeDto = convertToDtoList(districtTreeDto, 
				districtList,districtTreeDto.getId().substring(0, 2),4);
		List<DistrictTreeDto> returnList = new ArrayList<DistrictTreeDto>();
		returnList.add(districtTreeDto);
		return returnList;
	}
	
	/**
	 * ��domain���ص�list����ת��Ϊ���νṹ
	 * @param districtTreeDto ���ṹ����
	 * @param districtList domain�㷵�ص��б�
	 * @param code ���ڵ����
	 * @param length ��0�ַ�������
	 * @return
	 */
	private DistrictTreeDto convertToDtoList(DistrictTreeDto districtTreeDto, List<District> districtList,
			String code, int length) {
		List<DistrictTreeDto> dtoList = new ArrayList<DistrictTreeDto>();
		for(int index=0 ; index<districtList.size(); index++){
			District district = districtList.get(index);
			String codeWithout0 = subDistrictCode(district.districtCode);
			if(codeWithout0.length() == length && codeWithout0.startsWith(code)){
				districtList.remove(index--);
				DistrictTreeDto dto = convertToDto(district);
				dto = convertToDtoList(dto, 
						districtList,dto.getId().substring(0, length),length + 2);
				dtoList.add(dto);
			}
		}
		if(dtoList.size() != 0){
			districtTreeDto.setChildren(dtoList);
		}
		return districtTreeDto;
	}
	
	/**
	 * ���������������к������е�0ȥ��
	 * @param districtCode
	 * @return
	 */
	private String subDistrictCode(String districtCode) {
		while(districtCode.endsWith("00")){
			districtCode = districtCode.substring(0, districtCode.length() - 2);
		}
		// TODO Auto-generated method stub
		return districtCode;
	}

	
	/**
	 * ��������������
	 * @param districtList
	 */
	private void sortDistrict(List<District> districtList) {
		Collections.sort(districtList,new Comparator<District>(){
			public int compare(District arg0, District arg1) {
                return arg0.districtCode.compareTo(arg0.districtCode);
            }
		});
	}

	/**
	 * ���������ת��dto
	 * @param org
	 * @return
	 */
	private DistrictTreeDto convertToDto(District district){
		DistrictTreeDto dto = new DistrictTreeDto();
		dto.setId(district.getIdentityId());
		dto.setText(district.districtName);
		Map<String,String> attribute = new HashMap<String,String>();
		attribute.put("code", district.districtCode);
		dto.setAttribute(attribute);
		return dto;
	}
	/**
	 * �����ֵ����ͻ�ȡ�ֵ���
	 * @return
	 */
	private List<CodeComboxDto> getSysCodesByType(String codeType) throws Exception{
		List<Code> codeList = sysCodeService.codeListOfType(codeType);
		//��codeת��Ϊǰ��ʹ�õ�DTO������װ��map��
		Iterator<Code> iter = codeList.iterator();
		List<CodeComboxDto> codeDtoList = new ArrayList<CodeComboxDto>();
		while(iter.hasNext()){
			Code code = iter.next();
			CodeComboxDto codeDto = new CodeComboxDto();
			codeDto.setValue(code.codeNo);
			codeDto.setText(code.codeName);
			codeDtoList.add(codeDto);
		}
		return codeDtoList;
	}

	@Override
	@RequestMapping("/getPlatePrefix")
	public Map<String, String> initPlatePrefixData() throws Exception {
		// TODO Auto-generated method stub
		return this.sysCodeService.selectAllData();
	}
	
	
}
	
