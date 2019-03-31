package com.zxk1997.px.common.utils;

import com.zxk1997.px.common.enums.ErrorEnum;

public class ResponseResult {
	private int status = 1;//状态
	private int errorCode = 0;//错误代码
	private Object msg = "";//提示信息
	private Object info;//业务数据
	

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}

	public static ResponseResult success(String msg,Object info) {
		ResponseResult result=new ResponseResult();
		result.setMsg(msg);
		result.setInfo(info);
		return result;
	}
	
	public static ResponseResult success(Object info) {
		return success("",info);
	}
	
	public static ResponseResult success() {
		return success("",null);
	}
	
	public static ResponseResult error(ErrorEnum e) {
		ResponseResult result=new ResponseResult();
		result.setMsg(e.getMsg());
		result.setStatus(0);
		result.setErrorCode(e.getErrCode());
		return result;
	}
	
	public static ResponseResult error(String msg) {
		ResponseResult result=new ResponseResult();
		result.setMsg(msg);
		result.setStatus(0);
		result.setErrorCode(-1);
		return result;
	}
	
	public static ResponseResult error() {
		return error("");
	}
	@Override
	public String toString() {
		return "ResponseResult [status=" + status + ", errorCode=" + errorCode + ", msg=" + msg + ", info=" + info
				+ "]";
	}
	
	


}
