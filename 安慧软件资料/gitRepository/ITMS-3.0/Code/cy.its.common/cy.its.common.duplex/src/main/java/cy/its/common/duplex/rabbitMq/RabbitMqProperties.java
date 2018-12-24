package cy.its.common.duplex.rabbitMq;

import java.util.Map;

/**
* @Title: RabbitMqProperties.java 
* @Package com.cy.web 
* @Description: mq����ֵ
* @author lil@cychina.cn
* @date 2015��10��30�� ����10:06:52 
* @version V1.0   
 */
public class RabbitMqProperties {
	
	
	
    private static  String ip="";//IP
    private static  String user="";//�û�
    private static  String pwd="";//����
    private static  String dataCenter=""; //���ݽ�������
    private static  String exchangeType="";//topic
    
    private static  Map<String,String>  map;//���ҵ�����Ͷ�Ӧʵ��������
	   
	private   RabbitMqProperties(String ip1,String user1,String pwd1,
			String dataCenter1,String exchangeType1,Map  map1){
		ip = ip1;
		user =  user1;
		pwd = pwd1;
		dataCenter= dataCenter1;
		exchangeType=exchangeType1;
		map=map1;
	} 
    
	public static String getIp() {
		return ip;
	}
	public static String getUser() {
		return user;
	}
	public static String getPwd() {
		return pwd;
	}
	public static String getDataCenter() {
		return dataCenter;
	}
	public static Map<String,String> getMap() {
		return map;
	}

	public static String getExchangeType() {
		return exchangeType;
	}
}
