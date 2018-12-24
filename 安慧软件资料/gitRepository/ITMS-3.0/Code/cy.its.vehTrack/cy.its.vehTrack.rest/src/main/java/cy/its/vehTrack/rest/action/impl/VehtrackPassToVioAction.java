package cy.its.vehTrack.rest.action.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.wordnik.swagger.annotations.ApiOperation;

import cy.its.com.util.DateUtil;
import cy.its.com.util.ExcelUtil;
import cy.its.com.util.StringUtil;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.ISiteService;
import cy.its.device.domain.service.ISystemService;
import cy.its.road.domain.criteria.RoadCriteria;
import cy.its.road.domain.model.road.Road;
import cy.its.road.domain.service.IRoadService;
import cy.its.syscfg.domain.model.sysCode.Code;
import cy.its.syscfg.domain.service.ISysCodeService;
import cy.its.vehTrack.domain.service.IVehtrackPassToVioService;
import cy.its.vehTrack.rest.action.IVehtrackPassToVioAction;
import cy.its.vehTrack.rest.dto.VehtrackPassToVio;
import cy.its.vehTrack.rest.dto.VehtrackPassToVioBean;

@RequestMapping(value = "/vehTrack/vehtrackPassVio")
@RestController
public class VehtrackPassToVioAction implements IVehtrackPassToVioAction {
	@Autowired
	IVehtrackPassToVioService service;
	@Autowired
	ISiteService siteService;
	@Autowired
	ISysCodeService sysService;
	@Autowired
	IRoadService roadService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	ISystemService systemService;

