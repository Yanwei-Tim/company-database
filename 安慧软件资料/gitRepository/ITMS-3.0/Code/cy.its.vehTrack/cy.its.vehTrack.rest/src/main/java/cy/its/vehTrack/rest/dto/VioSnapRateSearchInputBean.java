package cy.its.vehTrack.rest.dto;


import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

/**
 * @Description: Υ���豸ץ���ʷ�����ѯ����ʵ��
 *
 */
public class VioSnapRateSearchInputBean extends BaseDto {

	/**
	 * �������루����ð�Ƕ��Ÿ�����
	 */
	@ApiParam(value = "�������루����ð�Ƕ��Ÿ�����")
	private String orgCodes;

	/**
	 * ������������(007)������ð�Ƕ��Ÿ�����
	 */
	@ApiParam(value = "�����������루����ð�Ƕ��Ÿ�����")
	private String districtCodes;

	/**
	 * ��·���루����ð�Ƕ��Ÿ�����
	 */
	@ApiParam(value = "��·���루����ð�Ƕ��Ÿ�����")
	private String roadCodes;

	/**
	 * ��λ���루����ð�Ƕ��Ÿ�����
	 */
	@ApiParam(value = "��λ���루����ð�Ƕ��Ÿ�����")
	private String siteCodes;

	/**
	 * (�Զ���)�������� <br />
	 * ������ѯҳ��δʹ�ø�����������Ȼ����ʹ��restful�ӿ�ʹ�ø�����
	 */
	@ApiParam(value = "(�Զ���)�������ƣ���ȷƥ�䡣")
	private String directionName;

	/**
	 * ��ѯ��ʼ����
	 */
	@ApiParam(value = "��ѯ��ʼ���� ��ʽ��yyyy-MM-dd", required = true)
	private String startDate;

	/**
	 * ��ѯ��������
	 */
	@ApiParam(value = "��ѯ��������  ��ʽ��yyyy-MM-dd", required = true)
	private String endDate;

	/**
	 * Υ������
	 */
	@ApiParam(value = "Υ�����ʹ��뵥ѡ", required = true)
	private String violationType;

	/**
	 * ���ڳн���id(t_device_sys.contractor_id)
	 */
	@ApiParam(value = "���ڳн���id")
	private String contractorId;

	/**
	 * ��Ͻ��������
	 */
	@ApiParam(value = "��Ͻ�������룺���鲻Ҫʹ�øò���")
	private String orgAuthorityCode;

	/**
	 * ��������
	 */
	@ApiParam(value = "�������� ��ʽ��contractor[������+ץ��������] �� vioRate[��ץ��������]")
	private String orderName;

	/**
	 * ����ʽ
	 */
	@ApiParam(value = "��ѯ�������ʽ����������˳��ֵ\"asc\"��\"desc\"��")
	private String orderType;

	// ��ǰҳ��
	@ApiParam(value = "��ǰҳ��")
	private int pageNumber;
	// ��ҳ��С
	@ApiParam(value = "��ҳ��С")
	private int pageSize;

	@ApiParam(value = "����")
	private int totalCount;

	public String getOrgCodes() {
		return orgCodes;
	}

	public void setOrgCodes(String orgCodes) {
		this.orgCodes = orgCodes;
	}

	public String getDistrictCodes() {
		return districtCodes;
	}

	public void setDistrictCodes(String districtCodes) {
		this.districtCodes = districtCodes;
	}

	public String getRoadCodes() {
		return roadCodes;
	}

	public void setRoadCodes(String roadCodes) {
		this.roadCodes = roadCodes;
	}

	public String getSiteCodes() {
		return siteCodes;
	}

	public void setSiteCodes(String siteCodes) {
		this.siteCodes = siteCodes;
	}

	public String getDirectionName() {
		return directionName;
	}

	public void setDirectionName(String directionName) {
		this.directionName = directionName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getViolationType() {
		return violationType;
	}

	public void setViolationType(String violationType) {
		this.violationType = violationType;
	}

	public String getContractorId() {
		return contractorId;
	}

	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
	}

	public String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}

	public void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
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

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
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
