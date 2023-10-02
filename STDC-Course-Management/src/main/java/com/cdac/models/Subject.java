package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	@ManyToOne
	@JoinColumn(name="cid")
	private Course course;
	private LocalDateTime createdon;
	private boolean active;
	
	public Subject() {
		this.createdon=LocalDateTime.now();
		this.active=true;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
