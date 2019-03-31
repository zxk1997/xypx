package manage.xypx.AOP;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;

//异常处理类
@RestControllerAdvice
public class MyExceptionHandler {

	//处理404错误
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseResult handlerNotFound() {
		ResponseResult result=new ResponseResult();
		String str="";
		result.setError(ErrorEnum.NOT_FOUND);
		return result;
	}
	

	//处理所有异常
	@ExceptionHandler(Exception.class)
	public ResponseResult otherException(Exception ex) {
		ResponseResult result=new ResponseResult();
		result.setError(ErrorEnum.OP_FAIL);
		System.out.println(ex.getMessage());
		return result;
	}

}
