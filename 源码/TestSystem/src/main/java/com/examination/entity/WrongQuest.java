package com.examination.entity;

public class WrongQuest {
	private Integer errorId;
	private String errorBelong;
	private String errorSub;
	private String userCode;
	private Integer errorNum;
	private Double errorRate;
	public Double getErrorRate() {
		return errorRate;
	}
	public void setErrorRate(Double errorRate) {
		this.errorRate = errorRate;
	}
	public Integer getErrorId() {
		return errorId;
	}
	public void setErrorId(Integer errorId) {
		this.errorId = errorId;
	}
	public String getErrorSub() {
		return errorSub;
	}
	public void setErrorSub(String errorSub) {
		this.errorSub = errorSub;
	}
	public String getErrorBelong() {
		return errorBelong;
	}
	public void setErrorBelong(String errorBelong) {
		this.errorBelong = errorBelong;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public Integer getErrorNum() {
		return errorNum;
	}
	public void setErrorNum(Integer errorNum) {
		this.errorNum = errorNum;
	}
	public WrongQuest(Integer errorId, String errorBelong, String errorSub, String userCode, Integer errorNum,
			Double errorRate) {
		super();
		this.errorId = errorId;
		this.errorBelong = errorBelong;
		this.errorSub = errorSub;
		this.userCode = userCode;
		this.errorNum = errorNum;
		this.errorRate = errorRate;
	}
	public WrongQuest() {
		super();
	}
	@Override
	public String toString() {
		return "WrongQuest [errorId=" + errorId + ", errorBelong=" + errorBelong + ", errorSub=" + errorSub
				+ ", userCode=" + userCode + ", errorNum=" + errorNum + ", errorRate=" + errorRate + "]";
	}


}
