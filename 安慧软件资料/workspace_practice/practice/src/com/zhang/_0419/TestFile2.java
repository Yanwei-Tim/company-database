package com.zhang._0419;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class TestFile2 {
	public static void main(String[] args) {
		File file = new File("D:/eclipse");

		File[] arr = file.listFiles(); // ��ȡ�����ļ��ģ������ļ�����

		// System.out.println(Arrays.toString(arr));

		/*
		 * for (File f : arr) { //����File���� System.out.println(f); }
		 */

		List<File> list = Arrays.asList(arr);
		for (File f : list) {
			System.out.println(f);
		}
	}
}
