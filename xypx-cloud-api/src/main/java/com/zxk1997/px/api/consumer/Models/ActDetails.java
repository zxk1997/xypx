package com.zxk1997.px.api.consumer.Models;



import java.util.Date;

import com.zxk1997.px.common.models.PxActDetail;

public class ActDetails {
	private String id;
	private String title;
	private String address;
	private String phone;
	private Date s;
	private Date e;
	private Date ps;
	private Date pe;
	private String placard;
	private int plimit;
	private String describe;
	private String content;
	private String[] tags1;
	private String[] tags2;
	private int joincnt;
	private int status;
	private String ua;
	private String nickname;
	private String icon;
	
	
	
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUa() {
		return ua;
	}
	public void setUa(String ua) {
		this.ua = ua;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getS() {
		return s;
	}
	public void setS(Date s) {
		this.s = s;
	}
	public Date getE() {
		return e;
	}
	public void setE(Date e) {
		this.e = e;
	}
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
	public String getPlacard() {
		return placard;
	}
	public void setPlacard(String placard) {
		this.placard = placard;
	}
	public int getPlimit() {
		return plimit;
	}
	public void setPlimit(int plimit) {
		this.plimit = plimit;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String[] getTags1() {
		return tags1;
	}
	public void setTags1(String[] tags1) {
		this.tags1 = tags1;
	}
	public String[] getTags2() {
		return tags2;
	}
	public void setTags2(String[] tags2) {
		this.tags2 = tags2;
	}
	public int getJoincnt() {
		return joincnt;
	}
	public void setJoincnt(int joincnt) {
		this.joincnt = joincnt;
	}
	
}
