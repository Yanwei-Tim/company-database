package com.zhang._0422;

public class TestDraw {
	public static void main(String[] args) throws InterruptedException {
		// ����һ���û�
		Accout acct = new Accout("62282122900", "����", 1000);
		// ģ���ĸ��߳�ͬʱȡǮ
		DrawThread dt = new DrawThread(acct, 500);
		Thread th1 = new Thread(dt, "�߳�1��");
		Thread th2 = new Thread(dt, "�߳�2��");
		Thread th3 = new Thread(dt, "�߳�3��");
		Thread th4 = new Thread(dt, "�߳�4��");
		th1.start();
		th2.start();
		th3.start();
		th4.start();
	}
}