package com.zxk1997.px.api.consumer.Controller;



import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.api.consumer.Models.PXActDetails;
import com.zxk1997.px.api.consumer.Models.PXLctrDetails;
import com.zxk1997.px.api.consumer.Service.Interface.PXActService;
import com.zxk1997.px.api.consumer.common.SessionUtils;
import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.ResponseResult;

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

		SearchParm search=new SearchParm();
		search.setId(id);
		search.setType(0);
		//search.setHost(uid);
		
		PXActDetails act = pxAct.getAct(search);
		if (act.getId() != null)
			result.setInfo(act);
		else
			result=ResponseResult.error(ErrorEnum.QUERY_ERR);
		return result;
	}

	// 获取讲座

	@GetMapping("/lctr/{id}")
	public ResponseResult getLctr(@PathVariable String id, HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		String uid = SessionUtils.getCurUid(req);
		uid = uid != null ? uid : "";

		SearchParm search=new SearchParm();
		search.setId(id);
		search.setType(1);
		//search.setHost(uid);
		
		PXLctrDetails lctr = pxAct.getLctr(search);
		if (lctr.getId() != null)
			result.setInfo(lctr);
		else
			result=ResponseResult.error(ErrorEnum.QUERY_ERR);
		return result;
	}

	// 搜索活动

	@PostMapping("/search")
	public ResponseResult search(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		
		SearchParm search=new SearchParm();
		
		if(req.getParameter("act_type")!=null) {
			if(req.getParameter("act_type").toString().equals("1")) {
				search.setType(0);
			}else if (req.getParameter("act_type").toString().equals("2")){
				search.setType(1);
			}
		}
		
		search.setStarttime(DataUtils.ConvterToDate(req.getParameter("starttime")));
		
		//map.put("endtime", req.getParameter("endtime"));// 活动时间区间结束
		//map.put("lb", req.getParameter("lb"));// 讲座专用，搜索有无讲座章
		
		search=DataUtils.simplePageHandler(req, search, 10);
		search.setTags1(req.getParameterValues("tags1"));
		search.setTags2(req.getParameterValues("tags2"));

		if (req.getParameter("str") != null) {
			search.setStr(req.getParameter("str"));

		}
		
		result.setMsg(String.valueOf(pxAct.getActFromSearchCnt(search)));
		result.setInfo(pxAct.findActFromSearch(search));
		return result;
	}

	// 推荐活动

	@GetMapping("/rec/act")
	public ResponseResult getActREC(HttpServletRequest req) {
		ResponseResult result = new ResponseResult();
		result.setInfo(pxAct.findActFromREC());
		return result;
	}
//
//	// 根据标签推荐活动
//
//	@GetMapping("/rec/tag")
//	public ResponseResult getActTagREC(HttpServletRequest req) {
//		ResponseResult result = new ResponseResult();
//		if (SessionUtils.getCurUid(req) == null) {
//			result.setError(ErrorEnum.QUERY_ERR, "请登录后再进行操作！");
//		} else
//			result.setInfo(pxAct.findActFromTagREC(SessionUtils.getCurUid(req)));
//		return result;
//	}

}
