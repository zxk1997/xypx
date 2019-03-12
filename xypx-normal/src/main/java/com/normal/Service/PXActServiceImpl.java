package com.normal.Service;



import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.normal.DAO.PXActMapper;
import com.normal.DAO.PXTagMapper;
import com.normal.DAO.PXUserPartakeMapper;
import com.normal.DAO.PXUserRelationMapper;
import com.normal.Enums.ErrorEnum;
import com.normal.Enums.PXTagEnum;
import com.normal.Model.ActContainer;
import com.normal.Model.PXActDetails;
import com.normal.Model.PXActInfoToSearch;
import com.normal.Model.PXActTag;
import com.normal.Model.PXLctrDetails;
import com.normal.Model.PXSelfAct;
import com.normal.Service.Interface.PXActService;
import com.normal.Service.Interface.PXTagService;
import com.normal.common.ResponseResult;



@Service
public class PXActServiceImpl implements PXActService {

	@Resource
	PXTagMapper pxTag;
	@Resource
	PXTagService pxTagService;
	
	@Resource
	PXActMapper pxAct;
	
	@Resource
	PXUserPartakeMapper pxUserPartake;
	
	@Resource
	PXUserRelationMapper pxUserRelation;

	/**
	 * type： 0普通活动 1讲座
	 * 插入活动  在controller中要控制map status的值 
	 * */
	@Override
	public int insertActMethod(int type,Map<String, Object> map){
		String id=UUID.randomUUID().toString().replaceAll("-", "");
		map.put("time", new Date());
		map.put("id",id);
		map.put("actType", type);
		pxTag.insertActTags(map);//写入标签
		if(type==0)return pxAct.insertAct(map);//插入活动
		else return pxAct.insertLctr(map);//插入讲座
		
	}
	
	/** 
	 * type： 0普通活动 1讲座
	 * 修改活动  在controller中要控制map status的值 
	 * */
	@Override
	public int updateActMethod(int type, Map<String, Object> map) {
		map.put("time", new Date());
		map.put("actType", type);
		
		int result=0;
		if(type==0) result=pxAct.updateAct(map);
		else result=pxAct.updateLctr(map);
		if(result>0){
			//修改成功，重置标签数据
			pxTag.deleteActTags(map.get("id").toString());
			return pxTag.insertActTags(map);
		}
		return 0;
	}
	
	/**
	 * 伪删除活动，map内需要有以下内容
	 * id：活动id
	 * uid：用户id
	 * **/
	@Override
	public int deleteActMethod(int type, String id,String uid) {
		Map<String, Object> map=new HashMap<>();
		map.put("status", -999);
		map.put("id", id);
		map.put("uid", uid);
		if(type==0)return pxAct.updateActStatus(map);
		else return pxAct.updateLctrStatus(map);
	}
	
	/**
	 * 获取活动，map内需要有以下内容
	 * id：活动id
	 * uid：用户id
	 * **/
	@Override
	public PXActDetails getAct(Map<String, Object> map) {
		PXActDetails act=pxAct.findActByID(map);
		List<PXActTag> tags=pxTag.findActTagsById(map.get("id").toString());
		ActContainer temp=handlerTags( tags);
		act.setTags1(temp.getTags1());
		act.setTags2(temp.getTags2());
		return act;
	}

	/**
	 * 获取讲座，map内需要有以下内容
	 * id：活动id
	 * uid：用户id
	 * **/
	@Override
	public PXLctrDetails getLctr(Map<String, Object> map) {
		PXLctrDetails lctr=pxAct.findLctrByID(map);
		List<PXActTag> tags=pxTag.findActTagsById(map.get("id").toString());
		ActContainer temp=handlerTags(tags);
		lctr.setTags1(temp.getTags1());
		lctr.setTags2(temp.getTags2());
		return lctr;
	}
	
	
	
