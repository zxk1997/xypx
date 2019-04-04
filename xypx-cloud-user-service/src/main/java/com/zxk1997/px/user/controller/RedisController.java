package com.zxk1997.px.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.common.utils.ResponseResult;
import com.zxk1997.px.user.service.RedisService;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
	RedisService redis;
	
	@PostMapping("/")
	public ResponseResult add(String name,String value,int sec) {
		if(redis.set(name, value, sec)) {
			return ResponseResult.success();
		}
		return ResponseResult.error();
	}
	
	@PostMapping("/obj")
	public ResponseResult addObj(String name,@RequestBody Object value,int sec) {
		if(redis.set(name, value, sec)) {
			return ResponseResult.success();
		}
		return ResponseResult.error();
	}
	
	@DeleteMapping("/{name}")
	public ResponseResult del(@PathVariable("name") String name) {
		redis.del(name);
		return ResponseResult.success();
	}
	
	@GetMapping("/{name}")
	public ResponseResult get(@PathVariable("name") String name) {
		String obj=redis.getByString(name);
		if(obj!=null) return ResponseResult.success(obj);
		return ResponseResult.error();
	}

	@GetMapping("/obj/{name}")
	public ResponseResult getObj(@PathVariable("name") String name) {
		Object obj=redis.get(name);
		if(obj!=null) return ResponseResult.success(obj);
		return ResponseResult.error();
	}
	
	@PutMapping("/{name}")
	public ResponseResult ref(@PathVariable("name") String name,@RequestParam("sec")int sec) {
		ResponseResult result=new ResponseResult();
		result.setStatus(redis.expire(name, sec)?1:0);
		return result;
	}
	
}
