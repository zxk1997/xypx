package com.zxk1997.px.api.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.zxk1997.px.common.ServiceName;
import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.PxTag;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;

@FeignClient(ServiceName.search)
public interface ISearchService {
	
	/**
	 * 获取活动推荐列表，推荐的活动以基本信息返回
	 * */
	@PostMapping("/act/rec")
	public List<PxActBase> getRecList(SearchParm s);
	
	/**
	 * 获取活动推荐列表，推荐的活动以预览信息返回
	 * */
	@PostMapping("/act/rec/detail")
	public List<PxActReview> getRecDetailList(SearchParm s);
	
	/**
	 * 获取活动推荐列表的总数
	 * */
	@PostMapping("/act/rec/total")
	public Integer getActRecCuont(SearchParm s);
	
	/**
	 * 获取活动列表，返回详细信息
	 * */
	@PostMapping("/act/detail")
	public List<PxActDetail> findActDetail(SearchParm s);
	
	/**
	 * 获取活动列表，返回预览信息
	 * */
	@PostMapping("/act/review")
	public List<PxActReview> findActReview(SearchParm s);
	
	/**
	 * 获取活动列表，返回基本信息
	 * */
	@PostMapping("/act")
	public List<PxActBase> findActBase(SearchParm s);
	
	/**
	 * 获取活动的总数
	 * */
	@PostMapping("/act/total")
	public Integer getActCount(SearchParm s);
	
	/**
	 * 获取一个活动参加人员的总数
	 * */
	@PostMapping("/act/join/total")
	public int getActJoinCount(SearchParm s);
	
	/**
	 * 获取一个活动的参与人员
	 * */
	@PostMapping("/act/join/user")
	public List<PxUser> getJoinList( SearchParm s);
	
	/**
	 * 获取用户参加的活动
	 * */
	@PostMapping("/user/act")
	public List<PxActReview> findActByUserJoin(SearchParm s);
	
	/**
	 * 获取用户实名文件链接
	 * */
	@GetMapping("/user/auth/{id}")
	public String findUserAuthUrl(@PathVariable("id") String id);
	
	/**
	 * 获取用户列表
	 * */
	@PostMapping("/user/list")
	public List<PxUser> findUserList(SearchParm s);
	
	/**
	 * 获取用户总数
	 * */
	@PostMapping("/user/list/total")
	public int getUserListTotal(SearchParm s);
	
	/**
	 * 获取标签列表
	 * type 为0  代表活动标签
	 * 为1 代表性格标签
	 * */
	@PostMapping("/tag/list")
	public List<PxTag> findTagList(SearchParm s);
	
	/**
	 * 获取标签总数
	 * type 为0  代表活动标签
	 * 为1 代表性格标签
	 * */
	@PostMapping("/tag/list/total")
	public int getTagListTotal(SearchParm s);
}
