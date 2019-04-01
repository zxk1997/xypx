package com.zxk1997.px.search.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.search.dao.PxActMapper;
import com.zxk1997.px.search.service.ActService;

@Service
public class ActServiceImpl implements ActService {

	@Autowired
	PxActMapper act;
	
	@Override
	public List<PxActBase> getRecList(SearchParm s) {
		
		return act.selectRecList(s);
	}

	@Override
	public List<PxActReview> getRecDetailList(SearchParm s) {
		
		return act.selectRecDetailList(s);
	}

	@Override
	public int getActRecCuont(SearchParm s) {
		s.setType(0);
		int a=act.selectRecTotal(s);
		s.setType(1);
		int b=act.selectRecTotal(s);
		return a+b;
	}

	@Override
	public List<PxActDetail> findActDetail(SearchParm s) {
		
		return act.selectByConditions(s);
	}

	@Override
	public List<PxActReview> findActReview(SearchParm s) {
		
		return act.selectByConditionsToReview(s);
	}

	@Override
	public List<PxActBase> findActBase(SearchParm s) {
		return act.selectByConditionsToBase(s);
	}

	@Override
	public int getActCount(SearchParm s) {
		s.setType(0);
		int a =act.selectTotalByConditions(s);
		s.setType(1);
		int b=act.selectTotalByConditions(s);
		return a+b;
	}

	@Override
	public int getActJoinCount(SearchParm s) {
		return act.selectActJoinTotal(s);
	}

	@Override
	public List<PxActReview> findActByUserJoin(SearchParm s) {
		return act.selectActByUserJoin(s);
	}

	@Override
	public List<PxUser> selectActJoinUser(SearchParm s) {
		
		return act.selectActJoinUser(s);
	}



}
