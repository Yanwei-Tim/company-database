package cy.its.sysCfg.rest.dto;

public class FestivalDto {

	private String festivalId;// ����Id
	private String festivalType;// ��������(���ڣ�����ڵ�)
	private String startDate;// ��ʼ����
	private String endDate;// ��������
	private String year;// �ڼ����������
	private String remark;// ��ע

	public String getFestivalId() {
		return festivalId;
	}

	public void setFestivalId(String festivalId) {
		this.festivalId = festivalId;
	}

	public String getFestivalType() {
		return festivalType;
	}

	public void setFestivalType(String festivalType) {
		this.festivalType = festivalType;
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

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
