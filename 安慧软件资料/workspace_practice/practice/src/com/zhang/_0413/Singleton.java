package com.zhang._0413;

/**
 * ����ģʽ�������ڴ���ֻ����һ������
 */
public class Singleton {
	
	/**
	 * ����ʽ�������ʼ��ʱ�����Լ�ʵ������������
	 */
	
	//���췽��˽�л�(ֻ���ڱ�����Դ�������)�������Ͳ��ܴ���������
	private Singleton(){
		
	}
	//�ڱ����д�����Ψһ��һ������
	//private������Ϊ�˲������ֱ�ӷ��ʣ���������ķ�������static����ֻ̬�ܷ��ʾ�̬������Ҫ��static����
	private static Singleton s = new Singleton();
	
	/**
	 * �����������ر��ഴ����Ψһ��һ������
	 * ��Ϊ���췽����˽�л��ˣ����Լ�static���Σ�����������ͨ���������ʸ÷���
	 */
	public static Singleton getInstance(){
		
		return s;
	}
}
