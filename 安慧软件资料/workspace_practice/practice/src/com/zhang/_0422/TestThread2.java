package com.zhang._0422;

/**
 * Thread�߳��ࣺʵ��Runnable�ӿڣ�ʵ��run����
 * 
 * @author zhangyu
 *
 */
public class TestThread2 implements Runnable {

	private int i;

	public void run() {
		for (; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			System.out.println(Thread.currentThread().getName() + "             .." + i);
			if (i == 10) {
				TestThread2 t = new TestThread2();
				// ͨ��new Thread�� Runable target,String name�����������߳�
				new Thread(t, "�߳�1").start();
				new Thread(t, "�߳�2").start();
			}
		}
	}
}