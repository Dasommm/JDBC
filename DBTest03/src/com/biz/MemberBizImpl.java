package com.biz;

import java.util.List;
import com.dao.MemberDao;
import com.dao.MemberDaoImpl;
import com.dto.MemberDto;


public class MemberBizImpl implements MemberBiz {

	private MemberDao dao = new MemberDaoImpl();
	
	@Override
	public List<MemberDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MemberDto selectOne(int no) {
		return dao.selectOne(no);
	}

	@Override
	public int insert(MemberDto dto) {
		MemberDto tmp = dto;
		tmp.setGender(dto.getGender().toUpperCase());		
		
		return dao.insert(tmp);
	}

	@Override
	public int update(MemberDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int no) {
		return dao.delete(no);
	}

}
