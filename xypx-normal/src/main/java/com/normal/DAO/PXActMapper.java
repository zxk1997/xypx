package com.normal.DAO;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.normal.Model.PXActDetails;
import com.normal.Model.PXActInfoToSearch;
import com.normal.Model.PXLctrDetails;
import com.normal.Model.PXSelfAct;


public interface PXActMapper {
	
	public PXActDetails findActByID(Map<String, Object> map);
	
	public PXLctrDetails findLctrByID(Map<String, Object> map);
	
	public List<PXSelfAct>findSelfAct(Map<String, Object> map);
	
	public List<PXActInfoToSearch> findActFromSearch(Map<String, Object> map);
	
	public List<PXActInfoToSearch> findActFromREC();
	
	public List<PXActInfoToSearch> findActFromTagREC(String[] tags);
	
	public String findActHost(String id);
	
	public String findLctrHost(String id);
	
	public String getActRM(String id);
	
	public String getLctrRM(String id);
	
	public int getSelfActCnt(Map<String, Object> map);
	
	public int getActFromSearchCnt(Map<String, Object> map);
	
	public int getActPlimit(@Param("type")int type,@Param("id")String id);
	
	public int insertAct(Map<String, Object> map);
	
	public int insertLctr(Map<String, Object> map);
	
	public int updateAct(Map<String, Object> map);
	
	public int updateLctr(Map<String, Object> map);
	
	public int updateLctrStatus(Map<String, Object> map);
	
	public int updateActStatus(Map<String, Object> map);
	
}
