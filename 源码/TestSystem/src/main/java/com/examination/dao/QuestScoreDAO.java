package com.examination.dao;

import java.util.List;

import com.examination.entity.AnswerSheet;
import com.examination.entity.Score;
import com.examination.entity.User;
import com.examination.entity.WrongQuest;
/**
 * 查询成绩的接口，主要由三个方法
 * 1.查询考试成绩
 * 2.添加考试成绩
 * 3.添加考生的答案
 * 4.查询考生的答案
 * @author 
 *
 */
public interface QuestScoreDAO {
	/**
	 * 查询考生的成绩
	 * @param sno
	 * @return list集合 类型：成绩（Score）
	 */
	public List<Score> findBySno(Integer sno);
	/**
	 * 添加成绩
	 * @param user
	 * @param score int 型 分数 
	 * @param TQ 题目类型（一个题目的对象包含一个题目的所有信息）
	 * @return boolean 是否添加成功 true 添加成功 false添加失败
	 */
	public boolean addScore(User user,int score,String examName);
	/**
	 * 添加考生的答案
	 * @param as 一个答案类型的对象（包含一个考生的登录名，考生的答案，以及所做考题的类型）
	 * @param code 考生的登录名
	 * @return boolean 是否添加成功 true 添加成功 false添加失败
	 */
	public boolean addAnswerSheet(AnswerSheet as,String code);
	/**
	 * 查询考生的历史答案
	 * @param code 考生的登录名
	 * @return 一个list集合 集合中存储了一个考生的所有的考试结果是一个封装好的对象（AnswerSheet）
	 */
	public List<AnswerSheet> findByCode(String code);
	/**
	 * 
	 */
	public List<WrongQuest> findWrongQuest(Float rate,String usercode);
}
