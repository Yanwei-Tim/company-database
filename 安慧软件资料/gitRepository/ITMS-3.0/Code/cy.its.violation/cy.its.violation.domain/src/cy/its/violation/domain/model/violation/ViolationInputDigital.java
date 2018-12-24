package cy.its.violation.domain.model.violation;

import java.text.SimpleDateFormat;
import java.util.Date;

import cy.its.violation.domain.criteria.ConstantCode;

/**
 * �ɼ�����¼�� ��Ӧ��:����ȡ֤;��Ƶ���ȡ֤;��Ƶ¼��ȡ֤;
 * 
 * @author STJ
 *
 */
public class ViolationInputDigital extends ViolationInput {

	/**
	 * �豸/������
	 */
	private String deviceSysNbr;

	/**
	 * ץ�ı��
	 */
	public String snapNbr;

	/**
	 * �ɼ�����
	 */
	private String orgCode;

	/**
	 * �ɼ���Ա
	 */
	public String collectionPolice;

	/**
	 * �ɼ�����
	 */
	private String collectionType;

	/**
	 * ��������
	 */
	private String districtCode;

	/**
	 * Υ���ص����
	 */
	private String vioSiteCode;

	/**
	 * Υ���ص�����
	 */
	private String addressDesc;

	/**
	 * ��·
	 */
	private String roadCode;

	/**
	 * ·��·��
	 */
	private String roadSectionCode;

	/**
	 * ����
	 */
	public Short mileage;

	/**
	 * ���ƺ���
	 */
	private String plateNbr;

	/**
	 * ��������(002)
	 */
	private String plateType;

	/**
	 * ������ɫ
	 */
	private String plateColor;

	/**
	 * Υ��ʱ��
	 */
	private Date violationTime;

	/**
	 * Υ������
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
	 * ������ֵ
	 */
	public Long limitLarge;

	/**
	 * С������ֵ
	 */
	public Long limitSmall;

	/**
	 * ���ٱ�
	 */
	public Integer overSpeedPercent;

	/**
	 * ¼����
	 */
	public String entryBy;

	/**
	 * ͼƬ�洢·��
	 */
	public String image;

	/**
	 * ��Ƶ�洢·��
	 */
	public String video;

	static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS");

	public ViolationInputDigital(String deviceNbr, String snapNbr, String orgCode, String collectionPolice,
			String collectionType, String districtCode, String vioSiteCode, String addressDesc, String roadCode,
			String roadSectionCode, Short mileage, String plateNbr, String plateType, String plateColor,
			Date violationTime, String violationType, String violationCode, String violationDesc, Integer speed,
			Long limitLarge, Long limitSmall, Integer limitLower, Integer overSpeedPercent, String entryBy,
			Date entryTime, String uploadFlag, String uploadBy, String imageAddress) {

		this.deviceSysNbr = deviceNbr;
		this.snapNbr = snapNbr;
		this.orgCode = orgCode;
		this.collectionPolice = collectionPolice;
		this.collectionType = collectionType;
		this.districtCode = districtCode;
		this.vioSiteCode = vioSiteCode;
		this.addressDesc = addressDesc;
		this.roadCode = roadCode;
		this.roadSectionCode = roadSectionCode;
		this.mileage = mileage;
		this.plateNbr = plateNbr;
		this.plateType = plateType;
		this.plateColor = plateColor;
		this.violationTime = violationTime;
		this.violationType = violationType;
		this.violationCode = violationCode;
		this.violationDesc = violationDesc;
		this.speed = speed;
		this.limitLarge = limitLarge;
		this.limitSmall = limitSmall;
		this.overSpeedPercent = overSpeedPercent;
		this.entryBy = entryBy;
		this.image = imageAddress;
	}

	@Override
	void ExcuteInput(Violation violation) throws Exception {

		violation.setExportFlag("0");// Ĭ��Ϊδ����
		violation.setLocalPunishFlag("1");// Ĭ��Ϊδ����
		violation.setLockFlag("0");
		violation.uploadFlag = "0";

		violation.setDeviceNbr(this.deviceSysNbr);
		violation.setOrgCode(this.orgCode);
		violation.setCollectionType(this.collectionType);
		violation.setDistrictCode(this.districtCode);
		violation.setVioSiteCode(this.vioSiteCode);
		violation.setAddressDesc(this.addressDesc);
		violation.setRoadCode(this.roadCode);
		violation.setRoadSectionCode(this.roadSectionCode);
		violation.setPlateNbr(this.plateNbr);
		violation.setPlateType(this.plateType);
		violation.setPlateColor(this.plateColor);
		violation.setViolationTime(this.violationTime);
		violation.setViolationType(this.violationType);
		violation.setViolationCode(this.violationCode);
		violation.setViolationDesc(this.violationDesc);

		violation.snapNbr = this.snapNbr;
		violation.collectionPolice = this.collectionPolice;
		violation.mileage = this.mileage;
		violation.speed = this.speed;
		violation.limitLarge = this.limitLarge;
		violation.limitSmall = this.limitSmall;
		violation.overSpeedPercent = this.overSpeedPercent;
		violation.entryBy = this.entryBy;
		violation.entryTime = new Date();

		violation.image = this.image;
		violation.video = this.video;
		violation.setStatusFlag(ConstantCode.StatusFlag.CONFIRMED);

	}

	@Override
	protected boolean IsEmpty() {
		return false;
	}

}
