package cy.its.video.rest.action.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cy.its.com.util.StringUtil;
import cy.its.device.domain.criteria.SystemCriteria;
import cy.its.device.domain.model.Server;
import cy.its.device.domain.model.ServerApplication;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.model.SysComponent;
import cy.its.device.domain.model.Video;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.device.domain.service.ISurveySystemService;
import cy.its.device.domain.service.ISystemAttachService;
import cy.its.device.domain.service.ISystemService;
import cy.its.road.domain.criteria.RoadCriteria;
import cy.its.road.domain.model.road.Road;
import cy.its.road.domain.service.IRoadService;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.syscfg.domain.service.ISysCodeService;
import cy.its.video.domain.criteria.TrafficVideoGroupCriteria;
import cy.its.video.domain.model.TrafficVideoGroup;
import cy.its.video.domain.service.IVideoCruiseService;
import cy.its.video.rest.dto.TrafficPlanVideoDto;
import cy.its.video.rest.dto.easyUITree;

/**
 * @author jinhb
 *
 */
@RestController
@RequestMapping("/video/videoPlay")
public class VideoPlayAction {

	@Autowired
	ISysCodeService sysCodeService;

	@Autowired
	IRoadService roadService;

	@Autowired
	ISystemService systemService;

	@Autowired
	ISystemAttachService systemAttachService;

	@Autowired
	ISurveySystemService iSurveySystemService;

	@Autowired
	IDutyService dutyService;

	@Autowired
	ISiteService siteService;

	@Autowired
	IVideoCruiseService videoCruiseService;

	private String deviceTypeVideoSysCodeNo = "03";// �豸���� ����Ƶ��ϵͳ���ʹ��룺400

	// private String iconClsOrg = "icon-org";// ������ʽ
	// private String iconClsSite = "icon-site";// ��λ

	@RequestMapping("/getVideoDeviceTrees")
	public List<easyUITree> getVideoDeviceTrees(HttpServletRequest request) throws Exception {
		String type = request.getParameter("type");
		String nodeIDType = request.getParameter("nodeIDType");// �ڵ�id���ͣ�deviceID,deviceSysNbr,����������Ҫ��չ
		String currentOrgPrivilegeCode = request.getParameter("currentOrgPrivilegeCode");
		String currentOrgId = request.getParameter("currentOrgId");
		// ע������isDomeGun��ֵ����ֵ�߼��ǲ�ͬ�ġ������ǹ��ֻ������Ƶ�豸�����ֻ���������Ϊ��ʱ�����豸�������������豸�������
		String isDomeGun = request.getParameter("isDomeGun");
		List<easyUITree> trees = new ArrayList<>();

		if ("orgTree".equals(type)) {
			// ����ͷ���ڵ�
			Organization rootOrg = dutyService.organizationOfId(currentOrgId);
			easyUITree rootTree = convertToTreeDto(rootOrg);
			List<Sys> lstSys = getVideoSys(currentOrgPrivilegeCode, null);
			List<easyUITree> trees2 = GenerateOrgDeviceTree(rootOrg, lstSys, isDomeGun,
					currentOrgPrivilegeCode.length() + 2);
			if (trees2.size() > 0) {
				rootTree.setChildren(trees2);
				trees.add(rootTree);
			}
		} else if ("roadTree".equals(type)) {
			// trees = GenerateRoadDeviceTree();
			// ����ͷ���ڵ�
			trees = GenerateRoadDeviceTree(nodeIDType, isDomeGun, currentOrgPrivilegeCode);
			// easyUITree rootTree = new easyUITree();
			// rootTree.setText("��·");
			// rootTree.setState("closed");
			// Map<String, String> attribute1 = new HashMap<String,
			// String>();
			// attribute1.put("nodeType", "road");
			// rootTree.setAttribute(attribute1);
			// rootTree.setChildren();
			// trees.add(rootTree);
		} else if ("userGroupTree".equals(type)) {
			// ����ͷ���ڵ�
			easyUITree rootTree = new easyUITree();
			rootTree.setText("�û��Զ����豸��");
			rootTree.setState("expanded");
			Map<String, String> attribute1 = new HashMap<String, String>();
			attribute1.put("nodeType", "road");
			rootTree.setAttribute(attribute1);
			rootTree.setChildren(GenerateUserDefineGroupTree(currentOrgPrivilegeCode, isDomeGun));
			trees.add(rootTree);

		} else {
			// TODO
		}

		return trees;
	}

