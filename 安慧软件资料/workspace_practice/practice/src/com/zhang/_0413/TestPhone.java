package com.zhang._0413;

public class TestPhone {
	
	public static void main(String[] args) {
		
		/*AndroidPhone ap = new AndroidPhone();
		System.out.println(ap.name);
		ap.call();
		ap.sms();*/
		
		//��̬д��
		Phone p = new AndroidPhone();   //��̬�����ҵ�����⣬��׿�ֻ����ֻ�
		System.out.println(p.name); //���������----���Բ�������д
		p.call();//��׿�ֻ���绰-----����ʵ������д����ӡ����������д�ķ�����
		p.sms();
		
		//�����Ҫ������������ԣ����Բ��ã�����ת��
		
		AndroidPhone ap = (AndroidPhone)p;//����ת��
		System.out.println(ap.name);//------���������
		
		//�ж�һ�������ǲ���һ�����ʵ����instanceof
		System.out.println(p instanceof Phone);//true
		System.out.println(p instanceof AndroidPhone);//true
		System.out.println(p instanceof Object);//true----�κζ��󶼼̳���object������Object��һ��ʵ��
	}
}
