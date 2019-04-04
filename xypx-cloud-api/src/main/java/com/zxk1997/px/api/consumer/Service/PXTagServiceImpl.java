package com.zxk1997.px.api.consumer.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.api.consumer.Service.Interface.PXTagService;
import com.zxk1997.px.api.service.ISearchService;
import com.zxk1997.px.common.enums.PXTagEnum;
import com.zxk1997.px.common.models.PxTag;
import com.zxk1997.px.common.models.SearchParm;

@Service
public class PXTagServiceImpl implements PXTagService {

	@Autowired
	ISearchService search;
	
	@Override
	public Map<String,String> getTags(PXTagEnum type) {
		SearchParm s=new SearchParm();
		s.setType(type==PXTagEnum.ACT?0:1);
		List<PxTag> list= search.findTagList(s);
		Map<String,String> map=new HashMap<>();
		for(PxTag t : list) {
			map.put(t.getId().toString(), t.getName());
		}
		return map;
	}

}
