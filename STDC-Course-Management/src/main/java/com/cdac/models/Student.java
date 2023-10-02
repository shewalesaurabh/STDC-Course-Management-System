package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.BeanUtils;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	private String city;
	private String gender;
	@ManyToOne
	@JoinColumn(name="cid")
	private Course course;
	private String email;
	private boolean active;
	private LocalDateTime createdon;
	
	public Student() {
		this.createdon=LocalDateTime.now();
		this.active=true;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "Student [rollno=" + rollno + ", name=" + name + ", city=" + city + ", gender=" + gender + ", course="
				+ course + ", email=" + email + ", active=" + active + ", createdon=" + createdon + "]";
	}
	
	public static Student toEntity(StudentDTO dto) {
		Student entity=new Student();
		BeanUtils.copyProperties(dto, entity);		
		return entity;
	}
}
