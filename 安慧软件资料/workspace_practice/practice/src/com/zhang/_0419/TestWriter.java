package com.zhang._0419;

import java.io.FileWriter;

public class TestWriter {
	public static void main(String[] args) throws Exception {
		
		/**
		 * ����������ȡ���ݣ��������д����
		 * �ֽ�����������InputStream �ֽ������:OutPutStream
		 * �ַ���������Reader �ַ��������Write
		 */
		//A.������a.txt�ļ�
		//B.�������ַ����������fw,���ҽ��ö���ָ���ļ�
		FileWriter fw = new FileWriter("a.txt");
		fw.write("����");//���ļ�д���ݣ�ע���ʱ����û�н�ȥ����Ҫflushһ�²ſ���
		fw.flush();//ˢ��
		fw.close();//�������ͷ���Դ
	}
}
