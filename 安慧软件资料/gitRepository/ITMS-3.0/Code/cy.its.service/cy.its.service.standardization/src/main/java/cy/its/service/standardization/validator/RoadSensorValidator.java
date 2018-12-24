package cy.its.service.standardization.validator;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.RoadSensor;

public class RoadSensorValidator extends BaseValidator<RoadSensor> {

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceSysNbr()), "DeviceSysNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_18, "DeviceSysNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getOrgCode()) > ConstValue.INT_18, "OrgCode���ܴ���18λ;");
		addFilter(u -> dbLen(u.getSiteCode()) > ConstValue.INT_32, "SiteCode���ܴ���32λ;");
		addFilter(u -> !isRightDbNum(u.getRoadTemperature(),ConstValue.INT_4,ConstValue.INT_2), "RoadTemperature����������λ����2λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getRoadbedTemperature(),ConstValue.INT_4,ConstValue.INT_2), "RoadbedTemperature����������λ����2λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getWaterFileHeigh(),ConstValue.INT_4,ConstValue.INT_2), "WaterFileHeigh����������λ����2λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getSalinity(),ConstValue.INT_4,ConstValue.INT_2), "Salinity����������λ����2λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getFreezingTemperature(),ConstValue.INT_4,ConstValue.INT_2), "FreezingTemperature����������λ����2λС��λ����2������;");
		addFilter(u -> dbLen(u.getRoadCondition()) > ConstValue.INT_2, "RoadCondition���ܴ���2λ;");
		addFilter(u -> u.getRecordTime() == null, "RecordTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getRecordTime()), "RecordTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_8, "OrgPrivilegeCode���ܴ���8λ;");
	}
}
