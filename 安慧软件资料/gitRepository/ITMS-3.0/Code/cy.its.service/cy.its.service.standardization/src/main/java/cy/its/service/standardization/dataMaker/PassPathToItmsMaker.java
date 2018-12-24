package cy.its.service.standardization.dataMaker;

import java.math.BigDecimal;
import java.util.Date;

import cy.its.service.common.ConstValue;
import cy.its.service.common.DateUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceDataPathToITMS;
import cy.its.service.common.ioc.Export;
import cy.its.service.common.ioc.Import;
import cy.its.service.standardization.dataMaker.originalModel.PassingVehicle;
import cy.its.service.standardization.dictionary.SurveyUpgrade_DeviceCache;
import cy.its.service.standardization.dictionary.model.IDeviceInfo;
import cy.its.service.standardization.validator.BaseValidator;
import cy.its.service.standardization.validator.DeviceDataPathToITMSValidator;

@Export
public class PassPathToItmsMaker extends DataMaker<PassingVehicle, DeviceDataPathToITMS> {

	@Import
	SurveyUpgrade_DeviceCache surveyUpgrade_DeviceCache;

	public PassPathToItmsMaker() {
		super("���ܿ�ƽ̨��������켣", PassingVehicle.class, DeviceDataPathToITMS.class,
				ConstValue.ROUTE_KEY_ORIGINAL_PASS_FOR_ITMS_PATH,
				ConstValue.ROUTE_KEY_STANDARD_DEVICE_DATA_PATH_TO_ITMS, "original_pass_vehicle_for_itms_path", true);
	}

	String KEY_Proxy_Receive = "Proxy_Receive";
	String KEY_Proxy_Receive_After = "Proxy_Receive_After";
	String KEY_ICE2MQ_Receive = "ICE2MQ_Receive";
	String KEY_MQ2File_Receive = "MQ2File_Receive";
	String KEY_File2MQ_Receive = "File2MQ_Receive";
	double d1000 = 1000.0;

	@Override
	DeviceDataPathToITMS translate(PassingVehicle input) {
		if (input.getExtendedProperties() != null) {
			String devKey = input.getExtendedProperties().get(ConstValue.DEVICE_KEY);
			if (!StringUtil.isNullOrEmpty(devKey)) {
				IDeviceInfo d = surveyUpgrade_DeviceCache.get(devKey);
				if (d != null) {
					DeviceDataPathToITMS path = new DeviceDataPathToITMS();
					path.setDeviceId(d.getDeviceId());
					path.setSysComponentId(d.getSysComponentId());
					path.setOrgPrivilegeCode(d.getOrgPrivilegeCode());
					path.setDeviceSysNbr(d.getSysNbr());
					path.setDeviceNbr(input.getDeviceNo());
					path.setSnapNbr(input.getSnapNbr());
					path.setPassTime(DateUtil.parseDate(input.getCaptureTime()));
					// serverReceivingTime:      ��ط���������ʱ��                                                                 Proxy_Receive
					// afterserverReceivingTime: ���ü�ط���������ʱ�䣨���м�ط���������ʱ��ֵ�� Proxy_Receive_After
					// ice2mqTime:               ICE2MQ����ʱ��                                                                       ICE2MQ_Receive
					// preTime:                  ǰ�û�����ʱ��                                                                         MQ2File_Receive
					// afterTime:                ���û�����ʱ��                                                                         File2MQ_Receive
					path.setServerReceivingTime(
							DateUtil.parseDate(input.getExtendedProperties().get(KEY_Proxy_Receive)));
					path.setAfterserverReceivingTime(
							DateUtil.parseDate(input.getExtendedProperties().get(KEY_Proxy_Receive_After)));
					path.setIce2mqTime(DateUtil.parseDate(input.getExtendedProperties().get(KEY_ICE2MQ_Receive)));
					path.setPreTime(DateUtil.parseDate(input.getExtendedProperties().get(KEY_MQ2File_Receive)));
					path.setAfterTime(DateUtil.parseDate(input.getExtendedProperties().get(KEY_File2MQ_Receive)));
					path.setItmsTime(new Date());

					if (path.getItmsTime() != null && path.getPassTime() != null) {
						path.setTotalTime(BigDecimal
								.valueOf((path.getItmsTime().getTime() - path.getPassTime().getTime()) / d1000)
								.setScale(ConstValue.INT_2, BigDecimal.ROUND_HALF_UP));
					}

					path.setDeviceKey(devKey);
					path.setSiteCode(d.getSiteCode());
					path.setRoadCode(d.getRoadCode());
					
					return path;
				} else {
					input.validateResult = STR_DEVICE_UNREG;
				}
			} else {
				input.validateResult = STR_EXT_NOKEY;
			}
		} else {
			input.validateResult = STR_EXT_NULL;
		}

		return null;
	}

	@Override
	BaseValidator<DeviceDataPathToITMS> validator() {
		return new DeviceDataPathToITMSValidator();
	}

}
