package com.zhang._0413;

public class TestSingleton1 {

	public static void main(String[] args) {

		Singleton1 s1 = Singleton1.getInstance();
		Singleton1 s2 = Singleton1.getInstance();
		// ==�����ж��������õĵ�ֵַ�Ƿ����
		System.out.println(s1 == s2); // true
	}
}
