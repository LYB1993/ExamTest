package com.examination.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 没什么用，可以删除了 （^_^||）
 * @author 
 *
 */
public class Filter2 implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest srequest, ServletResponse sreponse, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) srequest;
		HttpServletResponse reponse = (HttpServletResponse) sreponse;
		Object user = request.getSession().getAttribute("user");
		if(user==null){
			reponse.sendRedirect(redirePage);
		}
		else{
			arg2.doFilter(request, reponse);
		}
		

	}
	String usersession;
	String redirePage;
	public void init(FilterConfig arg0) throws ServletException {
		ServletContext servletcontext = arg0.getServletContext();
		usersession = servletcontext.getInitParameter("usersessionkey");
		redirePage = servletcontext.getInitParameter("redirectPage");
	}

}
