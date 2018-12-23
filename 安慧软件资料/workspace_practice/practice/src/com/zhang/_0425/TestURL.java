package com.zhang._0425;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL�ࣺ��������ʵ�ַ��url ��java.net.url����
 * 
 * @author zhangyu
 *
 */
public class TestURL {
	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL("http://www.baidu.com/index.jsp");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		System.out.println(url.getProtocol());// ��ȡЭ����
		System.out.println(url.getPort());// ��ȡ�˿ںţ�û�вⷵ��-1
		System.out.println(url.getDefaultPort());// ��ȡĬ�ϵö˿ںţ�80�˿���Ĭ�ϵö˿ں�
		System.out.println(url.getPath());// ��ȡurl��·������----/index.jsp
	}
}
