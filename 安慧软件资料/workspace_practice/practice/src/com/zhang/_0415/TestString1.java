package com.zhang._0415;

public class TestString1 {
	public static void main(String[] args) {
		
		 String s1 = "abc"; //���ַ��������ش���һ��"abc"���󣬲���������
		 String s2 = "abc"; //ֱ�ӽ��ַ����������е�"abc"���ø���s2
		 System.out.println(s2==s1);//true
		 
		 String s3 = "def";//���ַ��������ش���һ��"def"���󣬲���������
		 String s4 = new String("def");//������������new String():�ڶ��д���һ�����󣬽����ø���s4��"def":���ַ��������ش���һ������
		 System.out.println(s3==s4);//false
		 
		 /**
		  * ==:�Ƚϵ�ֵַ
		  * equals���ַ�����equals����д�ˣ��Ƚ�����ֵ
		  * һ����˵��������дequals���������Ե�object��equals���ǱȽ�����ֵ�ģ�����Ҫ��д
		  */
		 System.out.println(s3.equals(s4));//true
	}

}
