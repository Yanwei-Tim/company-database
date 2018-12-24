package cy.its.service.standardization.validator;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.Visibility;

public class VisibilityValidator extends BaseValidator<Visibility>{

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceSysNbr()), "DeviceSysNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_18, "DeviceSysNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getOrgCode()) > ConstValue.INT_18, "OrgCode���ܴ���18λ;");
		addFilter(u -> dbLen(u.getSiteCode()) > ConstValue.INT_32, "SiteCode���ܴ���32λ;");
		addFilter(u -> !isRightDbNum(u.getOneMinuteVisibility(),ConstValue.INT_10), "OneMinuteVisibility����������λ����10λС��λ����0������;");
		addFilter(u -> !isRightDbNum(u.getTenMinuteVisibility(),ConstValue.INT_10), "TenMinuteVisibility����������λ����10λС��λ����0������;");
		addFilter(u -> !isRightDbNum(u.getCleanDegre(),ConstValue.INT_10), "CleanDegre����������λ����10λС��λ����0������;");
		addFilter(u -> !isRightDbNum(u.getCaseTemperature(),ConstValue.INT_10), "CaseTemperature����������λ����10λС��λ����0������;");
		addFilter(u -> dbLen(u.getPowerVolatage()) > ConstValue.INT_8, "PowerVolatage���ܴ���8λ;");
		addFilter(u -> u.getRecordTime() == null, "RecordTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getRecordTime()), "RecordTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_8, "OrgPrivilegeCode���ܴ���8λ;");
	}
}
