package com.zhang._0413;

public class TestSingleton {
	
	public static void main(String[] args) {
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		//==�����ж��������õĵ�ֵַ�Ƿ����
		System.out.println(s1==s2);	//true
		
	}

}
