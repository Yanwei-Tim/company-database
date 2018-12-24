package cy.its.road.rest.action.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cy.its.com.util.ObjectMapUtils;
import cy.its.com.util.StringUtil;
import cy.its.device.domain.criteria.SiteCriteria;
import cy.its.device.domain.criteria.SystemCriteria;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.device.domain.service.ISystemService;
import cy.its.road.domain.criteria.RoadCriteria;
import cy.its.road.domain.criteria.RoadSectionCriteria;
import cy.its.road.domain.model.road.Road;
import cy.its.road.domain.model.road.RoadSection;
import cy.its.road.domain.service.IRoadService;

import cy.its.road.rest.dto.RoadSectionTreeDto;
import cy.its.road.rest.action.IRoadSectionAction;
import cy.its.road.rest.dto.RoadSectionDto;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.syscfg.domain.service.ISysCodeService;

/**
 * @Title: RoadSectionAction.java
 * @Package cy.its.road.rest.action.impl
 * @Description: ·��rest����
 * @author zuop zuop@cychina.cn
 * @date 2015��11��16�� ����2:12:15
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 *      Company: ���ճ�Զ��Ϣ�������޹�˾ Copyright: Copyright (c) 2015
 */
@RestController
@RequestMapping("/road/roadSection")
public class RoadSectionAction implements IRoadSectionAction {

	@Autowired
	IRoadService roadService;

	@Autowired
	ISysCodeService sysCodeService;

	@Autowired
	IDutyService dutyService;
	
	@Autowired
	ISiteService siteService;

	@Autowired
	ISystemService systemService; 
	/**
	 * ���·���� getRoadSectionTree(������һ�仰�����������������) @Title:
	 * getRoadSectionTree @Description: TODO @param @return �趨�ļ� @return List
	 * <RoadSectionTreeDto> �������� @throws
	 * 
	 * @throws Exception
	 */
	@RequestMapping("/getRoadSectionTree")
	public List<RoadSectionTreeDto> getRoadSectionTree(String id) throws Exception {
		if (id == null || "".equals(id)) {
			// ���ص�·��Ϣ
			return getRoadTree();
		} else {
			List<RoadSectionTreeDto> returnList = new ArrayList<RoadSectionTreeDto>();
			// ����·����Ϣ
			RoadSectionCriteria criteria = new RoadSectionCriteria();
			criteria.roadId = id;
			criteria.setNoPage();
			List<RoadSection> roadSectionList = roadService.findRoadSectiones(criteria);
			roadSectionList.forEach(item -> {
				returnList.add(new RoadSectionTreeDto(item));
			});
			return returnList;
		}
	}

	/**
	 * 
	 * findRoadSection ����·�� @Title: findRoadSection @Description:
	 * TODO @param @param searchIndex @param @return �趨�ļ� @return Map
	 * �������� @throws
	 */
	@RequestMapping("/findRoadSection")
	public Map<String, Object> findRoadSection(String searchIndex) {
		RoadSectionCriteria criteria = new RoadSectionCriteria();
		criteria.roadSectionName = searchIndex;
		criteria.setNoPage();
		List<RoadSection> roadSectionList = roadService.findRoadSectiones(criteria);
		return returnResult(roadSectionList, roadSectionList.size());
	}

	/**
	 * ��װҳ�淵������
	 * 
	 * @param dataList
	 * @param total
	 * @return
	 */
	private Map<String, Object> returnResult(List<RoadSection> dataList, int total) {
		// ��װ���ؼ�
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("error", "");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("total", total);
		resultMap.put("rows", dataList);
		returnMap.put("result", resultMap);
		return returnMap;
	}

	/**
	 * getRoadTree ��õ�·�����
	 * 
	 * @Title: getRoadTree
	 * @Description: TODO
	 * @param @return
	 * �趨�ļ� @return List<RoadSectionTreeDto> �������� @throws
	 * @throws Exception
	 */
	private List<RoadSectionTreeDto> getRoadTree() throws Exception {
		// �������еĵ�·��Ϣ
		RoadCriteria roadCriteria = new RoadCriteria();
		roadCriteria.setNoPage();
		List<Road> roadList = roadService.findRoads(roadCriteria);
		// ��õ�·���ͱ���
		List<Code> roadTypeList = sysCodeService.codeListOfType("016");
		return convertToRoadTree(roadTypeList, roadList);
	}

