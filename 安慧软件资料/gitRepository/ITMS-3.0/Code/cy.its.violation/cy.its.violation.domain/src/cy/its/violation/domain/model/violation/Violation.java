package cy.its.violation.domain.model.violation;

import java.util.Date;

import cy.its.com.domain.AggregateRoot;
import cy.its.violation.domain.criteria.ConstantCode;

/**
 * @author Administrator
 *
 */
public class Violation extends AggregateRoot {

	/**
	 * Υ��֤��ID
	 */
	public String violationId;

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
	private String roadSectionCode;

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
	private Date violationTime;

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
	public Date regionEntryTime;

	/**
	 * �������
	 */
	public Long regionDistance;

	/**
	 * ��ƿ�ʼʱ��
	 */
	public Date redLightBeginTime;

	/**
	 * ��ƽ���ʱ��
	 */
	public Date redLightEndTime;

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
	public Date exportTime;

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
	public Date lockTime;

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
	public Date entryTime;

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
	public Date uploadTime;

	/**
	*
	*/
	public Date createTime;

	/**
	*
	*/
	public Date updateTime;

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

	private String discardedBy;

	private Date discardedTime;

	private String getDeviceNBr() {
		return deviceNBr;
	}

	private void setDeviceNBr(String deviceNBr) {
		this.deviceNBr = deviceNBr;
	}

