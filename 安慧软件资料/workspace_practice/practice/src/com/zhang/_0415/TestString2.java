package com.zhang._0415;

public class TestString2 {
	public static void main(String[] args) {
		
		/**
		 * �ַ�����ƴ�ӣ�+
		 * �κ��������ַ���ƴ�Ӷ������ַ���
		 */
		String s1 = 10+"abc";
		System.out.println(s1);//10abc
		
		String s2 = true+"abc";
		System.out.println(s2);//trueabc
		
		String s3 = 1+2+'0'+"a"+2+3;
		System.out.println(s3);//51a23('0'���ַ�����0�ᱻת����ASCIIΪ48)

	}

}
