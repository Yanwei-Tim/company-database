package com.zhang._0530;

public class TestInnerClass {
	public static void main(String[] args) {

		// �����ڲ��࣬��д����ķ��������������������������
		new Person() {

			@Override
			public void eat() {
				System.out.println("�Զ���");
			}
		}.eat();
	}
}
