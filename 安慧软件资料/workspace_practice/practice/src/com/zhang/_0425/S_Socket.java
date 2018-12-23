package com.zhang._0425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Socket������server
 * @author zhangyu
 *
 */
public class S_Socket {
	public static void main(String[] args) {
		new Thread(new s_start()).start(); //���������
	}
}

/**
 * ������߳���
 * @author zhangyu
 *
 */
class s_start implements Runnable {

	public void run() {
		BufferedReader re; //��Ч�ַ�������
		try {
			System.out.println("socket������������......");
			ServerSocket socket = new ServerSocket(8080); //����ServerSocket���󣬲��󶨵�8080�˿�
			Socket s = socket.accept();//����������socket�����ӣ�����Socket
			re = new BufferedReader(new InputStreamReader(s.getInputStream()));//s.getInputStream():����Socket��������
			String re_s = re.readLine();//������
			while (re_s != null) {
				System.out.println(re_s);
				re_s = re.readLine();
			}
			re.close();
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
