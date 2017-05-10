package com.examination.cotroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examination.constant.PublicSession;
import com.examination.dao.QuestScoreDAO;
import com.examination.dao.UploadDAO;
import com.examination.dao.UserDAO;
import com.examination.entity.AnswerSheet;
import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
import com.examination.entity.User;

import net.sf.json.JSONObject;

@Controller
@SuppressWarnings("restriction")
public class NextQuestionsController {

	@Resource(name="uploadDAO")
	private UploadDAO uploadDAO;
	
	@Resource(name="questScoreDAO")
	private QuestScoreDAO qsd;
	
	@Resource(name="userDAO")
	private UserDAO ud;
	
	static List<TestQuestions> list;
	private static Integer questNum;
	private static Integer questSum;
	private static List<String> answers;

	
	
	@RequestMapping("firstone.do")
	@ResponseBody
	public String toFirstInde(){
		
		//初始化属性
		list = PublicSession.getSessionValueToList();
		questSum = list.size()-1;
		answers = new ArrayList<String>();
		TestQuestions tq = new TestQuestions();
		questNum = 0;
		tq = list.get(questNum);	
		JSONObject jsonTQ = JSONObject.fromObject(tq);
		return jsonTQ.toString();
	}
	
	@RequestMapping("next.do")
	@ResponseBody
	public String nextQuestion(HttpServletRequest requset){	
		String choice = requset.getParameter("choice");
		if(choice!=null){
			int i = questNum;
			if(answers.get(i)!=null){
				answers.remove(i);				
			}
			answers.add(i,choice);			
		}else{
			return "choice is null";
		}
		System.out.println("choice:"+questNum+"::"+choice+"答案长度："+answers.size());
		System.out.println(answers.toString());
		if(questNum==questSum){
			return "end";
		}
		questNum++;
		TestQuestions tq = new TestQuestions();
		tq = list.get(questNum);
		JSONObject jsonTQ = JSONObject.fromObject(tq);
		return jsonTQ.toString();
	}
	
	@RequestMapping("returnnext.do")
	@ResponseBody
	public String returnnextQuestion(){	
		questNum--;		
		if(questNum<0){
			return null;
		}
		TestQuestions tq = new TestQuestions();
		tq = list.get(questNum);
		JSONObject jsonTQ = JSONObject.fromObject(tq);		
		return jsonTQ.toString();
	}
	
	/**
	 * 提交答题记录到数据库
	 */
	
	@RequestMapping("toTijiaoAnswer.do")
	public void toTIjiaoAnswer(){
		String examName = PublicSession.getSessionValueToExamName();
		User user = PublicSession.getSessionValueToUser();
		ExamPage exampage = uploadDAO.findByexamName(examName);
		Integer scoreSum = 0;
		String answerSrc = "";
		String otherSrc = "";
		AnswerSheet as = new AnswerSheet();
		for(int i=0;i<list.size();i++){
			answerSrc+=answers.get(i)+"X";
			if(answers.get(i).equals(list.get(i).getQuestAnswer())){
				scoreSum += exampage.getChoiceScore();
			}else{
				qsd.addWrongQuest(examName, list.get(i).getQuestSubjct(), user.getUserCode());
			}
		}
		as.setBelong(examName);
		as.setAnswerstr(answerSrc);
		as.setOther(otherSrc);
		boolean isaddScore = qsd.addScore(user, scoreSum, examName);//将考试的成绩写入数据库
		boolean isaddAswer = qsd.addAnswerSheet(as, user.getUserCode());//将考生的答案写入数据库
		ud.addExamNum(user.getUserCode());//添加考试次数
		System.out.println(isaddScore+"   "+isaddAswer);
	}
}
