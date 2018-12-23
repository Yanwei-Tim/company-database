package com.zhang._0419;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestObjectInputStream {
	public static void main(String[] args) throws Exception, IOException {
		//ObjectInputStream:����������--������
		File file = new File("c.txt");
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		Object obj = ois.readObject();//������
		System.out.println(obj);
		ois.close();
		fis.close();
	}
}
