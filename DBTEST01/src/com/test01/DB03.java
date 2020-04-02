package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB03 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver연결
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);

		// 3. query 준비
		Scanner sc = new Scanner(System.in);
		System.out.println("번호입력 :");
		int no = sc.nextInt();
		System.out.println("이름입력 :");
		String name = sc.next();
		System.out.println("별명입력 : ");
		String nickname = sc.next();

		// INSER INTO JDBCTEST VALUES(NO, 'NAME', 'NICKNAME'); -> 따옴표 잊지 말것!

		String sql = " INSERT INTO JDBCTEST " + " VALUES (" + no + ", '" + name + "','" + nickname + "') ";
		Statement stmt = con.createStatement();

		// 4. 실행 및 리턴
		// select 는 resultSet으로 받는데
		// insert update delete는 숫자를 리턴하기 때문에 int로
		int res = stmt.executeUpdate(sql);
		// select는 stmt.executeQuery였는데 나머지는 executeUpdate로!! -> 꼭 외우기
		// int는 적용된 숫자( 결과값)이 반환
		if (res > 0) {
			System.out.println("insert 성공");
		} else {
			System.out.println("insert 실패");
		}

		// 5. db종료

		stmt.close();
		con.close();
	}
}
