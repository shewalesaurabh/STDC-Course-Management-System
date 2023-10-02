package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Material {

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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Faculty getInstructor() {
		return faculty;
	}
	public void setInstructor(Faculty faculty) {
		this.faculty = faculty;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
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
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Material [id=" + id + ", instructor=" + faculty + ", subject=" + subject + ", filename=" + filename
				+ ", createdon=" + createdon + ", active=" + active + "]";
	}
	public Material() {
		// TODO Auto-generated constructor stub
		this.createdon=LocalDateTime.now();
		this.active=true;
	}
	
	
}
