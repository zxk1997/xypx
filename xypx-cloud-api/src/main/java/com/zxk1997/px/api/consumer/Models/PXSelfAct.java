package com.zxk1997.px.api.consumer.Models;



import java.util.Date;

import com.zxk1997.px.common.models.PxActReview;

public class PXSelfAct {
	private String id;
	private String placard;
	private String name;
	private String host;
	private Date starttime;
	private String address;
	private int acttype;
	private int status;
	private int type;//参与或者发布
	
	public static PXSelfAct convert(PxActReview r) {
		PXSelfAct p=new PXSelfAct();
		p.setId(r.getId());
		p.setPlacard(r.getPlacard());
		p.setName(r.getName());
		p.setHost(r.getHost());
		p.setStarttime(r.getStartTime());
		p.setActtype(r.getType());
		p.setStatus(r.getStatus());
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getActtype() {
		return acttype;
	}
	public void setActtype(int acttype) {
		this.acttype = acttype;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
