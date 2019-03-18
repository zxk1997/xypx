package manage.xypx.AOP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;
import manage.xypx.Enums.PxManageRole;
import manage.xypx.Model.PxManageUser;

@Component
public class UserAuth implements HandlerInterceptor {

	@Value("${spring.mvc.alloworigin}")
	String allowOrigin;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean state=false;
		
		//增加跨域头部
		response.setHeader("content-type", "application/json;charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", allowOrigin);
		response.setHeader("Access-Control-Allow-Credentials", "true");	
		response.setHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS,PUT,DELETE");
		response.setHeader("Access-Control-Allow-Headers", "content-type");
		
		if(!request.getMethod().equals("OPTIONS")) {
			HttpSession session=request.getSession(false);
			ResponseResult result=new ResponseResult();
			result.setError(ErrorEnum.NOT_LOGIN, "请先登录");
			if(session!=null) {
				PxManageUser user=(PxManageUser)session.getAttribute("user");
				if(user!=null) {
					//验证通过
					if(!request.getMethod().equals("GET") && user.role()!=PxManageRole.ADMIN) {
						//权限不够
						result.setError(ErrorEnum.QUERY_ERR, "您当前没有操作权限");
					}else {
						state=true;
					}
				}
			}
			if(!state) {
				response.getWriter().write(new ObjectMapper().writeValueAsString(result));
				response.flushBuffer();
			}
		}
		return state;
	}


	

}
