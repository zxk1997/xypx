package com.zxk1997.px.common.models;

import java.util.Date;

public class PxActDetail extends PxActReview {
	private Date endTime;
	private String address;
	private int plimit;
	private String content;
	private Date ps;
	private Date pe;
	
	
	public Date getPs() {
		return ps;
	}
	public void setPs(Date ps) {
		this.ps = ps;
	}
	public Date getPe() {
		return pe;
	}
	public void setPe(Date pe) {
		this.pe = pe;
	}
	private int lb;
	public int getLb() {
		return lb;
	}
	public void setLb(int lb) {
		this.lb = lb;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public int getPlimit() {
		return plimit;
	}
	public void setPlimit(int plimit) {
		this.plimit = plimit;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
