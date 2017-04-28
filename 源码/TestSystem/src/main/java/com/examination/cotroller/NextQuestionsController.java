package com.examination.cotroller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.examination.constant.PublicSession;
import com.examination.entity.TestQuestions;

import net.sf.json.JSONObject;

@Controller
public class NextQuestionsController {

	static List<TestQuestions> list;
	private static Integer questNum = 0;
	private static Integer questSum = 0;
	private static String[] answers = null;
	
	@RequestMapping("toAnswer.do")
	@ResponseBody
	public String toFirstQuestion(){

		TestQuestions tq = new TestQuestions();
		tq = list.get(questNum);
		JSONObject jsonTQ = JSONObject.fromObject(tq);
		return jsonTQ.toString();
	}
	
	
	@RequestMapping("next.do")
	@ResponseBody
	public String nextQuestion(){
		if(list.isEmpty()){
			init();
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
		TestQuestions tq = new TestQuestions();
		tq = list.get(questNum);
		JSONObject jsonTQ = JSONObject.fromObject(tq);		
		return jsonTQ.toString();
	}
	
	public void init(){
		list = PublicSession.getSessionValueToList();
		questSum = list.size();
		answers = new String[questSum];		
	}
}
