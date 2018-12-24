/**
 *name :Σ�ռ�ʻ������������bean
 *author:wangyunqi
 *date:2016/03/14
 * 
 */
package cy.its.vehTrack.rest.dto;

import java.lang.reflect.Field;

import com.wordnik.swagger.annotations.ApiParam;

import cy.its.com.dto.BaseDto;

public class DangerCarDto extends BaseDto {

	/**
	 * ������������(007)
	 */
	private String districtCode;

	/**
	 * ��ʼʱ��
	 */
	@ApiParam(value = " ������ʼʱ�� ��ʽ��yyyy-MM-dd HH:mm:ss", required = true)
	private String startTime;

	/**
	 * ����ʱ��
	 */
	@ApiParam(value = " ������ֹʱ�� ��ʽ��yyyy-MM-dd HH:mm:ss", required = true)
	private String endTime;

	/**
	 * ��������
	 */
	private String vioActionCodes;

	/**
	 * ����
	 */
	private long tatal;

	/**
	 * ��������
	 */
	private String directionType;
	/**
	 * ʱ����
	 */
	private String minInterval;
	
	/**
	 * Υ������
	 */
	private String vioType;

	// ��ǰҳ��
	private int pageNumber;
	// ��ҳ��С
	private int pageSize;

	/**
	 * topN
	 */
	private String topN;

	public String getTopN() {
		return topN;
	}

	public void setTopN(String topN) {
		this.topN = topN;
	}

	public long getTatal() {
		return tatal;
	}

	public void setTatal(long tatal) {
		this.tatal = tatal;
	}

	public String getVioActionCodes() {
		return vioActionCodes;
	}

	public void setVioActionCodes(String vioActionCodes) {
		this.vioActionCodes = vioActionCodes;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime
	 *            the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public String getDirectionType() {
		return directionType;
	}

	public void setDirectionType(String directionType) {
		this.directionType = directionType;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getMinInterval() {
		return minInterval;
	}

	public void setMinInterval(String minInterval) {
		this.minInterval = minInterval;
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
	

	public String getVioType() {
		return vioType;
	}

	public void setVioType(String vioType) {
		this.vioType = vioType;
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
