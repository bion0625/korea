package com.korea.demo.vo.yedana;

import java.sql.Date;

public class YedanaVO {

	private int seq;
	private String address;
	private String name;
	private String orderstatus;
	private String tel;
	private String contents;
	private String del_info;
	private Date created_dtm;
	private Date modified_dtm;

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDel_info() {
		return del_info;
	}
	public void setDel_info(String del_info) {
		this.del_info = del_info;
	}
	public Date getCreated_dtm() {
		return created_dtm;
	}
	public void setCreated_dtm(Date created_dtm) {
		this.created_dtm = created_dtm;
	}
	public Date getModified_dtm() {
		return modified_dtm;
	}
	public void setModified_dtm(Date modified_dtm) {
		this.modified_dtm = modified_dtm;
	}
	
	
	
}
