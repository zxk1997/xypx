package com.zxk1997.px.api.consumer.Controller;




import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zxk1997.px.api.consumer.Models.PXAct;
import com.zxk1997.px.api.consumer.Models.PXLctr;
import com.zxk1997.px.api.consumer.Models.PXSelfAct;
import com.zxk1997.px.api.consumer.Service.Interface.PXActReviewService;
import com.zxk1997.px.api.consumer.Service.Interface.PXActService;
import com.zxk1997.px.api.consumer.Service.Interface.PXUserService;
import com.zxk1997.px.api.consumer.common.SessionUtils;
import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxAct;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxLctr;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.common.utils.DataUtils;
import com.zxk1997.px.common.utils.ResponseResult;


@RestController
@RequestMapping("/op")
public class PXActOpController {

	@Resource
	PXActService pxAct;
	
	@Resource
	PXUserService pxUser;
	

	//添加活动
	@PostMapping("/act")
	public ResponseResult addAct(PXAct act,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String status=req.getParameter("draft")!=null?"-2":"0",id=req.getParameter("id");
		if(act!=null){
			
			if(pxUser.findUserStatus(SessionUtils.getCurUserName(req))!=1){
				result.setError(ErrorEnum.QUERY_ERR,"实名认证后才可以发布活动！");
				return result;
			}
			
			PxAct a=act.convert();
			a.setStatus(Integer.parseInt(status));
			a.setUid(SessionUtils.getCurUid(req));
			
			if(id!=null && id.length()==32){//修改活动
				a.setUid(SessionUtils.getCurUid(req));
				
				
				int r=pxAct.updateActMethod(new PxActivity(PxActType.ACTIVITY, a));
				if(r>0)result.setMsg("活动修改成功！");
				else if(r==-1)result.setError(ErrorEnum.QUERY_ERR, "请填写正确的内容");
				else result.setError(ErrorEnum.QUERY_ERR, "活动修改失败！");
			}else{//添加活动
				if(pxAct.insertActMethod(new PxActivity(PxActType.ACTIVITY, a))>0)result.setMsg("发布活动成功，请耐心等待审核！");
				else result.setError(ErrorEnum.QUERY_ERR, "发布活动失败！");
			}
			if(status.equals("-2")){
				if(result.getErrorCode()==0)result.setMsg("草稿保存成功！");
				else  result.setError(ErrorEnum.QUERY_ERR, "草稿保存失败！");
			}
		}else result.setError(ErrorEnum.PARAM_ERR, "请提交完整的参数");
		return result;
	}
	
	//添加讲座
	@PostMapping("/lctr")
	public ResponseResult addLctr(PXLctr lctr,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String status=req.getParameter("draft")!=null?"-2":"0",id=req.getParameter("id");
		if(lctr!=null){

			if(pxUser.findUserStatus(SessionUtils.getCurUserName(req))!=1){
				result.setError(ErrorEnum.QUERY_ERR,"实名认证后才可以发布讲座！");
				return result;
			}
			
			PxLctr a=lctr.convert();
			a.setStatus(Integer.parseInt(status));
			a.setUid(SessionUtils.getCurUid(req));

			if(id!=null && id.length()==32){//修改活动
				a.setId(id);
				if(pxAct.updateActMethod(new PxActivity(PxActType.LECTURE, a))>0)result.setMsg("讲座修改成功");
				else result.setError(ErrorEnum.QUERY_ERR, "修改讲座失败！");
			}else{//添加活动
				if(pxAct.insertActMethod(new PxActivity(PxActType.LECTURE, a))>0)result.setMsg("发布讲座成功，请耐心等待审核！");
				else result.setError(ErrorEnum.QUERY_ERR, "发布讲座失败！");
			}
			
			if(status.equals("-2")){
				if(result.getErrorCode()==0)result.setMsg("草稿保存成功！");
				else  result.setError(ErrorEnum.QUERY_ERR, "草稿保存失败！");
			}
		}else result.setError(ErrorEnum.PARAM_ERR, "请提交完整的参数");
		return result;
	}
	
