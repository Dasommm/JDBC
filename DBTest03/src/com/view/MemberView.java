package com.view;

import java.util.List;
import java.util.Scanner;
import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

//view랑 controller와 결합
public class MemberView {

	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		sb.append("**********\n")
		.append("*1.전체출력*\n")
		.append("*2.선택출력*\n")
		.append("*3.추      가*\n")
		.append("*4.수      정*\n")
		.append("*5.삭      제*\n")
		.append("*6.종      료*\n")
		.append("**********\n");
		
		System.out.println(sb);;
		System.out.println("input select :");
		select = sc.nextInt();
		
		return select;
	}
	
	public static void main(String[] args) {
		int select = 0;
		MemberBiz biz= new MemberBizImpl();
		
		while (select != 6) {
			select = getMenu();
			
			switch(select) {
			
			case 1:
				//전체출력
				List<MemberDto> list = biz.selectList();
				for(MemberDto dto : list) {
					System.out.println(dto);
				}								
				break;
				
			case 2:
				//선택출력
				System.out.println("열람할 번호를 입력하세요 : ");
				int selectNo = sc.nextInt();
				
				MemberDto selectOne = biz.selectOne(selectNo);
				System.out.println(selectOne);				
				break;
				
			case 3:
				//추가
				System.out.println("추가할 번호를 입력하세요 :");
				int insertNo = sc.nextInt();
				System.out.println("이름 : ");
				String insertName = sc.next();
				System.out.println("나이 :");
				int insertAge = sc.nextInt();
				System.out.println("성별 :");
				String insertGender = sc.next();
				System.out.println("주소 : ");
				String insertLocation = sc.next();
				System.out.println("직업 : ");
				String insertJob = sc.next();
				System.out.println("전화번호");
				String insertTel = sc.next();
				System.out.println("이메일");
				String insertEmail = sc.next();
				
				//biz에게 보내려고 dto에 담았다.
				MemberDto insertDto = new MemberDto(insertNo, insertName, insertAge, insertGender, insertLocation, 
						insertJob, insertTel, insertEmail);
				/*
				MemberDto insertDto = new MemberDto();
				insertDto.setNo(insertNo);
				insertDto.setName(insertName);
				... 으로 해도 된다.
				*/	
				int insertRes = biz.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("추가성공");					
				}else {
					System.out.println("추가실패");
				}				
				break;
				
			case 4:
				//수정
				System.out.println("수정할 번호를 입력하세요 : ");
				int updateNo = sc.nextInt();
				System.out.println("이름 : ");
				String updateName = sc.next();
				System.out.println("나이 :");
				int updateAge = sc.nextInt();
				System.out.println("성별 :");
				String updateGender = sc.next();
				System.out.println("주소 : ");
				String updateLocation = sc.next();
				System.out.println("직업 : ");
				String updateJob = sc.next();
				System.out.println("전화번호");
				String updateTel = sc.next();
				System.out.println("이메일");
				String updateEmail = sc.next();
				
				MemberDto updateDto = new MemberDto();
				updateDto.setName(updateName);
				updateDto.setAge(updateAge);
				updateDto.setGender(updateGender);
				updateDto.setLocation(updateLocation);
				updateDto.setJob(updateJob);
				updateDto.setTel(updateTel);
				updateDto.setEmail(updateEmail);
				updateDto.setNo(updateNo);
				
				int updateRes = biz.update(updateDto);
				if(updateRes > 0) {
					System.out.println("수정성공");
				}else {
					System.out.println("수정실패");
				}				
				break;
				
			case 5:
				//삭제
				System.out.println("삭제할 번호를 입력하세요 : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = biz.delete(deleteNo);
				if(deleteRes > 0) {
					System.out.println("삭제성공");
				}else {
					System.out.println("삭제실패");
				}				 
				break;
				
			case 6:
				System.out.println("종료");
				break;
			}				
		}		
	}	
}
