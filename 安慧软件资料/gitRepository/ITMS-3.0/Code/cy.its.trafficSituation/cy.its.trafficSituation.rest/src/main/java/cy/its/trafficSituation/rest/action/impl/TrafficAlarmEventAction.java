package cy.its.trafficSituation.rest.action.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cy.its.com.constant.SysCodeConstant;
import cy.its.com.util.StringUtil;
import cy.its.device.domain.criteria.SiteCriteria;
import cy.its.device.domain.criteria.SystemCriteria;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.model.site.Section;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.device.domain.service.ISystemService;
import cy.its.road.domain.model.region.Region;
import cy.its.road.domain.service.IRegionService;
import cy.its.trafficSituation.domain.model.TrafficAlarmEvent;
import cy.its.trafficSituation.domain.model.TrafficEventProcess;
import cy.its.trafficSituation.domain.service.ITrafficAlarmEventService;
import cy.its.trafficSituation.domain.service.ITrafficControlService;
import cy.its.trafficSituation.domain.service.ITrafficEventProcessService;
import cy.its.trafficSituation.rest.action.ITrafficAlarmEventAction;
import cy.its.trafficSituation.rest.dto.TrafficAlarmEventDto;

/**
 * 
 * @ClassName: TrafficAlarmEventAction
 * @Description: ��ͨԤ���¼�rest
 * @author gyf guanyf@cychina.cn
 * @date 2015��10��27�� ����3:24:05
 *
 */
@RestController
@RequestMapping("/trafficSituation/alarmEvent")
public class TrafficAlarmEventAction implements ITrafficAlarmEventAction {

	@Autowired
	ITrafficAlarmEventService trafficAlarmEventService;
	@Autowired
	ITrafficEventProcessService processService;
	@Autowired
	ISiteService siteService;
	@Autowired
	ISystemService systemService;
	@Autowired
	IRegionService regionService;
	@Autowired
	ITrafficControlService trafficControlService;

	@RequestMapping("/update")
	public int update(TrafficAlarmEventDto trafficAlarmEventDto) throws ParseException {
		String id = trafficAlarmEventDto.getEventProcessId();// trafficAlarmEventDto.parseToEventProcess().getEventProcessId();
		int count = 0;
		if (trafficAlarmEventDto.getValidity().equals("1")) {// �����Ч����һ���ж�EventProcessId�Ƿ�Ϊ����ȷ�����������Ǹ��¼�¼
			if (StringUtil.isNullOrEmpty(id)) {
				TrafficEventProcess pro = trafficAlarmEventDto.parseToEventProcess();
				pro.setDealPerson(trafficAlarmEventDto.getCurrentUserName());
				pro.setDealTime(new Date());
				String processId = processService.save(pro);
				if (!StringUtil.isNullOrEmpty(processId)) {
					count++;
				}
			} else {
				TrafficEventProcess pro = trafficAlarmEventDto.parseToEventProcess();
				pro.setDealPerson(trafficAlarmEventDto.getCurrentUserName());
				pro.setDealTime(new Date());
				count += processService.update(pro);
			}
		} else {// �����Ч������EventProcessIdҲ��Ϊ�գ���ɾ�����������¼
			if (!StringUtil.isNullOrEmpty(id)) {
				count += processService.delete(id);
			}
		}
		// ����validity��confirmPeason��confirmTime
		TrafficAlarmEvent event = trafficAlarmEventDto.parseToTrafficAlarmEvent();
		event.setConfirmPerson(trafficAlarmEventDto.getCurrentUserName());
		event.setConfirmTime(new Date());
		count += trafficAlarmEventService.update(event);
		return count;
	}

