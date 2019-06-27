package com.biz.jdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biz.jdbc.config.DBConnection;
import com.biz.jdbc.model.StudentVO;

public class StdServiceImp_01 implements StdService {
	
	private Connection dbCon = null;
//	private String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	private List<StudentVO> stdList;
	
//	private String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	private String userName = "user5";
//	private String password = "1234";
	
	public StdServiceImp_01() {
		/*
		 * 데이터 리스트를 만들어서 외부로 전달하기 위해 사용하는
		 * stdList를 생성자에서 초기화를 하고 계속 사용을 하면
		 * selectAll() 실행할때마다 리스트가 계속 쌓이게 된다.
		 * 리스틀 초기화 하는 코드는
		 * 리스트를 만들기 직전에 위치 해야한다.
		 */
		this.dbCon = DBConnection.getDBConnection();
		
	}
	
	// dbConnection은 외부에서 실행하지 못하도록 private로 선언한다
	// dbConnection이 자주 실행되는 것은 Driver를 계속 on load 시키고
	// 통로를 새로 설정하는과정이 반복되어 문제를 일으킬 수 있기 때문이다.
//	private void dbConnection() {
//		
//		try {
//			Class.forName(jdbcDriver);
//			dbCon = DriverManager.getConnection(url,userName,password);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			// e.printStackTrace();
//		}
//	}
	
