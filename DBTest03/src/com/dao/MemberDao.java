package com.dao;

import java.util.List;
import com.dto.MemberDto;

// interface�� �ϴ� ������ ���������� ���� ���ؼ� 
// ���� ��� ����ؾ��ϱ� ������
public interface MemberDao {

	String SELECT_LIST_SQL = " SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL "
			+ " FROM TB_MEMBER ORDER BY NO DESC ";
	
	String SELECT_ONE_SQL = " SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL"
			+ " FROM TB_MEMBER WHERE NO = ";
	String INSERT_SQL = " INSERT INTO TB_MEMBER VALUES(?,?,?,?,?,?,?,?) ";
	String UPDATE_SQL = " UPDATE TB_MEMBER SET NAME = ?, AGE = ?, GENDER = ?,LOCATION =?, JOB =?,"
			+ "TEL = ?,EMAIL = ? WHERE NO = ?";
	String DELETE_SQL = " DELETE FROM TB_MEMBER WHERE NO = ?";	
	
	public List<MemberDto> selectList();	// ��ü��� - ���� ���� ���ðű� ������ List�� ����Ÿ��
	public MemberDto selectOne(int no);	// ������� - �ϳ��� �����ðű� ������ primary key�� no�� �Ķ����
	public int insert(MemberDto dto);		// �߰� - �߰��� ������ �������� ������ �� dto(�ѹ�ġ)�� ����ϱ� ������
	public int update(MemberDto dto);		// ���� - �߰��� �����ϴ�
	public int delete(int no);				// ���� - ���� �����ϰ� ���� ������ �ϳ�(primary key)�� no�� �Ķ����
	// row�� ������ �����ϱ� ������ int�� ����Ÿ��
		
}
