package com.normal.common;



import java.util.HashMap;
import java.util.Map;

import com.normal.Enums.ErrorEnum;

public class ResponseResult {
	private String status = STATUS_OK;//状态
	private String errorCode = "0";//错误代码
	private String msg = "";//提示信息
	private Object info;//业务数据
	
	public static final String STATUS_OK = "1";
	public static final String STATUS_ERR = "0";
	public static final String TOTAL_COUNT = "totalCount";
	public static final String PAGE_DATA = "listItems";
	public static final String PARAM_PAGE_SIZE = "pageSize";
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getInfo() {
		return info;
	}
	public void setInfo(Object info) {
		this.info = info;
	}

	

	public void setError(ErrorEnum error){
		setError(error,error.getMsg());
	}
	

	public void setError(ErrorEnum error,String msg){
		setStatus(STATUS_ERR);
		setErrorCode(error.getErrCode());
		setMsg(msg);
	}

	@SuppressWarnings("unchecked")
	public void setDataAttr(String key, Object data) {
		Map<String, Object> attrMap = null;
		if (getInfo() == null) {
			attrMap = new HashMap<String, Object>();
			setInfo(attrMap);
		} else {
			attrMap = (Map<String, Object>)getInfo();
		}
		attrMap.put(key, data);
	}
}
