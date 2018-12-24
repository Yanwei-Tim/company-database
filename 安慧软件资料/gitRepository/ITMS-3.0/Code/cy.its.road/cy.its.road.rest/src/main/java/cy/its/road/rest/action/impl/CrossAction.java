package cy.its.road.rest.action.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Title: CrossAction.java
 * @Package cy.its.road.rest.action.impl
 * @Description: TODO ·�ڹ���rest����
 * @author zuop zuop@cychina.cn
 * @date 2015��11��14�� ����1:49:47
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

import cy.its.com.util.ObjectMapUtils;
import cy.its.com.util.StringUtil;
import cy.its.road.domain.criteria.CrossCriteria;
import cy.its.road.domain.model.road.Cross;
import cy.its.road.domain.service.IRoadService;
import cy.its.road.rest.action.ICrossAction;
import cy.its.road.rest.dto.CrossDto;
import cy.its.road.rest.dto.CrossTreeDto;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.service.IDutyService;

@RestController
@RequestMapping("/road/cross")
public class CrossAction implements ICrossAction {

	@Autowired
	IRoadService roadService;

	@Autowired
	IDutyService dutyService;

	/**
	 * @throws Exception
	 * 
	 * findCrossByOrgId ���ݻ���Id����·����Ϣ @Title:
	 * findCrossByOrgId @Description: TODO @param @param
	 * orgId @param @return �趨�ļ� @return List �������� @throws
	 */
	@RequestMapping("findCrossByOrgId")
	public List<CrossTreeDto> findCrossByOrgId(String id, String rootId) throws Exception {
		List<CrossTreeDto> returnList = new ArrayList<CrossTreeDto>();
		// ��ʼ�����ظ��ڵ���¼��ڵ�
		if (id == null || "".equals(id)) {
			Organization rootOrg = dutyService.organizationOfId(rootId);
			List<Organization> children = dutyService.findOrgsOfParent(rootId);
			CrossTreeDto orgTreeDto = new CrossTreeDto(rootOrg);
			orgTreeDto.setState("open");
			for (Organization org : children) {
				orgTreeDto.getChildren().add(new CrossTreeDto(org));
			}
			returnList.add(orgTreeDto);
		} else {
			// �����ӽڵ�
			// �ҵ�·����Ϣ
			CrossCriteria criteria = new CrossCriteria();
			criteria.setNoPage();
			criteria.orgId = id;
			List<Cross> crossList = roadService.findCrosses(criteria);
			for (Cross cross : crossList) {
				returnList.add(new CrossTreeDto(cross));
			}
			// �ҵ��ӻ�����Ϣ
			List<Organization> orgList = dutyService.findOrgsOfParent(id);
			for (Organization org : orgList) {
				returnList.add(new CrossTreeDto(org));
			}
		}
		return returnList;
	}

	/**
	 * 
	 * findCorssInfo ����·�� @Title: findCorssInfo @Description: TODO @param @param
	 * searchIndex @param @return �趨�ļ� @return List �������� @throws
	 */
	@RequestMapping("/findCrossInfo")
	public Map<String, Object> findCorssInfo(String searchIndex) {
		CrossCriteria criteria = new CrossCriteria();
		criteria.setNoPage();
		criteria.crossName = searchIndex;
		List<Cross> crossList = roadService.findCrosses(criteria);
		return returnResult(crossList, crossList.size());
	}

	/**
	 * ��װҳ�淵������
	 * 
	 * @param dataList
	 * @param total
	 * @return
	 */
	private Map<String, Object> returnResult(List<Cross> dataList, int total) {
		// ��װ���ؼ�
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("error", "");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", dataList);
		returnMap.put("result", resultMap);
		return returnMap;
	}

	/*
	 * <p>Title: createCross</p> <p>Description: ����·����Ϣ</p>
	 * 
	 * @param crossDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ICrossAction#createCross(cy.its.road.rest.dto.
	 * CrossDto)
	 */

	@RequestMapping("/saveCross")
	@Override
	public String createCross(CrossDto crossDto) throws Exception {

		Cross cross = new Cross();
		if (!StringUtil.isNullOrEmpty(crossDto.getCrossLatitude())) {
			cross.setCrossLatitude(new BigDecimal(crossDto.getCrossLatitude()));
		}
		if (!StringUtil.isNullOrEmpty(crossDto.getCrossLongitude())) {
			cross.setCrossLongitude(new BigDecimal(crossDto.getCrossLongitude()));
		}
		// ���ݻ���Id��û���Ȩ�޴���ת������Dto
		Organization org = dutyService.organizationOfId(crossDto.getOrgId());
		if (org != null) {
			cross.setOrgPrivilegeCode(org.orgPrivilegeCode);
		}
				
		// ��dtoת�����������
		ObjectMapUtils.parseObject(cross, crossDto);
		roadService.saveCross(cross);
		return "success";
	}

