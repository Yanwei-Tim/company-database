package cy.its.vehTrack.rest.dto;

import java.util.Date;

public class AccompanyDetailBean {
	/**
	 * ��������
	 */
	private String plate_nbr;

	/**
	 * ������������
	 */
	private String plate_type;

	/**
	 * ���泵������
	 */
	private String accplatenbr;

	/**
	 * ���泵����������
	 */
	private String accPlateType;
	
	/**
	 * ��λ����
	 */
	private String site_code;
	
	/**
	 * ��������
	 */
	private String direction_name;
	
	/**
	 * ��������ʱ��
	 */
	private Date pass_time;
	
	/**
	 * ���泵����ʱ��
	 */
	private Date accpasstime;
	
	/**
	 * ��������ͼƬURL���豸��ţ�ץ�ı�ţ�
	 */
	private String imgSource;
	
	/**
	 * ���泵����ͼƬURL���豸��ţ�ץ�ı�ţ�
	 */
	private String accImgSource;
	
	
	private String site_name;
	
	public String getSite_name() {
		return site_name;
	}

	public void setSite_name(String site_name) {
		this.site_name = site_name;
	}

	/**
	 * �������
	 */
	private int acccount;

	public String getPlate_nbr() {
		return plate_nbr;
	}

	public void setPlate_nbr(String plate_nbr) {
		this.plate_nbr = plate_nbr;
	}

	public String getPlate_type() {
		return plate_type;
	}

	public void setPlate_type(String plate_type) {
		this.plate_type = plate_type;
	}

	public String getAccplatenbr() {
		return accplatenbr;
	}

	public void setAccplatenbr(String accplatenbr) {
		this.accplatenbr = accplatenbr;
	}

	public String getAccPlateType() {
		return accPlateType;
	}

	public void setAccPlateType(String accPlateType) {
		this.accPlateType = accPlateType;
	}

	public String getSite_code() {
		return site_code;
	}

	public void setSite_code(String site_code) {
		this.site_code = site_code;
	}

	public String getDirection_name() {
		return direction_name;
	}

	public void setDirection_name(String direction_name) {
		this.direction_name = direction_name;
	}

	public Date getPass_time() {
		return pass_time;
	}

	public void setPass_time(Date pass_time) {
		this.pass_time = pass_time;
	}

	public Date getAccpasstime() {
		return accpasstime;
	}

	public void setAccpasstime(Date accpasstime) {
		this.accpasstime = accpasstime;
	}

	public String getImgSource() {
		return imgSource;
	}

	public void setImgSource(String imgSource) {
		this.imgSource = imgSource;
	}

	public String getAccImgSource() {
		return accImgSource;
	}

	public void setAccImgSource(String accImgSource) {
		this.accImgSource = accImgSource;
	}

	public int getAcccount() {
		return acccount;
	}

	public void setAcccount(int acccount) {
		this.acccount = acccount;
	}
	
}
