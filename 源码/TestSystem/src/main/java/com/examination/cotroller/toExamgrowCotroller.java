package com.examination.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
/**
 * 用于试题上传的类，弃用
 * @author 
 *
 */
@Controller
public class toExamgrowCotroller {

	@ExceptionHandler
	public String toExamgrowExeception(Exception ex){
		
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"    Exception is:"+ex.getMessage());
			return "error";
		}
		return "error";
	}
	
//	@RequestMapping("toExamgrow.do")
//	public String toExamGrow(){		
//		return "upload";
//	}
}
