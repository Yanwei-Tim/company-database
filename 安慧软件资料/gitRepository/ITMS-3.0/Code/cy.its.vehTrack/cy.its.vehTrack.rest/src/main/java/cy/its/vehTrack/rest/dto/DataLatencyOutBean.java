package cy.its.vehTrack.rest.dto;

public class DataLatencyOutBean {
	
	/**
	 * �豸���
	 */
	private String deviceSysNbr;
	/**
	 * ���к�
	 */
	private int seq;
	private int hour;
	private int step;
	/**
	 * �ӳٵ�ʱ��
	 */
	private double cost;
	public String getDeviceSysNbr() {
		return deviceSysNbr;
	}
	public void setDeviceSysNbr(String deviceSysNbr) {
		this.deviceSysNbr = deviceSysNbr;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
}
