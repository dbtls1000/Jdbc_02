package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.StdService;
import com.biz.jdbc.service.StdServiceImp_01;

public class StdExec_10 {
	/*
	 * 키보드로
	 * 학생정보를 입력받아서
	 * (학번,이름,학년,학과)
	 * 계속해서 insert를 수행하는 코드작성
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StdService ss = new StdServiceImp_01();
		
		while(true) {
			System.out.println("================================");
			// StdService 인터페이스에 미쳐 선언하지 못한
			// makeStNo method를
			// StdServiceImp_01 클래스에 생성하고
			//사용을 하려고 한다
			
			//이럴때는 다소 복잡하지만 ss의 객체를
			//StdServiceImp_01로 cascading(형변환)을 실행해서
			//method를 호출해야 한다.
			String strNo = ((StdServiceImp_01)ss).makeStNo();
			System.out.println(strNo + " 학생 정보 등록 ");
			System.out.println("================================");
			
			System.out.print("이름 >>(종료 : -E)");
			String strName = scan.nextLine();
			if(strName.equals("-E")) break;
			System.out.print("학년 >>");
			String strGrade = scan.nextLine();
			int intGrade = Integer.valueOf(strGrade);
			System.out.print("학과 >>");
			String strDept = scan.nextLine();
			StudentVO vo = new StudentVO();
			vo.setSt_no(strNo);
			vo.setSt_name(strName);
			vo.setSt_grade(intGrade);
			vo.setSt_dept_no(strDept);
			
			ss.insert(vo);
			
			
		}
		
	}
}
