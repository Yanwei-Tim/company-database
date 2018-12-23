package com.zhang._0415;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap2 {
	public static void main(String[] args) {

		Student s1 = new Student("����", 18);
		Student s2 = new Student("����", 19);
		Student s3 = new Student("����", 20);
		Student s4 = new Student("����", 21);
		Student s5 = new Student("����", 22);

		Map<Integer, Student> map = new HashMap<Integer, Student>();
		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		map.put(4, s4);
		map.put(5, s5);

		// ����map
		System.out.println("----------��ʽһ----------");
		Set<Integer> key = map.keySet();
		for (Integer i : key) {
			Student value = map.get(i);
			System.out.println("key:" + i + " " + "value:" + value);
		}

		System.out.println("----------��ʽ��----------");
		Set<Entry<Integer, Student>> entry = map.entrySet();
		for (Entry<Integer, Student> en : entry) {
			Integer k = en.getKey();
			Student v = en.getValue();
			System.out.println("key:" + k + " " + "value:" + v);
		}

		System.out.println("----------��ʽ��----------");
		Collection<Student> coll = map.values();
		for (Student s : coll) {
			System.out.println(s);
		}
	}
}
