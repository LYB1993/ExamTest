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
import com.examination.entity.AnswerSheet;
import com.examination.entity.Score;
import com.examination.entity.User;
import com.examination.entity.WrongQuest;

@SuppressWarnings("restriction")
@Repository("questScoreDAO")
public class QuestScoreDAOJdbcImpl implements QuestScoreDAO{
	
	@Resource(name="ds")
	private DataSource ds;
	
	
	public List<Score> findBySno(Long sno) {
		List<Score> Slist = new ArrayList<Score>();
		Connection conn=null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Score score = null;
		try {
			conn = ds.getConnection();
			//String sql = "select * from questscore where sno=?";
			String sql = Constant.sql_questscoredao_findBySno;
			ps = conn.prepareStatement(sql);
			ps.setLong(1, sno);
			rs = ps.executeQuery();
			while(rs.next()){
				score = new Score();
				score.setSujectId(rs.getInt(Constant.COLUMNNAME_QUESTSCORE_ID));
				score.setSujectName(rs.getString(Constant.COLUMNNAME_QUESTSCORE_EXAMNAME));
				score.setSno(rs.getInt(Constant.COLUMNNAME_QUESTSCORE_SNO));
				score.setSname(rs.getString(Constant.COLUMNNAME_QUESTSCORE_USERNAME));
				score.setTime(rs.getDate(Constant.COLUMNNAME_QUESTSCORE_EXAMTIME));
				score.setScore(rs.getInt(Constant.COLUMNNAME_QUESTSCORE_SCORE));
				Slist.add(score);
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
		return Slist;
	}


	public boolean addScore(User user, int score,String examName) {
		Connection conn=null;
		PreparedStatement ps = null;
		try {
			//String sql = "insert into Questscore(Subject,Sno,Sname,Score)values(?,?,?,?)";
			String sql = Constant.sql_questscoredao_addScore;
			conn = ds.getConnection();
			//System.out.println(TQ.getQuestId()+":"+TQ.getQuestBelongTo()+":"+user.getUserNo()+":"+user.getUserName()+":"+score);
			ps = conn.prepareStatement(sql);
			ps.setString(1, examName);
			ps.setLong(2, user.getUserNo());
			ps.setString(3, user.getUserName());
			ps.setInt(4, score);
			ps.execute();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	public List<AnswerSheet> findByCode(String code) {
		List<AnswerSheet> ASlist = new ArrayList<AnswerSheet>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AnswerSheet as = null;
		//String sql = "select * from AnswerSheet where user_code = ?";
		String sql = Constant.sql_questscoredao_findByCode;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, code);
			rs = ps.executeQuery();
			while(rs.next()){
				as = new AnswerSheet();
				as.setAnswerstr(rs.getString(Constant.COLUMNNAME_ANSWERSHEET_CHOICEANSWER));
				as.setOther(rs.getString(Constant.COLUMNNAME_ANSWERSHEET_OTHERANSWER));
				as.setUser_code(rs.getString(Constant.COLUMNNAME_ANSWERSHEET_USERCODE));
				as.setBelong(rs.getString(Constant.COLUMNNAME_ANSWERSHEET_EXAMNAME));
				ASlist.add(as);
				
			}
		} catch (SQLException e) {
			System.out.println("Data findByCode Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ASlist;
	}


	public boolean addAnswerSheet(AnswerSheet as,String Code) {
		Connection conn = null;
		PreparedStatement ps = null;
		//String sql = "insert into answersheet (user_code,belong,answerstr,other) values(?,?,?,?)";
		String sql = Constant.sql_questscoredao_addAnswerSheet;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Code);
			ps.setString(2, as.getBelong());
			ps.setString(3, as.getAnswerstr());
			ps.setString(4, as.getOther());
			if(ps.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Data addAnswerSheet Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


	public List<WrongQuest> findWrongQuest(Float rate,String usercode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<WrongQuest> wrongquest = null;
//		String sql = "SELECT put.* from ("
//				+ "SELECT (w.error_num/u.user_examnum) as rate,"
//				+ "u.user_examnum,w.error_id,"
//				+ "w.error_sub,w.user_code,"
//				+ "w.error_num,w.error_belong "
//				+ "from user u,wrong w "
//				+ "where w.user_code=u.user_code) put where put.rate >=? and u.user_code = ?";
		
		String sql = Constant.sql_questscoredao_findWrongQuest;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			wrongquest = new ArrayList<WrongQuest>();
			ps.setFloat(1, rate);
			ps.setString(2,usercode);
			rs = ps.executeQuery();
			while(rs.next()){
				WrongQuest wq = new WrongQuest();
				wq.setErrorId(rs.getInt(Constant.COLUMNNAME_ERROR_ID));
				wq.setErrorSub(rs.getString(Constant.COLUMNNAME_ERROR_SUB));
				wq.setErrorBelong(rs.getString(Constant.COLUMNNAME_ERROR_EXAMNAME));
				wq.setUserCode(rs.getString(Constant.COLUMNNAME_ERROR_USERCODE));
				wq.setErrorNum(rs.getInt(Constant.COLUMNNAME_ERROR_NUM)); 
				wq.setErrorRate(rs.getDouble("rate"));
				wrongquest.add(wq);
			}
		} catch (SQLException e) {
			System.out.println("Data findWrongQuest Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return wrongquest;
	}


	public boolean addWrongQuest(String examName, String errorSub, String UserCode) {
//		String sqlSelect = "SELECT N_Error_Id,"
//				+ "N_Error_ExamName,"
//				+ "C_Error_Sub,"
//				+ "C_Error_UserCode,"
//				+ "N_Error_Num "
//				+ "FROM t_error WHERE C_Error_Sub = ?";
//		String sqlInsert = "INSERT INTO t_error (N_Error_ExamName,C_Error_Sub,C_Error_UserCode) VALUES(?,?,?)";
//		String sqlUpdate = "update t_error set N_Error_Num = ? where N_error_Id = ?";
		String sqlSelect = Constant.sql_questscoredao_addWrongQuest_Select;
		String sqlInsert = Constant.sql_questscoredao_addWrongQuest_Insert;
		String sqlUpdate = Constant.sql_questscoredao_addWrongQuest_Update;
		Connection conn = null;
		PreparedStatement psSelect = null;
		PreparedStatement psInsert = null;
		PreparedStatement psUpdate = null;
		try {
			conn = ds.getConnection();
			psSelect = conn.prepareStatement(sqlSelect);
			psInsert = conn.prepareStatement(sqlInsert);
			psUpdate = conn.prepareStatement(sqlUpdate);
			psSelect.setString(1, errorSub);
			ResultSet rs = psSelect.executeQuery();
			if(rs.next()){
				if(rs.getString(Constant.COLUMNNAME_ERROR_EXAMNAME).equals(examName)&&
						rs.getString(Constant.COLUMNNAME_ERROR_SUB).equals(errorSub)&&
						rs.getString(Constant.COLUMNNAME_ERROR_USERCODE).equals(UserCode)){
					//执行数据+1
					Integer id = rs.getInt(Constant.COLUMNNAME_ERROR_ID);
					Integer num = rs.getInt(Constant.COLUMNNAME_ERROR_NUM);
					num += 1;
					psUpdate.setInt(1, num);
					psUpdate.setInt(2, id);
					if(psUpdate.executeUpdate()==1){
						return true;
					}
				}else{
					//添加数据
					psInsert.setString(1, examName);
					psInsert.setString(2, errorSub);
					psInsert.setString(3, UserCode);
					if(psInsert.executeUpdate()==1){
						return true;
					}
				}
			}else{
				//添加数据
				psInsert.setString(1, examName);
				psInsert.setString(2, errorSub);
				psInsert.setString(3, UserCode);
				if(psInsert.executeUpdate()==1){
					return true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("addWrongQuest error:" +this.getClass().getName());
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


}
