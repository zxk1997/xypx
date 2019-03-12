package com.normal.Controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.normal.Enums.ErrorEnum;
import com.normal.Model.PXUser;
import com.normal.Service.Interface.PXAuthService;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.SessionUtils;

@RestController
@RequestMapping("/auth")
public class PXAuthController {

	@Resource
	PXAuthService pxAuth;

	// 深职院在线验证.
	@PostMapping("/szpt")
	public ResponseResult szpt_online(String pid, String stuid, String v, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		if (pid != null && stuid != null && v != null) {
			PXUser obj = SessionUtils.getCurUser(req);
			if (obj.getStatus() == 0) {
				if (DataUtils.verifyCode(req, v)) {
					String schoolKey = "21328fdda9f5439ab1ee10bd125bc9f6";
					// SZPTUtils szptUtils=new SZPTUtils();
					// String str=szptUtils.Reg(stuid, pid);
					String str = "okok";
					if (pxAuth.insertUserInfo(SessionUtils.getCurUid(req), str, stuid, schoolKey) > 0) {
						if (pxAuth.updateUserStatus("1", SessionUtils.getCurUid(req)) > 0) {
							obj.setStatus(1);
							SessionUtils.initUserSession(req, obj);
							result.setMsg("验证成功！");
						} else
							result.setError(ErrorEnum.QUERY_ERR, "写入验证失败！");
					} else
						result.setError(ErrorEnum.QUERY_ERR, "未知原因导致验证失败！");
				} else
					result.setError(ErrorEnum.QUERY_ERR, "验证码错误！");
			} else
				result.setError(ErrorEnum.QUERY_ERR, "请勿重复验证！");
		} else
			result.setError(ErrorEnum.PARAM_ERR, "请提交完整的参数");
		return result;
	}

	// 上传证件照验证码(校园卡)
	@PostMapping("")
	public ResponseResult standard(String schoolkey, String url, String v, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		if (schoolkey != null && url != null && v != null) {
			// String schoolKey="21328fdda9f5439ab1ee10bd125bc9f6";
			PXUser obj = SessionUtils.getCurUser(req);
			if (obj.getStatus() == 0) {
				if (pxAuth.insertUserAuthFile(obj.getUid(), url)) {
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
