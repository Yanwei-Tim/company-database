package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class StrangeCarDto extends BaseDto {

	@ApiParam(value = "���ƺ���")
	private String plateNbr;
	@ApiParam(value = "��س���ѯ��ʶֵ")
	private String justNonlocalVeh;
	@ApiParam(value = "��������")
	private String plateType;
	@ApiParam(value = "��������")
	private String vehicleType;
	@ApiParam(value = "������ɫ")
	private String vehicleColor;
	@ApiParam(value = "����Ʒ��")
	private String vehicleBrand;
	@ApiParam(value = "������Ʒ��")
	private String vehicleSubBrand;
	@ApiParam(value = "��������", required = true)
	private String districtCode;
	@ApiParam(value = "��ʼʱ��", required = true)
	private String firstTime;
	@ApiParam(value = "����ʱ��", required = true)
	private String endTime;
	@ApiParam(value = "���⳵���ƹ���������ʽ���磺^��[A-Z]T.*")
	private String texiPlateRule;
	@ApiParam(value = "�ǽ���ѯ���⳵�����ų����⳵��ֵ��justTexi excludeTexi")
	private String justOrExcludeTexi;
	private String totalCount;
	// ��ǰҳ��
	private int pageNumber;
	// ��ҳ��С
	private int pageSize;

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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleSubBrand() {
		return vehicleSubBrand;
	}

	public void setVehicleSubBrand(String vehicleSubBrand) {
		this.vehicleSubBrand = vehicleSubBrand;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getFirstTime() {
		return firstTime;
	}

	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTexiPlateRule() {
		return texiPlateRule;
	}

	public void setTexiPlateRule(String texiPlateRule) {
		this.texiPlateRule = texiPlateRule;
	}

	public String getJustOrExcludeTexi() {
		return justOrExcludeTexi;
	}

	public void setJustOrExcludeTexi(String justOrExcludeTexi) {
		this.justOrExcludeTexi = justOrExcludeTexi;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getJustNonlocalVeh() {
		return justNonlocalVeh;
	}

	public void setJustNonlocalVeh(String justNonlocalVeh) {
		this.justNonlocalVeh = justNonlocalVeh;
	}

	@Override
	public String toString() {
		StringBuilder params = new StringBuilder();
		Field[] fields = this.getClass().getDeclaredFields();
		for (Field field : fields) {
			try {
				params.append("&").append(field.getName()).append("=");
				Object value = field.get(this);
				if (value != null) {
					params.append(value);
				}
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return params.substring(1);
	}
}
