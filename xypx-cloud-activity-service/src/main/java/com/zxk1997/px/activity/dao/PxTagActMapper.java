package com.zxk1997.px.activity.dao;

import com.zxk1997.px.common.models.PxTag;

public interface PxTagActMapper {
	PxTag selectByName(PxTag record);
    int deleteByPrimaryKey(PxTag record);
    int insertSelective(PxTag record);
    int updateByPrimaryKeySelective(PxTag record);
    
    
}