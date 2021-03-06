package com.zxk1997.px.activity;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zxk1997.px.common.Interceptors.ServiceAuth;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.zxk1997.px.activity.dao")
public class ActivityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityServiceApplication.class, args);

	}
	
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
			}
			
		};
	}

}
