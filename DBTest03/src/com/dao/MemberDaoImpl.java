package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.db.JDBCTemplate;
import com.dto.MemberDto;
//extends 안하고 아래처럼 import해도 된다. 
//import static com.db.JDBCTemplate.*

public class MemberDaoImpl extends JDBCTemplate implements MemberDao {

	@Override
	public List<MemberDto> selectList() {

		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<MemberDto>();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_LIST_SQL);
			while (rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setGender(rs.getString(4));
				dto.setLocation(rs.getString(5));
				dto.setJob(rs.getString(6));
				dto.setTel(rs.getString(7));
				dto.setEmail(rs.getString(8));

				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		return list;
	}

	@Override
	public MemberDto selectOne(int no) {
		Connection con = getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		MemberDto dto = new MemberDto();

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_ONE_SQL + no);
			while (rs.next()) {
				dto.setNo(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setAge(rs.getInt(3));
				dto.setGender(rs.getString(4));
				dto.setLocation(rs.getString(5));
				dto.setJob(rs.getString(6));
				dto.setTel(rs.getString(7));
				dto.setEmail(rs.getString(8));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(stmt);
			close(con);
		}
		return dto;
	}

	@Override
	public int insert(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(INSERT_SQL);
			pstm.setInt(1, dto.getNo());
			pstm.setString(2, dto.getName());
			pstm.setInt(3, dto.getAge());
			pstm.setString(4, dto.getGender());
			pstm.setString(5, dto.getLocation());
			pstm.setString(6, dto.getJob());
			pstm.setString(7, dto.getTel());
			pstm.setString(8, dto.getEmail());

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	@Override
	public int update(MemberDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;

		try {
			pstm = con.prepareStatement(UPDATE_SQL);
			pstm.setString(1, dto.getName());
			pstm.setInt(2, dto.getAge());
			pstm.setString(3, dto.getGender());
			pstm.setString(4, dto.getLocation());
			pstm.setString(5, dto.getJob());
			pstm.setString(6, dto.getTel());
			pstm.setString(7, dto.getEmail());
			pstm.setInt(8, dto.getNo());

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			System.out.println("[Error] : 3,4");
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}

	@Override
	public int delete(int no) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		try {
			pstm = con.prepareStatement(DELETE_SQL);
			pstm.setInt(1, no);

			res = pstm.executeUpdate();
			if (res > 0) {
				commit(con);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstm);
			close(con);
		}
		return res;
	}
}
