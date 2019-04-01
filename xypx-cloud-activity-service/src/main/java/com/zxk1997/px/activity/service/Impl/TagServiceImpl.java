package com.zxk1997.px.activity.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.activity.dao.PxTagActMapper;
import com.zxk1997.px.activity.service.TagService;
import com.zxk1997.px.common.enums.PXTagEnum;
import com.zxk1997.px.common.models.PxTag;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	PxTagActMapper tag;
	
	@Override
	public int addTag(PxTag tag, PXTagEnum type) {
		tag.setI(type==PXTagEnum.ACT?0:1);
		if(this.tag.selectByName(tag)!=null) {
			return -1;
		}
		
		return this.tag.insertSelective(tag);
	}

	@Override
	public int editTag(PxTag tag, PXTagEnum type) {
		tag.setI(type==PXTagEnum.ACT?0:1);
		
		return this.tag.updateByPrimaryKeySelective(tag);
	}

	@Override
	public int delTag(PxTag tag, PXTagEnum type) {
		tag.setI(type==PXTagEnum.ACT?0:1);
		
		return this.tag.deleteByPrimaryKey(tag);
	}

}
