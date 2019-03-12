package com.normal.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.normal.Enums.ErrorEnum;
import com.normal.Model.PXUser;
import com.normal.Service.Interface.PXUserService;
import com.normal.common.MyException;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.MD5;
import com.normal.common.utils.SessionUtils;

@RestController
@RequestMapping("/user")
public class PXUserController {

	@Resource
	PXUserService pxUser;

	// 修改密码
	@PostMapping("/pwd")
	public ResponseResult updatePwd(String newpwd, String oldpwd, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
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
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (icon != null && icon.length() > 10) {
				result = pxUser.updateIcon(icon, req);
			} else
				result.setError(ErrorEnum.QUERY_ERR, "请填写正确的参数");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 插入标签
	@PostMapping("/tags")
	public ResponseResult insertTags(String[] tags, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (tags != null && tags.length > 0) {
				if (pxUser.insertUserTags(obj.getUid(), tags) > 0)
					result.setMsg("修改成功！");
				else
					result.setError(ErrorEnum.QUERY_ERR, "修改标签失败！");
			} else
				result.setError(ErrorEnum.QUERY_ERR, "请填写正确的参数");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 查询标签
	@GetMapping("/tags")
	public ResponseResult getTags(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			result.setInfo(pxUser.findUserTags(obj.getUid()));
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 获取实名认证状态
	@GetMapping("/auth")
	public ResponseResult getAuthStatus(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			result.setInfo(pxUser.findUserStatus(obj.getU()) == 1);
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "未登录");
		return result;
	}

	// 获取黑名单列表
	@GetMapping("/blacklist/list")
	public ResponseResult getBlackList(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			result.setMsg(String.valueOf(pxUser.getBlackListCnt(obj.getU())));
			Map<String, Object> map = new HashMap<>();
			map.put("user", obj.getU());
			map = DataUtils.simplePageHandler(req, map, 10);
			result.setInfo(pxUser.findBlackList(map));
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "请登录后再进行操作！");
		return result;
	}

	// 获取与目标用户是否存在黑名单关系
	@GetMapping("/blacklist/{user}")
	public ResponseResult getBlackListStatus(@PathVariable String user, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (user != null) {
				String str = pxUser.findUserRelation(obj.getU(), user);
				result.setInfo(str != null && str.equals("0"));
			} else
				result.setError(ErrorEnum.NOT_LOGIN, "请填写完整的参数！");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "请登录后再进行操作！");
		return result;
	}

