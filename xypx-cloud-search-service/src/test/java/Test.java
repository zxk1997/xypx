import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zxk1997.px.common.models.PxActBase;
import com.zxk1997.px.common.models.PxActDetail;
import com.zxk1997.px.common.models.PxActReview;
import com.zxk1997.px.common.models.SearchParm;
import com.zxk1997.px.search.dao.PxActMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.zxk1997.px.search.SearchServiceApplication.class)
public class Test {
	
	@Autowired
	PxActMapper act;
	
	@org.junit.Test
	public void test() {
		SearchParm s=new SearchParm();
		
		
//		s.setId("0ea87427ff0e4d84a0d4e46894984db2");
//		int total = act.selectActJoinTotal(s);
//		List<PxActDetail> a=act.selectByConditions(s);
//	
//		s=new SearchParm();
//		s.setUid("008ec6c52d1745d7873675d87a36e49e");
//		List<PxActReview> b=act.selectActByUserJoin(s);
//	
//		s=new SearchParm();
//		s.setHost("29ec8258ce444f6ab75c135ee09488df");
//		List<PxActBase> c=act.selectByConditionsToBase(s);
//		
//		s.setType(0);
//		int i =act.selectRecTotal(s);
//		s.setType(1);
//		int i2=act.selectRecTotal(s);
		s.setType(1);
		List<PxActReview> d=act.selectByConditionsToReview(s);
		System.out.println("o");
	}
}
