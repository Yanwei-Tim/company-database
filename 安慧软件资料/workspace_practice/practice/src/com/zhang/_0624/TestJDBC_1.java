package com.zhang._0624;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBC_1 {

	public static void main(String[] args) throws Exception {

		// ��������
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// ��ȡ���ӣ��õ�Connection����
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.240:1521:orcl", "trff_app","trff_app");

		// ��ȡStatement����
		Statement statement = conn.createStatement();

		// Statement����ִ�в�ѯsql������ResultSet���������
		String sql = "select * from t_user";
		ResultSet rs = statement.executeQuery(sql);

		// ���������
		while (rs.next()) {
			System.out.println(rs.getString("username")); // ������
		}
		
		// �ر���Դ
		rs.close();
		statement.close();
		conn.close();
	}
}
