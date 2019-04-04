package com.zxk1997.px.api.consumer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.api.consumer.Service.Interface.PXAuthService;
import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.models.PxUser;

@Service
public class PXAuthServiceImpl implements PXAuthService {

	@Autowired
	IUserService user;
	
	@Override
	public int insertUserInfo(String id, String realname, String stuid, String schoolkey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUserStatus(String status, String uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean insertUserAuthFile(String uid, String url) {
		PxUser u=new PxUser();
		u.setId(uid);
		
		return this.user.addAuth(u, url).getStatus()==1;
	}

}
