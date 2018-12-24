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
import org.springframework.web.bind.annotation.ModelAttribute;
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
import cy.its.road.domain.criteria.CrossCriteria;
import cy.its.road.domain.criteria.RegionCriteria;
import cy.its.road.domain.criteria.RoadCriteria;
import cy.its.road.domain.criteria.RoadSectionCriteria;
import cy.its.road.domain.model.region.Region;
import cy.its.road.domain.model.road.Cross;
import cy.its.road.domain.model.road.Road;
import cy.its.road.domain.model.road.RoadSection;
import cy.its.road.domain.service.IRegionService;
import cy.its.road.domain.service.IRoadService;
import cy.its.road.rest.action.IRoadCodeAction;
import cy.its.road.rest.dto.RoadDto;
import cy.its.road.rest.dto.RoadTreeDto;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.syscfg.domain.service.ISysCodeService;

@RestController
@RequestMapping("/road/roadCode")
public class RoadCodeAction implements IRoadCodeAction {

	@Autowired
	IRoadService roadService;
	
	@Autowired
	IRegionService RegionService;
	
	@Autowired
	ISysCodeService sysCodeService;

	@Autowired
	IDutyService dutyService;
	
	@Autowired
	ISiteService siteService;

	@Autowired
	ISystemService systemService; 
	
