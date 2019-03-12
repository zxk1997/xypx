package com.normal.Model;



import java.util.Date;

public class PXSelfAct {
	private String id;//娲诲姩(璁插骇鐨刬d)
	private String placard;//灏侀潰
	private String name;//娲诲姩鍚嶇О
	private String host;//娲诲姩涓诲姙鏂�
	private Date starttime;//寮�濮嬫椂闂�
	private String address;//娲诲姩鍦扮偣
	private int acttype;//娲诲姩绫诲瀷
	private int status;//娲诲姩鐘舵��
	private int type;//鍙備笌鏂瑰紡
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