	//Log4jFactoryProxy log4jFactoryProxy=Log4jFactoryProxy.getSingleton(VehtrackPassToVioAction.class);
	
	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping(value = "/queryVehTrackVios", method = RequestMethod.POST)
	@ApiOperation(value = "queryVehTrackVios", notes = "Υ�����ɳ�������", httpMethod = "POST")
	public Map<String, Object> queryVehtrackPassToVio(@ModelAttribute("dto") VehtrackPassToVioBean dto) {
		
		//ֻ�д�ռ��������֯����Ȩ�޴���
		if("0".equals(dto.getIdentifyType())){
			dto.setOrgAuthorityCode(dto.getCurrentOrgPrivilegeCode());
		}else{
			dto.setDistritCodes("");
			dto.setRoadCodes("");
		}
		@SuppressWarnings("rawtypes")
		Map map = dto.beanToMap();
		if (!StringUtil.isNullOrEmpty(dto.getPlateNbr())) {
			map.put("plateNbrs", dto.getPlateNbr().split(","));
		}
		//ֻ�д�ռ������������
		if (!StringUtil.isNullOrEmpty(dto.getDistritCodes()) && "0".equals(dto.getIdentifyType())) {
			map.put("distritCodes", dto.getDistritCodes().split(","));
		}
		//ֻ�д�ռ������������
		if (!StringUtil.isNullOrEmpty(dto.getRoadCodes())&& "0".equals(dto.getIdentifyType())) {
			map.put("roadCodes", dto.getRoadCodes().split(","));
		}
		/*if (!StringUtil.isNullOrEmpty(dto.getIdentifyType())) {
			map.put("identifyType", dto.getIdentifyType().split(","));
		}*/
		if (!StringUtil.isNullOrEmpty(dto.getConfirmFlags())) {
			map.put("confirmFlags", dto.getConfirmFlags().split(","));
		}
		
		@SuppressWarnings("rawtypes")
		Map returnMap = null;
		try {
			returnMap = this.service.queryVehtrackPassToVios(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map2 = (Map) returnMap.get("result");
		Object obj = map2.get("rows");
		List<VehtrackPassToVio> list = (List<VehtrackPassToVio>) JSONObject.parseArray(obj.toString(),
				VehtrackPassToVio.class);
		Site site = null;
		for (VehtrackPassToVio vio : list) {
			if (!StringUtil.isNullOrEmpty(vio.getVioSiteCode())) {
				if (!StringUtil.isNullOrEmpty(vio.getDeviceSysNbr())){
				Sys sysDevice = this.systemService.selectByNBR(vio.getDeviceSysNbr());
				if (sysDevice!=null){
					vio.setDeviceId(sysDevice.getDeviceId());
				}
			}
				site = this.siteService.siteOfCode(vio.getVioSiteCode());
				if (site != null) {
					vio.setVioSiteName(site.getSiteName());
				}
			}
		}
		map2.put("rows", list);
		return returnMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	@RequestMapping(value = "/updateVehById", method = RequestMethod.POST)
	@ApiOperation(value = "updateVehById", notes = "����Υ�����ɼ�¼", httpMethod = "POST")
	public Map<String, Object> updateVehTraackPassById(@RequestParam(value = "id") String id,
			@RequestParam(value = "confirmFlag") String confirmFlag,
			@RequestParam(value = "confirmResult") String confirmResult,
			@RequestParam(value = "currentUserName") String currentUserName) {
		Map<String, Object> result = null;
		@SuppressWarnings("rawtypes")
		Map map = new HashMap();
		map.put("id", id);
		map.put("confirmFlag", confirmFlag);
		map.put("confirmResult", confirmResult);
		map.put("confirmPerson", currentUserName);
		map.put("confirmTime", new Date());
		try {
			result = this.service.updateVehtrackPassToVio(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@RequestMapping(value = "/exportVioRecordExcel")
	@ApiOperation(value = "exportVioRecordExcel", notes = "����Υ����������excel", httpMethod = "GET")
	public Object exportVioRecordExcel(@ModelAttribute("dto") VehtrackPassToVioBean dto) throws Exception {
		//log4jFactoryProxy.error("����Υ����������excel ����");
		dto.setPageSize(10000);
		OutputStream outputStream = null;
		JSONObject obj = new JSONObject();
		//ֻ�д�ռ��������֯����Ȩ�޴���
		if("0".equals(dto.getIdentifyType())){
			dto.setOrgAuthorityCode(dto.getCurrentOrgPrivilegeCode());
		}else{
			dto.setDistritCodes("");
			dto.setRoadCodes("");
		}
		@SuppressWarnings("rawtypes")
		Map map = dto.beanToMap();
		//ֻ�д�ռ������������
		if (!StringUtil.isNullOrEmpty(dto.getDistritCodes()) && "0".equals(dto.getIdentifyType())) {
			map.put("distritCodes", dto.getDistritCodes().split(","));
		}
		//ֻ�д�ռ������������
		if (!StringUtil.isNullOrEmpty(dto.getRoadCodes())&& "0".equals(dto.getIdentifyType())) {
			map.put("roadCodes", dto.getRoadCodes().split(","));
		}
		/*if (!StringUtil.isNullOrEmpty(dto.getIdentifyType())) {
			map.put("identifyType", dto.getIdentifyType().split(","));
		}*/
		if (!StringUtil.isNullOrEmpty(dto.getConfirmFlags())) {
			map.put("confirmFlags", dto.getConfirmFlags().split(","));
		}
		
		@SuppressWarnings("rawtypes")
		Map returnMap = null;
		try {
			returnMap = this.service.queryVehtrackPassToVios(map);
			//log4jFactoryProxy.error("����Υ����������excel ����ȡ���ɹ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map map2 = (Map) returnMap.get("result");
		Object rows = map2.get("rows");
		List<VehtrackPassToVio> list = (List<VehtrackPassToVio>) JSONObject.parseArray(rows.toString(),
				VehtrackPassToVio.class);
		Site site = null;
		Code code = null;
		Road road = null;
		RoadCriteria roadCreteria = new RoadCriteria();
		//log4jFactoryProxy.error("����Υ����������excel ����ת���ɹ�,��������" + list.size());
		for (VehtrackPassToVio vio : list) {
			if (!StringUtil.isNullOrEmpty(vio.getVehicleType())) {
				code = this.sysService.codeOfId("001", vio.getVehicleType());
				// ��������
				if (!StringUtil.isNullOrEmpty(code)) {
					vio.setVehicleType(code.codeName);
				}
			}
				// Υ������
				code = this.sysService.codeOfId("011", vio.getIdentifyType());
				if (!StringUtil.isNullOrEmpty(code)) {
					vio.setIdentifyType(code.codeName);
				}
				// ȷ�ϱ�ʶ
				code = this.sysService.codeOfId("241", vio.getConfirmFlag());
				if (!StringUtil.isNullOrEmpty(code)) {
					vio.setConfirmFlag(code.codeName);
				}
				// ��·
				if (!StringUtil.isNullOrEmpty(vio.getRoadCode())) {
					roadCreteria.roadCode = vio.getRoadCode();
					road = this.roadService.findRoads(roadCreteria).get(0);
					if (road != null) {
						vio.setRoadCode(road.getRoadName());
					}
				}
			
			if (!StringUtil.isNullOrEmpty(vio.getVioSiteCode())) {
				site = this.siteService.siteOfCode(vio.getVioSiteCode());
				if (site != null) {
					vio.setVioSiteName(site.getSiteName());
				}
			}
		}
		if (list != null && list.size() > 1) {
			//log4jFactoryProxy.error("����Υ����������excel ����ת���ɹ�����������excel����������" + list.size());
			String[] headers = new String[] { "ȷ�ϱ�ʶ", "���ƺ���", "��������", "��������", "���ڵ�·", "Υ���ص�", "Υ��ʱ��", "��������" };
			String[] fieldNameArr = new String[] { "confirmFlag", "plateNbr", "vehicleType", "identifyType", "roadCode",
					"vioSiteName", "detectionTime", "vioSuspectedDesc" };
			String excelName = "Υ�����ɳ�������" + DateUtil.parseFormatDate(new Date(), "yyyyMMddHHmmssS") + ".xlsx";
			File file = new File(request.getServletContext().getRealPath("/FileDir") + "/"
					+ DateUtil.parseFormatDate(new Date(), "yyyyMMdd") + "/" + excelName);
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
			File fileDir = file.getParentFile();
			if (!fileDir.exists()) {
				fileDir.mkdirs();
			}
			outputStream = new FileOutputStream(file);
			obj.put("url", basePath + request.getContextPath() + "/FileDir/"
					+ DateUtil.parseFormatDate(new Date(), "yyyyMMdd") + "/" + excelName);
			//log4jFactoryProxy.error("����Υ����������excel��������url" + obj.getString("url"));
			new ExcelUtil<VehtrackPassToVio>().exportExcel(list, fieldNameArr, headers, outputStream);
		}
		return obj;

	}

}
