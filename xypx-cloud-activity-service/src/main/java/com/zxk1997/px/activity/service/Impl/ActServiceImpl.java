package com.zxk1997.px.activity.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.activity.dao.PxActMapper;
import com.zxk1997.px.activity.dao.PxActRecMapper;
import com.zxk1997.px.activity.dao.PxLctrMapper;
import com.zxk1997.px.activity.dao.PxUserPartakeMapper;
import com.zxk1997.px.activity.service.ActService;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxAct;
import com.zxk1997.px.common.models.PxActRec;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxLctr;
import com.zxk1997.px.common.models.PxUserPartake;
import com.zxk1997.px.common.utils.RandomUtils;

@Service
public class ActServiceImpl implements ActService {

	@Autowired
	PxActMapper act;
	
	@Autowired
	PxLctrMapper lctr;
	
	@Autowired
	PxActRecMapper rec;
	
	@Autowired
	PxUserPartakeMapper partake;
	
	@Override
	public int addAct(PxActivity obj) {
		if(obj.getType() == PxActType.ACTIVITY) {
			PxAct a=obj.getAct();
			a.setId(RandomUtils.getUUID());
			return act.insertSelective(a);
		}else {
			PxLctr l=obj.getLctr();
			l.setId(RandomUtils.getUUID());
			return lctr.insertSelective(l);
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

	@Override
	public int addRec(PxActivity obj) {
		PxActRec r=new PxActRec();
		if(obj.getType()==PxActType.ACTIVITY) {
			r.setAid(obj.getAct().getId());
			r.setAt(0);
		}else {
			r.setAid(obj.getLctr().getId());
			r.setAt(1);
		}
		
		if(rec.selectByAid(r.getAid())!=null) {
			return -1;//已存在
		}else {
			return rec.insertSelective(r);
		}
	}

	@Override
	public int delRec(String aid) {
		
		return rec.deleteByActId(aid);
	}

}
