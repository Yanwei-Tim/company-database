package com.zhang._0419;

import java.io.File;

public class TestFile3 {
	public static void main(String[] args) {
		
		/**
		 * �����ļ��У�mkdir--���뱣֤����Ŀ¼����
		 * 		 mkdirs--����Ҫ��֤����Ŀ¼���ڣ�����ֱ�Ӵ���ȫ����Ŀ¼�ṹ��ͨ���������
		 */
		File file = new File("E:/java/java");
//		boolean b = file.mkdir();
//		System.out.println(b); //false
		boolean b1 = file.mkdirs();
		System.out.println(b1);//true
	}
}
