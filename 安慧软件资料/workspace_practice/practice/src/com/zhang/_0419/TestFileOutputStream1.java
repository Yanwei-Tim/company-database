package com.zhang._0419;

import java.io.FileOutputStream;

public class TestFileOutputStream1 {

	// FileOutputStream:�ַ������ ----д����
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("b.txt", true);// ���Զ������ļ�,true��ʾ����׷��
		fos.write("zhangyu".getBytes());// д�룬��Ϊ�������ֽ����ͣ�������getByte����
		fos.close();
	}
}
