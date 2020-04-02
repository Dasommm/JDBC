package com.controller;

import java.util.List;
import java.util.Scanner;
import com.biz.ScoreBiz;
import com.biz.ScoreBizImpl;
import com.dto.ScoreDto;

public class ScoreController {

	private static Scanner sc = new Scanner(System.in);

	private static int getMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("1. ��ü��� \n");
		sb.append("2. ������� \n");
		sb.append("3. ��      �� \n");
		sb.append("4. ��      ��\n");
		sb.append("5. ��      �� \n");
		sb.append("---------\n");
		sb.append("6. 1�� ���\n");
		sb.append("7. 2�� ���\n");
		sb.append("8. 3�� ���\n");
		sb.append("9. ��      ��\n");

		System.out.println(sb);
		System.out.println("��ȣ ���� : ");
		int select = sc.nextInt();

		return select;
	}

	public static void main(String[] args) {
		ScoreBiz biz = new ScoreBizImpl();
		int select = 0;

		while (select != 9) {
			select = getMenu();

			switch (select) {

			case 1:
				List<ScoreDto> list = biz.selectList();
				for (ScoreDto dto : list) {
					System.out.println(dto);
				}
				
				break;
				
			case 2:
				System.out.println("������ �̸��� �Է��ϼ��� :");
				String selectName = sc.next();

				ScoreDto selectOne = biz.selectOne(selectName);
				System.out.println(selectOne);

				break;
				
			case 3:
				// �߰�
				// �̸� �Է¹ް� �̹� �̸��� ������ "�̸��� �����մϴ�." -> getMenu��
				// ������ �Է¹޴´�.
				System.out.println("�̸��� �Է��ϼ��� : ");
				String inputName = sc.next();

				ScoreDto tmp = biz.selectOne(inputName);
				if (tmp != null) {
					System.out.println("�̸��� �����մϴ�.");

				} else {
					System.out.println("���� : ");
					int insertKor = sc.nextInt();
					System.out.println("���� : ");
					int insertEng = sc.nextInt();
					System.out.println("���� : ");
					int insertMath = sc.nextInt();
					ScoreDto insertDto = new ScoreDto(inputName, insertKor, insertEng, insertMath, 0, 0, null);

					int insertRes = biz.insert(insertDto);
					if (insertRes > 0) {
						System.out.println("�߰��Ϸ�");
					} else {
						System.out.println("�߰�����");
					}
				}
				
				break;

			case 4:
				System.out.println("������ �̸��� �Է��ϼ��� :");
				String updateName = sc.next();
				// �ߺ�Ȯ���ϱ� �غ���

				System.out.println("���� : ");
				int updateKor = sc.nextInt();
				System.out.println("���� : ");
				int updateEng = sc.nextInt();
				System.out.println("���� : ");
				int updateMath = sc.nextInt();

				ScoreDto updateDto = new ScoreDto(updateName, updateKor, updateEng, updateMath, 0, 0, null);

				int updateRes = biz.update(updateDto);
				if (updateRes > 0) {
					System.out.println("���� �Ϸ�");
				} else {
					System.out.println("���� ����");
				}
				
				break;

			case 5:
				System.out.println("������ �̸��� �Է��ϼ��� : ");
				String deleteName = sc.next();

				int deleteRes = biz.delete(deleteName);
				if (deleteRes > 0) {
					System.out.println("���� ����");
				} else {
					System.out.println("���� ����");
				}
				
				break;
				
			case 6:
				// 1��
				System.out.println("1�� ���");
				System.out.println(biz.topNSelect(1));
				break;
				
			case 7:
				// 2��
				System.out.println("2�� ���");
				System.out.println(biz.topNSelect(2));
				break;
				
			case 8:
				// 3��
				System.out.println("3�� ���");
				System.out.println(biz.topNSelect(3));
				break;
				
			case 9:
				System.out.println("����");
				break;
			}
		}
	}
}