	//根据标签ID从标签缓存中读取标签名
	private ActContainer handlerTags(List<PXActTag> tags){
		ActContainer temp=new ActContainer();
		Map<String, String> pers=pxTagService.getTags(PXTagEnum.PERS);
		Map<String, String> act=pxTagService.getTags(PXTagEnum.ACT);
		
		ArrayList<String> tags1=new ArrayList<>();
		ArrayList<String> tags2=new ArrayList<>();
		for(PXActTag tag : tags){
			if(tag.getT()==0)tags1.add(act.get(""+tag.getTid()));
			else tags2.add(pers.get(""+tag.getTid()));
		}
		
		temp.setTags1(tags1.toArray(new String[tags1.size()]));
		temp.setTags2(tags2.toArray(new String[tags2.size()]));
		return temp;		
	}

	



	/**
	 * 参与活动/讲座，map内需要有以下内容
	 * id：活动id
	 * uid：用户id
	 * phone：手机号码
	 * email：邮箱
	 * at：类型
	 * time：添加时间
	 * **/
	@Override
	public ResponseResult joinActMethod(int type, String id, String uid, String phone, String email) {
		ResponseResult result=new ResponseResult();
		if(!joinActStatusMethod(id,uid)){
			int black=0;
			if(type==0)black=pxUserRelation.canJoinAct(id, uid);
			else black=pxUserRelation.canJoinLctr(id, uid);
			if(black==0){
				int plimit=pxAct.getActPlimit(type, id);
				if(plimit==0 || plimit>pxUserPartake.findJoinCount(id)){
					Map<String, Object> map=new HashMap<>();
					map.put("id", id);
					map.put("uid", uid);
					map.put("phone", phone);
					map.put("email", email);
					map.put("at", ""+type);
					map.put("time", new Date());
					if(pxUserPartake.insertPartake(map)>0){
						if(type==0)result.setInfo(pxAct.getActRM(id));
						else result.setInfo(pxAct.getLctrRM(id));
						result.setMsg("报名成功！");
					}else result.setError(ErrorEnum.QUERY_ERR, "报名失败！");
				}else result.setError(ErrorEnum.QUERY_ERR, "报名人数已满");
			}else  result.setError(ErrorEnum.QUERY_ERR, "对方已将您拉入黑名单，报名失败！");
		}else result.setError(ErrorEnum.QUERY_ERR, "您已经参加过活动了");
		return result;
	}

	@Override
	public boolean joinActStatusMethod(String id, String uid) {
		return pxUserPartake.findJoinStatus(id, uid)>0;
	}

	@Override
	public boolean cancelJoin(String id, String uid) {
		return pxUserPartake.deletePartake(id, uid)>0;
	}

	@Override
	public List<PXSelfAct> findSelfAct(Map<String, Object> map) {
		return pxAct.findSelfAct(map);
	}

	@Override
	public int getSelfActCnt(Map<String, Object> map) {
		return pxAct.getSelfActCnt(map);
	}

	@Override
	public ResponseResult findPartakeList(Map<String, Object> map) {
		ResponseResult result=new ResponseResult();
		String host="";
		if(map.get("type").toString().equals("0"))host=pxAct.findActHost(map.get("id").toString());
		else host=pxAct.findLctrHost(map.get("id").toString());
		
		if(host ==null || !host.equals(map.get("uid").toString())){
			result.setError(ErrorEnum.QUERY_ERR, "非法请求！");
			return result;
		}
		Map<String, Object> resutMap=new HashMap<>();
		resutMap.put("total", pxUserPartake.findPartakeCnt(map.get("id").toString()));
		resutMap.put("data", pxUserPartake.findPartakeList(map));
		result.setInfo(resutMap);
		return result;
	}

	@Override
	public List<PXActInfoToSearch> findActFromSearch(Map<String, Object> map) {
		
		return pxAct.findActFromSearch(map);
	}

	@Override
	public List<PXActInfoToSearch> findActFromREC() {
		
		return pxAct.findActFromREC();
	}

	@Override
	public List<PXActInfoToSearch> findActFromTagREC(String uid) {
		String[] tags=pxTag.findUserTagsIDByUID(uid);
		return pxAct.findActFromTagREC(tags);
	}

	@Override
	public int getActFromSearchCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return pxAct.getActFromSearchCnt(map);
	}






}
