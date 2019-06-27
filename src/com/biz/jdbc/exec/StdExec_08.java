package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.StdService;
import com.biz.jdbc.service.StdServiceImp_01;

public class StdExec_08 {
	/*
	 * 키보드로
	 * 학번을 입력받고 해당하는 학번의 학생정보를 보여준 후
	 * 다시 키보드에서 주소를 입력 받아서
	 * 학생정보를 업데이트
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StdService ss = new StdServiceImp_01();
		
		while(true) {
			
			System.out.println("==============================");
			System.out.print("학번 입력 > (종료 : --END)");
			String strNo = scan.nextLine();
			if(strNo.equals("--END")) break;
			StudentVO vo = ss.findByNum(strNo);
			if(vo == null) {
				System.out.println("찾는 학생이 없음");
				continue;
			}
			System.out.println(vo.toString());
			System.out.println("==============================");
			System.out.print("주소 입력 >");
			String strAddr = scan.nextLine();
			// 주소를 입력하지 않으면 업데이트하지않고 처음으로 돌아감
			if(strAddr.isEmpty()) continue;
			vo.setSt_addr(strAddr);
				
			ss.update(vo);
			
			
		}
		
		
	}
}