	@RequestMapping("/getVideoByIds")
	public List<TrafficPlanVideoDto> getVideoByIds(HttpServletRequest request) throws Exception {
		List<TrafficPlanVideoDto> returnList = new ArrayList<>();
		String deviceIds = request.getParameter("deviceIds");

		if (!StringUtil.isNullOrEmpty(deviceIds)) {
			List<String> ids = JSON.parseArray(deviceIds, String.class);
			if (ids != null && ids.size() > 0) {
				for (String deviceId : ids) {

					Sys sys = systemService.systemOfId(deviceId);
					if (sys != null) {
						// ���豸�����ȡ����ֵ
						// ���CameraServerTypeIp
						List<ServerApplication> g1 = iSurveySystemService.serverAppsOfServerPlat(sys.getServerPlatId());
						String cameraServerTypeIp = null;
						if (g1 != null) {
							for (ServerApplication serverApp : g1) {
								if ("8".equals(serverApp.getAppType())) {// 436
									// 8
									Server t1 = iSurveySystemService.serverOfId(serverApp.getServerId()); // ��Ƶweb������
									cameraServerTypeIp = t1.getServerIp();
								}
							}
						}

						// ��ȡvideo������ص�ֵ
						if (sys.getDeviceType().equals(deviceTypeVideoSysCodeNo)) {
							TrafficPlanVideoDto dto = new TrafficPlanVideoDto();
							dto.setDeviceId(sys.getDeviceId());
							dto.setDeviceSysNbr(sys.getDeviceSysNbr());
							dto.setVideoDeviceName(sys.getDeviceName());
							dto.setCameraServerTypeIp(cameraServerTypeIp);
							Video video = systemService.videoOfId(sys.getDeviceId());
							if (video != null) {
								dto.setVideoAccessMode(video.getVideoAccessMode());
								dto.setPreViewParam(video.getPreviewParam());
								dto.setPlayBackParam(video.getPlaybackParam());
							}
							returnList.add(dto);
						} else {
							List<SysComponent> componentLst = systemAttachService.componentsOfSystem(sys.getDeviceId())
									.stream().filter(com -> {
										return com.getIsVideoSupport() != null
												&& com.getIsVideoSupport().trim().equals("1");
									}).collect(Collectors.toList());

							for (SysComponent sysComponent : componentLst) {
								TrafficPlanVideoDto dto = new TrafficPlanVideoDto();
								dto.setDeviceId(sys.getDeviceId());
								dto.setDeviceSysNbr(sys.getDeviceSysNbr());
								dto.setCameraServerTypeIp(cameraServerTypeIp);
								dto.setVideoDeviceName(sysComponent.getComponentName());
								dto.setVideoAccessMode(sysComponent.getVideoAccessMode());
								dto.setPreViewParam(sysComponent.getPreviewParam());
								dto.setPlayBackParam(sysComponent.getPlaybackParam());
								returnList.add(dto);
							}
						}
					}
				}

			}

		}
		return returnList;
	}

