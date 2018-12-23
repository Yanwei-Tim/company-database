package com.zhang._0413;

/**
 * ����ģʽ
 */
public class Singleton1 {

	/**
	 * ����ʽ���ڵ��õ�ʱ���ȥʵ������������
	 */

	// ���췽��˽�л���������紴������
	private Singleton1() {

	}

	// ������һ�����󣬺����õ�ʱ����ʵ����
	private static Singleton1 s = null;

	/*public static Singleton1 getInstance() {
		if (s == null) {
			s = new Singleton1();
		}
		return s;
	}*/
	
	//����ʽû�п��ǵ��̵߳İ�ȫ���⣬���Կ��Լ����Ż���ͨ��synchronized�ؼ��֣�ʵ��ͬ����
	public synchronized static Singleton1 getInstance() {
		if (s == null) {
			s = new Singleton1();
		}
		return s;
	}
}
