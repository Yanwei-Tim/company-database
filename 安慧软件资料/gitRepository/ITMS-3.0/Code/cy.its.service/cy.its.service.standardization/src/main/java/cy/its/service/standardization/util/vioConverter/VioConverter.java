package cy.its.service.standardization.util.vioConverter;

//import java.util.Arrays;
import java.util.Map;
//import java.util.stream.Collectors;

import cy.its.service.common.ConstValue;
import cy.its.service.common.DateUtil;
//import cy.its.service.common.ImageUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.Violation;
import cy.its.service.common.ioc.Import;
import cy.its.service.standardization.dataMaker.originalModel.SpeedLimit;
import cy.its.service.standardization.dataMaker.originalModel.ViolationVehicle;
import cy.its.service.standardization.dictionary.VioActionCache;
import cy.its.service.standardization.dictionary.model.VioAction;
import cy.its.service.standardization.util.Config;

public abstract class VioConverter {

	@Import
	VioActionCache vioActionCache;

	void commonFormat(ViolationVehicle v, Violation info, String driveMode) {
		formatOriginal(v, info);
		formatPlate(v, info);
		formatVioType(v, info);
		// ���㳬�ٱ�
		formatOverSpeedPercent(v, info, driveMode);
		formatVehLocal(v, info);
	}

	/**
	 * ֱ�Ӵ�ԭʼΥ����ȡ����
	 * 
	 * @param v
	 * @param info
	 */
	void formatOriginal(ViolationVehicle v, Violation info) {
		info.setSnapNbr(v.getSnapNbr());
		info.setLaneNbr(String.valueOf(v.getLane()));
		info.setViolationTime(DateUtil.parseDate(v.getCaptureTime()));
		info.setSpeed(v.getVehicleSpeed());
		info.setRedLightBeginTime(DateUtil.parseDate(v.getRedlightTime()));
//		info.setDeviceTime(info.getViolationTime().getTime());
		formatImage(v, info);
	}

	String fmt = "F:%d-%s-%s";

	/**
	 * ��ʽ��ͼƬ��ַ
	 * 
	 * @param v
	 * @param info
	 */
	void formatImage(ViolationVehicle v, Violation info) {
		Map<String, String> ext = v.getExtendedProperties();
		if (ext != null) {
			String imgUrls = ext.get(ConstValue.STR_IMAGE_URLS);
			if (!StringUtil.isNullOrEmpty(imgUrls)) {
//				info.setImage(String.join(ConstValue.SEMICOLON, Arrays.stream(imgUrls.split(ConstValue.SEMICOLON))
//						.map(s -> ImageUtil.encryptUrl(s)).collect(Collectors.toList())));
				info.setImage(String.join(ConstValue.SEMICOLON, imgUrls.split(ConstValue.SEMICOLON)));
			}
		}
		ext = null;

		if (StringUtil.isNullOrEmpty(info.getImage())) {
			String[] lst = new String[v.getImageDescriptions() != null ? v.getImageDescriptions().length
					: ConstValue.INT_2];
			for (int i = ConstValue.INT_0; i < lst.length; i++) {
//				lst[i] = ImageUtil.encryptUrl(String.format(fmt, i, v.getDeviceNo(), v.getSnapNbr()));
				lst[i] = String.format(fmt, i, v.getDeviceNo(), v.getSnapNbr());
			}

			info.setImage(String.join(ConstValue.SEMICOLON, lst));
		}
	}

	/**
	 * ����������
	 * 
	 * @param v
	 * @param info
	 */
	void formatVehLocal(ViolationVehicle v, Violation info) {
		// ��ȡ����������
		// ���������� 0-δ֪��1-���С�2-��ʡ,3-��ʡ,4-������
		if (StringUtil.isNullOrEmpty(v.getPlateNbr())) {
			info.setVehLocalization(ConstValue.STR_ZERO);
		} else if (ConstValue.STR_ZERO.equals(v.getPlateColor())) {
			info.setVehLocalization(ConstValue.STR_FOUR);
		} else if (info.getPlateNbr().startsWith(Config.DEFAULT_VEHICLE_CITY)) {
			info.setVehLocalization(ConstValue.STR_ONE);
		} else if (info.getPlateNbr().startsWith(Config.DEFAULT_VEHICLE_PROVINCE)) {
			info.setVehLocalization(ConstValue.STR_TWO);
		} else {
			info.setVehLocalization(ConstValue.STR_THREE);
		}
	}

