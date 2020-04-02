package com.test01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB01 {

	// java�� db�� �����ϱ�
	// ojdbc6.jar�� �������ִ� �� -> library
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// 1. driver���� -> ojdbc6.jar �� �߰��ؾ��Ѵ�!!!
		Class.forName("oracle.jdbc.driver.OracleDriver"); // �ش� Ŭ������ �����Դ�.(ojdbc6����)

		// 2. ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // db������ �ּ�
		String user = "kh";
		String password = "kh";

		Connection con = DriverManager.getConnection(url, user, password);
		// ���� �������� ������ Ŀ�ؼ� ��ü�� ����Ŵ�. ��״� java.sql�� �ִ�.

		// 3. query �غ�
		// ������ ���̽��� ������ ������ ��ü�� �غ��ϰڴ�.
		Statement stmt = con.createStatement();
		String sql = " SELECT * FROM EMP "; // ���� �հ� �ڴ� ����ش�.

		// 4. ���� �� ����
		// ���̺��� �޾��� �ְ� �ʿ��ϴ�.
		ResultSet rs = stmt.executeQuery(sql); // ���������� Ŀ���� ������ �־ �ϳ��ϳ� �������ش�.
		while (rs.next()) {
			System.out.printf("%d %s %s %d %s %d %d %d \n", rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getInt("MGR"), rs.getDate(5), rs.getInt(6), rs.getInt(7), rs.getInt("DEPTNO"));
			// empno�� ���� ù��° �÷��� �����´�.
			// empno�� numberŸ���̶� getInt�� varchar2�� String����

		}

		// 5. db����
		// connection�� �Ǿ������� �ٸ� connection�� �� �� ���� ������ ��������Ѵ�.
		// ���� �������� ����� ���� ���� �������..
		rs.close();
		stmt.close();
		con.close();

	}
}
