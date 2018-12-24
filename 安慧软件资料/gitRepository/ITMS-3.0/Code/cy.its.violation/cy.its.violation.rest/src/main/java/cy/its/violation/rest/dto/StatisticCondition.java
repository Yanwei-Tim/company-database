package cy.its.violation.rest.dto;

public class StatisticCondition {

	public int pageNumber;

	public int pageSize;

	public int dataIndex;

	public String seriesName;

	public Boolean ViolationRedLight;

	public Boolean getIsArmyPlate() {
		return isArmyPlate;
	}

	public void setIsArmyPlate(Boolean isArmyPlate) {
		this.isArmyPlate = isArmyPlate;
	}

	public Boolean getIsUnknownPlate() {
		return isUnknownPlate;
	}

	public void setIsUnknownPlate(Boolean isUnknownPlate) {
		this.isUnknownPlate = isUnknownPlate;
	}

	public Boolean isArmyPlate;

	public Boolean isUnknownPlate;

	public Boolean getViolationRedLight() {
		return ViolationRedLight;
	}

	public void setViolationRedLight(Boolean violationRedLight) {
		ViolationRedLight = violationRedLight;
	}

	public int getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(int dataIndex) {
		this.dataIndex = dataIndex;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getViolationEndTime() {
		return violationEndTime;
	}

	public void setViolationEndTime(String violationEndTime) {
		this.violationEndTime = violationEndTime;
	}

	/**
	 * ��������
	 */
	public String operationName;

	/**
	 * ��ȷ���ƺ���
	 */
	public String plateNbr;

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String Total;

	public String Pages;

	/**
	 * ģ�����ƺ���
	 */
	public String fuzzyPlateNbr;

	/**
	 * ��������
	 */
	public String plateType;

	/**
	 * ������ɫ
	 */
	public String plateColor;

	/**
	 * �ɼ���λ
	 */
	public String orgCode;

	/**
	 * �ɼ��豸
	 */
	public String deviceNbr;

	/**
	 * Υ����ʼʱ��
	 */
	public String violationBeginTime;

	/**
	 * Υ������ʱ��
	 */
	public String violationEndTime;

	/**
	 * Υ������(030)�� 0����ռ�� 1�������� 2�������� 3������ 4������� 5��ѹ���� 6��Υ��ͣ�� 7�����䳬�� 8������ 9������
	 * a��Υ��ռ�� b���ڵ����� c������������ʻ d��ѹ�� e��δϵ��ȫ��
	 */
	public String violationType;

	/**
	 * ��¼״̬��301��,0���¼�¼��1����¼�룻2��������¼
	 */
	public String statusFlag;

	/**
	 * ����ԭ��(312) 01 �쳣���� 02 ���⳵�� 21���Ƴ� 22 ���Ƴ� 23 �������� 24 ������ 25 ũ�ó� 26 Ħ�г� 03
	 * �ظ���¼ 04 ��Чͼ�� 05 ���Ʋ�ȫ 06 �޺��� 07 ��ʱ 08 ����
	 */
	public String discardedReason;

	/**
	 * ��������ֵ
	 */
	public String speedMin;

	/**
	 * ��������ֵ
	 */
	public String speedMax;

	/**
	 * �ɼ���ʽ 1��������豸 2����·�����豸 3�������豸 4����·���� 5���ƶ����� 6������ͨ 7��������� 8�����Ƕ�λװ�� 9�����������豸
	 */
	public String collectionType;

	/**
	 * ������� ��1 �ƶ����� 2 ������� 3 �̶������ 4 ������Ȧ���� 5 �����״����
	 */
	public String speedingType;

	/**
	 * �ϴ���� 0 δ�ϴ� 1 ���ϴ� 2 ���ϴ� 3 �ϴ�ʧ��
	 */
	public String uploadFlag;

	/**
	 * ���⳵������
	 */
	public String specialVehType;

	/**
	 * �Ƿ�������⳵�� 0���: ������; 1:����;
	 */
	public String isIncludeSpecial;

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

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getDeviceNbr() {
		return deviceNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceNbr = deviceNbr;
	}

	public String getViolationBeginTime() {
		return violationBeginTime;
	}

	public void setViolationBeginTime(String violationBeginTime) {
		this.violationBeginTime = violationBeginTime;
	}

	public String getViolationEndTim() {
		return violationEndTime;
	}

	public void setViolationEndTim(String violationEndTim) {
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
