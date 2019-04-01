import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxk1997.px.api.service.ISearchService;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.SearchParm;

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
	
	@Autowired
	IUserService user;
	
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
	

	@Autowired
	ISearchService search;
	
	@Test
	public void test3() {
		
		SearchParm s=new SearchParm();
		List<PxActDetail> list=search.findActDetail(s);
		
		s.setStart(0);
		s.setLength(10);
		List<PxActDetail> list2=search.findActDetail(s);
		
		s=new SearchParm();
		s.setType(1);
		List<PxActDetail> list3=search.findActDetail(s);
	
		System.out.println("");
	}
}
