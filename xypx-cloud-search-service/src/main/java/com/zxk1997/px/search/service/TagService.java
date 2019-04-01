package com.zxk1997.px.search.service;

import java.util.List;

import com.zxk1997.px.common.models.PxTag;
import com.zxk1997.px.common.models.SearchParm;

public interface TagService {
    List<PxTag> selectTagsByConditions(SearchParm s);
    
    int selectTagTotalByConditions(SearchParm s);
}
