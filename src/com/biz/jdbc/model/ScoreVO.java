package com.biz.jdbc.model;

public class ScoreVO {
	// sc_seq는 tbl_score의 PK로 설정되어 있고.
	// 많은 학생의 성적이 입력될 예정이다
	// 이럴때 sc_seq의 자동증가 성질에 의해서 값이 계속 증가
	// 이러한 칼럼일경우 언젠가 int형의 데이터 범위를 넘어갈 수도 있다
	// 그래서 이러한 칼럼은 int보다 long형으로 설정하는 것을 권장
	private long sc_seq;
	private String sc_date;
	private String sc_no;
	private String sc_subject;
	private int sc_score;
	public long getSc_seq() {
		return sc_seq;
	}
	public void setSc_seq(long sc_seq) {
		this.sc_seq = sc_seq;
	}
	public String getSc_date() {
		return sc_date;
	}
	public void setSc_date(String sc_date) {
		this.sc_date = sc_date;
	}
	public String getSc_no() {
		return sc_no;
	}
	public void setSc_no(String sc_no) {
		this.sc_no = sc_no;
	}
	public String getSc_subject() {
		return sc_subject;
	}
	public void setSc_subject(String sc_subject) {
		this.sc_subject = sc_subject;
	}
	public int getSc_score() {
		return sc_score;
	}
	public void setSc_score(int sc_score) {
		this.sc_score = sc_score;
	}
	@Override
	public String toString() {
		return "ScoreVO [sc_seq=" + sc_seq + ", sc_date=" + sc_date + ", sc_no=" + sc_no + ", sc_subject=" + sc_subject
				+ ", sc_score=" + sc_score + "]";
	}
	
}
