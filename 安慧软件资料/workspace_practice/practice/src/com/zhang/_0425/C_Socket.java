package com.zhang._0425;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Socket�ͻ���client
 * @author zhangyu
 *
 */
public class C_Socket {

	public static void main(String[] args) {
		new Thread(new c_start()).start(); //�����ͷ���
	}
}
/**
 * �ͻ����߳���
 * @author zhangyu
 *
 */
class c_start implements Runnable {

	public void run() {

		BufferedWriter o_b; //��Ч�ַ������

		try {
			System.out.println("socket�ͻ���������......");
			Socket s = new Socket("127.0.0.1", 8080);  //����һ��Socket���󣬲�������ڱ�����8080�˿���
			o_b = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));//s.getOutputStream():�õ������
			System.out.println("����������Ҫ���������:");
			Scanner s_c = new Scanner(System.in);
			o_b.write("�ͻ���-���룺" + s_c.next());
			o_b.flush();
			o_b.close();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}