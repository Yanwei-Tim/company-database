package com.zhang._0415;

public class Test1 {
	public static void main(String[] args) {
		int a = 10;
		Integer i = new Integer(20);//Integer:int�İ�װ��
		System.out.println(i);

		int b = i.intValue();
		System.out.println(b);

		Float f = new Float(3.1f);//Float:float�İ�װ��
		System.out.println(f);

		float f1 = f.floatValue();
		System.out.println(f1);

		// jdk5�����ԣ��Զ�װ����Զ����䣨ֻ�����ڰ�װ���У�
		// �Զ�װ�䣺�� �������� �� ��������
		Integer in1 = 100;
		Integer in2 = 200;

		Double b1 = 3.1;
		Float f2 = 3.1f;

		// �Զ����䣺�� �������� �� ��������
		int i1 = in1 + in2;
		System.out.println(i1);
	}

}
