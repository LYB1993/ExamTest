package com.examination.cotroller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 无用的类
 * @author
 *
 */
@Controller
public class DelectUserController {
	
	@RequestMapping()
	public String delectuser(HttpSession session){
		
		return "";
	}
		
}
