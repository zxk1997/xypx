package com.zxk1997.px.common.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.zxk1997.px.common.enums.ErrorEnum;
import com.zxk1997.px.common.utils.ResponseResult;



@RestControllerAdvice
public class MyExceptionHandler {
	
	private static Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseResult handleBindException(MethodArgumentNotValidException ex) {
		log.error(ex.toString());
		return ResponseResult.error(ErrorEnum.PARAM_ERR);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseResult handleNoFoundException(NoHandlerFoundException ex) {
		log.error(ex.toString());
		return ResponseResult.error(ErrorEnum.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseResult handleException(Exception ex) {
		log.error(ex.getClass().toString()+":"+ex.toString()+"---"+ex.getStackTrace().toString());
		return ResponseResult.error(ErrorEnum.OP_FAIL);
	}
}
