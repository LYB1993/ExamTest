package com.examination.constant;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.examination.entity.TestQuestions;
import com.examination.entity.User;

public class PublicSession {

	private static HttpSession session;

	public static HttpSession getSession() {
		return session;
	}

	public static void setSession(HttpSession session) {
		PublicSession.session = session;
	}
	
	public static void setSessionValueToUser(Object value){
		session.setAttribute("user", value);
	}
	public static User getSessionValueToUser(){	
		User user =  (User) session.getAttribute("user");
		return user;
	}
	
	public static void setSessionValueToExamName(Object value){
		session.setAttribute("examname", value);
	}
	public static String getSessionValueToExamName(){
		String examname = (String) session.getAttribute("examname");
		return examname;	
	}
	
	public static void setSessionValueToList(Object value){
		session.setAttribute("TestQuestList", value);
	}
	public static List<TestQuestions> getSessionValueToList(){
		@SuppressWarnings("unchecked")
		List<TestQuestions> list = (List<TestQuestions>) session.getAttribute("TestQuestList");
		return list;
	}
}
