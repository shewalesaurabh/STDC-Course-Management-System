package com.cdac.dto;

public class SubjectDTO {
	private String sname;
	private int cid;
	
	public String getSname() {
		return sname;
	}


	public void setSname(String sname) {
		this.sname = sname;
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	@Override
	public String toString() {
		return "SubjectDTO [sname=" + sname + ", cid=" + cid + "]";
	}
	
	
}
