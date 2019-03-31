package com.zxk1997.px.activity.dao;

import java.util.List;
import java.util.Map;

import com.zxk1997.px.common.models.PxAct;
import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;

public interface PxActMapper {
    int deleteByPrimaryKey(String id);

    int insert(PxAct record);

    int insertSelective(PxAct record);

    PxAct selectByPrimaryKey(String id);
    
    List<PxActDetail> selectByConditions(Map<String, Object> map);

    List<PxActReview> selectByConditionsToReview(Map<String, Object> map);
    
    List<PxActBase> selectByConditionsToBase(Map<String, Object> map);
    
    int selectTotalByConditions(Map<String, Object> map);
    
    List<PxActBase> selectPushByConditions(Map<String, Object> map);

    int selectPushTotalByConditions(Map<String, Object> map);
    
    int updateByPrimaryKeySelective(PxAct record);

    int updateByPrimaryKeyWithBLOBs(PxAct record);

    int updateByPrimaryKey(PxAct record);
}