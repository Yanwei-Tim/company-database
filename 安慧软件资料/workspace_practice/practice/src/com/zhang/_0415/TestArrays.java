package com.zhang._0415;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 32, 65, 9541, 321, 32 };
		System.out.println(arr);  //�������������ͣ���ӡ���ǵ�ֵַ
		System.out.println(Arrays.toString(arr));//��ӡ����ķ���
		System.out.println("--------------");

		Arrays.sort(arr);//�������������
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));
	}

}
