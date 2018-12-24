package cy.its.service.analysisAlarm.domain;

import java.util.Date;

/**
* @Title: TrafficWeather.java 
* @Package cy.its.service.weather.domain 
* @Description: �����豸����
* @author lil@cychina.cn
* @date 2015��11��13�� ����11:08:13 
* @version V1.0   
 */
public class TrafficWeather {
	/*
	 * ϵͳ���
	 */
	private  String  deviceSysNbr ;
	/*
	 * ��������
	 */
	private  String  orgCode ;
	/*
	 *����Ȩ�޴���
	 */
	private  String  orgPrivilegeCode;
	/*
	 * ��λ����
	 */
	private  String  siteCode;
	/*
	 * �¶ȣ���C��
	 */
	private  double  weatherTemperature;
	/*
	 * ���ʪ��
	 */
	private  double  relativeHumidity;
	/*
	 * ��ѹ��hPa��
	 */
	private  double  airPressure ;
	/*
	 * ���٣� m/s��
	 */
	private  double  windSpeed ;
	/*
	 * ���򣨡㣩
	 */
	private  double  windDirection ;
	/*
	 * ��������mm)
	 */
	private  double  waterFilmHeight;
	/*
	 * ��������
	 */
	private  String  waterType ;
	/*
	 * ��ˮǿ��(mm/h)
	 */
	private  double  rainStrong;
	
	
	/*
	 * ��¼ʱ��
	 */
	private  Date  recordTime;
	
	/*
	 * ��·����
	 */
	private  String  roadType;
	
	
	/**
	 *�豸ID
	 */
	private String  deviceId="";
	
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public double getWeatherTemperature() {
		return weatherTemperature;
	}

	public void setWeatherTemperature(double weatherTemperature) {
		this.weatherTemperature = weatherTemperature;
	}

	public double getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(double relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public double getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(double airPressure) {
		this.airPressure = airPressure;
	}

	public double getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}

	public double getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}

	public double getWaterFilmHeight() {
		return waterFilmHeight;
	}

	public void setWaterFilmHeight(double waterFilmHeight) {
		this.waterFilmHeight = waterFilmHeight;
	}

	public String getWaterType() {
		return waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	public double getRainStrong() {
		return rainStrong;
	}

	public void setRainStrong(double rainStrong) {
		this.rainStrong = rainStrong;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}
	
}
