package com.cdac.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Faculty {

	@Id
	private int id;
	private String name;
	private String city;
	private String gender;
	private String email;
	private String qual;
	private boolean active;
	private LocalDateTime createdon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
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
		return "Instructor [id=" + id + ", name=" + name + ", city=" + city + ", gender=" + gender + ", email=" + email
				+ ", qual=" + qual + ", active=" + active + ", createdon=" + createdon + "]";
	}
	public Faculty() {
		this.createdon=LocalDateTime.now();
		this.active=true;
	}
	
	
}
