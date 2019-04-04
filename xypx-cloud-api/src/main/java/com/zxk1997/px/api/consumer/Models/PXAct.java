package com.zxk1997.px.api.consumer.Models;

import java.util.Date;

import com.zxk1997.px.common.models.PxAct;
public class PXAct extends ActContainer {
	private Date time;
	private int status;
	
	public  PxAct convert() {
		PxAct a=new PxAct();
		a.setId(this.getId());
		a.setTitle(this.getTitle());
		a.setAddress(this.getAddress());
		a.setPhone(this.getPhone());
		a.setS(this.getS());
		a.setE(this.getE());
		a.setPs(this.getPs());
		a.setPe(this.getPe());
		a.setPlacard(this.getPlacard());
		a.setPlimit(this.getPlimit());
		a.setSummary(this.getDescribe());
		a.setRm(this.getRm());
		a.setTime(this.getTime());
		a.setContent(this.getContent());
		return a;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