	/**
	 * �����ҵ�������ת��ΪTree�ṹ
	 * 
	 * @return ��·��
	 */
	private List<RoadSectionTreeDto> convertToRoadTree(List<Code> roadTypeList, List<Road> roadList) {
		List<RoadSectionTreeDto> types = new ArrayList<RoadSectionTreeDto>();
		// ���ȳ�ʼ����·���
		roadTypeList.stream().forEach(item -> {
			types.add(new RoadSectionTreeDto(item));
		});
		// ����·������ӵ���Ӧ�ĵ�·���ͽڵ���
		roadList.stream().forEach(item -> {
			List<RoadSectionTreeDto> children = findChildrenByRoadType(types, item.getRoadType());
			if (children != null) {
				children.add(new RoadSectionTreeDto(item));
			}
		});
		// ���һ��ͳһ�ĸ��ڵ�
		List<RoadSectionTreeDto> roots = new ArrayList<RoadSectionTreeDto>();
		RoadSectionTreeDto root = new RoadSectionTreeDto();
		root.setId("0");
		root.setText("��·");
		root.setChildren(types);
		roots.add(root);
		return roots;
	}

	/**
	 * ���ݵ�·�����ҵ��������µ��ӽڵ�
	 * 
	 * @param roots
	 *            ���е�·�����ڵ�
	 * @param roadType
	 *            ��·����
	 * @return ��·�����ӽڵ�
	 */
	private List<RoadSectionTreeDto> findChildrenByRoadType(List<RoadSectionTreeDto> roots, String roadType) {
		Iterator<RoadSectionTreeDto> iter = roots.iterator();
		while (iter.hasNext()) {
			RoadSectionTreeDto item = iter.next();
			if (item.getId().equals(roadType)) {
				return item.getChildren();
			}
		}
		return null;
	}

	/*
	 * <p>Title: createSection</p> <p>Description: ����·����Ϣ</p>
	 * 
	 * @param sectionDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ISectionAction#createSection(cy.its.road.rest.dto
	 * .SectionDto)
	 */

	@RequestMapping("/saveRoadSection")
	@Override
	public int createRoadSection(RoadSectionDto roadSectionDto) throws Exception {
		int flag=0;
		//���ݵ�·Id��ѯ�õ�·�µ�����·��Code
		//�ж�����һ��·���Ƿ��Ѱ󶨵�·,��֤·��codeΨһ�Ա�ʶ
		RoadSectionCriteria criteria = new RoadSectionCriteria();
		criteria.roadId=roadSectionDto.getRoadId();
		List<RoadSection> roadSectionList = roadService.findRoadSectiones(criteria);
		if(roadSectionList !=null && roadSectionList.size() !=0){
			for(RoadSection roadSection : roadSectionList){
				if(roadSectionDto.getRoadSectionCode().equals(roadSection.getRoadSectionCode())){
					return flag;
				}
			}
			flag=addRoadSection(roadSectionDto);
		}else{
			flag=addRoadSection(roadSectionDto);
		}
		return flag;
	}
	//����·����Ϣ
	private int addRoadSection(RoadSectionDto roadSectionDto) throws Exception{

		RoadSection roadSection = new RoadSection();
		// ���ݻ���Id��û���Ȩ�޴���ת������Dto
		Organization org = dutyService.organizationOfId(roadSectionDto.getOrgId());
		if (org != null) {
			roadSection.setOrgPrivilegeCode(org.orgPrivilegeCode);
		}

		String beginMeter = roadSectionDto.getBeginMeterG() + "+" + roadSectionDto.getBeginMeterM();
		if (roadSectionDto.getBeginMeterM() == null) {
			roadSection.setBeginMeter(beginMeter.substring(0, beginMeter.length() - 1));
		} else {
			roadSection.setBeginMeter(beginMeter);
		}

		String endMeter = roadSectionDto.getEndMeterG() + "+" + roadSectionDto.getEndMeterM();
		if (roadSectionDto.getEndMeterM() == null) {
			roadSection.setEndMeter(endMeter.substring(0, endMeter.length() - 1));
		} else {
			roadSection.setEndMeter(endMeter);
		}
		roadSection.setEndMeter(endMeter);
		ObjectMapUtils.parseObject(roadSection, roadSectionDto);
		saveRoadSection(roadSection);
		return 1;
	}
	/**
	 * saveRoadSection(��ҳ����Ϣ���浽���ݿ�) TODO(����������������������� �C ��ѡ) TODO(�����������������ִ������ �C
	 * ��ѡ) TODO(�����������������ʹ�÷��� �C ��ѡ) TODO(�����������������ע������ �C ��ѡ)
	 *
	 * @Title: saveRoadSection @Description: TODO @param @param roadSection
	 *         �趨�ļ� @return void �������� @throws
	 */
	private void saveRoadSection(RoadSection roadSection) {

		roadService.saveRoadSection(roadSection);

	}
	/*
	 * <p>Title: searchSection</p> <p>Description:��ѯ·����Ϣ </p>
	 * 
	 * @param sectionDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ISectionAction#searchSection(cy.its.road.rest.dto
	 * .SectionDto)
	 */

