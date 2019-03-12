package com.normal.AOP;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.normal.Enums.ErrorEnum;
import com.normal.common.MyException;
import com.normal.common.ResponseResult;

@RestControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseResult handlerNotFound() {
		ResponseResult result=new ResponseResult();
		result.setError(ErrorEnum.NOT_FOUND);
		return result;
	}
	
	@ExceptionHandler(MyException.class)
	public ResponseResult handlerMyException(MyException ex) {
		ResponseResult result=new ResponseResult();
		result.setError(ErrorEnum.OP_FAIL,ex.getMessage());
		return result;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseResult otherException(Exception ex) {
		ResponseResult result=new ResponseResult();
		result.setError(ErrorEnum.OP_FAIL);
		System.out.println(ex.getMessage());
		return result;
	}
}
