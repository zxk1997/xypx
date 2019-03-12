package com.normal.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.normal.DAO.PXActMapper;
import com.normal.DAO.PXActReviewMapper;
import com.normal.DAO.PXUserPartakeMapper;
import com.normal.Enums.ErrorEnum;
import com.normal.Service.Interface.PXActReviewService;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.SessionUtils;

@Service
public class PXActReviewServiceImpl implements PXActReviewService {

	@Resource
	PXActReviewMapper review;
	@Resource
	PXUserPartakeMapper partake;
	@Resource
	PXActMapper pxAct;

	@Override
	public boolean findReviewStatus(String id, String uid) {
		return review.findReviewStatus(id, uid) > 0;
	}

	@Override
	public ResponseResult insertReview(String id, String uid, String content, int tag, int at) {
		ResponseResult result = new ResponseResult();
		if (partake.findJoinStatus(id, uid) > 0) {
			if (review.findReviewStatus(id, uid) == 0) {
				Map<String, Object> map = new HashMap<>();
				map.put("id", id);
				map.put("uid", uid);
				map.put("content", content);
				map.put("tag", tag);
				map.put("at", at);
				if (review.insertReview(map) > 0) {
					result.setMsg("评论成功！");
				} else
					result.setError(ErrorEnum.QUERY_ERR, "评论失败！");
			} else
				result.setError(ErrorEnum.QUERY_ERR, "已评论，请勿重复评论哟~");
		} else
			result.setError(ErrorEnum.QUERY_ERR, "没查询到你的参加记录，不能评论哟~");
		return result;
	}

	@Override
	public int getReviewListCnt(String aid) {
		return review.getReviewListCnt(aid);
	}

	@Override
	public List<Map<String, Object>> findReviewList(HttpServletRequest req, String aid, String act_type) {
		String hostuid = "";

		if (act_type.equals("0"))
			hostuid = pxAct.findActHost(aid);
		else
			hostuid = pxAct.findLctrHost(aid);
		if (hostuid != null && hostuid.equals(SessionUtils.getCurUid(req))) {
			Map<String, Object> map = new HashMap<>();
			map.put("aid", aid);
			map = DataUtils.simplePageHandler(req, map, 15);
			return review.findReviewList(map);
		}

		return null;
	}

}
