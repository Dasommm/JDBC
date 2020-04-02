package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB02 {

	// 한줄 찾아서 출력하겠다.
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver 연결
		Class.forName("oracle.jdbc.driver.OracleDriver"); // ojdbc6 안에 들어가 있는거다.

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query준비
		Statement stmt = con.createStatement();
		String sql = " SELECT DEPTNO, DNAME, LOC " + " FROM DEPT " + " WHERE DEPTNO =  ";

		Scanner sc = new Scanner(System.in);
		System.out.println("부서를 선택해주세요. (10/20/30/40)");
		int deptno = sc.nextInt();
		sql = sql + deptno;
		System.out.println(sql);

		// 4. 실행 및 리턴
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) { // rs.next가 없으면 맨 윗칸만 보게된다.
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

		}

		// 5. db 종료

		rs.close();
		stmt.close();
		con.close();

	}
}
