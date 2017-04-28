package com.examination.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.examination.constant.Constant;
import com.examination.entity.ExamPage;
import com.examination.entity.TestQuestions;
import com.examination.util.RandomNum;
/**
 * 实现QuestDAO接口的类
 * @author 
 *
 */
@SuppressWarnings("restriction")
@Repository("questDAO")
public class QuestDAOJdbcImpl implements QuestDAO{

	
	@Resource(name="ds")
	private DataSource ds;
	
	public List<TestQuestions> findByGroup(String Group) {
		List<TestQuestions> Qlist = new ArrayList<TestQuestions>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestQuestions tq = null;
		try {
			if(!Qlist.isEmpty()){
				Qlist.clear();
			}
			conn = ds.getConnection();
			String sql = "select * from Questions where Quest_Belong = ? order by quest_Id";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Group);
			rs = ps.executeQuery();
			while(rs.next()){
				tq = new TestQuestions();
				tq.setQuestId(rs.getInt("Quest_Id"));
				tq.setQuestSubjct(rs.getString("Quest_Subject"));
				tq.setQuestScore(rs.getInt("Quest_Score"));
				tq.setQuestA(rs.getString("Quest_A"));
				tq.setQuestB(rs.getString("Quest_B"));
				tq.setQuestC(rs.getString("Quest_C"));
				tq.setQuestD(rs.getString("Quest_D"));
				tq.setQuestBelongTo(rs.getString("Quest_Belong"));
				tq.setQuestAnswer(rs.getString("Quest_Answer"));
				
				Qlist.add(tq);
			}
		} catch (SQLException e) {
			System.out.println("Select Questions Error:"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("DataBases Close Fail");
				e.printStackTrace();
			}
		}
		return Qlist;
	}
	public TestQuestions findByIdAndBelong(int id,String belong) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestQuestions tq = null;
			try {
				conn = ds.getConnection();
				String sql = "select * from Questions where Quest_Id = ? and Quest_Belong = ?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, belong);
				rs = ps.executeQuery();
				while(rs.next()){
					tq = new TestQuestions();
					tq.setQuestId(rs.getInt("Quest_Id"));
					tq.setQuestSubjct(rs.getString("Quest_Subject"));
					tq.setQuestScore(rs.getInt("Quest_Score"));
					tq.setQuestA(rs.getString("Quest_A"));
					tq.setQuestB(rs.getString("Quest_B"));
					tq.setQuestC(rs.getString("Quest_C"));
					tq.setQuestD(rs.getString("Quest_D"));
					tq.setQuestBelongTo(rs.getString("Quest_Belong"));
					tq.setQuestAnswer(rs.getString("Quest_Answer"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("DataBases Close Fail");
					e.printStackTrace();
				}
			}
		return tq;
	}
	public boolean randomlyGenerated(ExamPage exampage) {
		int[] randomChoice = null; //选择题 题目编号存放的数组
		//int[] randomJd = null; //简答题题目编号存放的数组
		Connection conn = null;
		
		//这是连接
		//PreparedStatement psRandomQuest = null;
		PreparedStatement psNumMax = null;
		PreparedStatement psNumMin = null;
		PreparedStatement psInsetRandomNum = null;
		
		//这是根据sql查询的结果集
		ResultSet rsChoiceMaxNum = null;//获取选择题库中的最大编号
		ResultSet rsChoiceMinNum = null;//获取选择题库中的最小编号
	//	ResultSet rsJdMaxNum = null;//获取选择题库中的最大编号
	//	ResultSet rsJdMinNum = null;//获取选择题库中的最小编号
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			//选择题题库中的最大和最小编号sql语句
			String sqlChoiceMaxNum = Constant.sql_questdao_random_ChoiceMaxNum;
			String sqlChoiceMinNum = Constant.sql_questdao_random_ChoiceMinNum;
			//简答题题库中最大最小编号sql语句
			//String sqlJdMaxNum = Constant.sql_questdao_random_jdMaxNum;
			//String sqlJdMinNum = Constant.sql_questdao_random_jdMaxNum;
			String sqlInsetQuetToExamQuest = Constant.sql_questdao_random_insertQuestToExamQuset;
			
			psNumMax = conn.prepareStatement(sqlChoiceMaxNum);
			psNumMin = conn.prepareStatement(sqlChoiceMinNum);
			rsChoiceMaxNum = psNumMax.executeQuery();
			rsChoiceMinNum = psNumMin.executeQuery();
			if(rsChoiceMaxNum.next()&&rsChoiceMinNum.next()){

				randomChoice = RandomNum.randomNum(rsChoiceMinNum.getInt("minnum"), rsChoiceMaxNum.getInt("maxnum"), exampage.getExamChoiceNum());
			}
			//开始写入数据到数据库
			psInsetRandomNum = conn.prepareStatement(sqlInsetQuetToExamQuest);
			for(int i=0 ;i<randomChoice.length;i++){
				psInsetRandomNum.setString(1, exampage.getExamName());
				psInsetRandomNum.setInt(2, randomChoice[i]);
				psInsetRandomNum.setInt(3, exampage.getChoiceScore());
				psInsetRandomNum.setLong(4, exampage.getExamId());
				psInsetRandomNum.addBatch();
				if(i%5==0){
					psInsetRandomNum.executeBatch();
					psInsetRandomNum.clearBatch();
				}		
			}
			psInsetRandomNum.executeBatch();
			conn.commit();
			return true;
		} catch (SQLException e) {
			System.out.println("Randomly Generated quest false :"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("database close false:"+this.getClass().getName());
				e.printStackTrace();
			}
		}
		return false;
	}
	public List<TestQuestions> findByExamName(String examName) {
		List<TestQuestions> Qlist = new ArrayList<TestQuestions>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		TestQuestions tq = null;
		String sql = Constant.sql_questdao_random_selectquestInquestions;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, examName);
			rs = ps.executeQuery();
			while(rs.next()){
				tq = new TestQuestions();
				tq.setQuestId(rs.getInt(Constant.COLUMNNAME_QUESTIONS_ID));
				tq.setQuestSubjct(rs.getString(Constant.COLUMNNAME_QUESTIONS_SUBJECT));
				tq.setQuestScore(rs.getInt(Constant.COLUMNNAME_EXAMCHOICE_CHOICESCORE));
				tq.setQuestA(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTA));
				tq.setQuestB(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTB));
				tq.setQuestC(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTC));
				tq.setQuestD(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTD));
				tq.setQuestBelongTo(rs.getString(Constant.COLUMNNAME_QUESTIONS_BELONG));
				tq.setQuestAnswer(rs.getString(Constant.COLUMNNAME_QUESTIONS_ANSWER));
				
				Qlist.add(tq);
			}
		} catch (SQLException e) {
			System.out.println("Select Questions Error:"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("DataBases Close False:"+this.getClass().getName());
				e.printStackTrace();
			}
		}
		return Qlist;
	}
	public List<TestQuestions> findAllquest() {
		List<TestQuestions> allQuestlist = new ArrayList<TestQuestions>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = Constant.sql_questdao_findAllquest;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				TestQuestions  tq = new TestQuestions();
				tq.setQuestId(rs.getInt(Constant.COLUMNNAME_QUESTIONS_ID));
				tq.setQuestSubjct(rs.getString(Constant.COLUMNNAME_QUESTIONS_SUBJECT));
				tq.setQuestA(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTA));
				tq.setQuestB(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTB));
				tq.setQuestC(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTC));
				tq.setQuestD(rs.getString(Constant.COLUMNNAME_QUESTIONS_QUESTD));
				tq.setQuestAnswer(rs.getString(Constant.COLUMNNAME_QUESTIONS_ANSWER));
				allQuestlist.add(tq);
			}
		} catch (SQLException e) {
			System.out.println("查询题库出错；："+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("database close false:"+this.getClass().getName());
				e.printStackTrace();
			}
		}
		return allQuestlist;
	}
	
}
