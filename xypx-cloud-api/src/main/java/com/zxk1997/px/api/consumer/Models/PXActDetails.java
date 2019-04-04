package com.zxk1997.px.api.consumer.Models;

import com.zxk1997.px.common.models.PxActDetail;

public class PXActDetails extends ActDetails {
	public static PXActDetails convert(PxActDetail d) {
		PXActDetails a=new PXActDetails();
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
		return a;
	}
}
