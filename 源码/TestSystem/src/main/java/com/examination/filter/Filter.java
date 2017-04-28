package com.examination.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 用于是实现session实现功能的类
 * 主要判断用户是否登陆，防止用户直接访问出登陆界面以外的其它界面
 * 如果用户直接登陆其它界面，这时session为null，系统会自动重定向到登陆界面
 * @author 
 *
 */
public class Filter implements javax.servlet.Filter {
	public void destroy() {
	}
	/**
	 * 
	 */
	public void doFilter(ServletRequest srequest, ServletResponse sreponse, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse reponse = (HttpServletResponse) sreponse;
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
				//System.out.println("user session is null");
				request.getRequestDispatcher("/toLogin.do").forward(request, reponse);	
		}else{
			arg2.doFilter(request, reponse);
		}
		

	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
