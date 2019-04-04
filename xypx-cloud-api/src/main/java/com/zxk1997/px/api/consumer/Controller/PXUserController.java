package com.zxk1997.px.api.consumer.Controller;


import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.api.consumer.Service.Interface.PXUserService;
import com.zxk1997.px.api.consumer.common.SessionUtils;
import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.MD5;
import com.zxk1997.px.common.utils.ResponseResult;



@RestController
@RequestMapping("/user")
public class PXUserController {
	
	@Autowired
	IUserService u;
	
	@Resource
	PXUserService pxUser;
	
	public boolean verifyCode(HttpServletRequest req , String v) {
		String vid=DataUtils.getCookie(req, "v");
		if(vid!=null) {
			ResponseResult r= u.redisGet(vid);
			return r.getStatus()==1 && r.getInfo().toString().equals(v);
		}
		return false;
	}



	// 修改密码
	@PostMapping("/pwd")
	public ResponseResult updatePwd(String newpwd, String oldpwd, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PxUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (newpwd != null && newpwd.length() == 32 && oldpwd != null && oldpwd.length() == 32) {
				result = pxUser.updatePwd(obj.getU(), oldpwd, newpwd, req);
			} else
				result.setError(ErrorEnum.QUERY_ERR, "请填写正确的参数");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录gh");
		return result;
	}

	// 修改头像
	@PostMapping("/icon")
	public ResponseResult updateIcon(String icon, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PxUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (icon != null && icon.length() > 10) {
				result = pxUser.updateIcon(icon, req);
			} else
				result.setError(ErrorEnum.QUERY_ERR, "请填写正确的参数");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 获取实名认证状态
	@GetMapping("/auth")
	public ResponseResult getAuthStatus(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PxUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			result.setInfo(pxUser.findUserStatus(obj.getU()) == 1);
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 获取登录状态
	@GetMapping("/login/status")
	public ResponseResult getLoginStatus(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PxUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("nickname", obj.getNickname());
			map.put("icon", obj.getIcon());
			result.setInfo(map);
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 注册操作
	@PostMapping("/register")
	public ResponseResult doRegister(String user, String pwd, String nickname, String v, String bind,
			HttpServletRequest req, HttpServletResponse resp)  {
		ResponseResult result = new ResponseResult();
		if (user != null && pwd != null && nickname != null && v != null) {
			if (verifyCode(req, v)) {
				PxUser userobj = new PxUser();
				userobj.setNickname(nickname);
				userobj.setU(user);
				userobj.setP(MD5.MD5Encode(user + pwd));
				result = pxUser.register(userobj, resp);
			} else {
				result.setError(ErrorEnum.QUERY_ERR, "验证码错误");
			}

		} else
			result.setError(ErrorEnum.QUERY_ERR, "请填写完整的参数！");
		return result;
	}

	// 登录操作
	@PostMapping("/login")
	public ResponseResult doLogin(String user, String pwd, String v, String bind, HttpServletRequest req,
			HttpServletResponse resp) throws IOException {
		ResponseResult result = new ResponseResult();
		if (user != null && pwd != null && v != null) {
			if (verifyCode(req, v)) {	
				result=pxUser.login(user, pwd, v,resp );
			} else
				result.setError(ErrorEnum.QUERY_ERR, "验证码错误");
		} else
			result.setError(ErrorEnum.QUERY_ERR, "请填写完整的参数！");
		return result;
	}


}
