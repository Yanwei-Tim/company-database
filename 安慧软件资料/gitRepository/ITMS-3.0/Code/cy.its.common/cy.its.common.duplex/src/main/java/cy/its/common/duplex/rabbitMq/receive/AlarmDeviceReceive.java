package cy.its.common.duplex.rabbitMq.receive;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import cy.its.common.duplex.rabbitMq.IMqReceiver;
import cy.its.common.duplex.rabbitMq.IWebscoketReceiver;

/**
 * �豸״̬����
 * @author dell
 *
 */
public class AlarmDeviceReceive implements IMqReceiver{
	/**
	 * ��ʱ����ע����Ϣ
	 */
	private List<IWebscoketReceiver> list = new ArrayList<IWebscoketReceiver>();

	/**
	 * ������෢����Ϣ
	 */
	@Override
	public Boolean receive(String routingKey, String message) {
		boolean status = true;
		try {
			for (IWebscoketReceiver webscoketReceiver : list) {
				JSONObject jsonObject = JSONObject.parseObject(message);
				status = webscoketReceiver.receive(jsonObject);
			}
			return status;
		} catch (Exception e) {
			return true;
		}
	}

	/**
	 * ע��һ��������
	 */
	@Override
	public boolean addReciveObject(IWebscoketReceiver webscoketReceiver) {
		synchronized (this) {
			list.add(webscoketReceiver);
		}
		return true;
	}

}
