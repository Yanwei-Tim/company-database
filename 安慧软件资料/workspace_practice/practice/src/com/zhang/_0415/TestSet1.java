package com.zhang._0415;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestSet1 {
	public static void main(String[] args) {
		// set:���򣬲������ظ�
		// setȥ��ԭ����д�������͵�hashcode��equal����

		Student s1 = new Student("����", 18);
		Student s2 = new Student("����", 19);
		Student s3 = new Student("����", 20);
		Student s4 = new Student("����", 21);
		Student s5 = new Student("����", 22);

		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);
		set.add(s3);
		set.add(s4);
		set.add(s5);

		/************************* ������set�ı��� *****************************/
		System.out.println("-----------��ǿforѭ������--------");// ����set������ģ����Բ�������forѭ��������
		for (Student s : set) {
			System.out.println(s );
		}

		System.out.println("----------����������------------");
		Iterator<Student> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
