package com.zxk1997.px.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zxk1997.px.api.interceptors.UserAuth;
import com.zxk1997.px.common.Interceptors.FeignInterceptor;
import com.zxk1997.px.common.Interceptors.ServiceAuth;



@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages="com.zxk1997.px.api.service")
public class ApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);

	}
	
	/**
	 * feign拦截器，用于添加认证头部
	 * */
	@Bean
	public FeignInterceptor feignInterceptor() {
		return new FeignInterceptor();
	}
	
	/**
	 * service的拦截器，用于验证请求是否安全
	 * */
	@Bean
	public ServiceAuth auth() {
		return new ServiceAuth();
	}
	
	@Bean
	public WebMvcConfigurer mvcConfig(ServiceAuth auth) {
		return new WebMvcConfigurer() {

			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				registry.addInterceptor(auth).addPathPatterns("/**");
				registry.addInterceptor(new UserAuth()).addPathPatterns("/**");
			}
			
		};
	}

}
