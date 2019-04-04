package com.zxk1997.px.zuul.filters;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.ResponseResult;
import com.zxk1997.px.zuul.feign.IUserService;

@Component
public class MyFilter extends ZuulFilter {

	Logger log=LoggerFactory.getLogger(MyFilter.class);
	
	@Autowired
	IUserService user;
	
	@Value("${authKey}")
	private String key;
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}
	
	//这里可以增加缓存
	public String getUser(String s) {
		ResponseResult r=user.getLoginInfo(s);
		if(r!=null && r.getStatus()==1) {
			Gson g=new Gson();
			return g.toJson(r.getInfo());
		}
		
		return null;
	}
	

	@Override
	public Object run() throws ZuulException {
	
		//添加服务通信认证头部
		RequestContext ctx=RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader("auth", key);
		
		//登录信息，s为登录的id，t为登录的时间，每10分钟更新一次状态
		HttpServletRequest req=ctx.getRequest();
		String s=DataUtils.getCookie(req, "s");
		
		if(s!=null) {//有登录信息
			log.info("包含登录cookie:"+s);
			String t=DataUtils.getCookie(req, "t");
			if(t==null || !DataUtils.cookieTimeAvailable(t, 10)) {
				//如果时间为空或者超过有效啥时间，则要刷新
				if(user.refLogin(s).getStatus()==1) {
					//刷新成功，重新写入cookie
					HttpServletResponse resp=ctx.getResponse();
					Cookie cookie=new Cookie("t", DataUtils.getCookieTime());
					cookie.setPath("/");
					resp.addCookie(cookie);
				}
			}
			
			String u=getUser(s);
			log.info("获取到的用户信息："+u);
			if(u!=null)
				try {
					ctx.addZuulRequestHeader("user", URLEncoder.encode(u, "utf-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		
		return null;
	}
}
