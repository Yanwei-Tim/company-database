package com.zhang._0422;

/**
 * Thread�߳��ࣺ�̳�Thread�࣬��дrun����
 * 
 * @author zhangyu
 *
 */
public class TestThread1 extends Thread {

	private int i;

	// ��дrun������run�����ķ���������߳�ִ����
	public void run() {
		for (; i < 10; i++) {
			System.out.println(this.getName() + ":" + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "             .." + i);//���ص�ǰ�̶߳��������
			if (i == 10) {
				System.out.println("--------------------------------------------");
				new TestThread1().start(); //�����߳�
				new TestThread1().start(); //�����߳�
				System.out.println("---------------------------------------------");
			}
		}
	}
}
