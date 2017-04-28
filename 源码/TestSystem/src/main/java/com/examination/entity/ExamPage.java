package com.examination.entity;
/**
 * 这个类是试卷类型，声明了试卷的种类
 * 题目的数量，难度
 * @author LqY
 *
 */
public class ExamPage {
	private String examName;//试卷名称
	private Integer examChoiceNum;//选择题目数量
	private Integer ChoiceScore;
	private Integer examjdNum;//简答题数量
	private Integer jdScore;
	private Integer examDif;//难度等级
	private Integer examTime;//考试时间
	public long examId;//试卷唯一ID
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public Integer getExamChoiceNum() {
		return examChoiceNum;
	}
	public void setExamChoiceNum(Integer examChoiceNum) {
		this.examChoiceNum = examChoiceNum;
	}
	public Integer getChoiceScore() {
		return ChoiceScore;
	}
	public void setChoiceScore(Integer choiceScore) {
		ChoiceScore = choiceScore;
	}
	public Integer getExamjdNum() {
		return examjdNum;
	}
	public void setExamjdNum(Integer examjdNum) {
		this.examjdNum = examjdNum;
	}
	public Integer getJdScore() {
		return jdScore;
	}
	public void setJdScore(Integer jdScore) {
		this.jdScore = jdScore;
	}
	public Integer getExamDif() {
		return examDif;
	}
	public void setExamDif(Integer examDif) {
		this.examDif = examDif;
	}
	public Integer getExamTime() {
		return examTime;
	}
	public void setExamTime(Integer examTime) {
		this.examTime = examTime;
	}
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
	public ExamPage(String examName, Integer examChoiceNum, Integer choiceScore, Integer examjdNum, Integer jdScore,
			Integer examDif, Integer examTime, long examId) {
		super();
		this.examName = examName;
		this.examChoiceNum = examChoiceNum;
		ChoiceScore = choiceScore;
		this.examjdNum = examjdNum;
		this.jdScore = jdScore;
		this.examDif = examDif;
		this.examTime = examTime;
		this.examId = examId;
	}
	public ExamPage() {
		super();
	}
	@Override
	public String toString() {
		return "ExamPage [examName=" + examName + ", examChoiceNum=" + examChoiceNum + ", ChoiceScore=" + ChoiceScore
				+ ", examjdNum=" + examjdNum + ", jdScore=" + jdScore + ", examDif=" + examDif + ", examTime="
				+ examTime + ", examId=" + examId + "]";
	}
	
	
}
