package cy.its.vehTrack.rest.dto;

import java.util.List;

public class DangerAreaStatBean {
	
	/**
	 * ���ƺ���
	 */
	private String plate_nbr;
	
	/**
	 * ��Σ��������ܴ���
	 */
	private int platecount;
	
	/**
	 * ��������
	 */
	private String plate_type;

	/**
	 * ����Ʒ��
	 */
	private String vehicle_brand;
	
	/**
	 * ������ɫ
	 */
	private String vehicle_color;

	/**
	 * ��ϸ�����б�
	 */
	private List<DangerAreaDetailBean> detailList;
	
	/**
	 * ��ʼʱ��
	 */
	private String startTime;
	
	/**
	 * ����ʱ��
	 */
	private String endTime;

	public String getPlate_nbr() {
		return plate_nbr;
	}

	public void setPlate_nbr(String plate_nbr) {
		this.plate_nbr = plate_nbr;
	}

	public int getPlatecount() {
		return platecount;
	}

	public void setPlatecount(int platecount) {
		this.platecount = platecount;
	}

	public String getPlate_type() {
		return plate_type;
	}

	public void setPlate_type(String plate_type) {
		this.plate_type = plate_type;
	}

	public String getVehicle_brand() {
		return vehicle_brand;
	}

	public void setVehicle_brand(String vehicle_brand) {
		this.vehicle_brand = vehicle_brand;
	}

	public String getVehicle_color() {
		return vehicle_color;
	}

	public void setVehicle_color(String vehicle_color) {
		this.vehicle_color = vehicle_color;
	}

	public List<DangerAreaDetailBean> getDetailList() {
		return detailList;
	}

	public void setDetailList(List<DangerAreaDetailBean> detailList) {
		this.detailList = detailList;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}
