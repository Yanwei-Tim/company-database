package com.zhang._0413;

public class Circle extends Shape {

	double r;

	// ������ι����������Ϊ�˲���ʹ���޲ι���
	// �����ͱ�������Ը�ֵ
	public Circle(double r) {
		// super(); //���ø�����޲ι���
		this.r = r;
		name = "Բ";
	}
	
	/**
	 * ��д���󷽷�calcS()
	 */
	@Override
	public double calcS() {
		return 3.14 * r * r;
	}
}
