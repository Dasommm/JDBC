package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import common.JDBCTemplate;

public class DB06 extends JDBCTemplate {

	public static void main(String[] args) {
		// ��ȣ�� �޾Ƽ� �ش� �ϴ� ����� �̸��� �ٲܰŴ�
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��ȣ : ");
		int no = sc.nextInt();
		System.out.println("������ �̸� : ");
		String name = sc.next();
		System.out.println("������ ���� : ");
		String nickName = sc.next();

		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE JDBCTEST SET NAME = ? , NICKNAME = ? " + " WHERE NO = ? ";

		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, name);
			pstm.setString(2, nickName);
			pstm.setInt(3, no);

			res = pstm.executeUpdate();
			if (res > 0) {
				System.out.println("���� ����");
				commit(con);
			} else {
				System.out.println("���� ����");
			}
		} catch (SQLException e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
	}
}
