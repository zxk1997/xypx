package com.zxk1997.px.common.models;

import java.util.Date;

public class SearchParm {
	private String id;//活动id
	private String host;//活动主办方id
	private String uid;//用户id
	private String[] tags1;//活动标签
	private String[] tags2;//性格标签
	private String str;//搜索字符
	private Date starttime;//开始时间
	private Integer status;//通过状态
	private Integer type;//活动类型
	private Integer start;//分页开始位置
	private Integer length;//每页长度
	private Object obj;//附加
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
}
