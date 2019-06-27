package com.biz.jdbc.service;

import java.util.List;

import com.biz.jdbc.model.StudentVO;

/*
 * CRUD구현
 * 1.DB Connection을 설정하기
 * 2.Select 구현
 * 3.INSERT 구현
 * 4. UPDATE,DELETE구현
 */
public interface StdService {

	// 전체 리스트를 가져올 method
	public List<StudentVO> selectAll();

	// 학번을 기준으로 한 학생의 정보를 가져올 method
	// 학번을 매개변수로 전달하고 학번을 where로 하여 select 수행한후 
	// 한 학생의 정보를 가져와서 VO에 담아
	// 요청한 곳에 return
	public StudentVO findByNum(String st_num);

	// 학생정보를 DB에 INSERT할 method
	// 추가하고자하는 학생의 정보를 VO에 담아서 매개변수로 전달해주고
	// INSERT를 수행하도록 한다.
	public void insert(StudentVO vo);

	// 학생정보를 UPDATE할 method
	// 1.학생정보를 조회하고 VO에 받은정도
	// 2. 수정할 칼럼이 있으면 그 칼럼의 값만 변경을하고
	// 3. 나머지 값은 그대로 유지하여
	// 4. VO에 담겨있는 값을 매개변수로 전달하여 업데이트한다.
	public void update(StudentVO vo);

	// 학생정보를 DELETE할 method
	// 삭제할때는 학번하나만 매개변수로 전달하고
	// DELETE한다.
	public void delete(String st_num);

}
