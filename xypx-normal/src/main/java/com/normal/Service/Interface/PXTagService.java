package com.normal.Service.Interface;



import java.util.Map;

import org.springframework.cache.annotation.Cacheable;

import com.normal.Enums.PXTagEnum;



public interface PXTagService {
	
	//获取所有标签
	public Map<String, String> getTags(PXTagEnum type);
	

	
}
