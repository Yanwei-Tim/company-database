package com.zhang._0419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class TestCopy1 {
	
	public static void main(String[] args) throws Exception {
		//����ͼƬ
		File src = new File("F:/11.png");//Դ�ļ�
		File dest = new File("E:/11.png");//Ŀ�ĵ�
		
		FileInputStream fis = new FileInputStream(src);//������
		FileOutputStream fos = new FileOutputStream(dest);//д����
		
		byte[] buff = new byte[1024];
		int len =0;
		while(-1!=(len=fis.read(buff))){ //��
			fos.write(buff, 0, len); //д
		}
		System.out.println("-------ͼƬ�������--------");
		fos.close();
		fis.close();
	}
}
