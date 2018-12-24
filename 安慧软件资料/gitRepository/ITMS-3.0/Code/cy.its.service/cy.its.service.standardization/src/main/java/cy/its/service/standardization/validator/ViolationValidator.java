package cy.its.service.standardization.validator;

import cy.its.service.common.dataModel.Violation;
import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;

public class ViolationValidator extends BaseValidator<Violation> {

	@Override
	void fillFilters() {		
		addFilter(u -> dbLen(u.getVehicleRegId()) > ConstValue.INT_32, "VehicleRegId���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceSysNbr()), "DeviceSysNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_32, "DeviceSysNbr���ܴ���32λ;");
		addFilter(u -> dbLen(u.getSnapNbr()) > ConstValue.INT_32, "SnapNbr���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getOrgCode()), "OrgCode����Ϊ��;");
		addFilter(u -> dbLen(u.getOrgCode()) > ConstValue.INT_32, "OrgCode���ܴ���32λ;");
		addFilter(u -> dbLen(u.getOrgAuthorityCode()) > ConstValue.INT_32, "OrgAuthorityCode���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getCollectionType()), "CollectionType����Ϊ��;");
		addFilter(u -> dbLen(u.getCollectionType()) > ConstValue.INT_1, "CollectionType���ܴ���1λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDistrictCode()), "DistrictCode����Ϊ��;");
		addFilter(u -> dbLen(u.getDistrictCode()) > ConstValue.INT_6, "DistrictCode���ܴ���6λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getVioSiteCode()), "VioSiteCode����Ϊ��;");
		addFilter(u -> dbLen(u.getVioSiteCode()) > ConstValue.INT_16, "VioSiteCode���ܴ���16λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getAddressDesc()), "AddressDesc����Ϊ��;");
		addFilter(u -> dbLen(u.getAddressDesc()) > ConstValue.INT_128, "AddressDesc���ܴ���128λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getRoadCode()), "RoadCode����Ϊ��;");
		addFilter(u -> dbLen(u.getRoadCode()) > ConstValue.INT_6, "RoadCode���ܴ���6λ;");
		addFilter(u -> dbLen(u.getRoadSectionCode()) > ConstValue.INT_4, "RoadSectionCode���ܴ���4λ;");
		addFilter(u -> !isRightDbNum(u.getMileage(), ConstValue.INT_4), "Mileage����������λ����4λС��λ����0������;");
		addFilter(u -> dbLen(u.getDirectionType()) > ConstValue.INT_2, "DirectionType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getDirectionName()) > ConstValue.INT_32, "DirectionName���ܴ���32λ;");
		addFilter(u -> dbLen(u.getLaneNbr()) > ConstValue.INT_2, "LaneNbr���ܴ���2λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getPlateNbr()), "PlateNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getPlateNbr()) > ConstValue.INT_16, "PlateNbr���ܴ���16λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getPlateType()), "PlateType����Ϊ��;");
		addFilter(u -> dbLen(u.getPlateType()) > ConstValue.INT_2, "PlateType���ܴ���2λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getPlateColor()), "PlateColor����Ϊ��;");
		addFilter(u -> dbLen(u.getPlateColor()) > ConstValue.INT_2, "PlateColor���ܴ���2λ;");
		addFilter(u -> u.getViolationTime() == null, "ViolationTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getViolationTime()), "ViolationTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getViolationType()), "ViolationType����Ϊ��;");
		addFilter(u -> dbLen(u.getViolationType()) > ConstValue.INT_2, "ViolationType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getViolationCode()) > ConstValue.INT_8, "ViolationCode���ܴ���8λ;");
		addFilter(u -> dbLen(u.getViolationDesc()) > ConstValue.INT_128, "ViolationDesc���ܴ���128λ;");
		addFilter(u -> !isRightDbNum(u.getSpeed(), ConstValue.INT_5), "Speed����������λ����5λС��λ����0������;");
		addFilter(u -> !isRightDbNum(u.getLimitLarge(),ConstValue.INT_10), "LimitLarge����������λ����10λС��λ����0������;");
		addFilter(u -> !isRightDbNum(u.getLimitSmall(),ConstValue.INT_10), "LimitSmall����������λ����10λС��λ����0������;");
        addFilter(u -> !isRightDbNum(u.getLimitLower(),ConstValue.INT_5), "LimitLower����������λ����5λС��λ����0������;");
		addFilter(u -> !isRightDbNum(u.getOverSpeedPercent(),ConstValue.INT_5), "OverSpeedPercent����������λ����5λС��λ����0������;");
		addFilter(u -> dbLen(u.getEntrySiteCode()) > ConstValue.INT_12, "EntrySiteCode���ܴ���12λ;");
		addFilter(u -> is1HMoreThanNow(u.getRegionEntryTime()), "RegionEntryTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> !isRightDbNum(u.getRegionDistance(),ConstValue.INT_10), "RegionDistance����������λ����10λС��λ����0������;");
		addFilter(u -> is1HMoreThanNow(u.getRedLightBeginTime()), "RedLightBeginTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> is1HMoreThanNow(u.getRedLightEndTime()), "RedLightEndTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getSpeedingType()) > ConstValue.INT_1, "SpeedingType���ܴ���1λ;");
		addFilter(u -> dbLen(u.getSpecialVehType()) > ConstValue.INT_1, "SpecialVehType���ܴ���1λ;");
		addFilter(u -> dbLen(u.getImage()) > ConstValue.INT_1024, "Image���ܴ���1024λ;");
		addFilter(u -> dbLen(u.getVideo()) > ConstValue.INT_1024, "Video���ܴ���1024λ;");
		addFilter(u -> dbLen(u.getRemark()) > ConstValue.INT_256, "Remark���ܴ���256λ;");
		addFilter(u -> dbLen(u.getVehLocalization()) > ConstValue.INT_1, "VehLocalization���ܴ���1λ;");
		addFilter(u -> dbLen(u.getDeviceNbr()) > ConstValue.INT_32, "DeviceNbr���ܴ���32λ;");
		addFilter(u -> dbLen(u.getCrossCode()) > ConstValue.INT_12, "CrossCode���ܴ���12λ;");
	}
}
