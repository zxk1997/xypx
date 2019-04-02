import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zxk1997.px.api.service.IUserService;
import com.zxk1997.px.common.models.PxUser;
import com.zxk1997.px.common.utils.ResponseResult;

@SpringBootTest(classes=com.zxk1997.px.api.ApiServiceApplication.class)
@RunWith(SpringRunner.class)
public class ApiTest {
	
	
	/*@Autowired
	IActService act;
	
	
	@Test
	public void test() {
		
		PxActivity a=new PxActivity();
		a.setType(PxActType.ACTIVITY);
		a.setAct(RandomUtils.getAct(RandomUtils.getUser()));
		
		System.out.println(act.add(a));
	}
	
	
	
	@Test
	public void test2() {
		PxTag tag=new PxTag();
		
		tag.setName("测试");
		
		int a =act.addTag(tag, PXTagEnum.ACT);
		tag.setId(10);
		tag.setName("测试啊啊");
		
		int b =act.editTag(tag, PXTagEnum.ACT);
		
		int c =act.delTag(tag, PXTagEnum.ACT);
		System.out.println("o");
	}*/
	

//	@Autowired
//	ISearchService search;
//	
//	@Test
//	public void test3() {
//		
//		SearchParm s=new SearchParm();
//		List<PxActDetail> list=search.findActDetail(s);
//		
//		s.setStart(0);
//		s.setLength(10);
//		List<PxActDetail> list2=search.findActDetail(s);
//		
//		s=new SearchParm();
//		s.setType(1);
//		List<PxActDetail> list3=search.findActDetail(s);
//	
//		System.out.println("");
//	}
	
	@Autowired
	IUserService user;
	
	@Test
	public void test4() {
		
//		PxUser user=new PxUser();
//		user.setU("kdhuuw75");
//		user.setP("4746191fed3ee8528573fd053991bdbd");
//		ResponseResult r2=this.user.login(user);
//		System.out.println(r2);
//		
		ResponseResult r=this.user.getLoginInfo("0301be3746364031a09544f696b890a5");

		

	
		Gson g=new Gson();
		String str=g.toJson(r.getInfo());
		PxUser user=g.fromJson(str, PxUser.class);
		
		System.out.println(user);
		
		
//		ResponseResult r3=this.user.refLogin("0301be3746364031a09544f696b890a5");
//		System.out.println(r3);
		
		
		
	}
	
}
