package com.examination.dao;

import java.util.List;

import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
/**
 * 查询题目的接口
 * 1.通过题目的所属类型来查询题目（例如 belong="2016会计资格考试"）
 * 2.通过题目的id和题目的所属类型来查询题目
 * @author 
 *
 */
public interface QuestDAO {
	/**
	 * 通过题目的所属类型来查询题目（例如 belong="2016会计资格考试"）
	 * @param Group 题目的所属类型
	 * @return list集合，包含了一个类型的所有题目的集合，list中保存的是（TestQuestions类型）
	 */
	public List<TestQuestions> findByGroup(String Group);
	/**
	 * 通过题目的id和题目的所属类型来查询题目
	 * @param id 题目的id
	 * @param belong 题目所属类型
	 * @return 返回一个题目类型TestQuestions类型
	 */
	public TestQuestions findByIdAndBelong(int id,String belong);
	/**
	 * 随机生成题目
	 * @return
	 */
	public boolean randomlyGenerated(ExamPage exampage);
	/**
	 * 通过试卷名称获取试卷
	 * @param examName
	 * @return
	 */
	public List<TestQuestions> findByExamName(String examName);
	/**
	 * 查询全部的题目
	 * @return
	 */
	public List<TestQuestions> findAllquest();

}
