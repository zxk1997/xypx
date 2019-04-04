package com.zxk1997.px.api.consumer.Service.Interface;



import java.util.Map;

import com.zxk1997.px.common.enums.PXTagEnum;



public interface PXTagService {
	
	//获取所有标签
	public Map<String,String> getTags(PXTagEnum type);
	

	
}
