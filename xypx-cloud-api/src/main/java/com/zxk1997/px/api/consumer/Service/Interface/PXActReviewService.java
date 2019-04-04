package com.zxk1997.px.api.consumer.Service.Interface;



import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zxk1997.px.common.utils.ResponseResult;



public interface PXActReviewService {
	
	public boolean findReviewStatus(String id,String uid);
	
	public ResponseResult insertReview(String id,String uid,String content,int tag,int at);
	
	public List<Map<String, Object>> findReviewList(HttpServletRequest req,String aid,String act_type);
	
	public int getReviewListCnt(String aid);
}
