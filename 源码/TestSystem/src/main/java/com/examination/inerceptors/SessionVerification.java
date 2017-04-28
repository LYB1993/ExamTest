package com.examination.inerceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用于是实现session实现功能的类
 * 主要判断用户是否登陆，防止用户直接访问出登陆界面以外的其它界面
 * 如果用户直接登陆其它界面，这时session为null，系统会自动重定向到登陆界面
 * @author 
 *
 */
public class SessionVerification implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)throws Exception {
		
		
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)throws Exception {
		
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		HttpSession session = request.getSession();
		if("/toregister.do".equals(request.getServletPath())||//用户的注册界面不需要session验证，跳过判断
			"/toregistersucceed.do".equals(request.getServletPath())||//用户 找回秘密界面不需要验证 ，跳过判断
			"/toFindpwd.do".equals(request.getServletPath())||//这里多说一句，也可以在配置文件中直接配置哪些请求不用验证，然后有spring框架去执行这些判断
			"/findpwd.do".equals(request.getServletPath())
				){
			return true;
		}
		//System.out.println(request.getServletPath());
		Object user = session.getAttribute("user");
		//System.out.println("session 验证 filter:"+user);
		if(user==null){
			response.sendRedirect("toLogin.do");
			return false;
		}
		return true;
	}

}
