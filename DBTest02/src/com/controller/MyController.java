package com.controller;

import java.util.List;
import java.util.Scanner;
import com.dao.MyDao;
import com.dto.MyDto;

// ȭ���� ����(��ȯ/����)���ִ� 
public class MyController {

	private static Scanner sc = new Scanner(System.in);
	// �Է� ���� ���� ���Ƽ� ���������� �Ѵ�.
	
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		// �� �Ʒ��� main view
		sb.append("1.��ü��� \n")
			.append("2.�������\n")
			.append("3.��   ��\n")
			.append("4.��   ��\n")
			.append("5.��   �� \n")
			.append("6.��   �� \n");
				
		System.out.println(sb);
		System.out.println("��ȣ���� : ");
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
				System.out.println("��ü���");
				List<MyDto> list = dao.selectList();
				for(MyDto dto : list) {
					System.out.println(dto);
				}
				break;
				
			case 2 : 
				System.out.println("�������");
				System.out.println("���� ��ȣ�� �����ϼ���");
				int selectNo = sc.nextInt();
						
				MyDto selectOne = dao.selectOne(selectNo);
				System.out.println(selectOne);
				
				break;
				
			case 3 : 
				System.out.println("�߰�");
				System.out.println("�߰��� ��ȣ�� �Է��ϼ��� :");
				int insertNo = sc.nextInt();
				System.out.println("�߰��� �̸��� �Է��ϼ���");
				String insertName = sc.next();
				System.out.println("�߰��� ������ �Է��ϼ���");
				String insertNickname = sc.next();
				
				MyDto insertDto = new MyDto(insertNo, insertName, insertNickname);
				
				/* ���� ������
				 * MyDto insertDto = new MyDto();
				insertDto.setNo(insertNo);
				insertDto.setName(insertName);
				insertDto.setNickname(insertNickname);
				*/
				
				int insertRes = dao.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("�Է� ����");
				}else {
					System.out.println("�Է� ����");
				}
				
				break;
				
			case 4 : 
				System.out.println("����");
				System.out.println("������ ��ȣ �����ϼ��� :");
				int updateNo = sc.nextInt();
				System.out.println("������ �̸� : ");
				String updateName = sc.next();
				System.out.println("������ ���� : ");
				String updateNickname = sc.next();
				
				MyDto updateDto = new MyDto();
				updateDto.setNo(updateNo);
				updateDto.setName(updateName);
				updateDto.setNickname(updateNickname);
				
				// db�� �����ϴ� �ִ� dao�̱� ������ dao���� �������Ѵ�.
				int updateRes = dao.update(updateDto);
				if(updateRes > 0) {
					System.out.println("���� ����");
				}else {
					System.out.println("���� ����");
				}				
				break;
				
			case 5 : 
				System.out.println("����");
				System.out.println("������ ��ȣ�� �����ϼ��� :");
				int deleteNo = sc.nextInt();
						
				int deleteRes = dao.delete(deleteNo);
				if(deleteRes > 0) {
					System.out.println("���� ����");
				}else {
					System.out.println("���� ����");
				}						
				break;
				
			case 6 : 
				System.out.println("����");
				sc.close();
				System.exit(0);
			}
						
		}while(no != 6);
		
		
		
	}
}
