package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String message;
	private LocalDateTime createdon;
	@ManyToOne
	@JoinColumn(name="lid")
	private Faculty faculty;
	private boolean fromAdmin;
	
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public boolean isFromAdmin() {
		return fromAdmin;
	}
	public void setFromAdmin(boolean fromAdmin) {
		this.fromAdmin = fromAdmin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	public Faculty getInstructor() {
		return faculty;
	}
	public void setInstructor(Faculty faculty) {
		this.faculty = faculty;
	}
	
	public Notification() {
		this.createdon=LocalDateTime.now();
	}
}