	/**
	 * Υ������
	 * 
	 * @param v
	 * @param info
	 */
	void formatVioType(ViolationVehicle v, Violation info) {
		if (v.getViolationBehaviors() != null && v.getViolationBehaviors().length > ConstValue.INT_0) {
			String vioCode = v.getViolationBehaviors()[ConstValue.INT_0];
			VioAction vioAct = vioActionCache.get(vioCode);

			if (vioAct != null) {
				info.setViolationType(vioAct.getVioType());
				info.setViolationCode(vioCode);
				info.setViolationDesc(vioAct.getVioSummary());
			}
		}
	}

	/**
	 * �������
	 * 
	 * @param v
	 * @param info
	 */
	void formatPlate(ViolationVehicle v, Violation info) {
		// �������
		String plateNbr = v.getPlateNbr();
		if (StringUtil.isNullOrEmpty(plateNbr) || StringUtil.isNullOrEmpty(plateNbr.trim())
				|| plateNbr.trim().length() < ConstValue.INT_7) {
			info.setPlateNbr(ConstValue.STR_UNKNOWN);
		} else {
			info.setPlateNbr(plateNbr);
		}

		String plateType = v.getPlateType();
		info.setPlateType(!StringUtil.isNullOrEmpty(plateType) ? StringUtil.padLeft(plateType, ConstValue.INT_2, ConstValue.CHAR_ZERO)
				: plateType);
		info.setPlateColor(v.getPlateColor());
		if (StringUtil.isNullOrEmpty(info.getPlateType())) {
			if (ConstValue.STR_TWO.equals(v.getPlateColor())) {
				info.setPlateType(ConstValue.STR_02);
			} else {
				info.setPlateType(ConstValue.STR_01);
			}
		}
	}

	/**
	 * ���㳬�ٱ�
	 * 
	 * @param v
	 * @param info
	 * @param driveMode
	 */
	void formatOverSpeedPercent(ViolationVehicle v, Violation info, String driveMode) {
		if (ConstValue.STR_ZERO.equals(driveMode) || ConstValue.STR_REGIONAL.equals(driveMode)) {
			// ������
			if (ConstValue.STR_01.equals(v.getVehicleType())) {
				if (info.getLimitLarge() > ConstValue.INT_0) {
					info.setOverSpeedPercent(
							(info.getSpeed() - info.getLimitLarge()) * ConstValue.INT_100 / info.getLimitLarge());
				}
			} else if (ConstValue.STR_02.equals(v.getVehicleType())) {
				if (info.getLimitSmall() > ConstValue.INT_0) {
					info.setOverSpeedPercent(
							(info.getSpeed() - info.getLimitSmall()) * ConstValue.INT_100 / info.getLimitSmall());
				}
			} else {
				if (info.getLimitSmall() > ConstValue.INT_0) {
					info.setOverSpeedPercent(
							(info.getSpeed() - info.getLimitSmall()) * ConstValue.INT_100 / info.getLimitSmall());
				}
			}
		} else if (ConstValue.STR_ONE.equals(driveMode)) {
			// ������
			if (info.getLimitLower() > info.getSpeed()) {
				info.setOverSpeedPercent(
						(info.getLimitLower() - info.getSpeed()) * ConstValue.INT_100 / info.getLimitLower());
			}
		}
	}

	/**
	 * ��ȡ����ֵ
	 * 
	 * @param v
	 * @param info
	 * @return
	 */
	Boolean formatSpeedLimit(ViolationVehicle v, Violation info) {
		if (v.getRoadSpeedLimits() == null) {
			return false;
		}

		for (SpeedLimit limit : v.getRoadSpeedLimits()) {
			if (limit != null) {
				if (v.getLane() == limit.getLane()) {
					switch (limit.getVehicleType()) {
					case ConstValue.STR_01:
						info.setLimitLarge(limit.getRoadOverSpeedLimit());
						break;
					case ConstValue.STR_02:
						info.setLimitSmall(limit.getRoadOverSpeedLimit());
						break;
					case ConstValue.STR_00:
						info.setLimitLower(limit.getRoadUnderSpeedLimit());
						break;
					default:
						break;
					}
				}
			}
		}

		return true;
	}

}
