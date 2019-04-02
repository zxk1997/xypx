package com.zxk1997.px.user;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zxk1997.px.common.Interceptors.MyExceptionHandler;
import com.zxk1997.px.common.Interceptors.ServiceAuth;

@SpringBootApplication
@MapperScan("com.zxk1997.px.user.dao")
@EnableEurekaClient
@EnableTransactionManagement
@EnableScheduling
public class UserServiceApplication {

	Logger log=LoggerFactory.getLogger(UserServiceApplication.class);
	
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
	
	@Autowired
	RedisTemplate<String, Object> redisTemplate;
	
	//使用redis的时候很奇怪，不操作几分钟连接就失效，要重连，网上关于这的问题几乎没有，最后找到一篇相关的文章，也没找到问题，就用定时任务暂时解决
	@Scheduled(cron = "0/10 * * * * *")
    public void timer() {
        redisTemplate.opsForValue().get("heartbeat");
    }

}
