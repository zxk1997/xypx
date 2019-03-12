package com.normal.Controller;


import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class PXImgController {
	//七牛云上传图片
	/*
	@ResponseBody
	@RequestMapping(value="/op/imgtoken/icon",method=RequestMethod.GET)
	public HashMap<String, String> getIconToken(HttpServletRequest req){
		return DataUtils.getQNToken(500, null);
	}
	
	@ResponseBody
	@RequestMapping(value="/op/imgtoken/placard",method=RequestMethod.GET)
	public HashMap<String, String> getPlacardToken(HttpServletRequest req){
		return DataUtils.getQNToken(1024*3, null);
	}
	
	@ResponseBody
	@RequestMapping(value="/op/imgtoken/content",method=RequestMethod.GET)
	public HashMap<String, String> getContentToken(HttpServletRequest req){
		String basePath = req.getScheme() + "://"
				+ req.getServerName() + ":" + req.getServerPort()
				+ req.getContextPath() + "/";
		String returnurl=basePath+"imgtoken/back";
		return DataUtils.getQNToken(1024, returnurl);
	}
	
	@RequestMapping("/imgtoken/back")
	public void imgCallBack(HttpServletRequest request,HttpServletResponse resp){
		String str=request.getParameter("upload_ret");
		resp.setContentType("application/json;charset=UTF-8");
		try {
			resp.getOutputStream().write(Base64.decode(str, Base64.DEFAULT));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
