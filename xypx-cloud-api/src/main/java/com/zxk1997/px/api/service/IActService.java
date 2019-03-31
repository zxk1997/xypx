package com.zxk1997.px.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.zxk1997.px.common.ServiceName;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxUserPartake;


@FeignClient(ServiceName.activity)
public interface IActService {
	
	@PostMapping("/act/")
	Integer add(PxActivity a);
	
	@PutMapping("/act/")
	Integer edit(PxActivity a);
	
	@DeleteMapping("/act/{id}")
	Integer del(@PathVariable("id") String id,@RequestParam("type") PxActType type);
	
	@PostMapping("/act/partake")
	Integer join(PxUserPartake partake);
	
	@DeleteMapping("/act/partake/{id}")
	Integer unJoin(@PathVariable("id") Integer id);
	
	@PostMapping("/act/rec/")
	Integer addRec(PxActivity a) ;
	
	@DeleteMapping("/act/rec/{aid}")
	Integer delRec(@PathVariable("aid") String aid);
	
}
