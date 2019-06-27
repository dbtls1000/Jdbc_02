package com.biz.jdbc.exec;

import java.util.List;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.service.ScoreService;
import com.biz.jdbc.service.ScoreServiceImp_01;

public class ScoreExec_01 {
	public static void main(String[] args) {
		ScoreService ss = new ScoreServiceImp_01();
		List<ScoreVO> scList = ss.findByNum("001");
		
		for(ScoreVO vo : scList) {
			System.out.println(vo);
		}
	}
}
