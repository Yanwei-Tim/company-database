/**
 * @Title: WhiteListDto.java
 * @Package cy.its.violation.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��4�� ����3:01:45
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.dto;

/**
  * @ClassName: WhiteListDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��4�� ����3:01:45
  *
  */

public class WhiteListDto {
	//����Id
	private String vehicleId;
	//���ƺ���
	private String plateNbr;
	//��������
	private String plateType;
	//������ɫ
	private String plateColor;
	//����Ʒ��
	private String vehicleBrand;
	//�����ͺ�
	private String vehicleModel;
	//������ɫ 
	private String vehicleColor;
	//������
	private String orgId;
	//������������
	private String vehicleOwner;
	//��������ϵ��
	private String vehicleContactor;
	//��������ϵ���ֻ�
	private String vehicleContactorTel;
	//������Դ
	private String dataSource;
	//������
	private String noPunishFlag;
	//�ۼ��⴦������
	private String noPunishCounts;
	//�ۼ���۷�
	private String noPunishScore;
	//�ۼ��⴦�����
	private String noPunishMoney;
	//�鳵�������
	private String queryProtectFlag;
	//��Ч����
	private String validEndDate;
	//��ע
	private String remark;
	
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
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
	public String getVehicleBrand() {
		return vehicleBrand;
	}
	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleColor() {
		return vehicleColor;
	}
	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getVehicleOwner() {
		return vehicleOwner;
	}
	public void setVehicleOwner(String vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	public String getVehicleContactor() {
		return vehicleContactor;
	}
	public void setVehicleContactor(String vehicleContactor) {
		this.vehicleContactor = vehicleContactor;
	}
	public String getVehicleContactorTel() {
		return vehicleContactorTel;
	}
	public void setVehicleContactorTel(String vehicleContactorTel) {
		this.vehicleContactorTel = vehicleContactorTel;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getNoPunishFlag() {
		return noPunishFlag;
	}
	public void setNoPunishFlag(String noPunishFlag) {
		this.noPunishFlag = noPunishFlag;
	}
	public String getNoPunishCounts() {
		return noPunishCounts;
	}
	public void setNoPunishCounts(String noPunishCounts) {
		this.noPunishCounts = noPunishCounts;
	}
	public String getNoPunishScore() {
		return noPunishScore;
	}
	public void setNoPunishScore(String noPunishScore) {
		this.noPunishScore = noPunishScore;
	}
	public String getNoPunishMoney() {
		return noPunishMoney;
	}
	public void setNoPunishMoney(String noPunishMoney) {
		this.noPunishMoney = noPunishMoney;
	}
	
	public String getQueryProtectFlag() {
		return queryProtectFlag;
	}
	public void setQueryProtectFlag(String queryProtectFlag) {
		this.queryProtectFlag = queryProtectFlag;
	}
	public String getValidEndDate() {
		return validEndDate;
	}
	public void setValidEndDate(String validEndDate) {
		this.validEndDate = validEndDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
