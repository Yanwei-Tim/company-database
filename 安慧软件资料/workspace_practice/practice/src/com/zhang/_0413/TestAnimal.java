package com.zhang._0413;

public class TestAnimal {

	public static void main(String[] args) {
		Animal a = new Cat(); // ��̬
		System.out.println(a.name);// ----���� ���Բ�������д
		a.eat();// è�Զ���----- ����������д
		a.run();

		Animal a1 = new BsCat();
		System.out.println(a1.name);
		a1.eat();
		a1.run();

		Cat a2 = new BsCat();
		System.out.println(a2.name);
		a2.eat();
		a2.run();

		BsCat a3 = new BsCat();
		System.out.println(a3.name);
		a3.eat();
		a3.run();

		// ����õ���������ԣ����Բ��ö�����ת��(��Ҫǿת)
		Cat a4 = (Cat) a;
		System.out.println(a4.name);// è

		BsCat a5 = (BsCat) a2;
		System.out.println(a5.name);// ��˹è

	}

}
