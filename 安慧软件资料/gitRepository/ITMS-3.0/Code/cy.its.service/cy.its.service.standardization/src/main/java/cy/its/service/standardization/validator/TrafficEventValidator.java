package cy.its.service.standardization.validator;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.TrafficEvent;

public class TrafficEventValidator extends BaseValidator<TrafficEvent> {

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getOrgCode()), "OrgCode����Ϊ��;");
		addFilter(u -> dbLen(u.getOrgCode()) > ConstValue.INT_18, "OrgCode���ܴ���18λ;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_18, "DeviceSysNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getSiteCode()) > ConstValue.INT_32, "SiteCode���ܴ���32λ;");
		addFilter(u -> dbLen(u.getAlarmEventType()) > ConstValue.INT_3, "AlarmEventType���ܴ���3λ;");
		addFilter(u -> dbLen(u.getSubAlarmEvent()) > ConstValue.INT_3, "SubAlarmEvent���ܴ���3λ;");
		addFilter(u -> u.getStartAlarmTime() == null, "StartAlarmTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getStartAlarmTime()), "StartAlarmTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getAlarmDesc()) > ConstValue.INT_256, "AlarmDesc���ܴ���256λ;");		
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_8, "OrgPrivilegeCode���ܴ���8λ;");
	}
}
