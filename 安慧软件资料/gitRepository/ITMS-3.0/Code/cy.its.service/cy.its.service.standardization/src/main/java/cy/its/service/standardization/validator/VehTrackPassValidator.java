package cy.its.service.standardization.validator;


import cy.its.service.common.dataModel.VehTrackPass;
import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;

public class VehTrackPassValidator extends BaseValidator<VehTrackPass> {

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getSnapNbr()), "SnapNbr����Ϊ��;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceSysNbr()), "DeviceSysNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_18, "DeviceSysNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getSnapNbr()) > ConstValue.INT_32, "SnapNbr���ܴ���32λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceNbr()), "DeviceNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceNbr()) > ConstValue.INT_18, "DeviceNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getDistrictCode()) > ConstValue.INT_6, "DistrictCode���ܴ���6λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getSiteCode()), "SiteCode����Ϊ��;");
		addFilter(u -> dbLen(u.getSiteCode()) > ConstValue.INT_16, "SiteCode���ܴ���16λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getRoadCode()), "RoadCode����Ϊ��;");
		addFilter(u -> dbLen(u.getRoadCode()) > ConstValue.INT_6, "RoadCode���ܴ���6λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getRoadType()), "RoadType����Ϊ��;");
		addFilter(u -> dbLen(u.getRoadType()) > ConstValue.INT_2, "RoadType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getRoadSectionCode()) > ConstValue.INT_4, "RoadSectionCode���ܴ���4λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDirectionName()), "DirectionName����Ϊ��;");
		addFilter(u -> dbLen(u.getDirectionName()) > ConstValue.INT_128, "DirectionName���ܴ���128λ;");
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDirectionType()), "DirectionType����Ϊ��;");
		addFilter(u -> dbLen(u.getDirectionType()) > ConstValue.INT_2, "DirectionType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getLane()) > ConstValue.INT_2, "Lane���ܴ���2λ;");
		addFilter(u -> dbLen(u.getPlateNbr()) > ConstValue.INT_16, "PlateNbr���ܴ���16λ;");
		addFilter(u -> dbLen(u.getPlateColor()) > ConstValue.INT_2, "PlateColor���ܴ���2λ;");
		addFilter(u -> dbLen(u.getPlateType()) > ConstValue.INT_2, "PlateType���ܴ���2λ;");
		addFilter(u -> dbLen(u.getTailPlateNbr()) > ConstValue.INT_16, "TailPlateNbr���ܴ���16λ;");
		addFilter(u -> dbLen(u.getTailPlateColor()) > ConstValue.INT_2, "TailPlateColor���ܴ���2λ;");
		addFilter(u -> dbLen(u.getVehicleBrand()) > ConstValue.INT_32, "VehicleBrand���ܴ���32λ;");
		addFilter(u -> dbLen(u.getVehicleSubBrand()) > ConstValue.INT_32, "VehicleSubBrand���ܴ���32λ;");
		addFilter(u -> dbLen(u.getVehicleType()) > ConstValue.INT_3, "VehicleType���ܴ���3λ;");
		addFilter(u -> dbLen(u.getVehCharcter()) > ConstValue.INT_2, "VehCharcter���ܴ���2λ;");
		addFilter(u -> dbLen(u.getVehicleShape()) > ConstValue.INT_2, "VehicleShape���ܴ���2λ;");
		addFilter(u -> !isRightDbNum(u.getVehicleLength(), ConstValue.INT_4, ConstValue.INT_2), "VehicleLength����������λ����2λС��λ����2������;");
		addFilter(u -> dbLen(u.getVehicleColor()) > ConstValue.INT_5, "VehicleColor���ܴ���5λ;");
		addFilter(u -> u.getPassTime() == null, "PassTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getPassTime()), "PassTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> !isRightDbNum(u.getSpeed(), ConstValue.INT_5), "Speed����������λ����5λС��λ����0������;");
		addFilter(u -> dbLen(u.getDriveMode()) > ConstValue.INT_4, "DriveMode���ܴ���4λ;");
		addFilter(u -> dbLen(u.getVehLocalization()) > ConstValue.INT_1, "VehLocalization���ܴ���1λ;");
		addFilter(u -> dbLen(u.getVehCategory()) > ConstValue.INT_1, "VehCategory���ܴ���1λ;");
		addFilter(u -> dbLen(u.getOrgCode()) > ConstValue.INT_32, "OrgCode���ܴ���32λ;");
		addFilter(u -> dbLen(u.getOrgAuthorityCode()) > ConstValue.INT_32, "OrgAuthorityCode���ܴ���32λ;");
		addFilter(u -> dbLen(u.getImageUrlPath()) > ConstValue.INT_256, "ImageUrlPath���ܴ���256λ;");
		addFilter(u -> dbLen(u.getImageUrl1()) > ConstValue.INT_128, "ImageUrl1���ܴ���128λ;");
		addFilter(u -> dbLen(u.getImageUrl2()) > ConstValue.INT_128, "ImageUrl2���ܴ���128λ;");
		addFilter(u -> dbLen(u.getImageUrl3()) > ConstValue.INT_128, "ImageUrl3���ܴ���128λ;");
		addFilter(u -> dbLen(u.getVehiclePlatePlace()) > ConstValue.INT_32, "VehiclePlatePlace���ܴ���32λ;");
		addFilter(u -> dbLen(u.getFacePlace()) > ConstValue.INT_32, "FacePlace���ܴ���32λ;");
		addFilter(u -> !isRightDbNum(u.getTransferDelay(), ConstValue.INT_10), "TransferDelay����������λ����10λС��λ����0������;");
		addFilter(u -> dbLen(u.getHighwayAccessFlag()) > ConstValue.INT_1, "HighwayAccessFlag���ܴ���1λ;");
		addFilter(u -> dbLen(u.getServiceAreaAccessFlag()) > ConstValue.INT_1, "ServiceAreaAccessFlag���ܴ���1λ;");
		addFilter(u -> dbLen(u.getErtranceOrExit()) > ConstValue.INT_1, "ErtranceOrExit���ܴ���1λ;");
	}
}
