import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxk1997.px.api.service.IActService;
import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.enums.PxActType;
import com.zxk1997.px.common.models.PxActivity;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.RandomUtils;
import com.zxk1997.px.common.utils.ResponseResult;

@SpringBootTest(classes=com.zxk1997.px.api.ApiServiceApplication.class)
@RunWith(SpringRunner.class)
public class ApiTest {
	
	/*
	@Autowired
	IActService act;
	
	
	@Test
	public void test() {
		
		PxActivity a=new PxActivity();
		a.setType(PxActType.ACTIVITY);
		a.setAct(RandomUtils.getAct(RandomUtils.getUser()));
		
		System.out.println(act.add(a));
	}*/
	
	@Autowired
	IUserService user;
	
	@Test
	public void test2() {
		PxUser u=new PxUser();
		u.setU("sdf");
		u.setP("sdfsdfsdf");
		ResponseResult r=user.login(u);
		System.out.println(r);
	}
}
