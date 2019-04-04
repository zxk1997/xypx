package com.zxk1997.px.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxk1997.px.common.ServiceName;
import com.zxk1997.px.common.enums.PXTagEnum;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxTag;
import com.zxk1997.px.common.models.PxUserPartake;


@FeignClient(ServiceName.activity)
public interface IActService {
	
	/**
	 * 添加一个活动
	 * */
	@PostMapping("/act/")
	Integer add(PxActivity a);
	
	/**
	 * 修改一个活动
	 * */
	@PutMapping("/act/")
	Integer edit(PxActivity a);
	
	/**
	 * 删除一个活动
	 * */
	@DeleteMapping("/act/{id}")
	Integer del(@PathVariable("id") String id,@RequestParam("type") PxActType type);
	
	/**
	 * 用户参加一个活动
	 * */
	@PostMapping("/act/partake")
	Integer join(PxUserPartake partake);
	
	/**
	 * 用户取消参加一个活动
	 * */
	@DeleteMapping("/act/partake/{id}")
	Integer unJoin(@PathVariable("id") Integer id);
	
	
	@DeleteMapping("/partake")
	Integer unJoinByObj(PxUserPartake p);
	
	/**
	 * 添加一个推送
	 * */
	@PostMapping("/act/rec/")
	Integer addRec(PxActivity a) ;
	
	/**
	 * 删除一个推送
	 * */
	@DeleteMapping("/act/rec/{aid}")
	Integer delRec(@PathVariable("aid") String aid);
	
	/**
	 * 添加一个标签
	 * */
	@PostMapping("/act/tag")
	Integer addTag(@RequestBody PxTag t,@RequestParam("type") PXTagEnum type);
	
	/**
	 * 删除一个标签
	 * */
	@DeleteMapping("/act/tag")
	Integer delTag(@RequestBody PxTag t,@RequestParam("type") PXTagEnum type);
	
	/**
	 * 编辑一个标签
	 * */
	@PutMapping("/act/tag")
	Integer editTag(@RequestBody PxTag t,@RequestParam("type") PXTagEnum type);
	
}
