package com.normal.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.normal.Model.PXUser;

public class SessionUtils {
	private static final String USER = "user";

	public static void initUserSession(HttpServletRequest req, PXUser user) {
		HttpSession session = req.getSession();
		session.setMaxInactiveInterval(-1);// 设置会话不超时
		session.setAttribute(USER, user);
	}

	public static PXUser getCurUser(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		return session != null ? (PXUser) session.getAttribute(USER) : null;
	}

	public static String getCurUid(HttpServletRequest req) {
		PXUser user = getCurUser(req);
		return user != null ? user.getUid() : null;
	}

	public static String getCurUserName(HttpServletRequest req) {
		PXUser user = getCurUser(req);
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
