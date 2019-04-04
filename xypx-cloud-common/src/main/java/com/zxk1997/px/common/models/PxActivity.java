package com.zxk1997.px.common.models;

import com.zxk1997.px.common.enums.PxActType;

public class PxActivity {

	private PxAct act;
	private PxLctr lctr;
	private PxActType type;
	
	public PxActivity() {}
	
	public PxActivity(PxActType type,PxAct act) {
		this.act=act;
		this.type=type;
	}
	
	public PxActivity(PxActType type,PxLctr lctr) {
		this.lctr=lctr;
		this.type=type;
	}

	public PxActType getType() {
		return type;
	}
	public void setType(PxActType type) {
		this.type = type;
	}
	public PxAct getAct() {
		return act;
	}
	public void setAct(PxAct act) {
		this.act = act;
	}
	public PxLctr getLctr() {
		return lctr;
	}
	public void setLctr(PxLctr lctr) {
		this.lctr = lctr;
	}
	
	
}