	/*
	 * <p>Title: findCross</p> <p>Description: ��ѯ·����Ϣ</p>
	 * 
	 * @param crossDto
	 * 
	 * @return
	 * 
	 * @see cy.its.road.rest.action.ICrossAction#findCross(cy.its.road.rest.dto.
	 * CrossDto)
	 */

	@RequestMapping("/findCross")
	@Override
	public Map<String, Object> findCross(CrossDto crossDto) throws Exception {
		/**
		 * ������ѯ����
		 */
		CrossCriteria crossCriteria = new CrossCriteria();
		crossCriteria.crossCode = crossDto.getCrossCode();
		crossCriteria.crossName = crossDto.getCrossName();
		crossCriteria.roadId = crossDto.getRoadId();
		crossCriteria.crossType = crossDto.getCrossType();
		crossCriteria.setNeedTotal(true);
		crossCriteria.setPageNum(crossDto.getPageNumber());
		crossCriteria.setPageSize(crossDto.getPageSize());
		ArrayList<CrossDto> lstView = new ArrayList<CrossDto>();
		// ���·����ϢList����
		List<Cross> crossLst = roadService.findCrosses(crossCriteria);
		for (Cross cross : crossLst) {
			CrossDto Dto = new CrossDto();
			if (cross.getCrossLatitude() != null) {
				Dto.setCrossLatitude(cross.getCrossLatitude().toString());
			}
			if (cross.getCrossLongitude() != null) {
				Dto.setCrossLongitude(cross.getCrossLongitude().toString());
			}
			// ���������ת��ΪDto
			ObjectMapUtils.parseObject(Dto, cross);
			lstView.add(Dto);
		}
		// ��װ���ؽ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "");
		Map<String, Object> rows = new HashMap<String, Object>();
		rows.put("total", crossCriteria.getTotal());
		rows.put("rows", lstView);
		map.put("result", rows);
		return map;
	}

	/*
	 * <p>Title: updateCross</p> <p>Description:����·����Ϣ </p>
	 * 
	 * @param crossDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ICrossAction#updateCross(cy.its.road.rest.dto.
	 * CrossDto)
	 */

	@RequestMapping("/updateCross")
	@Override
	public String updateCross(CrossDto crossDto) throws Exception {

		Cross cross = new Cross();

		if (!StringUtil.isNullOrEmpty(crossDto.getCrossLatitude())) {
			cross.setCrossLatitude(new BigDecimal(crossDto.getCrossLatitude()));
		}
		if (!StringUtil.isNullOrEmpty(crossDto.getCrossLongitude())) {
			cross.setCrossLongitude(new BigDecimal(crossDto.getCrossLongitude()));
		}
		// ���ݻ���Id��û���Ȩ�޴���ת������Dto
		Organization org = dutyService.organizationOfId(crossDto.getOrgId());
		if (org != null) {
			cross.setOrgPrivilegeCode(org.orgPrivilegeCode);
		}
		// ��dtoת�����������
		ObjectMapUtils.parseObject(cross, crossDto);

		roadService.updateCross(cross);

		return "success";

	}

	/*
	 * <p>Title: deleteCrossIds</p> <p>Description: ����ɾ��CrossIds</p>
	 * 
	 * @param crossIdStr
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ICrossAction#deleteCrossIds(java.lang.String)
	 */

	@RequestMapping("removeCrossIds")
	@Override
	public String removeCrossIds(String crossIdStr) {
		// TODO Auto-generated method stub
		String[] idarr = crossIdStr.split(",");

		// ͨ��Arrays.asList���ַ�������ת��ΪList<String>���϶���

		List<String> idList = Arrays.asList(idarr);

		Map<String, Object> map = new HashMap<String, Object>();

		// �����϶�����õ�HashMap��

		map.put("idList", idList);

		// ����mysqlbatisɾ������

		roadService.removeCross(map);
		// ���֪ͨ
		roadService.roadChanged();
		return "success";
	}

	/*
	 * <p>Title: removeCrossId</p> <p>Description: ����ɾ��CrossId</p>
	 * 
	 * @param crossId
	 * 
	 * @return
	 * 
	 * @see cy.its.road.rest.action.ICrossAction#removeCrossId(java.lang.String)
	 */

	@RequestMapping("/deleteCrossId")
	@Override
	public String deleteCrossId(String crossId) {
		// TODO Auto-generated method stub
		roadService.deleteCross(crossId);
		return "success";
	}
}
