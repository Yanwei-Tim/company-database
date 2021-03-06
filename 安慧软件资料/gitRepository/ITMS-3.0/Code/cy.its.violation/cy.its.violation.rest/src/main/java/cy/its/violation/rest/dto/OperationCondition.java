package cy.its.violation.rest.dto;

import cy.its.com.dto.BaseDto;

public class OperationCondition extends BaseDto {

	public int pageNumber;

	public int pageSize;

	public String operationName;

	/**
	 * 精确号牌号码
	 */
	public String plateNbr;

	public String Total;

	public String Pages;

	/**
	 * 模糊号牌号码
	 */
	public String fuzzyPlateNbr;

	/**
	 * 号牌种类
	 */
	public String plateType;

	/**
	 * 号牌颜色
	 */
	public String plateColor;

	/**
	 * 采集单位
	 */
	public String orgId;

	/**
	 * 采集设备
	 */
	public String deviceSysNbr;

	/**
	 * 违法开始时间
	 */
	public String violationBeginTime;

	/**
	 * 违法结束时间
	 */
	public String violationEndTime;

	/**
	 * 上传开始时间
	 */
	public String uploadBeginTime;

	/**
	 * 上传结束时间
	 */
	public String uploadEndTime;
	/**
	 * 违法类型(030)： 0：大车占道 1：超高速 2：超低速 3：逆行 4：闯红灯 5：压黄线 6：违章停车 7：区间超速 8：禁行 9：其他
	 * a：违法占道 b：遮挡号牌 c：不按导向行驶 d：压线 e：未系安全带
	 */
	public String violationType;

	/**
	 * 记录状态（301）,0：新记录；1：已录入；2：废弃记录
	 */
	public String statusFlag;

	/**
	 * 废弃原因(312) 01 异常数据 02 特殊车辆 21套牌车 22 假牌车 23 白名单车 24 军警车 25 农用车 26 摩托车 03
	 * 重复记录 04 无效图像 05 号牌不全 06 无号牌 07 超时 08 其他
	 */
	public String discardedReason;

	/**
	 * 
	 */
	public String discardedType;

	/**
	 * 车速下限值
	 */
	public String speedMin;

	/**
	 * 车速上限值
	 */
	public String speedMax;

	/**
	 * 采集方式 1：闯红灯设备 2：公路卡口设备 3：测速设备 4：闭路电视 5：移动摄像 6：警务通 7：区间测速 8：卫星定位装置 9：其它电子设备
	 */
	public String collectionType;

	/**
	 * 测速类别 ：1 移动测速 2 区间测速 3 固定点测速 4 卡口线圈测速 5 卡口雷达测速
	 */
	public String speedingType;

	/**
	 * 上传标记 0 未上传 1 待上传 2 已上传 3 上传失败
	 */
	public String uploadFlag;

	/**
	 * 特殊车辆类型
	 */
	public String specialVehType;

	public String siteCodes;

	public String getSiteCodes() {
		return siteCodes;
	}

	public void setSiteCodes(String siteCodes) {
		this.siteCodes = siteCodes;
	}

	/**
	 * 是否包含特殊车辆 0或空: 不包含; 1:包含;
	 */
	public String isIncludeSpecial;

	public Boolean isArmyPlate;

	public Boolean isUnknownPlate;

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getUploadBeginTime() {
		return uploadBeginTime;
	}

	public void setUploadBeginTime(String uploadBeginTime) {
		this.uploadBeginTime = uploadBeginTime;
	}

	public String getUploadEndTime() {
		return uploadEndTime;
	}

	public void setUploadEndTime(String uploadEndTime) {
		this.uploadEndTime = uploadEndTime;
	}

	public String getDiscardedType() {
		return discardedType;
	}

	public void setDiscardedType(String discardedType) {
		this.discardedType = discardedType;
	}

	public Boolean getisArmyPlate() {
		return isArmyPlate;
	}

	public void setisArmyPlate(Boolean isArmyPlate) {
		isArmyPlate = isArmyPlate;
	}

	public Boolean getisUnknownPlate() {
		return isUnknownPlate;
	}

	public void setisUnknownPlate(Boolean isUnknownPlate) {
		isUnknownPlate = isUnknownPlate;
	}

	public String runStatus;

	public String getRunStatus() {
		return runStatus;
	}

	public void setRunStatus(String runStatus) {
		this.runStatus = runStatus;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNum) {
		this.pageNumber = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPlateNbr() {
		return plateNbr;
	}

	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
	}

	public String getTotal() {
		return Total;
	}

	public void setTotal(String total) {
		Total = total;
	}

	public String getPages() {
		return Pages;
	}

	public void setPages(String pages) {
		Pages = pages;
	}

	public String getFuzzyPlateNbr() {
		return fuzzyPlateNbr;
	}

	public void setFuzzyPlateNbr(String fuzzyPlateNbr) {
		this.fuzzyPlateNbr = fuzzyPlateNbr;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public void setPlateColor(String plateColor) {
		this.plateColor = plateColor;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getViolationBeginTime() {
		return violationBeginTime;
	}

	public void setViolationBeginTime(String violationBeginTime) {
		this.violationBeginTime = violationBeginTime;
	}

	public String getViolationEndTime() {
		return violationEndTime;
	}

	public void setViolationEndTime(String violationEndTim) {
		this.violationEndTime = violationEndTim;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getDiscardedReason() {
		return discardedReason;
	}

	public void setDiscardedReason(String discardedReason) {
		this.discardedReason = discardedReason;
	}

	public String getSpeedMin() {
		return speedMin;
	}

	public void setSpeedMin(String speedMin) {
		this.speedMin = speedMin;
	}

	public String getSpeedMax() {
		return speedMax;
	}

	public void setSpeedMax(String speedMax) {
		this.speedMax = speedMax;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getSpeedingType() {
		return speedingType;
	}

	public void setSpeedingType(String speedingType) {
		this.speedingType = speedingType;
	}

	public String getUploadFlag() {
		return uploadFlag;
	}

	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	public String getSpecialVehType() {
		return specialVehType;
	}

	public void setSpecialVehType(String specialVehType) {
		this.specialVehType = specialVehType;
	}

	public String getIsIncludeSpecial() {
		return isIncludeSpecial;
	}

	public void setIsIncludeSpecial(String isIncludeSpecial) {
		this.isIncludeSpecial = isIncludeSpecial;
	}

}
