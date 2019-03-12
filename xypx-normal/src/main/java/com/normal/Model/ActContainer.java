package com.normal.Model;



import java.util.Date;
import java.util.HashMap;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

public class ActContainer {
	private String id;
	private String title;//标题
	private String address;//活动地点
	private String phone;//主办方手机
	
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm" )
	private Date s,e;//活动开始/结束时间
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm" )
	private Date ps,pe;//报名开始/结束时间
	
	private String placard;//海报链接
	private int plimit;//人数上限
	private String describe;//活动/讲座内容简述
	private String content;//活动/讲座内容
	private String[] tags1,tags2;//活动/讲座标签，人群标签
	private String rm;//报名成功后提示信息
	
	private int joincnt;
	
	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}
	private  HashMap<String, Object> map=new HashMap<>();
	
	private String stirngCheck(String value,String key,String name,int maxLen){
		if(value!=null){
			int len = value.length();
			if(len>0)
				if(maxLen>=len){
					map.put(key, value);
					return "";
				}else return name+"的长度不能超过"+maxLen+" ";
		} 
		return name+"不能为空 ";
	}
	
	private String dateCheck(Date sdate,String sname,Date  edate,String ename,String name){
		if(sdate!=null && edate!=null && sdate.getTime()<edate.getTime() && edate.getTime()>new Date().getTime()){
			map.put(sname, sdate);
			map.put(ename, edate);
			return "";
		}
		return name+" ";
	}
	
	
	public String check(){
		String str="";
		str+=stirngCheck(title,"title","标题",50);
		str+=stirngCheck(address,"address","地点",200);
		str+=stirngCheck(phone,"phone","手机号码",11);
		str+=dateCheck(s,"s",e,"e","活动/讲座时间设置错误");
		str+=dateCheck(ps,"ps",pe,"pe","报名时间设置错误");
		str+=stirngCheck(placard,"placard","海报",100);
		
		if(plimit<0)str+="人数上限设置错误 ";
		else map.put("plimit", plimit);
		
		str+=stirngCheck(describe,"summary","描述",100);
		
		if(content!=null)map.put("content", content);
		else str+="内容错误 ";
		
		if(tags1!=null && tags2!=null && tags1.length>0&& tags2.length>0){
			map.put("tags1", tags1);
			map.put("tags2", tags2);
		}else str+="标签不能为空  ";
		
		if(rm==null || rm.length()<100)map.put("rm", rm);
		else str+="报名成功提示信息过长 ";
		
		return str;
	}
	
	
	
	public int getJoincnt() {
		return joincnt;
	}

	public void setJoincnt(int joincnt) {
		this.joincnt = joincnt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getS() {
		return s;
	}

	public void setS(Date s) {
		this.s = s;
	}
	public Date getE() {
		return e;
	}
	public void setE(Date e) {
		this.e = e;
	}
	public Date getPs() {
		return ps;
	}
	public void setPs(Date ps) {
		this.ps = ps;
	}
	public Date getPe() {
		return pe;
	}
	public void setPe(Date pe) {
		this.pe = pe;
	}
	public String getPlacard() {
		return placard;
	}
	public void setPlacard(String placard) {
		this.placard = placard;
	}
	public int getPlimit() {
		return plimit;
	}
	public void setPlimit(int plimit) {
		this.plimit = plimit;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	
	
	
}
