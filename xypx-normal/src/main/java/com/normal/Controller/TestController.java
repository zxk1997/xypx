package com.normal.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import com.normal.Model.PXUser;
import com.normal.common.MyException;
import com.normal.common.ResponseResult;

@RestController
public class TestController {

	@GetMapping("/test")
	public ResponseResult test(HttpServletRequest req) {
		ResponseResult result=new ResponseResult();
		HttpSession session=req.getSession(true);
		session.setAttribute("xixi", "asdf");
		return result;
	}
}