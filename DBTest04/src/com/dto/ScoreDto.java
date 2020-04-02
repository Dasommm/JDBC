package com.dto;

public class ScoreDto {

	private String s_name;
	private int s_kor;
	private int s_eng;
	private int s_math;
	private int s_sum;
	private double s_avg;
	private String s_grade;
	// 사용할 변수들 선언하기 (전역변수)

	// 기본 생성자와 파라미터 값 받는 생성자, getter/setter 만들기
	public ScoreDto() {
	}

	public ScoreDto(String s_name, int s_kor, int s_eng, int s_math, int s_sum, double s_avg, String s_grade) {
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
		this.s_sum = s_sum;
		this.s_avg = s_avg;
		this.s_grade = s_grade;
	}

	// 이름 국어 영어 수학 만 받는 생성자
	public ScoreDto(String s_name, int s_kor, int s_eng, int s_math) {
		this.s_name = s_name;
		this.s_kor = s_kor;
		this.s_eng = s_eng;
		this.s_math = s_math;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_kor() {
		return s_kor;
	}

	public void setS_kor(int s_kor) {
		this.s_kor = s_kor;
	}

	public int getS_eng() {
		return s_eng;
	}

	public void setS_eng(int s_eng) {
		this.s_eng = s_eng;
	}

	public int getS_math() {
		return s_math;
	}

	public void setS_math(int s_math) {
		this.s_math = s_math;
	}

	public int getS_sum() {

		return s_kor + s_eng + s_math;
	}

	public void setS_sum(int s_sum) {
		this.s_sum = s_sum;
	}

	public double getS_avg() {
		return s_avg;
	}

	public void setS_avg(double s_avg) {
		this.s_avg = s_avg;
	}

	public String getS_grade() {
		return s_grade;
	}

	public void setS_grade(String d) {
		this.s_grade = d;
	}

	@Override
	public String toString() {
		return " 이름 : " + s_name + ", 국어 : " + s_kor + ", 영어 : " + s_eng + ", 수학 : " + s_math + ", 합계 : " + s_sum
				+ ", 평균 : " + s_avg + ", 등급 : " + s_grade;
	}
}
