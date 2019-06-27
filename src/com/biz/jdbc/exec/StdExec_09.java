package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.StdService;
import com.biz.jdbc.service.StdServiceImp_01;

public class StdExec_09 {
	/*
	 * 키보드로
	 * 학생정보를 입력받아서
	 * (학번,이름,학년,학과)
	 * 계속해서 insert를 수행하는 코드작성
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StdService ss = new StdServiceImp_01();
		
		StudentVO vo = new StudentVO();
		while(true) {
			
			System.out.print("학번 입력 >> (종료 : --END)");
			String strNo = scan.nextLine();
			if(strNo.equals("--END")) break;
			System.out.print("이름 입력 >>");
			String strName = scan.nextLine();
			System.out.print("학년 입력 >>");
			String strGrade = scan.nextLine();
			int intGrade = Integer.valueOf(strGrade);
			System.out.print("학과 입력 >>");
			String strDept = scan.nextLine();
			
			vo.setSt_no(strNo);
			vo.setSt_name(strName);
			vo.setSt_grade(intGrade);
			vo.setSt_dept_no(strDept);
			
			ss.insert(vo);
			
			
		}
		System.out.println("종료합니다");
		
	}
}
