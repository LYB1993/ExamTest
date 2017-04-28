package com.examination.entity;

import java.sql.Date;
/**
 * 用户的成绩对应的实体类型包含
 * 1.SujectId
 * 2.SujectName ：考试的类型，即belong="XXXXXXXX";
 * 3.Time：完成考试的时间
 * 4.Sno：考生的学号
 * 5.Sname：考生的姓名
 * 6.Score：考生的成绩
 * @author
 *
 */
public class Score {
	private Integer SujectId;
	private String SujectName;
	private Date Time;
	private Integer Sno;
	private String Sname;
	private Integer Score;

	public Score(Integer sujectId, String sujectName, Date time, Integer sno, String sname, Integer score) {
		super();
		SujectId = sujectId;
		SujectName = sujectName;
		Time = time;
		Sno = sno;
		Sname = sname;
		Score = score;
	}
	public Score() {
		super();
	}
	public Integer getSujectId() {
		return SujectId;
	}
	public void setSujectId(Integer sujectId) {
		SujectId = sujectId;
	}
	public String getSujectName() {
		return SujectName;
	}
	public void setSujectName(String sujectName) {
		SujectName = sujectName;
	}
	public Date getTime() {
		return Time;
	}
	public void setTime(Date time) {
		Time = time;
	}
	public Integer getSno() {
		return Sno;
	}
	public void setSno(Integer sno) {
		Sno = sno;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public Integer getScore() {
		return Score;
	}
	public void setScore(Integer score) {
		Score = score;
	}

	@Override
	public String toString() {
		return "Score [SujectId=" + SujectId + ", SujectName=" + SujectName + ", Time=" + Time + ", Sno=" + Sno
				+ ", Sname=" + Sname + ", Score=" + Score + "]";
	}
	
	
}
