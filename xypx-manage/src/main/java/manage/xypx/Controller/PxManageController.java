package manage.xypx.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;
import manage.xypx.Model.PxManageUser;
import manage.xypx.Service.Interface.PxManageServiceInterface;

@RestController
@RequestMapping("/manage")
public class PxManageController {
	
	@Autowired
	PxManageServiceInterface manage;
	
	@PostMapping("/login")
	public ResponseResult login(HttpServletRequest req,@RequestBody PxManageUser user) {
		ResponseResult result=new ResponseResult();
		if(user!=null) {
			PxManageUser u=manage.login(user.getUser(), user.pwd());
			if(u!=null) {
				HttpSession session=req.getSession();
				session.setAttribute("user", u);
				session.setMaxInactiveInterval(15*60);//不活动15分钟后失效
				result.setInfo(u);
			}else {
				result.setError(ErrorEnum.QUERY_ERR,"账号或者密码错误，登录失败");
			}
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"错误的请求");
		}
		
		return result;
	}
	
	@GetMapping("/login/state")
	public ResponseResult loginState() {
		return new ResponseResult();
	}
	
	@GetMapping("/logout")
	public ResponseResult logout(HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session!=null)session.invalidate();
		return new ResponseResult();
	}
}
