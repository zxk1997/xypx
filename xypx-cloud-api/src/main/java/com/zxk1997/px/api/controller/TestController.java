package com.zxk1997.px.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.ResponseResult;


@RestController
public class TestController {
	
	Logger log=LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	IUserService user;
	
	@GetMapping("/test")
	public ResponseResult test() {
		PxUser u=new PxUser();
		u.setU("kdhuuw75");
		u.setP("4746191fed3ee8528573fd053991bdbd");
		return user.login(u);
	}
	
	@GetMapping("/info")
	public ResponseResult info(HttpServletRequest req) {
		PxUser u=null;
		Object obj=req.getAttribute("user");
		if(obj!=null) {
			log.info("找到了user"+obj);
			u=(PxUser)obj;
		}else {
			log.info("没找到user"+obj);
		}

		return ResponseResult.success(u);
	}
}
