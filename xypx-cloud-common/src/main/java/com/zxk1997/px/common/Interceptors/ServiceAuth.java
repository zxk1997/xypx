package com.zxk1997.px.common.Interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

public class ServiceAuth implements HandlerInterceptor {

	@Value("${authKey}")
	private String key;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authKey=request.getHeader("auth");
		return authKey!=null && authKey.equals(key);
	}

}
