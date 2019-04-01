package com.zxk1997.px.search.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.search.dao.PxUserMapper;
import com.zxk1997.px.search.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	PxUserMapper user;
	
	@Override
	public List<PxUser> findUserList(SearchParm s) {
		return user.selectByConditions(s);
	}

	@Override
	public String findUserAuthUrl(String s) {
		return user.selectUserAuthFileById(s);
	}

	@Override
	public int getUserListTotal(SearchParm s) {
		return user.selectTotalByConditions(s);
	}

}