	@Override
	public List<StudentVO> selectAll() {
		// TODO 여기는 전체 리스트를 SELECT하는 method
		String sql = " SELECT * FROM tlb_student ";
		
		//String으로 된 sql문장을 DBMS방식의 코드로 변환하여 DBMS에 전달
		PreparedStatement ps = null;
		try {
			// sql문을 DBMS 코드로 변환하여 잠시보관
			ps = this.dbCon.prepareStatement(sql);
			//query를 실행하고 DBMS가 보낸 결과를 ResultSet 데이터 구조로 바꾸어
			//return을 한다
			
			//ResultSet구조의 객체를 선언하여 데이터를 수신한다.
			ResultSet rs = ps.executeQuery();
			/*
			 * ResultSet : DBMS가 보낸 데이터를 배열형태로 보관을하고\
			 * next() 메서드를 실행하면 한줄씩 데이터를 읽어 온다
			 * 단, 읽는 방향은 일방통행이다
			 * 처음부터~끝방향으로
			 */
			// if(rs.next()) System.out.println("데이터가 있다");
			stdList = new ArrayList<StudentVO>();
			while(rs.next()) {
				StudentVO vo = new StudentVO();
				//old 코드
				vo.setSt_no(rs.getString(1));
				vo.setSt_name(rs.getString(2));
				vo.setSt_addr(rs.getString(3));
				vo.setSt_grade(rs.getInt(4));
				vo.setSt_height(rs.getInt(5));
				vo.setSt_weight(rs.getInt(6));
				vo.setSt_nick(rs.getString(7));
				vo.setSt_nick_rem(rs.getString(8));
				vo.setSt_dept_no(rs.getString(9));
				
				vo.setSt_no(rs.getString("st_no"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setSt_addr(rs.getString("st_addr"));
				vo.setSt_grade(rs.getInt("st_grade"));
				vo.setSt_height(rs.getInt("st_height"));
				vo.setSt_weight(rs.getInt("st_weight"));
				vo.setSt_nick(rs.getString("st_nick"));
				vo.setSt_nick_rem(rs.getString("st_nick_rem"));
				vo.setSt_dept_no(rs.getString("st_dept_no"));
				
				stdList.add(vo);
			}
			return stdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public StudentVO findByNum(String st_num) {
		// TODO Auto-generated method stub
		
		//sql문을 작성할때 "가 시작되는 곳과 끝나는 곳에서 스페이스바
		String sql = " SELECT * FROM tlb_student ";
		sql += " WHERE st_no = " + st_num;
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
				StudentVO vo = new StudentVO();
				vo.setSt_no(rs.getString("st_no"));
				vo.setSt_name(rs.getString("st_name"));
				vo.setSt_addr(rs.getString("st_addr"));
				vo.setSt_grade(rs.getInt("st_grade"));
				vo.setSt_height(rs.getInt("st_height"));
				vo.setSt_weight(rs.getInt("st_weight"));
				vo.setSt_nick(rs.getString("st_nick"));
				vo.setSt_nick_rem(rs.getString("st_nick_rem"));
				vo.setSt_dept_no(rs.getString("st_dept_no"));
				return vo;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(StudentVO vo) {
		// TODO 학생정보를 vo에 받아 DB에 INSERT수행
		String sql = " INSERT INTO tlb_student ( ";
		sql += " st_no, ";		//1
		sql += " st_name, ";	//2
		sql += " st_addr, ";	//3
		sql += " st_grade, ";	//4
		sql += " st_height, ";	//5
		sql += " st_weight, ";	//6
		sql += " st_nick, ";	//7
		sql += " st_nick_rem, ";//8
		sql += " st_dept_no) ";	//9
		sql += " VALUES(?,?,?,?,?,?,?,?,?) ";
		
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ps.setString(1, vo.getSt_no());
			ps.setString(2, vo.getSt_name());
			ps.setString(3, vo.getSt_addr());
			ps.setInt(4, vo.getSt_grade());
			ps.setInt(5, vo.getSt_height());
			ps.setInt(6, vo.getSt_weight());
			ps.setString(7, vo.getSt_nick());
			ps.setString(8, vo.getSt_nick_rem());
			ps.setString(9, vo.getSt_dept_no());
			
			ps.executeUpdate();
			System.out.println("데이터 INSERT 성공");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(StudentVO vo) {
		// TODO vo에 값을 받아서 기존 데이터를 업데이트
		String sql = " UPDATE tlb_student SET ";
		sql += " ST_NAME = ?, ";
		sql += " ST_ADDR = ?, ";
		sql += " ST_GRADE = ?, ";
		sql += " ST_HEIGHT = ?, ";
		sql += " ST_WEIGHT = ?, ";
		sql += " ST_NICK = ?, ";
		sql += " ST_NICK_REM = ?, ";
		sql += " ST_DEPT_NO = ? ";
		sql += " WHERE st_no = ? ";
		
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ps.setString(9, vo.getSt_no());
			ps.setString(1, vo.getSt_name());
			ps.setString(2, vo.getSt_addr());
			ps.setInt(3, vo.getSt_grade());
			ps.setInt(4, vo.getSt_height());
			ps.setInt(5, vo.getSt_weight());
			ps.setString(6, vo.getSt_nick());
			ps.setString(7, vo.getSt_nick_rem());
			ps.setString(8, vo.getSt_dept_no());
			
			ps.executeUpdate();
			System.out.println("데이터 UPDATE 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	@Override
	public void delete(String st_num) {
		// TODO 여기는 한개의 레코드를 삭제하는 method
		String sql = " DELETE FROM tlb_student ";
		sql += " WHERE st_no = " + st_num;
		
		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			
			int ret = ps.executeUpdate();
			
			//삭제가 정상적으로 이루어 졌는지 알아보는 방법으로
			// 아래 2가지 코드가 있지만 
			// DBMS 서버와 통신하는과정에서 
			// 레코드 정상적으로 삭제되면 반드시 0이상의 값을
			// return해서 ret값에 담아 주지만
			
			// 레코드 삭제가 이루어지지 않았을경우
			// 정말 삭제할 레코드가 없는 경우도 있고
			// 이경우는 0을 return할 것이다
			
			//하지만 어떤 이유로 레코드가 있음에도삭제가 이루어지지 않았을 경우 
			//0 미만의 값을 return하는 경우도 있다
			// 이런경우 2번의 방법에서는 정상적으로 삭제가 이루어졋다는 메시지를 보이게 된다.
			// 따라서 1번방법이 안전한 코드 작성법
			
			//1번검증방법
			if(ret>0)System.out.println("데이터 DELETE 성공");
			else System.out.println("삭제할 데이터가 없음");
			
			//2번검증방법
//			if(ret == 0 )System.out.println("삭제할 데이터가 없음");
//			else System.out.println("데이터 DELETE 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String makeStNo() {
		String sql = " SELECT LPAD(MAX(st_no)+1,3,'0') ";
		sql += " FROM tlb_student " ;

		PreparedStatement ps = null;
		try {
			ps = this.dbCon.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				String strNum = rs.getString(1);
				return strNum;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
	}
	
}
