package com.zxk1997.px.user.service;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.ResponseResult;

public interface UserService {
	
	//用户登录
	ResponseResult login(PxUser u);
	
	//根据id，u获取用户
	ResponseResult getUser(PxUser u);
	
	//编辑用户信息
	ResponseResult edit(PxUser u);
	
	//删除用户
	ResponseResult del(PxUser u);
	
	//添加用户
	ResponseResult reg(PxUser u);
	
	//添加用户实名材料
	ResponseResult addAuth(PxUser u,String imgUrl);

	
}
