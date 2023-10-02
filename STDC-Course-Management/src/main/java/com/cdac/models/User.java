package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	private String userid;
	private String uname;
	private String role;
	private String pwd;
	private boolean active;
	private int id;
	private LocalDateTime createdon;
	
	public User(String userid,String pwd,String role,String uname) {
		this.userid=userid;
		this.pwd=pwd;
		this.role=role;
		this.uname=uname;
		this.active=true;
		this.createdon=LocalDateTime.now();
	}
	
	public User() {
		this.createdon=LocalDateTime.now();
		this.active=true;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", uname=" + uname + ", role=" + role + ", pwd=" + pwd + ", active=" + active
				+ ", id=" + id + ", createdon=" + createdon + "]";
	}
	
	
}
