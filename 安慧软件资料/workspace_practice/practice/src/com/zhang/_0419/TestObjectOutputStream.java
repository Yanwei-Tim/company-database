package com.zhang._0419;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class TestObjectOutputStream {
	public static void main(String[] args) throws Exception {
		//ObjectOutputStream:��������д�����
		File file = new File("c.txt");
		FileOutputStream fis = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(new Student()); //д��Ķ��������ʵ�����л��ӿ�
		oos.close();
		fis.close();
	}
}
