package com.zhang._0413;

public class TestMan {
	
	public static void main(String[] args) {
		
		Man m = new Man();//����Man���󣬾��ǵ���Man���޲ι��췽��
		m.eat();//���÷���
		m.setAge(22);//�����Ը�ֵ
		m.setName("����");//�����Ը�ֵ
		System.out.println(m.getName()+"����"+m.getAge()+"�꣡");//������Ե�ֵ
		
		Man m1 = new Man("����",45);//����Man���󣬾��ǵ���Man�Ĵ��ι��췽��
		m1.eat();
		System.out.println(m1.getName()+"����"+m1.getAge()+"�꣡");
	
	}
}
