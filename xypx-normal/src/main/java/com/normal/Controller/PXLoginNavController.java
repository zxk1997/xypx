package com.normal.Controller;



import java.io.IOException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.normal.DAO.PXUserMapper;
import com.normal.Enums.ErrorEnum;
import com.normal.Model.PXUser;
import com.normal.Service.Interface.PXUserService;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.SessionUtils;


/**
 * 处理微信登录控制类
 * */
@Controller
public class PXLoginNavController {
//	
//	@Resource
//	PXUserService pxUser;
//	@Resource
//	PXUserMapper pxUserMapper;
//	
//	
//	@RequestMapping(value="/",method=RequestMethod.GET)
//	
//	public ModelAndView nav(HttpServletRequest req,HttpServletResponse resp){
//		System.out.println("laile");
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("redirect:/pc/index.jsp");
//		return mav;
//	}
//	
//	@RequestMapping(value="/aaa",method=RequestMethod.GET)
//	
//	public ModelAndView nav2(HttpServletRequest req,HttpServletResponse resp){
//		System.out.println("laile");
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("redirect:/pc/index.jsp");
//		return mav;
//	}
//	
//	
//	@RequestMapping("/login")
//	public ModelAndView loginNav(String redirect_url,HttpServletRequest req,HttpServletResponse resp){
//		ModelAndView mav=new ModelAndView();
//		mav.setViewName("redirect:/pc/index.jsp");
//		return mav;/*
//		if(redirect_url==null){
//			redirect_url=req.getHeader("referer");
//			if(redirect_url==null||redirect_url.length()<=0){
//				redirect_url="http://www.xypuxing.com";
//			}
//		}else req.getSession().setAttribute("unionlogin", 0);
//		req.getSession().setAttribute("redirect_url", redirect_url);
//		
//		if(DataUtils.isWeChat(req)){//微信中打开
//			mav.setViewName("redirect:"+WeChatUtils.mp_GetCodeUrl(PXViewConfig.MOBILE_Handler_URL));
//		}else if(DataUtils.isMobileBrowser(req)){//手机浏览器打开
//			mav.setViewName("redirect:"+PXViewConfig.LOGIN_MOBILE);
//		}else {//pc端
//			mav.setViewName("redirect:"+PXViewConfig.LOGIN_PC);
//		}
//		return mav;*/
//	}
//	
//	@RequestMapping("/login/wx")
//	public ModelAndView wxloginNav(String redirect_url,HttpServletRequest req,HttpServletResponse resp){
//		ModelAndView mav=new ModelAndView();
//		if(redirect_url==null){
//			redirect_url=req.getHeader("referer");
//			if(redirect_url==null||redirect_url.length()<=0){
//				redirect_url="http://www.xypuxing.com";
//			}
//		}else req.getSession().setAttribute("unionlogin", 0);
//		req.getSession().setAttribute("redirect_url", redirect_url);
//		
//		if(DataUtils.isWeChat(req)){//微信中打开
//			mav.setViewName("redirect:"+WeChatUtils.mp_GetCodeUrl(PXViewConfig.MOBILE_Handler_URL));
//		}else {
//			mav.setViewName("redirect:"+WeChatUtils.open_GetCodeUrl(PXViewConfig.PC_Handler_URL, "open"));
//		}
//		return mav;
//	}
//	
//	//微信公众号回调处理函数
//	@RequestMapping("/wx/mp")
//	public ModelAndView wxMpLogin(String code,String state,HttpServletRequest req,HttpServletResponse resp){
//		ModelAndView mav=new ModelAndView("redirect:"+PXViewConfig.LOGIN_MOBILE);
//		if(state.equals("open")){
//			mav.setViewName("redirect:http://www.xypuxing.com:8080/web2/wx/open?code="+code+"&state="+state);
//			return mav;
//		}
//		if(code!=null){
//			WeChatUserInfo info=WeChatUtils.mp_Handler(code);
//			if(info!=null && info.getUnionid()!=null && info.getUnionid().length()>0){
//				req.getSession().setAttribute("unionuser", info);
//				System.out.println(info.getNickname());
//				PXUser user=pxUser.findUserByOpenID(info.getUnionid());
//				if(user!=null && user.getUid()!=null){
//					loginSuccess(user,req,resp);
//					return null;
//				}else mav.setViewName("redirect:"+PXViewConfig.LOGIN_BIND_MOBILE);//未绑定的微信号
//			}
//		}
//		return mav;
//	}
//	
//	//微信开发者平台回调处理函数
//	@RequestMapping("/wx/open")
//	public ModelAndView wxOpenLogin(String code,String state,HttpServletRequest req,HttpServletResponse resp){
//		ModelAndView mav=new ModelAndView("redirect:"+PXViewConfig.LOGIN_PC);
//		if(code!=null){
//			WeChatUserInfo info=WeChatUtils.open_Handler(code);
//			if(info!=null && info.getUnionid()!=null && info.getUnionid().length()>0){
//				PXUser user=pxUser.findUserByOpenID(info.getUnionid());
//				if(user!=null && user.getUid()!=null){
//					Object object=req.getSession().getAttribute("redirect_url");
//					String redirect_url="";
//					if(object!=null){
//						redirect_url=object.toString();
//					}
//					loginSuccess(user,req);
//					mav.setViewName("redirect:"+redirect_url);
//				}else mav.setViewName("redirect:"+PXViewConfig.LOGIN_BIND_PC);//未绑定的微信号
//			}
//		}
//		return mav;
//	}
//	
//	@ResponseBody
//	@RequestMapping("/wx/info")
//	public ResponseResult wxInfo(HttpServletRequest req,HttpServletResponse resp){
//		ResponseResult result=new ResponseResult();
//		Object obj=req.getSession().getAttribute("unionuser");
//		if(obj!=null){
//			HashMap<String, String> map=new HashMap<>();
//			WeChatUserInfo info=(WeChatUserInfo)obj;
//			map.put("nickname", info.getNickname());
//			map.put("headimg", info.getHeadimgurl());
//			result.setInfo(map);
//		}else result.setError(ErrorEnum.QUERY_ERR, "没有微信登录记录");
//		return result;
//	}
//
//	@ResponseBody
//	@RequestMapping("/login/auth")
//	public ResponseResult loginAuth(String user,String time,String token,HttpServletRequest req,HttpServletResponse resp){
//		ResponseResult result=new ResponseResult();
//		if(MainServerUtils.checkRequestFromClient(user, time, token)){
//			PXUser obj=pxUserMapper.findUser(user);
//			result.setDataAttr("uid", obj.getUid());
//			result.setDataAttr("user", obj.getU());
//			result.setDataAttr("icon", obj.getIcon());
//			result.setDataAttr("nickname", obj.getNickname());
//			result.setDataAttr("status", obj.getStatus());
//		}else result.setError(ErrorEnum.QUERY_ERR, "校验失败！");
//		return result;
//	}
//	
//	public  static  ResponseResult loginSuccess(PXUser user,HttpServletRequest req){
//		ResponseResult result=new ResponseResult();
//		String redirect_url="";
//		Object object=req.getSession().getAttribute("redirect_url");
//		if(object!=null){
//			redirect_url=object.toString();
//			redirect_url=URLDecoder.decode(redirect_url);
//		}
//		if(req.getSession().getAttribute("unionlogin")!=null) {
//			req.getSession().invalidate();
//			//处理redirect_url参数
//			String time=""+new Date().getTime();
//			String token=MainServerUtils.createServerToken(user.getU(), time);
//			String parm="user="+user.getU()+"&time="+time+"&token="+token;
//			if(redirect_url.indexOf("?")>-1)redirect_url+="&"+parm;
//			else redirect_url+="?"+parm;
//		}else SessionUtils.initUserSession(req, user);
//		result.setInfo("redirect:"+redirect_url);
//		return result;
//	}
//	
//	public static void loginSuccess(PXUser user,HttpServletRequest req,HttpServletResponse resp){
//		ResponseResult result=loginSuccess(user,req);
//		String json=new Gson().toJson(result);
//		resp.setHeader("content-type", "application/json;charset=UTF-8");
//		
//		//跨域支持，发布时删除
//		resp.setHeader("Access-Control-Allow-Origin", "*");
//		resp.setHeader("Access-Control-Allow-Credentials", "true");
//		
//		try {
//			resp.getWriter().print(json);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	

	
	
}
