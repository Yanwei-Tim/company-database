package com.zhang._0413;

public class Phone {

	String name = "���������";
	double price;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void call() {
		System.out.println("��绰");
	}

	public void sms() {
		System.out.println("������");

	}

}
