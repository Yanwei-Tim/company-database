package com.zhang._0413;

/**
 * ����
 * ��׼��javabean��
 *
 */
public class Man {

	private String name;// ��������
	private int age;// ��������

	public Man() { // �޲ι���

	}

	public Man(String name, int age) { // ���ι���
		this.name = name;
		this.age = age;
	}

	public void eat() { 	// �Է���Ϊ��������

		System.out.println("�Է�");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
