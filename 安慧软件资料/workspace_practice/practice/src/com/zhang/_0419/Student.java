package com.zhang._0419;

import java.io.Serializable;

/**
 * ��student����д���ļ��У�Student����ʵ��Serializable���л��ӿ�
 * @author zhangyu
 *
 */
@SuppressWarnings("serial")
public class Student implements Serializable{

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}

}
