package com.zhang._0414;
/**
 * ʵ�ֹ��������ӿڵľ���ʵ����
 * �����յ��Ĺ���
 * @author zhangyu
 *
 */
public class CreateAirCondition implements Factory {

	@Override
	public Product create() {
		return new AirCondition();
	}

}
