package com.zxk1997.px.user.controller;

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
import com.zxk1997.px.user.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService user;
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@PostMapping("/login")
	public ResponseResult login(@RequestBody @Validated PxUser u) {
		return user.login(u);
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
