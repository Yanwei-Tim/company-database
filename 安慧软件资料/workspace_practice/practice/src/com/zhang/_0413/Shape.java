package com.zhang._0413;

/**
 * ������abstract
 *
 */
public abstract class Shape{
	
	String name;
	
	public abstract double calcS(); //���󷽷�,abstract����ʡ��
	
	public Shape(){
		System.out.println("Shape ���췽��");
	}
	public void printS(double d){
		System.out.println(name+"�������"+d);
	}
}
