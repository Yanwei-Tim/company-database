/**
 * @Title: DeviceForMap.java
 * @Package cy.its.trafficSituation.rest.action.impl
 * @Description: �豸��ط���
 * @author gyf guanyf@cychina.cn
 * @date 2015��11��13�� ����3:28:59
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.trafficSituation.rest.action.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import cy.its.com.util.StringUtil;
import cy.its.device.domain.criteria.SystemCriteria;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.model.site.Site;
import cy.its.device.domain.service.IModelFunctionService;
import cy.its.device.domain.service.ISiteService;
import cy.its.device.domain.service.ISystemService;
import cy.its.platform.common.utils.RedisPoolUtil;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.syscfg.domain.service.ISysCodeService;
import cy.its.trafficSituation.rest.action.IDeviceForMapAction;
import cy.its.trafficSituation.rest.dto.DeviceDto;
import cy.its.trafficSituation.rest.dto.RoadsensorDeviceDto;
import cy.its.trafficSituation.rest.dto.VisibilityDeviceDto;
import cy.its.trafficSituation.rest.dto.WeatherDeviceDto;

@RestController
@RequestMapping("/trafficSituation/device")
public class DeviceForMapAction implements IDeviceForMapAction {

	@Autowired
	ISystemService systemService;
	@Autowired
	ISiteService siteService;
	@Autowired
	IDutyService dutyService;
	@Autowired
	IModelFunctionService modelFunctionService;
	@Autowired
	ISysCodeService sysCodeService;

	/*
	 * <p>Title: selectByType</p> <p>Description:�����豸���Ͳ����豸 </p>
	 * 
	 * @param deviceType �豸����
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.trafficSituation.rest.action.IDeviceForMap#selectByType(java.lang.
	 * String)
	 */

	@Override
	@RequestMapping("/selectByType")
	public List<DeviceDto> selectByType(String deviceType, String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		if (deviceType.equals("05")) {
			dtos.addAll(findByFuncCode(deviceType, "1008", currentOrgPrivilegeCode));// ·��"1008"
			dtos.addAll(findByFuncCode(deviceType, "1009", currentOrgPrivilegeCode));// �ܼ�����"1009"
			dtos.addAll(findByFuncCode(deviceType, "1010", currentOrgPrivilegeCode));// ������"1010"
		} else {
			dtos.addAll(findByFuncCode(deviceType, null, currentOrgPrivilegeCode));
		}
		return dtos;
	}

	// ��ѯ����·���豸
	@RequestMapping("/selectRoadsensors")
	public List<DeviceDto> selectRoadSensors(String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		dtos.addAll(findByFuncCode("05", "1008", currentOrgPrivilegeCode));
		return dtos;
	}

	@RequestMapping("/selectRoadsensorsForGrid")
	public Object selectRoadSensorsForGrid(String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		dtos.addAll(findByFuncCode("05", "1008", currentOrgPrivilegeCode));
		return retObject(dtos);
	}

	// ��ѯ�����ܼ������豸
	@RequestMapping("/selectVisibilitys")
	public List<DeviceDto> selectVisibilitys(String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		dtos.addAll(findByFuncCode("05", "1009", currentOrgPrivilegeCode));
		return dtos;
	}

	@RequestMapping("/selectVisibilitysForGrid")
	public Object selectVisibilitysForGrid(String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		dtos.addAll(findByFuncCode("05", "1009", currentOrgPrivilegeCode));
		return retObject(dtos);
	}

	// ��ѯ�����������豸
	@RequestMapping("/selectWeathers")
	public List<DeviceDto> selectWeathers(String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		dtos.addAll(findByFuncCode("05", "1010", currentOrgPrivilegeCode));
		return dtos;
	}

	@RequestMapping("/selectWeathersForGrid")
	public Object selectWeathersForGrid(String currentOrgPrivilegeCode) throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		dtos.addAll(findByFuncCode("05", "1010", currentOrgPrivilegeCode));
		return retObject(dtos);
	}

	// ���豸���Ͳ�ѯ�豸����
	@RequestMapping("/deviceCount")
	public int weatherCount(String deviceType, String currentOrgPrivilegeCode) {
		int count = 0;
		SystemCriteria criteria = new SystemCriteria();
		criteria.deviceType = deviceType;
		criteria.orgPrivilegeCode = currentOrgPrivilegeCode;
		List<Sys> devLst = systemService.findSystems(criteria);
		for (Sys sys : devLst) {
			if (!StringUtil.isNullOrEmpty(sys.getUseStatusFlag())) {
				// ʹ��״̬��ʶ��0 δ���ã�1���ã�2 ͣ�ã�3 ����
				if (sys.getUseStatusFlag().equals("1") || sys.getUseStatusFlag().equals("2")) {
					count++;
				}
			}
		}
		return count;
	}

	private Object retObject(List list) {
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("error", "");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", list.size());
		jsonObject.put("rows", list);
		jsonObj.put("result", jsonObject);
		return jsonObj;
	}

	private List<DeviceDto> findByFuncCode(String deviceType, String funcCode, String currentOrgPrivilegeCode)
			throws Exception {
		List<DeviceDto> dtos = new ArrayList<DeviceDto>();
		SystemCriteria criteria = new SystemCriteria();
		// �����������ʱע��
		// if (funcCode != null) {
		// criteria.lstFuncCodeList = Arrays.asList(funcCode);
		// }
		criteria.deviceType = deviceType;
		criteria.orgPrivilegeCode = currentOrgPrivilegeCode;
		List<Sys> devLst = systemService.findSystems(criteria);
		for (Sys sys : devLst) {
			if (!StringUtil.isNullOrEmpty(sys.getUseStatusFlag())) {
				// ʹ��״̬��ʶ��0 δ���ã�1���ã�2 ͣ�ã�3 ����
				if (sys.getUseStatusFlag().equals("1") || sys.getUseStatusFlag().equals("2")) {
					DeviceDto dto = new DeviceDto();
					if (funcCode == null) {
						dto = convertToDeviceDto(sys);
					} else {
						if (funcCode.equals("1008")) {
							dto = convertToRoadsensorDeviceDto(sys);
							dto.setWeatherType(funcCode);
						} else if (funcCode.equals("1009")) {
							dto = convertToVisibilityDeviceDto(sys);
							dto.setWeatherType(funcCode);
						} else if (funcCode.equals("1010")) {
							dto = convertToWeatherDeviceDto(sys);
							dto.setWeatherType(funcCode);
						}
					}
					// û�о�γ�ȵĲ�����
					if (dto.getLonLat() != null) {
						dtos.add(dto);
					}
				}
			}
		}
		return dtos;
	}

	// sysת��ΪDeviceDto
	private DeviceDto convertToDeviceDto(Sys s) throws Exception {
		DeviceDto deviceDto = new DeviceDto();
		deviceDto.setDeviceSysNbr(s.getDeviceSysNbr());
		deviceDto.setDeviceName(s.getDeviceName());
		deviceDto.setDeviceStatus(s.getStatusType());// �豸״̬
		deviceDto.setDeviceType(s.getDeviceType());
		deviceDto.setDeviceId(s.getDeviceId());

		Site sysSite = siteService.siteOfId(s.getSiteId());

		Double siteLon = (double) 0;
		Double siteLat = (double) 0;
		String siteName = "";
		if (sysSite != null) {
			siteLon = sysSite.getSiteLongitude() == null ? 0 : sysSite.getSiteLongitude().doubleValue();
			siteLat = sysSite.getSiteLatitude() == null ? 0 : sysSite.getSiteLatitude().doubleValue();
			siteName = sysSite.getSiteName();

		}
		deviceDto.setSiteId(s.getSiteId());
		deviceDto.setSiteName(siteName);
		deviceDto.setLatitude(siteLat);
		deviceDto.setLongitude(siteLon);
		if (siteLon != 0 && siteLat != 0) {
			deviceDto.setLonLat("POINT(" + siteLon + " " + siteLat + ")");
		}
		Organization org = dutyService.organizationOfId(s.getOrgId());
		if (org != null) {
			deviceDto.setOrgName(org.orgName);
			deviceDto.setOrgCode(org.orgCode);
		}
		return deviceDto;
	}

	// �������豸ת��ΪDeviceDto
	private WeatherDeviceDto convertToWeatherDeviceDto(Sys s) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Map<String, String> mapObject = RedisPoolUtil.hgetAll("tf:weather");
		WeatherDeviceDto deviceDto = new WeatherDeviceDto();

		// ���ػ�������
		String jsonStr = mapObject.get(s.getDeviceSysNbr());
		if (!StringUtil.isNullOrEmpty(jsonStr)) {
			JSONObject obj = JSONObject.parseObject(jsonStr);
			deviceDto.setAirPressure(obj.getString("airPressure"));
			deviceDto.setRainStrong(obj.getString("rainStrong"));
			deviceDto.setRecordTime(df.format(obj.getDate("recordTime")));
			deviceDto.setRelativeHumidity(obj.getString("relativeHumidity"));
			deviceDto.setWaterFilmHeight(obj.getString("waterFilmHeight"));
			deviceDto.setWaterType(obj.getString("waterType"));
			deviceDto.setWeatherTemperature(obj.getString("weatherTemperature"));
			deviceDto.setWindDirection(obj.getString("windDirection"));
			deviceDto.setWindSpeed(obj.getString("windSpeed"));
		}
		deviceDto.setDeviceSysNbr(s.getDeviceSysNbr());
		deviceDto.setDeviceName(s.getDeviceName());
		deviceDto.setDeviceStatus(s.getStatusType());// �豸״̬
		deviceDto.setDeviceType(s.getDeviceType());

		Site sysSite = siteService.siteOfId(s.getSiteId());
		Double siteLon = (double) 0;
		Double siteLat = (double) 0;
		String siteName = "";
		if (sysSite != null) {
			siteLon = sysSite.getSiteLongitude() == null ? 0 : sysSite.getSiteLongitude().doubleValue();
			siteLat = sysSite.getSiteLatitude() == null ? 0 : sysSite.getSiteLatitude().doubleValue();
			siteName = sysSite.getSiteName();

		}
		deviceDto.setSiteId(s.getSiteId());
		deviceDto.setSiteName(siteName);
		deviceDto.setLatitude(siteLat);
		deviceDto.setLongitude(siteLon);
		if (siteLon != 0 && siteLat != 0) {
			deviceDto.setLonLat("POINT(" + siteLon + " " + siteLat + ")");
		}
		Organization org = dutyService.organizationOfId(s.getOrgId());
		if (org != null) {
			deviceDto.setOrgName(org.orgName);
			deviceDto.setOrgCode(org.orgCode);
		}
		return deviceDto;
	}

	// �ܼ������豸ת��ΪDTO
	private VisibilityDeviceDto convertToVisibilityDeviceDto(Sys s) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Map<String, String> mapObject = RedisPoolUtil.hgetAll("tf:visibility");
		VisibilityDeviceDto deviceDto = new VisibilityDeviceDto();

		// ���ػ�������
		String jsonStr = mapObject.get(s.getDeviceSysNbr());
		if (!StringUtil.isNullOrEmpty(jsonStr)) {
			JSONObject obj = JSONObject.parseObject(jsonStr);
			deviceDto.setCaseTemperature(obj.getString("caseTemperature"));
			deviceDto.setCleanDegre(obj.getString("cleanDegre"));
			deviceDto.setRecordTime(df.format(obj.getDate("recordTime")));
			deviceDto.setOneMinuteVisibility(obj.getString("oneMinuteVisibility"));
			deviceDto.setPowerVolatage(obj.getString("powerVolatage"));
			deviceDto.setTenMinuteVisibility(obj.getString("tenMinuteVisibility"));
		}
		deviceDto.setDeviceSysNbr(s.getDeviceSysNbr());
		deviceDto.setDeviceName(s.getDeviceName());
		deviceDto.setDeviceStatus(s.getStatusType());// �豸״̬
		deviceDto.setDeviceType(s.getDeviceType());

		Site sysSite = siteService.siteOfId(s.getSiteId());
		Double siteLon = (double) 0;
		Double siteLat = (double) 0;
		String siteName = "";
		if (sysSite != null) {
			siteLon = sysSite.getSiteLongitude() == null ? 0 : sysSite.getSiteLongitude().doubleValue();
			siteLat = sysSite.getSiteLatitude() == null ? 0 : sysSite.getSiteLatitude().doubleValue();
			siteName = sysSite.getSiteName();

		}
		deviceDto.setSiteId(s.getSiteId());
		deviceDto.setSiteName(siteName);
		deviceDto.setLatitude(siteLat);
		deviceDto.setLongitude(siteLon);
		if (siteLon != 0 && siteLat != 0) {
			deviceDto.setLonLat("POINT(" + siteLon + " " + siteLat + ")");
		}
		Organization org = dutyService.organizationOfId(s.getOrgId());
		if (org != null) {
			deviceDto.setOrgName(org.orgName);
			deviceDto.setOrgCode(org.orgCode);
		}
		return deviceDto;
	}

	// ·���豸ת��ΪDTO
	private RoadsensorDeviceDto convertToRoadsensorDeviceDto(Sys s) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
		Map<String, String> mapObject = RedisPoolUtil.hgetAll("tf:roadsensor");
		RoadsensorDeviceDto deviceDto = new RoadsensorDeviceDto();

		// ���ػ�������
		String jsonStr = mapObject.get(s.getDeviceSysNbr());
		if (!StringUtil.isNullOrEmpty(jsonStr)) {
			JSONObject obj = JSONObject.parseObject(jsonStr);
			deviceDto.setFreezingTemperature(obj.getString("freezingTemperature"));
			deviceDto.setRoadbedTemperature(obj.getString("roadbedTemperature"));
			deviceDto.setRecordTime(df.format(obj.getDate("recordTime")));
			deviceDto.setRoadCondition(obj.getString("roadCondition"));
			deviceDto.setRoadTemperature(obj.getString("roadTemperature"));
			deviceDto.setSalinity(obj.getString("salinity"));
			deviceDto.setWaterFileHeigh(obj.getString("waterFileHeigh"));
		}
		deviceDto.setDeviceSysNbr(s.getDeviceSysNbr());
		deviceDto.setDeviceName(s.getDeviceName());
		deviceDto.setDeviceStatus(s.getStatusType());// �豸״̬
		deviceDto.setDeviceType(s.getDeviceType());

		Site sysSite = siteService.siteOfId(s.getSiteId());
		Double siteLon = (double) 0;
		Double siteLat = (double) 0;
		String siteName = "";
		if (sysSite != null) {
			siteLon = sysSite.getSiteLongitude() == null ? 0 : sysSite.getSiteLongitude().doubleValue();
			siteLat = sysSite.getSiteLatitude() == null ? 0 : sysSite.getSiteLatitude().doubleValue();
			siteName = sysSite.getSiteName();

		}
		deviceDto.setSiteId(s.getSiteId());
		deviceDto.setSiteName(siteName);
		deviceDto.setLatitude(siteLat);
		deviceDto.setLongitude(siteLon);
		if (siteLon != 0 && siteLat != 0) {
			deviceDto.setLonLat("POINT(" + siteLon + " " + siteLat + ")");
		}
		Organization org = dutyService.organizationOfId(s.getOrgId());
		if (org != null) {
			deviceDto.setOrgName(org.orgName);
			deviceDto.setOrgCode(org.orgCode);
		}
		return deviceDto;
	}
}
