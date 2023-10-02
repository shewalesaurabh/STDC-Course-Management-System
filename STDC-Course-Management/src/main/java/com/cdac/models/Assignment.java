package com.cdac.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="lid")
	private Faculty faculty;
	@ManyToOne
	@JoinColumn(name="subid")
	private Subject subject;
	@ManyToOne
	@JoinColumn(name="cid")
	private Course course;
	private String filename;
	private LocalDateTime createdon;
	private boolean active;
	private int marks;
	private LocalDate submitdate;
	
	public LocalDate getSubmitdate() {
		return submitdate;
	}
	public void setSubmitdate(LocalDate submitdate) {
		this.submitdate = submitdate;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
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
	public Assignment() {
		// TODO Auto-generated constructor stub
		this.createdon=LocalDateTime.now();
		this.active=true;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
}
