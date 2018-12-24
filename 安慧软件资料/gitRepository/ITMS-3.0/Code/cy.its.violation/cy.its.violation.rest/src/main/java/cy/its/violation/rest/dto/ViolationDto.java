package cy.its.violation.rest.dto;

public class ViolationDto {

	public ViolationDto() {
		// todo
	}

	/**
	 * Υ��֤��ID
	 */
	private String violationId;

	/**
	 * ������Ϣ��ID
	 */
	public String vehicleRegId;

	/**
	 * �豸/������
	 */
	public String deviceSysNbr;

	/**
	 * ץ�ı��
	 */
	public String snapNbr;

	/**
	*
	*/
	private String orgCode;

	/**
	 * 1��������豸 2����·�����豸 3�������豸 4����·���� 5���ƶ����� 6������ͨ 7��������� 8�����Ƕ�λװ�� 9�����������豸
	 */
	private String collectionType;

	/**
	*
	*/
	public String collectionPolice;

	/**
	*
	*/
	private String districtCode;

	/**
	*
	*/
	private String vioSiteCode;

	/**
	 * Υ���ص�
	 */
	private String addressDesc;

	/**
	*
	*/
	private String roadCode;

	/**
	*
	*/
	private String junctionCode;

	/**
	*
	*/
	public Short mileage;

	/**
	 * 1�����У�2�����С�
	 */
	public String directionType;

	/**
	*
	*/
	public String directionName;

	/**
	*
	*/
	public String laneNbr;

	/**
	 * ���ƺ���
	 */
	private String plateNbr;

	/**
	 * ��������(002)
	 */
	private String plateType;

	/**
	 * ������ɫ(003)
	 */
	private String plateColor;

	/**
	 * Υ��ʱ��
	 */
	private String violationTime;

	/**
	 * Υ������(030)�� 0����ռ�� 1�������� 2�������� 3������ 4������� 5��ѹ���� 6��Υ��ͣ�� 7�����䳬�� 8������ 9������
	 * a��Υ��ռ�� b���ڵ����� c������������ʻ d��ѹ�� e��δϵ��ȫ��
	 */
	private String violationType;

	/**
	 * Υ������
	 */
	private String violationCode;

	/**
	 * Υ������
	 */
	private String violationDesc;

	/**
	 * ����
	 */
	public Integer speed;

	/**
	*
	*/
	public Long limitLarge;

	/**
	*
	*/
	public Long limitSmall;

	/**
	*
	*/
	public Integer limitLower;

	/**
	 * ���ٱ�
	 */
	public Integer overSpeedPercent;

	/**
	 * ��ڵ�λ����
	 */
	public String entrySiteCode;

	/**
	 * �������ʱ��
	 */
	public String regionEntryTime;

	/**
	 * �������
	 */
	public Long regionDistance;

	/**
	 * ��ƿ�ʼʱ��
	 */
	public String redLightBeginTime;

	/**
	 * ��ƽ���ʱ��
	 */
	public String redLightEndTime;

	/**
	 * 1 �ƶ����� 2 ������� 3 �̶������ 4 ������Ȧ���� 5 �����״����
	 */
	public String speedingType;

	/**
	*
	*/
	public String abnormalDataType;

	/**
	 * ���⳵������ 1�����Ƴ� 2�����Ƴ� 3���������� 4�������� 5��ũ�ó� 6��Ħ�г�
	 */
	public String specialVehType;

	/**
	 * ����ԭ��(312) 01 �쳣���� 02 ���⳵�� 21���Ƴ� 22 ���Ƴ� 23 �������� 24 ������ 25 ũ�ó� 26 Ħ�г� 03
	 * �ظ���¼ 04 ��Чͼ�� 05 ���Ʋ�ȫ 06 �޺��� 07 ��ʱ 08 ����
	 */
	public String discardedReason;

	/**
	 * �������(306), 1 ���ŷ��� 2 �Զ����� 3 ��������
	 */
	public String discardedType;

	/**
	 * ���ش�����ǣ�313��,0��δ������1���Ѵ�����
	 */
	private String localPunishFlag;

	/**
	 * ������ʶ(314),0��δ������1���ѵ�����
	 */
	private String exportFlag;

	/**
	 * ����ʱ��
	 */
	public String exportTime;

	/**
	 * ������ʶ,0��δ������1����������
	 */
	private String lockFlag;

	/**
	 * ������
	 */
	public String lockUser;

	/**
	 * ����ʱ��
	 */
	public String lockTime;

	/**
	 * ��¼״̬��301��,0���¼�¼��1����¼�룻2��������¼
	 */
	private String statusFlag;

	/**
	 * ¼����
	 */
	public String entryBy;

	/**
	 * ¼��ʱ��
	 */
	public String entryTime;

	/**
	 * �ϴ�״̬��305�� 0 δ�ϴ� 1 ���ϴ� 2 ���ϴ� 3 �ϴ�ʧ��
	 */
	public String uploadFlag;

	/**
	 * �ϴ���
	 */
	public String uploadBy;

	/**
	 * �ϴ�ʱ��
	 */
	public String uploadTime;

	/**
	*
	*/
	public String createTime;

	/**
	*
	*/
	public String updateTime;

	/**
	 * ͼƬ�洢·��
	 */
	public String image;

	/**
	 * ��Ƶ�洢·��
	 */
	public String video;

	/**
	*
	*/
	public String remark;

	public String getViolationId() {
		return violationId;
	}

