package cy.its.vehTrack.rest.dto;

public class DangerCarTopN {
	
	/**
	 * ����������
	 */
	private String plateNbr;
	
	/**
	 * ��������
	 */
	private String plateType;
	
	/**
	 * ����
	 */
	private int fineScore;
	
	/**
	 * ��������
	 */
	private int forceType;

	public String getPlateNbr() {
		return plateNbr;
	}

	public void setPlateNbr(String plateNbr) {
		this.plateNbr = plateNbr;
	}

	public String getPlateType() {
		return plateType;
	}

	public void setPlateType(String plateType) {
		this.plateType = plateType;
	}

	public int getFineScore() {
		return fineScore;
	}

	public void setFineScore(int fineScore) {
		this.fineScore = fineScore;
	}

	public int getForceType() {
		return forceType;
	}

	public void setForceType(int forceType) {
		this.forceType = forceType;
	}
	
	

}
