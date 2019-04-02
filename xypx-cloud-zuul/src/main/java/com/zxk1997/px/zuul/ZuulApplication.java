package com.zxk1997.px.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.zxk1997.px.common.Interceptors.FeignInterceptor;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableZuulProxy
@EnableFeignClients(basePackages="com.zxk1997.px.zuul.feign")
public class ZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);

	}
	/**
	 * feign拦截器，用于添加认证头部
	 * */
	@Bean
	public FeignInterceptor feignInterceptor() {
		
		return new FeignInterceptor();
	}
	
	

}
