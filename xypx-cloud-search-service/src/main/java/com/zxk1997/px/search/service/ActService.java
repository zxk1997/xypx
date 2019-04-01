package com.zxk1997.px.search.service;

import java.util.List;

import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.PxRecDetail;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;

public interface ActService {

	//获取首页推荐
	List<PxActBase> getRecList(SearchParm s);
	//获取首页推荐 兼容原接口 
	List<PxActReview> getRecDetailList(SearchParm s);
	
	int getActRecCuont(SearchParm s);
	
	//获取活动详情/预览/简单信息
	List<PxActDetail> findActDetail(SearchParm s);
	List<PxActReview> findActReview(SearchParm s);
	List<PxActBase> findActBase(SearchParm s);
	int getActCount(SearchParm s);
	
	//获取活动参与人数
	int getActJoinCount(SearchParm s);
	

	//获取我参加的活动
	List<PxActReview> findActByUserJoin(SearchParm s);
	
    List<PxUser> selectActJoinUser(SearchParm s);
    

}
