package com.test01;

// import static으로 하면 아래에서 쓸 때 생략 가능하다.
import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DB05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 번호 : ");
		
		int no = sc.nextInt();
		
		//1.
		//2.
		Connection con = getConnection(); 
		// jdbc template를 호출해서 con에 담을거다.
		Statement stmt = null;
		int res = 0;
		String sql = " DELETE FROM JDBCTEST WHERE NO = " + no;
				
		//3.
		try {
			stmt = con.createStatement();
			
		//4.
			res = stmt.executeUpdate(sql);			
			if(res > 0) {
				System.out.println("삭제 성공");
				commit(con);				
			}					
		} catch (Exception e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		} finally {
			
		//5. 
			close(stmt);
			close(con);						
		}		
	}
}
