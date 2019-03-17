package manage.xypx.AOP;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import manage.xypx.Common.ResponseResult;
import manage.xypx.Enums.ErrorEnum;

@RestControllerAdvice
public class MyExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseResult handlerNotFound() {
		ResponseResult result=new ResponseResult();
		result.setError(ErrorEnum.NOT_FOUND);
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
