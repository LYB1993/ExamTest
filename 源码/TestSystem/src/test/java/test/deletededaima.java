package test;

public class deletededaima {

	
	//答案接受的代码，然后跳转到查询页面
	
//	@RequestMapping("/toExamAnser.do")
//	public String toScore(HttpServletRequest request,HttpSession session){
//		String[] id = new String[list.size()+1];
//		String all_choice = "";
//		String all_other = "";
//		//System.out.println(list);
//		int score = 0;
//		id[0] = "answer:";
//		TestQuestions TQ = null;
//		for(int i = 1;i<id.length-1;i++){
//			id[i] = request.getParameter(""+i);
//			all_choice += request.getParameter(""+i)+"X";//拼接选择题目的答案字符串
//			//System.out.println("id:"+i+":answer="+id[i]);
//		}
//		all_other += request.getParameter(""+id.length);
//		
//		as.setAnswerstr(all_choice);
//		as.setOther(all_other);
//		
//		
//		for(int i = 1;i<id.length-1;i++){
//			 TQ = list.get(i-1);
//			 System.out.println(i+":"+TQ.getQuestAnswer());
//			
//			if(TQ.getQuestAnswer().equals("answer="+id[i])){
//				score+=TQ.getQuestScore();
//			}
//		} 
//		System.out.println("成绩："+score);
//		session.setAttribute("SCore", score);
//		User user = (User) session.getAttribute("user");
//		session.setAttribute("code", user.getUserCode());
//		//System.out.println(Arrays.toString(id));
//		boolean isaddScore = qsd.addScore(user, score, TQ);//将考试的成绩写入数据库
//		boolean isaddAs = qsd.addAnswerSheet(as, user.getUserCode());//将考生的答案写入数据库
//		System.out.println("addScore:"+isaddScore+"  ,addAnswer:"+isaddAs);
//		return "redirect:toSlelctScore.do";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//跳转到考试界面 页面跳转到试卷的examTest.jsp页面,
//	//点击页面保存后执行下面的代码（代码这个类的最下方）
//	/**
//	 * 2017年4月21日22点08分 此方法删除
//	 * 
//	 * 
//	 * 跳转到考试界面 页面跳转到试卷的examTest.jsp页面,
//	 * 点击页面保存后执行下面的代码（代码这个类的最下方）
//	 * @param request
//	 * @param session
//	 * @return 字符串 examTest 跳转到考试界面examTest.jsp
//	 */
//	@RequestMapping("/toExamTest.do")
//	public String choice(HttpServletRequest request,HttpSession session){
//		tolong =request.getParameter("choice");
//		as.setBelong(tolong);
//		list = qd.findByGroup(tolong);
//		TestQuestions tq = qd.findByIdAndBelong(arrays[index],tolong);
//		session.setAttribute("quests", tq);
//		index++;
//		request.setAttribute("request", list);
//		return "examTest";	
//	}
//	
//	List<String> choiceAnswe = new ArrayList<String>();
//	String all_choice = "";
//	int score = 0;
//	String[] id = new String[arrays.length];
//	AnswerSheet as = new AnswerSheet();//答案类型，用来保存用户的答案和用户的其它信息
//	//响应用户考试界面的下一题的按钮，点击后调用以下方法
//	/**
//	 * 响应用户考试界面的下一题的按钮，点击后调用以下方法
//	 * @param request
//	 * @param session
//	 * @return 字符串，重定向到考试界面，如果题目已经没有了，就显示成绩界面
//	 */
//	@RequestMapping("/nextone.do")
//	public String toNextOne(HttpServletRequest request,HttpSession session){
//		TestQuestions src_tq = qd.findByIdAndBelong(arrays[index-1],tolong);
//		all_choice += request.getParameter(""+src_tq.getQuestId())+"X";//拼接选择题目的答案字符串
//		TestQuestions tq = qd.findByIdAndBelong(arrays[index],tolong);
//		if(index==20){
//			User user = (User) session.getAttribute("user");
//			as.setAnswerstr(all_choice);
//			as.setUser_code(user.getUserCode());
//			boolean isaddAs = qsd.addAnswerSheet(as, user.getUserCode());//将考生的答案写入数据库
//			boolean isaddScore = qsd.addScore(user, score, tq);//将考试的成绩写入
//			ud.addExamNum(user.getUserCode());
//			return "redirect:toSlelctScore.do";
//			
//		}
//		if(tq.getQuestAnswer().equals("answer="+request.getParameter(""+index))){
//			score+=tq.getQuestScore();
//		}
//		index++;
//		session.setAttribute("quests", tq);
//		return "examTest";
//	}
}
