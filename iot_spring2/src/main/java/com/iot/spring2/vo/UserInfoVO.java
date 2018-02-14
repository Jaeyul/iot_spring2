package com.iot.spring2.vo;

import javax.validation.constraints.NotNull;

public class UserInfoVO {	
	private int uiNo;
	private String uiName;
	@NotNull
	private String uiID;
	private String uiPwd;
	private String uiEmail;
	private char admin;
	public int getUiNo() {
		return uiNo;
	}
	public void setUiNo(int uiNo) {
		this.uiNo = uiNo;
	}
	public String getUiName() {
		return uiName;
	}
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	public String getUiID() {
		return uiID;
	}
	public void setUiID(String uiID) {
		this.uiID = uiID;
	}
	public String getUiPwd() {
		return uiPwd;
	}
	public void setUiPwd(String uiPwd) {
		this.uiPwd = uiPwd;
	}
	public String getUiEmail() {
		return uiEmail;
	}
	public void setUiEmail(String uiEmail) {
		this.uiEmail = uiEmail;
	}
	public char getAdmin() {
		return admin;
	}
	public void setAdmin(char admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "UserInfoVO [uiNo=" + uiNo + ", uiName=" + uiName + ", uiID=" + uiID + ", uiPwd=" + uiPwd + ", uiEmail="
				+ uiEmail + ", admin=" + admin + "]";
	}
	
	

}
