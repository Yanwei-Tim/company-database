package com.zhang._0414;

/**
 * �򵥹�������̬������
 * 
 * @author zhangyu
 *
 */
public class SimpleFactory {

	/**
	 * ��̬���������ݴ���Ĳ����Ĳ�ͬ�����ز�ͬ��ʵ��
	 * @param productName ��Ʒ����
	 * @return ��Ʒʵ��
	 */
	public static Product factory(String productName) throws Exception {
		if (productName.equals("washer")) {
			return new Washer();
		} else if (productName.equals("icebox")) {
			return new Icebox();
		} else if (productName.equals("airCondition")) {
			return new AirCondition();
		} else {
			throw new Exception("û�иò�Ʒ");
		}
	}

	public static void main(String[] args) {
		try {
			SimpleFactory.factory("washer");
			SimpleFactory.factory("icebox");
			SimpleFactory.factory("airCondition");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
