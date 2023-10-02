package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String cname;
	private boolean active;
	private LocalDateTime createdon;
	public Course() {
		createdon=LocalDateTime.now();
		this.active=true;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + "]";
	}
	
	
}
