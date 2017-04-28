package com.examination.cotroller;

/**
 * 这个类时主要的类，是整个系统的核心类
 * 界面中的功能都由这个类中的方法实现
 * 
 */



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examination.constant.PublicSession;
import com.examination.dao.BelongDAO;
import com.examination.dao.QuestDAO;
import com.examination.dao.QuestScoreDAO;
import com.examination.dao.UploadDAO;
import com.examination.dao.UserDAO;
import com.examination.entity.AnswerSheet;
import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
import com.examination.entity.User;
/**
 * 这个类时主要的类，是整个系统的核心类
 * 界面中的功能都由这个类中的方法实现
 * @author 
 *
 */
@SuppressWarnings("restriction")
@Controller
public class IndexCotroller {	
	//注入：QuestDAO接口，这个接口的具体方法和功能请到接口类中查看（按住Alt然后点击下面的QuestDAO即可）
	@Resource(name="questDAO")
	private QuestDAO qd;
	
	@Resource(name="questScoreDAO")
	private QuestScoreDAO qsd;
	
	
	@Resource(name="belongDAO")
	private BelongDAO belongdao;
	
	@Resource(name="userDAO")
	private UserDAO ud;
	
	@Resource(name="uploadDAO")
	private UploadDAO uploadDAO;
	//对错误异常的处理
	@ExceptionHandler
	public String indexConExeception(Exception ex){
		
		if(ex instanceof Exception){
			System.out.println("Exception:"+this.getClass().getName()+"   Exception is:"+ex.getMessage());
			ex.printStackTrace();
			return "error";
		}
		return "error";
	}
	
	
	
	//考试科目的选择页：响应开始考试的按钮 选择科目后，会获取选取的科目然后通过科目
	//到数据库中去查询，然后跳转到（choice.jsp）界面
	/**
	 * 考试科目的选择页：响应开始考试的按钮 选择科目后，会获取选取的科目然后通过科目
	 * 到数据库中去查询，然后跳转到（choice.jsp）界面
	 * @param request
	 * @return 字符串，choice 跳转到（choice.jsp）
	 */
	@RequestMapping("/toChoice.do")
	public String toChoice(HttpServletRequest request){
		//获取数据库中保存的所有的科目类型
		List<String> examPageList = new ArrayList<String>();
		examPageList = belongdao.selectExamPage();
		request.setAttribute("examPageList", examPageList);
		return "choice";
	}

	
	
	/**
	 * 2017年4月21日22点08分 此方法启用
	 *  跳转到考试界面 页面跳转到试卷的examTest.jsp页面,
	 * @param request 页面request
	 * @param session 页面session
	 * @return 字符串 examTest 跳转到考试界面examTest.jsp
	 */
	@RequestMapping("toExamTest.do")
	public String examTest(HttpServletRequest request){
		List<TestQuestions> list = new ArrayList<TestQuestions>();
		String examName = request.getParameter("choice");
		list = qd.findByExamName(examName);
		ExamPage exampage = uploadDAO.findByexamName(examName);
		request.setAttribute("questList", list);
		request.setAttribute("examTime", exampage.getExamTime());
		PublicSession.setSessionValueToExamName(examName);
		PublicSession.setSessionValueToList(list);
		return "examTest";
	}
	/**
	 * 练习模式，下面两个方法分别是此界面中对应的两种模式
	 * @param request
	 * @return 字符串跳转到练习模式的jsp界面
	 */
	@RequestMapping("toChoiceType.do")
	public String toChoiceType(HttpServletRequest request){
		List<String> belong = new ArrayList<String>();
		request.setAttribute("belong", belong);
		return "choiceTestType";
	}
	/**
	 * 测试模式
	 * @param request
	 * @return 字符串，跳转到测试模式
	 */
	@RequestMapping("toChoiceContent.do")
	public String toChoiceContent(HttpServletRequest request){
		List<String> belong = new ArrayList<String>();
		belong = belongdao.selectBelong();
		//System.out.println("belong:"+belong);
		request.setAttribute("belong", belong);
		return "choiceContent";
	}
	/**
	 * 正式模式
	 * @param request
	 * @param session
	 * @return 字符串，跳转到正式模式
	 */
	@RequestMapping("toExamType.do")
	public String toExamType(HttpServletRequest request,HttpSession session){
		Integer questNum = Integer.valueOf(request.getParameter("num"));
		String belong = request.getParameter("belong");
		String difficulty = request.getParameter("dif");
		System.out.println(questNum+"  "+belong+"  "+difficulty);
		request.setAttribute("belong", belong);
		return "choiceContent";
	}
	
	//成绩查询因涉及到数据库连接
	//单独创建一个类class:QuestScoreCotroller
	
