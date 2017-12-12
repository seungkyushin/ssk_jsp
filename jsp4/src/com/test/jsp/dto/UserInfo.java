package com.test.jsp.dto;

public class UserInfo {

	private String  userName;
	private String  userId;
	private String  userPwd;
	private String  userAddress;
	private Integer userNo;
	private Integer userAge;
	private Integer diNo;
	
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", userId=" + userId + ", userPwd=" + userPwd + ", userAddress="
				+ userAddress + ", userNo=" + userNo + ", userAge=" + userAge + ", diNo=" + diNo + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Integer getUserNo() {
		return userNo;
	}
	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}
	public Integer getUserAge() {
		return userAge;
	}
	public void setUserAge(Integer userAge) {
		this.userAge = userAge;
	}
	public Integer getDiNo() {
		return diNo;
	}
	public void setDiNo(Integer diNo) {
		this.diNo = diNo;
	}
	
	
		
	
}