	public void setViolationId(String violationId) {
		this.violationId = violationId;
	}

	public String getVehicleRegId() {
		return vehicleRegId;
	}

	public void setVehicleRegId(String vehicleRegId) {
		this.vehicleRegId = vehicleRegId;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceNbr) {
		this.deviceSysNbr = deviceNbr;
	}

	public String getSnapNbr() {
		return snapNbr;
	}

	public void setSnapNbr(String snapNbr) {
		this.snapNbr = snapNbr;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getCollectionPolice() {
		return collectionPolice;
	}

	public void setCollectionPolice(String collectionPolice) {
		this.collectionPolice = collectionPolice;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getVioSiteCode() {
		return vioSiteCode;
	}

	public void setVioSiteCode(String vioSiteCode) {
		this.vioSiteCode = vioSiteCode;
	}

	public String getAddressDesc() {
		return addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}

	public String getJunctionCode() {
		return junctionCode;
	}

	public void setJunctionCode(String junctionCode) {
		this.junctionCode = junctionCode;
	}

	public Short getMileage() {
		return mileage;
	}

	public void setMileage(Short mileage) {
		this.mileage = mileage;
	}

	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getLaneNbr() {
		return laneNbr;
	}

	public void setLaneNbr(String laneNbr) {
		this.laneNbr = laneNbr;
	}

	public String getPlateNbr() {
		return plateNbr;
	}

	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
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

	public String getViolationTime() {
		return violationTime;
	}

	public void setViolationTime(String violationTime) {
		this.violationTime = violationTime;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public String getViolationCode() {
		return violationCode;
	}

	public void setViolationCode(String violationCode) {
		this.violationCode = violationCode;
	}

	public String getViolationDesc() {
		return violationDesc;
	}

	public void setViolationDesc(String violationDesc) {
		this.violationDesc = violationDesc;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Long getLimitLarge() {
		return limitLarge;
	}

	public void setLimitLarge(Long limitLarge) {
		this.limitLarge = limitLarge;
	}

	public Long getLimitSmall() {
		return limitSmall;
	}

	public void setLimitSmall(Long limitSmall) {
		this.limitSmall = limitSmall;
	}

	public Integer getLimitLower() {
		return limitLower;
	}

	public void setLimitLower(Integer limitLower) {
		this.limitLower = limitLower;
	}

	public Integer getOverSpeedPercent() {
		return overSpeedPercent;
	}

	public void setOverSpeedPercent(Integer overSpeedPercent) {
		this.overSpeedPercent = overSpeedPercent;
	}

	public String getEntrySiteCode() {
		return entrySiteCode;
	}

	public void setEntrySiteCode(String entrySiteCode) {
		this.entrySiteCode = entrySiteCode;
	}

	public String getRegionEntryTime() {
		return regionEntryTime;
	}

	public void setRegionEntryTime(String regionEntryTime) {
		this.regionEntryTime = regionEntryTime;
	}

	public Long getRegionDistance() {
		return regionDistance;
	}

	public void setRegionDistance(Long regionDistance) {
		this.regionDistance = regionDistance;
	}

	public String getRedLightBeginTime() {
		return redLightBeginTime;
	}

	public void setRedLightBeginTime(String redLightBeginTime) {
		this.redLightBeginTime = redLightBeginTime;
	}

	public String getRedLightEndTime() {
		return redLightEndTime;
	}

	public void setRedLightEndTime(String redLightEndTime) {
		this.redLightEndTime = redLightEndTime;
	}

	public String getSpeedingType() {
		return speedingType;
	}

	public void setSpeedingType(String speedingType) {
		this.speedingType = speedingType;
	}

	public String getAbnormalDataType() {
		return abnormalDataType;
	}

	public void setAbnormalDataType(String abnormalDataType) {
		this.abnormalDataType = abnormalDataType;
	}

	public String getSpecialVehType() {
		return specialVehType;
	}

	public void setSpecialVehType(String specialVehType) {
		this.specialVehType = specialVehType;
	}

	public String getDiscardedReason() {
		return discardedReason;
	}

	public void setDiscardedReason(String discardedReason) {
		this.discardedReason = discardedReason;
	}

	public String getDiscardedType() {
		return discardedType;
	}

	public void setDiscardedType(String discardedType) {
		this.discardedType = discardedType;
	}

	public String getLocalPunishFlag() {
		return localPunishFlag;
	}

	public void setLocalPunishFlag(String localPunishFlag) {
		this.localPunishFlag = localPunishFlag;
	}

	public String getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(String exportFlag) {
		this.exportFlag = exportFlag;
	}

	public String getExportTime() {
		return exportTime;
	}

	public void setExportTime(String exportTime) {
		this.exportTime = exportTime;
	}

	public String getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(String lockFlag) {
		this.lockFlag = lockFlag;
	}

	public String getLockUser() {
		return lockUser;
	}

	public void setLockUser(String lockUser) {
		this.lockUser = lockUser;
	}

	public String getLockTime() {
		return lockTime;
	}

	public void setLockTime(String lockTime) {
		this.lockTime = lockTime;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public String getUploadFlag() {
		return uploadFlag;
	}

	public void setUploadFlag(String uploadFlag) {
		this.uploadFlag = uploadFlag;
	}

	public String getUploadBy() {
		return uploadBy;
	}

	public void setUploadBy(String uploadBy) {
		this.uploadBy = uploadBy;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
