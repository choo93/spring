package org.kh.member.model.vo;

public class Member {
	private String userId;
	private String userPw;
	private String userName;
	private String userPhone;
	
	public Member() {
		super();
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	
	@Override
	public String toString() {
		return "userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userPhone=" + userPhone;
	}
	
	
}
