package com.zhang._0415;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestList1 {
	public static void main(String[] args) {
		// list�����򣬿��ظ���

		Student s1 = new Student("����", 18);
		Student s2 = new Student("����", 19);
		Student s3 = new Student("����", 20);
		Student s4 = new Student("����", 21);
		Student s5 = new Student("����", 22);

		List<Student> list = new ArrayList<Student>();
		list.add(s1); // Ϊlist���Ԫ��
		list.add(s2);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		/*********************** list�ı��� *************************/
		System.out.println("---------��ͨforѭ������----------");// ȡ����list�������
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("---------��ǿ��forѭ������-------------");// ȱ�㣺��ʧ����
		for (Student s : list) {
			System.out.println(s);
		}

		System.out.println("----------����������----------");
		Iterator<Student> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