	// 将目标账户加入黑名单
	@PostMapping("/blacklist")
	public ResponseResult setBlackListStatus(String user, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (user != null) {
				result.setInfo(pxUser.insertBlack(obj.getU(), user) > 0);
			} else
				result.setError(ErrorEnum.NOT_LOGIN, "请填写完整的参数！");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "请登录后再进行操作！");
		return result;
	}

	// 删除与目标账户的黑名单关系
	@DeleteMapping("/blacklist/{user}")
	public ResponseResult delBlackListStatus(@PathVariable String user, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
		if (obj != null) {
			if (user != null) {
				result.setInfo(pxUser.deleteBlack(obj.getU(), user) > 0);
			} else
				result.setError(ErrorEnum.NOT_LOGIN, "请填写完整的参数！");
		} else
			result.setError(ErrorEnum.NOT_LOGIN, "请登录后再进行操作！");
		return result;
	}

	// 获取登录状态
	@GetMapping("/login/status")
	public ResponseResult getLoginStatus(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		PXUser obj = SessionUtils.getCurUser(req);
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
			HttpServletRequest req, HttpServletResponse resp) throws IOException, MyException {
		ResponseResult result = new ResponseResult();
		if (user != null && pwd != null && nickname != null && v != null) {
			if (DataUtils.verifyCode(req, v)) {
				if (DataUtils.isLetterAndNumber(user) && user.length() >= 6 && user.length() <= 12) {
					if (pwd.length() == 32) {
						if (nickname.length() >= 4 && nickname.length() <= 8) {
							PXUser userobj = new PXUser();
							userobj.setNickname(nickname);
							userobj.setU(user);
							userobj.setP(MD5.MD5Encode(user + pwd));
							result = pxUser.register(userobj, req);
							// if(bind!=null && bind.equals("1")&&
							// result.getErrorCode().equals("0"))result=wechatBind(req,resp);
							if (result.getErrorCode().equals("0"))
								SessionUtils.initUserSession(req, userobj);
						} else
							result.setError(ErrorEnum.QUERY_ERR, "昵称的长度必须在4-8个字符之间哦~");
					} else
						result.setError(ErrorEnum.QUERY_ERR, "设置密码错误！");
				} else
					result.setError(ErrorEnum.QUERY_ERR, "登录账号必须是6-12位的数字+字母组合");
			} else
				result.setError(ErrorEnum.QUERY_ERR, "验证码错误");
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
			if (DataUtils.verifyCode(req, v)) {
				if (DataUtils.isLetterAndNumber(user) && user.length() >= 6 && user.length() <= 12) {
					if (pwd.length() == 32) {
						result = pxUser.login(user, pwd, v, req);
						// if(bind!=null && bind.equals("1")&&
						// result.getErrorCode().equals("0"))result=wechatBind(req,resp);
					} else
						result.setError(ErrorEnum.QUERY_ERR, "密码错误！");
				} else
					result.setError(ErrorEnum.QUERY_ERR, "登录账号必须是6-12位的数字+字母组合");
			} else
				result.setError(ErrorEnum.QUERY_ERR, "验证码错误");
		} else
			result.setError(ErrorEnum.QUERY_ERR, "请填写完整的参数！");
		return result;
	}

	/*
	 * //微信绑定操作 public ResponseResult wechatBind(HttpServletRequest
	 * request,HttpServletResponse response) throws IOException{ ResponseResult
	 * result=new ResponseResult(); if(SessionUtils.getCurUser(request)!=null){
	 * if(request.getSession().getAttribute("unionuser")!=null){ String
	 * openId=((WeChatUserInfo)request.getSession().getAttribute("unionuser")).
	 * getUnionid(); String uid=SessionUtils.getCurUserId(request); PXUser
	 * user=pxUser.findUserByOpenID(openId); if(user!=null){
	 * if(user.getUid().equals(uid))result.setError(ErrorEnum.QUERY_ERR,
	 * "你已经绑定过这个微信号了"); else result.setError(ErrorEnum.QUERY_ERR, "此微信已经绑定了其他账号！");
	 * }else { //openid未绑定状态
	 * if(pxUser.findUserOpenId(SessionUtils.getCurUserId(request))!=null)result.
	 * setError(ErrorEnum.QUERY_ERR, "此账号已经绑定了其他微信！"); else {
	 * if(pxUser.updateUserOpenId(uid,
	 * openId)>0)result=PXLoginNavController.loginSuccess(SessionUtils.getCurUser(
	 * request), request); else result.setError(ErrorEnum.QUERY_ERR, "绑定失败！"); } }
	 * }else result.setError(ErrorEnum.QUERY_ERR, "野路子请求！！"); }else
	 * result.setError(ErrorEnum.QUERY_ERR, "请先登录后再进行操作！"); return result; }
	 */

	/*
	 * //获取微信绑定视图
	 * 
	 * @RequestMapping(value="/wx/bind",method=RequestMethod.GET) public
	 * ModelAndView wechatBindView(HttpServletRequest request,HttpServletResponse
	 * response) throws IOException{ String ua = request.getHeader("user-agent")
	 * .toLowerCase(); ModelAndView mav=new ModelAndView(); HttpSession session =
	 * request.getSession(false); if(session!=null &&
	 * session.getAttribute("openid")!=null){ System.out.println("openid是："+
	 * session.getAttribute("openid")); mav.setViewName("/m/loginbind.html"); }else{
	 * response.sendRedirect(PXWeChatConfig.Login_URL); mav=null; } return mav; }
	 */

	// 获取微信绑定状态
	@ResponseBody
	@RequestMapping(value = "/wx/status", method = RequestMethod.GET)
	public ResponseResult getBindStatus(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		if (getLoginStatus(req).getErrorCode().equals("0")) {
			result.setInfo(pxUser.findUserOpenId(SessionUtils.getCurUid(req)) != null);
		} else {
			result.setError(ErrorEnum.QUERY_ERR, "请先登录后再进行操作！");
		}

		return result;
	}

	// 处理微信的回调请求
	@RequestMapping("/wx")
	public void wechatGetOID(HttpServletRequest req, HttpServletResponse resp, String code, String state)
			throws IOException {
		System.out.println("sfsdfsd");
		if (state.equals("open")) {
			resp.sendRedirect("http://www.xypuxing.com:8080/web2/wx/open?code=" + code + "&state=" + state);
		} else
			resp.sendRedirect("http://www.xypuxing.com:8080/web2/wx/mp?code=" + code + "&state=" + state);

		/*
		 * if(code!=null && state!=null){ String result=HttpClientUtil.sendHttpGet(
		 * "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WeChatConfig.
		 * GZH_AppID+"&secret="+WeChatConfig.GZH_AppSecret+"&code="+code+
		 * "&grant_type=authorization_code"); if(result!=null){
		 * if(result.indexOf("openid")>-1){ JsonParser parser=new JsonParser();
		 * JsonObject obj=(JsonObject)parser.parse(result); if(obj!=null){ String
		 * openid=obj.get("openid").getAsString(); if(openid!=null
		 * &&openid.length()>0){//得到微信openid HttpSession session = req.getSession(true);
		 * session.setAttribute("openid", openid); PXUser
		 * user=pxUser.findUserByOpenID(openid); if(user!=null && user.getUid()!=null){
		 * SessionUtils.initUserSession(req, user);//根据openid自动登录
		 * resp.sendRedirect(URLDecoder.decode(state));//重定向到原始链接 }else
		 * resp.sendRedirect(PXWeChatConfig.Bind_Login_URL);//重定向到绑定微信号链接 }else
		 * DataUtils.simplePrint(resp, "openid异常"); }else DataUtils.simplePrint(resp,
		 * "数据解析失败！"); }else DataUtils.simplePrint(resp, result); }else
		 * DataUtils.simplePrint(resp, "访问微信公众号平台失败！"); }else
		 * DataUtils.simplePrint(resp, "参数错误");
		 */
	}

}
