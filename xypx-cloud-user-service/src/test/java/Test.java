import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.RandomUtils;
import com.zxk1997.px.common.utils.ResponseResult;
import com.zxk1997.px.user.service.RedisService;
import com.zxk1997.px.user.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.zxk1997.px.user.UserServiceApplication.class)
public class Test {

//	@Autowired
//	UserService user;
//	
//	@org.junit.Test
//	public void test() {
//		PxUser u=RandomUtils.getUser();
//
//		ResponseResult r=user.reg(u);
//		if(r.getStatus()==1) {
//			u=(PxUser)r.getInfo();
//			r=user.getUser(u);
//			if(r.getStatus()==1) {
//				u=(PxUser)r.getInfo();
//				r=user.addAuth(u, "test");
//				if(r.getStatus()==1) {
//					u.setP("sfsdfsf");
//					r=user.edit(u);
//					if(r.getStatus()==1) {
//						r=user.login(u);
//						if(r.getStatus()==1) {
//							r=user.del(u);
//							if(r.getStatus()!=1) {
//								fail("用户删除失败");
//							}
//						}else fail("用户登录失败");
//					}else fail("编辑用户失败");
//				}else fail("添加实名材料失败");
//			}else fail("获取用户失败");
//		}else fail("注册失败");
//
//		
//	}
	
	@Autowired
	RedisService redis;
	
	@org.junit.Test
	public void test2() {
		//System.out.println(redis.get("xixi2"));
		System.out.println(redis.set("sasdffsf", "bbbb", 60*2));
		
	}

}
