package com.controller;

import java.util.List;
import java.util.Scanner;
import com.dao.MyDao;
import com.dto.MyDto;

// 화면을 응답(전환/제어)해주는 
public class MyController {

	private static Scanner sc = new Scanner(System.in);
	// 입력 받을 값이 많아서 전역변수로 한다.
	
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		// 이 아래가 main view
		sb.append("1.전체출력 \n")
			.append("2.선택출력\n")
			.append("3.추   가\n")
			.append("4.수   정\n")
			.append("5.삭   제 \n")
			.append("6.종   료 \n");
				
		System.out.println(sb);
		System.out.println("번호선택 : ");
		select = sc.nextInt();
				
		return select;
		
	}
	
	public static void main(String[] args) {
		int no = 0;
		MyDao dao = new MyDao();
		// model
		
		do {
			no = getMenu();
	
			// controller
			switch(no) {
			case 1 : 
				System.out.println("전체출력");
				List<MyDto> list = dao.selectList();
				for(MyDto dto : list) {
					System.out.println(dto);
				}
				break;
				
			case 2 : 
				System.out.println("선택출력");
				System.out.println("열람 번호를 선택하세요");
				int selectNo = sc.nextInt();
						
				MyDto selectOne = dao.selectOne(selectNo);
				System.out.println(selectOne);
				
				break;
				
			case 3 : 
				System.out.println("추가");
				System.out.println("추가할 번호를 입력하세요 :");
				int insertNo = sc.nextInt();
				System.out.println("추가할 이름을 입력하세요");
				String insertName = sc.next();
				System.out.println("추가할 별명을 입력하세요");
				String insertNickname = sc.next();
				
				MyDto insertDto = new MyDto(insertNo, insertName, insertNickname);
				
				/* 솜이 적은거
				 * MyDto insertDto = new MyDto();
				insertDto.setNo(insertNo);
				insertDto.setName(insertName);
				insertDto.setNickname(insertNickname);
				*/
				
				int insertRes = dao.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("입력 성공");
				}else {
					System.out.println("입력 실패");
				}
				
				break;
				
			case 4 : 
				System.out.println("수정");
				System.out.println("수정할 번호 선택하세요 :");
				int updateNo = sc.nextInt();
				System.out.println("수정할 이름 : ");
				String updateName = sc.next();
				System.out.println("수정할 별명 : ");
				String updateNickname = sc.next();
				
				MyDto updateDto = new MyDto();
				updateDto.setNo(updateNo);
				updateDto.setName(updateName);
				updateDto.setNickname(updateNickname);
				
				// db와 연결하는 애는 dao이기 때문에 dao에게 보내야한다.
				int updateRes = dao.update(updateDto);
				if(updateRes > 0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}				
				break;
				
			case 5 : 
				System.out.println("삭제");
				System.out.println("삭제할 번호를 선택하세요 :");
				int deleteNo = sc.nextInt();
						
				int deleteRes = dao.delete(deleteNo);
				if(deleteRes > 0) {
					System.out.println("삭제 성공");
				}else {
					System.out.println("삭제 실패");
				}						
				break;
				
			case 6 : 
				System.out.println("종료");
				sc.close();
				System.exit(0);
			}
						
		}while(no != 6);
		
		
		
	}
}
