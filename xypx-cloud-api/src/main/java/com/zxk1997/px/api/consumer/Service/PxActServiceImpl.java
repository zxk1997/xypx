package com.zxk1997.px.api.consumer.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.api.consumer.Models.ActDetails;
import com.zxk1997.px.api.consumer.Models.PXActDetails;
import com.zxk1997.px.api.consumer.Models.PXActInfoToSearch;
import com.zxk1997.px.api.consumer.Models.PXLctrDetails;
import com.zxk1997.px.api.consumer.Models.PXSelfAct;
import com.zxk1997.px.api.consumer.Service.Interface.PXActService;
import com.zxk1997.px.api.service.IActService;
import com.zxk1997.px.api.service.ISearchService;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.PxUserPartake;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.common.utils.ResponseResult;

@Service
public class PxActServiceImpl implements PXActService {

	@Autowired
	IActService act;

	@Autowired
	ISearchService search;

	@Override
	public PXActDetails getAct(SearchParm parm) {
		PXActDetails at = new PXActDetails();
		int joinCnt = search.getActJoinCount(parm);

		List<PxActDetail> d = search.findActDetail(parm);
		if (d != null && d.size() > 0) {
			at = PXActDetails.convert(d.get(0));
		}
		at.setJoincnt(joinCnt);
		return at;
	}

	@Override
	public PXLctrDetails getLctr(SearchParm parm) {
		PXLctrDetails at = new PXLctrDetails();
		int joinCnt = search.getActJoinCount(parm);

		List<PxActDetail> d = search.findActDetail(parm);
		if (d != null && d.size() > 0) {
			at = PXLctrDetails.convert(d.get(0));
		}
		at.setJoincnt(joinCnt);
		return  at;
	}

	@Override
	public List<PXSelfAct> findSelfAct(String type, SearchParm parm) {
		List<PXSelfAct> list = new ArrayList<>();
		String uid=parm.getUid();
		if (type.equals("1") ||type.equals("0")) {
			// 发布
			parm.setUid(null);
			List<PxActReview> tmp = search.findActReview(parm);
			for (PxActReview t : tmp) {
				list.add(PXSelfAct.convert(t));
			}
		} 
		/*
		if (type.equals("2")||type.equals("0")){
			// 参加
			parm.setHost(null);
			parm.setUid(uid);
			List<PxActReview> tmp = search.findActReview(parm);
			for (PxActReview t : tmp) {
				list.add(PXSelfAct.convert(t));
			}
		}*/
		

		return list;
	}

	@Override
	public List<PXActInfoToSearch> findActFromSearch(SearchParm parm) {
		List<PXActInfoToSearch> list = new ArrayList<>();
		List<PxActReview> tmp = search.findActReview(parm);

		for (PxActReview t : tmp) {
			list.add(PXActInfoToSearch.convert(t));
		}
		return list;
	}

	@Override
	public List<PXActInfoToSearch> findActFromREC() {
		List<PXActInfoToSearch> list = new ArrayList<>();
		List<PxActReview> tmp = search.getRecDetailList(new SearchParm());

		for (PxActReview t : tmp) {
			list.add(PXActInfoToSearch.convert(t));
		}
		return list;
	}

	@Override
	public List<PXActInfoToSearch> findActFromTagREC(String uid) {
	
		return new ArrayList<>();
	}

	@Override
	public ResponseResult findPartakeList(SearchParm parm) {
		List<PxUser> list=search.getJoinList(parm);
		ResponseResult result=new ResponseResult();
		
		Map<String, Object> resutMap=new HashMap<>();
		resutMap.put("total",list.size());
		
		List<Map<String, Object>> userList=new ArrayList<>();
		for(PxUser u : list) {
			Map<String, Object> user=new HashMap<>();
			user.put("nickname", u.getNickname());
			user.put("icon", u.getIcon());
			user.put("icon", u.getId());
		}
		resutMap.put("total",list.size());
		resutMap.put("data", userList);
		result.setInfo(resutMap);
		
		return result;
	}

	@Override
	public int getActFromSearchCnt(SearchParm parm) {
		
		return search.getActCount(parm);
	}

	@Override
	public int getSelfActCnt(String type, SearchParm parm) {

		// type参与互动类型 0为全部 1为主办方 2为参与者
		// host和uid只能二选一
		if (type.equals("1")) {
			// 发布
			parm.setUid(null);
		} else {
			// 参加
			parm.setHost(null);
		}

		return search.getActCount(parm);
	}

	@Override
	public int updateActMethod(PxActivity act) {
		
		return this.act.edit(act);
	}

	@Override
	public int insertActMethod(PxActivity act) {
		
		return this.act.add(act);
	}

	@Override
	public int deleteActMethod(int type, String id, String uid) {
		
		SearchParm s=new SearchParm();
		s.setHost(uid);
		s.setId(id);
		List<PxActBase> list=search.findActBase(s);
		if(list!=null && list.size()==1) {
			return this.act.del(id,type==0?PxActType.ACTIVITY:PxActType.LECTURE);
		}
		
		
		return -1;
	}

	@Override
	public ResponseResult joinActMethod(int type, String id, String uid, String phone, String email) {
		PxUserPartake p=new PxUserPartake();
		p.setAt(type);
		p.setAid(id);
		p.setUid(uid);
		p.setPhone(phone);
		p.setEmail(email);
		p.setTime(new Date());
		int t= this.act.join(p);
		if(t==1) {
			return ResponseResult.success("报名成功");
		}else if(t==-1) {
			return ResponseResult.error("已经报过名了");
		}else {
			return ResponseResult.error("报名失败");
		}
	}

	@Override
	public boolean joinActStatusMethod(String id, String uid) {
		return true;
	}

	@Override
	public boolean cancelJoin(String id, String uid) {
		PxUserPartake p=new PxUserPartake();
		p.setAid(id);
		p.setUid(uid);
		return this.act.unJoinByObj(p)>0;
	}

}
