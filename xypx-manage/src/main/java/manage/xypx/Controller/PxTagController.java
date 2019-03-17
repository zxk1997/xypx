package manage.xypx.Controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import manage.xypx.Common.DataUtils;
import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;
import manage.xypx.Enums.PXTagEnum;
import manage.xypx.Service.Interface.PxTagServiceInterface;

@RestController
@RequestMapping("/tag")
public class PxTagController {
	
	@Autowired
	PxTagServiceInterface tag;
	
	private ResponseResult getTagList(HttpServletRequest req,String Searchstr,PXTagEnum type) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		map=DataUtils.simplePageHandler(req, map, 10);
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(tag.getTagList(map, type));
		return result;
	}
	
	private ResponseResult getTagTotal(HttpServletRequest req,String Searchstr,PXTagEnum type) {
		ResponseResult result=new ResponseResult();
		HashMap<String,Object> map=new HashMap<>();
		if(Searchstr !=null && Searchstr.length()>0)map.put("str", Searchstr);
		result.setInfo(tag.getTagTotal(map, type));
		return result;
	}
	
	private ResponseResult getResult(int i) {
		ResponseResult result=new ResponseResult();
		if(i==1) {
			result.setMsg("操作成功");
		}else {
			result.setError(ErrorEnum.QUERY_ERR,"操作失败");
		}
		return result;
	}
	
	private ResponseResult renameTag(int id,String name,PXTagEnum type) {
		return getResult(tag.renameTag(type, id, name));
	}
	
	private ResponseResult deleteTag(int id,PXTagEnum type) {
		return getResult(tag.deleteTag(type, id));
	}
	
	private ResponseResult addTag(String name,PXTagEnum type) {
		return getResult(tag.addTag(type, name));
	}
	
	
	@GetMapping("/act/list")
	public ResponseResult getActTagList(HttpServletRequest req,String Searchstr) {
		return getTagList(req,Searchstr,PXTagEnum.ACT);
	}
	
	@GetMapping("/per/list")
	public ResponseResult getPerTagList(HttpServletRequest req,String Searchstr) {
		return getTagList(req,Searchstr,PXTagEnum.PERS);
	}
	

	
	@GetMapping("/act/list/total")
	public ResponseResult getActTotal(HttpServletRequest req,String Searchstr) {
		return getTagTotal(req, Searchstr, PXTagEnum.ACT);
	}
	
	@GetMapping("/per/list/total")
	public ResponseResult getPerTotal(HttpServletRequest req,String Searchstr) {
		return getTagTotal(req, Searchstr, PXTagEnum.PERS);
	}
	
	
	@PostMapping("/act")
	public ResponseResult addActTag(String name) {
		return addTag(name, PXTagEnum.ACT);
	}
	
	@PostMapping("/per")
	public ResponseResult addPerTag(String name) {
		return addTag(name, PXTagEnum.PERS);
	}
	
	@DeleteMapping("/act/{id}")
	public ResponseResult delActTag(@PathVariable("id")int id) {
		return deleteTag(id, PXTagEnum.ACT);
	}
	@DeleteMapping("/per/{id}")
	public ResponseResult delPerTag(@PathVariable("id")int id) {
		return deleteTag(id, PXTagEnum.PERS);
	}
	
	@PutMapping("/act/{id}")
	public ResponseResult upActTag(String name, @PathVariable("id")int id) {
		return renameTag(id,name, PXTagEnum.ACT);
	}
	
	@PutMapping("/per/{id}")
	public ResponseResult upPerTag(String name,@PathVariable("id")int id) {
		return renameTag(id,name, PXTagEnum.PERS);
	}

	
}
