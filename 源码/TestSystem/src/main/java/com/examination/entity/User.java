package com.examination.entity;
/**
 * 用户类型
 * 1.userId：用户的Id，用数据库自动生成
 * 2.userCode：用户的登录名
 * 3.userPwd：用户的登陆密码
 * 4.userNo：用户的学号
 * 5.userIdentity：用户的类型（有管理员（ADMIN）和普通用户）
 * 6.userName：用户的姓名
 * 7.userEmainl：用户的邮箱
 * 8.userUnmcard：用户的身份证号码
 * 9.userPhone：用户的手机号码
 * @author 
 *
 */
public class User {
	private Integer userId;
	private String userCode;
	private String userPwd;
	private Long userNo;
	private String userIdentity;
	private String userName;
	private String userEmail;
	private String userUnmcard;
	private String userPhone;
	private String userImagePath;
	
	public User() {
		super();
	}
	public User(Integer userId, String userCode, String userPwd, String userName, Long userNo, String userUnmcard,
			String userPhone,String userEmail) {
		super();
		this.userId = userId;
		this.userCode = userCode;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userUnmcard = userUnmcard;
		this.userPhone = userPhone;
		this.userNo = userNo;
		this.userEmail = userEmail;
	}
	public String getUserIdentity() {
		return userIdentity;
	}
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserUnmcard() {
		return userUnmcard;
	}
	public void setUserUnmcard(String userUnmcard) {
		this.userUnmcard = userUnmcard;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserImagePath() {
		return userImagePath;
	}
	public void setUserImagePath(String userImagePath) {
		this.userImagePath = userImagePath;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userCode=" + userCode + ", userPwd=" + userPwd + ", userNo=" + userNo
				+ ", userIdentity=" + userIdentity + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userUnmcard=" + userUnmcard + ", userPhone=" + userPhone + ", userImagePath=" + userImagePath
				+ "]";
	}
	
	
}
