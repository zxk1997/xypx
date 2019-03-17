package manage.xypx.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manage.xypx.Common.DataUtils;
import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;
import manage.xypx.Service.Interface.PxActServiceInterface;

@RestController
@RequestMapping("/act")
public class PxActController {
	
	@Autowired
	PxActServiceInterface act;
	
	@GetMapping("/list")
	public ResponseResult getActList(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map=DataUtils.simplePageHandler(req, map, 10);
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(act.getActList(map));
		return result;
	}
	
	@GetMapping("/list/total")
	public ResponseResult getActTotal(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(act.getActTotal(map));
		return result;
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseResult deleteAct(@PathVariable("id")String id,int type) {
		ResponseResult result=new ResponseResult();
		int i=act.deleteAct(id, type==0?0:1);
		if(i==1) {
			result.setMsg("删除成功");
		}else if(i>1) {
			result.setMsg("删除成功，但有问题");
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"删除失败");
		}
		return result;
	}
	

	
	@GetMapping("/review/list")
	public ResponseResult getActReviewList(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map=DataUtils.simplePageHandler(req, map, 10);
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(act.getReviewAct(map));
		return result;
	}
	@GetMapping("/review/list/total")
	public ResponseResult getActReviewTotal(HttpServletRequest req,String Searchstr) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		map.put("status", 0);
		result.setInfo(act.getActTotal(map));
		return result;
	}
	
	@GetMapping("/review/{id}")
	public ResponseResult getActDetail(@PathVariable("id") String id) {
		ResponseResult result=new ResponseResult();
		result.setInfo(act.getAct(id));
		return result;
	}
	
	public ResponseResult setActStatus(String id,int type,boolean status) {
		ResponseResult result=new ResponseResult();
		int i=act.setActStatus(id, type,status);
		if(i==1) {
			result.setMsg("操作成功");
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"操作失败");
		}
		return result;
	}
	
	@PutMapping("/review/{id}")
	public ResponseResult setActPass(@PathVariable("id") String id,String type) {
		
		return setActStatus(id,type.equals("0")?0:1,true);
	}
	
	@DeleteMapping("/review/{id}")
	public ResponseResult setActFail(@PathVariable("id") String id,String type) {

		return setActStatus(id,type.equals("0")?0:1,true);
	}
	
	@PostMapping("/rec/{id}")
	public ResponseResult setPush(@PathVariable("id")String id,String type) {
		ResponseResult result=new ResponseResult();
		
		int i=act.setPush(id, type.equals("0")?0:1);
		if(i==1) {
			result.setMsg("添加推荐成功");
		}else if(i==-1){
			result.setError(ErrorEnum.QUERY_ERR,"推荐已存在");
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"添加推荐失败");
		}
		return result;
	}
	
	@GetMapping("/rec/list")
	public ResponseResult getActRecList(HttpServletRequest req) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map=DataUtils.simplePageHandler(req, map, 10);
		result.setInfo(act.getPushActList(map));
		return result;
	}
	@GetMapping("/rec/list/total")
	public ResponseResult getActRecTotal(HttpServletRequest req) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		result.setInfo(act.getPushActTotal(map));
		return result;
	}
	
	@DeleteMapping("/rec/{id}")
	public ResponseResult deleteActRec(@PathVariable("id")String id) {
		ResponseResult result=new ResponseResult();
		int i=act.deletePush(id);
		if(i==1) {
			result.setMsg("删除成功");
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"删除失败");
		}
		return result;
	}
	
	
}
