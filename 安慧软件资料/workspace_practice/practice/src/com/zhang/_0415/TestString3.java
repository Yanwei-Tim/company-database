package com.zhang._0415;

import java.util.Arrays;

public class TestString3 {
	public static void main(String[] args) throws Exception {
		byte[] buff = {1,2,3};
		String s= new String(buff,"utf-8");//ΪStringָ�����뷽ʽ
		
		s = "zhangyu linwanyu  ";
		char c = s.charAt(4);//ȡָ��λ�õ��ַ�
		System.out.println(c);
		
		String s1 = "4zhangyu";
		String s2 = "3linwanyu";
		System.out.println(s1.compareTo(s2));//������Ȼ˳��Ƚ��ַ������������֣�������������0��
		
		String s3 ="�����й���";
		byte[] by= s3.getBytes();//���ַ���ת�����ֽ�����
		System.out.println(Arrays.toString(by));
		
		
		
		String s4 = "zhangyuzhangyuzhangyu";

		// indexOf:�õ�ĳ���ַ���һ�γ��ֵ�λ�õ�����
		System.out.println(s4.indexOf("z"));
		System.out.println(s4.indexOf("han"));

		// lastIndexOf:����ָ�����ַ����ڴ��ַ��������һ�γ��ִ�������
		System.out.println(s4.lastIndexOf('z'));
		System.out.println(s4.lastIndexOf("yu"));

		String s5 = "linwanyu";
		String s6 = s5.replace('w', 'q');
		System.out.println(s6);

		// trim():�����ַ����ĸ���������ǰ���հ׺�β���հס�
		String s7 = "  z h a n g y u    ";
		String s8 = s7.trim();
		System.out.println(s8);

		// ���⣺��ôȥ���м�Ŀո�
		// replace
		String s9 = s7.replace(" ", "");
		System.out.println(s9);

		// split:���ݸ���������ʽ��ƥ���ִ��ַ�����

		String s10 = "zhangyu.linwanyu.yangchenlin";
		String[] str = s10.split("\\.");
		System.out.println(Arrays.toString(str));

		// substring:����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ����������ַ�����ָ�����������ַ���ʼ��ֱ�����ַ���ĩβ��
		String s11 = s6.substring(8);
		System.out.println(s11);

		// substring(int beginIndex,int endIndex):����һ�����ַ��������Ǵ��ַ�����һ�����ַ�����
		// �����ַ�����ָ���� beginIndex ����ʼ��ֱ������ endIndex - 1 �����ַ�.
		String s12 = s6.substring(8, 16);
		System.out.println(s12);

		// valueOf:������ �������� ����ֵ������ַ�������̬�������������ã�
		// ��ͬ��+"",ֻ�ǱȽ����档
		System.out.println(String.valueOf(12.3f));

	}

}
