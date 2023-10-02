package com.cdac.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class AssignmentDTO {
	private int sid;
	private MultipartFile material;
	private int cid;
	private int marks;
	@JsonFormat(pattern = "YYYY-MM-dd",shape = Shape.STRING)
	private LocalDate submitdate;
	
	public LocalDate getSubmitdate() {
		return submitdate;
	}
	public void setSubmitdate(LocalDate submitdate) {
		this.submitdate = submitdate;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public MultipartFile getMaterial() {
		return material;
	}
	public void setMaterial(MultipartFile material) {
		this.material = material;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "AssignmentDTO [sid=" + sid + ", material=" + material + ", cid=" + cid + ", marks=" + marks
				+ ", submitdate=" + submitdate + "]";
	}
	
	
}
