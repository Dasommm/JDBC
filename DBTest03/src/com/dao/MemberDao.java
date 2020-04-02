package com.dao;

import java.util.List;
import com.dto.MemberDto;

// interface에 하는 이유는 유지보수가 쉽기 위해서 
// 또한 모두 상속해야하기 때문에
public interface MemberDao {

	String SELECT_LIST_SQL = " SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL "
			+ " FROM TB_MEMBER ORDER BY NO DESC ";
	
	String SELECT_ONE_SQL = " SELECT NO, NAME, AGE, GENDER, LOCATION, JOB, TEL, EMAIL"
			+ " FROM TB_MEMBER WHERE NO = ";
	String INSERT_SQL = " INSERT INTO TB_MEMBER VALUES(?,?,?,?,?,?,?,?) ";
	String UPDATE_SQL = " UPDATE TB_MEMBER SET NAME = ?, AGE = ?, GENDER = ?,LOCATION =?, JOB =?,"
			+ "TEL = ?,EMAIL = ? WHERE NO = ?";
	String DELETE_SQL = " DELETE FROM TB_MEMBER WHERE NO = ?";	
	
	public List<MemberDto> selectList();	// 전체출력 - 여러 줄이 나올거기 때문에 List가 리턴타입
	public MemberDto selectOne(int no);	// 선택출력 - 하나만 가져올거기 때문에 primary key인 no로 파라미터
	public int insert(MemberDto dto);		// 추가 - 추가할 데이터 여러개를 전달할 때 dto(한뭉치)를 사용하기 때문에
	public int update(MemberDto dto);		// 수정 - 추가와 동일하다
	public int delete(int no);				// 삭제 - 내가 삭제하고 싶은 유일한 하나(primary key)인 no로 파라미터
	// row의 갯수를 리턴하기 때문에 int로 리턴타입
		
}
