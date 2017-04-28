package com.examination.service;
/**
 * 用户登陆信息验证的类
 * 
 * 通过登陆时传递过来的用户名和密码来判断
 * 如果错误给出相应的提示信息
 */
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.examination.dao.UserDAO;
import com.examination.entity.User;


@SuppressWarnings("restriction")
@Service("loginVerifiaction")
public class LoginVerifiactionImpl implements LoginVerifiaction {
	//注入userDao接口用来查询信息
	@Resource(name="userDAO")
	UserDAO userDao;
	
	public User verifiaction(String userCode, String pwd) {
		User user = null;
		user = userDao.findByUserCode(userCode);
		if(user == null){
			throw new ApplicationException("账号不存在!!");
		}
		if(!user.getUserPwd().equals(pwd)){
			throw new ApplicationException("密码错误!!");
		}
		return user;	
	}

}
