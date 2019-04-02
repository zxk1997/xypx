package com.zxk1997.px.api.interceptors;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.zxk1997.px.common.models.PxUser;

public class UserAuth implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getHeader("user")!=null) {
			
			Gson g=new Gson();
			String str=URLDecoder.decode(request.getHeader("user"), "utf-8");
			PxUser u=g.fromJson(str, PxUser.class);
			request.setAttribute("user", u);
		}
		
		return true;
	}
	
	
}
