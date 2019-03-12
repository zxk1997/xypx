package com.normal.DAO;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.normal.Model.PXPartakeUser;



public interface PXUserPartakeMapper {
	
	public int findJoinStatus(@Param("id")String id,@Param("uid")String uid);
	
	public int findJoinCount(String id);
	
	public int findPartakeCnt(String id);
	
	public List<PXPartakeUser>findPartakeList(Map<String, Object> map);
	
	public int insertPartake(Map<String, Object> map);
	
	public int deletePartake(@Param("id")String id,@Param("uid")String uid);
	
}
