package com.normal.Model;

import java.util.Date;
public class PXAct extends ActContainer {
	private Date time;
	private int status;
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
