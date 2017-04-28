package com.examination.cotroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * 点击退出后调用此页
 *
 */
@Controller
public class LoginOutController {

	@ExceptionHandler
	public String LoginOutExeception(Exception ex){
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"   Exception is:"+ex.getMessage());
			return "error";
		}
		return "error";
	}
	//点击退出后，清空session的内容，然后重定向到登陆界面（login.jsp）
	@RequestMapping("loginout.do")
	public String loginout(HttpSession session){
		session.removeAttribute("user");
		System.out.println("clean session");
		return "redirect:toLogin.do";
	}
}
