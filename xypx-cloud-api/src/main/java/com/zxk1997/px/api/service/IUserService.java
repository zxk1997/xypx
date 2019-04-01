package com.zxk1997.px.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxk1997.px.common.ServiceName;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.ResponseResult;

@FeignClient(ServiceName.user)
public interface IUserService {
	
	/**
	 * 用户登录
	 * */
	@PostMapping("/user/login")
	ResponseResult login( PxUser u) ;
	
	/**
	 * 获取一个用户的信息
	 * */
	@GetMapping("/user/{id}")
	ResponseResult getUser(@PathVariable("id") String id);
	
	/**
	 * 修改用户信息
	 * */
	@PutMapping("/user/")
	ResponseResult editUser(PxUser u) ;
	
	/**
	 * 删除一个用户
	 * */
	@DeleteMapping("/user/{id}")
	ResponseResult delUser(@PathVariable("id") String id);
	
	/**
	 * 注册用户
	 * */
	@PostMapping("/user/")
	ResponseResult reg(PxUser u);
	
	/**
	 * 添加用户的证件信息
	 * */
	@PostMapping("/user/auth")
	ResponseResult addAuth(PxUser u,@RequestParam("img")String imgUrl);
}
