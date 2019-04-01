package com.zxk1997.px.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.PxTag;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.search.service.ActService;
import com.zxk1997.px.search.service.TagService;
import com.zxk1997.px.search.service.UserService;

@RestController
public class SearchController {
	
	@Autowired
	ActService act;
	
	@Autowired
	UserService user;
	
	@Autowired
	TagService tag;
	
	@PostMapping("/act/rec")
	public List<PxActBase> getRecList(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.getRecList(s);
	}
	
	@PostMapping("/act/rec/detail")
	public List<PxActReview> getRecDetailList(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.getRecDetailList(s);
	}
	
	@PostMapping("/act/rec/total")
	public Integer getActRecCuont(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.getActRecCuont(s);
	}
	
	@PostMapping("/act/detail")
	public List<PxActDetail> findActDetail(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.findActDetail(s);
	}
	
	@PostMapping("/act/review")
	public List<PxActReview> findActReview(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.findActReview(s);
	}
	
	@PostMapping("/act")
	public List<PxActBase> findActBase(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.findActBase(s);
	}
	
	@PostMapping("/act/total")
	public Integer getActCount(@RequestBody SearchParm s) {
		if(s==null)s=new SearchParm();
		return act.getActCount(s);
	}
	
	@PostMapping("/act/join/total")
	public int getActJoinCount(@RequestBody SearchParm s) {
		if(s==null)s=new SearchParm();
		return act.getActJoinCount(s);
	}
	
	@PostMapping("/act/join/user")
	public List<PxUser> getJoinList(@RequestBody SearchParm s) {
		if(s==null)s=new SearchParm();
		return act.selectActJoinUser(s);
	}

	@PostMapping("/user/act")
	public List<PxActReview> findActByUserJoin(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return act.findActByUserJoin(s);
	}
	
	@GetMapping("/user/auth/{id}")
	public String findUserAuthUrl(@PathVariable("id") String id){
		return user.findUserAuthUrl(id);
	}
	
	@PostMapping("/user/list")
	public List<PxUser> findUserList(@RequestBody SearchParm s){
		if(s==null)s=new SearchParm();
		return user.findUserList(s);
	}
	
	@PostMapping("/user/list/total")
	public int getUserListTotal(@RequestBody SearchParm s) {
		if(s==null)s=new SearchParm();
		return user.getUserListTotal(s);
	}
	
	@PostMapping("/tag/list")
	public List<PxTag> findTagList(@RequestBody SearchParm s){
		if(s==null) {
			s=new SearchParm();
			s.setType(0);
		}
		return tag.selectTagsByConditions(s);
	}
	
	@PostMapping("/tag/list/total")
	public int getTagListTotal(@RequestBody SearchParm s) {
		if(s==null) {
			s=new SearchParm();
			s.setType(0);
		}
		return tag.selectTagTotalByConditions(s);
	}
	
	

	
}
