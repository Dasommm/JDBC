package com.test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import common.JDBCTemplate;

public class DB06 extends JDBCTemplate {

	public static void main(String[] args) {
		// 번호를 받아서 해당 하는 사람의 이름을 바꿀거다
		Scanner sc = new Scanner(System.in);
		System.out.println("수정할 번호 : ");
		int no = sc.nextInt();
		System.out.println("수정할 이름 : ");
		String name = sc.next();
		System.out.println("수정할 별명 : ");
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
				System.out.println("수정 성공");
				commit(con);
			} else {
				System.out.println("수정 실패");
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
