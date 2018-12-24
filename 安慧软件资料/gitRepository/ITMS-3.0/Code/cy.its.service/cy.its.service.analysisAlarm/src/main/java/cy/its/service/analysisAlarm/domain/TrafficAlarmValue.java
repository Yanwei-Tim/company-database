package cy.its.service.analysisAlarm.domain;

/**
* @Title: TrafficAlertValue.java 
* @Package cy.its.service.section.domain 
* @Description: ��ֵ��Ϣ 
* @author lil@cychina.cn
* @date 2015��11��5�� ����3:35:47 
* @version V1.0   
 */
public class TrafficAlarmValue {
	/**
	 *Ԥ������
	 */
    private String  alarmValueType;
	/**
	 *��·����
	 */
    private String  roadType;
	/**
	 *��Сֵ
	 */
    private String  min;
	/**
	 *���ֵ
	 */
    private String  max;
	/**
	 *Ԥ������
	 */
    private String  alermGrade;
    

	public String getAlarmValueType() {
		return alarmValueType;
	}

	public void setAlarmValueType(String alarmValueType) {
		this.alarmValueType = alarmValueType;
	}

	public String getRoadType() {
		return roadType;
	}

	public void setRoadType(String roadType) {
		this.roadType = roadType;
	}

	public double getMin() {
		return Double.valueOf(min);
	}

	public void setMin(String min) {
		this.min = min;
	}

	public double getMax() {
		return Double.valueOf(max);
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getAlermGrade() {
		return alermGrade;
	}

	public void setAlermGrade(String alermGrade) {
		this.alermGrade = alermGrade;
	}
}
