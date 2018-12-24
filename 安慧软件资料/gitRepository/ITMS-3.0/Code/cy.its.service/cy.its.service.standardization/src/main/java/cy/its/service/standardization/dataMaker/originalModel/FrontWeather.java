package cy.its.service.standardization.dataMaker.originalModel;

import java.math.BigDecimal;

public class FrontWeather extends BaseOrginalModel {

	//�豸���
    private String DEVICE_NBR;
    private String IP ;
    private BigDecimal TEMPERATURE;//�¶� ��C
    private BigDecimal RELATIVE_HUMIDITY;//���ʪ�� %
    private BigDecimal AIR_PRESSURE;//��ѹ hPa
    private BigDecimal WIND_SPEED;//����  m/s
    private BigDecimal WIND_DIRECTION;//	����  ��
    private BigDecimal WATER_FILM_HEIGHT;//������ mm
    private String WATER_TYPE;//"�������� 	0 = No precipitation 60 = Rain 70 = Snow 40=��ȷ���Ľ���
    private BigDecimal RAIN_STRONG;//��ˮǿ��   mm/h
    private String RECORD_TIME;//��¼ʱ��
    
	public String getDEVICE_NBR() {
		return DEVICE_NBR;
	}
	public void setDEVICE_NBR(String dEVICE_NBR) {
		DEVICE_NBR = dEVICE_NBR;
	}
	public String getIP() {
		return IP;
	}
	public void setIP(String iP) {
		IP = iP;
	}
	public BigDecimal getTEMPERATURE() {
		return TEMPERATURE;
	}
	public void setTEMPERATURE(BigDecimal tEMPERATURE) {
		TEMPERATURE = tEMPERATURE;
	}
	public BigDecimal getRELATIVE_HUMIDITY() {
		return RELATIVE_HUMIDITY;
	}
	public void setRELATIVE_HUMIDITY(BigDecimal rELATIVE_HUMIDITY) {
		RELATIVE_HUMIDITY = rELATIVE_HUMIDITY;
	}
	public BigDecimal getAIR_PRESSURE() {
		return AIR_PRESSURE;
	}
	public void setAIR_PRESSURE(BigDecimal aIR_PRESSURE) {
		AIR_PRESSURE = aIR_PRESSURE;
	}
	public BigDecimal getWIND_SPEED() {
		return WIND_SPEED;
	}
	public void setWIND_SPEED(BigDecimal wIND_SPEED) {
		WIND_SPEED = wIND_SPEED;
	}
	public BigDecimal getWIND_DIRECTION() {
		return WIND_DIRECTION;
	}
	public void setWIND_DIRECTION(BigDecimal wIND_DIRECTION) {
		WIND_DIRECTION = wIND_DIRECTION;
	}
	public BigDecimal getWATER_FILM_HEIGHT() {
		return WATER_FILM_HEIGHT;
	}
	public void setWATER_FILM_HEIGHT(BigDecimal wATER_FILM_HEIGHT) {
		WATER_FILM_HEIGHT = wATER_FILM_HEIGHT;
	}
	public String getWATER_TYPE() {
		return WATER_TYPE;
	}
	public void setWATER_TYPE(String wATER_TYPE) {
		WATER_TYPE = wATER_TYPE;
	}
	public BigDecimal getRAIN_STRONG() {
		return RAIN_STRONG;
	}
	public void setRAIN_STRONG(BigDecimal rAIN_STRONG) {
		RAIN_STRONG = rAIN_STRONG;
	}
	public String getRECORD_TIME() {
		return RECORD_TIME;
	}
	public void setRECORD_TIME(String rECORD_TIME) {
		RECORD_TIME = rECORD_TIME;
	}
}
