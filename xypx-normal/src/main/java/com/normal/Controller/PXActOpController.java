package com.normal.Controller;



import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.normal.Enums.ErrorEnum;
import com.normal.Model.PXAct;
import com.normal.Model.PXLctr;
import com.normal.Model.PXSelfAct;
import com.normal.Service.Interface.PXActReviewService;
import com.normal.Service.Interface.PXActService;
import com.normal.Service.Interface.PXUserService;
import com.normal.common.ResponseResult;
import com.normal.common.utils.DataUtils;
import com.normal.common.utils.SessionUtils;


@RestController
@RequestMapping("/op")
public class PXActOpController {

	@Resource
	PXActService pxAct;
	
	@Resource
	PXUserService pxUser;
	
	@Resource
	PXActReviewService pxReview;
	
	//发布活动评论

	@PostMapping("/act/review")
	public ResponseResult addActReview(String id,String content,int goodtag,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(id!=null && content!=null){
			result=pxReview.insertReview(id, SessionUtils.getCurUid(req), content, goodtag, 0);
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	//发布讲座评论
	@PostMapping("/lctr/review")
	public ResponseResult addLctrReview(String id,String content,int goodtag,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(id!=null && content!=null){
			result=pxReview.insertReview(id, SessionUtils.getCurUid(req), content, goodtag, 1);
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	//获取评论状态
	@GetMapping("/actreview/status/{id}")
	public ResponseResult getReviewStatus(@PathVariable String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(id!=null ){
			result.setInfo(pxReview.findReviewStatus(id, SessionUtils.getCurUid(req)));
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	//获取评论列表
	@GetMapping("/actreview/list")
	public ResponseResult getReviewList( String type,String id,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		if(id!=null  && type!=null){
			result.setInfo(pxReview.findReviewList(req, id, type));
			if(result.getInfo()!=null)result.setMsg(String.valueOf(pxReview.getReviewListCnt(id)));
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整的参数");
		return result;
	}
	
	
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
			
			String check=act.check();
			if(check.length()==0){
				Map<String, Object> map=act.getMap();
				map.put("status", status);
				map.put("uid", SessionUtils.getCurUid(req));
				
				if(id!=null && id.length()==32){//修改活动
					map.put("id", id);
					if(pxAct.updateActMethod(0, map)>0)result.setMsg("活动修改成功！");
					else result.setError(ErrorEnum.QUERY_ERR, "活动修改失败！");
				}else{//添加活动
					if(pxAct.insertActMethod(0, map)>0)result.setMsg("发布活动成功，请耐心等待审核！");
					else result.setError(ErrorEnum.QUERY_ERR, "发布活动失败！");
				}
				if(status.equals("-2")){
					if(result.getErrorCode().equals("0"))result.setMsg("草稿保存成功！");
					else  result.setError(ErrorEnum.QUERY_ERR, "草稿保存失败！");
				}
				
			}else result.setError(ErrorEnum.PARAM_ERR, check);
		}else result.setError(ErrorEnum.PARAM_ERR, "请提交完整的参数");
		return result;
	}
	
	//添加讲座
	@PostMapping("/lctr")
	public ResponseResult addLctr(PXLctr lctr,HttpServletRequest req){
		ResponseResult result=new ResponseResult();
		String status=req.getParameter("draft")!=null?"-2":"0",id=req.getParameter("id");
		if(lctr!=null){
			String check=lctr.check();
			if(pxUser.findUserStatus(SessionUtils.getCurUserName(req))!=1){
				result.setError(ErrorEnum.QUERY_ERR,"实名认证后才可以发布讲座！");
				return result;
			}
			if(check.length()==0){
				Map<String, Object> map=lctr.getMap();
				map.put("status", status);
				map.put("uid", SessionUtils.getCurUid(req));
				if(id!=null && id.length()==32){//修改活动
					map.put("id", id);
					if(pxAct.updateActMethod(1, map)>0)result.setMsg("讲座修改成功");
					else result.setError(ErrorEnum.QUERY_ERR, "修改讲座失败！");
				}else{//添加活动
					if(pxAct.insertActMethod(1, map)>0)result.setMsg("发布讲座成功，请耐心等待审核！");
					else result.setError(ErrorEnum.QUERY_ERR, "发布讲座失败！");
				}
				
				if(status.equals("-2")){
					if(result.getErrorCode().equals("0"))result.setMsg("草稿保存成功！");
					else  result.setError(ErrorEnum.QUERY_ERR, "草稿保存失败！");
				}
			}else result.setError(ErrorEnum.PARAM_ERR, check);
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
			Map<String, Object> map=new HashMap<>();
			map.put("id", SessionUtils.getCurUid(req));//个人UID
			map.put("act_type",act_type);//活动类型：0为全部 1为普通活动 2为讲座
			map.put("type", type);//参与互动类型 0为全部 1为主办方 2为参与者
			map.put("timefilter", timefilter);//时间筛选 1未过期的活动 2已经过期的活动
			map.put("time", new Date());//对比的时间
			map=DataUtils.simplePageHandler(req, map, 10);//p：页码 l：每页显示的个数
			
			List<PXSelfAct> acts=pxAct.findSelfAct(map);
			int total=pxAct.getSelfActCnt(map);
			
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
			Map<String, Object> map=new HashMap<>();
			map.put("uid", SessionUtils.getCurUid(req));//个人UID
			map.put("type",act_type);//活动类型：0活动 1讲座
			map.put("id", id);//活动id
			map=DataUtils.simplePageHandler(req, map, 10);//p：页码 l：每页显示的个数
			result=pxAct.findPartakeList(map);
		}else result.setError(ErrorEnum.PARAM_ERR, "请填写完整参数！");
		return result;
	}
	
	
	
}
