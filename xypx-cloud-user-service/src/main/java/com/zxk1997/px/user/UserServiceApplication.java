package com.zxk1997.px.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zxk1997.px.common.Interceptors.MyExceptionHandler;
import com.zxk1997.px.common.Interceptors.ServiceAuth;

@SpringBootApplication
@MapperScan("com.zxk1997.px.user.dao")
@EnableEurekaClient
@EnableTransactionManagement
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
	
	
	@Bean
	public MyExceptionHandler exHandler() {
		return new MyExceptionHandler();
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
