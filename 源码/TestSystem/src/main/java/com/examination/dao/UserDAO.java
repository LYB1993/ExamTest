package com.examination.dao;

import java.util.List;

import com.examination.entity.User;
/**
 * 这个接口提供的通过不同条件查询用户的方法
 * 1.通过登陆名查询用户
 * 2.添加用户
 * 3.用户信息编辑
 * 4.查询所有的用户信息（仅管理员可用）
 * 5.删除用户（仅管理员可用）
 * 6.找回密码
 * @author
 *
 */
public interface UserDAO {
	/**
	 * 通过登陆名查询用户
	 * @param userCode 永辉的登录名
	 * @return 发挥一个用户的实体类型（User）
	 */
	public User findByUserCode(String userCode);
	/**
	 * 添加一个用户
	 * @param user 一个用户的实体类型（User）数据由前台输入，在服务端封装
	 * @return boolean类型，true添加成功，false添加失败
	 */
	public boolean addUser(User user);
	/**
	 * 编辑用户信息
	 * @param user 一个用户的实体类型（User）数据由前台输入，在服务端，封装具体过程见类：#PersonalInformation
	 * @return boolean类型，true添加成功，false添加失败
	 */
	public boolean editUser(User user);
	/**
	 * 查询所有的用户
	 * @return 一个list集合
	 */
	public List<User> selectAll();
	/**
	 * 删除一个用户
	 * @param userCode 用户的登录名
	 * @return boolean类型，true删除成功，false删除失败
	 */
	public boolean delectUser(String userCode);
	/**
	 * 找回密码
	 * @param numcard 用户身份证号码 
	 * @return 一个string类型，即用户的密码
	 */ 
	public String findpwd(String numcard);
	/**
	 * 添加用户的考试次数，用开来判断用户的考试错误率
	 * @param userCode
	 * @return 考试次数
	 */
	public Integer addExamNum(String userCode);
	/**
	 * 用户上传图片修改图像
	 * @param path
	 * @return
	 */
	public boolean updateImagePath(String path,String usercode);
}
