package com.examination.entity;
/**
 * 题目对应的实体类型
 * 1.QuestId：题目的编号
 * 2.QuestScore：题目的分值
 * 3.QuestSubjct：题目内容
 * 4.QuestA：A答案内容
 * 5.QuestB：B答案内容
 * 6.QuestC：C答案内容
 * 7.QuestD：D答案内容
 * 8.QuestBelongTo：题目所属类型
 * 9.QuestAnswer：题目的正确答案
 * @author
 *
 */
public class TestQuestions {
	private Integer QuestId;
	private Integer QuestScore;
	private String QuestSubjct;
	private String QuestA;
	private String QuestB;
	private String QuestC;
	private String QuestD;
	private String QuestBelongTo;
	private String QuestAnswer;
	
	public TestQuestions( Integer questScore, String questSubjct, String questA, String questB,
			String questC, String questD, String questBelongTo, String questAnswer) {
		super();
		QuestScore = questScore;
		QuestSubjct = questSubjct;
		QuestA = questA;
		QuestB = questB;
		QuestC = questC;
		QuestD = questD;
		QuestBelongTo = questBelongTo;
		QuestAnswer = questAnswer;
	}
	
	public TestQuestions() {
		super();
	}

	public String getQuestAnswer() {
		return QuestAnswer;
	}
	public void setQuestAnswer(String questAnswer) {
		QuestAnswer = questAnswer;
	}
	public String getQuestBelongTo() {
		return QuestBelongTo;
	}
	public void setQuestBelongTo(String questBelongTo) {
		QuestBelongTo = questBelongTo;
	}
	public Integer getQuestId() {
		return QuestId;
	}
	public void setQuestId(Integer questId) {
		QuestId = questId;
	}
	public Integer getQuestScore() {
		return QuestScore;
	}
	public void setQuestScore(Integer questScore) {
		QuestScore = questScore;
	}
	public String getQuestSubjct() {
		return QuestSubjct;
	}
	public void setQuestSubjct(String questSubjct) {
		QuestSubjct = questSubjct;
	}
	public String getQuestA() {
		return QuestA;
	}
	public void setQuestA(String questA) {
		QuestA = questA;
	}
	public String getQuestB() {
		return QuestB;
	}
	public void setQuestB(String questB) {
		QuestB = questB;
	}
	public String getQuestC() {
		return QuestC;
	}
	public void setQuestC(String questC) {
		QuestC = questC;
	}
	public String getQuestD() {
		return QuestD;
	}
	public void setQuestD(String questD) {
		QuestD = questD;
	}
	@Override
	public String toString() {
		return "TestQuestions [QuestId=" + QuestId + ", QuestScore=" + QuestScore + ", QuestSubjct=" + QuestSubjct
				+ ", QuestA=" + QuestA + ", QuestB=" + QuestB + ", QuestC=" + QuestC + ", QuestD=" + QuestD
				+ ", QuestBelongTo=" + QuestBelongTo + ", QuestAnswer=" + QuestAnswer + "]";
	}
	
}
