package manage.xypx.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manage.xypx.Common.DataUtils;
import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;
import manage.xypx.Model.PxUser;
import manage.xypx.Service.Interface.PxUserServiceInterface;

@RestController
@RequestMapping("/user")
public class PxUserController {
	
	@Autowired
	PxUserServiceInterface pxUser;
	
	@GetMapping("/list")
	public ResponseResult getUserList(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map=DataUtils.simplePageHandler(req, map, 10);
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(pxUser.getUserByConditions(map));
		return result;
	}
	
	@GetMapping("/list/total")
	public ResponseResult getUserTotal(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(pxUser.getUserTotalByConditions(map));
		return result;
	}
	
	@DeleteMapping("/{id}")
	public ResponseResult deleteUser(@PathVariable("id")String id) {
		ResponseResult result=new ResponseResult();
		int i=pxUser.deleteById(id);
		if(i==1) {
			result.setMsg("删除成功");
		}else if(i>1) {
			result.setMsg("删除成功，但有问题");
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"删除失败");
		}
		return result;
	}
	
	@GetMapping("/auth/list")
	public ResponseResult getAuthUserList(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map=DataUtils.simplePageHandler(req, map, 10);
		map.put("status", -1);
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		
		List<HashMap<String, Object>> outList=new ArrayList<>();
		List<PxUser> list=pxUser.getUserByConditions(map);
		if(list!=null && list.size()>0) {
			HashMap<String, Object> tmpMap=new HashMap<>();
			for (PxUser tmp :list) {
				tmpMap.put("id", tmp.getId());
				tmpMap.put("time", tmp.getTime());
				tmpMap.put("nickname", tmp.getNickname());
			}
			outList.add(tmpMap);
		}
		result.setInfo(outList);
		return result;
	}
	
	@GetMapping("/auth/list/total")
	public ResponseResult getAuthUserTotal(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map.put("status", -1);
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(pxUser.getUserTotalByConditions(map));
		return result;
	}
	
	private ResponseResult userAuthOp(String id,boolean status) {
		ResponseResult result=new ResponseResult();
		if(id!=null) {
			int tmp=pxUser.updateUserReview(id, status);
			if(tmp>0) {
				result.setMsg("操作成功");
				return result;
			}
		}
		result.setError(ErrorEnum.QUERY_ERR,"操作失败");	
		return result;
	}

	@PutMapping("/auth/{id}")
	public ResponseResult userAuthPass(@PathVariable("id")String id) {
		return userAuthOp(id,true);
	}
	
	@DeleteMapping("/auth/{id}")
	public ResponseResult userAuthFail(@PathVariable("id")String id) {
		return userAuthOp(id,false);
	}
	
	@GetMapping("/auth/{id}")
	public ResponseResult getUserAuthFileUrl(@PathVariable("id")String id) {
		ResponseResult result=new ResponseResult();
		String tmp=pxUser.getUserAuthFile(id);
		if(tmp!=null) {
			result.setInfo(tmp);
		}else result.setError(ErrorEnum.QUERY_ERR, "获取失败");
		return result;
	}
	
	
	
	
}