	@RequestMapping("/searchRoadSection")
	@Override
	public Map<String, Object> searchRoadSection(RoadSectionDto roadSectionDto) throws Exception {
		RoadSectionCriteria roadSection = new RoadSectionCriteria();
		// ���ò�ѯҳ��
		roadSection.setPageNum(roadSectionDto.getPageNumber());
		// ����ÿҳ������¼��
		roadSection.setPageSize(roadSectionDto.getPageSize());
		// �����Ƿ���Ҫͳ������: ��
		roadSection.setNeedTotal(true);
		// ��ȡ������UI�˵���������
		roadSection.roadSectionCode = roadSectionDto.getRoadSectionCode();
		roadSection.roadSectionName = roadSectionDto.getRoadSectionName();
		roadSection.roadSectionType = roadSectionDto.getRoadSectionType();
		roadSection.roadId = roadSectionDto.getRoadId();
		roadSection.orgPrivilegeCode = roadSectionDto.getCurrentOrgPrivilegeCode();
		roadSection.setOrderName(roadSectionDto.getOrderName());
		roadSection.setOrderType(roadSectionDto.getOrderType());
		ArrayList<RoadSectionDto> lstView = new ArrayList<RoadSectionDto>();

		List<RoadSection> list = roadService.findRoadSectiones(roadSection);

		if (list != null) {
			for (RoadSection RSection : list) {
				RoadSectionDto sectionDo = new RoadSectionDto();
				if (!StringUtil.isNullOrEmpty(RSection.getRoadSectionCode())) {
					sectionDo.setRoadSectionCode(RSection.getRoadSectionCode());// ·�α��ID
				}
				if (!StringUtil.isNullOrEmpty(RSection.getRoadSectionName())) {
					sectionDo.setRoadSectionName(RSection.getRoadSectionName());// ·������
				}
				if (!StringUtil.isNullOrEmpty(RSection.getRoadSectionType())) {
					sectionDo.setRoadSectionType(RSection.getRoadSectionType());// ·������
				}
				if (!StringUtil.isNullOrEmpty(RSection.getRoadId())) {
					sectionDo.setRoadId(RSection.getRoadId());// ������·
				}
				if (RSection.getBeginMeter() != null) {
					String[] bMeter = RSection.getBeginMeter().split("\\+");
					if (bMeter.length > 0) {
						sectionDo.setBeginMeterG(bMeter[0]);
					}
					if (bMeter.length > 1) {
						sectionDo.setBeginMeterM(bMeter[1]);
					}
				}
				if (RSection.getEndMeter() != null) {
					String[] eMeter = RSection.getEndMeter().split("\\+");
					if (eMeter.length > 0) {
						sectionDo.setEndMeterG(eMeter[0]);
					}
					if (eMeter.length > 1) {
						sectionDo.setEndMeterM(eMeter[1]);
					}

				}
				sectionDo.setOldRoadSectionCode(RSection.getRoadSectionCode());
				sectionDo.setOldRoadId(RSection.getRoadId());
				ObjectMapUtils.parseObject(sectionDo, RSection);
				lstView.add(sectionDo);
			}
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "");
		Map<String, Serializable> maprow = new HashMap<String, Serializable>();
		maprow.put("rows", lstView);
		maprow.put("total", roadSection.getTotal());
		map.put("result", maprow);
		return map;

	}

	/*
	 * <p>Title: goUpdateSection</p> <p>Description:����·����Ϣ </p>
	 * 
	 * @param sectionDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ISectionAction#goUpdateSection(cy.its.road.rest.
	 * dto.SectionDto)
	 */

