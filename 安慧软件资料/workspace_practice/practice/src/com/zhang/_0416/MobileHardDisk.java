package com.zhang._0416;

/**
 * �ƶ�Ӳ��
 * ʵ����IMobileStorage�ӿ�
 * ��д���Լ����е����ݽ�������
 * @author zhangyu
 *
 */
public class MobileHardDisk implements IMobileStorage {

	@Override
	public void read() {
		System.out.println("�ƶ�Ӳ�̶�����");
	}

	@Override
	public void write() {
		System.out.println("�ƶ�Ӳ��д����");
	}

}