	//删除活动
	@DeleteMapping("/act/{id}")
	public ResponseResult deleteAct(@PathVariable String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String uid=SessionUtils.getCurUid(req);
		if(pxAct.deleteActMethod(0, id, uid)>0)result.setMsg("删除成功");
		else result.setError(ErrorEnum.QUERY_ERR, "删除失败!");
		return result;
	}
	
	//删除讲座
	@DeleteMapping("/lctr/{id}")
	public ResponseResult deleteLctr(@PathVariable String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String uid=SessionUtils.getCurUid(req);
		if(pxAct.deleteActMethod(1, id, uid)>0)result.setMsg("删除成功");
		else result.setError(ErrorEnum.QUERY_ERR, "删除失败!");
		return result;
	}
	
	//报名活动
	@PostMapping("/partake")
	public ResponseResult joinAct(String type,String id,String phone,String email,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(pxUser.findUserStatus(SessionUtils.getCurUserName(req))!=1){
			result.setError(ErrorEnum.QUERY_ERR,"实名认证后才可以报名！");
			return result;
		}
		String uid=SessionUtils.getCurUid(req);
		if(type!=null&&id!=null && phone!=null&&email!=null)
			result=pxAct.joinActMethod(Integer.parseInt(type), id, uid, phone, email);
		else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	//取消报名
	@DeleteMapping("/partake/{id}")
	public ResponseResult cancelJoin(@PathVariable String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String uid=SessionUtils.getCurUid(req);
		if(id!=null ){
			if(pxAct.cancelJoin(id, uid))result.setMsg("取消报名成功！");
			else result.setError(ErrorEnum.PARAM_ERR, "取消报名失败");
		}
		else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	//获取报名状态
	@GetMapping("/partake/{id}")
	public ResponseResult getJoinStatus(@PathVariable String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String uid=SessionUtils.getCurUid(req);
		if(id!=null) result.setInfo(pxAct.joinActStatusMethod(id, uid));
		else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	//获取用户自己参加的活动 【疑问：获取状态，干嘛要用post？】
	@PostMapping("/selfact")
	public ResponseResult getSelfAct(String act_type,String type,String timefilter,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(type!=null && act_type!=null){
			SearchParm s=new SearchParm();
			s.setHost(SessionUtils.getCurUid(req));
			s.setUid(SessionUtils.getCurUid(req));
			
			if(act_type!=null) {
				if(act_type.equals("1")) {
					s.setType(0);
				}else if(act_type.equals("2")){
					s.setType(1);
				}
			}
			
			
//			map.put("timefilter", timefilter);//时间筛选 1未过期的活动 2已经过期的活动
//			map.put("time", new Date());//对比的时间
			
			s=DataUtils.simplePageHandler(req,s , 10);//p：页码 l：每页显示的个数
			
			List<PXSelfAct> acts=pxAct.findSelfAct(type,s);
			int total=pxAct.getSelfActCnt(type,s);
			
			Map<String, Object> resutMap=new HashMap<>();
			resutMap.put("total", total);
			resutMap.put("data", acts);
			result.setInfo(resutMap);
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整参数！");
		return result;
	}
	
	//获取参与人员列表【为什么用post？】
	@PostMapping("/partakelist")
	public ResponseResult findPartakeList(String act_type,String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(id!=null && act_type!=null){
			
			SearchParm s=new SearchParm();
			s.setId(id);
			s.setHost(SessionUtils.getCurUid(req));
			s.setType(act_type.equals("1")?0:1);
			s=DataUtils.simplePageHandler(req, s, 10);//p：页码 l：每页显示的个数
			result=pxAct.findPartakeList(s);
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整参数！");
		return result;
	}
	
	
	
}
