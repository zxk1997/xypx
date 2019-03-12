package com.normal.Service.Interface;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import com.normal.Model.PXUser;
import com.normal.common.MyException;
import com.normal.common.ResponseResult;





public interface PXUserService {
	
	public ResponseResult login(String user,String pwd,String v,HttpServletRequest req);
	
	public ResponseResult register(PXUser user,HttpServletRequest req);
	
	public ResponseResult updatePwd(String user,String oldPwd,String newPwd,HttpServletRequest req);
	
	public ResponseResult updateIcon(String icon,HttpServletRequest req);
	
	public List<Map<String,Object>> findBlackList (Map<String,Object> map);
	
	public int insertUserTags(String uid,String[] tags);
	
	public HashMap<String, String>  findUserTags(String uid);
	
	public int getBlackListCnt(String user);
	
	public PXUser findUserByOpenID(String openid);
	
	public String findUserOpenId(String id);
	
	public int findUserStatus(String user);
	
	public int updateUserOpenId(String id,String openid);
	
	public String findUserRelation(String fuac,String tuac);
	
	public int insertBlack(String fuac,String tuac);
	
	public int deleteBlack(String fuac,String tuac);
	
}
