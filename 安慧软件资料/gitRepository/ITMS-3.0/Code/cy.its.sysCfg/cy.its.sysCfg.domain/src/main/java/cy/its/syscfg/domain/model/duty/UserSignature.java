package cy.its.syscfg.domain.model.duty;

public class UserSignature {

	/**
	 * ǩ��ID
	 */
	private String signatureId;

	/**
	 * �û�ID
	 */
	private String userId;

	/**
	 * ǩ��˳��
	 */
	private Integer signatureIndex;

	/**
	 * ǩ��ͼƬ·��
	 */
	private String signatureImage;

	public String getSignatureId() {
		return signatureId;
	}

	public void setSignatureId(String signatureId) {
		this.signatureId = signatureId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getSignatureIndex() {
		return signatureIndex;
	}

	public void setSignatureIndex(Integer signatureIndex) {
		this.signatureIndex = signatureIndex;
	}

	public String getSignatureImage() {
		return signatureImage;
	}

	public void setSignatureImage(String signatureImage) {
		this.signatureImage = signatureImage;
	}

}
