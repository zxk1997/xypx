package com.normal.Service.Interface;




public interface PXAuthService {
	
	public int insertUserInfo(String id,String realname,String stuid,String schoolkey);
	
	public int updateUserStatus(String status,String uid);
	
	public boolean insertUserAuthFile(String uid,String url);
}
