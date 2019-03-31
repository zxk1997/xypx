import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxk1997.px.activity.service.ActService;
import com.zxk1997.px.common.models.PxUserPartake;

@SpringBootTest(classes=com.zxk1997.px.activity.ActivityServiceApplication.class)
@RunWith(SpringRunner.class)
public class ActivityTest {
	
	@Autowired
	ActService act;
	
	@Test
	public void test() {
		PxUserPartake p=new PxUserPartake();
		p.setAid("63b7f49573de45f78223ab6446d4cf58");
		p.setUid("testuid");
		System.out.println(act.joinAct(p));
		
	}
}
