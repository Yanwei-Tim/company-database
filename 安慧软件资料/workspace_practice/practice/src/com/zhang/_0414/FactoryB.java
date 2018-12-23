package com.zhang._0414;

/**
 * ������Ʒ�ͺ�ΪB�Ĳ�Ʒ����
 * @author zhangyu
 *
 */
public class FactoryB implements AbstractFactory {

	@Override
	public Washe1 createWasher() {
		return new WasherB();
	}

	@Override
	public Icebox1 createIcebox() {
		return new IceboxB();
	}
}
