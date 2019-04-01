package com.zxk1997.px.search.dao;

import java.util.List;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;

public interface PxUserMapper {

    
    List<PxUser> selectByConditions(SearchParm s);
    
    int selectTotalByConditions(SearchParm s);
    
    String selectUserAuthFileById(String id);

}