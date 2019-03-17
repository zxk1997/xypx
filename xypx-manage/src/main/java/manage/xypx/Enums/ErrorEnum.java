package manage.xypx.Enums;




public enum ErrorEnum {
	QUERY_ERR("500","查询错误"),
	PARAM_ERR("101","参数错误"),
	SAVE_ERR("600","保存出错"),
	DEL_ERR("700","删除出错"),
	PWD_ACT_ERR("800","账号或密码错�?"),
	NOT_FOUND("404","未定义的操作"),
	OP_FAIL("999","操作失败"), 
	NOT_LOGIN("-1","请登录后再操�?");
	
	private String errCode;
	private String msg;
	
	private ErrorEnum(String errCode,String msg){
		this.errCode = errCode;
		this.msg = msg;
	}
	public String getErrCode() {
		return errCode;
	}
	public String getMsg() {
		return msg;
	}
	
}