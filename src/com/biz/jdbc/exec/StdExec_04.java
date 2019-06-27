package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.StdService;
import com.biz.jdbc.service.StdServiceImp_01;

public class StdExec_04 {
	public static void main(String[] args) {

		StdService ss = new StdServiceImp_01();
		
		StudentVO stdVO = new StudentVO();
		stdVO.setSt_no("101");
		stdVO.setSt_name("이몽룡");
		stdVO.setSt_grade(3);
		stdVO.setSt_dept_no("005");
		
		ss.insert(stdVO);

	}
}
