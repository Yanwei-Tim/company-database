package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class ViolationCar extends BaseDto {

	/**
	 * Υ������
	 */
	private String violationTypes;

	/**
	 * ������ʼ���ڼ�ʱ��
	 */
	@ApiParam(value = "������ʼ���ڼ�ʱ�� ��ʽ��yyyy-MM-dd HH:mm:ss", required = true)
	private String startDateTime;

	/**
	 * ������ֹ���ڼ�ʱ��
	 */
	@ApiParam(value = "������ֹ���ڼ�ʱ��  ��ʽ��yyyy-MM-dd HH:mm:ss", required = true)
	private String endDateTime;

	/**
	 * �������루����ð�Ƕ��Ÿ�����
	 */
	private String orgCodes;

	/**
	 * ��Ͻ��������
	 */
	private String orgAuthorityCode;

	/**
	 * ������������(007)������ð�Ƕ��Ÿ�����
	 */
	private String districtCodes;
	
	/**
	 * ���١��Ǹ��ٱ�ʶ true:����ѯ���� false:��ѯ�Ǹ���
	 */
	private String isHighway; 
	
	/**
	 * ����ֵ��Count����ҳ������ѯTopN
	 */
	private String topN;
	
	/**
	 * ͳ�Ʒ�ʽ��1����Υ������ͳ�� 0��գ���Υ������ͳ��
	 */
	private String statBy;

	/**
	 * �ܼ�¼��
	 */
	private String totalCount;

	// ��ǰҳ��
	private int pageNumber;
	// ��ҳ��С
	private int pageSize;
	
	private String plateType;

	public String getViolationTypes() {
		return violationTypes;
	}

	public void setViolationTypes(String violationTypes) {
		this.violationTypes = violationTypes;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getOrgCodes() {
		return orgCodes;
	}

	public void setOrgCodes(String orgCodes) {
		this.orgCodes = orgCodes;
	}

	public String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}

	public void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
	}

	public String getDistrictCodes() {
		return districtCodes;
	}

	public void setDistrictCodes(String districtCodes) {
		this.districtCodes = districtCodes;
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

	
	public String getIsHighway() {
		return isHighway;
	}

	public void setIsHighway(String isHighway) {
		this.isHighway = isHighway;
	}

	public String getTopN() {
		return topN;
	}

	public void setTopN(String topN) {
		this.topN = topN;
	}

	public String getStatBy() {
		return statBy;
	}

	public void setStatBy(String statBy) {
		this.statBy = statBy;
	}
	

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
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
