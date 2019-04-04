package com.zxk1997.px.api.consumer.Service.Interface;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.ResponseResult;





public interface PXUserService {
	
	public ResponseResult login(String user,String pwd,String v,HttpServletResponse resp);
	
	public ResponseResult register(PxUser user,HttpServletResponse resp);
	
	public ResponseResult updatePwd(String user,String oldPwd,String newPwd,HttpServletRequest req);
	
	public ResponseResult updateIcon(String icon,HttpServletRequest req);
	
	public int findUserStatus(String user);
	

	
}
