package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB02 {

	// ���� ã�Ƽ� ����ϰڴ�.
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver ����
		Class.forName("oracle.jdbc.driver.OracleDriver"); // ojdbc6 �ȿ� �� �ִ°Ŵ�.

		// 2. ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query�غ�
		Statement stmt = con.createStatement();
		String sql = " SELECT DEPTNO, DNAME, LOC " + " FROM DEPT " + " WHERE DEPTNO =  ";

		Scanner sc = new Scanner(System.in);
		System.out.println("�μ��� �������ּ���. (10/20/30/40)");
		int deptno = sc.nextInt();
		sql = sql + deptno;
		System.out.println(sql);

		// 4. ���� �� ����
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) { // rs.next�� ������ �� ��ĭ�� ���Եȴ�.
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}

		// 5. db ����

		rs.close();
		stmt.close();
		con.close();

	}
}
