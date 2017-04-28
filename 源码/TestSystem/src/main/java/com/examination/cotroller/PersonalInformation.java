package com.examination.cotroller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examination.constant.PublicSession;
import com.examination.dao.UserDAO;
import com.examination.entity.User;
/**
 * 用户信息界面的类，这个类主要用于对用户信息进行修改
 * @author 
 *
 */
@SuppressWarnings("restriction")
@Controller
public class PersonalInformation {
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@ExceptionHandler
	public String PersonalInformationExeception(Exception ex){
		
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"    Exception is:"+ex.getMessage());
			return "error";
		}
		return "error";
	}
	//用户信息编辑：点击修改用户信息后，调用此方法，获取页面的输入信息，然后
	//根据信息来修改内容
	/**
	 * 用户信息编辑：点击修改用户信息后，调用此方法，获取页面的输入信息，然后
	 * 根据信息来修改内容
	 * @param request
	 * @param session
	 * @return 返回字符串，redirect:toPersonalInformation.do
	 * 如果修改成功重定向到个人信息界面
	 */
	@RequestMapping("/to_edit-profile.do")
	public String editprofile(HttpServletRequest request){
		User user = new User();
		User srcuser = PublicSession.getSessionValueToUser();
		String User_name = request.getParameter("name");
		String User_pwd = request.getParameter("pwd");
		String numcard = request.getParameter("numcard");
		String phone = request.getParameter("mobile");
		String email = request.getParameter("email");
		user.setUserId(srcuser.getUserId());
		user.setUserName(User_name);
		user.setUserPwd(User_pwd);
		user.setUserUnmcard(numcard);
		user.setUserPhone(phone);
		user.setUserEmail(email);
		boolean edit = userDAO.editUser(user);
		if(edit){
			User newuser = new User();
			newuser = userDAO.findByUserCode(srcuser.getUserCode());
			PublicSession.setSessionValueToUser(newuser);
			return "redirect:toPersonalInformation.do";
		}
		return null;
	}
}
