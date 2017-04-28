package test;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.examination.dao.QuestDAO;
import com.examination.dao.UploadDAO;
import com.examination.dao.UserDAO;
import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
import com.examination.entity.User;
@SuppressWarnings("resource")
public class TestCase {
	
	
	@Test
	//Test adopt:ture
	public void dbDataRead(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ac.getBean("db"));
	}
	@Test
	//Linking DataBases:true
	public void DataBaseTest() throws SQLException{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource ds = ac.getBean("ds", DataSource.class);
		Connection conn = ds.getConnection();
		System.out.println(conn);
	}
	//data select:true
	@Test
	public void DataSelect(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = ac.getBean("userDAO",UserDAO.class);
		User user = userDao.findByUserCode("s1001");
		System.out.println(user);	
		
	}
	
	@Test
	public void DataQuest(){
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestDAO questDAO = ac.getBean("questDAO",QuestDAO.class);
		List<TestQuestions> list = new ArrayList<TestQuestions>();
		list = questDAO.findByGroup("english");
		System.out.println(list);
		
	}
	@Test
	public void DataAddUser(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		User user = new User(1001,"s1001","123456","超级管理员",6301, "410326199312235598","1562301881", "805864468@qq.com");
		UserDAO userDao = ac.getBean("userDAO",UserDAO.class);
		System.out.println(userDao.addUser(user));
		
	}
	
	
	//Test Succeed:true;
	@Test
	public void UnoutDAtaTEst(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UploadDAO UPDAO = ac.getBean("uploadDAO",UploadDAO.class);
		System.out.println("QUDAO:"+UPDAO);
		File file = new File("C:\\Users\\LYB\\Desktop\\TEST.txt");
		System.out.println(file);
		ac.getBean("ds", DataSource.class);
		 List<TestQuestions> list = UPDAO.readFile(file);
		 boolean si =  UPDAO.uploadMySQL(list);
		 if(si){
			 System.out.println("SUCCEED!!");
		 }else{
			 System.out.println("DEFALE!!");
		 }

		
		
	}
	@Test
	public void usertables(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = ac.getBean("userDAO",UserDAO.class);
		List<User> userall = new ArrayList<User>();
		userall = userDao.selectAll();
		System.out.println(userall);	
	}
	
	@Test
	public void wrongQuest(){
		//ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		//QuestScoreDAO scoredao = ac.getBean("questScoreDAO",QuestScoreDAO.class);
		//List<WrongQuest> wrongquest = new ArrayList<WrongQuest>();
		//wrongquest = scoredao.findWrongQuest((float) 0.0);
		//System.out.println(wrongquest);
	}
	
	@Test
	public void addExamNum(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAO userDao = ac.getBean("userDAO",UserDAO.class);
		System.out.println(userDao.addExamNum("s1001"));
	}
	
	@Test
	public void radomExam(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestDAO qd = ac.getBean("questDAO",QuestDAO.class);
		ExamPage ep = new ExamPage();
		ep.setExamName("这又是一个测试");
		ep.setExamChoiceNum(5);
		ep.setChoiceScore(2);
		ep.setExamId(System.currentTimeMillis());
		
		System.out.println(qd.randomlyGenerated(ep));
		
	}
	
	//测试返回题目list集合
	@Test
	public void radomExamquestList(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		QuestDAO qd = ac.getBean("questDAO",QuestDAO.class);
		List<TestQuestions> list = new ArrayList<TestQuestions>();
		list = qd.findByExamName("这又是一个测试");
		System.out.println(list.size());
		
	}
}
