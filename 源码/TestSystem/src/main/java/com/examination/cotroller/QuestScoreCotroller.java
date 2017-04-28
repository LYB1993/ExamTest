package com.examination.cotroller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examination.constant.PublicSession;
import com.examination.dao.QuestScoreDAO;
import com.examination.entity.AnswerSheet;
import com.examination.entity.Score;
import com.examination.entity.User;
/**
 * 查询所有的考试成绩的类
 * @author 
 *
 */
@SuppressWarnings("restriction")
@Controller
public class QuestScoreCotroller {
	
	@Resource(name="questScoreDAO")
	private QuestScoreDAO qsd;
	
	@ExceptionHandler
	public String QuestScoreExeception(Exception ex){
		ex.printStackTrace();
		if(ex instanceof Exception){
			
			System.out.println("Exception:"+this.getClass().getName()+"    Exception is:"+ex.getMessage());
			return "error";
		}
		return "error";
	}
	/**
	 * 跳转到所有的考试成绩的界面（QueryHistoryScore。jsp）
	 * @param request
	 * @return 字符串（QueryHistoryScore。jsp）
	 */
	@RequestMapping("toSlelctScore.do")
	public String requestScore(HttpServletRequest request){
		List<Score> slist = new ArrayList<Score>();
		User user = PublicSession.getSessionValueToUser();
		if(!slist.isEmpty()){
			slist.clear();
		}
		slist = qsd.findBySno(user.getUserNo());
		//System.out.println(slist);
		request.setAttribute("Score", slist);
		return "QueryHistoryScore";
	}
	
	//全部的考试信息，可以显示每次考试的情况，然后跳转到（allproinfo.jsp）界面
		/**
		 * 全部的考试信息，可以显示每次考试的情况，然后跳转到（allproinfo.jsp）界面
		 * @param session
		 * @param request
		 * @return （allproinfo.jsp）界面
		 */
		@RequestMapping("toAllScore.do")
		public String toAllScore(HttpServletRequest request){
			List<AnswerSheet> all_as = new ArrayList<AnswerSheet>();
			User user = PublicSession.getSessionValueToUser();;			
			String code = user.getUserCode();
			all_as = qsd.findByCode(code);
			request.setAttribute("all_as", all_as);
			request.setAttribute("name", user.getUserName());
			return "allproinfo";
		}
		
	
}