	@RequestMapping("/getVideoByVideoComponentIds")
	public List<easyUITree> getVideoByVideoComponentIds(HttpServletRequest request) throws Exception {
		List<easyUITree> returnList = new ArrayList<>();
		String videoComponentIds = request.getParameter("VideoComponentIds");

		String[] ids = videoComponentIds.split(",");
		if (ids != null && ids.length > 0) {
			for (String videoComponentId : ids) {
				String[] videoComponent = videoComponentId.split("\\|");
				String deviceId = videoComponent[0].substring(1);
				String componentId = videoComponent[1].substring(0, videoComponent[1].length() - 1);
				Sys sys = systemService.systemOfId(deviceId);
				if (sys != null) {
					// ��ȡvideo������ص�ֵ
					if (StringUtil.isNullOrEmpty(componentId)) {
						Video video = systemService.videoOfId(sys.getDeviceId());
						if(video!=null){
							returnList.add(convertToTreeDto(sys, video, null));	
						}						
					} else {
						SysComponent sysComponent = systemAttachService.componentOfId(componentId);
						if(sysComponent!=null){
							returnList.add(convertToTreeDto(sys, null, sysComponent));	
						}						
					}
				}
			}
		}
		return returnList;
	}

	/**
	 * ��ȡ��Ƶ�豸
	 * 
	 * @param previlegeCode
	 * @return
	 */
	private List<Sys> getVideoSys(String previlegeCode, String roadId) {
		SystemCriteria criteria = new SystemCriteria();
		// criteria.deviceType = deviceTypeVideoSysCodeNo;
		criteria.orgPrivilegeCode = previlegeCode;
		criteria.isSupportVideoOrNot = "1";
		if (!StringUtil.isNullOrEmpty(roadId)) {
			criteria.roadId = roadId;
		}
		criteria.useStatusFlag = "1";
		criteria.setPageNum(1);
		criteria.setPageSize(Integer.MAX_VALUE);
		criteria.setOrderName("siteCode");
		criteria.setOrderType("ASC");
		return systemService.findSys(criteria);
	}

