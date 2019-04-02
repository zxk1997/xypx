package com.zxk1997.px.common.Interceptors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;


public class FeignInterceptor implements RequestInterceptor {

	@Value("${authKey}")
	private String key;
	
	@Override
	public void apply(RequestTemplate template) {
		template.header("auth", key);
	}

}
