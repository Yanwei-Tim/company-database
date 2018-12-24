/**
 * @Title: DeviceGroupAction.java
 * @Package cy.its.violation.rest.action.impl
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��9�� ����8:39:11
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.action.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cy.its.com.util.ObjectMapUtils;
import cy.its.device.domain.criteria.SystemCriteria;
import cy.its.device.domain.model.Sys;
import cy.its.device.domain.service.ISystemService;
import cy.its.syscfg.domain.criteria.UserCriteria;
import cy.its.syscfg.domain.model.duty.Organization;
import cy.its.syscfg.domain.model.duty.User;
import cy.its.syscfg.domain.service.IDutyService;
import cy.its.violation.domain.criteria.AssoUserDeviceCriteria;
import cy.its.violation.domain.model.config.VioAssoUserDevice;
import cy.its.violation.domain.service.IVioAssoUserDeviceService;
import cy.its.violation.rest.action.IDeviceGroupAction;
import cy.its.violation.rest.dto.DeviceGroupDto;

/**
 * @ClassName: DeviceGroupAction
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��9�� ����8:39:11
 *
 */
@RestController
@RequestMapping("/deviceGroupAction")
public class DeviceGroupAction implements IDeviceGroupAction {

	@Autowired
	ISystemService systemService;
	@Autowired
	IDutyService dutyService;
	@Autowired
	IVioAssoUserDeviceService vioAssoUserDeviceService;
	/*
	 * <p>Title: findDeviceAction</p> <p>Description:�����û��� </p>
	 * 
	 * @param deviceGroupDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#searchDeviceAction(cy.its
	 * .violation.rest.dto.DeviceGroupDto)
	 */

	@RequestMapping("/findDeviceAction")
	@Override
	public ArrayList<DeviceGroupDto> findDeviceAction(DeviceGroupDto deviceGroupDto) throws Exception {
		ArrayList<DeviceGroupDto> lstView = new ArrayList<DeviceGroupDto>();
		UserCriteria userCriteria = new UserCriteria();
		// ������е��û���Ϣ
		List<User> lst = dutyService.findUsers(userCriteria);
		// ���� list����û�Id���û���
		for (User user : lst) {
			DeviceGroupDto deviceGroup = new DeviceGroupDto();
			// ���������û�Id���û���ת��Ϊ�ͻ���
			deviceGroup.setUserId(user.getUserId());
			deviceGroup.setUserName(user.name);
			ObjectMapUtils.parseObject(deviceGroup, user);
			// �ѿͻ��˵�������ӵ�ArrayList����
			lstView.add(deviceGroup);
		}

		return lstView;

	}
	/*
	 * <p>Title: searchDeviceList</p> <p>Description: </p>
	 * 
	 * @param deviceGroupDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#searchDeviceList(cy.its.
	 * violation.rest.dto.DeviceGroupDto)
	 */

	@RequestMapping("/findDeviceList")
	@Override
	public Map findDeviceList(@RequestParam("orgId") String orgId) {

		ArrayList<DeviceGroupDto> lstView = new ArrayList<DeviceGroupDto>();
		SystemCriteria systemCriteria = new SystemCriteria();
		// ������е��豸����Ϣ
		List<Sys> lst = systemService.findSystems(systemCriteria);
		// ��ȡ���û���Ͻ���豸����Ϊ�豸�������в�������������������Ҫ��������Ȩ�ޱ���Ҫ������һ����ȥϵͳ�������в�ѯ���û�������������
		List<Sys> devLst = filterCurrentUserDev(orgId, lst);
		// �����û����¼��»����������豸����豸�����豸���
		for (Sys list : devLst) {
			DeviceGroupDto device = new DeviceGroupDto();
			device.setDeviceName(list.getDeviceName());
			device.setDeviceSysNbr(list.getDeviceSysNbr());
			lstView.add(device);
		}

		Map map = new HashMap();
		map.put("error", "");
		Map maprows = new HashMap();
		maprows.put("rows", lstView);
		map.put("result", maprows);
		return map;

	}

