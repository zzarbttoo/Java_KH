package com.member.controller;

import java.util.List;
import java.util.Scanner;

import com.member.biz.MemberBiz;
import com.member.dto.MemberDto;

//Controller :  화면 제어
//View : 화면 (우리는 아직 화면을 안배워서, console에 출력할거다 = View와 Controller가 섞여있다)
public class MemberController {

	
	private static Scanner sc = new Scanner(System.in);
	
	//view 역할 할거야
	public static int getMenu() {
		StringBuffer sb = new StringBuffer();
		sb.append("**********\n")
		.append("*1.전체 출력*\n")
		.append("*2.선택 출력*\n")
		.append("*3.추       가*\n")
		.append("*4.수       정*\n")
		.append("*5.삭       제*\n")
		.append("*6.종       료*\n")
		.append("***********\n");
		System.out.println(sb);
		System.out.println("input select : ");
		int select= sc.nextInt();
		return select;
	}
	
	public static void main(String[] args) {
		
		int select = 0;
		MemberBiz biz = new MemberBiz();
		int res = 0;
		
		while(select!=6) {
			select = getMenu();
			
			switch(select) {
			case 1:
				System.out.println("----전체 출력------");
				List<MemberDto> list = biz.selectList();
				
				for(MemberDto dto : list) {
					System.out.println(dto);
					
				}
				
				break;
			case 2:
				System.out.println("----선택 출력-------");
				
				System.out.println("선택할 번호 :");
				int selectNum = sc.nextInt();
				MemberDto selectDto = new MemberDto();

	
				selectDto = biz.selectOne(selectNum);
				System.out.println(selectDto);
				
				break;
			case 3:
				System.out.println("-----추     가 ------");
				
				System.out.println("추가 할 이름 : ");
				String inputName = sc.next();
				System.out.println("나이 : ");
				int inputAge = sc.nextInt();
				System.out.println("성별 [M/F] :");
				String inputGender = sc.next();
				System.out.println("지역 : ");
				String inputLocation = sc.next();
				System.out.println("직업 : ");
				String inputJob = sc.next();
				System.out.println("전화번호 : ");
				String inputTel = sc.next();
				System.out.println("이메일 : ");
				String inputEmail = sc.next();
				
				//Dto에 담아서 model에 전달해준다
				MemberDto inputDto = new MemberDto(0, inputName, inputAge, inputGender, 
						inputLocation , inputJob, inputTel, inputEmail);
				
				res = biz.insert(inputDto);
				
				if(res > 0) {
					System.out.println("입력 성공");
				}else {
					System.out.println("입력 실패");
				}
				
				
				break;
				
			case 4:
				System.out.println("-----수    정-------");
				
				System.out.println("수정할 번호 :");
				int updateNum = sc.nextInt();
				
				System.out.println("수정할 이름 :");
				String updateName = sc.next();
				
				MemberDto updateDto = new MemberDto();
				updateDto.setMno(updateNum);
				updateDto.setMname(updateName);
				
				System.out.println(res);
				res = biz.update(updateDto);
				System.out.println(res);
				
				
				if(res > 0) {
					System.out.println("수정 성공");
				}else {
					System.out.println("수정 실패");
				}
			
				break;
			case 5:
				System.out.println("-----삭    제--------");
				
				System.out.println("삭제할 번호 : ");
				int deleteNum = sc.nextInt();
				res = biz.delete(deleteNum);
			
				break;
			case 6:
				System.out.println("-----종     료--------");
				System.out.println("프로그램을 종료합니다...");
				
				//0은 정상 종료
				System.exit(0);
				
			
				
			}
			
		}
		
		
		
	}
}
