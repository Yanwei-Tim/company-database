package com.zhang._0416;
/**
 * U��
 * ʵ����IMobileStorage�ӿ�
 * ��д���Լ����е����ݽ�������
 * @author zhangyu
 *
 */
public class FlashDisk implements IMobileStorage {

	@Override
	public void read() {
		System.out.println("U�̶�����");
	}

	@Override
	public void write() {
		System.out.println("U��д����");
	}

}
