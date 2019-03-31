package com.zxk1997.px.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.zxk1997.px.common.ServiceName;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxUserPartake;


@FeignClient(ServiceName.activity)
public interface IActService {
	
	@PostMapping("/act/")
	public Integer add(PxActivity a);
	
	@PutMapping("/act/")
	public Integer edit(PxActivity a);
	
	@DeleteMapping("/act/{id}")
	public Integer del(@PathVariable("id") String id,PxActType type);
	
	@PostMapping("/act/partake")
	public Integer join(PxUserPartake partake);
	
	@DeleteMapping("/act/partake/{id}")
	public Integer unJoin(@PathVariable("id") Integer id);
}