	/**
	 * FilterCurrentUserDev(�����û��Ļ���ID��ȡ���û��Ļ���������������) TODO(����������������������� �C ��ѡ)
	 * TODO(�����������������ִ������ �C ��ѡ) TODO(�����������������ʹ�÷��� �C ��ѡ) TODO(�����������������ע������ �C
	 * ��ѡ)
	 *
	 * @Title: FilterCurrentUserDev @Description: TODO @param @param
	 * orgId @param @param lst @param @return �趨�ļ� @return List<Sys>
	 * �������� @throws
	 */

	private List<Sys> filterCurrentUserDev(String orgId, List<Sys> lst) {

		if (lst == null || lst.size() == 0) {
			return null;
		}
		if (orgId.equals("")) // �����ǰ�û�δ֪���򷵻����е��豸
		{
			return lst;
		}
		List<Sys> devs = new ArrayList<Sys>();// ��ŵ�ǰ�û���Ͻ���豸�豸
		try {
			// �����û��Ļ���ID��ȡ���û��Ļ���������������
			List<Organization> sonOrgLst = dutyService.findSonOrgsOfParent(orgId);
			List<String> orgIds = sonOrgLst.stream().map(org -> org.getIdentityId()).collect(Collectors.toList());

			if (orgIds == null || orgIds.size() == 0) {
				orgIds = new ArrayList<String>();
			}
			orgIds.add(orgId);// �ѵ�ǰ�û��Ļ�������
			for (Sys s : lst) {
				String devOrgId = s.getOrgId();
				if (orgIds.contains(devOrgId)) {
					devs.add(s);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return devs;
	}

	/*
	 * <p>Title: findDGroupAction</p> <p>Description: ��ѯ�豸������Ϣ </p>
	 * 
	 * @param deviceGroupDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#searchDGroupAction(cy.its
	 * .violation.rest.dto.DeviceGroupDto)
	 */
	@RequestMapping("/findDGroupAction")
	@Override
	public Map findDGroupAction() throws Exception {
		// ͨ���豸�������û�ID�����û���,�豸���(����)
		// ͨ�� �û�ID���豸���ת���û������豸��
		ArrayList<DeviceGroupDto> dtoList = new ArrayList<DeviceGroupDto>();
		AssoUserDeviceCriteria assoUserDeviceCriteria = new AssoUserDeviceCriteria();
		assoUserDeviceCriteria.setNoPage();
		List<VioAssoUserDevice> list = vioAssoUserDeviceService.findVioAssoUserDevice(assoUserDeviceCriteria);
		for (VioAssoUserDevice vioAssoUserDevice : list) {
			// ת�û�IDΪ����
			String username = convertUserIdToName(vioAssoUserDevice.getUserId());
			// ת�豸idΪ����
			String deviceName = getDeviceNameBySysNbr(vioAssoUserDevice.getDeviceSysNbr());
			// ת��dto
			DeviceGroupDto dto = new DeviceGroupDto();
			dto.setUserId(vioAssoUserDevice.getUserId());
			dto.setUserName(username);
			dto.setDeviceName(deviceName);
			dtoList.add(dto);
		}
		// ����userId���飬�豸��ţ��豸���ƣ������","�÷ָ�
		List<DeviceGroupDto> viewList = groupDeviceGroupByUserId(dtoList);

		Map map = new HashMap();
		map.put("error", "");
		Map maprows = new HashMap();
		maprows.put("rows", viewList);
		map.put("result", maprows);
		return map;

	}

	private List<DeviceGroupDto> groupDeviceGroupByUserId(ArrayList<DeviceGroupDto> dtoList) {
		Map<String, List<DeviceGroupDto>> groupMap = dtoList.stream()
				.collect(Collectors.groupingBy(DeviceGroupDto::getUserId));
		List<DeviceGroupDto> viewList = new ArrayList<DeviceGroupDto>();
		for (Entry<String, List<DeviceGroupDto>> item : groupMap.entrySet()) {
			DeviceGroupDto viewDto = new DeviceGroupDto();
			viewDto.setUserId(item.getKey());
			viewDto.setUserName(item.getValue().get(0).getUserName());
			StringBuilder deviceIds = new StringBuilder();
			StringBuilder deviceNames = new StringBuilder();
			for (DeviceGroupDto dtoItem : item.getValue()) {
				deviceIds.append(dtoItem.getDeviceSysNbr()).append(",");
				deviceNames.append(dtoItem.getDeviceName()).append(",");
			}
			viewDto.setDeviceSysNbrs(deviceIds.substring(0, deviceIds.length() - 1));
			viewDto.setDeviceNames(deviceNames.substring(0, deviceNames.length() - 1));
			viewList.add(viewDto);
		}
		return viewList;
	}

	// ����豸��
	private String getDeviceNameBySysNbr(String deviceSysNbr) {
		String deviceName = "";
		Sys deviceSys = systemService.selectByNBR(deviceSysNbr);
		if (deviceSys != null) {
			deviceName = deviceSys.getDeviceName();
		}
		return deviceName;
	}

	// ����û���
	private String convertUserIdToName(String userId) throws Exception {
		return dutyService.userOfId(userId).name;
	}

	/*
	 * <p>Title: createDGroupAction</p> <p>Description:�����û��豸 </p>
	 * 
	 * @param deviceGroupDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#saveDGroupAction(cy.its.
	 * violation.rest.dto.DeviceGroupDto)
	 */
	@RequestMapping("/createDGroupAction")
	@Override
	public String createDGroupAction(String deviceSysNbrStr, String userId) {
		String[] deviceSysNbr = deviceSysNbrStr.split(",");

		for (int i = 0; i < deviceSysNbr.length; i++) {
			VioAssoUserDevice vioAssoUserDevice = new VioAssoUserDevice();
			vioAssoUserDevice.setDeviceSysNbr(deviceSysNbr[i]);
			vioAssoUserDevice.setUserId(userId);
			vioAssoUserDeviceService.saveVioAssoUserDevice(vioAssoUserDevice);
		}

		return "success";
	}

	/*
	 * <p>Title: updateDGroupAction</p> <p>Description: </p>
	 * 
	 * @param deviceGroupDto
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#updateDGroupAction(cy.its
	 * .violation.rest.dto.DeviceGroupDto)
	 */

	@Override
	public String updateDGroupAction(DeviceGroupDto deviceGroupDto) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * 
	 * <p>Title: deleteDGroupAction</p> <p>Description: ����ɾ��</p>
	 * 
	 * @param userIdStr
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#deleteDGroupAction(java.
	 * lang.String)
	 */
	@RequestMapping("/deleteDGoupAction")
	@Override
	public String deleteDGroupAction(String userIdStr) {
		String userId[] = userIdStr.split(",");
		int resultIdStr = 0;
		for (int i = 0; i < userId.length; i++) {
			// ���ÿһ���Id
			resultIdStr += vioAssoUserDeviceService.removeVioAssoUserDeviceByUserID(userId[i]);

		}
		if (resultIdStr > 0) {
			return "success";
		} else {
			return "false";
		}

	}

	/*
	 * 
	 * <p>Title: removeDGroupAction</p> <p>Description: ����ɾ�� </p>
	 * 
	 * @param userId
	 * 
	 * @return
	 * 
	 * @see
	 * cy.its.violation.rest.action.IDeviceGroupAction#removeDGroupAction(java.
	 * lang.String)
	 */
	@RequestMapping("/removeDGroupAction")
	@Override
	public String removeDGroupAction(@RequestParam("userId") String userId) {
		int resultUserId = vioAssoUserDeviceService.removeVioAssoUserDeviceByUserID(userId);
		if (resultUserId > 0) {
			return "1";
		} else {
			return "0";
		}
	}

}
