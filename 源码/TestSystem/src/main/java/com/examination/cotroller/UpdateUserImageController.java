package com.examination.cotroller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;

import com.examination.dao.UserDAO;

@SuppressWarnings("restriction")
public class UpdateUserImageController {

	
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@RequestMapping("updateImage.do")
	public String updateImage(){
		
		return "";
	}
	
}