	/**
	 * ��ȡ��·������
	 * 
	 * @return ��·������
	 * @throws Exception
	 */
	@RequestMapping("/getRoadCodeTree")
	public List<RoadTreeDto> getRoadCodeTree(String currentOrgPrivilegeCode) throws Exception {
		// �������еĵ�·��Ϣ
		RoadCriteria roadCriteria = new RoadCriteria();
		roadCriteria.setNoPage();
		roadCriteria.orgPrivilegeCode = currentOrgPrivilegeCode;
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
	private List<RoadTreeDto> convertToRoadTree(List<Code> roadTypeList, List<Road> roadList) {
		List<RoadTreeDto> types = new ArrayList<RoadTreeDto>();
		// ���ȳ�ʼ����·���
		roadTypeList.stream().forEach(item -> {
			RoadTreeDto treeRoot = new RoadTreeDto();
			treeRoot.setId(item.codeNo);
			treeRoot.setText(item.codeName);
			treeRoot.setChildren(new ArrayList<RoadTreeDto>());
			Map<String, String> attribute = new HashMap<String, String>();
			attribute.put("nodeType", "raodType");
			treeRoot.setAttribute(attribute);
			types.add(treeRoot);
		});
		if(roadList != null && !roadList.isEmpty()){
			// ����·������ӵ���Ӧ�ĵ�·���ͽڵ���
			roadList.stream().forEach(item -> {
				List<RoadTreeDto> children = findChildrenByRoadType(types, item.getRoadType());
				if (children != null) {
					RoadTreeDto treeNode = new RoadTreeDto();
					treeNode.setId(item.getRoadId());
					treeNode.setText(item.getRoadName());
					Map<String, String> attribute = new HashMap<String, String>();
					attribute.put("nodeType", "road");
					attribute.put("code", item.getRoadCode());//����
					attribute.put("orgId", item.getOrgId());//����ID
					attribute.put("orgPrivCode", item.getOrgPrivilegeCode());//����Ȩ�ޱ���
					attribute.put("districtCode", item.getDistrictCodeList());//������������
					treeNode.setAttribute(attribute);
					children.add(treeNode);
				}
			});
		}
		// ���һ��ͳһ�ĸ��ڵ�
		List<RoadTreeDto> roots = new ArrayList<RoadTreeDto>();
		RoadTreeDto root = new RoadTreeDto();
		root.setId("0");
		root.setText("��·");
		root.setChildren(types);
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("nodeType", "root");
		root.setAttribute(attribute);
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
	private List<RoadTreeDto> findChildrenByRoadType(List<RoadTreeDto> roots, String roadType) {
		Iterator<RoadTreeDto> iter = roots.iterator();
		while (iter.hasNext()) {
			RoadTreeDto item = iter.next();
			if (item.getId().equals(roadType)) {
				return item.getChildren();
			}
		}
		return null;
	}

	/**
	 * ������·��Ϣ
	 */
	@RequestMapping("/saveRoad")
	@Override
	public String createRoad(RoadDto roadDto) throws Exception {
		String flag="errorRoadCode";
		RoadCriteria roadCriteria = new RoadCriteria();
		roadCriteria.roadCode = roadDto.getRoadCode();
		List<Road> list = roadService.findRoads(roadCriteria);
		if (list == null || list.size() == 0) {
			flag = addRoad(roadDto);
		}
		return flag;
	}
		// ������·����
		private String addRoad(RoadDto roadDto) throws Exception {
		// TODO Auto-generated method stub
			Road road = new Road();
			if ((roadDto.getRoadType()).equals("5") || roadDto.getRoadType().equals("6")
					|| roadDto.getRoadType().equals("7") || roadDto.getRoadType().equals("8")) {

				road.setDirectionType(roadDto.getDirectionTypeCity());
			} else if (roadDto.getNoDirectionTypeCity().equals("0")) {
				road.setDirectionType("1" + "," + "2");
			} else {
				road.setDirectionType(roadDto.getNoDirectionTypeCity());
			}

			if (!StringUtil.isNullOrEmpty(roadDto.getRoadLength())) {
				road.setRoadLength(Double.parseDouble(roadDto.getRoadLength()));
			}
			// ���ݻ���Id��û���Ȩ�޴���ת������Dto
			if (!StringUtil.isNullOrEmpty(roadDto.getOrgId())) {
				String[] orgId = roadDto.getOrgId().split(",");
				StringBuilder strBuilder = new StringBuilder();
				for (int i = 0; i < orgId.length; i++) {
					Organization org = dutyService.organizationOfId(orgId[i]);
					if (org != null) {
						strBuilder.append(org.orgPrivilegeCode).append(",");
					}
				}

				road.setOrgPrivilegeCode(strBuilder.substring(0, strBuilder.length() - 1));
			}
			// �ͻ���Dtoת������Dto
			ObjectMapUtils.parseObject(road, roadDto);
			roadService.roadChanged();
			return saveRoad(road);
		}
	/**
	 * saveRoad(������·��Ϣ) TODO(����������������������� �C ��ѡ) TODO(�����������������ִ������ �C��ѡ)
	 * TODO(�����������������ʹ�÷��� �C ��ѡ) TODO(�����������������ע������ �C ��ѡ) @Title:
	 * saveRoad @Description: TODO @param @param road �趨�ļ� @return void
	 * �������� @throws
	 */
	private String saveRoad(Road road) {
		return roadService.saveRoad(road);

	}

	/*
	 * <p>Title: searchRoad</p> <p>Description:��ѯ���� </p>
	 * 
	 * @param roadDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.IRoadCodeAction#searchRoad(cy.its.road.rest.dto.
	 * RoadDto)
	 */

	@RequestMapping("/searchRoadList")
	@Override
	public Map<String, Object> searchRoad(RoadDto roadDto) throws Exception {

		RoadCriteria roadCriteria = new RoadCriteria();
		// ���ò�ѯҳ��
		roadCriteria.setPageNum(roadDto.getPageNumber());
		// ����ÿҳ������¼��
		roadCriteria.setPageSize(roadDto.getPageSize());
		// �����Ƿ���Ҫͳ������: ��
		roadCriteria.setNeedTotal(true);
		// ��ȡ������UI�˵���������
		roadCriteria.roadCode = roadDto.getRoadCode();
		roadCriteria.roadName=roadDto.getRoadName();
		roadCriteria.roadType = roadDto.getRoadType();
		roadCriteria.districtCode = roadDto.getDistrictCode();
		roadCriteria.orgPrivilegeCode = roadDto.getCurrentOrgPrivilegeCode();
		roadCriteria.setOrderName(roadDto.getOrderName());
		roadCriteria.setOrderType(roadDto.getOrderType());
		// ����ҳ��lstView����
		ArrayList<RoadDto> lstView = new ArrayList<RoadDto>();
		// ���list����
		List<Road> list = roadService.findRoads(roadCriteria);

		if (list != null) {
			for (Road road : list) {
				RoadDto roadDo = new RoadDto();
				// ����roadType�ж�;����������("070","072")��ֵ
				if (road.getRoadType().equals("5") || road.getRoadType().equals("6") || road.getRoadType().equals("7")
						|| road.getRoadType().equals("8")) {

					roadDo.setDirectionTypeCity(road.getDirectionType());

				} else {
					if (!StringUtil.isNullOrEmpty(road.getDirectionType())) {
						if (road.getDirectionType().equals("1,2")) {

							roadDo.setNoDirectionTypeCity("0");

						} else {
							roadDo.setNoDirectionTypeCity(road.getDirectionType());
						}
					}
				}
				if (road.getRoadLength() != null) {
					roadDo.setRoadLength(road.getRoadLength().toString());
				}
				if (!StringUtil.isNullOrEmpty(road.getRoadCode())) {
					roadDo.setRoadCode(road.getRoadCode());// ��·���ID
				}
				if (!StringUtil.isNullOrEmpty(road.getRoadName())) {
					roadDo.setRoadName(road.getRoadName());// ��·����
				}
				if (!StringUtil.isNullOrEmpty(road.getRoadType())) {
					roadDo.setRoadType(road.getRoadType());// ��·����
				}
				if (!StringUtil.isNullOrEmpty(road.getDistrictCodeList())) {
					roadDo.setDistrictCode(road.getDistrictCodeList());// ��������
				}
				if (!StringUtil.isNullOrEmpty(road.getOrgId())) {
					String[] orgId = road.getOrgId().split(",");
					for (int i = 0; i < orgId.length; i++) {
						roadDo.setOrgPrivilegeCode(orgId[i]);
					}
				}
				roadDo.setOldRoadCode(road.getRoadCode());
				ObjectMapUtils.parseObject(roadDo, road);
				// ��ÿһ�α���Road������ӵ�lstView
				lstView.add(roadDo);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("error", "");
		Map<String, Serializable> maprow = new HashMap<String, Serializable>();
		maprow.put("rows", lstView);
		maprow.put("total", roadCriteria.getTotal());
		map.put("result", maprow);

		return map;
	}

	/*
	 * <p>Title: updateRoad</p> <p>Description:���µ�·��Ϣ </p>
	 * 
	 * @param road
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.road.rest.action.IRoadCodeAction#updateRoad(cy.its.road.rest.dto.
	 * RoadDto)
	 */
	@RequestMapping("/updateRoad")
	@Override
	public int goUpdateRoad(@ModelAttribute(value = "roadId") RoadDto roadDto) throws Exception {
		int flag=0;
		if(roadDto.getRoadCode().equals(roadDto.getOldRoadCode())){
			flag = updateRoadMessager(roadDto);
		}else{
			RoadCriteria roadCriteria = new RoadCriteria();
			roadCriteria.roadCode = roadDto.getRoadCode();
			List<Road> list = roadService.findRoads(roadCriteria);
			if (list == null || list.size() == 0) {
				flag = updateRoadMessager(roadDto);
			}else{
				return flag;
			}
		}
		return flag;
	}
		
		private int updateRoadMessager(RoadDto roadDto) throws Exception {
			// TODO Auto-generated method stub
			// ������·����
			Road road = new Road();
			// ���ø���ʱ��
			road.setUpdateTime(new Date());
			// �ͻ���Dtoת������ Dto
			// ���ݵ�·�����жϣ��ֱ�ֵ����������
			if (roadDto.getRoadType().equals("5") || roadDto.getRoadType().equals("6") || roadDto.getRoadType().equals("7")
					|| roadDto.getRoadType().equals("8")) {

				road.setDirectionType(roadDto.getDirectionTypeCity());
			} else if (roadDto.getNoDirectionTypeCity().equals("0")) {
				road.setDirectionType("1" + "," + "2");
			} else {
				road.setDirectionType(roadDto.getNoDirectionTypeCity());
			}
			if (!StringUtil.isNullOrEmpty(roadDto.getRoadLength())) {
				road.setRoadLength(Double.parseDouble(roadDto.getRoadLength()));
			}
			// ���ݻ���Id��û���Ȩ�޴���ת������Dto
			if (!StringUtil.isNullOrEmpty(roadDto.getOrgId())) {
				String[] orgId = roadDto.getOrgId().split(",");
				StringBuilder strBuilder = new StringBuilder();
				for (int i = 0; i < orgId.length; i++) {
					Organization org = dutyService.organizationOfId(orgId[i]);
					if (org != null) {
						strBuilder.append(org.orgPrivilegeCode).append(",");
					}
				}
				road.setOrgPrivilegeCode(strBuilder.substring(0, strBuilder.length() - 1));
			}
			ObjectMapUtils.parseObject(road, roadDto);

			updateRoad(road);// ���ø��·���

			roadService.roadChanged();// ���֪ͨ

			return 1;

		}
		/**
		 * updateRoad(���µ�·��Ϣ) TODO(����������������������� �C ��ѡ) TODO(�����������������ִ������ �C ��ѡ)
		 * TODO(�����������������ʹ�÷��� �C ��ѡ) TODO(�����������������ע������ �C ��ѡ) @Title:
		 * updateRoad @Description: TODO @param @param road �趨�ļ� @return void
		 * �������� @throws
		 */

		private void updateRoad(Road road) {
			roadService.updateRoad(road);
		}
	
			
	/*
	 * <p>Title: deleteRoad</p> <p>Description: ����ɾ��</p>
	 * 
	 * @param roadIdStr
	 * 
	 * @return
	 * 
	 * @see cy.its.road.rest.action.IRoadCodeAction#deleteRoad(java.lang.String)
	 */
	@RequestMapping("/goDeleteRoad")
	@Override
	public String goDeleteRoad(String roadId) {

			// ɾ����·��Ϣ
			roadService.deleteRoad(roadId);
			// ���֪ͨ
			roadService.roadChanged();

		return "success";
	}

	/*
	 * <p>Title: removeRoad</p> <p>Description: ����ɾ��</p>
	 * 
	 * @param roadId
	 * 
	 * @return
	 * 
	 * @see cy.its.road.rest.action.IRoadCodeAction#removeRoad(java.lang.String)
	 */
	@RequestMapping("/goRemoveRoad")
	public  String goRemoveRoad(String ids) {
		  
		String[] idarr = ids.split(",");

		//ͨ��Arrays.asList���ַ�������ת��ΪList<String>���϶���

		List<String> idList = Arrays.asList(idarr);

		Map<String,Object> map = new HashMap<String,Object>();

		//�����϶�����õ�HashMap��

		map.put("idList", idList);

		//����mysqlbatisɾ������

		roadService.removeRoad(map);
		// ���֪ͨ
		roadService.roadChanged();
		
		return "success";

	}

	/**
	 * ���ݵ�·ID��ѯ�õ�·�Ƿ���ͨ������Ӷ���
	 * 
	 * @throws Exception
	 */
	@Override
	@RequestMapping("/querySectionByRoadId")
	public int querySectionByRoadId(@RequestParam("roadId") String roadId) throws Exception {
		// TODO Auto-generated method stub
		int sectionNum = 0;// �õ�·�µĶ�����
		Road road = roadService.roadOfId(roadId);
		String isOneDirection = road.getIsOneDirection();
		if ("1".equals(isOneDirection)) {
			sectionNum = 1;
		} else if ("0".equals(isOneDirection)) {
			sectionNum = 2;
		} else {
			sectionNum = 2;
		}
		return sectionNum;
	}
	
	/**
	 * ����roadId��directionType��ѯ��������
	 * @param roadId
	 * @param directionType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryDirectionNameByRoadId")
	public String queryDirectionNameByRoadId(String roadId,String directionType) throws Exception{
		String directionName = null;
		Road road = roadService.roadOfId(roadId);
		
		if(roadId != null && directionType !=null){
			if("1".equals(directionType)){
				directionName = road.getUpDirection();
			}else{
				directionName = road.getUpDirection();
			}
		}
		System.out.println(directionName);
		return directionName;
	}
	
	/**
	 * ���ݵ�·ID��ѯ�豸�����˵�·�ϵĵ�λ�Ƿ��Ѱ��豸�������Ѱ�·��
	 * @param roadId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/queryByRoadId")
	public int queryByRoadId(@RequestParam("roadId") String roadId){
		int flag = 0;
		String[] rId=roadId.split(","); 
		for(String id : rId){
			//���ݵ�·��ѯ��λ��Ϣ
			SiteCriteria siteCriteria = new SiteCriteria();
			siteCriteria.roadId = id;
			List<Site> site = siteService.findSites(siteCriteria);
			if (site != null) {
				if (site != null) {
					flag = flag + site.size();
					if (flag > 0) {
						return 1;
					}
				}
			}
			//�ж�·���Ƿ�󶨵�·
			RoadSectionCriteria criteria = new RoadSectionCriteria();
			criteria.roadId = id;
			List<RoadSection> roadSectionList = roadService.findRoadSectiones(criteria);
			if (roadSectionList != null) {
				flag = flag + roadSectionList.size();
				if (flag > 0) {
					return 2;
				}
			}
		}
		return flag;
	}
	
	/**
	 * ����roadId��ȡ��·��Ϣ
	 */
	@RequestMapping("/queryRoadInfoById")
	public RoadDto queryRoadInfoById(@RequestParam("roadId") String roadId) throws Exception{
		Road road = roadService.roadOfId(roadId);
		RoadDto roadDto = new RoadDto();
		ObjectMapUtils.parseObject(roadDto, road);
		return roadDto;
	}

}
