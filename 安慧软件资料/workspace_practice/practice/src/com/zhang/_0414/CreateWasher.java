package com.zhang._0414;

/**
 * ʵ�ֹ��������ӿڵľ���ʵ����
 * ����ϴ�»��Ĺ���
 * @author zhangyu
 *
 */
public class CreateWasher implements Factory{

	@Override
	public Product create() {
		return new Washer();
	}
}
