package ah.its.wrokflow.dto;

import java.util.Date;

/**
* @Description: ���뵥��������¼
* @author lil@cychina.cn
* @version V1.0   
 */
public class CheckRecord {
	
	/**
	 * @serialField:����ID
	 */
	private String  id;
	
	/**
	 * @serialField:�������
	 */
	private String  result;
	
	/**
	 * @serialField:������
	 */
	private String  checkUser;
	
	/**
	 * @serialField:�������
	 */
	private String  checkOpinion;
	
	/**
	 * @serialField:����ʱ��
	 */
	private Date  checkTime;

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCheckUser() {
		return checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getCheckOpinion() {
		return checkOpinion;
	}

	public void setCheckOpinion(String checkOpinion) {
		this.checkOpinion = checkOpinion;
	}
}
