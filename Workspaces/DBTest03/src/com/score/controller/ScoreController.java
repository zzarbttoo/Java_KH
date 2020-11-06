package com.score.controller;

import java.util.List;
import java.util.Scanner;

import com.score.biz.ScoreBiz;
import com.score.dto.ScoreDto;

public class ScoreController {

	private static Scanner sc = new Scanner(System.in);

	// view 역할 할거야
	public static int getMenu() {

		StringBuffer sb = new StringBuffer();
		sb.append("*************\n").append("1. 전체 출력 *\n").append("2. 선택 출력 *\n").append("3. 추      가  *\n")
				.append("4. 수      정  *\n").append("5. 삭      제  *\n").append("6. 1등 출력 *\n").append("7. 2등 출력 *\n")
				.append("8. 3등 출력 *\n").append("9. 종      료 *\n").append("************");

		System.out.println(sb);
		System.out.println("input select : ");
		int select = sc.nextInt();
		return select;

	}

	public static void main(String[] args) {

		int select = 0;
		ScoreBiz biz = new ScoreBiz();
		int res = 0;

		while (select != 9) {

			select = getMenu();
			switch (select) {

			case 1:
				System.out.println("---전체 출력------");
				List<ScoreDto> list = biz.selectList();

				for (ScoreDto dto : list) {
					System.out.println(dto);
				}

				break;
			case 2:
				System.out.println("---선택 출력------");

				System.out.println("출력할 이름 :");
				String selectName = sc.next();

				ScoreDto selectDto = new ScoreDto();
				selectDto = biz.selectOne(selectName);
				System.out.println(selectDto);

				break;

			case 3:
				System.out.println("---추      가------");

				System.out.println("추가 할 이름");
				String inputName = sc.next();
				System.out.println("국어 성적: ");
				int inputKor = sc.nextInt();
				System.out.println("영어 성적: ");
				int inputEng = sc.nextInt();
				System.out.println("수학 성적: ");
				int inputMath = sc.nextInt();

				ScoreDto inputDto = new ScoreDto(inputName, inputKor, inputEng, inputMath);

				res = biz.insert(inputDto);
				if (res > 0) {

					System.out.println("입력 성공");
				} else {

					System.out.println("입력 실패");
				}
				break;
			case 4:
				System.out.println("---수      정------");

				System.out.println("수정할 이름 : ");
				String updateName = sc.next();

				System.out.println("수정할 국어점수 : ");
				int updateKor = sc.nextInt();

				System.out.println("수정할 영어점수 :");
				int updateEng = sc.nextInt();

				System.out.println("수정할 수학점수");
				int updateMath = sc.nextInt();

				ScoreDto updateDto = new ScoreDto(updateName, updateKor, updateEng, updateMath);

				res = biz.update(updateDto);
				if (res > 0) {
					System.out.println("수정 성공");

				} else {
					System.out.println("수정 실패");
				}
				break;
			case 5:
				System.out.println("---삭      제------");

				System.out.println("삭제할 이름 : ");
				String delName = sc.next();
				res = biz.delete(delName);
				break;
			case 6:
				System.out.println("---1등 출력------");

//				ScoreDto firstDto = new ScoreDto();
//				firstDto = biz.selectFirst();
//				System.out.println("일 등");
//				System.out.println(firstDto);

				ScoreDto first = biz.topN(1);
				System.out.println(first);
//				

				break;
			case 7:
				System.out.println("---2등 출력------");
				ScoreDto second = biz.topN(2);
				System.out.println(second);
//				
//				ScoreDto secondDto = new ScoreDto();
//				secondDto = biz.selectSecond();
//				System.out.println("이 등");
//				System.out.println(secondDto);
//				
				break;
			case 8:
				System.out.println("---3등 출력------");
				ScoreDto third = biz.topN(3);
				System.out.println(third);
//				

//				
//				ScoreDto thirdDto = new ScoreDto();
//				thirdDto = biz.selectThird();
//				System.out.println("삼 등");
//				System.out.println(thirdDto);
//				
				break;
			case 9:
				System.out.println("---종       료------");
				System.out.println("프로그램을 종료합니다...");
				break;

			}

		}

	}

}
