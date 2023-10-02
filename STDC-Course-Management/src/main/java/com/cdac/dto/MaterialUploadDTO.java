package com.cdac.dto;

import org.springframework.web.multipart.MultipartFile;

public class MaterialUploadDTO {

	private int sid;
	private MultipartFile material;
	private int cid;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	@Override
	public String toString() {
		return "MaterialUploadDTO [sid=" + sid + ", material=" + material + "]";
	}
	
	
}
