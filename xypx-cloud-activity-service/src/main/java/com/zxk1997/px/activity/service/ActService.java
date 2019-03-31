package com.zxk1997.px.activity.service;

import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxUserPartake;

public interface ActService {
	
	//插入活动/讲座
	int addAct(PxActivity obj);
	
	//修改活动/讲座
	int editAct(PxActivity obj);
	
	//删除讲座/活动
	int delAct(String id,PxActType type);
	
	//参加活动/讲座
	int joinAct(PxUserPartake partake);
	
	//取消参加
	int unJoinAct(PxUserPartake partake);
	
	//添加推送
	int addRec(PxActivity obj);
	
	//删除推送
	int delRec(String aid);
}
