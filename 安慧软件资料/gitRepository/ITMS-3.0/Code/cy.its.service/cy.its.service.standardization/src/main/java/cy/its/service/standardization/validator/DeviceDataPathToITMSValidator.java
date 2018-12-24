package cy.its.service.standardization.validator;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceDataPathToITMS;

public class DeviceDataPathToITMSValidator extends BaseValidator<DeviceDataPathToITMS> {

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getSnapNbr()), "SnapNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getSnapNbr()) > ConstValue.INT_32, "SnapNbr���ܴ���32λ;");
		addFilter(u -> u.getPassTime() == null, "PassTime����Ϊ��;");
		addFilter(u -> u.getItmsTime() == null, "ItmsTime����Ϊ��;");
		addFilter(u -> !isRightDbNum(u.getTotalTime(), ConstValue.INT_12, ConstValue.INT_2),
				"TotalTime����������λ����10λС��λ����2������;");
		addFilter(u -> dbLen(u.getDeviceKey()) > ConstValue.INT_64, "DeviceKey���ܴ���64λ;");
		addFilter(u -> dbLen(u.getSysComponentId()) > ConstValue.INT_32, "SysComponentId���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceId()), "DeviceId����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceId()) > ConstValue.INT_32, "DeviceId���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getOrgPrivilegeCode()), "OrgPrivilegeCode����Ϊ��;");
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_8, "OrgPrivilegeCode���ܴ���8λ;");
	}

}
