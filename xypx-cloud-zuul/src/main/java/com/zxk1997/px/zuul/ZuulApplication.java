package com.zxk1997.px.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.zxk1997.px.common.Interceptors.FeignInterceptor;
import com.zxk1997.px.common.Interceptors.MyExceptionHandler;

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
	
	/***
	 * 解决跨域
	 * @return
	 */
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOrigin("*");
	    config.addAllowedHeader("*");
	    config.addAllowedMethod("*");
	    config.setMaxAge(18000L);
	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
	
	@Bean
	public MyExceptionHandler exceptionHandler() {
		return new MyExceptionHandler();
	}
	

}
