package com.zhang._0415;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSdf2 {
	public static void main(String[] args) throws Exception {
		String s = "20150808160520";
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("yyyyMMddHHmmss");// �����ģʽҪ�ͱ������ĸ�ʽ��ͬ
		Date date = sdf.parse(s);// parse������s�ĸ�ʽ
		sdf.applyPattern("yyyy-MM-dd HH:mm:ss E");// Ҫ�����ɵ�ģʽ
		System.out.println(sdf.format(date));// ��ʽ��
	}
}