	@RequestMapping("/search")
	public Object search(TrafficAlarmEventDto trafficAlarmEventDto) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(trafficAlarmEventDto.getStartTime())) {
			map.put("startTime", sdf.parse(trafficAlarmEventDto.getStartTime()));
		}
		if (!StringUtils.isEmpty(trafficAlarmEventDto.getEndTime())) {
			map.put("endTime", sdf.parse(trafficAlarmEventDto.getEndTime()));
		}
		if (!StringUtils.isEmpty(trafficAlarmEventDto.getAlarmEventType())) {
			map.put("alarmEventType", trafficAlarmEventDto.getAlarmEventType());
		}
		map.put("orgPrivilegeCode", trafficAlarmEventDto.getCurrentOrgPrivilegeCode());

		PageHelper.startPage(trafficAlarmEventDto.getPageNumber(), trafficAlarmEventDto.getPageSize());

		Page pageRs = (Page) trafficAlarmEventService.selectAll(map);
		List<TrafficAlarmEvent> trafficAlarmEvents = pageRs.getResult();
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("error", "");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", pageRs.getTotal());
		jsonObject.put("rows", trafficAlarmEvents);
		jsonObj.put("result", jsonObject);
		return jsonObj;
	}

	private List<Site> findSiteByOrgPrivilegeCode(String currentOrgPrivilegeCode) {
		SiteCriteria criteria = new SiteCriteria();
		criteria.orgPrvCode = currentOrgPrivilegeCode;
		return siteService.findSites(criteria);
	}

	private Site getSiteByCode(List<Site> siteLst, String siteCode) {
		if (siteLst == null || siteLst.size() == 0) {
			return null;
		}
		List<Site> sites = siteLst.stream().filter(p -> p.getSiteCode().equals(siteCode)).collect(Collectors.toList());
		if (sites == null || sites.size() == 0) {
			return null;
		} else {
			return sites.get(0);
		}
	}

	/**
	 * ���ݻ���Ȩ�޴����ѯ���Ͻ���豸
	 * 
	 * @param currentOrgPrivilegeCode
	 * @return
	 */
	private List<Sys> findDevSysByOrgPrivilegeCode(String currentOrgPrivilegeCode) {
		SystemCriteria criteria = new SystemCriteria();
		criteria.useStatusFlag = SysCodeConstant.USE_STATUS_USE;
		criteria.orgPrivilegeCode = currentOrgPrivilegeCode;
		return systemService.findSys(criteria);
	}

	private Sys getSysByNbr(List<Sys> sysLst, String devNbr) {
		if (sysLst == null || sysLst.size() == 0) {
			return null;
		}
		List<Sys> devs = sysLst.stream().filter(p -> p.getDeviceSysNbr().equals(devNbr)).collect(Collectors.toList());
		if (devs == null || devs.size() == 0) {
			return null;
		} else {
			return devs.get(0);
		}
	}

	@RequestMapping("/searchEvents")
	public Object searchEvents(TrafficAlarmEventDto trafficAlarmEventDto) throws Exception {
		Integer pageNow = Integer.valueOf(trafficAlarmEventDto.getPageNumber());
		Integer pageSize = Integer.valueOf(trafficAlarmEventDto.getPageSize());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Map<String, Object> map = new HashMap<String, Object>();
		if (!StringUtils.isEmpty(trafficAlarmEventDto.getStartTime())) {
			map.put("startTime", sdf.parse(trafficAlarmEventDto.getStartTime()));
		}
		if (!StringUtils.isEmpty(trafficAlarmEventDto.getEndTime())) {
			map.put("endTime", sdf.parse(trafficAlarmEventDto.getEndTime()));
		}
		map.put("alarmEventType", "434");
		if (!StringUtils.isEmpty(trafficAlarmEventDto.getSubAlarmEvent())) {
			map.put("subAlarmEvent", trafficAlarmEventDto.getSubAlarmEvent());
		}
		map.put("orgPrivilegeCode", trafficAlarmEventDto.getCurrentOrgPrivilegeCode());

		PageHelper.startPage(pageNow, pageSize);
		Page pageRs = (Page) trafficAlarmEventService.selectAll(map);

		List<TrafficAlarmEventDto> pDtos = new ArrayList<TrafficAlarmEventDto>();

		List<TrafficAlarmEvent> trafficAlarmEvents = pageRs.getResult();

		List<Site> siteLst = findSiteByOrgPrivilegeCode(trafficAlarmEventDto.getCurrentOrgPrivilegeCode());
		// List<Sys> devLst =
		// findDevSysByOrgPrivilegeCode(trafficAlarmEventDto.getCurrentOrgPrivilegeCode());
		for (TrafficAlarmEvent trafficAlarmEvent : trafficAlarmEvents) {
			// TrafficEventProcess process =
			// processService.selectByEventId(trafficAlarmEvent.getAlarmEventId());
			TrafficAlarmEventDto dto = new TrafficAlarmEventDto(trafficAlarmEvent);
			// if (process == null) {
			// dto = new TrafficAlarmEventDto(trafficAlarmEvent);
			// dto.setConfirmPerson(null);
			// dto.setConfirmTime(null);
			// } else {
			// dto = new TrafficAlarmEventDto(trafficAlarmEvent, process);
			// }
			if (dto.getSiteCode() != null) {
				Site site = getSiteByCode(siteLst, dto.getSiteCode());
				if (site != null) {
					String siteName = site.getSiteName();
					if (!StringUtils.isEmpty(siteName)) {
						dto.setSiteName(siteName);
					}
					String lon = site.getSiteLongitude().toString();
					String lat = site.getSiteLatitude().toString();
					if (!StringUtils.isEmpty(lon) && !StringUtils.isEmpty(lat)) {
						dto.setSiteLongitude(lon);
						dto.setSiteLongitude(lat);
					}
				}
			}
			// if (dto.getDeviceSysNbr() != null) {
			// Sys sy = getSysByNbr(devLst,dto.getDeviceSysNbr());
			// if (sy != null) {
			// String deviceName = sy.getDeviceName();
			// if (!StringUtils.isEmpty(deviceName)) {
			// dto.setDeviceName(deviceName);
			// }
			// }
			// }
			pDtos.add(dto);
		}
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("error", "");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", pageRs.getTotal());
		jsonObject.put("rows", pDtos);
		jsonObj.put("result", jsonObject);
		return jsonObj;
	}

	@RequestMapping("/getAlarmProcessByAlarmEventId")
	public Map getAlarmProcessByAlarmEventId(String alarmEventId, String currentOrgPrivilegeCode, String devSysNbr) {
		List<Sys> devLst = findDevSysByOrgPrivilegeCode(currentOrgPrivilegeCode);
		String deviceSysName = devSysNbr;
		Sys sy = getSysByNbr(devLst, devSysNbr);
		if (sy != null) {
			String deviceName = sy.getDeviceName();
			if (!StringUtils.isEmpty(deviceName)) {
				deviceSysName = deviceName;
			}
		}
		TrafficEventProcess tProcess = processService.selectByEventId(alarmEventId);
		Map res = new HashMap();
		res.put("deviceName", deviceSysName);
		res.put("tProcess", tProcess);
		// ������Ҫ�����¼���ͼƬURL TODO
		return res;
	}

	// ����������¼����
	private long getEventCount(String currentOrgPrivilegeCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgPrivilegeCode", currentOrgPrivilegeCode);
		map.put("alarmEventType", "434");
		return trafficAlarmEventService.selectCountByType(map);
	}

	// ����δ������¼����
	private long getEventAlarmCount(String currentOrgPrivilegeCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("validity", "1");
		map.put("orgPrivilegeCode", currentOrgPrivilegeCode);
		map.put("alarmEventType", "434");
		return trafficAlarmEventService.selectCountByType(map);
	}

	// ������Ч�Ľ�ͨ����
	private long getControlCount(String currentOrgPrivilegeCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orgPrivilegeCode", currentOrgPrivilegeCode);
		return trafficControlService.selectCount(map);
	}

	// ������������
	@RequestMapping("/getCounts")
	public Object getCount(String currentOrgPrivilegeCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		// �������е��¼��������⵽���¼�
		map.put("eventCount", getEventCount(currentOrgPrivilegeCode));
		// �������е�δ������¼�
		map.put("eventAlarmCount", getEventAlarmCount(currentOrgPrivilegeCode));
		// ��ȡ��Ч�Ľ�ͨ����
		map.put("controlCount", getControlCount(currentOrgPrivilegeCode));
		return map;
	}
}
