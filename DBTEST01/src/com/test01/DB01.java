package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {

	// java랑 db랑 연결하기
	// ojdbc6.jar가 연결해주는 애 -> library
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver연결 -> ojdbc6.jar 꼭 추가해야한다!!!
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 해당 클래스를 가져왔다.(ojdbc6에서)

		// 2. 계정 연결
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // db서버의 주소
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);
		// 위의 정보들을 가지고 커넥션 개체를 만들거다. 얘네는 java.sql에 있다.

		// 3. query 준비
		// 데이터 베이스에 전달할 구문과 객체를 준비하겠다.
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM EMP "; // 문장 앞과 뒤는 띄워준다.

		// 4. 실행 및 리턴
		// 테이블을 받아줄 애가 필요하다.
		ResultSet rs = stmt.executeQuery(sql); // 내부적으로 커서를 가지고 있어서 하나하나 가져와준다.
		while (rs.next()) {
			System.out.printf("%d %s %s %d %s %d %d %d \n", rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getInt("MGR"), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt("DEPTNO"));
			// empno가 가진 첫번째 컬럼을 가져온다.
			// empno가 number타입이라서 getInt로 varchar2는 String으로

		}

		// 5. db종료
		// connection이 되어있으면 다른 connection을 할 수 없기 때문에 끊어줘야한다.
		// 가장 마지막에 만든걸 먼저 끊고 순서대로..
		rs.close();
		stmt.close();
		con.close();

	}
}
