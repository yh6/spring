package com.iot.spring.vo;

public class UserInfoVO {
	
	private int uNo;
	private String uName;
	private String uID;
	private String uPwd;
	private String uEmail;
	private String admin; //char
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserInfoVO [uNo=" + uNo + ", uName=" + uName + ", uID=" + uID + ", uPwd=" + uPwd + ", uEmail=" + uEmail
				+ ", admin=" + admin + "]";
	}
	

}
