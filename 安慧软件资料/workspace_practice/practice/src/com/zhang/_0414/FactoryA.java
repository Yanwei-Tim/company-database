package com.zhang._0414;

/**
 * ������Ʒ�ͺ�ΪA�Ĳ�Ʒ����
 * @author zhangyu
 *
 */
public class FactoryA implements AbstractFactory {

	@Override
	public Washe1 createWasher() {
		return new WasherA();
	}

	@Override
	public Icebox1 createIcebox() {
		return new IceboxA();
	}
}
