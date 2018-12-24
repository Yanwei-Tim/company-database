package cy.its.service.standardization.dataMaker.originalModel;

import java.math.BigDecimal;

public class FrontRoadSensor extends BaseOrginalModel{
	private String devNbr;  //�豸���
    private BigDecimal roanTemperature;//·���¶�
    private BigDecimal temperature;//·���¶�
    private BigDecimal waterFilmHeigh; //ˮĤ���
    private BigDecimal salinity; //�ζ�
    private BigDecimal freezingTemperature;//�ڱ���
    private String roadCondition;//·��״�� 0	����1	΢ʪ2	��ʪ3	Lyc  ?4	��/ѩ5	��Ũ��6	�ڱ�7	Critical ��90	δ֪
    private String recordTime;//��¼ʱ��
    private String remark;
    
	public String getDevNbr() {
		return devNbr;
	}
	public void setDevNbr(String devNbr) {
		this.devNbr = devNbr;
	}
	public BigDecimal getRoanTemperature() {
		return roanTemperature;
	}
	public void setRoanTemperature(BigDecimal roanTemperature) {
		this.roanTemperature = roanTemperature;
	}
	public BigDecimal getTemperature() {
		return temperature;
	}
	public void setTemperature(BigDecimal temperature) {
		this.temperature = temperature;
	}
	public BigDecimal getWaterFilmHeigh() {
		return waterFilmHeigh;
	}
	public void setWaterFilmHeigh(BigDecimal waterFilmHeigh) {
		this.waterFilmHeigh = waterFilmHeigh;
	}
	public BigDecimal getSalinity() {
		return salinity;
	}
	public void setSalinity(BigDecimal salinity) {
		this.salinity = salinity;
	}
	public BigDecimal getFreezingTemperature() {
		return freezingTemperature;
	}
	public void setFreezingTemperature(BigDecimal freezingTemperature) {
		this.freezingTemperature = freezingTemperature;
	}
	public String getRoadCondition() {
		return roadCondition;
	}
	public void setRoadCondition(String roadCondition) {
		this.roadCondition = roadCondition;
	}
	public String getRecordTime() {
		return recordTime;
	}
	public void setRecordTime(String recordTime) {
		this.recordTime = recordTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
