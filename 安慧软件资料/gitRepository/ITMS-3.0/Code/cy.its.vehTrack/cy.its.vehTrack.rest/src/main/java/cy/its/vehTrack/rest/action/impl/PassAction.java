package cy.its.vehTrack.rest.action.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cy.its.device.domain.criteria.SiteCriteria;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.vehTrack.domain.criteria.PassCriteria;
import cy.its.vehTrack.domain.model.PassInfo;
import cy.its.vehTrack.domain.service.IPassService;
import cy.its.vehTrack.rest.action.IPassAction;
import cy.its.vehTrack.rest.dto.PassDto;

/**
 * 
  * @ClassName: PassAction
  * @Description: ������Ϣrest����
  * @author zuop zuop@cychina.cn
  * @date 2015��10��27�� ����2:59:46
  *
 */
@RestController
@RequestMapping("/vehTrack/pass")
public class PassAction implements IPassAction{
	
	@Autowired
	IPassService passService;
	
	@Autowired
	ISiteService siteService;

	/**
	 * 
	  * findPassInfo ��ѯ������Ϣ
	  * @Title: findPassInfo
	  * @Description: ����ǰ�˲�ѯ������ѯ����������
	  * @param @param passDto ������ѯ������װDTO
	  * @param @return
	  * @param @throws Exception    �趨�ļ�
	  * @return Map    ��������
	  * @throws
	 */
	@RequestMapping("/findPassInfo")
	public Map findPassInfo(PassDto passDto) throws Exception {
		if("nullPlate".equals(passDto.getJustSearchNullPlate())){
			passDto.setJustSearchNullPlate("true");
		}else if ("unlocal".equals(passDto.getJustNonlocalVeh())){
			passDto.setJustNonlocalVeh("true");
		}
		PassCriteria criteria = passDto.convertToCriteria();
		criteria.setSort("desc");
		List<PassInfo> passInfoList = passService.findPassInfo(criteria);
		List<PassDto> passDtoList = new ArrayList<PassDto>();
		SiteCriteria siteCriteria = new SiteCriteria();
		siteCriteria.setNoPage();
		passInfoList.stream().forEach(item -> {
			Site site = siteService.siteOfCode(item.getSiteCode());
			PassDto passDtoItem = new PassDto(item);
			if(site != null){
				passDtoItem.setSiteName(site.getSiteName());
			}
			passDtoList.add(passDtoItem);
		});
		return returnResult(passDtoList, criteria.getTotal(),passDto.isActiveFlag());
	}
	
	/**
	 * @throws ParseException 
	 *  ��ѯ�켣
	  * findPath(������һ�仰�����������������)
	  * @Title: findPath
	  * @Description: TODO
	  * @param @param plateNbr ���ƺ�
	  * @param @param passTimeStart ��ʼʱ��
 	  * @param @param passTimeEnd ����ʱ��
	  * @param @param searchType ��ѯ����
	  * @param @return    �趨�ļ�
	  * @return List<PassDto>    ��������
	  * @throws
	 */
	@RequestMapping("/findPath")
	public List<PassDto> findPath(String plateNbr, String passTimeStart, 
			String passTimeEnd, String searchType,String currentOrgPrivilegeCode, int pageSize, int pageNumber,String plateType) throws Exception{
		PassDto passDto = new PassDto(plateNbr, passTimeStart, passTimeEnd, searchType, pageSize, pageNumber,plateType);
		PassCriteria criteria = passDto.convertToCriteria();
		criteria.setSort("asc");
		criteria.setOrgPrvCode(currentOrgPrivilegeCode);
		criteria.setTotal(Integer.MAX_VALUE);
		List<PassInfo> passInfoList = passService.findPassInfo(criteria);
		List<PassDto> passDtoList = new ArrayList<PassDto>();
		SiteCriteria siteCriteria = new SiteCriteria();
		siteCriteria.setNoPage();
		passInfoList.stream().forEach(item -> {
			PassDto passDtoItem = new PassDto(item);
			siteCriteria.siteCode = item.getSiteCode();
			List<Site> result = siteService.findSites(siteCriteria);
			if(result != null && !result.isEmpty()){
				passDtoItem.setSiteName(result.get(0).getSiteName());
				passDtoItem.setSiteLon(result.get(0).getSiteLongitude());
				passDtoItem.setSiteLat(result.get(0).getSiteLatitude());
			}
			passDtoList.add(passDtoItem);
			
		});
		return passDtoList;
	}
	
	/**
	 * 
	  * returnResult ��װ���ز���
	  * @Title: returnResult
	  * @Description: ��װ���ز���
	  * @param @param dataList ����
	  * @param @param total ����
	  * @param @return    �趨�ļ�
	  * @return Map<String,Object>    ��������
	  * @throws
	 */
	private Map<String, Object> returnResult(List<PassDto> dataList, long total,boolean flag) {
		// ��װ���ؼ�
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("error", "");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", dataList);
		returnMap.put("result", resultMap);
		if (flag){
			Map<String,PassDto> map = new HashMap<String,PassDto>();
		  for(PassDto bean:dataList){
			  if(!map.containsKey(bean.getPlateNbr())){
				  map.put(bean.getPlateNbr(), bean);
			  }
		  }
		  if(map.size()>3){
			  returnMap.put("error", "������׼ȷ�ĳ��ƺ�");
		  }
		}
		return returnMap;
	}
}
