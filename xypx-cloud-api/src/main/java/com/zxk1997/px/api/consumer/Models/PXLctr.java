package com.zxk1997.px.api.consumer.Models;



import java.util.Date;

import com.zxk1997.px.common.models.PxLctr;

public class PXLctr extends ActContainer {
	private int lb;
	private Date time;
	private int status;
	
	public  PxLctr convert() {
		PxLctr a=new PxLctr();
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
		a.setLb(this.getLb());
		return a;
	}
	
	public int getLb() {
		return lb;
	}

	public void setLb(int lb) {
		this.lb = lb;
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
