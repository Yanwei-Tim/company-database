/**
 * @Title: ViolationCodeDto.java
 * @Package cy.its.violation.rest.dto
 * @Description: TODO(����Ҫ��д��;)
 * @author wangyf wangyf@cychina.cn
 * @date 2015��11��13�� ����4:42:01
 * @version V1.0
 * @Revision : $Rev$
 * @Id: $Id$
 *
 * Company: ���ճ�Զ��Ϣ�������޹�˾
 * Copyright: Copyright (c) 2015 
 */

package cy.its.violation.rest.dto;

/**
  * @ClassName: ViolationCodeDto
  * @Description: TODO(����Ҫ��д��;)
  * @author wangyf wangyf@cychina.cn
  * @date 2015��11��13�� ����4:42:01
  *
  */

public class ViolationCodeDto {
	//Υ��������  
	private String vioActionCode;
	//Υ������
	private String vioType;
	//Υ������ 
	private String vioPriorType;
	//Υ�����ݸ��� 
	private String vioSummary ;
	//Υ������
	private String  vioConetent;
	//���÷������� 
	private String  legalReference;
	//������������
	private String punishLegalReference;
	//Υ���Ƿ�
	private String fineScore;
	//��߷�����
	private String fineMax;
	//��ͷ�����
	private String fineMin;
	//Ĭ�Ϸ�����
	private String fineDefault;
	//����ݿ��·�
	private String suspendMonthMax;
	//����ݿ��·�
	private String suspendMonthMin;
	//����������
	private String detainDaysMax;
	//��С��������
	private String detainDaysMin;
	//ǿ�ƴ�ʩ����
	private String forceType;
	//������
	private String flagWarn;
	//������
	private String flagFine;
	//�ݿ۱��
	private String flagSuspend;
	//�������
	private String flagCancel;
	//�������
	private String flagDetain;
	//������ʻ֤���
	private String flagRevokeVehicle;
	//������ʻ֤���
	private String flagRevokeDriver;
	//�Ƿ����
	private String isGb;
	//��Ч��ʼ
	private String issueDay;
	//��Ч����
	private String issueEndDay;
	//�Ƿ���
	private String isCommonUsed;
	
	
	//Υ�����ñ�Id
	private String vioActionMatchId;
	//��·����
	public String roadType;
	//Υ������
	public String violationType; 
	//����ֵ
	public String limitSpeed;
	//����ٱ�
	public String MaxRatio;
	//��С���ٱ�
	public String minRatio;
	
	public String getVioActionMatchId() {
		return vioActionMatchId;
	}
	public void setVioActionMatchId(String vioActionMatchId) {
		this.vioActionMatchId = vioActionMatchId;
	}
	public String getVioActionCode() {
		return vioActionCode;
	}
	public void setVioActionCode(String vioActionCode) {
		this.vioActionCode = vioActionCode;
	}
	public String getVioType() {
		return vioType;
	}
	public void setVioType(String vioType) {
		this.vioType = vioType;
	}
	public String getVioPriorType() {
		return vioPriorType;
	}
	public void setVioPriorType(String vioPriorType) {
		this.vioPriorType = vioPriorType;
	}
	public String getVioSummary() {
		return vioSummary;
	}
	public void setVioSummary(String vioSummary) {
		this.vioSummary = vioSummary;
	}
	public String getVioConetent() {
		return vioConetent;
	}
	public void setVioConetent(String vioConetent) {
		this.vioConetent = vioConetent;
	}
	public String getLegalReference() {
		return legalReference;
	}
	public void setLegalReference(String legalReference) {
		this.legalReference = legalReference;
	}
	public String getPunishLegalReference() {
		return punishLegalReference;
	}
	public void setPunishLegalReference(String punishLegalReference) {
		this.punishLegalReference = punishLegalReference;
	}
	
