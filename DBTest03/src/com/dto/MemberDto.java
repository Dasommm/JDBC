package com.dto;

public class MemberDto {
	private int no;
	private String name;
	private int age;
	private String gender;
	private String location;
	private String job;
	private String tel;
	private String email;
	// 필드 (전역변수)

	// 기본생성자
	public MemberDto() {
	}

	public MemberDto(int no, String name, int age, String gender, String location, String job, String tel, String email) {
		this.no = no;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.location =location;
		this.job = job;
		this.tel = tel;
		this.email = email;
	}

	// getter, setter
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return " 번호 = " + no + ", 이름 =" + name + ", 나이=" + age + ", 성별 =" + gender + ", 주소 = "+ location 
				+ ", 직업 =" + job	+ ", 전화번호 =" + tel + ", 이메일 =" + email;
	}

}
