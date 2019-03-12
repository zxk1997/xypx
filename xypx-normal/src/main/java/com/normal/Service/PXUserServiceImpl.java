package com.normal.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Service;


import com.normal.DAO.PXTagMapper;
import com.normal.DAO.PXUserMapper;
import com.normal.DAO.PXUserRelationMapper;
import com.normal.Enums.ErrorEnum;
import com.normal.Enums.PXTagEnum;
import com.normal.Model.PXUser;
import com.normal.Service.Interface.PXTagService;
import com.normal.Service.Interface.PXUserService;
import com.normal.common.MyException;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.MD5;
import com.normal.common.utils.SessionUtils;


@Service
public  class PXUserServiceImpl implements PXUserService {

	@Resource
	PXUserMapper pxUser;
	
	@Resource
	PXTagMapper pxTagr;
	
	@Resource
	PXTagService pxTagService;
	@Resource
	PXUserRelationMapper pxUserRelation;
	
	private final String defaultIcon="http://img.xypuxing.com/header.png";
	
	@Override
	public ResponseResult updatePwd(String user,String oldPwd,String newPwd,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		PXUser u=pxUser.findUser(user);
		
		oldPwd=MD5.MD5Encode(user+oldPwd);
		System.out.println("旧密码:"+oldPwd);
		System.out.println("旧密码:"+u.getP());
		if(u.getP().equals(oldPwd)){
			newPwd=MD5.MD5Encode(user+newPwd);
			if(pxUser.updatePwd(newPwd, u.getUid())>0){
				u.setP(newPwd);
				SessionUtils.initUserSession(req, u);
				result.setMsg("密码修改成功");
			}
			else result.setError(ErrorEnum.QUERY_ERR, "密码修改失败");
		}else result.setError(ErrorEnum.QUERY_ERR, "原密码错误");
		return result;
	}
	

	@Override
	public ResponseResult updateIcon(String icon,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		PXUser u=SessionUtils.getCurUser(req);
		if(pxUser.updateIcon(icon, u.getUid())>0)result.setMsg("修改头像成功");
		else result.setError(ErrorEnum.QUERY_ERR, "修改头像失败");
		return result;
	}
	
	@Override
	public ResponseResult login(String user, String pwd,String v,HttpServletRequest req) {
		ResponseResult result=new ResponseResult();
		PXUser u=pxUser.findUser(user);
		if(u!=null){
			u.setP(MD5.MD5Encode(u.getP()+v));
			if(u.getP().equals(pwd)){
				SessionUtils.initUserSession(req, u);
				result.setMsg("登录成功！");
				//result=PXLoginNavController.loginSuccess(u, req);
			}else result.setError(ErrorEnum.QUERY_ERR, "密码错误！");
		}else result.setError(ErrorEnum.QUERY_ERR, "账号不存在！");
		return result;
	}
	
	@Override
	public ResponseResult register(PXUser user,HttpServletRequest req) {
		ResponseResult result=new ResponseResult();
		if(pxUser.findUser(user.getU())==null){
			user.setIcon(defaultIcon);
			user.setUid(DataUtils.generateUUID());
			user.setStatus(0);
			user.setTime(new Date());
			if(pxUser.insertUser(user)>0){
				result.setMsg("注册成功！");
				//result.setError(ErrorEnum.QUERY_ERR, "注册成功！");
				//result=PXLoginNavController.loginSuccess(user,req);
				
				//测试事务
				//throw new RuntimeException("测试事务咯");
				
			}
			else result.setError(ErrorEnum.QUERY_ERR, "未知原因导致注册失败！");
		}else result.setError(ErrorEnum.QUERY_ERR, "账号已存在!");
		return result;
	}

	@Override
	public PXUser findUserByOpenID(String openid) {
		
		return pxUser.findUserByOpenID(openid);
	}

	@Override
	public String findUserOpenId(String id) {
		
		return pxUser.findUserOpenId(id);
	}

	@Override
	public int updateUserOpenId(String id, String openid) {
	
		Map<String, Object>map=new HashMap<>();
		map.put("uid", id);
		map.put("openid", openid);
		return pxUser.updateUserOpenId(map);
	}

	@Override
	public int findUserStatus(String user) {
		return pxUser.findUserStatus(user);
	}

	@Override
	public String findUserRelation(String fuac, String tuac) {
		// TODO Auto-generated method stub
		return pxUserRelation.findUserRelation(fuac, tuac);
	}

	@Override
	public int insertBlack(String fuac, String tuac) {
		// TODO Auto-generated method stub
		return pxUserRelation.insertBlack(fuac, tuac);
	}

	@Override
	public int deleteBlack(String fuac, String tuac) {
		// TODO Auto-generated method stub
		return pxUserRelation.deleteBlack(fuac, tuac);
	}

	@Override
	public List<Map<String, Object>> findBlackList(Map<String, Object> map) {
		
		return pxUserRelation.findBlackList(map);
	}

	@Override
	public int getBlackListCnt(String user) {
		// TODO Auto-generated method stub
		return pxUserRelation.getBlackListCnt(user);
	}
	@Override
	public int insertUserTags(String uid,String[] tags){
		Map<String,Object> map =new HashMap<>();
		map.put("uid", uid);
		map.put("tags", tags);
		pxTagr.deleteUserTags(uid);
		return pxTagr.insertUserTags(map);
	}
	@Override
	public HashMap<String, String>  findUserTags(String uid){
		HashMap<String, String> map=new HashMap<>();
		String[] tags=pxTagr.findUserTagsIDByUID(uid);
		Map<String, String> tagsmap=pxTagService.getTags(PXTagEnum.PERS);
		for(String id :tags){
			map.put(id, tagsmap.get(id));
		}
		return map;
	}
}
