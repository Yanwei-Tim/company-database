package cy.its.service.standardization.validator;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceFault;

public class DeviceFaultValidator extends BaseValidator<DeviceFault> {

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceId()), "DeviceId����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceId()) > ConstValue.INT_32, "DeviceId���ܴ���32λ;");
		addFilter(u -> u.getFaultEventTime() == null, "FaultEventTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getFaultEventTime()), "FaultEventTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getFaultSubType()) > ConstValue.INT_4, "FaultSubType���ܴ���4λ;");
		addFilter(u -> dbLen(u.getFaultAlarm()) > ConstValue.INT_1, "FaultAlarm���ܴ���1λ;");
		addFilter(u -> dbLen(u.getFaultType()) > ConstValue.INT_2, "FaultType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getCollectMethod()) > ConstValue.INT_1, "CollectMethod���ܴ���1λ;");
		addFilter(u -> dbLen(u.getRemark()) > ConstValue.INT_256, "Remark���ܴ���256λ;");		
		addFilter(u -> dbLen(u.getSysComponentId()) > ConstValue.INT_32, "SysComponentId���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getOrgPrivilegeCode()), "OrgPrivilegeCode����Ϊ��;");
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_8, "OrgPrivilegeCode���ܴ���8λ;");
	}
}
