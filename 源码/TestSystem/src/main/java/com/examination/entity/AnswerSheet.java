package com.examination.entity;
/**
 * 用户的答案类型的实体类包含
 * 1.User_code 用户名
 * 2.Answerstr 用户选择题的答案
 * 3.Other 用户其它题目的答案
 * 4.用户所做的题目的类型
 * @author
 *
 */
public class AnswerSheet {
	private String User_code;
	private	String Answerstr;
	private String Other;
	private String belong;

	public AnswerSheet(String user_code, String answerstr, String other, String belong) {
		super();
		User_code = user_code;
		Answerstr = answerstr;
		Other = other;
		this.belong = belong;
	}
	public AnswerSheet() {
		super();
	}
	public String getUser_code() {
		return User_code;
	}
	public void setUser_code(String user_code) {
		User_code = user_code;
	}
	public String getBelong() {
		return belong;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	public String getAnswerstr() {
		return Answerstr;
	}
	public void setAnswerstr(String answerstr) {
		Answerstr = answerstr;
	}
	public String getOther() {
		return Other;
	}
	public void setOther(String other) {
		Other = other;
	}

	
	@Override
	public String toString() {
		return "AnswerSheet [User_code=" + User_code + ", Answerstr=" + Answerstr + ", Other=" + Other + ", belong="
				+ belong + "]";
	}
	
}