	/**
	 * ���ݻ���Ȩ�ޱ��룬ת�����ṹ
	 * 
	 * @param parentOrg
	 *            ������
	 * @param videoLst
	 *            ��Ƶ�豸�б�
	 * @param orgList
	 *            �����б�
	 * @param length
	 *            Ȩ�޴��볤��
	 * @return
	 */
	private List<easyUITree> GenerateOrgDeviceTree(Organization parentOrg, List<Sys> videoLst, String domeGun,
			int length) {
		List<easyUITree> OrgTrees = new ArrayList<easyUITree>();
		List<Organization> childOrgs;
		try {
			childOrgs = dutyService.findOrgsOfParent(parentOrg.getIdentityId());

			// �������豸�����ڵ�
			for (int index = 0; index < childOrgs.size(); index++) {
				Organization childOrg = childOrgs.get(index);
				if (childOrg.orgPrivilegeCode.startsWith(parentOrg.orgPrivilegeCode)
						&& childOrg.orgPrivilegeCode.length() == length) {
					childOrgs.remove(index--);
					// �ݹ������ӻ������
					List<easyUITree> childrenTrees = GenerateOrgDeviceTree(childOrg, videoLst, domeGun, length + 2);
					if (childrenTrees.size() > 0) {
						easyUITree orgTree = convertToTreeDto(childOrg);
						orgTree.setChildren(childrenTrees);
						OrgTrees.add(orgTree);
					}
				}
			}
			// ���ɵ�ǰֱ����Ƶ�豸�ڵ�
			if (videoLst.size() > 0) {
				for (int j = 0; j < videoLst.size(); j++) {
					Sys sys = videoLst.get(j);
					if (sys.getOrgId().equals(parentOrg.getIdentityId())) {
						videoLst.remove(j--);
						if (sys.getDeviceId().equals("462038d8c44e42cda2ec93c5c40de96e")) {
							System.out.println(sys.getDeviceBrand());
						}
						if (!StringUtil.isNullOrEmpty(domeGun)) {
							if (domeGun.contains("1") || domeGun.contains("2")) {// �����ǹ��ֻ������Ƶ�豸
								Video video = systemService.videoOfId(sys.getDeviceId());
								if (video != null && domeGun.contains(video.getDomeGunlock())) {
									easyUITree videoTree = convertToTreeDto(sys, video, null);
									OrgTrees.add(videoTree);
								}
							}
							if (domeGun.contains("3")) {// ���
								List<SysComponent> componentLst = systemAttachService
										.componentsOfSystem(sys.getDeviceId()).stream().filter(com -> {
											return com.getIsVideoSupport() != null
													&& com.getIsVideoSupport().trim().equals("1");
										}).collect(Collectors.toList());

								for (SysComponent sysComponent : componentLst) {
									easyUITree componentTree = convertToTreeDto(sys, null, sysComponent);
									OrgTrees.add(componentTree);
								}
							}
						} else {
							if (sys.getDeviceType() != null && sys.getDeviceType().equals(deviceTypeVideoSysCodeNo)) {

								Video video = systemService.videoOfId(sys.getDeviceId());
								easyUITree videoTree = convertToTreeDto(sys, video, null);
								OrgTrees.add(videoTree);
							} else {
								List<SysComponent> componentLst = systemAttachService
										.componentsOfSystem(sys.getDeviceId()).stream().filter(com -> {
											return com.getIsVideoSupport() != null
													&& com.getIsVideoSupport().trim().equals("1");
										}).collect(Collectors.toList());

								for (SysComponent sysComponent : componentLst) {
									easyUITree componentTree = convertToTreeDto(sys, null, sysComponent);
									OrgTrees.add(componentTree);
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OrgTrees;
	}

	/**
	 * ��ʼ����·����Ϣ
	 * 
	 * @throws Exception
	 */
	private List<easyUITree> GenerateUserDefineGroupTree(String orgAuthorityCode, String domeGun) throws Exception {
		List<easyUITree> trees = new ArrayList();
		// �����û��豸��
		TrafficVideoGroupCriteria criteria = new TrafficVideoGroupCriteria();
		criteria.setOrgAuthorityCode(orgAuthorityCode);
		List<TrafficVideoGroup> videoGroups = videoCruiseService.getVideoGroupByCondition(criteria);
		if (videoGroups != null && videoGroups.size() > 0) {
			for (TrafficVideoGroup videoGroup : videoGroups) {
				// �����û������������豸��
				easyUITree groupTree = convertToTreeDto(videoGroup);
				List<easyUITree> deviceTrees = new ArrayList();
				if (!StringUtil.isNullOrEmpty(videoGroup.getGroupContent())) {
					String[] videoComponentIds = videoGroup.getGroupContent().split(",");
					for (String videoComponentId : videoComponentIds) {
						String[] ids = videoComponentId.split("\\|");
						String deviceID = ids[0].substring(1);
						String sysComponentId = ids[1].substring(0, ids[1].length() - 1);
						Sys sys = systemService.systemOfId(deviceID);
						if (sys == null) {
							continue;
						}
						if (StringUtil.isNullOrEmpty(sysComponentId)) {// ��Ƶ���豸
							Video video = systemService.videoOfId(deviceID);
							if(video!=null){								
								if (!StringUtil.isNullOrEmpty(domeGun)) {
									if (!domeGun.contains("3")) {// �����ǹ�����Ͳ�����
										if (video == null || video.getDomeGunlock() == null
												|| !domeGun.contains(video.getDomeGunlock())) {
											continue;
										}
									} else {// ���
										continue;
									}
								}
								easyUITree videoTree = convertToTreeDto(sys, video, null);
								deviceTrees.add(videoTree);
							}
						} else {// �������Ƶ
							// ���������ǹ��ʱֱ�ӹ���
							if (!StringUtil.isNullOrEmpty(domeGun) && !domeGun.contains("3")) {
								continue;
							}
							SysComponent sysComponent = systemAttachService.componentOfId(sysComponentId);
							if(sysComponent!=null){								
								easyUITree componentTree = convertToTreeDto(sys, null, sysComponent);
								deviceTrees.add(componentTree);
							}
						}
					}
				}
				if (deviceTrees.size() > 0) {
					groupTree.setChildren(deviceTrees);
					trees.add(groupTree);
				}
			}
		}
		return trees;
	}

	/**
	 * 
	 * 
	 * @throws Exception
	 */

	/**
	 * ��ʼ����·����Ϣ
	 * 
	 * @param nodeIDType
	 *            �ڵ�id���ͣ�deviceID,deviceSysNbr
	 * @return
	 * @throws Exception
	 */
	private List<easyUITree> GenerateRoadDeviceTree(String nodeIDType, String domeGun, String previlegeCode)
			throws Exception {
		// �������еĵ�·��Ϣ
		RoadCriteria roadCriteria = new RoadCriteria();
		roadCriteria.setNoPage();
		List<Road> roadList = roadService.findRoads(roadCriteria);
		// ��õ�·���ͱ���
		List<Code> roadTypeList = sysCodeService.codeListOfType("016");
		List<easyUITree> roadDeviceTrees = new ArrayList<>();
		// ���ȳ�ʼ����·���
		for (Code roadTypeCode : roadTypeList) {
			easyUITree roadTypeTree = convertToTreeDto(roadTypeCode);

			// ���ɵ�·�����µ�·�ڵ�
			List<Road> childRoads = roadList.stream().filter(road -> {
				return road.getRoadType().equals(roadTypeCode.codeNo);
			}).collect(Collectors.toList());
			if (childRoads != null) {
				List<easyUITree> roadTrees = new ArrayList<>();
				childRoads.forEach(road -> {
					easyUITree roadTree = convertToTreeDto(road);
					List<easyUITree> siteTrees = getDeviceInRoadByRootId(road.getRoadId(), previlegeCode, domeGun,
							nodeIDType);
					// �����е�λ�ӽ��ʱ�Ž��м���
					if (siteTrees.size() > 0) {
						roadTree.setChildren(siteTrees);
						roadTrees.add(roadTree);
					}
				});
				if (roadTrees.size() > 0) {
					roadTypeTree.setChildren(roadTrees);
					roadDeviceTrees.add(roadTypeTree);
				}
			}
		}
		// ����û�е�·���豸�ڵ�
		// ���һ��ͳһ�ĸ��ڵ�//TODO
		return roadDeviceTrees;
	}

	/**
	 * ���ݵ�·ID����ȡ��λ��Ϣ�����µ���Ƶtree
	 * 
	 * @param roadId
	 * @return
	 */
	private List<easyUITree> getDeviceInRoadByRootId(String roadId, String previlegeCode, String domeGun,
			String nodeIDType) {
		List<easyUITree> videoTrees = new ArrayList<easyUITree>();
		List<Sys> lstSys = getVideoSys(previlegeCode, roadId);
		// if (roadId.equals("70277")) {
		// if (roadId == "70277") {
		// System.out.println("dd");
		// } 
		// ������Ƶ�豸�����ɽڵ�
		// ������Ƶ�豸
		for (int j = 0; j < lstSys.size(); j++) {
			Sys sys = lstSys.get(j);
			if (!StringUtil.isNullOrEmpty(domeGun)) {
				if (domeGun.contains("1") || domeGun.contains("2")) {// �����ǹ��ֻ������Ƶ�豸
					Video video = systemService.videoOfId(sys.getDeviceId());
					if (video != null && domeGun.contains(video.getDomeGunlock())) { 
						easyUITree videoTree = convertToTreeDto(sys, video, null);
						videoTrees.add(videoTree);
					}
				}
				if (domeGun.contains("3")) {// ���
					List<SysComponent> componentLst = systemAttachService.componentsOfSystem(sys.getDeviceId()).stream()
							.filter(com -> {
								return com.getIsVideoSupport() != null && com.getIsVideoSupport().trim().equals("1");
							}).collect(Collectors.toList());

					for (SysComponent sysComponent : componentLst) {
						easyUITree componentTree = convertToTreeDto(sys, null, sysComponent);
						videoTrees.add(componentTree);
					}
				}
			} else {
				// ��Ƶ�豸ȡ��Ƶ������������ȡ�����
				if (sys.getDeviceType() != null && sys.getDeviceType().equals(deviceTypeVideoSysCodeNo)) {

					Video video = systemService.videoOfId(sys.getDeviceId());
					easyUITree videoTree = convertToTreeDto(sys, video, null);
					videoTrees.add(videoTree);
				} else {
					List<SysComponent> componentLst = systemAttachService.componentsOfSystem(sys.getDeviceId()).stream()
							.filter(com -> {
								return com.getIsVideoSupport() != null && com.getIsVideoSupport().trim().equals("1");
							}).collect(Collectors.toList());

					for (SysComponent sysComponent : componentLst) {
						easyUITree componentTree = convertToTreeDto(sys, null, sysComponent);
						videoTrees.add(componentTree);
					}
				}
			}
		}
//		if(videoTrees.size()>0){
//			Collections.sort(videoTrees, new Comparator<easyUITree>() {
//				public int compare(easyUITree o1, easyUITree o2) {					
//					int code1=(null==o1.getAttribute().get("siteCode"))?9999:Integer.parseInt(o1.getAttribute().get("siteCode"));
//					int code2=(null==o2.getAttribute().get("siteCode"))?9999:Integer.parseInt(o2.getAttribute().get("siteCode"));
//					return code1 - code2;						
//				}
//			});
//		}
		return videoTrees;
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
	private List<easyUITree> findChildrenByRoadType(List<easyUITree> roots, String roadType) {
		Iterator<easyUITree> iter = roots.iterator();
		while (iter.hasNext()) {
			easyUITree item = iter.next();
			if (item.getId().equals(roadType)) {
				return item.getChildren();
			}
		}
		return null;
	}

	/**
	 * ����������ת��easyUITree
	 * 
	 * @param org
	 * @return
	 */
	private easyUITree convertToTreeDto(Code code) {
		easyUITree dto = new easyUITree();
		dto.setId(code.getIdentityId());
		dto.setText(code.codeName);
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("nodeType", "roadType");
		dto.setAttribute(attribute);
		return dto;
	}

	/**
	 * ����������ת��easyUITree
	 * 
	 * @param org
	 * @return
	 */
	private easyUITree convertToTreeDto(Organization org) {
		easyUITree dto = new easyUITree();
		dto.setId(org.getIdentityId());
		dto.setText(org.orgName);
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("code", org.orgCode);
		attribute.put("nodeType", "org");
		dto.setAttribute(attribute);
		return dto;
	}

	/**
	 * ���û������ת��easyUITree
	 * 
	 * @param org
	 * @return
	 */
	private easyUITree convertToTreeDto(TrafficVideoGroup videoGroup) {
		easyUITree dto = new easyUITree();
		dto.setId(videoGroup.getGroupId());
		dto.setText(videoGroup.getGroupName());
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("orgCode", videoGroup.getOrgAuthorityCode());
		attribute.put("nodeType", "deviceGroup");
		attribute.put("groupContent", videoGroup.getGroupContent());
		dto.setAttribute(attribute);
		return dto;
	}

	/**
	 * ���豸����ת��easyUITree
	 * 
	 * @param org
	 * @return
	 */
	private easyUITree convertToTreeDto(Sys sys, Video video, SysComponent sysComponent) {
		easyUITree sysTree = new easyUITree();
		try {
			if (video != null) {
				sysTree.setText(sys.getDeviceName());
			} else {
				sysTree.setText(sysComponent.getComponentName());
			}
			Map<String, String> attribute = new HashMap<String, String>();
			attribute.put("deviceSysNbr", sys.getDeviceSysNbr());
			attribute.put("ip", sys.getDeviceIp());

			String cameraServerTypeIp = "";
			if (!StringUtil.isNullOrEmpty(sys.getServerPlatId())) {
				List<ServerApplication> g1 = iSurveySystemService.serverAppsOfServerPlat(sys.getServerPlatId());
				for (ServerApplication serverApp : g1) {
					// ��Ƶweb������
					if ("8".equals(serverApp.getAppType())) {// 436
						// 8
						Server server = iSurveySystemService.serverOfId(serverApp.getServerId());
						cameraServerTypeIp = server.getServerIp();
					}
				}
			}
			attribute.put("cameraServerTypeIp", cameraServerTypeIp);// ��ط�����ip

			attribute.put("deviceType", sys.getDeviceType());
			attribute.put("deviceId", sys.getDeviceId());
			Site site=siteService.siteOfId(sys.getSiteId());
			if (video != null) {
				sysTree.setId(sys.getDeviceId());
				String statusType = StringUtil.isNullOrEmpty(sys.getStatusType()) ? "1" : sys.getStatusType();
				sysTree.setIconCls("icon-03-" + statusType);
				attribute.put("nodeType", "video");
				attribute.put("statusType", sys.getStatusType());
				attribute.put("videoAccessMode", video.getVideoAccessMode());
				attribute.put("preViewParam", video.getPreviewParam());
				attribute.put("playBackParam", video.getPlaybackParam());
				attribute.put("domeGun", video.getDomeGunlock());
				if(site!=null){
					attribute.put("siteCode", site.getSiteCode());	
				}
				else{
					attribute.put("siteCode", "-1");
				}
			} else { // Ĭ��video �����������һ����Ϊ��
				String onlineStatus = StringUtil.isNullOrEmpty(sysComponent.getOnlineStatus()) ? "1"
						: sysComponent.getOnlineStatus();
				sysTree.setIconCls("icon-component-" + onlineStatus);
				sysTree.setId(sys.getDeviceId() + sysComponent.getSysComponentId());
				attribute.put("nodeType", "component");
				attribute.put("sysComponentId", sysComponent.getSysComponentId());
				attribute.put("statusType", sysComponent.getOnlineStatus());
				attribute.put("videoAccessMode", sysComponent.getVideoAccessMode());
				attribute.put("preViewParam", sysComponent.getPreviewParam());
				attribute.put("playBackParam", sysComponent.getPlaybackParam());
				attribute.put("siteCode", "-1");
			}
			sysTree.setAttribute(attribute);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sysTree;
	}

	/**
	 * ��ϵͳ�������ת��easyUITree
	 * 
	 * @param org
	 * @return
	 */
	private easyUITree convertToTreeDto(Road road) {
		easyUITree roadTree = new easyUITree();
		roadTree.setId(road.getRoadId());
		roadTree.setText(road.getRoadName());
		// String iconCls = "";
		// switch (road.getRoadType()) {
		// case "0":
		// iconCls = "icon-road-gs";// ���ٹ�· 0
		// break;
		// case "1":
		// iconCls = "icon-road-gd";// ���� 1
		// break;
		// case "2":
		// iconCls = "icon-road-sd";// ʡ�� 2
		// break;
		// case "3":
		// iconCls = "icon-road-xd";// �ص� 3
		// break;
		// case "4":
		// iconCls = "icon-road-xcd";// ���� 4
		// break;
		// case "5":
		// iconCls = "icon-road-cksl";// ���п���· 5
		// break;
		// case "6":
		// iconCls = "icon-road-czgd";// �������ɵ� 6
		// break;
		// case "7":
		// iconCls = "icon-road-ccgd";// ���дθɵ� 7
		// break;
		// case "8":
		// iconCls = "icon-road-czl";// ����֧· 8
		// break;
		// default:
		// iconCls = "icon-road-qt";// ������· 9
		// break;
		// }
		// roadTree.setIconCls(iconCls);
		roadTree.setState("closed");
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("code", road.getRoadCode());
		attribute.put("nodeType", "road");

		roadTree.setAttribute(attribute);
		return roadTree;
	}

	/**
	 * ����λ�������ת��easyUITree
	 * 
	 * @param org
	 * @return
	 */
	private easyUITree convertToTreeDto(Site site) {
		easyUITree siteTree = new easyUITree();
		siteTree.setId(site.getSiteId());
		siteTree.setText(site.getSiteName());
		siteTree.setState("closed");
		Map<String, String> attribute = new HashMap<String, String>();
		attribute.put("code", site.getSiteCode());
		attribute.put("nodeType", "site");
		siteTree.setAttribute(attribute);

		return siteTree;
	}

}
