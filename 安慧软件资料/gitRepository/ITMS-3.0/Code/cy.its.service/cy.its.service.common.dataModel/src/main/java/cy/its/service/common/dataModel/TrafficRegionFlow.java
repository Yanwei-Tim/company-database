package cy.its.service.common.dataModel;

import java.math.BigDecimal;
import java.util.Date;

public class TrafficRegionFlow extends Model {

	/**
	 * ����ID
	 */
	@Mapper("REGIONAL_ID")
	private String regionalId;
	
	/**
	 * �������ܳ���
	 */
	@Mapper("TOTAL_NUM")
	private int totalNum;
	
	/**
	 * ����
	 */
	@Mapper("LARGE_NUM")
	private int largeNum;
	
	/**
	 * С����
	 */
	@Mapper("SMALL_NUM")
	private int smallNum;
	
	/**
	 * ��������
	 */
	@Mapper("OTHER_NUM")
	private int otherNum;
	
	/**
	 * �������ص㳵����
	 */
	@Mapper("IMPORTANT_NUM")
	private int importantNum;
	
	/**
	 * ƽ������
	 */
	@Mapper("AVG_SPEED")
	private BigDecimal avgSpeed;

	/**
	 * ƽ������ʱ�䡣��λΪ����
	 */
	@Mapper("AVG_TRAVEL_TIME")
	private BigDecimal avgTravelTime;

	/**
	 * ����Ȩ�޹��˴���
	 */
	@Mapper("ORG_PRIVILEGE_CODE")
	private String orgPrivilegeCode;

	/**
	 * ͨ��״̬
	 */
	@Mapper("TRAFFIC_STATE")
	private String trafficState;

	/**
	 * ����ʱ��
	 */
	@Mapper("UPDATE_TIME")
	private Date updateTime;

	public String getRegionalId() {
		return regionalId;
	}

	public void setRegionalId(String regionalId) {
		this.regionalId = regionalId;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getLargeNum() {
		return largeNum;
	}

	public void setLargeNum(int largeNum) {
		this.largeNum = largeNum;
	}

	public int getSmallNum() {
		return smallNum;
	}

	public void setSmallNum(int smallNum) {
		this.smallNum = smallNum;
	}

	public int getOtherNum() {
		return otherNum;
	}

	public void setOtherNum(int otherNum) {
		this.otherNum = otherNum;
	}

	public int getImportantNum() {
		return importantNum;
	}

	public void setImportantNum(int importantNum) {
		this.importantNum = importantNum;
	}

	public BigDecimal getAvgSpeed() {
		return avgSpeed;
	}

	public void setAvgSpeed(BigDecimal avgSpeed) {
		this.avgSpeed = avgSpeed;
	}

	public BigDecimal getAvgTravelTime() {
		return avgTravelTime;
	}

	public void setAvgTravelTime(BigDecimal avgTravelTime) {
		this.avgTravelTime = avgTravelTime;
	}

	public String getOrgPrivilegeCode() {
		return orgPrivilegeCode;
	}

	public void setOrgPrivilegeCode(String orgPrivilegeCode) {
		this.orgPrivilegeCode = orgPrivilegeCode;
	}

	public String getTrafficState() {
		return trafficState;
	}

	public void setTrafficState(String trafficState) {
		this.trafficState = trafficState;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
