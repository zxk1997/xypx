package com.zxk1997.px.activity.dao;

import com.zxk1997.px.common.models.PxUserPartake;

public interface PxUserPartakeMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByObj(PxUserPartake record);
    
    int insert(PxUserPartake record);

    int selectByObj(PxUserPartake record);
    
    PxUserPartake selectByPrimaryKey(Integer id);

}