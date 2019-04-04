package com.zxk1997.px.api.consumer.Controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.zxk1997.px.api.consumer.Service.Interface.PXAuthService;
import com.zxk1997.px.api.consumer.common.SessionUtils;
import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.ResponseResult;

@RestController
@RequestMapping("/auth")
public class PXAuthController {

	@Resource
	PXAuthService pxAuth;

	// 深职院在线验证.
	@PostMapping("/szpt")
	public ResponseResult szpt_online(String pid, String stuid, String v, HttpServletRequest req) {
		return ResponseResult.error("接口已经停用,请上传校园卡进行认证");
	}

	// 上传证件照验证码(校园卡)
	@PostMapping("")
	public ResponseResult standard(String schoolkey, String url, String v, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		if (schoolkey != null && url != null && v != null) {
			// String schoolKey="21328fdda9f5439ab1ee10bd125bc9f6";
			PxUser obj = SessionUtils.getCurUser(req);
			if (obj.getStatus() == 0) {
				if (pxAuth.insertUserAuthFile(obj.getId(), url)) {
					result.setMsg("上传成功，请耐心等待审核~");
				} else
					result.setError(ErrorEnum.QUERY_ERR, "保存证件照失败！");
			} else
				result.setError(ErrorEnum.QUERY_ERR, "请勿重复验证！");
		} else
			result.setError(ErrorEnum.PARAM_ERR, "请提交完整的参数");
		return result;
	}
}
