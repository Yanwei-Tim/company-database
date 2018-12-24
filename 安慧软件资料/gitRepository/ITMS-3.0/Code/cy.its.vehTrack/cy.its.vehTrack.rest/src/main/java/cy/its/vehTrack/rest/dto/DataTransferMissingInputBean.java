package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class DataTransferMissingInputBean extends BaseDto {

	/***** ��ѯ�������ֶ� ********/
	// ��·����
	@ApiParam(value = "��·����")
	private String roadCode;

	// �豸���
	@ApiParam(value = "�豸���")
	private String deviceSysNbr;

	// ��λ����
	@ApiParam(value = "��λ����")
	private String siteCode;

	// ��ʼ����ʱ��
	@ApiParam(value = "��ʼ����ʱ��")
	private String passTimeFrom;

	// ��������ʱ��
	@ApiParam(value = "��������ʱ��")
	private String passTimeTo;

	// ����Ȩ�޴���
	@ApiParam(value = "����Ȩ�޴���")
	private String orgPrivilegeCode;

	// ��·����
	@ApiParam(value = "��·����")
	private String roadType;

	// ��·ID
	@ApiParam(value = "��·ID")
	private String roadId;

	/**
	 * �Ƿ������鲼��ϵͳ 0 : �� 1 : �� 2 : ȫ
	 */
	@ApiParam(value = "�Ƿ������鲼��ϵͳ")
	private String isConnectTrackSys;

	// ��ǰҳ��
	@ApiParam(value = "��ǰҳ��")
	private int pageNumber;
	// ��ҳ��С
	@ApiParam(value = "��ҳ��С")
	private int pageSize;

	@ApiParam(value = "����")
	private int totalCount;

	@ApiParam(value = "��������")
	private String orderName;
	@ApiParam(value = "����ʽ")
	private String orderType;

	@ApiParam(value = "�н�����id")
	private String contractorId;

	public String getRoadCode() {
		return roadCode;
	}

	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}

	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}

	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getPassTimeFrom() {
		return passTimeFrom;
	}

	public void setPassTimeFrom(String passTimeFrom) {
		this.passTimeFrom = passTimeFrom;
	}

	public String getPassTimeTo() {
		return passTimeTo;
	}

	public void setPassTimeTo(String passTimeTo) {
		this.passTimeTo = passTimeTo;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public String getRoadId() {
		return roadId;
	}

	public void setRoadId(String roadId) {
		this.roadId = roadId;
	}

	public String getIsConnectTrackSys() {
		return isConnectTrackSys;
	}

	public void setIsConnectTrackSys(String isConnectTrackSys) {
		this.isConnectTrackSys = isConnectTrackSys;
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

	public String getContractorId() {
		return contractorId;
	}

	public void setContractorId(String contractorId) {
		this.contractorId = contractorId;
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
