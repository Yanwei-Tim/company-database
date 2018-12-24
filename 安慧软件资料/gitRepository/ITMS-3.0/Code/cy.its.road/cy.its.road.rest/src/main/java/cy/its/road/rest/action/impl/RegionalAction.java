/**

 * @Title: ReglonalAction.java
 * @Package cy.its.road.rest.action.impl
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��21�� ����11:25:47
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.road.rest.action.impl;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cy.its.com.util.ObjectMapUtils;
import cy.its.com.util.StringUtil;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.platform.common.exception.ItmsAppException;
import cy.its.road.domain.criteria.RegionCriteria;
import cy.its.road.domain.model.region.Region;
import cy.its.road.domain.service.IRegionService;
import cy.its.road.domain.service.IRoadService;
import cy.its.road.rest.action.IRegionalAction;
import cy.its.road.rest.dto.RegionalDto;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.service.IDutyService;

/**
 * @ClassName: RegionalAction
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��21�� ����11:25:47
 *
 */
@RestController
@RequestMapping("/road/RegionalAction")
public class RegionalAction implements IRegionalAction {

	@Autowired
	IRegionService RegionService;
	@Autowired
	ISiteService siteService;
	@Autowired
	IRoadService roadService;
	@Autowired
	IDutyService dutyService;
	/*
	 * <p>Title: createReglonal</p> <p>Description:����������Ϣ </p>
	 * 
	 * @param reglonalDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.IReglonalAction#createReglonal(cy.its.road.rest.
	 * dto.ReglonalDto)
	 */

	@RequestMapping("/createRegional")
	@Override
	public String createRegional(RegionalDto regionalDto) throws Exception {
		
		RegionCriteria regionCriteria = new RegionCriteria();
		regionCriteria.regionalCode = regionalDto.getRegionalCode();
		
		List<Region> lst1 = RegionService.findRegions(regionCriteria);
		
		if(!lst1.isEmpty()){
			throw new ItmsAppException("�������Ѵ��ڣ����������룡");
		}
		
		Region region = new Region();
		
		// String תshort��
		if (regionalDto.getLimitLarge() != null && regionalDto.getLimitLarge() != "") {
			region.setLimitLarge(Short.parseShort(regionalDto.getLimitLarge()));
		}
		if (regionalDto.getLimitSmall() != null && regionalDto.getLimitSmall() != "") {
			region.setLimitSmall(Short.parseShort(regionalDto.getLimitSmall()));
		}
		if (regionalDto.getLimitLower() != null && regionalDto.getLimitLower() != "") {
			region.setLimitLower(Short.parseShort(regionalDto.getLimitLower()));
		}

		// Stringתlong
		//@@@@@@@@
//		if (regionalDto.getLimitOthers() != null && regionalDto.getLimitOthers() != "") {
//			region.setLimitOthers(Long.parseLong(regionalDto.getLimitOthers()));
//		}
		// StringתDouble
		if (!StringUtil.isNullOrEmpty(regionalDto.getDistance())) {
			region.setDistance(Double.parseDouble(regionalDto.getDistance()));
		}
		// ���ݻ���Id��û���Ȩ�޴���ת������Dto
		Organization org = dutyService.organizationOfId(regionalDto.getOrgId());
		if (org != null) {
			region.setOrgPrivilegeCode(org.orgPrivilegeCode);
		}
		// �ͻ���Dtoת������Dto
		ObjectMapUtils.parseObject(region, regionalDto);
		RegionService.saveRegion(region);
		return "success";
	}

	/*
	 * <p>Title: findReglonal</p> <p>Description:��ѯ������Ϣ </p>
	 * 
	 * @param reglongalId
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.IReglonalAction#findReglonal(java.lang.String)
	 */
	@RequestMapping("/findRegional")
	@Override
	public Map<String, Object> findRegional(RegionalDto regionalDto) throws Exception {
		// ������ѯ����
		RegionCriteria region = new RegionCriteria();
		region.regionalCode = regionalDto.getRegionalCode();
		region.regionalName = regionalDto.getRegionalName();
		region.roadId = regionalDto.getRoadId();
		region.districtCode = regionalDto.getDistrictCode();
		region.orgId = regionalDto.getCurrentOrgPrivilegeCode();
		region.setPageSize(regionalDto.getPageSize());
		region.setPageNum(regionalDto.getPageNumber());
		region.setOrderType(regionalDto.getOrderType());
		region.setOrderName(regionalDto.getOrderName());
		// �����Ƿ���Ҫͳ������: ��
		region.setNeedTotal(true);
		// ����lstView���ϸ��ͻ���
		ArrayList<RegionalDto> lstView = new ArrayList<RegionalDto>();
		// ���������Ϣ
		List<Region> lst = RegionService.findRegions(region);

		for (Region reg : lst) {

			RegionalDto Dto = new RegionalDto();
			SimpleDateFormat sdf = new SimpleDateFormat();
			// ShortתString
			if (reg.getLimitLarge() != null) {
				Dto.setLimitLarge(Short.toString(reg.getLimitLarge()));
			}
			if (reg.getLimitLower() != null) {
				Dto.setLimitLower(Short.toString(reg.getLimitLower()));
			}
			if (reg.getLimitSmall() != null) {
				Dto.setLimitSmall(Short.toString(reg.getLimitSmall()));
			}

			// LongתString
//			if (reg.getLimitOthers() != null) {
//				Dto.setLimitOthers(Long.toString(reg.getLimitOthers()));
//			}
			// dateתString
			if (reg.getHistoryMaxFlowTime() != null) {
				Dto.setHisToryMaxFlowTime(sdf.format(reg.getHistoryMaxFlowTime()));
			}
			// ͨ������λId��õ�λ����
			if (reg.getEntrySiteId() != null) {
				Site entryRite = siteService.siteOfId(reg.getEntrySiteId());
				if (entryRite != null) {
					Dto.setEntrySiteName(entryRite.getSiteName());
				}

			}
			// ͨ���յ��λId��õ�λ����
			if (reg.getExitSiteId() != null) {
				Site exitRite = siteService.siteOfId(reg.getExitSiteId());
				if (exitRite != null) {
					Dto.setExitSiteName(exitRite.getSiteName());
				}
			}
			// DoubleתString
			if (reg.getDistance() != null) {
				Dto.setDistance(reg.getDistance().toString());
			}
			// �ͻ���Dtoת������Dto
			ObjectMapUtils.parseObject(Dto, reg);
			lstView.add(Dto);
		}
		// ��װ���ؽ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "");
		Map<String, Object> maprows = new HashMap<String, Object>();
		maprows.put("rows", lstView);
		maprows.put("total", region.getTotal());
		map.put("result", maprows);
		return map;
	}

