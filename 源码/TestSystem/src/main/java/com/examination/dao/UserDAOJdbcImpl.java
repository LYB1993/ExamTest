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
import com.examination.entity.User;


@SuppressWarnings("restriction")
@Repository("userDAO")
public class UserDAOJdbcImpl implements UserDAO{
	
	@Resource(name="ds")
	private DataSource ds;
	
	public User findByUserCode(String userCode) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			//String sql = "select * from user where user_code=?";
			String sql = Constant.sql_userdao_findByUserCode;
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userCode);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(Constant.COLUMNNAME_USER_ID));
				user.setUserCode(rs.getString(Constant.COLUMNNAME_USER_CODE));
				user.setUserPwd(rs.getString(Constant.COLUMNNAME_USER_PWD));
				user.setUserName(rs.getString(Constant.COLUMNNAME_USER_NAME));	
				user.setUserUnmcard(rs.getString(Constant.COLUMNNAME_USER_NUMCARD));
				user.setUserPhone(rs.getString(Constant.COLUMNNAME_USER_PHONENUM));
				user.setUserEmail(rs.getString(Constant.COLUMNNAME_USER_EMAIL));
				user.setUserNo(rs.getInt(Constant.COLUMNNAME_USER_NO));
				user.setUserIdentity(rs.getString(Constant.COLUMNNAME_USER_IDENTITY));
			}
			
		} catch (SQLException e) {
			System.out.println("findByUserCode Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Databases close defeated!");
				e.printStackTrace();
			}
		}
		return user;
	}

	public boolean addUser(User user) {
		Connection conn = null;
		PreparedStatement ps = null;
		//String sql = "insert into user(user_code,user_pwd,user_name,user_no,user_numCard,user_phone,user_email) values(?,?,?,?,?,?,?)";
		String sql = Constant.sql_userdao_addUser;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);			
			ps.setString(1, user.getUserCode());
			ps.setString(2, user.getUserPwd());
			ps.setString(3, user.getUserName());
			ps.setInt(4, user.getUserNo());
			ps.setString(5, user.getUserUnmcard());
			ps.setString(6, user.getUserPhone());
			ps.setString(7, user.getUserEmail());			
			ps.executeUpdate();
			conn.commit();
			return true;
		} catch (SQLException e) {
			System.out.println("addUser Error! in"+this.getClass().getName());
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean editUser(User user) {
		System.out.println(user);
		Connection conn = null;
		PreparedStatement ps = null;
		//String sql = "update User set user_name=?,user_pwd=?,user_numCard=?,user_phone=?, user_email=? where user_id=?";
		String sql = Constant.sql_userdao_editUser;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserPwd());
			ps.setString(3, user.getUserUnmcard());
			ps.setString(4, user.getUserPhone());
			ps.setString(5, user.getUserEmail());
			ps.setInt(6, user.getUserId());
			Integer comm = ps.executeUpdate();
			if(comm==1){
				conn.commit();
				return true;
			}else{
				conn.rollback();
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Data update Error! in"+this.getClass().getName());
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

	public List<User> selectAll() {
		List<User> userall = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		//String sql = "select * from user";
		String sql = Constant.sql_userdao_selectAll;
		try {
			if(!userall.isEmpty()){
				userall.clear();
			}
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				user = new User();
				user.setUserId(rs.getInt(Constant.COLUMNNAME_USER_ID));
				user.setUserCode(rs.getString(Constant.COLUMNNAME_USER_CODE));
				user.setUserPwd(rs.getString(Constant.COLUMNNAME_USER_PWD));
				user.setUserName(rs.getString(Constant.COLUMNNAME_USER_NAME));	
				user.setUserUnmcard(rs.getString(Constant.COLUMNNAME_USER_NUMCARD));
				user.setUserPhone(rs.getString(Constant.COLUMNNAME_USER_PHONENUM));
				user.setUserEmail(rs.getString(Constant.COLUMNNAME_USER_EMAIL));
				user.setUserNo(rs.getInt(Constant.COLUMNNAME_USER_NO));
				user.setUserIdentity(rs.getString(Constant.COLUMNNAME_USER_IDENTITY)); 
				userall.add(user);
			}
		} catch (SQLException e) {
			System.out.println("Data select all user Error! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return userall;
	}

	public boolean delectUser(String userCode) {		
		Connection conn = null;
		PreparedStatement ps = null;
		Integer delete = null;
		//String sql = "delete from user where user_code=?";
		String sql = Constant.sql_userdao_delectUser;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, userCode);
			delete = ps.executeUpdate();
			if(delete==1){
				return true;
			}
			
		} catch (Exception e) {
			System.out.println("Data delete user error ! in"+this.getClass().getName());
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

	public String findpwd(String numcard) {
		if(numcard==""||numcard==null){
			return "身份证号码不能为空";
		}
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String pwd = null;
		//String sql = "select user_pwd from user where user_numcard=?";
		String sql = Constant.sql_userdao_findpwd;
		try {
			conn=ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, numcard);
			rs = ps.executeQuery();
			if(rs.next()){
				pwd = rs.getString(Constant.COLUMNNAME_USER_PWD);
				return pwd;
			}
			return "身份证号码错误";
			
		} catch (SQLException e) {
			System.out.println("Data find pwd error ! in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return "身份证号码错误";
	}

	public Integer addExamNum(String userCode) {
		Connection conn = null;
		PreparedStatement psSelect = null;
		PreparedStatement psUpdate = null;
		ResultSet rs = null;
		//String sqlSelect = "select user_examnum from user where user_code=?";
		//String sqlUpdate = "update user set user_examnum=? where user_code=?";
		
		String sqlSelect = Constant.sql_userdao_addExamNum_select;
		String sqlUpdate = Constant.sql_userdao_addExamNum_update;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			psSelect = conn.prepareStatement(sqlSelect);
			psUpdate = conn.prepareStatement(sqlUpdate);
			psSelect.setString(1, userCode);
			rs = psSelect.executeQuery();
			
			if(rs.next()){
				Integer examNum = rs.getInt(Constant.COLUMNNAME_USER_EXAMNUM)+1;
				psUpdate.setInt(1, examNum);
				psUpdate.setString(2, userCode);
				Integer exam = psUpdate.executeUpdate();
				if(exam==1){
					conn.commit();
				}else{
					conn.rollback();
				}		
			}
			
		} catch (SQLException e) {
			System.out.println("ExamNum add false !in"+this.getClass().getName());
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 1;
	}

	public boolean updateImagePath(String path,String usercode) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = Constant.sql_userdao_updateImage;
		try {
			conn = ds.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Constant.COLUMNNAME_USER_IMAGEPATH);
			ps.setString(2, Constant.COLUMNNAME_USER_CODE);
			if(ps.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			System.out.println("updateImagePath error:"+this.getClass().getName());
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
