package com.normal.Model;

import java.io.Serializable;
import java.util.Date;

public class PXUser implements Serializable {
	private static final long serialVersionUID = 585956405634913797L;
	
	private String uid;
	private String u;
	private String p;
	private String icon;
	private String nickname;
	private int status;
	private Date time;
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getU() {
		return u;
	}
	public void setU(String u) {
		this.u = u;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getP() {
		return p;
	}
	public void setP(String p) {
		this.p = p;
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
	
}