	//试卷生成  按钮点击事件
	//页面跳转到生成试卷的（upload.jsp)页面，其他的页面操作在class：UploadController中
	/**
	 * 试卷生成  按钮点击事件
	 * 页面跳转到生成试卷的（upload.jsp)页面，其他的页面操作在class：UploadController中
	 * @return
	 */
	@RequestMapping("toExamgrow.do")
	public String toExamGrow(HttpSession session){	
		return "upload";
	}
	//试卷删除  按钮
	//跳转到删除试卷的（deleteExam.jsp)页面
	/**
	 * /试卷删除  按钮
	 * 跳转到删除试卷的（deleteExam.jsp)页面
	 * @param request
	 * @return 字符串 deleteExam.jsp 页面
	 */
	@RequestMapping("toExamdelete.do")
	public String toExamDelete(HttpServletRequest request){
		request.setAttribute("belong", belongdao.selectExamPage());
		return "deleteExam";
	}
	//响应删除试卷界面的删除按钮（页面中的红色的（X）
	//无论删除成功与否都重定向到删除试卷的界面
	/**
	 * 响应删除试卷界面的删除按钮（页面中的红色的（X）
	 * 无论删除成功与否都重定向到删除试卷的界面
	 * @param request
	 * @param session
	 * @return 字符串，重定向
	 */
	@RequestMapping("examdelete.do")
	public String deleteExam(HttpServletRequest request,HttpSession session){
		String exampageName = request.getParameter("exampageName");
		boolean isdelete = belongdao.deleteByExamPageName(exampageName);
		System.out.println(isdelete);
		if(isdelete){
			return "redirect:toExamdelete.do";
		}
		return "redirect:toExamdelete.do";		
	}
	
	//个人中心  页面跳转到个人中心的（personalInformayion.jsp）页面，此界面
	//还包括用户信息编辑的界面，点击界面的编辑按钮可以切换到用户信息编辑界面
	//编辑用户信息是为操作在class：PersonalInformation中
	/**
	 * 个人中心  页面跳转到个人中心的（personalInformayion.jsp）页面，此界面
	 * 还包括用户信息编辑的界面，点击界面的编辑按钮可以切换到用户信息编辑界面
	 * 编辑用户信息是为操作在class：PersonalInformation中
	 * @param request
	 * @param session
	 * @return 字符串 personalInformayion 跳转到个人中心的（personalInformayion.jsp）页面
	 */
	@RequestMapping("/toPersonalInformation.do")
	public String personaInf(HttpServletRequest request){	
		//System.out.println("pro:"+session);	
		//User user = (User) session.getAttribute("user");
		User user = PublicSession.getSessionValueToUser();
		System.out.println(user);
		request.setAttribute("User", user);	
		return "personalInformayion";
	}
	
	//用户信息界面，这个界面只有管理员才能看到，也就是说这个方法只有管理员才能调用
	//跳转到（informanagement.jsp）界面
	/**
	 * 用户信息界面，这个界面只有管理员才能看到，也就是说这个方法只有管理员才能调用
	 * 跳转到（informanagement.jsp）界面
	 * @param session
	 * @return （informanagement.jsp）界面
	 */
	@RequestMapping("/toInfomanagement.do")
	public String toinfomanagement(HttpServletRequest request){
		List<User> userall = new ArrayList<User>();	
		userall = ud.selectAll();
		request.setAttribute("usertables", userall);
		return "infomanagement";
	}
	
	//点击用户信息界面的删除按钮可以删除用户，然后重新获取所有用户的信息，然后显示（informanagement.jsp）界面
	//其实可以直接重定向到/toInfomanagement.do的，不过开始没注意（^.^）
	/**
	 * 点击用户信息界面的删除按钮可以删除用户，然后重新获取所有用户的信息，
	 * 然后显示（informanagement.jsp）界面其实可以直接重定向到/toInfomanagement.do的，
	 * 不过开始没注意（^.^）
	 * @param request
	 * @param session
	 * @return 字符串 informanagement.jsp）
	 */
	@RequestMapping("/todelete.do")
	public String deleteuser(HttpServletRequest request){		
		String userCode = request.getParameter("usercode");
		boolean isdelete = ud.delectUser(userCode);
		if(isdelete){
		List<User> userall = new ArrayList<User>();	
		userall = ud.selectAll();
		request.setAttribute("usertables", userall);
		}
		return "infomanagement";
		//可以把上面的代码注释 掉用下面这个也可以
		//return "redirect:/toInfomanagement.do"
	}
	
	@RequestMapping("toAllQuestions.do")
	public String toAllQuestions(HttpServletRequest request){
		List<TestQuestions> allQuestlist = new ArrayList<TestQuestions>();
		allQuestlist = qd.findAllquest();
		request.setAttribute("allquest", allQuestlist);		
		return "allQuestions";
	}
	
	

	@RequestMapping("toAnswer2.do")
	public String  answer(HttpServletRequest request){
		
		User user = PublicSession.getSessionValueToUser();
		List<TestQuestions> list = PublicSession.getSessionValueToList();
		String examName = PublicSession.getSessionValueToExamName();
		
		AnswerSheet as = new AnswerSheet();
		ExamPage exampage = new ExamPage();
		exampage = uploadDAO.findByexamName(examName);
		Integer sumScore = 0;
		String answerSrc = "";
		String otherSrc = "";
		for(TestQuestions tq:list){
			String userAnswe = request.getParameter(""+tq.getQuestId());
			answerSrc+=request.getParameter(""+tq.getQuestId())+"X";
			
			if(tq.getQuestAnswer().equals(userAnswe)){
				sumScore += exampage.getChoiceScore();
			}
			
		}
		as.setBelong(examName);
		as.setAnswerstr(answerSrc);
		as.setOther(otherSrc);
		boolean isaddScore = qsd.addScore(user, sumScore, examName);//将考试的成绩写入数据库
		boolean isaddAswer = qsd.addAnswerSheet(as, user.getUserCode());//将考生的答案写入数据库
		ud.addExamNum(user.getUserCode());//添加考试次数
		System.out.println(isaddScore+"   "+isaddAswer);
		return "redirect:toSlelctScore.do";
	}
}
