package com.normal.Controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.normal.Enums.PXTagEnum;
import com.normal.Service.Interface.PXTagService;
import com.normal.common.ResponseResult;

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
