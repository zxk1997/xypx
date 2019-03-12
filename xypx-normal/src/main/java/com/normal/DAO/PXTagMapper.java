package com.normal.DAO;


import java.util.List;
import java.util.Map;

import com.normal.Model.PXActTag;


public interface  PXTagMapper {

	public List<Map<String, Object>> findAllPersTag();
	
	public List<Map<String, Object>> findAllActTag();
	
	
	public String[] findUserTagsIDByUID(String uid);
	
	public String[] findUserTagsNameByUID(String uid);
	
	public List<PXActTag> findActTagsById(String id);
	
	public int insertUserTags(Map<String,Object> map);
	
	public int insertActTags(Map<String,Object> map);
	
	public int deleteUserTags(String uid);
	
	
	public int deleteActTags(String aid);
}
