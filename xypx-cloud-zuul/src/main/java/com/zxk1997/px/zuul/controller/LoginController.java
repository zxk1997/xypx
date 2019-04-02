package com.zxk1997.px.zuul.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.RandomUtils;
import com.zxk1997.px.common.utils.ResponseResult;
import com.zxk1997.px.zuul.feign.IUserService;

@RestController
public class LoginController {
	
	@Autowired
	IUserService user;
	
	@GetMapping("/login")
	public ResponseResult login(HttpServletResponse resp) {
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
				Cookie time=new Cookie("t", DataUtils.getCookieTime());
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
}
