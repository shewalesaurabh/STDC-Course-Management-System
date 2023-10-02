package com.cdac.dto;

public class RegisterDTO {

	private int id;
	private String role;
	private String uname;
	private String userid;
	private String pwd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "RegisterDTO [id=" + id + ", role=" + role + ", uname=" + uname + ", userid=" + userid + ", pwd=" + pwd
				+ "]";
	}
	
	
}
