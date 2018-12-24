package cy.its.service.common.dataModel;

import java.math.BigDecimal;
import java.util.Date;

public class Weather extends Model {
	
	/**
	* ϵͳ���
	*/
	@Mapper("DEVICE_SYS_NBR")
	private String deviceSysNbr;
	
	/**
	* ��������
	*/
	@Mapper("ORG_CODE")
	private String orgCode;
	
	/**
	* ��λ����
	*/
	@Mapper("SITE_CODE")
	private String siteCode;
	
	/**
	* �¶ȣ���C��
	*/
	@Mapper("WEATHER_TEMPERATURE")
	private BigDecimal weatherTemperature;
	
	/**
	* ���ʪ�ȣ�%��
	*/
	@Mapper("RELATIVE_HUMIDITY")
	private BigDecimal relativeHumidity;
	
	/**
	* ��ѹ��hPa��
	*/
	@Mapper("AIR_PRESSURE")
	private BigDecimal airPressure;
	
	/**
	* ���٣� m/s��
	*/
	@Mapper("WIND_SPEED")
	private BigDecimal windSpeed;
	
	/**
	* ���򣨡㣩
	*/
	@Mapper("WIND_DIRECTION")
	private BigDecimal windDirection;
	
	/**
	* ��������mm)
	*/
	@Mapper("WATER_FILM_HEIGHT")
	private BigDecimal waterFilmHeight;
	
	/**
	* ��������
	*/
	@Mapper("WATER_TYPE")
	private String waterType;
	
	/**
	* ��ˮǿ��(mm/h)
	*/
	@Mapper("RAIN_STRONG")
	private BigDecimal rainStrong;
	
	/**
	* ��¼ʱ��
	*/
	@Mapper("RECORD_TIME")
	private Date recordTime;
	
	/**
	* ����Ȩ�޹��˴���
	*/
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;

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

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public BigDecimal getWeatherTemperature() {
		return weatherTemperature;
	}

	public void setWeatherTemperature(BigDecimal weatherTemperature) {
		this.weatherTemperature = weatherTemperature;
	}

	public BigDecimal getRelativeHumidity() {
		return relativeHumidity;
	}

	public void setRelativeHumidity(BigDecimal relativeHumidity) {
		this.relativeHumidity = relativeHumidity;
	}

	public BigDecimal getAirPressure() {
		return airPressure;
	}

	public void setAirPressure(BigDecimal airPressure) {
		this.airPressure = airPressure;
	}

	public BigDecimal getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(BigDecimal windSpeed) {
		this.windSpeed = windSpeed;
	}

	public BigDecimal getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(BigDecimal windDirection) {
		this.windDirection = windDirection;
	}

	public BigDecimal getWaterFilmHeight() {
		return waterFilmHeight;
	}

	public void setWaterFilmHeight(BigDecimal waterFilmHeight) {
		this.waterFilmHeight = waterFilmHeight;
	}

	public String getWaterType() {
		return waterType;
	}

	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}

	public BigDecimal getRainStrong() {
		return rainStrong;
	}

	public void setRainStrong(BigDecimal rainStrong) {
		this.rainStrong = rainStrong;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}
	
    private String deviceId;	
	
	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
}
