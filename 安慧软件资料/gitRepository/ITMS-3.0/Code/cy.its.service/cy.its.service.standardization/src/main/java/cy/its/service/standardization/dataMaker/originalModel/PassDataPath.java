package cy.its.service.standardization.dataMaker.originalModel;

import java.util.Map;


public class PassDataPath extends BaseOrginalModel {

	/**
	 * �豸���
	 */
	private String deviceNbr;

	/**
	 * �豸���
	 */
	private String deviceKey;

	/**
	 * ץ�ı��
	 */
	private String snapNbr;

	/**
	 * ����ʱ��
	 */
	private String passTime;

	/**
	 * �������侭�����ڵ�ʱ��·�� 
	 * key-�����ڵ�ʱ��ؼ���; value-�����ڵ�ʱ��,��ʽ:yyyy-MM-dd HH:mm:ss.fff
	 * keyȡֵ:
	 *  serverReceivingTime:       ��ط���������ʱ��
	 *  afterserverReceivingTime:  ���ü�ط���������ʱ�䣨���м�ط���������ʱ��ֵ��
	 *  ice2mqTime:                ICE2MQ����ʱ��
	 *  preTime:                   ǰ�û�����ʱ�� 
	 *  afterTime:                 ���û�����ʱ�� 
	 *  uploadTime:                �ϴ���ʼʱ�� 
	 *  uploadEndTime:             �ϴ�����ʱ��
	 */
	private Map<String, String> dataTimePath;

//	/**
//	 * �ܺ�ʱ����λΪ�롣
//	 */
//	private int totalTime;

	public String getDeviceNbr() {
		return deviceNbr;
	}

	public void setDeviceNbr(String deviceNbr) {
		this.deviceNbr = deviceNbr;
	}

	public String getDeviceKey() {
		return deviceKey;
	}

	public void setDeviceKey(String deviceKey) {
		this.deviceKey = deviceKey;
	}

	public String getSnapNbr() {
		return snapNbr;
	}

	public void setSnapNbr(String snapNbr) {
		this.snapNbr = snapNbr;
	}

	public String getPassTime() {
		return passTime;
	}

	public void setPassTime(String passTime) {
		this.passTime = passTime;
	}

	public Map<String, String> getDataTimePath() {
		return dataTimePath;
	}

	public void setDataTimePath(Map<String, String> dataTimePath) {
		this.dataTimePath = dataTimePath;
	}

//	public int getTotalTime() {
//		return totalTime;
//	}
//
//	public void setTotalTime(int totalTime) {
//		this.totalTime = totalTime;
//	}
}
