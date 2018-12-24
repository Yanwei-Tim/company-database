package cy.its.service.standardization.validator;
 
import cy.its.service.common.ConstValue;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.Weather;

public class WeatherValidator extends BaseValidator<Weather>{

	@Override
	void fillFilters() {
		addFilter(u -> StringUtil.isNullOrEmpty(u.getDeviceSysNbr()), "DeviceSysNbr����Ϊ��;");
		addFilter(u -> dbLen(u.getDeviceSysNbr()) > ConstValue.INT_18, "DeviceSysNbr���ܴ���18λ;");
		addFilter(u -> dbLen(u.getOrgCode()) > ConstValue.INT_18, "OrgCode���ܴ���18λ;");
		addFilter(u -> dbLen(u.getSiteCode()) > ConstValue.INT_32, "SiteCode���ܴ���32λ;");
		addFilter(u -> !isRightDbNum(u.getWeatherTemperature(),ConstValue.INT_5,ConstValue.INT_2), "WeatherTemperature����������λ����3λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getRelativeHumidity(),ConstValue.INT_8,ConstValue.INT_2), "RelativeHumidity����������λ����6λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getAirPressure(),ConstValue.INT_8,ConstValue.INT_2), "AirPressure����������λ����6λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getWindSpeed(),ConstValue.INT_8,ConstValue.INT_2), "WindSpeed����������λ����6λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getWindDirection(),ConstValue.INT_5,ConstValue.INT_2), "WindDirection����������λ����3λС��λ����2������;");
		addFilter(u -> !isRightDbNum(u.getWaterFilmHeight(),ConstValue.INT_8,ConstValue.INT_2), "WaterFilmHeight����������λ����6λС��λ����2������;");
		addFilter(u -> dbLen(u.getWaterType()) > ConstValue.INT_2, "WaterType���ܴ���2λ;");
		addFilter(u -> !isRightDbNum(u.getRainStrong(),ConstValue.INT_8,ConstValue.INT_2), "RainStrong����������λ����6λС��λ����2������;");
		addFilter(u -> u.getRecordTime() == null, "RecordTime����Ϊ��;");
		addFilter(u -> is1HMoreThanNow(u.getRecordTime()), "RecordTimeʱ�䳬����ǰʱ��1��Сʱ,��Уʱ;");
		addFilter(u -> dbLen(u.getOrgPrivilegeCode()) > ConstValue.INT_8, "OrgPrivilegeCode���ܴ���8λ;");
	}

}
