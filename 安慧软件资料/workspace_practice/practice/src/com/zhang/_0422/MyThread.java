package com.zhang._0422;

public class MyThread {
	public static void main(String[] args) {
		Thread t = Thread.currentThread();// �õ���ǰ���߳�
		System.out.println("��ǰ���߳��ǣ�" + t);
		t.setName("MyThread");
		System.out.println("��ǰ���߳��ǣ�" + t);
	}
}
