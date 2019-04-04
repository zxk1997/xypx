package com.zxk1997.px.api.consumer.Controller;




import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.api.consumer.Service.Interface.PXTagService;
import com.zxk1997.px.common.enums.PXTagEnum;
import com.zxk1997.px.common.utils.ResponseResult;

@RestController
public class PXTagController {

	@Resource
	PXTagService pxTag;
	
	@GetMapping("/tag/{type}")
	public ResponseResult getTagsList(@PathVariable String type){
		ResponseResult result=new ResponseResult();
		PXTagEnum t=type.equals("0")?PXTagEnum.ACT:PXTagEnum.PERS;
		result.setInfo(pxTag.getTags(t));
		return result;
	}
}
