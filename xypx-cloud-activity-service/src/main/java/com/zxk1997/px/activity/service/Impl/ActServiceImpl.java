package com.zxk1997.px.activity.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.activity.dao.PxActMapper;
import com.zxk1997.px.activity.dao.PxLctrMapper;
import com.zxk1997.px.activity.dao.PxUserPartakeMapper;
import com.zxk1997.px.activity.service.ActService;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxUserPartake;

@Service
public class ActServiceImpl implements ActService {

	@Autowired
	PxActMapper act;
	
	@Autowired
	PxLctrMapper lctr;
	
	@Autowired
	PxUserPartakeMapper partake;
	
	@Override
	public int addAct(PxActivity obj) {
		if(obj.getType() == PxActType.ACTIVITY) {
			return act.insertSelective(obj.getAct());
		}else {
			return lctr.insertSelective(obj.getLctr());
		}
	}

	@Override
	public int editAct(PxActivity obj) {
		if(obj.getType() == PxActType.ACTIVITY) {
			return act.updateByPrimaryKeySelective(obj.getAct());
		}else {
			return lctr.updateByPrimaryKeySelective(obj.getLctr());
		}
	}

	@Override
	public int delAct(String id, PxActType type) {
		if(type == PxActType.ACTIVITY) {
			return act.deleteByPrimaryKey(id);
		}else {
			return lctr.deleteByPrimaryKey(id);
		}
	}

	@Override
	public int joinAct(PxUserPartake partake) {
		if(this.partake.selectByObj(partake)>0) {
			return -1;//已报名
		}else {
			return this.partake.insert(partake);
		}
	}

	@Override
	public int unJoinAct(PxUserPartake partake) {
		if(partake.getId()!=null) {
			return this.partake.deleteByPrimaryKey(partake.getId());
		}else {
			return this.partake.deleteByObj(partake);
		}
		
	}

}
