package com.zxk1997.px.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zxk1997.px.common.Interceptors.MyExceptionHandler;

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

}
