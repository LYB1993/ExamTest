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
/**
 * 实现BelongDAO接口的类
 * @author 
 *
 */
@SuppressWarnings("restriction")
@Repository("belongDAO")
public class BelongDAOJdbclmpl implements BelongDAO{
	
	@Resource(name="ds")
	private DataSource ds;

	public List<String> selectBelong() {
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = "select Quest_Belong from questions group by quest_belong";
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString("Quest_Belong"));
			}
			
		} catch (Exception e) {
			System.out.println("Data selectBelong Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean delete(String deletebelong) {
		Connection conn = null;
		PreparedStatement ps = null;
		Integer delete = null;
		String sql = "delete from questions where Quest_Belong=?";
		
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, deletebelong);
			delete = ps.executeUpdate();
			if(delete==1){
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Data delete Test belong Error! in"+this.getClass().getName());
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
	
	
	public List<String> selectExamPage() {
		List<String> list = new ArrayList<String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//String sql = "select c_exam_name from t_exampage group by c_exam_name";
			String sql = Constant.sql_belongdao_selectExamPage;
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString(Constant.COLUMNNAME_EXAMPAGE_EXAMNAME));
			}
			
		} catch (Exception e) {
			System.out.println("Data c_exam_name Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean deleteByExamPageName(String exampageName) {
		Connection conn = null;
		PreparedStatement ps = null;
		PreparedStatement psDeleteQuest = null;
		Integer delete = null;
		Integer delete2 = null;
		//String sql = "delete from t_exampage where c_exam_name = ?";
		//String sqlquest = "delete from t_examquest where c_exampage_name = ?"; 
		String sql = Constant.sql_belongdao_deleteByExamPageName_delete1;
		String sqlquest = Constant.sql_belongdao_deleteByExamPageName_delete1;
		try {
			conn = ds.getConnection();
			//删除试卷名称表中的数据
			ps = conn.prepareStatement(sql);
			ps.setString(1, exampageName);
			delete = ps.executeUpdate();
			//删除考题数据
			psDeleteQuest = conn.prepareStatement(sqlquest);
			psDeleteQuest.setString(1, exampageName);
			delete2 = psDeleteQuest.executeUpdate();
			if(delete==1 && delete2==1){
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("Data delete Exampage Error! in"+this.getClass().getName());
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

}
