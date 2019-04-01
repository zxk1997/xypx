package com.zxk1997.px.search.service;

import java.util.List;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.models.SearchParm;

public interface UserService {
	
	
	List<PxUser> findUserList(SearchParm s);
	
	String findUserAuthUrl(String s);
	
	int getUserListTotal(SearchParm s);
}
