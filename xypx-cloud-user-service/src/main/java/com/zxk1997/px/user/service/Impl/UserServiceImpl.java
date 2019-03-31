package com.zxk1997.px.user.service.Impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.RandomUtils;
import com.zxk1997.px.common.utils.ResponseResult;
import com.zxk1997.px.user.dao.PxUserMapper;
import com.zxk1997.px.user.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	PxUserMapper user;
	
	@Override
	public ResponseResult login(PxUser u) {
		u=user.loginAuth(u);
		if(u!=null)return ResponseResult.success(u);
		else return ResponseResult.error(ErrorEnum.PWD_ACT_ERR);
	}

	@Override
	public ResponseResult getUser(PxUser u) {
		u=user.selectByObj(u);
		if(u!=null)return ResponseResult.success(u);
		else return ResponseResult.error(ErrorEnum.QUERY_ERR);
	}

	
	@Override
	public ResponseResult addAuth(PxUser u, String imgUrl) {
		
		if(user.findAuthFileByUid(u.getId())!=null) {
			//如果存在记录，先删除,保证只有一条记录
			if(user.deleteAuthFileByUid(u.getId())==0) {
				return ResponseResult.error(ErrorEnum.OP_FAIL);
			}
		}
		if(user.insertUserAuthFile(imgUrl, u.getId())>0) {
			return ResponseResult.success();
		}
		return ResponseResult.error(ErrorEnum.OP_FAIL);
	}

	@Override
	public ResponseResult edit(PxUser u) {
		if(user.updateByPrimaryKeySelective(u)>0) {
			return ResponseResult.success();
		}
		return ResponseResult.error(ErrorEnum.OP_FAIL);
	}

	@Override
	public ResponseResult del(PxUser u) {
		if(user.deleteByPrimaryKey(u.getId())>0) {
			return ResponseResult.success();
		}
		return ResponseResult.error(ErrorEnum.OP_FAIL);
	}

	@Override
	public ResponseResult reg(PxUser u) {
		if(user.selectByObj(u)!=null) {
			return ResponseResult.error("账号已经存在");
		}else {
			u.setId(RandomUtils.getUUID());
			u.setStatus(0);
			u.setTime(new Date());
			u.setIcon("http://element-cn.eleme.io/favicon.ico");
			if(user.insert(u)>0) {
				return ResponseResult.success(u);
			}
		}
		log.info("账号注册失败："+u);
		return ResponseResult.error(ErrorEnum.OP_FAIL);
	}

}