	/*
	 * <p>Title: goUpdateReglonal</p> <p>Description:����������Ϣ </p>
	 * 
	 * @param regionalDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.IRegionalAction#goUpdateReglonal(cy.its.road.rest
	 * .dto.RegionalDto)
	 */

	@RequestMapping("/updateRegional")
	@Override
	public String goUpdateRegional(RegionalDto regionalDto) throws Exception {
		
		Region region = RegionService.regionOfId(regionalDto.getRegionalId());
		if(!(region.getRegionalCode().equals(regionalDto.getRegionalCode()))){
			RegionCriteria regionCriteria = new RegionCriteria();
			regionCriteria.regionalCode = regionalDto.getRegionalCode();
			List<Region> lst1 = RegionService.findRegions(regionCriteria);
			
			if(!lst1.isEmpty()){
				throw new ItmsAppException("����Ѵ��ڣ����������룡");
			}
		}
		
		region = new Region();
		// String תshort��
		if (regionalDto.getLimitLarge() != null && regionalDto.getLimitLarge() != "") {
			region.setLimitLarge(Short.parseShort(regionalDto.getLimitLarge()));
		}
		if (regionalDto.getLimitSmall() != null && regionalDto.getLimitSmall() != "") {
			region.setLimitSmall(Short.parseShort(regionalDto.getLimitSmall()));
		}
		if (regionalDto.getLimitLower() != null && regionalDto.getLimitLower() != "") {
			region.setLimitLower(Short.parseShort(regionalDto.getLimitLower()));
		}

		// Stringתlong
//		if (regionalDto.getLimitOthers() != null && regionalDto.getLimitOthers() != "") {
//			region.setLimitOthers(Long.parseLong(regionalDto.getLimitOthers()));
//		}
		// StringתDouble
		if (!StringUtil.isNullOrEmpty(regionalDto.getDistance())) {
			region.setDistance(Double.parseDouble(regionalDto.getDistance()));
		}
		// ���ݻ���Id��û���Ȩ�޴���ת������Dto
		Organization org = dutyService.organizationOfId(regionalDto.getOrgId());
		if (org != null) {
			region.setOrgPrivilegeCode(org.orgPrivilegeCode);
		}
		// �ͻ���Dtoת������Dto
		ObjectMapUtils.parseObject(region, regionalDto);
		RegionService.updateRegion(region);
		return "success";
	}

	/*
	 * <p>Title: goDeleteReglonal</p> <p>Description: ����ɾ��������Ϣ</p>
	 * 
	 * @param regionalIdStr
	 * 
	 * @return
	 * 
	 * @see cy.its.road.rest.action.IRegionalAction#goDeleteReglonal(java.lang.
	 * String)
	 */

	@RequestMapping("/removeRegional")
	@Override
	public String goRemoveRegional(String regionalIdStr) {
		String[] idarr = regionalIdStr.split(",");
		List<String> idList = Arrays.asList(idarr);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("idList", idList);
		RegionService.removeRegion(map);
		return "success";
	}

	/*
	 * <p>Title: goRemoveReglonal</p> <p>Description:����ɾ��������Ϣ </p>
	 * 
	 * @param regionalId
	 * 
	 * @return
	 * 
	 * @see cy.its.road.rest.action.IRegionalAction#goRemoveReglonal(java.lang.
	 * String)
	 */

	@RequestMapping("/deleteRegional")
	@Override
	public String goDeleteRegional(String regionalId) {
		RegionService.deleteRegion(regionalId);
		return "success";
	}

}
