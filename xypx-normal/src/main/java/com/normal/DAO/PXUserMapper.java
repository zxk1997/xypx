package com.normal.DAO;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.normal.Model.PXUser;



public interface PXUserMapper {
	public PXUser findUser(String user);
	
	public PXUser findUserByOpenID(String openid);
	
	public String findUserOpenId(String id);
	
	public int insertUserInfo(@Param("id")String id,@Param("realname")String realname,@Param("stuid")String stuid,@Param("schoolkey")String schoolkey);
	
	public int updateUserStatus(@Param("status")String status,@Param("uid")String uid);
	
	public int updatePwd(@Param("pwd")String pwd,@Param("uid")String uid);
	
	public int updateIcon(@Param("icon")String icon,@Param("uid")String uid);
	
	public String findUserAuthFile(String uid);
	
	public int insertUserAuthFile(@Param("url")String url,@Param("uid")String uid);
	
	public int updateUserAuthFile(@Param("url")String url,@Param("uid")String uid);
	
	public int findUserStatus(String user);
	
	public int updateUserOpenId(Map<String, Object> map);
	
	public int insertUser(PXUser user);
	
	
}
