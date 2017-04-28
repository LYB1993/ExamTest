package com.examination.dao;

import java.util.List;
/**
 * 接口，两个方法
 * 1.查询数据库中所有的题目类型，返回一个保存着所有题目类型的list集合
 * 2.通过题目的类型去删除题目返回 boolean类型
 * @author 
 *
 */
public interface BelongDAO {
	/**
	 * 方法停用
	 * 查询数据库中所有的题目类型，返回一个保存着所有题目类型的list集合
	 * @return 返回一个list集合，里面保存的是string类型 
	 */
	public List<String> selectBelong();
	/**
	 * 方法停用
	 * 通过题目的类型去删除题目返回 boolean类型
	 * @param deletebelong
	 * @return boolean类型，true删除成功，false删除失败
	 */
	public boolean delete(String deletebelong);
	
	/**
	 * 新方法 查询考试的科目
	 * 查询数据库中所有的题目类型，返回一个保存着所有考卷名称的list集合
	 */
	public List<String> selectExamPage();
	/**
	 * 通过试卷名称去删除试卷返回 boolean类型
	 * @param exampageName 考卷名称
	 * @return boolean类型，true删除成功，false删除失败
	 */
	public boolean deleteByExamPageName(String exampageName);
}
