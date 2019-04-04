package com.zxk1997.px.api.consumer.Models;

import com.zxk1997.px.common.models.PxActDetail;

public class PXLctrDetails extends ActDetails {
	private int lb;

	public int getLb() {
		return lb;
	}

	public void setLb(int lb) {
		this.lb = lb;
	}
	
	public static PXLctrDetails convert(PxActDetail d) {
		PXLctrDetails a=new PXLctrDetails();
		a.setId(d.getId());
		a.setTitle(d.getName());
		a.setAddress(d.getAddress());
		a.setS(d.getStartTime());
		a.setE(d.getEndTime());
		a.setPs(d.getPs());
		a.setPe(d.getPe());
		a.setPlacard(d.getPlacard());
		a.setPlimit(d.getPlimit());
		a.setDescribe(d.getSummary());
		a.setContent(d.getContent());
		a.setStatus(d.getStatus());
		a.setNickname(d.getHost());
		a.setIcon(d.getIcon());
		a.setLb(d.getLb());
		return a;
	}
	
}
