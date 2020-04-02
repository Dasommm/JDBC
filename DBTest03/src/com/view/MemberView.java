package com.view;

import java.util.List;
import java.util.Scanner;
import com.biz.MemberBiz;
import com.biz.MemberBizImpl;
import com.dto.MemberDto;

//view�� controller�� ����
public class MemberView {

	private static Scanner sc = new Scanner(System.in);
	
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		int select = 0;
		
		sb.append("**********\n")
		.append("*1.��ü���*\n")
		.append("*2.�������*\n")
		.append("*3.��      ��*\n")
		.append("*4.��      ��*\n")
		.append("*5.��      ��*\n")
		.append("*6.��      ��*\n")
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
				//��ü���
				List<MemberDto> list = biz.selectList();
				for(MemberDto dto : list) {
					System.out.println(dto);
				}								
				break;
				
			case 2:
				//�������
				System.out.println("������ ��ȣ�� �Է��ϼ��� : ");
				int selectNo = sc.nextInt();
				
				MemberDto selectOne = biz.selectOne(selectNo);
				System.out.println(selectOne);				
				break;
				
			case 3:
				//�߰�
				System.out.println("�߰��� ��ȣ�� �Է��ϼ��� :");
				int insertNo = sc.nextInt();
				System.out.println("�̸� : ");
				String insertName = sc.next();
				System.out.println("���� :");
				int insertAge = sc.nextInt();
				System.out.println("���� :");
				String insertGender = sc.next();
				System.out.println("�ּ� : ");
				String insertLocation = sc.next();
				System.out.println("���� : ");
				String insertJob = sc.next();
				System.out.println("��ȭ��ȣ");
				String insertTel = sc.next();
				System.out.println("�̸���");
				String insertEmail = sc.next();
				
				//biz���� �������� dto�� ��Ҵ�.
				MemberDto insertDto = new MemberDto(insertNo, insertName, insertAge, insertGender, insertLocation, 
						insertJob, insertTel, insertEmail);
				/*
				MemberDto insertDto = new MemberDto();
				insertDto.setNo(insertNo);
				insertDto.setName(insertName);
				... ���� �ص� �ȴ�.
				*/	
				int insertRes = biz.insert(insertDto);
				if(insertRes > 0) {
					System.out.println("�߰�����");					
				}else {
					System.out.println("�߰�����");
				}				
				break;
				
			case 4:
				//����
				System.out.println("������ ��ȣ�� �Է��ϼ��� : ");
				int updateNo = sc.nextInt();
				System.out.println("�̸� : ");
				String updateName = sc.next();
				System.out.println("���� :");
				int updateAge = sc.nextInt();
				System.out.println("���� :");
				String updateGender = sc.next();
				System.out.println("�ּ� : ");
				String updateLocation = sc.next();
				System.out.println("���� : ");
				String updateJob = sc.next();
				System.out.println("��ȭ��ȣ");
				String updateTel = sc.next();
				System.out.println("�̸���");
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
					System.out.println("��������");
				}else {
					System.out.println("��������");
				}				
				break;
				
			case 5:
				//����
				System.out.println("������ ��ȣ�� �Է��ϼ��� : ");
				int deleteNo = sc.nextInt();
				
				int deleteRes = biz.delete(deleteNo);
				if(deleteRes > 0) {
					System.out.println("��������");
				}else {
					System.out.println("��������");
				}				 
				break;
				
			case 6:
				System.out.println("����");
				break;
			}				
		}		
	}	
}
