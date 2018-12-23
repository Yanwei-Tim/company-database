package com.zhang._0415;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TestMap1 {
	public static void main(String[] args) {
		// Map:��ֵ�Ե���ʽ�洢����---key��value

		Map<Integer, String> map = new HashMap<Integer, String>();

		// ���
		map.put(1, "hello");
		map.put(2, "world");

		// ��ͬ��key�Ḳ��value
		map.put(2, "java");

		/****************** ������map�ı��� ************************/
		System.out.println("------------ͨ������ֵ��keySet����������----------------");
		// ��ȡ���е�key����
		Set<Integer> set = map.keySet();
		// ����key���ϣ���ǿ��for����ͨ��key�ҵ�value
		for (Integer i : set) {
			String value = map.get(i);// �õ����е�value
			System.out.println("key:" + i + "--" + "vaule:" + value);
		}

		System.out.println("------------ͨ��Entry��entrySet����������---------");
		// ��ȡEntrySet��Set����
		Set<Entry<Integer, String>> entry = map.entrySet();
		// ����EntrySet����ȡkey��value
		for (Entry<Integer, String> en : entry) {
			Integer key = en.getKey();// ��ȡkey
			String value = en.getValue();// ��ȡvalue
			System.out.println("key:" + key + "--" + "value:" + value);
		}

		System.out.println("---------ͨ��valuesֻ��ȡֵ-------");
		// ��ȡֵ
		Collection<String> coll = map.values();
		// ����ֵ����
		for (String s : coll) {
			System.out.println(s);
		}
	}

}