	@RequestMapping("/goUpdateRoadSection")
	@Override
	public int goUpdateRoadSection(RoadSectionDto roadSectionDto) throws Exception {
		int flag = 0;//·�α���ظ���ʶ:"0",��ʾ�Ѵ���;"1",��ʾ������
		if (roadSectionDto.getRoadSectionCode().equals(roadSectionDto.getOldRoadSectionCode()) &&
				roadSectionDto.getRoadId().equals(roadSectionDto.getOldRoadId())) {
			flag = updateRoadSection(roadSectionDto);
		}else{
			RoadSectionCriteria criteria = new RoadSectionCriteria();
			criteria.roadId = roadSectionDto.getRoadId();
			List<RoadSection> roadSectionList = roadService.findRoadSectiones(criteria);
			if (roadSectionList != null && roadSectionList.size() != 0) {
				for (RoadSection roadSection : roadSectionList) {
					if (roadSectionDto.getRoadSectionCode().equals(roadSection.getRoadSectionCode())) {
						return flag;
					}
				}
				flag = updateRoadSection(roadSectionDto);
			} else {
				flag = updateRoadSection(roadSectionDto);
			}
		}
		return flag;
	}
	//���һ������·�η���
	private int updateRoadSection(RoadSectionDto roadSectionDto) throws Exception {
		RoadSection roadSection = new RoadSection();
		// ���ø���ʱ��
		roadSection.setUpdateTime(new Date());
		// ���ݻ���Id��û���Ȩ�޴���ת������Dto
		Organization org = dutyService.organizationOfId(roadSectionDto.getOrgId());
		if (org != null) {
			roadSection.setOrgPrivilegeCode(org.orgPrivilegeCode);
		}
		if (!StringUtil.isNullOrEmpty(roadSectionDto.getBeginMeterM())) {
			String beginMeter = roadSectionDto.getBeginMeterG() + "+" + roadSectionDto.getBeginMeterM();
			roadSection.setBeginMeter(beginMeter);
		} else {
			roadSection.setBeginMeter(roadSectionDto.getBeginMeterG());
		}

		if (!StringUtil.isNullOrEmpty(roadSectionDto.getEndMeterM())) {
			String endMeter = roadSectionDto.getEndMeterG() + "+" + roadSectionDto.getEndMeterM();
			roadSection.setEndMeter(endMeter);
		} else {
			roadSection.setEndMeter(roadSectionDto.getEndMeterG());
		}
		// �ѿͻ��˵�Dtoת������Dto
		ObjectMapUtils.parseObject(roadSection, roadSectionDto);
		// ���·���
		updateRdSection(roadSection);
		return 1;
	}

	/**
	 * updateRoadSection(�Ѹ��µ�ҳ��·����Ϣ�������ݿ�) TODO(����������������������� �C ��ѡ)
	 * TODO(�����������������ִ������ �C ��ѡ) TODO(�����������������ʹ�÷��� �C ��ѡ) TODO(�����������������ע������ �C
	 * ��ѡ)
	 *
	 * @Title: updateRoadSection @Description: TODO
	 * @param @param
	 *            roadSection �趨�ļ� @return void �������� @throws
	 */

	private void updateRdSection(RoadSection roadSection) {
		roadService.updateRoadSection(roadSection);
	}

	/*
	 * <p>Title: goRemoveRoadSection</p> <p>Description: ����ɾ��</p>
	 * 
	 * @param sectionIdStr
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ISectionAction#goDeleteSection(java.lang.String)
	 */
	@RequestMapping("/goRemoveRoadSection")
	@Override
	public String goRemoveRoadSection(@RequestParam("ids") String ids) {
		String[] idarr = ids.split(",");

		// ͨ��Arrays.asList���ַ�������ת��ΪList<String>���϶���

		List<String> idList = Arrays.asList(idarr);

		Map<String, Object> map = new HashMap<String, Object>();

		// �����϶�����õ�HashMap��

		map.put("idList", idList);

		// ����mysqlbatisɾ���ķ���

		roadService.removeRoadSection(map);
		
		return "success";
	}

	/*
	 * <p>Title: goDeleteRoadSection</p> <p>Description: ����ɾ��</p>
	 * 
	 * @param sectionId
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.ISectionAction#goRemoveSection(java.lang.String)
	 */
	@RequestMapping("/goDeleteRoadSection")
	@Override
	public String goDeleteRoadSection(@RequestParam("roadSectionId") String roadSectionId) {
		// ɾ��·����Ϣ
		roadService.deleteRoadSection(roadSectionId);
		
		return "success";
	}
   
	// ����·��ID��ѯ������Ϣ
	@RequestMapping("/querySectionByRoadSectionId")
	@Override
	public int querySectionByRoadSectionId(String roadSectionId) throws Exception {
		// TODO Auto-generated method stub
		int sectionNum = 0;// ��·���µĶ�����
		RoadSection roadSection = roadService.roadSectionOfId(roadSectionId);
		String isOneDirection = roadSection.getIsOneDirection();
		if ("1".equals(isOneDirection)) {
			sectionNum = 1;
		} else if ("0".equals(isOneDirection)) {
			sectionNum = 2;
		} else {
			sectionNum = 2;
		}
		return sectionNum;
	}
	//����·��ID��ѯ��λ��Ϣ
	@RequestMapping("/queryBySectionRoadId")
	public int queryBySectionRoadId(String roadSectionId){
		int flag=0;
		String[] rSectionId=roadSectionId.split(",");
		for(String roadSId : rSectionId){
			SiteCriteria siteCriteria =new SiteCriteria();
			siteCriteria.roadSectionId = roadSId;
			List<Site> site= siteService.findSites(siteCriteria);
			if(site !=null){
				flag = flag + site.size();
				if(flag>0){
					return 1;
				}
			}
		}
		return flag;
	}
	
	
}
