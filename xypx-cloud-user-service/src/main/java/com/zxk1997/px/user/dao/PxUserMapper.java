package com.zxk1997.px.user.dao;

import org.apache.ibatis.annotations.Param;

import com.zxk1997.px.common.models.PxUser;

public interface PxUserMapper {
	
	PxUser loginAuth(PxUser u);
	
	PxUser selectByObj(PxUser u);
	
	int updateByPrimaryKeySelective(PxUser record);
	
    int deleteByPrimaryKey(String id);
    
    int insert(PxUser record);
	
	int insertUserAuthFile(@Param("url")String url,@Param("uid")String uid);
	String findAuthFileByUid(String uid);
	int deleteAuthFileByUid(String uid);
	


    

}