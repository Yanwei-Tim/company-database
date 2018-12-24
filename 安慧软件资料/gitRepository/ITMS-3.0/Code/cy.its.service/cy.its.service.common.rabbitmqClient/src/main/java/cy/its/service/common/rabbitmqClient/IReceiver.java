package cy.its.service.common.rabbitmqClient;

@FunctionalInterface
public interface IReceiver {

	/**
	 * ���Ľ���MQ���͵���Ϣ
	 * @param routingKey ���йؼ���
	 * @param message    ��Ϣ
	 * @return �Ƿ�ȷ���յ���Ϣ, true:��;false:��;
	 */
	Boolean receive(String routingKey, String message);
	
//	Boolean receive(String queue, String routingKey, String message);

}
