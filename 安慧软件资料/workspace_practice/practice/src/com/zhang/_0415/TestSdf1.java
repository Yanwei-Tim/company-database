package com.zhang._0415;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSdf1 {
	public static void main(String[] args) {
		/**
		 * SimpleDateFormat:����(parse)����ʽ��(format)ʱ��
		 */
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss E"); //applyPattern:�������ģʽ����
		String s = sdf.format(new Date());	//format:��ʽ��
		System.out.println(s);
		
		System.out.println("----------------------");
		sdf.applyPattern("yyyy��MM��dd��  HH:mm:ss");
		String s1 = sdf.format(new Date());	//format:��ʽ��
		System.out.println(s1);
	}
}
