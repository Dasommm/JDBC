package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver ����
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query �غ�
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM JDBCTEST ";

		// 4. ���� �� ����
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.printf("%d %s %s", rs.getInt(1), rs.getString(2), rs.getString(3));
		}

		// 5. db����
		rs.close();
		stmt.close();
		con.close();

	}
}
