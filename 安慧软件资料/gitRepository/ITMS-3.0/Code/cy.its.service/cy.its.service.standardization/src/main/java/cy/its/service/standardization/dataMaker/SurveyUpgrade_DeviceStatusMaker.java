package cy.its.service.standardization.dataMaker;

import java.util.Arrays;

import cy.its.service.common.ConstValue;
import cy.its.service.common.DateUtil;
import cy.its.service.common.JsonUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.SurveyUpgrade_DeviceStatus;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.ioc.Import;
import cy.its.service.common.log.LogManager;
import cy.its.service.standardization.dataMaker.originalModel.SurveyUpgrade_DeviceStatusInfo;
import cy.its.service.standardization.dictionary.SurveyUpgrade_DeviceCache;
import cy.its.service.standardization.dictionary.model.IDeviceInfo;
import cy.its.service.standardization.validator.BaseValidator;

@Export
public class SurveyUpgrade_DeviceStatusMaker
		extends DataArrayMaker<SurveyUpgrade_DeviceStatusInfo, SurveyUpgrade_DeviceStatus> {

	@Import
	SurveyUpgrade_DeviceCache surveyUpgrade_DeviceCache;

	public SurveyUpgrade_DeviceStatusMaker() {
		super("�豸״̬[��ط�������������]", SurveyUpgrade_DeviceStatusInfo.class, SurveyUpgrade_DeviceStatus.class,
				ConstValue.ROUTE_KEY_ORIGINAL_STATUS_FOR_UPGRADE, ConstValue.ROUTE_KEY_STANDARD_STATUS_FOR_UPGRADE,
				"original_device_status_for_upgrade", false);// "original_device_status_forSurveyUpgrade"
	}

	String STR_DEVICE_UNREG = "�豸��Ϣδע��";

	@Override
	SurveyUpgrade_DeviceStatus translate(SurveyUpgrade_DeviceStatusInfo input) {
		IDeviceInfo dev = surveyUpgrade_DeviceCache.get(input.getDeviceID());
		if (dev != null) {
			SurveyUpgrade_DeviceStatus status = new SurveyUpgrade_DeviceStatus();

			// ���ǰ�˷��͵��豸��źͱ���ϵͳ��Ż��������Ƿ�һ��
			if (ConstValue.STR_ONE.equals(dev.getDtype())) {
				// ƥ�䵽���豸����Ϊϵͳ
				if (!dev.getSysNbr().equals(input.getDeviceNo())) {
					LogManager.warn(String.format("�豸״̬[��ط�������������]ת������, ǰ���豸�����豸����뱾�ز�һ��, ����ϵͳID:%s, ���:%s, ǰ������:%s",
							dev.getDeviceId(), dev.getSysNbr(), JsonUtil.serialize(input)));
				}
			} else {
				// ƥ�䵽���豸����Ϊ���
				if (!dev.getDeviceNbr().equals(input.getDeviceNo())) {
					LogManager.warn(String.format("�豸״̬[��ط�������������]ת��, ǰ���豸�����豸����뱾�ز�һ��, �������ID:%s, ���:%s, ǰ������:%s",
							dev.getSysComponentId(), dev.getDeviceNbr(), JsonUtil.serialize(input)));
				}
			}

			status.setDeviceKey(input.getDeviceID());
			status.setDeviceSysId(dev.getDeviceId());
			status.setDeviceSysNbr(dev.getSysNbr());
			status.setCameraNbr(dev.getDeviceNbr());
			status.setCameraId(dev.getSysComponentId());
			status.setStatusCode(input.getDeviceStatus());
			if (!StringUtil.isNullOrEmpty(input.getFaultCode())
					&& !StringUtil.isNullOrEmpty(input.getFaultCode().trim())) {
				status.setFaultCodes(Arrays.asList(input.getFaultCode().trim().split(ConstValue.COMMA)));
			}

			if (!StringUtil.isNullOrEmpty(input.getStatusTime())) {
				status.setStatusTime(DateUtil.parseDateTime(input.getStatusTime()));
			}

			if (!StringUtil.isNullOrEmpty(input.getDeviceStartTime())) {
				status.setStartTime(DateUtil.parseDateTime(input.getDeviceStartTime()));
			}

			if (!StringUtil.isNullOrEmpty(input.getDeviceCurrTime())) {
				status.setDeviceTime(DateUtil.parseDateTime(input.getDeviceCurrTime()));
			}
			
			status.setTimeDiff(input.getTimeDiff());

			status.setExtendedProperties(input.getExtendedProperties());

			status.setOrgPrivilegeCode(dev.getOrgPrivilegeCode());

			return status;
		} else {
			input.validateResult = STR_DEVICE_UNREG;
		}

		return null;
	}

	@Override
	BaseValidator<SurveyUpgrade_DeviceStatus> validator() {
		return null;
	}

}
