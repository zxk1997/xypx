package com.normal.Service.Interface;



import java.util.List;
import java.util.Map;

import com.normal.Model.PXActDetails;
import com.normal.Model.PXActInfoToSearch;
import com.normal.Model.PXLctrDetails;
import com.normal.Model.PXSelfAct;
import com.normal.common.ResponseResult;



public interface PXActService {
	
	public PXActDetails getAct(Map<String, Object> map);
	
	public PXLctrDetails getLctr(Map<String, Object> map);
	
	public List<PXSelfAct>findSelfAct(Map<String, Object> map);
	
	public List<PXActInfoToSearch> findActFromSearch(Map<String, Object> map);
	
	public List<PXActInfoToSearch> findActFromREC();
	
	public List<PXActInfoToSearch> findActFromTagREC(String uid);
	
	public ResponseResult findPartakeList(Map<String, Object> map);
	
	public int getActFromSearchCnt(Map<String, Object> map);
	
	public int getSelfActCnt(Map<String, Object> map);
	
	public int updateActMethod(int type,Map<String, Object> map);
	
	public int insertActMethod(int type,Map<String, Object> map);
	
	public int deleteActMethod(int type,String id,String uid);
	
	public ResponseResult joinActMethod(int type,String id,String uid,String phone,String email);
	
	public boolean joinActStatusMethod(String id,String uid);
	
	public boolean cancelJoin(String id,String uid);
	
}
