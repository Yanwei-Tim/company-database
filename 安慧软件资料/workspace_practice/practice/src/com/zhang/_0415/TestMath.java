package com.zhang._0415;

public class TestMath {
	public static void main(String[] args) {
		// �����
		// random()����һ��doubleֵ��[0.0,1.0)
		System.out.println(Math.random());

		// ����һ��1-10���������
		int a = (int) ((Math.random() * 10) + 1);
		System.out.println(a);

		// ����pow(�ף���);
		System.out.println(Math.pow(2, 3));

		// ����ȡ�� ceil
		System.out.println(Math.ceil(12.1));

		// ����ȡ��floor
		System.out.println(Math.floor(12.9));

		// ��������round
		System.out.println(Math.round(12.6));
		System.out.println(Math.round(12.4));

		// ����ֵabs
		System.out.println(Math.abs(-12.5));
		System.out.println(Math.abs(12.5));

		// ƽ����sprt
		System.out.println(Math.sqrt(4.0));

		// ���ֵ����Сֵ max��min
		System.out.println(Math.max(10, 20));

		System.out.println(Math.max(Math.max(10, 20), 30));

	}

}
