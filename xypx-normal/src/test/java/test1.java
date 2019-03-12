import static org.junit.Assert.*;

import org.junit.Test;

import com.normal.common.utils.MD5;

public class test1 {

	@Test
	public void test() {
		String user="zxk1997";
		String newPwd="a123456";
		String str=MD5.MD5Encode(user+newPwd);
		System.out.println(str);
	}

}
