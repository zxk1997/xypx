package com.zxk1997.px.api.consumer.Service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.api.consumer.Service.Interface.PXUserService;
import com.zxk1997.px.api.consumer.common.SessionUtils;
import com.zxk1997.px.api.service.ISearchService;
import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.MD5;
import com.zxk1997.px.common.utils.RandomUtils;
import com.zxk1997.px.common.utils.ResponseResult;

@Service
public class PxUserServiceimpl implements PXUserService {

	@Autowired
	ISearchService search;
	
	@Autowired
	IUserService user;
	
	public boolean addUserToRedis(PxUser u,HttpServletResponse resp) {
		u.setP(null);
		String uuid=RandomUtils.getUUID();
		if(this.user.writeLoginInfo(u, uuid).getStatus()==1) {
			//写入redis成功
			Cookie session=new Cookie("s", uuid);
			session.setPath("/");
			Cookie time=new Cookie("t", DataUtils.getCookieTime());
			time.setPath("/");
			resp.addCookie(session);
			resp.addCookie(time);
			ResponseResult result=new ResponseResult();
			result.setMsg("登录成功");
			return true;
		}
		return false;
	}
	
	@Override
	public ResponseResult login(String user, String pwd, String v, HttpServletResponse resp) {
		//密码要经过二次加密 MD5.MD5Encode(u.getP()+v)
		SearchParm s=new SearchParm();
		s.setHost(user);
		List<PxUser> userList=search.findUserList(s);
		if(userList!=null && userList.size()>0) {
			PxUser u=userList.get(0);
			u.setP(MD5.MD5Encode(u.getP()+v));
			if(u.getP().equals(pwd)){
				if(addUserToRedis(u,resp)) {
					ResponseResult result=new ResponseResult();
					result.setMsg("登录成功");
					return result;
				}else {
					return ResponseResult.error("系统繁忙，请重试！");
				}
			}
		}
		return ResponseResult.error("账号或者密码错误！");
	}

	@Override
	public ResponseResult register(PxUser user, HttpServletResponse resp) {
		ResponseResult result=this.user.reg(user);
		if(result.getStatus()==1) {
			PxUser u=DataUtils.responseResultToUser(result);
			result.setInfo(null);
			if(addUserToRedis(u,resp)) {
				result.setMsg("注册成功");
			}else {
				return ResponseResult.error("注册成功，请重新登录！");
			}
		}
		return result;
	}

	@Override
	public ResponseResult updatePwd(String user, String oldPwd, String newPwd, HttpServletRequest req) {
		ResponseResult result=new ResponseResult();
		SearchParm s=new SearchParm();
		s.setHost(user);
		List<PxUser> userList=search.findUserList(s);
		if(userList!=null && userList.size()>0) {
			PxUser u=userList.get(0);
			oldPwd=MD5.MD5Encode(user+oldPwd);
			if(u.getP().equals(oldPwd)){
				newPwd=MD5.MD5Encode(user+newPwd);
				u.setP(newPwd);
				
				if(this.user.editUser(u).getStatus()==1){
				
					result.setMsg("密码修改成功");
				}
				else result.setError(ErrorEnum.QUERY_ERR, "密码修改失败");
			}else result.setError(ErrorEnum.QUERY_ERR, "原密码错误");
		}
		
		
		return result;
	}

	@Override
	public ResponseResult updateIcon(String icon, HttpServletRequest req) {
		PxUser u=SessionUtils.getCurUser(req);
		u.setIcon(icon);
		u.setP(null);
		return this.user.editUser(u);
	}



	@Override
	public int findUserStatus(String user) {
		SearchParm s=new SearchParm();
		s.setHost(user);
		List<PxUser> userList=search.findUserList(s);
		if(userList!=null && userList.size()>0) {
			return userList.get(0).getStatus();
		}
		return 0;
	}

	

}
