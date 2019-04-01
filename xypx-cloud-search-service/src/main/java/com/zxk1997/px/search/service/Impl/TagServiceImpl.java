package com.zxk1997.px.search.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.common.models.PxTag;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.search.dao.PxTagActMapper;
import com.zxk1997.px.search.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	PxTagActMapper tag;
	
	@Override
	public List<PxTag> selectTagsByConditions(SearchParm s) {
		
		return tag.selectTagsByConditions(s);
	}

	@Override
	public int selectTagTotalByConditions(SearchParm s) {
		
		return tag.selectTagTotalByConditions(s);
	}

}
