package com.examination.service;

import com.examination.entity.User;
/**
 * 用来处理异常信息的接口，例如用户名或者密码错误
 * 数据库发生异常，总之所有的系统运行异常都由这个接口中的
 * 方法去处理，然后返回相对应的结果
 * @author 
 *
 */
public interface LoginVerifiaction {
	public User verifiaction(String userCode,String pwd);
}
