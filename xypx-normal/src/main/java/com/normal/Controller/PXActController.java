package com.normal.Controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.normal.Enums.ErrorEnum;
import com.normal.Model.PXActDetails;
import com.normal.Model.PXLctrDetails;
import com.normal.Service.Interface.PXActService;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.SessionUtils;

@RestController
public class PXActController {
	@Resource
	PXActService pxAct;

	// 获取活动

	@GetMapping("/act/{id}")
	public ResponseResult getAct(@PathVariable String id, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		String uid = SessionUtils.getCurUid(req);
		uid = uid != null ? uid : "";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("uid", uid);
		PXActDetails act = pxAct.getAct(map);
		if (act.getId() != null)
			result.setInfo(act);
		else
			result.setError(ErrorEnum.QUERY_ERR, "获取活动失败！");
		return result;
	}

	// 获取讲座

	@GetMapping("/lctr/{id}")
	public ResponseResult getLctr(@PathVariable String id, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		String uid = SessionUtils.getCurUid(req);
		uid = uid != null ? uid : "";
		Map<String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("uid", uid);
		PXLctrDetails lctr = pxAct.getLctr(map);
		if (lctr.getId() != null)
			result.setInfo(lctr);
		else
			result.setError(ErrorEnum.QUERY_ERR, "获取讲座失败！");
		return result;
	}

	// 搜索活动

	@PostMapping("/search")
	public ResponseResult search(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		Map<String, Object> map = new HashMap<>();
		map.put("act_type", req.getParameter("act_type"));// 活动类型 0全部 1活动 2讲座

		map.put("starttime", req.getParameter("starttime"));// 活动时间区间开始
		map.put("endtime", req.getParameter("endtime"));// 活动时间区间结束
		map.put("lb", req.getParameter("lb"));// 讲座专用，搜索有无讲座章
		map = DataUtils.simplePageHandler(req, map, 10);
		map.put("tags1", req.getParameterValues("tags1"));
		map.put("tags2", req.getParameterValues("tags2"));

		if (req.getParameter("str") != null) {
			try {
				String s = new String(req.getParameter("str").toString().getBytes("iso-8859-1"), "UTF-8");
				map.put("str", s);// 搜索关键词
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		result.setMsg(String.valueOf(pxAct.getActFromSearchCnt(map)));
		result.setInfo(pxAct.findActFromSearch(map));
		return result;
	}

	// 推荐活动

	@GetMapping("/rec/act")
	public ResponseResult getActREC(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		result.setInfo(pxAct.findActFromREC());
		return result;
	}

	// 根据标签推荐活动

	@GetMapping("/rec/tag")
	public ResponseResult getActTagREC(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		if (SessionUtils.getCurUid(req) == null) {
			result.setError(ErrorEnum.QUERY_ERR, "请登录后再进行操作！");
		} else
			result.setInfo(pxAct.findActFromTagREC(SessionUtils.getCurUid(req)));
		return result;
	}

}
