package cy.its.service.device.faultMaintain;

import cy.its.service.common.JsonUtil;
import cy.its.service.common.StringUtil;
import cy.its.service.common.dataModel.DeviceFault;
import cy.its.service.common.log.LogManager;
import cy.its.service.common.rabbitmqClient.IReceiver;

public class FaultReceiver implements IReceiver {

	Class<DeviceFault> clazz = DeviceFault.class;
	String msg = "���յ�����:%s"; 

	@Override
	public Boolean receive(String routingKey, String message) {
		try {
			LogManager.debug(String.format(msg, message));
			return FaultWriter.write(JsonUtil.parseObject(message, clazz));
		} catch (Throwable e) {
			LogManager.error("���ϴ���ʧ��:" + StringUtil.getErrorDetail(e));
			return true;
		}
	}

}
