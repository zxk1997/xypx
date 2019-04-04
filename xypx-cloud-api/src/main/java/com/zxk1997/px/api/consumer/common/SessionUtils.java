package com.zxk1997.px.api.consumer.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.zxk1997.px.common.models.PxUser;



public class SessionUtils {
	private static final String USER = "user";



	public static PxUser getCurUser(HttpServletRequest req) {
		return req.getAttribute(USER) != null ? (PxUser) req.getAttribute(USER) : null;
	}

	public static String getCurUid(HttpServletRequest req) {
		PxUser user = getCurUser(req);
		return user != null ? user.getId() : null;
	}

	public static String getCurUserName(HttpServletRequest req) {
		PxUser user = getCurUser(req);
		return user != null ? user.getU() : null;
	}
	
	public static void setAttribute(HttpServletRequest req,String name,Object value) {
		req.getSession().setAttribute(name, value);
	}
	
	public static Object gettAttribute(HttpServletRequest req,String name) {
		return req.getSession().getAttribute(name);
	}	

	public static void logOut(HttpServletRequest req) {
		req.getSession().invalidate();
	}

}
