package com.zhang._0415;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSdf3 {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String s = sdf.format(date); //format�����չ��췽�����ģʽ��ʽ��Date���󣬷��ص����ַ���
		System.out.println(s);
		
		String s1 = "201604151609";
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date d = sdf1.parse(s1); //parse�����ַ���ת����Data����
		System.out.println(d);
		
	}

}
