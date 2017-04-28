package com.examination.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 系统信息界面
 * @author 
 *
 */
@Controller
public class ToaboutCoreoller {
	
	@ExceptionHandler
	public String ToaboutExeception(Exception ex){
		
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"    Exception is:"+ex.getMessage());
			return "error";
		}
		return "error";
	}
	
	//关于系统，响应关于系统的响应，点击后跳转大（about.jsp）界面
		@RequestMapping("/toAbout.do")
		public String aboutpage(){
			return "about";
		}
}
