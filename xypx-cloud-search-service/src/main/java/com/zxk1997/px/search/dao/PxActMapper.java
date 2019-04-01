package com.zxk1997.px.search.dao;



import java.util.List;

import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;

public interface PxActMapper {
    
    List<PxActDetail> selectByConditions(SearchParm s);

    List<PxActReview> selectByConditionsToReview(SearchParm s);
    
    List<PxActBase> selectByConditionsToBase(SearchParm s);
    
    int selectTotalByConditions(SearchParm s);
    
    List<PxActBase> selectRecList(SearchParm s);
    
    List<PxActReview> selectRecDetailList(SearchParm s);

    int selectRecTotal(SearchParm s);
    
    int selectActJoinTotal(SearchParm s);
    
    List<PxActReview> selectActByUserJoin(SearchParm s);
    
    List<PxUser> selectActJoinUser(SearchParm s);
    
    
}