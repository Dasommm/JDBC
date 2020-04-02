package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB04 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query 준비
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM JDBCTEST ";

		// 4. 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			System.out.printf("%d %s %s", rs.getInt(1), rs.getString(2), rs.getString(3));
		}

		// 5. db종료
		rs.close();
		stmt.close();
		con.close();

	}
}
