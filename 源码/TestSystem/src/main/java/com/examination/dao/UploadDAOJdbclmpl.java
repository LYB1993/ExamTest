package com.examination.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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

@SuppressWarnings("restriction")
@Repository("uploadDAO")
public class UploadDAOJdbclmpl implements UploadDAO{

	@Resource(name="ds")
	private DataSource ds;
	
	public List<TestQuestions> readFile(File file) {
		List<TestQuestions> list = new ArrayList<TestQuestions>();
		List<String> questionlist = new ArrayList<String>();
		
		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(
									new InputStreamReader(
											new FileInputStream(file), "utf-8"));
			String Questionstr = null;
			while((Questionstr=br.readLine())!=null){
				questionlist.add(Questionstr);
			}
			for(int i = 0;i<questionlist.size()/6;i++){
				int index = i*6;
				TestQuestions question = new TestQuestions();
				String[] str = questionlist.get(index).split(",");
				question.setQuestId(Integer.valueOf(str[0].split("=")[1]));
				question.setQuestAnswer(str[1].split("=")[1]);
				question.setQuestScore(Integer.valueOf(str[2].split("=")[1]));
				question.setQuestBelongTo(str[3].split("=")[1]);
				question.setQuestSubjct(questionlist.get(1+index));
				question.setQuestA(questionlist.get(2+index));
				question.setQuestB(questionlist.get(3+index));
				question.setQuestC(questionlist.get(4+index));
				question.setQuestD(questionlist.get(5+index));
				list.add(question);	
			}	
			
		} catch (Exception e) {
			System.out.println("Data readFile Error! in"+this.getClass().getName());
			e.printStackTrace();
		}
				
		
		
		return list;
	}

	public boolean uploadMySQL(List<TestQuestions> questList) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = Constant.sql_uplodadao_uploadMySQL;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			for(int i = 0;i<questList.size();i++){
				TestQuestions question = questList.get(i);
				//ps.setInt(1, question.getQuestId());
				//ps.setInt(2, question.getQuestScore());
				ps.setString(1, question.getQuestBelongTo());
				ps.setString(2, question.getQuestAnswer());
				ps.setString(3, question.getQuestSubjct());
				ps.setString(4, question.getQuestA());
				ps.setString(5, question.getQuestB());
				ps.setString(6, question.getQuestC());
				ps.setString(7, question.getQuestD());
				ps.addBatch();
				if(i%5==0){
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			ps.executeBatch();
			conn.commit();
			System.out.println("题库数据添加完成");
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
				return false;
			} catch (SQLException e1) {
				System.out.println("Data uploadMySQL Error! in"+this.getClass().getName());
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				System.out.println("database close succeed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return false;
	}

	public boolean uploadOneQuestToMySQL(TestQuestions question) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = Constant.sql_uplodadao_uploadOneQuestToMySQL;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setInt(1, question.getQuestScore());
			ps.setString(2, question.getQuestBelongTo());
			ps.setString(3, question.getQuestAnswer());
			ps.setString(4, question.getQuestSubjct());
			ps.setString(5, question.getQuestA());
			ps.setString(6, question.getQuestB());
			ps.setString(7, question.getQuestC());
			ps.setString(8, question.getQuestD());
			if(ps.executeUpdate()==1){
				conn.commit();
				return true;
			}

		} catch (SQLException e) {
			System.out.println("Data uploadOneQuestToMySQL Error! in"+this.getClass().getName());
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
	public void addExamPage(ExamPage exampage) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = Constant.sql_uplodadao_addExamPage;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setLong(1, exampage.getExamId());
			ps.setString(2, exampage.getExamName());
			ps.setInt(3,exampage.getExamChoiceNum());
			ps.setInt(4, exampage.getChoiceScore());
			ps.setInt(5, exampage.getExamjdNum());
			ps.setInt(6, exampage.getJdScore());
			ps.setInt(7, exampage.getExamTime());
			ps.setInt(8, exampage.getExamDif());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {
				System.out.println("database close false:"+this.getClass().getName());
				e1.printStackTrace();
			}
			System.out.println("add exampage false:"+this.getClass().getName());
			e.printStackTrace();
		}
		
	}

	public ExamPage findByexamName(String examName) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ExamPage exampage = null;
		String sql = Constant.sql_uploaddao_findByexamName;
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, examName);
			rs = ps.executeQuery();
			while(rs.next()){
				exampage = new ExamPage();
				exampage.setExamName(rs.getString(Constant.COLUMNNAME_EXAMPAGE_EXAMNAME));
				exampage.setExamChoiceNum(rs.getInt(Constant.COLUMNNAME_EXAMPAGE_CHOICENUM));
				exampage.setChoiceScore(rs.getInt(Constant.COLUMNNAME_EXAMPAGE_CHOCESCORE));
				exampage.setExamjdNum(rs.getInt(Constant.COLUMNNAME_EXAMPAGE_JDNUM));
				exampage.setJdScore(rs.getInt(Constant.COLUMNNAME_EXAMPAGE_JDSCORE));
				exampage.setExamTime(rs.getInt(Constant.COLUMNNAME_EXAMPAGE_TESTTIME));
				exampage.setExamDif(rs.getInt(Constant.COLUMNNAME_EXAMPAGE_DIF));
				exampage.setExamId(rs.getLong(Constant.COLUMNNAME_EXAMPAGE_UNIQUEID));
				
			}
		} catch (SQLException e) {
			System.out.println("Data findByexamName Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("database close false:"+this.getClass().getName());
				e.printStackTrace();
			}
		}
		return exampage;
	}


}
