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
	
	@PostMapping("/user/login")
	ResponseResult login( PxUser u) ;
	
	@GetMapping("/user/{id}")
	ResponseResult getUser(@PathVariable("id") String id);
	
	@PutMapping("/user/")
	ResponseResult editUser(PxUser u) ;
	
	@DeleteMapping("/user/{id}")
	ResponseResult delUser(@PathVariable("id") String id);
	
	@PostMapping("/user/")
	ResponseResult reg(PxUser u);
	
	@PostMapping("/user/auth")
	ResponseResult addAuth(PxUser u,@RequestParam("img")String imgUrl);
}
