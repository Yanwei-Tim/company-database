package com.zhang._0415;

public class Test2 {
	public static void main(String[] args) {
		// ���ַ���ת����int���ͣ���Integer.parseInt()
		String s = "12345";
		int a = Integer.parseInt(s);
		System.out.println(a);

		s = "100000000000000";
		long l = Long.parseLong(s);
		System.out.println(l);

		s = "3.125f";
		float f = Float.parseFloat(s);
		System.out.println(f);

		// ��ʮ������ת��������������(ע�ⷵ��String)
		// ������
		String s1 = Integer.toBinaryString(100);
		System.out.println(s1);

		// ʮ������
		s1 = Integer.toHexString(1000000);
		System.out.println(s1);

		// �˽���
		s1 = Integer.toOctalString(10000);
		System.out.println(s1);
		
		int b = 10;
		String ss = Integer.toString(b);//Ĭ����ʮ����
		System.out.println(ss);

		ss = Integer.toString(b, 2);
		System.out.println(ss);//������

		ss = Integer.toString(b, 8);
		System.out.println(ss);//�˽���

	}

}
