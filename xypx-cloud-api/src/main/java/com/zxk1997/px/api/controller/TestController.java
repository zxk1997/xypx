package com.zxk1997.px.api.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.RandomUtils;
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
	
	@GetMapping("/login")
	public ResponseResult login(HttpServletResponse resp) {
		//判断用户信息是否存在， 存在就直接返回
		PxUser u=new PxUser();
		
		u.setU("kdhuuw75");
		u.setP("4746191fed3ee8528573fd053991bdbd");
		
		ResponseResult result=user.login(u);
		if(result.getStatus()==1) {
			//用户信息验证通过
			String uuid=RandomUtils.getUUID();
			if(user.writeLoginInfo(DataUtils.responseResultToUser(result), uuid).getStatus()==1) {
				//写入redis成功
				Cookie session=new Cookie("s", uuid);
				session.setPath("/");
				Cookie time=new Cookie("t", DataUtils.getCookieTime());
				time.setPath("/");
				resp.addCookie(session);
				resp.addCookie(time);
				result=ResponseResult.success();
				
			}else {
				result=ResponseResult.error("系统繁忙，请重试！");
			}
		}else {
			result=ResponseResult.error("登录失败，请检查用户名和密码");
		}
		
		return result;
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
