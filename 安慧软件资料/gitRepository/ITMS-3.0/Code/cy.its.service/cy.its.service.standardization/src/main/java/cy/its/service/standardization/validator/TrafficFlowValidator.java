package cy.its.service.standardization.validator;

import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.TrafficFlow;

public class TrafficFlowValidator extends BaseValidator<TrafficFlow> {

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getSiteCode()), "SiteCode����Ϊ��;");
		addFilter(u -> dbLen(u.getSiteCode()) > ConstValue.INT_16, "SiteCode���ܴ���16λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceSysNbr()), "DeviceSysNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_18, "DeviceSysNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getDirectionType()) > ConstValue.INT_2, "DirectionType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getLane()) > ConstValue.INT_2, "Lane���ܴ���2λ;");
		addFilter(u -> u.getCountTime() == null, "CountTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getCountTime()), "CountTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");		
		addFilter(u -> !isRightDbNum(u.getPeriod(),ConstValue.INT_6), "Period����������λ����6λС��λ����0������;");		
		addFilter(u -> !isRightDbNum(u.getTotalNum(),ConstValue.INT_6), "TotalNum����������λ����6λС��λ����0������;");		
		addFilter(u -> !isRightDbNum(u.getAvrSpeed(),ConstValue.INT_6,ConstValue.INT_2), "AvrSpeed����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getAvrLength(),ConstValue.INT_6,ConstValue.INT_2), "AvrLength����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getTimePercent(),ConstValue.INT_6,ConstValue.INT_2), "TimePercent����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getSpacePercent(),ConstValue.INT_6,ConstValue.INT_2), "SpacePercent����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getVehSpaceHeadway(),ConstValue.INT_6,ConstValue.INT_2), "VehSpaceHeadway����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getVehTimeHeadway(),ConstValue.INT_6,ConstValue.INT_2), "VehTimeHeadway����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getVehDensity(),ConstValue.INT_6,ConstValue.INT_2), "VehDensity����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getLowSpeedVehNum(),ConstValue.INT_6,ConstValue.INT_2), "LowSpeedVehNum����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getHighSpeedVehNum(),ConstValue.INT_6,ConstValue.INT_2), "HighSpeedVehNum����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getLargeNum(),ConstValue.INT_6), "LargeNum����������λ����6λС��λ����0������;");		
		addFilter(u -> !isRightDbNum(u.getMiddleNum(),ConstValue.INT_6), "MiddleNum����������λ����6λС��λ����0������;");		
		addFilter(u -> !isRightDbNum(u.getSmallNum(),ConstValue.INT_6), "SmallNum����������λ����6λС��λ����0������;");		
		addFilter(u -> !isRightDbNum(u.getMotorNum(),ConstValue.INT_6), "MotorNum����������λ����6λС��λ����0������;");		
		addFilter(u -> !isRightDbNum(u.getSupperLenVehNum(),ConstValue.INT_6,ConstValue.INT_2), "SupperLenVehNum����������λ����4λС��λ����2������;");		
		addFilter(u -> !isRightDbNum(u.getOtherNum(),ConstValue.INT_6), "OtherNum����������λ����6λС��λ����0������;");		
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_16, "OrgCode���ܴ���16λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceNbr()), "DeviceNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceNbr()) > ConstValue.INT_32, "DeviceNbr���ܴ���32λ;");
	}
}
