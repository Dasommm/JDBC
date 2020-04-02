package com.dto;

// dto : Data Transfer Object
// vo : Value Object
// db�� �ִ� data�� ���� -> db�� �÷��� ���� �̸����� field ����

public class MyDto {
	/*
	NO NUMBER PRIMARY KEY,
	NAME VARCHAR2(100),
	NICKNAME VARCHAR2(200)
	*/
	
	private int no;
	private String name;
	private String nickname;

	// �⺻������
	// �Ķ���� 3��¥�� ������
	// getter, setter
	public MyDto() {
		
	}
	
	public MyDto(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;		
	}
	
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
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return no + "\t" + name + " \t" + nickname;
	}	
}
