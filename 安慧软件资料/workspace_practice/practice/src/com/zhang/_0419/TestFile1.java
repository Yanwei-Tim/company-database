package com.zhang._0419;

import java.io.File;
import java.io.IOException;

public class TestFile1 {
	public static void main(String[] args) {
		
		File file = new File("E:/java.java"); //��ʾ�ļ���ָ�򣬲����Ǵ����ļ�
		try {
			boolean b = file.createNewFile(); //�����ļ�
			System.out.println("�����ļ���״̬:"+b);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(file.exists());//�ж��ļ��Ƿ����
		
		System.out.println(file.getName());//�õ��ļ���
		
		System.out.println(file.getAbsolutePath());//�õ��ļ��ľ���·��
		
		System.out.println(file.getPath());//�õ����·��
		
		/**
		 * ɾ���ļ��������ļ��У��������ļ��Ļ����ǲ��ܱ�ɾ����
		 * ע�⣺�����߻���վ��
		 */
		System.out.println(file.delete());
	}

}
