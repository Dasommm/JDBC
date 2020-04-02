package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver����
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query �غ�
		Scanner sc = new Scanner(System.in);
		System.out.println("��ȣ�Է� :");
		int no = sc.nextInt();
		System.out.println("�̸��Է� :");
		String name = sc.next();
		System.out.println("�����Է� : ");
		String nickname = sc.next();

		// INSER INTO JDBCTEST VALUES(NO, 'NAME', 'NICKNAME'); -> ����ǥ ���� ����!

		String sql = " INSERT INTO JDBCTEST " + " VALUES (" + no + ", '" + name + "','" + nickname + "') ";
		Statement stmt = con.createStatement();

		// 4. ���� �� ����
		// select �� resultSet���� �޴µ�
		// insert update delete�� ���ڸ� �����ϱ� ������ int��
		int res = stmt.executeUpdate(sql);
		// select�� stmt.executeQuery���µ� �������� executeUpdate��!! -> �� �ܿ��
		// int�� ����� ����( �����)�� ��ȯ
		if (res > 0) {
			System.out.println("insert ����");
		} else {
			System.out.println("insert ����");
		}

		// 5. db����

		stmt.close();
		con.close();
	}
}
