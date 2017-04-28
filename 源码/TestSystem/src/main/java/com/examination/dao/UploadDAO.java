package com.examination.dao;

import java.io.File;
import java.util.List;

import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
/**
 * 上传试卷的接口主要由三个方法
 * 1.解析文本，返回一个list集合
 * 2.将文本内容写入数据库
 * 3.上传单独一道题目到数据库
 * @author LYB
 *
 */
public interface UploadDAO {
	/**
	 * .解析文本，返回一个list集合
	 * @param file 上传的文件
	 * @return list集合，包含了这个文本中的所有题目，list中保存的是（TestQuestions类型）
	 */
	public List<TestQuestions> readFile(File file);
	/**
	 * 将文本内容写入数据库
	 * @param questList 解析出来的文本集合
	 * @return boolean true 写入成功，false写入失败
	 */
	public boolean uploadMySQL(List<TestQuestions> questList);
	/**
	 * 上传单独一道题目到数据库
	 * @param testQuestions 界面传递的值封装为一个TestQuestions类型
	 * @return  boolean true 写入成功，false写入失败
	 */
	public boolean uploadOneQuestToMySQL(TestQuestions question);
	/**
	 * 根据界面输入的先要生成试卷的信息，自动生成试卷
	 * @param exampage
	 */
	public void addExamPage(ExamPage exampage);
	/**
	 * 通考试科目的名称找到试卷的实体类，是为了获取考试时间和各个题目的分数
	 * @param examName
	 * @return
	 */
	public ExamPage findByexamName(String examName);
}
