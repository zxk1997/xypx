package com.zxk1997.px.api.consumer.Models;


import java.util.Date;

import com.zxk1997.px.common.models.PxActReview;

public class PXActInfoToSearch {
	private String id;
	private String placard;
	private String title;
	private Date st;
	private Date et;
	private String summary;
	private String icon;
	private String nickname;
	private Date time;
	private int act_type;
	
	public static PXActInfoToSearch convert(PxActReview r) {
		PXActInfoToSearch p=new PXActInfoToSearch();
		p.setId(r.getId());
		p.setPlacard(r.getPlacard());
		p.setTitle(r.getName());
		p.setSt(r.getStartTime());
		p.setSummary(r.getSummary());
		p.setIcon(r.getIcon());
		p.setNickname(r.getHost());
		p.setTime(r.getStartTime());
		p.setAct_type(r.getType());
		return p;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPlacard() {
		return placard;
	}
	public void setPlacard(String placard) {
		this.placard = placard;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getSt() {
		return st;
	}
	public void setSt(Date st) {
		this.st = st;
	}
	public Date getEt() {
		return et;
	}
	public void setEt(Date et) {
		this.et = et;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getAct_type() {
		return act_type;
	}
	public void setAct_type(int act_type) {
		this.act_type = act_type;
	}
	
	
}
