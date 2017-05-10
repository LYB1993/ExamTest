package com.examination.cotroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examination.constant.PublicSession;
import com.examination.dao.QuestScoreDAO;
import com.examination.dao.UserDAO;
import com.examination.entity.Score;
import com.examination.entity.User;
import com.examination.entity.WrongQuest;
import com.examination.service.ApplicationException;
import com.examination.service.LoginVerifiaction;
/**
 * 这个是整个系统的入口：登陆界面
 * @author LYB
 *
 */
@SuppressWarnings("restriction")
@Controller
public class LoginCotroller {
	//注入 loginVerifiaction接口,
	//主要用于判断用户的登陆，如果错误，给出相应的提示
	@Resource(name="loginVerifiaction")
	private LoginVerifiaction lv;
	//注入  UserDAO接口，用于查询用户的信息，并于数据库进行比较
	@Resource(name="userDAO")
	private UserDAO ud;
	//注入QuestScoreDAO接口，用于查询用户的成绩信息
	@Resource(name="questScoreDAO")
	private QuestScoreDAO qsd;
	
	
	
	
	//进入系统的入口：登陆到系统，通过这个地址跳转到登陆界面（login.jsp）
	/**
	 * 进入系统的入口：登陆到系统，通过这个地址跳转到登陆界面（login.jsp）
	 * @return 字符串： login，跳转到login.jsp
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");		
		return "login";
	}
		
	//用户点击登陆后触发的请求：用于用户的登陆
	/**
	 * 用户点击登陆后触发的请求：用于用户的登陆
	 * @param requset
	 * @param session
	 * @return 字符串："redirect:toIndex.do"；功能：重定向到主界面
	 */
	@RequestMapping("/login.do")
	public String judgeLogin(HttpServletRequest requset,HttpSession session){
		//获取用户的session'并写入公共调用session的类中
		PublicSession.setSession(session);
		
		String userCode = requset.getParameter("usercode");
		String pwd = requset.getParameter("password");
		//System.out.println("U:"+userCode+","+"P:"+pwd);
		//调用用户信息验证的方法，判断用户的用户名和密码是否正确
		User user = lv.verifiaction(userCode, pwd);
		
		//将用户的信息传入session，以便后面其它的页面获取用户的信息（注意这里哦，亲爱的）
		PublicSession.setSessionValueToUser(user);
		//session.setAttribute("user", user);	
		//重定向到 ：主界面
		return "redirect:toIndex.do";
	}
	
	//相应toIndex。do请求，跳转的主界面（index.jsp）
	/**
	 * 响应toIndex.do请求，跳转的主界面（index.jsp）
	 * @param requset
	 * @param session
	 * @return 字符串 ”index“ 功能：跳转的主界面（index.jsp）
	 */
	@RequestMapping("/toIndex.do")
	public String toIndex(HttpServletRequest requset){
		//获取用户的信息，就是在上面judgeLogin（）方法中设置的（^_^）
		//User user = (User) session.getAttribute("user");
		User user = PublicSession.getSessionValueToUser();
		//错误的题目
		List<WrongQuest> wrongquest = new ArrayList<WrongQuest>();
		wrongquest = qsd.findWrongQuest((float) 0.1,user.getUserCode());
		//
		List<Score> score = new ArrayList<Score>();
		//通过用户的No号码来获取用户的历史成绩
		score = qsd.findBySno(user.getUserNo());
		//这里设置这个是为了字符流是为了将成绩的数据传输到界面，用来显示
		//成绩曲线
		StringBuffer src_fenshu = new StringBuffer();
		for(Score s:score){
			src_fenshu.append(String.valueOf(s.getScore())+",");
		}
		//这里是为了去掉最后面的一个“,”，否则后台正确的拆分这个字符流
		if(!(src_fenshu.length()==0)){
			
			src_fenshu.deleteCharAt(src_fenshu.length()-1);
		}
		requset.setAttribute("src_fenshu", src_fenshu);
		requset.setAttribute("wrongquest", wrongquest);
		return "index";
	}
	
	//注册界面的跳转：用来响应登陆界面的注册按钮，跳转到(register.jsp)界面
	/**
	 * 注册界面的跳转：用来响应登陆界面的注册按钮，跳转到(register.jsp)界面
	 * @param session
	 * @return 字符串："register"；功能：跳转到(register.jsp)界面
	 */
	@RequestMapping("toregister.do")
	public String register(){
		//System.out.println("toregister.do");
		return "register";
	}
	//注册界面：响应注册界面的注册按钮，如果注册成功，重定向到登陆界面
	//否则返回“注册失败的提示”，并重定向到注册界面
	/**
	 * 注册界面：响应注册界面的注册按钮，如果注册成功，重定向到登陆界面否则返回“注册失败的提示”，并重定向到注册界面
	 * @param request
	 * @param session
	 * @return  字符串：1."redirect:toLogin.do"；功能:注册成功，返回到登陆界面
	 * 					2."redirect:toregister.do"；功能：注册失败，返回注册界面
	 */
	@RequestMapping("/toregistersucceed.do")
	public String registersun(HttpServletRequest request){
		boolean isadd=false;
		Integer userId = null;
		String userCode = request.getParameter("username");
		String pwd1 = request.getParameter("password");
		String userName = request.getParameter("fullname");
		String userno = request.getParameter("userno");
		String userPhone = request.getParameter("phone");
		String usernumcard = request.getParameter("numcard");
		String useremail = request.getParameter("email");
		Long user_no = Long.valueOf(userno);
		User user = new User(userId, userCode, pwd1, userName,user_no,usernumcard, userPhone,useremail);
		isadd=ud.addUser(user);
		request.setAttribute("REGISTER", isadd);
		//System.out.println(isadd);
		if(isadd){
			request.setAttribute("message", "");
			return "redirect:toLogin.do";
		}else{
			request.setAttribute("message", "注册失败！");
			return "redirect:toregister.do";
		}	
	}
	
	//忘记密码,点击登陆界面的忘记密码，跳转到（findpwd.jsp）界面
	/**
	 * 忘记密码,点击登陆界面的忘记密码，跳转到（findpwd.jsp）界面
	 * @return 字符串："findpwd"；功能：跳转到（findpwd.jsp）界面找回密码
	 */
	@RequestMapping("/toFindpwd.do")
	public String tofindpwd(){
		return "findpwd";
	}
	//响应找回密码：点击后获取输入的身份证号码，然后返回一个密码
	/**
	 * 响应找回密码界面的按钮：点击后获取输入的身份证号码，然后返回一个密码
	 * @param session
	 * @param request
	 * @return 字符串："findpwd"，功能：跳转到找回密码界面，并将密码显示
	 */
	@RequestMapping("/findpwd.do")
	public String findpwd(HttpServletRequest request){
		String numcard = request.getParameter("numcard");
		String pwd = ud.findpwd(numcard);
		request.setAttribute("returnpwd", pwd);
		return "findpwd";
	}
	
	//异常处理方法
	 /**
	  * 异常处理方法，如果系统发生异常，跳转到异常界面
	  * @param ex
	  * @param request
	  * @param session
	  * @return
	  */
	@ExceptionHandler
	public String allExeception(Exception ex,HttpServletRequest request){
		if(ex instanceof ApplicationException){
			request.setAttribute("UP", ex.getMessage());
			return "login";
		}
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"    Exception is:"+ex.getMessage());
			ex.printStackTrace();
		}
		return "error";	
	}
}
