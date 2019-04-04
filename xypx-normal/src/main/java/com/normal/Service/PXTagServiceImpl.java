package com.normal.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.normal.DAO.PXTagMapper;
import com.normal.Enums.PXTagEnum;
import com.normal.Service.Interface.PXTagService;

@Service
public class PXTagServiceImpl implements PXTagService {

	@Resource
	PXTagMapper tags;

	@Cacheable(value = "tags")
	@Override
	public Map<String, String> getTags(PXTagEnum type) {
		List<Map<String, Object>> list = null;
		if (type == PXTagEnum.ACT)
			list = tags.findAllActTag();
		else
			list = tags.findAllPersTag();
		Map<String, String> resultMap = new HashMap<>();
		for (Map<String, Object> map : list) {
			String region = null;
			String id = null;
			for (Entry<String, Object> entry : map.entrySet()) {
				if ("name".equals(entry.getKey())) {
					region = (String) entry.getValue();
				} else if ("id".equals(entry.getKey())) {
					id = String.valueOf(entry.getValue());
				}
			}
			resultMap.put(id, region);
		}
		System.out.println("tags:从数据库中查询。。。");
		return resultMap;
	}

}
