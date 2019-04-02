package com.zxk1997.px.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.zxk1997.px.common.models.PxUser;



public class DataUtils {
	
	public static PxUser responseResultToUser(ResponseResult r) {
		if(r==null || r.getStatus()!=1)return null;
		Gson g=new Gson();
		String str=g.toJson(r.getInfo());
		PxUser user=g.fromJson(str, PxUser.class);
		return user;
	}
	
	
	
	public static String getCookie(HttpServletRequest req,String name) {
		if(req!=null && req.getCookies()!=null) {
			for(Cookie c :req.getCookies()) {
				if(c.getName().equals(name)) {
					return c.getValue();
				}
			}
		}
		return null;
	}
	
	public static boolean cookieTimeAvailable(String time,int minute) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		try {
			Date d=sdf.parse(time);
			int c = (int) ((new Date().getTime() - d.getTime()) / (1000*60));
			return minute>=c;
		} catch (ParseException e) {
			
		}
		return false;
	}
	
	public static String getCookieTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss");
		return sdf.format(new Date());
	}
	
//	public static HashMap<String, Object> simplePageHandler(HttpServletRequest req,HashMap<String, Object> map,int defaultSize){
//		int page,size;
//		
//		try{
//			if(req.getParameter("p")!=null)page=Integer.parseInt(req.getParameter("p").toString());
//			else page=1;
//		}catch(Exception ex){page=1;}
//		
//		try{
//			if(req.getParameter("l")!=null)size=Integer.parseInt(req.getParameter("l").toString());
//			else size=defaultSize;
//		}catch(Exception ex){size=defaultSize;}
//		size=size>20?20:size;
//		
//		map.put("start", (page-1)*size);
//		map.put("length", size);
//		return map;
//	}
}
