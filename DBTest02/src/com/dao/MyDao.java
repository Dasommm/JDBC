package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.dto.MyDto;
import common.JDBCTemplate;

// 데이터베이스와 연결해주는 object
// Data Access Object
public class MyDao extends JDBCTemplate  {
	
	//전체출력
	public List<MyDto> selectList(){
		//1 driver연결
		//2 계정 연결
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT NO, NAME, NICKNAME FROM MYTEST";
		
		List<MyDto> list = new ArrayList<MyDto>();
				
		//3 query 준비
		try {
			stmt = con.createStatement();
		
		//4  실행 및 리턴
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MyDto dto = new MyDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setNickname(rs.getString(3));
								
				list.add(dto);				
			}			
		} catch (SQLException e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		}finally {
			//5 db 종료
			close(rs);
			close(stmt);
			close(con);						
		}	
		return list;
	}
	
	//선택출력
	public MyDto selectOne(int no) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT NO, NAME, NICKNAME FROM MYTEST WHERE NO = "+ no;
		
		MyDto dto = new MyDto();
		
		try {
			stmt = con.createStatement();
			
			rs = stmt.executeQuery(sql);
			while (rs.next()) {		//한줄 뽑을거지만 그래도 while을 써준다.
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setNickname(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(stmt);
			close(con);
		}		
		return dto;
	}
	
	//추가
	public int insert(MyDto dto) {	//dto에 있는 데이터를 db에 전달한다.
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " INSERT INTO MYTEST(NO, NAME, NICKNAME) VALUES (?,?,?) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, dto.getNo());
			pstm.setString(2, dto.getName());
			pstm.setString(3, dto.getNickname());
			
			res = pstm.executeUpdate();
			if(res >0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);			
		}
		return res;		
	}
	
	//수정
	public int update(MyDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		String sql = " UPDATE MYTEST SET NAME = ?, NICKNAME = ? WHERE NO = ? ";
		
		try {
			pstm = con.prepareStatement(sql); // 물음표에 값을 넣어줄거다.
			pstm.setString(1, dto.getName());
			pstm.setString(2, dto.getNickname());
			pstm.setInt(3, dto.getNo());
			
			res = pstm.executeUpdate();
			if(res > 0) {
				commit(con);						
			}						
		} catch (SQLException e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);			
		}				
		return res;		
	}
	
	//삭제
	public int delete(int no) {
		Connection con = getConnection();	//1,2번
		PreparedStatement pstm = null;
		
		int res = 0;
		String sql = " DELETE FROM MYTEST WHERE NO = ? ";
		
		try {
			pstm = con.prepareStatement(sql); // 3. query준비
			pstm.setInt(1, no);
		
			res = pstm.executeUpdate();
			if(res >0 ) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(pstm);
			close(con);			
		}				
		return res;		
	}
}
