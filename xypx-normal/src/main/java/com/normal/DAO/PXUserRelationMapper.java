package com.normal.DAO;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PXUserRelationMapper {
	
	public List<Map<String,Object>> findBlackList (Map<String,Object> map);
	
	public int getBlackListCnt(String user);
	
	public int canJoinAct(@Param("id")String id,@Param("tid")String tuac);
	
	public int canJoinLctr(@Param("id")String id,@Param("tid")String tuac);
	
	public String findUserRelation(@Param("fid")String fuac,@Param("tid")String tuac);
	
	public int insertBlack(@Param("fid")String fuac,@Param("tid")String tuac);
	
	public int deleteBlack(@Param("fid")String fuac,@Param("tid")String tuac);
}
