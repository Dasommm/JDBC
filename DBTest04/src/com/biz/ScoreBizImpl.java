package com.biz;

import java.util.List;

import com.dao.ScoreDao;
import com.dao.ScoreDaoImpl;
import com.dto.ScoreDto;

public class ScoreBizImpl implements ScoreBiz {

	private ScoreDao dao = new ScoreDaoImpl();

	@Override
	public List<ScoreDto> selectList() {
		return dao.selectList();
	}

	@Override
	public ScoreDto selectOne(String s_name) {
		return dao.selectOne(s_name);
	}

	@Override
	public int insert(ScoreDto dto) {
		dto.setS_sum(getSum(dto.getS_kor(), dto.getS_eng(), dto.getS_math()));
		dto.setS_avg(getAvg(dto.getS_sum()));
		dto.setS_grade(getGrade(dto.getS_avg()));

		return dao.insert(dto);
	}

	@Override
	public int update(ScoreDto dto) {
		dto.setS_sum(getSum(dto.getS_kor(), dto.getS_eng(), dto.getS_math()));
		dto.setS_avg(getAvg(dto.getS_sum()));
		dto.setS_grade(getGrade(dto.getS_avg()));

		return dao.update(dto);
	}

	@Override
	public int delete(String s_name) {
		return dao.delete(s_name);
	}

	public int getSum(int kor, int eng, int math) {
		return kor + eng + math;
	}

	public double getAvg(int sum) {
		return sum / 3.0;
	}

	public String getGrade(double avg) {
		switch ((int) avg / 10) {
		case 10:
		case 9:
			return "A";

		case 8:
			return "B";

		case 7:
			return "C";

		case 6:
			return "D";
		}
		return "F";
	}

	@Override
	public ScoreDto topNSelect(int n) {
		return dao.topNSelect(n);
	}
}
