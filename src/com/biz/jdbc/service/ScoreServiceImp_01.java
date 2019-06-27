package com.biz.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.ScoreVO;

public class ScoreServiceImp_01 implements ScoreService {
	private Connection dbCon = null;
	List<ScoreVO> scList;
//	private String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	private String userName = "user5";
//	private String password = "1234";
	
	
	public ScoreServiceImp_01() {
		this.dbCon = DBConnection.getDBConnection();
	}
	
//	private void dbConnection() {
//		try {
//			Class.forName(jdbcDriver);
//			Connection dbCon = DriverManager.getConnection(url,userName,password);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	@Override
	public List<ScoreVO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			scList = new ArrayList<ScoreVO>();
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setSc_seq(rs.getLong("sc_seq"));
				vo.setSc_date(rs.getString("sc_date"));
				vo.setSc_no(rs.getString("sc_no"));
				vo.setSc_score(rs.getInt("sc_score"));
				scList.add(vo);
			}
			return scList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ScoreVO findById(long sc_seq) {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_seq = " + sc_seq;
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setSc_seq(rs.getLong(1));
				vo.setSc_date(rs.getString(2));
				vo.setSc_no(rs.getString(3));
				vo.setSc_score(rs.getInt(5));
				return vo;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insert(ScoreVO vo) {
		// TODO 데이터 추가
		String sql = " INSERT INTO tbl_score ( ";
		sql += " SC_SEQ, ";
		sql += " SC_DATE, ";
		sql += " SC_NO, ";
		sql += " SC_SUBJECT, ";
		sql += " SC_SCORE) ";
		sql += " VALUES( SEQ_score.NEXTVAL,?,?,?,?) ";
		return 0;
	}

	@Override
	public int update(ScoreVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(long sc_seq) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ScoreVO> findByNum(String st_no) {
		String sql = " SELECT * FROM tbl_score ";
		sql += " WHERE sc_no = " + st_no ;
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			scList = new ArrayList<ScoreVO>();
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setSc_seq(rs.getLong("sc_seq"));
				vo.setSc_date(rs.getString("sc_date"));
				vo.setSc_no(rs.getString("sc_no"));
				vo.setSc_subject(rs.getString("sc_subject"));
				vo.setSc_score(rs.getInt("sc_score"));
				scList.add(vo);
			}
			return scList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub
		
	}

}