	public String getFineScore() {
		return fineScore;
	}
	public void setFineScore(String fineScore) {
		this.fineScore = fineScore;
	}
	public String getFineMax() {
		return fineMax;
	}
	public void setFineMax(String fineMax) {
		this.fineMax = fineMax;
	}
	public String getFineMin() {
		return fineMin;
	}
	public void setFineMin(String fineMin) {
		this.fineMin = fineMin;
	}
	public String getFineDefault() {
		return fineDefault;
	}
	public void setFineDefault(String fineDefault) {
		this.fineDefault = fineDefault;
	}
	public String getSuspendMonthMax() {
		return suspendMonthMax;
	}
	public void setSuspendMonthMax(String suspendMonthMax) {
		this.suspendMonthMax = suspendMonthMax;
	}
	public String getSuspendMonthMin() {
		return suspendMonthMin;
	}
	public void setSuspendMonthMin(String suspendMonthMin) {
		this.suspendMonthMin = suspendMonthMin;
	}
	public String getDetainDaysMax() {
		return detainDaysMax;
	}
	public void setDetainDaysMax(String detainDaysMax) {
		this.detainDaysMax = detainDaysMax;
	}
	public String getDetainDaysMin() {
		return detainDaysMin;
	}
	public void setDetainDaysMin(String detainDaysMin) {
		this.detainDaysMin = detainDaysMin;
	}
	public String getForceType() {
		return forceType;
	}
	public void setForceType(String forceType) {
		this.forceType = forceType;
	}
	public String getFlagWarn() {
		return flagWarn;
	}
	public void setFlagWarn(String flagWarn) {
		this.flagWarn = flagWarn;
	}
	public String getFlagFine() {
		return flagFine;
	}
	public void setFlagFine(String flagFine) {
		this.flagFine = flagFine;
	}
	public String getFlagSuspend() {
		return flagSuspend;
	}
	public void setFlagSuspend(String flagSuspend) {
		this.flagSuspend = flagSuspend;
	}
	public String getFlagCancel() {
		return flagCancel;
	}
	public void setFlagCancel(String flagCancel) {
		this.flagCancel = flagCancel;
	}
	public String getFlagDetain() {
		return flagDetain;
	}
	public void setFlagDetain(String flagDetain) {
		this.flagDetain = flagDetain;
	}
	
	
	public String getFlagRevokeVehicle() {
		return flagRevokeVehicle;
	}
	public void setFlagRevokeVehicle(String flagRevokeVehicle) {
		this.flagRevokeVehicle = flagRevokeVehicle;
	}
	public String getFlagRevokeDriver() {
		return flagRevokeDriver;
	}
	public void setFlagRevokeDriver(String flagRevokeDriver) {
		this.flagRevokeDriver = flagRevokeDriver;
	}
	public String getIsGb() {
		return isGb;
	}
	public void setIsGb(String isGb) {
		this.isGb = isGb;
	}
	public String getIssueDay() {
		return issueDay;
	}
	public void setIssueDay(String issueDay) {
		this.issueDay = issueDay;
	}
	public String getIssueEndDay() {
		return issueEndDay;
	}
	public void setIssueEndDay(String issueEndDay) {
		this.issueEndDay = issueEndDay;
	}
	public String getIsCommonUsed() {
		return isCommonUsed;
	}
	public void setIsCommonUsed(String isCommonUsed) {
		this.isCommonUsed = isCommonUsed;
	}
	
	public String getRoadType() {
		return roadType;
	}
	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	public String getViolationType() {
		return violationType;
	}
	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}
	public String getLimitSpeed() {
		return limitSpeed;
	}
	public void setLimitSpeed(String limitSpeed) {
		this.limitSpeed = limitSpeed;
	}
	public String getMaxRatio() {
		return MaxRatio;
	}
	public void setMaxRatio(String maxRatio) {
		MaxRatio = maxRatio;
	}
	public String getMinRatio() {
		return minRatio;
	}
	public void setMinRatio(String minRatio) {
		this.minRatio = minRatio;
	}

	
}
