package com.zhang._0416;
/**
 * MP3
 * ʵ����IMobileStorage�ӿ�
 * ��д���Լ����е����ݽ�������
 * @author zhangyu
 *
 */
public class MP3Player implements IMobileStorage{

	@Override
	public void read() {
		System.out.println("MP3������");
	}

	@Override
	public void write() {
		System.out.println("MP3д����");
	}
	
	public void PlayMusic(){
		System.out.println("MP3������");
	}

}
