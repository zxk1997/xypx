package com.normal.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.normal.DAO.PXUserMapper;
import com.normal.Service.Interface.PXAuthService;


@Service
public class PXAuthServiceImpl implements PXAuthService {

	@Resource
	PXUserMapper pxUser;
	
	@Override
	public int insertUserInfo(String id, String realname, String stuid, String schoolkey) {
		
		return pxUser.insertUserInfo(id, realname, stuid, schoolkey);
	}

	@Override
	public int updateUserStatus(String status, String uid) {
		
		return pxUser.updateUserStatus(status, uid);
	}

	@Override
	public boolean insertUserAuthFile(String uid, String url) {
		if(pxUser.findUserAuthFile(uid)!=null){
			return pxUser.updateUserAuthFile(url, uid)>0;
		}else return pxUser.insertUserAuthFile(url, uid)>0;
	}

}