	private String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}

	private void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
	}

	private String getCrossCode() {
		return crossCode;
	}

	private void setCrossCode(String crossCode) {
		this.crossCode = crossCode;
	}

	private String deviceNBr;

	private String orgAuthorityCode;

	private String crossCode;

	/**
	 * Υ��¼��
	 * 
	 * @param input
	 * @throws Exception
	 */
	public void excuteInput(ViolationInput input) throws Exception {
		input.Excute(this);
	}

	public String getViolationId() {
		return violationId;
	}

	public void setViolationId(String violationId) {
		this.violationId = violationId;
	}

	public String getDeviceNbr() {
		return deviceSysNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceSysNbr = deviceNbr;
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

	public String getRoadSectionCode() {
		return roadSectionCode;
	}

	public void setRoadSectionCode(String roadSectionCode) {
		this.roadSectionCode = roadSectionCode;
	}

	public String getPlateNbr() {
		return plateNbr;
	}

	public void setPlateNbr(String plateNbr) throws Exception {
		NotNull(plateNbr, "���ƺ���");
		this.plateNbr = plateNbr;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) throws Exception {
		NotNull(plateNbr, "��������");
		this.plateType = plateType;
	}

	public String getPlateColor() {
		return plateColor;
	}

	public void setPlateColor(String plateColor) throws Exception {
		NotNull(plateNbr, "������ɫ");
		this.plateColor = plateColor;
	}

	public Date getViolationTime() {
		return violationTime;
	}

	public void setViolationTime(Date violationTime) {
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

	public void setViolationCode(String violationCode) throws Exception {
		NotNull(violationCode, "Υ������");
		this.violationCode = violationCode;
	}

	public String getViolationDesc() {
		return violationDesc;
	}

	public void setViolationDesc(String violationDesc) throws Exception {
		NotNull(violationDesc, "Υ������");
		this.violationDesc = violationDesc;
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

	public String getLockFlag() {
		return lockFlag;
	}

	public void setLockFlag(String lockFlag) {

		this.lockFlag = lockFlag;
	}

	public String getStatusFlag() {
		return statusFlag;
	}

	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	public String getDiscardedBy() {
		return discardedBy;
	}

	public void setDiscardedBy(String discardedBy) {
		this.discardedBy = discardedBy;
	}

	public Date getDiscardedTime() {
		return discardedTime;
	}

	public void setDiscardedTime(Date discardedTime) {
		this.discardedTime = discardedTime;
	}

	@Override
	public String getIdentityId() {
		return this.violationId;
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

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getSnapNbr() {
		return snapNbr;
	}

	public void setSnapNbr(String snapNbr) {
		this.snapNbr = snapNbr;
	}

	public String getCollectionPolice() {
		return collectionPolice;
	}

	public void setCollectionPolice(String collectionPolice) {
		this.collectionPolice = collectionPolice;
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

	public Date getRegionEntryTime() {
		return regionEntryTime;
	}

	public void setRegionEntryTime(Date regionEntryTime) {
		this.regionEntryTime = regionEntryTime;
	}

	public Long getRegionDistance() {
		return regionDistance;
	}

	public void setRegionDistance(Long regionDistance) {
		this.regionDistance = regionDistance;
	}

	public Date getRedLightBeginTime() {
		return redLightBeginTime;
	}

	public void setRedLightBeginTime(Date redLightBeginTime) {
		this.redLightBeginTime = redLightBeginTime;
	}

	public Date getRedLightEndTime() {
		return redLightEndTime;
	}

	public void setRedLightEndTime(Date redLightEndTime) {
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

	public Date getExportTime() {
		return exportTime;
	}

	public void setExportTime(Date exportTime) {
		this.exportTime = exportTime;
	}

	public String getLockUser() {
		return lockUser;
	}

	public void setLockUser(String lockUser) {
		this.lockUser = lockUser;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getEntryBy() {
		return entryBy;
	}

	public void setEntryBy(String entryBy) {
		this.entryBy = entryBy;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
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

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
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

	private Violation(String deviceNbr, String orgCode, String collectionType, String districtCode, String vioSiteCode,
			String addressDesc, String roadCode, String roadSectionCode, String plateNbr, String plateType,
			String plateColor, Date violationTime, String violationType, String violationCode, String violationDesc,
			String localPunishFlag, String exportFlag, String lockFlag, String statusFlag) {
		this.deviceSysNbr = deviceNbr;
		this.orgCode = orgCode;
		this.collectionType = collectionType;
		this.districtCode = districtCode;
		this.vioSiteCode = vioSiteCode;
		this.addressDesc = addressDesc;
		this.roadCode = roadCode;
		this.roadSectionCode = roadSectionCode;
		this.plateNbr = plateNbr;
		this.plateType = plateType;
		this.plateColor = plateColor;
		this.violationTime = violationTime;
		this.violationType = violationType;
		this.violationCode = violationCode;
		this.violationDesc = violationDesc;
		this.localPunishFlag = localPunishFlag;
		this.exportFlag = exportFlag;
		this.lockFlag = lockFlag;
		this.statusFlag = statusFlag;
	}

	public Violation(String deviceNbr, String orgCode, String collectionType, String districtCode, String vioSiteCode,
			String addressDesc, String roadCode, String roadSectionCode, String plateNbr, String plateType,
			String plateColor, Date violationTime, String violationType, String violationCode, String violationDesc) {

		this(deviceNbr, orgCode, collectionType, districtCode, vioSiteCode, addressDesc, roadCode, roadSectionCode,
				plateNbr, plateType, plateColor, violationTime, violationType, violationCode, violationDesc, "0", "0",
				"0", "0");
	}

	public Violation(String violationId, String deviceNbr, String orgCode, String collectionType, String districtCode,
			String vioSiteCode, String addressDesc, String roadCode, String roadSectionCode, String plateNbr,
			String plateType, String plateColor, Date violationTime, String violationType, String violationCode,
			String violationDesc, String localPunishFlag, String exportFlag, String lockFlag, String statusFlag) {
		this(deviceNbr, orgCode, collectionType, districtCode, vioSiteCode, addressDesc, roadCode, roadSectionCode,
				plateNbr, plateType, plateColor, violationTime, violationType, violationCode, violationDesc,
				localPunishFlag, exportFlag, lockFlag, statusFlag);
		this.violationId = violationId;
	}

	public Violation() {
	}

	/**
	 * 
	 * @param input
	 * @throws Exception
	 */
	public Violation(ViolationInput input) throws Exception {
		input.Excute(this);
	}

	/**
	 * �����ϴ�ʧ��Υ���Ա��ٴ��ϴ�
	 * 
	 * @param roadCode
	 *            ��·����
	 * @param orgCode
	 *            ��������
	 * @param police
	 *            ��Ա
	 * @param uploadBy
	 *            �ϴ���
	 */
	public void verifyForReadyUpload(String roadCode, String orgCode, String uploadBy) {
		this.setRoadCode(roadCode);
		this.setOrgCode(orgCode);
		this.uploadBy = uploadBy;
		this.setUploadFlag(ConstantCode.UploadFlag.WAITING);
		this.updateTime = new Date();
	}

	/**
	 * ����
	 */
	public void Import() {

	}

	/**
	 * �޸��ϴ�״̬Ϊ���ϴ�
	 * 
	 * @param uploadBy
	 */
	public void readyUpload(String uploadBy) {
		this.setUploadFlag(ConstantCode.UploadFlag.WAITING);
		this.uploadBy = uploadBy;
		this.updateTime = new Date();
	}

	/**
	 * �޸��ϴ�״̬Ϊȡ���ϴ�
	 * 
	 * @param uploadBy
	 */
	public void cancelUpload(String uploadBy) {
		this.setUploadFlag(ConstantCode.UploadFlag.CANCEL);
		this.uploadBy = "";
		this.updateTime = new Date();
	}

	/**
	 * ��¼
	 * 
	 * @param opUser
	 */
	public void reInputViolation(String opUser) {
		this.setStatusFlag(ConstantCode.StatusFlag.RECONFIRM);
		this.updateTime = new Date();
	}

	/**
	 * ȷ��¼��
	 */
	public void confirmInput() {
		this.setStatusFlag(ConstantCode.StatusFlag.CONFIRMED);
		this.setUploadFlag(ConstantCode.UploadFlag.NEW);
		this.updateTime = new Date();
	}

	/**
	 * ɸѡͨ��
	 * 
	 * @param opUser
	 */
	public void filter(String opUser) {
		this.setStatusFlag(ConstantCode.StatusFlag.FILTERED);
		this.exportTime = new Date();
		this.updateTime = new Date();
	}

	/**
	 * ������
	 */
	public void export() {

		this.setExportFlag(ConstantCode.BooleanFlag.TRUE);
		this.exportTime = new Date();
		this.updateTime = new Date();
	}

	/**
	 * ȷ�ϵ���
	 */
	public void confirmImport(String opUser) {
		this.setStatusFlag(ConstantCode.StatusFlag.NEW);
		this.setUploadFlag(ConstantCode.UploadFlag.NEW);
		this.createTime = new Date();
	}

	/**
	 * ȷ�Ϸ���
	 */
	public void confirmAbandon() {
		this.setStatusFlag(ConstantCode.StatusFlag.DISCARDED);
		this.setUploadFlag(ConstantCode.UploadFlag.NEW);
		this.updateTime = new Date();
	}

	/**
	 * ��ԭ����Υ��
	 */
	public void restoreAbandon() {
		this.setStatusFlag(ConstantCode.StatusFlag.NEW);
		this.setUploadFlag(ConstantCode.UploadFlag.NEW);
		this.discardedTime = new Date(0);
		this.updateTime = new Date();
	}

	/**
	 * ¼������
	 * 
	 * @throws Exception
	 */
	public void lockForInput(String lockUser) throws Exception {
		if ("1".equals(this.lockFlag)) {
			throw new Exception("��ǰΥ����¼�ѱ�����,��ֹ����¼��!");
		}

		// ����������
		this.setLockFlag("1");
		this.lockTime = new Date();
		this.lockUser = lockUser;
	}

	/**
	 * ���¼������
	 */
	public void unlockForInput() {
		// ����δ����
		this.setLockFlag("0");
		this.lockTime = new Date();
		this.lockUser = "";
	}
}
