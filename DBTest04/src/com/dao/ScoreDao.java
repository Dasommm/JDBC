package com.dao;

import java.util.List;
import com.dto.ScoreDto;

public interface ScoreDao {
	
	String SELET_LIST_SQL = " SELECT S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE FROM SCORE ";
	String SELET_ONE_SQL = " SELECT S_NAME, S_KOR, S_ENG, S_MATH, S_SUM, S_AVG, S_GRADE FROM SCORE "
			+ " WHERE S_NAME = ? ";
	String INSERT_SQL = " INSERT INTO SCORE VALUES(?,?,?,?,?,?,?) ";
	String UPDATE_SQL = " UPDATE SCORE SET S_KOR =?, S_ENG =?, S_MATH = ?, S_SUM =? , S_AVG =?, S_GRADE = ? "
			+ " WHERE S_NAME =? ";
	String DELETE_SQL = " DELETE FROM SCORE WHERE S_NAME = ? ";
	String TOP_N_SQL = " SELECT * " + 
						" FROM " + 
						"	(SELECT ROWNUM AS R, S_NAME, S_KOR,S_ENG,S_MATH,S_SUM,S_AVG, S_GRADE " + 
						"		FROM (SELECT S_NAME, S_KOR,S_ENG,S_MATH,S_SUM,S_AVG, S_GRADE " + 
						"				FROM SCORE ORDER BY S_AVG DESC)A)B " + 
						" WHERE R = ? ";
	// query문들을 모아두자.

	public List<ScoreDto> selectList();
	public ScoreDto selectOne(String s_name);
	public int insert(ScoreDto dto);
	public int update(ScoreDto dto);
	public int delete(String s_name);
	
	public ScoreDto topNSelect(int n);
}
