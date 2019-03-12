package com.normal.DAO;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PXActReviewMapper {
	public int findReviewStatus(@Param("id")String id,@Param("uid")String uid);
	
	public List<Map<String, Object>> findReviewList(Map<String, Object> map);
	
	public int getReviewListCnt(String aid);
	
	public int insertReview(Map<String, Object> map);
}
