package com.zxk1997.px.user.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.groups.Default;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.interfaces.OpType;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.ResponseResult;
import com.zxk1997.px.user.service.RedisService;
import com.zxk1997.px.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService user;
	@Autowired
	RedisService redis;
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/login")
	public ResponseResult login(@RequestBody @Validated PxUser u) {
		ResponseResult result=user.login(u);
		
		return result;
	}
	
	@PostMapping("/login/status/{id}")
	public ResponseResult writeLoginInfo(@RequestBody PxUser u,@PathVariable("id")String id) {
		if(redis.set(id, u, 60*20)) {
			return ResponseResult.success();
		}
		return ResponseResult.error();
	}
	
	//刷新登录状态
	@PutMapping("/login/{id}")
	public ResponseResult refLogin(@PathVariable("id")String id) {
		if(redis.expire(id, 60*20)) {
			return ResponseResult.success();
		}
		return ResponseResult.error();
	}
	
	//根据session id 获取登录信息
	@GetMapping("/login/{id}")
	public ResponseResult getLoginInfo(@PathVariable("id")String id) {
		Object obj=redis.get(id);
		if(obj!=null) {
			return ResponseResult.success(obj);
		}
		return ResponseResult.error();
	}
	
	//根据session id 获取登录信息
	@DeleteMapping("/login/{id}")
	public ResponseResult logout(@PathVariable("id")String id) {
		redis.del(id);
		return ResponseResult.success();
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseResult getUser(@PathVariable("id") String id) {
		if(id!=null) {
			PxUser p=new PxUser();
			p.setId(id);
			p.setU(id);
			return user.getUser(p);
		}
		return ResponseResult.error(ErrorEnum.OP_FAIL);
	}
	
	@PutMapping("/")
	public ResponseResult editUser(@RequestBody @Validated(OpType.U.class) PxUser u) {
		return user.edit(u);
	}
	
	@DeleteMapping("/{id}")
	public ResponseResult delUser(@PathVariable("id") String id) {
		PxUser p=new PxUser();
		p.setId(id);
		return user.edit(p);
	}
	
	
	@PostMapping("/")
	public ResponseResult reg(@RequestBody @Validated({OpType.C.class,Default.class}) PxUser u) {
		return user.login(u);
	}
	
	@PostMapping("/auth")
	public ResponseResult addAuth(@RequestBody PxUser u,@RequestParam("img")String imgUrl) {
		if(u==null) {
			return ResponseResult.error(ErrorEnum.OP_FAIL);
		}
		return user.addAuth(u, imgUrl);
	}
	
	
	
}
