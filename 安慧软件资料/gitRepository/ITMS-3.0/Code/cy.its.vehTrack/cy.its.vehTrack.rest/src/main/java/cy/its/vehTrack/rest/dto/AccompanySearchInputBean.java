package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

public class AccompanySearchInputBean {
	/**
	 * ��Ͻ��������
	 */
	private String orgAuthorityCode;

	/**
	 * ���ƺ���
	 */
	private String plateNbr;

	/**
	 * ������ʼ���ڼ�ʱ��
	 */
	@ApiParam(value="������ʼ���ڼ�ʱ��",required=true)
	private String startDateTime;

	/**
	 * ������ֹ���ڼ�ʱ��
	 */
	@ApiParam(value="������ֹ���ڼ�ʱ��",required=true)
	private String endDateTime;

	/**
	 * ����Ҫ����5�����ϲ���Ϊ�ǰ��泵
	 */
	private String accMinCount;
	
	/**
	 * ���N�����ھ�����ͬ��λ��ͬ����ͽа��泵
	 */
	private String accInterval;
	
	/**
	 * ��������(���Ӳ�ѯ����2015-11-12 by Jiaoxujin)
	 */
	private String plateType;
	
	/**
	 * �Ƿ�ʹ��storm��ʽ���㣨�����ã�
	 */
	private String useStorm;
	
	 /**
     * �ܼ�¼��
     */
    private String totalCount;
	
	/**
	 * ��ǰҳ���
	 */
	private int pageNumber;

	/**
	 * ÿҳ�����ʾ������
	 */
	private int pageSize;
	

	/**
	 * @return the plateNbr
	 */
	public String getPlateNbr() {
		return plateNbr;
	}

	/**
	 * @param plateNbr the plateNbr to set
	 */
	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
	}

	/**
	 * @return the startDateTime
	 */
	public String getStartDateTime() {
		return startDateTime;
	}

	/**
	 * @param startDateTime the startDateTime to set
	 */
	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * @return the endDateTime
	 */
	public String getEndDateTime() {
		return endDateTime;
	}

	/**
	 * @param endDateTime the endDateTime to set
	 */
	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * @return the accMinCount
	 */
	public String getAccMinCount() {
		return accMinCount;
	}

	/**
	 * @param accMinCount the accMinCount to set
	 */
	public void setAccMinCount(String accMinCount) {
		this.accMinCount = accMinCount;
	}

	/**
	 * @return the accInterval
	 */
	public String getAccInterval() {
		return accInterval;
	}

	/**
	 * @param accInterval the accInterval to set
	 */
	public void setAccInterval(String accInterval) {
		this.accInterval = accInterval;
	}

	/**
	 * getter method
	 * @return the plateType
	 */
	public String getPlateType() {
		return plateType;
	}

	/**
	 * setter method
	 * @param plateType the plateType to set
	 */
	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	/**
	 * @return the useStorm
	 */
	public String getUseStorm() {
		return useStorm;
	}

	/**
	 * @param useStorm the useStorm to set
	 */
	public void setUseStorm(String useStorm) {
		this.useStorm = useStorm;
	}

	/**
	 * getter method
	 * @return the orgAuthorityCode
	 */
	public String getOrgAuthorityCode() {
		return orgAuthorityCode;
	}

	/**
	 * setter method
	 * @param orgAuthorityCode the orgAuthorityCode to set
	 */
	public void setOrgAuthorityCode(String orgAuthorityCode) {
		this.orgAuthorityCode = orgAuthorityCode;
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
	@Override
	public String toString(){
		StringBuilder params = new StringBuilder();
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			try {
				params.append("&").append(field.getName()).append("=");
				Object value = field.get(this);
				if(value != null){
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

