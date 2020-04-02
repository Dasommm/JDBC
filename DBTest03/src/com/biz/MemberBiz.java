package com.biz;

import java.util.List;
import com.dto.MemberDto;

public interface MemberBiz {	// Business Logic(=Model), 계산, 연산, 처리한다.
	// service라고도 한다.
	// 화면 전환하는거, db랑 연결하는거 외에 모든 일을 할거다.
	
	public List<MemberDto> selectList();	
	public MemberDto selectOne(int no);	
	public int insert(MemberDto dto);		
	public int update(MemberDto dto);		
	public int delete(int no);

}
