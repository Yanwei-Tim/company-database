package com.zhang._0416;

/**
 * ������һ���洢�豸SD��
 * ֻ��Ҫ����ʵ��IMobileStorage��ok
 * @author zhangyu
 *
 */
public class SdCard implements IMobileStorage {

	@Override
	public void read() {
		System.out.println("SD��������");
	}

	@Override
	public void write() {
		System.out.println("SD��д����");
	}

}
