package com.zhang._0425;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress2 {
	public static void main(String[] args) {
		try {
			InetAddress ia = InetAddress.getByName("www.baidu.com");//����url�Զ�����
			System.out.println(ia.getHostAddress());//���ip��ַ
			System.out.println(ia.getHostName());//���������
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
