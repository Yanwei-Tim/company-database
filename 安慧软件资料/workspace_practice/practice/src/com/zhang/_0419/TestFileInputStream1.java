package com.zhang._0419;

import java.io.File;
import java.io.FileInputStream;

public class TestFileInputStream1 {
	public static void main(String[] args) throws Exception {
		
		//FileInputStream:�ֽ�����������ȡ����
		File file = new File("a.txt");
		FileInputStream fis  = new FileInputStream(file);
		byte[] buff = new byte[1024];//�����ֽ�����
		while(fis.available()>0){ //����ֵ����0��ʾ���ݻ�û�ж�ȡ��
			int len = fis.read(buff);
			System.out.println(new String(buff,0,len));
		}
		fis.close();
	}
}
