package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String msg;
	@ManyToOne
	@JoinColumn(name="faculty_id")
	private Faculty faculty;
	private LocalDateTime createdon;
	@ManyToOne
	@JoinColumn(name="rollno")
	private Student student;
	
	public Feedback() {
		this.createdon=LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public LocalDateTime getCreatedon() {
		return createdon;
	}

	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
