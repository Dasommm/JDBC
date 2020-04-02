package com.biz;

import java.util.List;
import com.dto.MemberDto;

public interface MemberBiz {	// Business Logic(=Model), ���, ����, ó���Ѵ�.
	// service��� �Ѵ�.
	// ȭ�� ��ȯ�ϴ°�, db�� �����ϴ°� �ܿ� ��� ���� �ҰŴ�.
	
	public List<MemberDto> selectList();	
	public MemberDto selectOne(int no);	
	public int insert(MemberDto dto);		
	public int update(MemberDto dto);		
	public int delete(int no);

}
