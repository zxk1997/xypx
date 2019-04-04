package com.zxk1997.px.api.consumer.Service.Interface;



import java.util.List;
import java.util.Map;

import com.zxk1997.px.api.consumer.Models.PXActDetails;
import com.zxk1997.px.api.consumer.Models.PXActInfoToSearch;
import com.zxk1997.px.api.consumer.Models.PXLctrDetails;
import com.zxk1997.px.api.consumer.Models.PXSelfAct;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.common.utils.ResponseResult;



public interface PXActService {
	
	/**
	 * 获取活动，map内需要有以下内容
	 * id：活动id
	 * uid：用户id
	 * **/
	public PXActDetails getAct(SearchParm parm);
	
	/**
	 * 获取讲座，map内需要有以下内容
	 * id：活动id
	 * uid：用户id
	 * **/
	public PXLctrDetails getLctr(SearchParm parm);
	
	/***
	 * 获取自己的活动
	 * @param map
	 * @return
	 */
	public List<PXSelfAct>findSelfAct(String type,SearchParm parm);
	
	/***
	 * 搜索活动
	 * @param map
	 * @return
	 */
	public List<PXActInfoToSearch> findActFromSearch(SearchParm parm);
	
	/**
	 * 获取首页推荐
	 * @return
	 */
	public List<PXActInfoToSearch> findActFromREC();
	
	/***
	 * 根据性格标签推荐活动
	 * @param uid
	 * @return
	 */
	public List<PXActInfoToSearch> findActFromTagREC(String uid);
	
	/***
	 * 获取活动参与者
	 * @param map
	 * @return
	 */
	public ResponseResult findPartakeList(SearchParm parm);
	
	/***
	 * 获取符合搜索条件的总数
	 * @param map
	 * @return
	 */
	public int getActFromSearchCnt(SearchParm parm);
	
	/***
	 * 获取自己的活动的总数
	 * @param map
	 * @return
	 */
	public int getSelfActCnt(String type,SearchParm parm);
	
	/***
	 * 修改活动
	 * @param type
	 * @param map
	 * @return
	 */
	public int updateActMethod(PxActivity act);
	
	/***
	 * 插入活动
	 * @param type
	 * @param map
	 * @return
	 */
	public int insertActMethod(PxActivity act);
	
	/***
	 * 删除活动
	 * @param type
	 * @param id
	 * @param uid
	 * @return
	 */
	public int deleteActMethod(int type,String id ,String uid);
	
	/***
	 * 参与活动
	 * @param type
	 * @param id
	 * @param uid
	 * @param phone
	 * @param email
	 * @return
	 */
	public ResponseResult joinActMethod(int type,String id,String uid,String phone,String email);
	
	/***
	 * 获取参与状态
	 * @param id
	 * @param uid
	 * @return
	 */
	public boolean joinActStatusMethod(String id,String uid);
	
	/***
	 * 取消参加
	 * @param id
	 * @param uid
	 * @return
	 */
	public boolean cancelJoin(String id,String uid);
	
}
