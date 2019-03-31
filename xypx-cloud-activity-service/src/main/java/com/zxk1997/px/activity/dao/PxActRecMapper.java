package com.zxk1997.px.activity.dao;

import com.zxk1997.px.common.models.PxActRec;

public interface PxActRecMapper {
	
	PxActRec selectByAid(String aid);
	
    int insert(PxActRec record);

    int insertSelective(PxActRec record);
    
    int deleteByActId(String aid);
}